package br.ce.wcaquino.steps;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Assert;

import br.ce.wcaquino.entities.Filme;
import br.ce.wcaquino.entities.NotaAluguel;
import br.ce.wcaquino.entities.TipoAluguel;
import br.ce.wcaquino.servicos.AluguelService;
import br.ce.wcaquino.utils.DateUtils;
import cucumber.api.PendingException;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;

public class AlugarFilmeSteps {
	private Filme filme;
	private AluguelService aluguel = new AluguelService();
	private NotaAluguel nota;
	private String erro;
	private TipoAluguel tipoAluguel= TipoAluguel.COMUM;
	
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
		nota = aluguel.alugar(filme,tipoAluguel);
		}catch(RuntimeException e) {
			erro=e.getMessage();
		}
	}

	@Entao("^o preço do aluguel sera R\\$ (\\d+)$")
	public void oPreçoDoAluguelSeraR$(int arg1) throws Throwable {
		Assert.assertEquals(arg1, nota.getPreco());
	    
	}

	

	@Entao("^o estoque sera de (\\d+) unidade$")
	public void oEstoqueSeraDeUnidade(int arg1) throws Throwable {
		Assert.assertEquals(arg1, filme.getEstoque());
	    
	}
	@Entao("^não sera possivel por falta de estoque$")
	public void não_sera_possivel_por_falta_de_estoque() throws Throwable {
		Assert.assertEquals("filme sem estoque", erro);

	}
	@Dado("^que o tipo do aluguel seja (.*)$")
	public void que_o_tipo_do_aluguel_seja_extendido(String tipo) throws Throwable {
	    tipoAluguel = tipo.equals("semanal")? TipoAluguel.SEMANAL: tipo.equals("extendido")? TipoAluguel.EXTENDIDO: TipoAluguel.COMUM;
	}

	@Entao("^a data de entrega será em (\\d+) dia?$")
	public void a_data_de_entrega_será_em_dias(int arg1) throws Throwable {
	    Date dataEsperada = DateUtils.obterDataDiferencaDias(arg1);
	    Date dataReal=nota.getDataEntrega();
	    DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
	    
	    Assert.assertEquals(format.format(dataEsperada), format.format(dataReal));
	}

	@Entao("^a pontuação recebida será de (\\d+) pontos$")
	public void a_pontuação_recebida_será_de_pontos(int arg1) throws Throwable {
	    Assert.assertEquals(arg1, nota.getPontuacao());
	}

}
