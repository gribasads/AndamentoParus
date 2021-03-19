/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aulamap;

import java.util.HashMap;

/**
 *
 * @author rafae
 */
public class AulaMap {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        HashMap<Integer,String> mapa = new HashMap<>();
        mapa.put(1,"bruno");
        mapa.put(2,"umberto");
        mapa.put(3,"fernando");
        mapa.put(3,"caetano");
        mapa.put(4,"umberto");
        System.out.println(mapa);
    }
    
}
