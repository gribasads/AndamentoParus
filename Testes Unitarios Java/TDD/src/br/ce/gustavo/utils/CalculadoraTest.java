package br.ce.gustavo.utils;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.ce.gustavo.principal.Calculadora;



public class CalculadoraTest {
	private Calculadora calc;
	
	@Before
	public void setup() {
		calc=new Calculadora();
	}
	
	@Test
	public void devesomardoisvalores() {
	
	//cenario
	int a=5;
	int b=3;
	
	//ação
	int resultado = calc.somar(a,b);
	
	//verificação
	Assert.assertEquals(8, resultado);
	}
	
	@Test
	public void devesubtrairdoisvalores() {
		int a = 8;
		int b = 5;
		
		
		//ação
		int resultado = calc.subtrair(a,b);
		
		//validação
		Assert.assertEquals(3, resultado);
		
		
	}
	
	@Test
	public void deveDividirDoisValors() throws NaoPodeDividirporZeroException {
		int a = 8;
	    int b= 2;
		
		//ação
		int resultado = calc.dividir(a,b);
		
		//validação
		Assert.assertEquals(4, resultado);
	}
	
	@Test(expected=NaoPodeDividirporZeroException.class)
	public void deveLançarExcecaoDivporzero() throws NaoPodeDividirporZeroException {
		int a = 8;
	    int b= 0;
		
		//ação
		int resultado = calc.dividir(a,b);
		
		
	}
}
