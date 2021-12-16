/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.model.repositories;

import dev.model.entities.Topico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 *
 * @author tiago
 */
@Repository
public interface TopicoRepository extends JpaRepository<Topico, Integer>{
    
//    @Query("select t from Topico t inner join Usuario u where u.id = :id")
//    public List<Topico> findByTopicoUser(Integer id);
    
    
}
