/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.restinga.dev1.tainara.Livro.entidade;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Suporte
 */
@Entity
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String titulo;
    private String autorPrimeiroNome;
    private String autorSegundoNome;
    private String anoPublicacao;
    private String editor;
    private boolean doacao;
    
    


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutorPrimeiroNome() {
        return autorPrimeiroNome;
    }

    public void setAutorPrimeiroNome(String autorPrimeiroNome) {
        this.autorPrimeiroNome = autorPrimeiroNome;
    }

    public String getAutorSegundoNome() {
        return autorSegundoNome;
    }

    public void setAutorSegundoNome(String autorSegundoNome) {
        this.autorSegundoNome = autorSegundoNome;
    }

    public String getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(String anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public boolean isDoacao() {
        return doacao;
    }

    public void setDoacao(boolean doacao) {
        this.doacao = doacao;
    }
    
    

}
