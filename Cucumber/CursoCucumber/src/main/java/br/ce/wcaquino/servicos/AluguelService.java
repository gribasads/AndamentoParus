package br.ce.wcaquino.servicos;

import java.util.Calendar;

import br.ce.wcaquino.entities.Filme;
import br.ce.wcaquino.entities.NotaAluguel;
import br.ce.wcaquino.utils.DateUtils;

public class AluguelService {
	public NotaAluguel alugar(Filme filme) {
		if(filme.getEstoque()==0) 
			throw new RuntimeException("filme sem estoque");
		
		NotaAluguel nota = new NotaAluguel();
		nota.setPreco(filme.getAluguel());
		nota.setDataEntrega(DateUtils.obterDataDiferencaDias(1));
		filme.setEstoque(filme.getEstoque() - 1);
		return nota;
		
	}

}
