package com.example.DecretandoViajesAPP.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.DecretandoViajesAPP.models.User;
import com.example.DecretandoViajesAPP.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/DecretandoViajes/v1/users")
public class UserController {

    //Por cada serivicio ofrecido
    //configuro 1 funcion controladora

    @Autowired
    UserService service;

    //funcion para controlar el guardado
    @PostMapping
    public ResponseEntity<User>controlSaving(@RequestBody User data){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(this.service.saveUserInDB(data));
    }
    //funcion para controlar las modificaciones
    @PutMapping("/{id}")
    public ResponseEntity<User>controlModify(@RequestBody User data, @PathVariable UUID id){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.service.modifyUserInBD(data, id));
    }

    //funcion para controlar el borrado
    @DeleteMapping("/{id}")
    public ResponseEntity<?>controlDelate(@PathVariable UUID id){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.service.deleteUserInBD(id));
    }


    //funcion para controlar el listar
    @GetMapping
    public ResponseEntity<?>controlList(){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.service.searchUserInBD());
    }

}