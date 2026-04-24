package com.example.DecretandoViajesAPP.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.DecretandoViajesAPP.models.Reserve;
import com.example.DecretandoViajesAPP.services.ReserveService;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/DecretandoViajes/v1/reserves")
public class ReserveController {

    //Por cada serivicio ofrecido
    //configuro 1 funcion controladora

    @Autowired
    ReserveService service;

    //funcion para controlar el guardado
    @PostMapping
    public ResponseEntity<Reserve>controlSaving(@RequestBody Reserve data){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(this.service.saveReserveInDB(data));
    }
    //funcion para controlar las modificaciones
    @PutMapping("/{id}")
    public ResponseEntity<Reserve>controlModify(@RequestBody Reserve data, @PathVariable UUID id){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.service.modifyReserveInBD(data, id));
    }

    //funcion para controlar el borrado
    @DeleteMapping("/{id}")
    public ResponseEntity<?>controlDelate(@PathVariable UUID id){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.service.deleteReserveInBD(id));
    }


    //funcion para controlar el listar
    @GetMapping
    public ResponseEntity<?>controlList(){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.service.searchReserveInBD());
    }

}