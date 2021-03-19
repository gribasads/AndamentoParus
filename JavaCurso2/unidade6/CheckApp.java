package unidade6;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JCheckBox;
import javax.swing.JFrame;

public class CheckApp {

	public static void main(String[] args) {
		JFrame frame= new JFrame("Aplicação");
		frame.setSize(350,250);
		Container cont = frame.getContentPane();
		cont.setLayout(new FlowLayout());
		cont.add(new JCheckBox("1-sim"));
		cont.add(new JCheckBox("2-não"));
		frame.setVisible(true);
		
		
		
	}

}
