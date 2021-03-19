/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unidade5;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author rafae
 */
public class LambdaApp {
    static int numero;
    int somatorio;
    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1,2,3,4);
        LambdaApp app = new LambdaApp();
       // int numero =10;
        //System.out.println(integers);
       /*for(Integer inteiro:integers)
        {
            inteiro = inteiro +10;
            System.out.println(inteiro);
        
        
        } */
       integers.forEach((Integer x)->
       {
            int y=x/2;
            System.out.println(y);
            numero=10;
            x=x+numero;
            app.somatorio=app.somatorio +x;
            System.out.println(x);
       });
            System.out.println(app.somatorio);
            
            /*no exercicio dois a resposta é que não se pode
            passar valores dentro do lambda para variavei locais
            */ 
        
    }
}
