/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.controllers;

import dev.model.entities.Topico;
import dev.model.entities.Usuario;
import dev.service.TopicoService;
import dev.service.UsuarioService;
import dev.service.VotoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author tiago
 */
@Controller
@RequestMapping("/topico")
public class TopicoController {

    @Autowired
    private TopicoService topicoService;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private VotoService votoService;

    Usuario usuario = new Usuario();
    Integer idUser;

    @GetMapping("/insert/{id}")
    public ModelAndView formForSave(@PathVariable("id") Integer id) {
        idUser = id;
        usuario = usuarioService.getUserById(idUser);
        ModelAndView andView = new ModelAndView("addTopico");
        andView.addObject("mensagemNameUser", usuario.getNome()+", insira um topico!");
        return andView;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView save(Topico t) {
        usuario = usuarioService.getUserById(idUser);
        t.setUsuario(usuario);
        topicoService.saveTopico(t);
        ModelAndView andView = new ModelAndView("addTopico");
        andView.addObject("mensagemSucess", "Tópico inserido. Confira em 'meus topicos'.");
        return andView;
    }

    @GetMapping()
    public ModelAndView searchTopicoById() {
        List<Topico> allByIdTopico = (List<Topico>) topicoService.getAllTopicoById(idUser);
        //votoService.calcSituacaoTopico(idUser);
        ModelAndView andView = new ModelAndView("myTopicos");
        andView.addObject("topicosUser", allByIdTopico);
        return andView;
    }

    @GetMapping("/allTopicos")
    public ModelAndView searchAllTopicos() {
        List<Topico> allTopicos = (List<Topico>) topicoService.getAllTopico();
        ModelAndView andView = new ModelAndView("allTopicos");
        andView.addObject("topicosUsers", allTopicos);
        return andView;
    }
}
