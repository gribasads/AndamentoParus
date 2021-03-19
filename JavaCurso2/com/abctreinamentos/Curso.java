/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abctreinamentos;

import java.nio.file.Path;

/**
 *
 * @author rafae
 */
public class Curso {
    String nome;
    int cdcurso;
    float valor;
    Path url;

    public Curso(String nome, int cdcurso, float valor, Path url) {
        this.nome = nome;
        this.cdcurso = cdcurso;
        this.valor = valor;
        this.url = url;
    }

    @Override
    public String toString() {
        return "Curso{" + "nome=" + nome + '}';
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCdcurso() {
        return cdcurso;
    }

    public void setCdcurso(int cdcurso) {
        this.cdcurso = cdcurso;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public Path getUrl() {
        return url;
    }

    public void setUrl(Path url) {
        this.url = url;
    }
    

    
}
