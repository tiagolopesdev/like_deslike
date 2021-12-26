/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.model.entities;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author tiago
 */
@Entity
@Getter
@Setter
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nome;
    
    @OneToMany(mappedBy = "usuario")
    private List<Topico> topico = new ArrayList<Topico>();
    
    @OneToMany(mappedBy = "usuario")
    private List<Voto> votos = new ArrayList<Voto>();
    
    @OneToMany(mappedBy = "usuario")
    private List<Comentarios> cs = new ArrayList<Comentarios>();

    public Usuario() {
    }

    public Usuario(String nome) {
        this.nome = nome;
    }

}
