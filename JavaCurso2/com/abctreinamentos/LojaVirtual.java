/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abctreinamentos;

import com.abctreinamentos.Curso;
import com.abctreinamentos.Cliente;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.function.Consumer;

/**
 *
 * @author rafae
 */
public class LojaVirtual {
    
    static Map<Cliente,List<Curso>> pagamentos=new HashMap<>();
    public static void listarCursos(List<Curso> lista){
       // lista.forEach(p->System.out.println(p.getCdcurso()+"<=>"+p.getNome()));
       lista.forEach(System.out::print);
       
    }
    public static void main(String[] args) {
        //criar os cursos disponiveis no site para venda
        Curso java8 = new Curso("java 8 para web",1,2000,Paths.get("/java8"));
        Curso oracle12c = new Curso("Oracle 12C",2,2500,Paths.get("/oracle12c"));
        Curso php7 = new Curso("php 7",3,1500,Paths.get("/php7"));
        
        
        //cadastrar o cliente
        Cliente gustavo= new Cliente("867.1186.220-87","Gustavo Bastos Ribas","gustavoribas.ads@gmail.com");
        
        
        //criar a lista de cursos do cliente
        List<Curso> cursosGustavo = new LinkedList<>();
        //fazer um checkout dos cursos escolhidos
        Scanner entrada=new Scanner(System.in);
        int opcao =0;
        while(opcao!=4){
            System.out.println("qual curso deseja adquirir? [1-java8],[2-Oracle],[3-php7],[4-finalizar]");
            opcao = entrada.nextInt();
            if(opcao==1)
                cursosGustavo.add(java8);
            if(opcao==2)
                cursosGustavo.add(oracle12c);
            if(opcao==3)
                cursosGustavo.add(php7);
            else 
                opcao=4;
                
        }
        entrada.close();
        pagamentos.put(gustavo,cursosGustavo);
        System.out.println(pagamentos);
        //listarCursos(cursosGustavo);
        //Referencia de metodos
        Consumer<List<Curso>> consumer = LojaVirtual::listarCursos;
        consumer.accept(cursosGustavo);
    }
    
    
    
    
}
