/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.service;

import dev.model.entities.Topico;
import dev.model.repositories.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author tiago
 */
@Service
public class TopicoService {

    @Autowired
    private TopicoRepository topicoRepository;

    public Topico saveTopico(Topico t) {
        return topicoRepository.save(t);
    }

}
