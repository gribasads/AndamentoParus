package BDprojetos;

public class ClienteVO {
	long cpf;
    String nome;
    String email;

    public ClienteVO(long cpf, String nome, String email) {
        super();
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
    }

    public long getCpf() {
        return cpf;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

  

   

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    @Override
    public String toString(){
        return  "Cliente [nome="+nome+"cpf="+cpf+"email="+email+"]";
    }
}
