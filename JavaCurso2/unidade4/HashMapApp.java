package unidade4;

import java.util.HashMap;

public class HashMapApp {

	public static void main(String[] args) {
		HashMap<Integer,String> mapa= new HashMap<>();
        mapa.put(1,"bruno");
        mapa.put(2,"umberto");
        mapa.put(3,"fernando");
        mapa.put(3,"caetano");
        mapa.put(4,"umberto");
        System.out.println(mapa);
	}

}
