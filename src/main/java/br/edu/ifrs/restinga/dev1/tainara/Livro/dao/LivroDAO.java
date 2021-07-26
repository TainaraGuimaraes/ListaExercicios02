/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.restinga.dev1.tainara.Livro.dao;

import br.edu.ifrs.restinga.dev1.tainara.Livro.entidade.Livro;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Suporte
 */
@Repository
public interface LivroDAO extends CrudRepository<Livro, Integer>{
    List <Livro> findByTituloContaining(String titulo);
}
