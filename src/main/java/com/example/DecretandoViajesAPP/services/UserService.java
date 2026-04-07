package com.example.DecretandoViajesAPP.services;

import com.example.DecretandoViajesAPP.models.User;
import com.example.DecretandoViajesAPP.repositories.IRepositorieSpace;
import com.example.DecretandoViajesAPP.repositories.IRepositorieUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@Service
public class UserService {

    //Inyectando una dependencia al repositorioUser
    @Autowired
    private IRepositorieSpace repositorieUser;

    public boolean saveUserInDB(User data){
        //condiciones logicas para validar datos a guardar

        if(repositorieUser.findByEmail(data.getEmail().isPresent()){
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "Ya existe un correo registrado igual al que me entregas "
            );
        }

        return false;
    }


    public boolean modifyUserInBD(User data, UUID id){

        //Condiciones logicas para validar datos a guardar

        //1. Validar que el correo a registrar no se haya guardado previamente

        return false;
    }

    public boolean deleteUserInBD(UUID id){

        //Buscar y validar si el ID que me envian existe
        //elimino el registro en BD
        return false;
    }

    public boolean searchUserInBD(){

        //Dependiendo del parametro de busqueda debo implementar validaciones
        //Devuelve los usuarios o usuario que se encuentre en BD

        return false;
    }

}
