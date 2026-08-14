package com.rayan.aprendendospring.infrastructure.repository;

import com.rayan.aprendendospring.infrastructure.entify.UsuarioLombok;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository  extends JpaRepository<UsuarioLombok,Long> {

    boolean existsByEmail(String email);
    Optional<UsuarioLombok> findByEmail(String email);

    @Transactional
    void deleteByEmail(String email);

}
