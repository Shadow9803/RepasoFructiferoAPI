package com.example.DecretandoViajesAPP.services;

import com.example.DecretandoViajesAPP.models.Space;
import com.example.DecretandoViajesAPP.repositories.IRepositorieSpace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class SpaceService {
    //Inyectando una dependencia al repositorioUser
    @Autowired
    private IRepositorieSpace repositorieSpace;

    public boolean saveSpacesInDB(Space data){}
    public boolean modifySpacesInBD(Space data, UUID id){}

    public boolean deleteSpacesInBD(UUID id){}

    public boolean searchSpacesInBD(){}
}
