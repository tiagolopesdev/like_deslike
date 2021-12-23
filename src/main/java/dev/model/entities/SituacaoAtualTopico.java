/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.model.entities;

import lombok.Getter;

/**
 *
 * @author tiago
 */
@Getter
public enum SituacaoAtualTopico {
    
    POSITIVO("Positivo"), 
    NEGATIVO("Negativo");

    private String descricao;

    private SituacaoAtualTopico(String descricao) {
        this.descricao = descricao;
    }

}
