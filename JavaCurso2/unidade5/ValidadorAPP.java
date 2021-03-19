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
public class ValidadorAPP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String celular= "99113-4566";
        Validador<String> validacao = valor ->valor.matches("[0-9]{5}-0-9]{4}");
        System.out.println(validacao.valida(celular));
    }
    
}
