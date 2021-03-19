/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicio2Maps;

import java.io.FileInputStream;
import java.util.Properties;


public class PropertiesAPP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception{
        Properties sites = new Properties();
        sites.loadFromXML(new FileInputStream("b:/Gustavo Ribas/site.xml"));
        System.out.println(sites.getProperty("2"));
    }
    
}
