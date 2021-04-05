package br.ce.wcaquino.entities;

public class Filme {

	private int estoque;
	private int aluguel;
	
	public void setEstoque(int arg1) {
	this.estoque = arg1;	
		
	}

	public void setAluguel(int arg1) {
		this.aluguel=arg1;
		
	}

	public int getAluguel() {
		// TODO Auto-generated method stub
		return aluguel;
	}

	public int getEstoque() {
		return estoque;
	}

}
