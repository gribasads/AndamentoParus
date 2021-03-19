package unidade6;

import javax.swing.JOptionPane;

public class DialogApp {

	public static void main(String[] args) {
		JOptionPane.showMessageDialog(null, "iniciando a aplicação","Instalação concluida",JOptionPane.INFORMATION_MESSAGE);
		String nome =JOptionPane.showInputDialog("digite seu nome");
		int resposta = JOptionPane.showConfirmDialog(null, "o nome "+nome+"foi informado");
		JOptionPane.showMessageDialog(null,""+resposta);
		

	}

}
