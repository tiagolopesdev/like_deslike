/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.controllers;

import dev.model.entities.Usuario;
import dev.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
/**
 *
 * @author tiago
 */
@Controller
@RequestMapping("/usuario")
public class UsuarioController {
     
    @Autowired
    private UsuarioService usuarioService;
    
    @RequestMapping(value="/formUser", method = RequestMethod.GET)
    public String formForsave(){
        return "addUser";
    }
  
    @RequestMapping(method=RequestMethod.POST)
    public String save(Usuario u){
        usuarioService.saveUser(u);
        return "redirect:/topico/insert/"+u.getId();
    }
}
