/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.service;

import dev.model.entities.Voto;
import dev.model.repositories.VotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author tiago
 */
@Service
public class VotoService {
    
    @Autowired
    private VotoRepository votoRepository;
    
    public Voto save(Voto v){
        return votoRepository.save(v);
    }
}
