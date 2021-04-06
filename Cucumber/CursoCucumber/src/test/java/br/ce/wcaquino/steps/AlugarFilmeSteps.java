package br.ce.wcaquino.steps;

import java.util.Calendar;
import java.util.Date;

import org.junit.Assert;

import br.ce.wcaquino.entities.Filme;
import br.ce.wcaquino.entities.NotaAluguel;
import br.ce.wcaquino.servicos.AluguelService;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;

public class AlugarFilmeSteps {
	private Filme filme;
	private AluguelService aluguel = new AluguelService();
	private NotaAluguel nota;
	private String erro;
	
	@Dado("^um filme com estoque de (\\d+) unidades$")
	public void umFilmeComEstoqueDeUnidades(int arg1) throws Throwable {
		filme = new Filme();
		filme.setEstoque(arg1);

	}

	@Dado("^que o preço do aluguel seja R\\$ (\\d+)$")
	public void queOPreçoDoAluguelSejaR$(int arg1) throws Throwable {
	    filme.setAluguel(arg1);
	}

	@Quando("^alugar$")
	public void alugar() throws Throwable {
		try {
		nota = aluguel.alugar(filme);
		}catch(RuntimeException e) {
			erro=e.getMessage();
		}
	}

	@Entao("^o preço do aluguel sera R\\$ (\\d+)$")
	public void oPreçoDoAluguelSeraR$(int arg1) throws Throwable {
		Assert.assertEquals(arg1, nota.getPreco());
	    
	}

	@Entao("^a data de entrega sera no dia seguinte$")
	public void aDataDeEntregaSeraNoDiaSeguinte() throws Throwable {
	    Calendar cal = Calendar.getInstance();
	    cal.add(Calendar.DAY_OF_MONTH, 1);
	    
	    Date dataRetorno = nota.getDataEntrega();
	    Calendar calRetorno = Calendar.getInstance();
	    calRetorno.setTime(dataRetorno);
	    
	    Assert.assertEquals(cal.get(Calendar.DAY_OF_MONTH), calRetorno.get(Calendar.DAY_OF_MONTH));
	    Assert.assertEquals(cal.get(Calendar.MONTH), calRetorno.get(Calendar.MONTH));
	    Assert.assertEquals(cal.get(Calendar.YEAR), calRetorno.get(Calendar.YEAR));
	}

	@Entao("^o estoque sera de (\\d+) unidade$")
	public void oEstoqueSeraDeUnidade(int arg1) throws Throwable {
		Assert.assertEquals(arg1, filme.getEstoque());
	    
	}
	@Entao("^não sera possivel por falta de estoque$")
	public void não_sera_possivel_por_falta_de_estoque() throws Throwable {
		Assert.assertEquals("filme sem estoque", erro);

	}
	@Dado("^que o tipo do aluguel seja extendido$")
	public void que_o_tipo_do_aluguel_seja_extendido() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Entao("^a data de entrega será em (\\d+) dias$")
	public void a_data_de_entrega_será_em_dias(int arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Entao("^a pontuação recebida será de (\\d+) pontos$")
	public void a_pontuação_recebida_será_de_pontos(int arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

}
