package com.rayan.aprendendospring.infrastructure.repository;

import com.rayan.aprendendospring.infrastructure.entify.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
}
