/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.model.repositories;

import dev.model.entities.Voto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author tiago
 */
@Repository
public interface VotoRepository extends JpaRepository<Voto, Integer>{
    
    //Todos os topicos referentes ao idTopico passado com Curtidas.
    @Query("select v from Voto v join v.topico t where v.upVote > 0 and t.id = :idTopico")
    public List<Voto> getUpVoteByIdTopico(Integer idTopico);
    
    @Query("select v from Voto v join v.topico t where v.downVote > 0 and t.id = :idTopico")
    public List<Voto> getDownVoteByIdTopico(Integer idTopico);
    
}
