/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unidade5;

/**
 *
 * @author rafae
 */
public class CalculadoraV2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CalculadoraV2 objeto= new CalculadoraV2();
        
        IMath somar= (a,b)->a+b;
        IMath subtrair=(a,b)->a-b;
        IMath multiplicar=(a,b)->a*b;
        IMath divisao=(a,b)->a/b;
        IMath exponenciacao=(a,b)->Math.pow(a,b);
        IMath radiciacao=(a,b)->Math.pow(a,1/b);
        //chamada das expressões lambdas
        System.out.println(objeto.execOpercacao(5,3,somar));
        System.out.println(objeto.execOpercacao(5,3,subtrair));
        System.out.println(objeto.execOpercacao(5,3,multiplicar));
        System.out.println(objeto.execOpercacao(5,3,divisao));
        System.out.println(objeto.execOpercacao(5,3,exponenciacao));
        System.out.println(objeto.execOpercacao(5,3,radiciacao));
        
        
       }
         public double execOpercacao(double a, double b, IMath op){
         return op.operacao(a, b);
    
       }
}   
    
    

