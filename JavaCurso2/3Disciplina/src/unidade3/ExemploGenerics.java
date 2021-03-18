package unidade3;

public class ExemploGenerics <T>{
	
	T obj;

	public ExemploGenerics(T obj) {
		super();
		this.obj = obj;
	}

	public T getObj() {
		return obj;
	}

	public void setObj(T obj) {
		this.obj = obj;
	}
	
	public void showType() {
		
		System.out.println(obj.getClass().getName());
	}

}
