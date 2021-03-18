package unidade4;


import java.util.ArrayList;

public class Notebook {
	
	static ArrayList<String> anotacoes;
	public static void main(String[] args) {
		anotacoes = new ArrayList<>();
		anotacoes.add("Comprar Pão");
		anotacoes.add("Vender Carro");
		anotacoes.add("COMER");
		
		double t1 = System.currentTimeMillis();
		for(int i = 3;i <10003;i++)
			anotacoes.add("texto_"+i);
		double t2 = System.currentTimeMillis();
		System.out.println((t2-t1)/1000);
			
		
		//System.out.println(anotacoes);
		
		

	}

}
