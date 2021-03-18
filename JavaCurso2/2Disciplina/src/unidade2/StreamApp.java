package unidade2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class StreamApp {

	public static void byteStream() throws Exception {
		FileInputStream entrada = new FileInputStream("C:/Users/Gustavo.ribas/eclipse-workspace/2Disciplina/src/unidade2/dados.txt");
		int contador =0;
		while((entrada.read())!=-1)
			System.out.println("numero de caracter é:"+contador);
            contador++;
            entrada.close();
	}
	public static void caracterStream(char letra) throws Exception {
		FileInputStream entrada = new FileInputStream("C:/Users/Gustavo.ribas/eclipse-workspace/2Disciplina/src/unidade2/dados.txt");
		int contador =0;
		int c;
		while((c =entrada.read())!=-1) {
			if(c== letra)
				contador++;
			
		}
			System.out.println("numero de vezes que a letra informada foi encontrada:"+contador);
            entrada.close();
		
	}
	public static void main(String[] args) {
		try {
			//byteStream();
			System.out.println("informar a letra a ser encontrada");
			char letra = (char)System.in.read();
			caracterStream(letra);
		} catch ( Exception e) {
			e.getStackTrace();
		}

	}

}
