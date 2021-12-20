/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.service;

import dev.model.entities.Comentarios;
import dev.model.repositories.ComentarioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author tiago
 */
@Service
public class ComentarioService {
    
    @Autowired
    private ComentarioRepository comentarioRepository;
    
    public List<Comentarios> getAllComentarioById(Integer id){
        return comentarioRepository.findByComentarioUser(id);
    }

}
