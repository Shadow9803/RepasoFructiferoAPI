package com.example.DecretandoViajesAPP.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.DecretandoViajesAPP.models.Space;
import com.example.DecretandoViajesAPP.services.SpaceService;

@RestController
@RequestMapping("/DecretandoViajes/v1/spaces")
public class SpaceController {

    //Por cada serivicio ofrecido
    //configuro 1 funcion controladora

    @Autowired
    SpaceService service;

    //funcion para controlar el guardado
    @PostMapping
    public ResponseEntity<Space>controlSaving(@RequestBody Space data){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(this.service.saveSpaceInDB(data));
    }
    //funcion para controlar las modificaciones
    @PutMapping("/{id}")
    public ResponseEntity<Space>controlModify(@RequestBody Space data, @PathVariable UUID id){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.service.modifySpaceInBD(data, id));
    }

    //funcion para controlar el borrado
    @DeleteMapping("/{id}")
    public ResponseEntity<?>controlDelate(@PathVariable UUID id){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.service.deleteSpaceInBD(id));
    }


    //funcion para controlar el listar
    @GetMapping
    public ResponseEntity<?>controlList(){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.service.searchSpaceInBD());
    }

}