package com.example.DecretandoViajesAPP.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.DecretandoViajesAPP.models.Space;
import com.example.DecretandoViajesAPP.repositories.IRepositorieSpace;

@Service
public class SpaceService {

    //Inyectando una dependencia al repositorioSpace
    @Autowired
    private IRepositorieSpace repositorieSpace;

    public Space saveSpaceInDB(Space data){
        //condiciones logicas para validar datos a guardar

        //1. validar que el nombre del espacio no se haya guardado previamente
        if(repositorieSpace.findByNames(data.getNames()).isPresent()){
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "Ya existe un espacio registrado con ese nombre "
            );
        }
    
        if (data.getNames().isEmpty()||data.getNames().isBlank()){
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "El nombre del espacio no puede enviarse vacio "
            );
        }

        if (data.getAforo() == null || data.getAforo() < 1){
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "El aforo debe ser al menos 1 "
            );
        }

        //Sí paso la zona de validacion procedo a preparar
        //receta(Ejecuto la query que se necesite)
        return this.repositorieSpace.save(data);
    }

    public Space modifySpaceInBD(Space data, UUID id){

        //Condiciones logicas para validar datos a guardar

        //1. Buscar sí el espacio existe en BD
        Optional<Space>espacio_que_estoy_buscando=this.repositorieSpace.findById(id);
        if (espacio_que_estoy_buscando.isEmpty()){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "El espacio que quieres editar no existe en BD "
            );
        }
        Space espacio_que_encontre=espacio_que_estoy_buscando.get();

        //2. validar la información nueva que me manda el cliente
        if (data.getNames().isEmpty() || data.getNames().isBlank()){
            throw new ResponseStatusException(
              HttpStatus.BAD_REQUEST,
                    "Revisa el nombre ingresado "
            );
        }
        //3. Ejecutar el nuevo guardado y retornar

        espacio_que_encontre.setNames(data.getNames());
        espacio_que_encontre.setDescripcion(data.getDescripcion());
        espacio_que_encontre.setFoto(data.getFoto());
        espacio_que_encontre.setAforo(data.getAforo());
        return this.repositorieSpace.save(espacio_que_encontre);

    }

    public boolean deleteSpaceInBD(UUID id){

        //Buscar y validar si el ID que me envian existe
        //elimino el registro en BD
        Optional<Space>espacio_que_estoy_buscando=this.repositorieSpace.findById(id);
        if (espacio_que_estoy_buscando.isEmpty()){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "El espacio que quieres eliminar no existe en BD "
            );
        }
        Space espacio_que_encontre=espacio_que_estoy_buscando.get();
        this.repositorieSpace.deleteById(id);
        return true;
    }

    public List<Space> searchSpaceInBD(){

        //Dependiendo del parametro de busqueda debo implementar validaciones
        //Devuelve los espacios o espacio que se encuentre en BD

        List<Space>espaciosEncontrados=this.repositorieSpace.findAll();

        return espaciosEncontrados;
    }

}
