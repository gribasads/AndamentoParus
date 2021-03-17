package unidade2;

import java.awt.Graphics;

import javax.swing.JApplet;
import javax.swing.JOptionPane;

public class Avaliacao extends JApplet {
	private static final long serialVersionUID =1L;
	@Override
	public void paint(Graphics g) {
	
		String notas = JOptionPane.showInputDialog("informe a nota");
		float nota = Float.parseFloat(notas);
		
		if(nota<0 || nota>100) {
			JOptionPane.showMessageDialog(null, "nota invalida favor informar nota de 0 a 100");
			paint(null);
			
		}else {
			if(nota<50) {
				JOptionPane.showInternalMessageDialog(null, "insuficiente");
			}
			else if(nota<70)
				JOptionPane.showMessageDialog(null, "regular");
			else if(nota<90)
				JOptionPane.showMessageDialog(null, "bom");
			else
				JOptionPane.showMessageDialog(null,"excelente");
			System.exit(0);
		}
	}

}
