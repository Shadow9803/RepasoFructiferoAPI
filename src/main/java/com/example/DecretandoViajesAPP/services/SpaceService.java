package com.example.DecretandoViajesAPP.services;

import com.example.DecretandoViajesAPP.models.Space;
import com.example.DecretandoViajesAPP.repositories.IRepositorieSpace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@Service
public class SpaceService {
    //Inyectando una dependencia al repositorioUser
    @Autowired
    private IRepositorieSpace repositorieSpace;

    public boolean saveSpacesInDB(Space data){
        if(repositorieSpace.findById(data.getId()).isPresent()){
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "Ya existe un ID registrado igual al que me entregas "
            );
        }

        return false;

        if (data.getNames().isEmpty()||data.getNames().isBlank()){
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "El nombre dogitado no puede enviarse vacio "
            );
        }

        if(data.getFoto().isBlank()){
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "Ya existe un ID registrado igual al que me entregas "
            );
        }
    }
    public boolean modifySpacesInBD(Space data, UUID id){}

    public boolean deleteSpacesInBD(UUID id){}

    public boolean searchSpacesInBD(){}
}
