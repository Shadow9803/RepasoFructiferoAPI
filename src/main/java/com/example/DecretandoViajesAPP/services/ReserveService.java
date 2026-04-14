package com.example.DecretandoViajesAPP.services;

import com.example.DecretandoViajesAPP.models.Reserve;
import com.example.DecretandoViajesAPP.repositories.IRepositorieReserve;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@Service
public class ReserveService {
    //Inyectando una dependencia al repositorioUser
    @Autowired
    private IRepositorieReserve repositorieReserve;

    public boolean saveReservesInDB(Reserve data){

    }
    public boolean modifyReservesInBD(Reserve data, UUID id){
    }

    public boolean deleteReservesInBD(UUID id){}

    public boolean searchReservesInBD(){}
}
