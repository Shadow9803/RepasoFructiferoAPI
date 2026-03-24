package com.example.DecretandoViajesAPP.repositories;

import com.example.DecretandoViajesAPP.models.Reserve;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IRepositorieReserve extends JpaRepository<Reserve, UUID> {
}
