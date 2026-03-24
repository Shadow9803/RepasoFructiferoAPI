package com.example.DecretandoViajesAPP.services;

import com.example.DecretandoViajesAPP.models.User;
import com.example.DecretandoViajesAPP.repositories.IRepositorieSpace;
import com.example.DecretandoViajesAPP.repositories.IRepositorieUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {

    //Inyectando una dependencia al repositorioUser
    @Autowired
    private IRepositorieSpace repositorieSpace;

    public boolean saveSpacesInDB(User data){}


    public boolean modifySpacesInBD(User data, UUID id){

        //validar q datos me envian y si estas cumplen las reglas del negocio
        //modificar los datos en BD
        return false;
    }

    public boolean deleteSpacesInBD(UUID id){

        //Buscar y validar si el ID que me envian existe
        //elimino el registro en BD
        return false;
    }

    public boolean searchSpacesInBD(){

        //Dependiendo del parametro de busqueda debo implementar validaciones
        //Devuelve los usuarios o usuario que se encuentre en BD

        return false;
    }

}
