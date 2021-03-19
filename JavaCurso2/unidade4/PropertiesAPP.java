package unidade4;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;

public class PropertiesAPP {

	public static void main(String[] args) throws Exception {
		 
		        Properties sites = new Properties();
		        sites.loadFromXML(new FileInputStream("C:/Users/rafae/OneDrive/Documentos/NetBeansProjects/AulaMap/src/exercicio2Maps/site.xml"));
		        System.out.println(sites.getProperty("1"));
		    

	}

}
