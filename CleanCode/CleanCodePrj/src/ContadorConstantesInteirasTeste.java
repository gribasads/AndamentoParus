

import static org.junit.Assert.assertEquals;

import java.time.Month;
import java.util.List;

import org.junit.Test;

public class ContadorConstantesInteirasTeste {
	
	@Test
	public void testContagem() {
		// parte1: preparação / cenario (s)
		ContadorConstantesInteiras contador = new ContadorConstantesInteiras();
		// parte3: validação 
		assertEquals(1,contador.contar(Classe1.class));
		assertEquals(-1,contador.contar(List.class));
		assertEquals(-1,contador.contar(Month.class));
		assertEquals(-1,contador.contar(null));
		assertEquals(3,contador.contar(Classe2.class));

	}

}


class Classe1{
	public static final int CONST1=1;
}

class Classe2 extends Classe1{
	public static final int CONST2=1;
	public static final int CONST3=1;
}
