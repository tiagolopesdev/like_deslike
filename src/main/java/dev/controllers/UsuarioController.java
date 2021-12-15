/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.controllers;

import dev.model.entities.Usuario;
import dev.service.UsuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author tiago
 */
@Controller
@RequestMapping("/usuario")
public class UsuarioController {
    
    @Autowired
    private UsuarioService usuarioService;
    
    @Autowired
    private TopicoController topicoController;
    
    Usuario u = new Usuario();
    
    @RequestMapping(value="/formUser")
    public String getForm(){
        return "addUser";
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public String saveUser(Usuario u){
        usuarioService.save(u);
        topicoController.idUser = u.getId();
        System.out.println(topicoController.idUser);
        return "redirect:/topico";
    }
    
    @GetMapping
    public ModelAndView getAllUsers(){
        List<Usuario> allUsers = (List<Usuario>) usuarioService.getAllUsers();
        ModelAndView andView = new ModelAndView("getAllUsers");
        andView.addObject("users", allUsers);
        return andView;
    }
  
}
