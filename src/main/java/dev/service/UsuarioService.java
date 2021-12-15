/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.service;

import dev.model.entities.Usuario;
import dev.model.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author tiago
 */
@Service
public class UsuarioService {
    
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    public Usuario save(Usuario u){
        return usuarioRepository.save(u);
    }
    
    public Usuario getUserById(int id){
        return usuarioRepository.findById(id).get();
    }
    
    public Iterable<Usuario> getAllUsers(){
        return usuarioRepository.findAll();
    }
}
