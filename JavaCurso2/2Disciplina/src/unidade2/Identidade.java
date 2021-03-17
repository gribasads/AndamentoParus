package unidade2;

import java.util.Iterator;

import javax.swing.JApplet;

public class Identidade extends JApplet {
	private static final long serialVersionUID =1L;
	@Override
	public void init() {
		int I[][]= new int [3][3];
		for (int i=0; i<3;i++) {
			for (int j=0;j<3;j++) {
				if(i==j)
					I[i][j]=1;
				else 
					I[i][j]=0;
				System.out.print(I[i][j]);
			}
			System.out.println("\n======");
			System.out.println("\n====");
		}
	}

}
