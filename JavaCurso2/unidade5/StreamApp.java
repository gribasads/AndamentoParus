/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unidade5;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rafae
 */
public class StreamApp {

    static List<String> funcionarios;
    
    public static void filtrar(String letra)
    {
        funcionarios.stream().filter(s->s.startsWith(letra)).forEach(System.out::println);
    
    }
    public static void ordenar(String letra)
    {
    
        funcionarios.stream().sorted().filter(s->s.startsWith(letra)).forEach(System.out::println);
        
    }
    public static void contar(String letra)
    {
    long contador= funcionarios.stream().filter(s->s.startsWith(letra)).count();
        System.out.println(contador);
    
    }
            
    public static void main(String[] args) {
        funcionarios = new ArrayList<>();
        funcionarios.add("Gustavo");
        funcionarios.add("José");
        funcionarios.add("Pedro");
        funcionarios.add("Joao");
        funcionarios.add("Andreia");
        contar("J");
    }
    
}
