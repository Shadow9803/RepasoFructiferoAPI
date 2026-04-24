package com.example.DecretandoViajesAPP.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.DecretandoViajesAPP.models.Reserve;

@Repository
public interface IRepositorieReserve extends JpaRepository<Reserve, UUID> {

}
