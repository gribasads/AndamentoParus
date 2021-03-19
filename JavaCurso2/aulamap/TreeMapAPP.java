/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aulamap;

import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author rafae
 */
public class TreeMapAPP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Map<Integer,String> mapa = new TreeMap<>();
        mapa.put(4,"bruno");
        mapa.put(2,"umberto");
        mapa.put(3,"fernando");
        mapa.put(3,"caetano");
        mapa.put(1,"umberto");
        System.out.println(mapa);
    }
    
}
