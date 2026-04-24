package com.example.DecretandoViajesAPP.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.DecretandoViajesAPP.models.Space;

@Repository
public interface IRepositorieSpace extends JpaRepository<Space, UUID> {

    Optional<Space> findByNames(String names);

}
