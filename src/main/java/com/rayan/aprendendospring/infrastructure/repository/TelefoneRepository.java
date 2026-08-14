package com.rayan.aprendendospring.infrastructure.repository;

import com.rayan.aprendendospring.infrastructure.entify.Telefone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TelefoneRepository extends JpaRepository<Telefone, Long> {
}
