/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unidade5;

@FunctionalInterface // interface funcional só pode ter 1 metodo abstrato
public interface Formula {
    double calcular (int a); //apenas 1 metodo abstrato
    //para ter mais metodos tem que tirar o functionalInterface
    
    default double sqrt(int a){
    return Math.sqrt(a);
    }
    default double sqrt(int a,int b){
    return Math.pow(a,1/b);
    }
    //Não foi gerado erro no codigo
}
