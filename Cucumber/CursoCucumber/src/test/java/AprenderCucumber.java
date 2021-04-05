import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;

public class AprenderCucumber {

	@Dado("^que criei o arquivo corretamente$")
	public void que_criei_o_arquivo_corretamente() throws Throwable {
		System.out.println("qq coisa");
	}

	@Quando("^execut?-lo$")
	public void executLo() throws Throwable {
	}

	@Entao("^a especifica??o deve finalizar com sucesso$")
	public void aEspecificaODeveFinalizarComSucesso() throws Throwable {
	}
	
	private int contador=0;
	
	@Dado("^que o valor do contador ? (\\d+)$")
	public void queOValorDoContador(int arg1) throws Throwable {
	    contador = arg1;
	}

	@Quando("^eu incrementar em (\\d+)$")
	public void euIncrementarEm(int arg1) throws Throwable {
	    contador=contador + arg1;
	}

	@Entao("^o valor do contador ser? (\\d+)$")
	public void oValorDoContadorSer(int arg1) throws Throwable {
	    System.out.println(arg1);
	    System.out.println(contador);
	}
}
