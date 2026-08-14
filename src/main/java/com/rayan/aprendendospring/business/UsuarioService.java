package com.rayan.aprendendospring.business;


import com.rayan.aprendendospring.infrastructure.entify.UsuarioLombok;
import com.rayan.aprendendospring.infrastructure.exceptions.ConflictException;
import com.rayan.aprendendospring.infrastructure.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.lang.module.ResolutionException;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public UsuarioLombok salvarUsuario(UsuarioLombok usuario) {
        try {
            emailExiste(usuario.getEmail());
            usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
            return usuarioRepository.save(usuario);
        } catch (ConflictException e) {
            throw new ConflictException("Email já cadastrado" + e.getCause());
        }
    }

    public void emailExiste(String email){
        try{
            boolean existe = verificaEmailExistente(email);
            if(existe){
                throw new ConflictException("Email já cadastrado! " + email);
            }
        }catch (ConflictException e){
            throw new ConflictException("Email já cadastrado!!" + e.getCause());
        }
    }

    public boolean verificaEmailExistente(String email){
        return usuarioRepository.existsByEmail(email);
    }

    public UsuarioLombok buscarUsuarioEmail(String email){
        return usuarioRepository.findByEmail(email).orElseThrow(() -> new ResolutionException("Email não encontrado!!" + email));
    }

    public void deletaUsuarioPorEmail(String email){
        usuarioRepository.deleteByEmail(email);
    }


}
