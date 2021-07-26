/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.restinga.dev1.tainara.Livro.controller;

import br.edu.ifrs.restinga.dev1.tainara.Livro.dao.LivroDAO;
import br.edu.ifrs.restinga.dev1.tainara.Livro.entidade.Livro;
import br.edu.ifrs.restinga.dev1.tainara.Livro.erro.NaoEncontrado;
import br.edu.ifrs.restinga.dev1.tainara.Livro.erro.RequisicaoInvalida;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Suporte
 */
@RestController
@RequestMapping("/api")
public class Livros {
    @Autowired
    LivroDAO livroDAO;
    
    @RequestMapping(path = "/livros/", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Livro cadastrar(@RequestBody Livro livro) {
        livro.setId(0);
        
  
     
        if(livro.getTitulo() == "" || livro.getTitulo() == null || livro.getTitulo().isEmpty()){
            throw new RequisicaoInvalida("Titulo deve ser preenchido");
        }if(livro.getAutorPrimeiroNome() == "" || livro.getAutorPrimeiroNome() == null || livro.getAutorPrimeiroNome().isEmpty()){
            throw new RequisicaoInvalida("Primeiro nome do autor deve ser preenchido");
        }if(livro.getEditor() == "" || livro.getEditor() == null || livro.getEditor().isEmpty()){
            throw new RequisicaoInvalida("Editor deve ser preenchido");
        }else{
            return livroDAO.save(livro);
        }
        
    }
    
    @RequestMapping(path = "/livros/", method = RequestMethod.GET)
    public Iterable<Livro> listar(){
        return livroDAO.findAll();
    }
    
    @RequestMapping(path = "/livros/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Livro Buscar(@PathVariable int id){
        final Optional<Livro> findById = livroDAO.findById(id);
        if(findById.isPresent()){
            return findById.get();
        }else{
            throw new NaoEncontrado("ID não encontrada!");
        }
    }
    
    @RequestMapping(path = "/livros/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void Apagar(@PathVariable int id){
        if(livroDAO.existsById(id)){
            livroDAO.deleteById(id);
        }else{
            throw new NaoEncontrado("ID não encontrada!");
        }
    }
    
    @RequestMapping(path = "/livros/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void Atualizar(@PathVariable int id, @RequestBody Livro livro){
       
        if(livro.getTitulo() == "" || livro.getTitulo() == null || livro.getTitulo().isEmpty()){
            throw new RequisicaoInvalida("Titulo deve ser preenchido");
        }if(livro.getAutorPrimeiroNome() == "" || livro.getAutorPrimeiroNome() == null || livro.getAutorPrimeiroNome().isEmpty()){
            throw new RequisicaoInvalida("Primeiro nome do autor deve ser preenchido");
        }if(livro.getEditor() == "" || livro.getEditor() == null || livro.getEditor().isEmpty()){
            throw new RequisicaoInvalida("Editor deve ser preenchido");
        }else{
            final Livro livroBanco = this.Buscar(id);
            livroBanco.setTitulo(livro.getTitulo());
            livroBanco.setAutorPrimeiroNome(livro.getAutorPrimeiroNome());
            livroBanco.setEditor(livro.getEditor());

            livroDAO.save(livroBanco);
        } 
    }
    
}
