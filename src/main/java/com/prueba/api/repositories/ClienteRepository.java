package com.prueba.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.prueba.api.entities.Cliente;


@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    public boolean existsByEmail(String email);
    
    @Query("SELECT c.email FROM Cliente c")
    List<String> findAllEmails();
}
