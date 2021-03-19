package unidade6;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;

public class JPFpp {

	public static void main(String[] args) {

		JFrame frame= new JFrame("primeira aplicação");
		frame.setSize(350,250);
		Container cont = frame.getContentPane();
		JPasswordField pf =new JPasswordField("digite aqui");
		cont.add(pf,BorderLayout.NORTH);
		frame.setVisible(true);
		
	}

}
