/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abctreinamentos;

/**
 *
 * @author rafae
 */
public class Cliente {
    String cpf;
    String nome;
    String email;

    public Cliente(String cpf, String nome, String email) {
        super();
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
    }
    public String toString(){
        return  "Cliente [nome"+nome+"]";
    }
    
    
    
}
