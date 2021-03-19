package unidade6;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Container;
import java.awt.GridLayout;

public class LabelApp {

	public static void main(String[] args) {

		JFrame frame= new JFrame("primeira aplicação");
		frame.setSize(350,250);
		Container cont = frame.getContentPane();
		cont.setLayout(new GridLayout(2,1));
		cont.add(new JLabel("Isto é um rotulo"));
		
		frame.setVisible(true);
		
	}

}
