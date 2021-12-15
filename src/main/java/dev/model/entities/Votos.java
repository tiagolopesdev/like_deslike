/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.model.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author tiago
 */
@Entity
@Getter
@Setter
public class Votos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Integer upVote;
    private Integer downVote;
    
    @ManyToOne
    private Usuario usuario;

    public Votos() {
    }

    public Votos(Integer upVote, Integer downVote) {
        this.upVote = upVote;
        this.downVote = downVote;
    }
    
    public int calcularVotos(){
        Integer statusTopico = getUpVote() - getDownVote();
        return statusTopico;
    }
}
