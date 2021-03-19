package unidade6;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JTFAppv2  {

	public static void main(String[] args) {

		JFrame frame= new JFrame();
		frame.setTitle("Primeira Aplicação");
		frame.setSize(350,250);
		Container cont = frame.getContentPane();
		JTextField tf =new JTextField("digite aqui");
		tf.addActionListener(ev->{
			JOptionPane.showMessageDialog(cont, ev.getActionCommand().toString());
			
		});
		
		
		
		cont.add(tf,BorderLayout.NORTH);
		frame.setVisible(true);
		
	}

	

}
