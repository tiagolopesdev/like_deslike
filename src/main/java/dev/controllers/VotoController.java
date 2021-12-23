/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.controllers;

import dev.model.entities.SituacaoAtualTopico;
import dev.model.entities.Topico;
import dev.model.entities.Usuario;
import dev.model.entities.Voto;
import dev.model.repositories.VotoRepository;
import dev.service.TopicoService;
import dev.service.UsuarioService;
import dev.service.VotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author tiago
 */
@Controller
@RequestMapping("/voto")
public class VotoController {

    @Autowired
    private VotoRepository votoRepository;

    @Autowired
    private VotoService votoService;

    @Autowired
    private TopicoController topicoController;

    @Autowired
    private TopicoService topicoService;

    @Autowired
    private UsuarioService usuarioService;

    Usuario u = new Usuario();
    Topico t = new Topico();

    @RequestMapping(value = "/curtir/{id}", method = RequestMethod.GET)
    public String computaUpVoto(@PathVariable("id") Integer id) {
        u = usuarioService.getUserById(topicoController.idUser);
        t = topicoService.getTopicoById(id);
        return "selectUpvote";
    }

    @RequestMapping(value = "/descurtir/{id}", method = RequestMethod.GET)
    public String computaDownVoto(@PathVariable("id") Integer id) {
        u = usuarioService.getUserById(topicoController.idUser);
        t = topicoService.getTopicoById(id);
        return "selectDownvote";
    }

    @PostMapping("/upvote")
    public String saveUpVoteController(Voto v) {
        v.setUpVote(1);
        v.setUsuario(u);
        v.setTopico(t);
        votoRepository.save(v);
        if (votoService.calcSituacaoTopico(t.getId()) > 0) {
            t.setSituacaoAtualTopico(SituacaoAtualTopico.POSITIVO);
            topicoService.saveTopico(t);
        } 
        return "redirect:/topico/allTopicos";
    }

    @PostMapping("/downvote")
    public String saveDownVoteController(Voto v) {
        v.setDownVote(1);
        v.setUsuario(u);
        v.setTopico(t);
        votoRepository.save(v);
        if (votoService.calcSituacaoTopico(t.getId()) < 0) {
            t.setSituacaoAtualTopico(SituacaoAtualTopico.NEGATIVO);
            topicoService.saveTopico(t);
        }
        return "redirect:/topico/allTopicos";
    }

}
