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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
    
    Usuario usuario = new Usuario();
    Integer idUser;

    @RequestMapping(value = "/formTopico/{id}", method = RequestMethod.GET)
    public String formForSave(@PathVariable("id") Integer id) {
        idUser = id;
        return "addTopico";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String save(Topico t) {
        usuario = usuarioService.getUserById(idUser);
        t.setUsuario(usuario);
        topicoService.saveTopico(t);
        return "addTopico";
    }

}
