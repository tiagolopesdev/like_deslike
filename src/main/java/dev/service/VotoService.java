/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.service;

import dev.model.entities.SituacaoAtualTopico;
import dev.model.entities.Topico;
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
    
    Topico topico = new Topico();
    
    public Voto save(Voto v){
        return votoRepository.save(v);
    }
    
    public Integer calcSituacaoTopico(Integer idTopico){
        Integer calc;
        calc = votoRepository.getUpVoteByIdTopico(idTopico).size() - 
                votoRepository.getDownVoteByIdTopico(idTopico).size();
        System.out.println("Valor CAL => "+calc);
        return calc;
    }
    
}
