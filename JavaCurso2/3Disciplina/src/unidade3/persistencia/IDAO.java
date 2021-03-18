package unidade3.persistencia;

public interface IDAO <T>{
	
	public void create (T entidade);
	public void read (T entidade);
	public void update (T entidade);
	public void delete (T entidade);

}
