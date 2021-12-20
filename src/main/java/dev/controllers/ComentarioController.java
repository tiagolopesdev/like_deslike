/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.controllers;

import dev.model.entities.Comentarios;
import dev.service.ComentarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author tiago
 */
@Controller
@RequestMapping("/comentario")
public class ComentarioController {
    
    @Autowired
    private ComentarioService comentarioService;
    
    @GetMapping("/getComentariosByTopico/{id}")
    public ModelAndView getAllComentarioTopico(@PathVariable("id") Integer id){
        List<Comentarios> allComentarios = comentarioService.getAllComentarioById(id);
        ModelAndView andView = new ModelAndView("myComentariosByTopico");
        andView.addObject("comentarios", allComentarios);
        return andView;
    }
}
