/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.controllers;

import dev.model.entities.Comentarios;
import dev.model.entities.Topico;
import dev.model.entities.Usuario;
import dev.service.ComentarioService;
import dev.service.TopicoService;
import dev.service.UsuarioService;
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

    @Autowired
    private TopicoController topicoController;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private TopicoService topicoService;

    Usuario user = new Usuario();
    Topico t = new Topico();

    @GetMapping("/getComentariosByTopico/{id}")
    public ModelAndView getAllComentarioTopico(@PathVariable("id") Integer id) {
        List<Comentarios> allComentarios = comentarioService.getAllComentarioById(id);
        ModelAndView andView = new ModelAndView("myComentariosByTopico");
        andView.addObject("comentarios", allComentarios);
        return andView;
    }
    
    @GetMapping("/insert/{id}")
    public String getInsertComment(@PathVariable("id") Integer idTopico){
        t = topicoService.getTopicoById(idTopico);
        user = usuarioService.getUserById(topicoController.idUser);
        return "insertComment";
    }

    @RequestMapping("/save")
    public String saveComentario(Comentarios comentario) {
        comentario.setUsuario(user);
        comentario.setTopico(t);
        comentarioService.saveComentarioService(comentario);
        return "redirect:/topico/allTopicos";
    }
}
