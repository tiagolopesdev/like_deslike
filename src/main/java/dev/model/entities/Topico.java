/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.model.entities;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String assunto;
    private String mensagem;
    
    @Enumerated(EnumType.STRING)
    private SituacaoAtualTopico situacaoAtualTopico;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @OneToMany(mappedBy = "topico")
    private List<Voto> voto = new ArrayList<Voto>();

    @OneToMany(mappedBy = "topico")
    private List<Comentarios> cs = new ArrayList<Comentarios>();

    public Topico() {
    }

    public Topico(String assunto, String mensagem) {
        this.assunto = assunto;
        this.mensagem = mensagem;
    }

}