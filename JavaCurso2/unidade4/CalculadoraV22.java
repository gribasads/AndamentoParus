package unidade4;

public class CalculadoraV22 {
public static void main(String[] args) {
	 CalculadoraV22 objeto= new CalculadoraV22();
     
     IMath somar= (a,b)->a+b;
     IMath subtrair=(a,b)->a-b;
     IMath multiplicar=(a,b)->a*b;
     IMath divisao=(a,b)->a/b;
     IMath exponenciacao=(a,b)->Math.pow(a,b);
     IMath radiciacao=(a,b)->Math.pow(a,1/b);
     //chamada das expressões lambdas
     System.out.println(objeto.execOpercacao(5,3,somar));
     System.out.println(objeto.execOpercacao(5,3,subtrair));
     System.out.println(objeto.execOpercacao(5,3,multiplicar));
     System.out.println(objeto.execOpercacao(5,3,divisao));
     System.out.println(objeto.execOpercacao(5,3,exponenciacao));
     System.out.println(objeto.execOpercacao(5,3,radiciacao));
     
     public double execOpercacao(double a, double b, IMath op)
     {
     return op.operacao(a,b);
     }
}
}
