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
public class Calculadora implements Formula{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        IMatematica objeto = new IMatematica() {
            
            @Override
            public int somar(int a, int b) {
     return (a/b);     
            }

            @Override
            public int subtrair(int a, int b) { 
            return (a/b);            
            }

            @Override
            public int multiplicar(int a, int b) {
                return (a/b);
            }

            @Override
            public int dividir(int a, int b) {
                return (a/b);
            } 

            @Override
            public double exponenciacao(double a, double b) {
             return Math.pow(a,b);
            }

            @Override
            public double radiciacao(double a, double b) {
                return Math.pow(a,1/b);
            }
        };
        System.out.println(objeto.getClass());
        System.out.println(objeto.somar(5,5));
        System.out.println(objeto.subtrair(6,4));
        System.out.println(objeto.multiplicar(3,4));
        System.out.println(objeto.dividir(10,2));
    }

    @Override
    public double calcular(int a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
