package unidade1;

public class TesteExcessao {

	public static void main(String[] args) {
		
		
		try {
		
		int i = 50;
		i=i /2;
		System.out.println(i);
		Object c =null;
		System.out.println(c.toString());
	     }
		catch (ArithmeticException |NullPointerException e)
		{
			e.printStackTrace();
			
		}
	}

}
