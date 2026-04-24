package com.example.DecretandoViajesAPP.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.DecretandoViajesAPP.models.Reserve;
import com.example.DecretandoViajesAPP.repositories.IRepositorieReserve;

@Service
public class ReserveService {

    //Inyectando una dependencia al repositorioReserve
    @Autowired
    private IRepositorieReserve repositorieReserve;

    public Reserve saveReserveInDB(Reserve data){
        //condiciones logicas para validar datos a guardar

        //1. validar que la fecha no sea nula
        if(data.getDate() == null){
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "La fecha de la reserva no puede estar vacia "
            );
        }
    
        if (data.getTime() == null || data.getTime() < 1){
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "El tiempo de la reserva debe ser al menos 1 hora "
            );
        }

        //Sí paso la zona de validacion procedo a preparar
        //receta(Ejecuto la query que se necesite)
        return this.repositorieReserve.save(data);
    }

    public Reserve modifyReserveInBD(Reserve data, UUID id){

        //Condiciones logicas para validar datos a guardar

        //1. Buscar sí la reserva existe en BD
        Optional<Reserve>reserva_que_estoy_buscando=this.repositorieReserve.findById(id);
        if (reserva_que_estoy_buscando.isEmpty()){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "La reserva que quieres editar no existe en BD "
            );
        }
        Reserve reserva_que_encontre=reserva_que_estoy_buscando.get();

        //2. validar la información nueva que me manda el cliente
        if (data.getDate() == null){
            throw new ResponseStatusException(
              HttpStatus.BAD_REQUEST,
                    "Revisa la fecha ingresada "
            );
        }
        //3. Ejecutar el nuevo guardado y retornar

        reserva_que_encontre.setDate(data.getDate());
        reserva_que_encontre.setTime(data.getTime());
        return this.repositorieReserve.save(reserva_que_encontre);

    }

    public boolean deleteReserveInBD(UUID id){

        //Buscar y validar si el ID que me envian existe
        //elimino el registro en BD
        Optional<Reserve>reserva_que_estoy_buscando=this.repositorieReserve.findById(id);
        if (reserva_que_estoy_buscando.isEmpty()){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "La reserva que quieres eliminar no existe en BD "
            );
        }
        Reserve reserva_que_encontre=reserva_que_estoy_buscando.get();
        this.repositorieReserve.deleteById(id);
        return true;
    }

    public List<Reserve> searchReserveInBD(){

        //Dependiendo del parametro de busqueda debo implementar validaciones
        //Devuelve las reservas o reserva que se encuentre en BD

        List<Reserve>reservasEncontradas=this.repositorieReserve.findAll();

        return reservasEncontradas;
    }

}
