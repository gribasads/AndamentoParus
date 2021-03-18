package unidade2;

import java.util.Formatter;
import java.util.Scanner;

public class ScannerAPP {

	public static void main(String[] args) {
		Scanner entrada = new Scanner (System.in);
		Formatter saida = new Formatter (System.out);
		System.out.println("informe a nota um");
		float n1=entrada.nextFloat();
		System.out.println("informe a nota dois");
		float n2=entrada.nextFloat();
		System.out.println("informe a nota tres");
		float n3=entrada.nextFloat();
		System.out.println("informe a nota quatro");
		float n4=entrada.nextFloat();
		float media = (n1+n2+n3+n4)/4;
		saida.format("resultado %.2f",media);
		entrada.close();
		saida.close();

	}

}
