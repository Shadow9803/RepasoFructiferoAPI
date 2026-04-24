package com.example.DecretandoViajesAPP.services;

import com.example.DecretandoViajesAPP.models.User;
import com.example.DecretandoViajesAPP.repositories.IRepositorieSpace;
import com.example.DecretandoViajesAPP.repositories.IRepositorieUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    //Inyectando una dependencia al repositorioUser
    @Autowired
    private IRepositorieUser repositorieUser;

    public User saveUserInDB(User data){
        //condiciones logicas para validar datos a guardar

        //1. validar que el correo a registrar no se haya guardado previamente

        if(repositorieUser.findByEmail(data.getEmail()).isPresent()){
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "Ya existe un correo registrado igual al que me entregas "
            );
        }
    
        if (data.getNames().isEmpty()||data.getNames().isBlank()){
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "El nombre dogitado no puede enviarse vacio "
            );
        }

        if (data.getPassword().length()<6){
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "La contraseña debe tener al menos 6 caracteres "
            );
        }

        //Sí paso la zona de validacion procedo a preparar
        //receta(Ejecuto la query que se necesite)
        return this.repositorieUser.save(data);
    }


    public User
    modifyUserInBD(User data, UUID id){

        //Condiciones logicas para validar datos a guardar

        //1. Validar que el correo a registrar no se haya guardado previamente

        //1. Buscar sí el usuario existe en BD
        Optional<User>usuario_que_estoy_buscando=this.repositorieUser.findById(id);
        if (usuario_que_estoy_buscando.isEmpty()){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "El usuario que quieres editar no existe en BD "
            );
        }
        User usuario_que_encontre=usuario_que_estoy_buscando.get();

        //2. validar la información nueva que me manda el cliente
        if (data.getNames().isEmpty() || data.getNames().isBlank()){
            throw new ResponseStatusException(
              HttpStatus.BAD_REQUEST,
                    "Revisa el nombre ingresado "
            );
        }
        //3. Ejecutar el nuevo guardado y retornar

        usuario_que_encontre.setNames(data.getNames());
        return this.repositorieUser.save(usuario_que_encontre);

    }

    public boolean deleteUserInBD(UUID id){

        //Buscar y validar si el ID que me envian existe
        //elimino el registro en BD
        Optional<User>usuario_que_estoy_buscando=this.repositorieUser.findById(id);
        if (usuario_que_estoy_buscando.isEmpty()){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "El usuario que quieres eliminar no existe en BD "
            );
        }
        User usuario_que_encontre=usuario_que_estoy_buscando.get();
        this.repositorieUser.deleteById(id);
        return true;
    }

    public List<User> searchUserInBD(){

        //Dependiendo del parametro de busqueda debo implementar validaciones
        //Devuelve los usuarios o usuario que se encuentre en BD

        List<User>usuariosEncontrados=this.repositorieUser.findAll();

        return usuariosEncontrados;
    }

}
