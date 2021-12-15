/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.controllers;

import dev.model.entities.Topico;
import dev.model.entities.Usuario;
import dev.model.repositories.TopicoRepository;
import dev.service.TopicoService;
import dev.service.UsuarioService;
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
    private TopicoRepository topicoRepository;
    
    Usuario user = new Usuario();
    
    Topico topico = new Topico();

    Integer idUser;
    String nome;
    
    @RequestMapping(value="/formTopico/{id}", method = RequestMethod.GET)
    public String getForm(@PathVariable("id") Integer id){
        user = usuarioService.getUserById(id);
        idUser = id;
        //System.out.println("Id do usuario"+idUser);
        return "addAndGetTopico";
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public String save(Topico t){
        //user = usuarioService.getUserById(idUser);
        //System.out.println("Id do user => "+user.getId());
        topico.setUsuario(user);
        topicoService.saveTopico(t);
        return "addAndGetTopico";
    }
    
    @GetMapping
    public ModelAndView searchTopicos(){
        List<Topico> allTopicos = topicoService.findAllTopicos();
        ModelAndView modelAndView = new ModelAndView("getAllTopicos");
        modelAndView.addObject("topicos", allTopicos);
        return modelAndView; 
    }
    
    
}
