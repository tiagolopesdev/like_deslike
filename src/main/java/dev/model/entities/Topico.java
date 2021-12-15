/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.model.entities;

import javax.persistence.CascadeType;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
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
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String assunto;

    private String mensagem;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    private SituacaoAtualTopico sat;

    public Topico() {
    }

    public Topico(String assunto, String mensagem) {
        this.setAssunto(assunto);
        this.setMensagem(mensagem);
    }

//    public void situacaoAtual() {
//        if (usuario.getVotos().calcularVotos() < 0) {
//            setSat(SituacaoAtualTopico.NEGATIVO);
//        } else {
//            setSat(SituacaoAtualTopico.POSITIVO);
//        }
//    }
    
}
