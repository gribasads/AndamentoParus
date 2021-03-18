package unidade3;

public class UsoGenerico {

	public static void main(String[] args) {
		ExemploGenerics<Integer>iob = new ExemploGenerics<Integer>(88);
		iob.showType();
		
		ExemploGenerics<String> sob = new ExemploGenerics<>("Gustavo");
		sob.showType();
		

	}

}
