package br.ce.wcaquino.servicos;

import java.util.Calendar;

import br.ce.wcaquino.entities.Filme;
import br.ce.wcaquino.entities.NotaAluguel;
import br.ce.wcaquino.entities.TipoAluguel;
import br.ce.wcaquino.utils.DateUtils;

public class AluguelService {
	public NotaAluguel alugar(Filme filme,TipoAluguel tipo) {
		if(filme.getEstoque()==0) 
			throw new RuntimeException("filme sem estoque");
		
		NotaAluguel nota = new NotaAluguel();
		switch(tipo) {
		case COMUM:
			nota.setPreco(filme.getAluguel());
		    nota.setPontuacao(1);
		    nota.setDataEntrega(DateUtils.obterDataDiferencaDias(1));
			break;
		case EXTENDIDO:
			nota.setPreco(filme.getAluguel()* 2);
			nota.setDataEntrega(DateUtils.obterDataDiferencaDias(3));
			nota.setPontuacao(2);
			break;
		case SEMANAL:
			nota.setPreco(filme.getAluguel()* 3);
			nota.setDataEntrega(DateUtils.obterDataDiferencaDias(7));
			nota.setPontuacao(3);
			break;
		}
		filme.setEstoque(filme.getEstoque() - 1);
		return nota;
		
	}

}
