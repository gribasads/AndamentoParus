/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aulamap;

import java.util.LinkedHashMap;

/**
 *
 * @author rafae
 */
public class LinkedHashMapAPP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LinkedHashMap<Integer,String> mapa = new LinkedHashMap<>();
        mapa.put(4,"bruno");
        mapa.put(2,"umberto");
        mapa.put(3,"fernando");
        mapa.put(3,"caetano");
        mapa.put(1,"umberto");
        System.out.println(mapa);
    }
    
}
