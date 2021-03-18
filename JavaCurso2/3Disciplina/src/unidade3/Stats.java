package unidade3;

public class Stats<T extends Number> {
	
	T[] num;
	
	public Stats(T[] num) {
		super();
		this.num=num;
	}
	
	double media() 
	{
		
		int i=0;
		double soma=0;
		for(i=0;i<num.length;i++)
			soma=soma +num[i].doubleValue();
		
		return(soma/i);
	}

}
