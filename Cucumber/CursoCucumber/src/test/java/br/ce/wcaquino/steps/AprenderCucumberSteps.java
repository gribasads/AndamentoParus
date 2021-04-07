package br.ce.wcaquino.steps;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Assert;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

public class AprenderCucumberSteps {

	@Dado("^que criei o arquivo corretamente$")
	public void que_criei_o_arquivo_corretamente() throws Throwable {
		System.out.println("qq coisa");
	}

	@Quando("^execut?-lo$")
	public void executLo() throws Throwable {
	}

	@Entao("^a especifica??o deve finalizar com sucesso$")
	public void aEspecificaODeveFinalizarComSucesso() throws Throwable {
	}

	private int contador = 0;

	@Dado("^que o valor do contador ? (\\d+)$")
	public void queOValorDoContador(int arg1) throws Throwable {
		contador = arg1;
	}

	@Quando("^eu incrementar em (\\d+)$")
	public void euIncrementarEm(int arg1) throws Throwable {
		contador = contador + arg1;
	}

	@Entao("^o valor do contador ser? (\\d+)$")
	public void oValorDoContadorSer(int arg1) throws Throwable {
		// Assert.assertTrue(arg1==contador);
		Assert.assertEquals(arg1, contador);
	}

	Date entrega = new Date();

	@Dado("que a entrega é dia {data}")
	public void queAEntregaeDia(Date data) throws Throwable {
		entrega = data;
		System.out.println(entrega);
	}

	@Quando("^a entrega atrasar em (\\d+) (dia|dias|mes|meses)$")
	public void aEntregaAtrasarEmDias(int arg1, String tempo) throws Throwable {
		Calendar cal = Calendar.getInstance();
		cal.setTime(entrega);
		if (tempo.equals("dias")) {
			cal.add(Calendar.DAY_OF_MONTH, arg1);
		}
		if (tempo.equals("meses")) {
			cal.add(Calendar.MONTH, arg1);
		}
		cal.add(Calendar.DAY_OF_MONTH, arg1);
		entrega = cal.getTime();

	}

	
	    
	

	// ------------------------------------------------------------------------exer1

	@Dado("^que o ticket ( especial)? é (A.\\d{3})$")
	public void queOTicketÉAF(String tipo, String arg1) throws Throwable {
	}

	@Dado("^que o valor da passagem é R\\$ (.*)$")
	public void queOValorDaPassagemÉR$(double numero) throws Throwable {
		System.out.println(numero);
	}

	@Dado("^que o nome do passageiro é \"(.{5,20})\"$")
	public void queONomeDoPassageiroÉ(String arg1) throws Throwable {

	}

	@Dado("^que o telefone do passageiro é (9\\d{3}-\\d{4})$")
	public void queOTelefoneDoPassageiroÉ(int arg1, int arg2) throws Throwable {

	}

	@Quando("^criar os steps$")
	public void criarOsSteps() throws Throwable {
	}

	@Entao("^o teste vai funcionar$")
	public void oTesteVaiFuncionar() throws Throwable {
	}

}
