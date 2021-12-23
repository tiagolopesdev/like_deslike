/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.model.repositories;

import dev.model.entities.Comentarios;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author tiago
 */
@Repository
public interface ComentarioRepository extends JpaRepository<Comentarios, Integer>{
    
    @Query("select c from Comentarios c join c.topico t where t.id = :id")
    public List<Comentarios> findByComentarioUser(Integer id); 
}
