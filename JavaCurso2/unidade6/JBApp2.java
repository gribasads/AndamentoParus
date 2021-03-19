package unidade6;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class JBApp2  {

	public static void main(String[] args) {

		JFrame frame= new JFrame("Primeira Aplicação");
		frame.setSize(350,250);
		Container cont = frame.getContentPane();
		cont.setLayout(new FlowLayout());
		JButton botao= new JButton("BOTAO AQUI");
		botao.addActionListener(ev->{
			JOptionPane.showMessageDialog(null, ev.getActionCommand().toString());
			
		});
		cont.add(botao);
		frame.setVisible(true);
		
	}

}
