package unidade6;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;

public class JTApp {

	public static void main(String[] args) {

		JFrame frame= new JFrame("primeira aplicação");
		frame.setSize(350,250);
		Container cont = frame.getContentPane();
		JTextArea ta =new JTextArea("digite aqui");
		cont.add(ta,BorderLayout.NORTH);
		frame.setVisible(true);
		
	}

}
