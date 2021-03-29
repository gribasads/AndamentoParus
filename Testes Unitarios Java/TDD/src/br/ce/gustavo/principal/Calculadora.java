package br.ce.gustavo.principal;

import br.ce.gustavo.utils.NaoPodeDividirporZeroException;

public class Calculadora {

	public int somar(int a, int b) {
		
		return a+b;
	}

	public int subtrair(int a, int b) {
		
		return a-b;
	}

	public int dividir(int a, int b) throws NaoPodeDividirporZeroException {
		if(b==0) {
			throw new NaoPodeDividirporZeroException();
		}
		return a/b;
	}
	
	

}
