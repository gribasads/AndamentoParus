package unidade4;

import java.util.LinkedList;
import java.util.Collections;
import java.util.List;

public class LinkedListApp {
	public static void main(String[] args) {
		LinkedList <String> lista = new LinkedList<>();
		lista.add("vermelho");
		lista.add("verde");
		lista.add("verde");
		lista.add("amarelo");
		System.out.println(lista);
		lista.removeFirst();
		lista.removeLast();
		System.out.println(lista);


	}

}
