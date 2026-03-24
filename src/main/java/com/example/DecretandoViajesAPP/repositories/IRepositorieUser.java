package com.example.DecretandoViajesAPP.repositories;

import com.example.DecretandoViajesAPP.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IRepositorieUser extends JpaRepository<User, UUID> {
}
