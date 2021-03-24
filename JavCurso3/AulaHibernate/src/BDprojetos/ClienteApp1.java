package BDprojetos;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ClienteApp1 {
    static String url="jdbc:oracle:thin:@localhost:1521:XE";
    static String usuario="C##CURSO_JAVA";
    static String senha="schema";
    static Connection conexao;
    /*******************************/
       public static void conectar ()throws SQLException
    {
    
    Connection conexao = DriverManager.getConnection(url,usuario,senha);
    DatabaseMetaData meta= conexao.getMetaData();
    conexao.setAutoCommit(false);
        System.out.println(">>>>>>>>>>Conectando ao Bando de Dados"+meta.getDatabaseProductVersion());
    }
       /*************************************************************/
          public static void desconectar ()throws SQLException
    {
    
    conexao.close();
    }
          /*********************************************/
          public static void inserir(ClienteVO cliente) throws SQLException
          {
          String sql="insert into cliente values ("+cliente.getCpf()+",'"+cliente.getNome()+",'"+cliente.getEmail()+"')";
          Statement statement=conexao.createStatement();
          statement.execute(sql);
          conexao.commit();
          }
          /***************************************************************/
          
          /***************************************************************/
          
          public static ClienteVO consultar(long cpf) throws SQLException
          {
          String sql="select*from cliente where cpf = "+cpf+"";
          Statement statement=conexao.createStatement();
          ResultSet rs = statement.executeQuery(sql);
          ClienteVO cliente = null;
             while(rs.next()) {
                 cliente = new ClienteVO (rs.getLong(1),rs.getString(2),rs.getString(3));
                 System.out.println( "cpf:"+rs.getInt(1)+
                " nome:"+ rs.getString(2)+ " email"+ rs.getString(3));
}
             return cliente;
          }
          /************************************************************/
          public static List<ClienteVO> consultarTodos() throws SQLException
          {
          String sql="select*from cliente";
          Statement statement=conexao.createStatement();
          ResultSet rs = statement.executeQuery(sql);
          List<ClienteVO> clientes = new LinkedList<>();
          
             while(rs.next()) 
             {
                 
                 
                 ClienteVO cliente = new ClienteVO (rs.getLong(1),rs.getString(2),rs.getString(3));
                 System.out.println( "cpf:"+rs.getInt(1)+
                " nome:"+ rs.getString(2)+ " email"+ rs.getString(3));
                 clientes.add(cliente);
             }
              
        return clientes;
        }
          /******************************************************************/
         
          public static void alterar(ClienteVO cliente) throws SQLException 
          {
          String sql="update cliente set nome= '"+cliente.getNome()+"',email='"+cliente.getEmail()+"' where cpf ="+cliente.getCpf();
          Statement statement=conexao.createStatement();
          statement.executeUpdate(sql);
          conexao.commit();
          }
          /************************************************************/
          
          public static void excluir (long cpf) throws SQLException
          {
          String sql="delete from cliente where cof="+cpf;
          Statement statement=conexao.createStatement();
          statement.executeUpdate(sql);
          conexao.commit();
          }
          
    public static void main(String[] args) throws SQLException {
       
        conectar();
        Scanner entrada = new Scanner(System.in);
        int opcao=0;
        long cpf;
        String nome,email;
        while(opcao!=6)
        {
            System.err.println("Sistema de Gerenciamento de Clientes");
            System.out.println("========================================");
            System.out.println("Digite [1] para consultar todos os clientes");
            System.out.println("Digite [2] para consultar um cliente especifico");
            System.out.println("Digite [3] para cadastrar um cliente");
            System.out.println("Digite [4] para alterar um cliente ");
            System.out.println("Digite [5] para excluir um cliente ");
            System.out.println("Digite [6] para excluir um cliente");
            System.out.println("========================================");
            opcao=entrada.nextInt();
            
            switch(opcao)
            {
                case 1: //consultar todos
                {
                System.out.println("[1] consultar todos");
                List<ClienteVO> clientes = ClienteApp1.consultarTodos();
                clientes.forEach(System.out::println);
                    System.out.println("Numero de Clientes>>>>>>"+clientes.size()+"\n");
                break;
                }
                case 2://consultar cpf
                {
                    System.out.println("[2] consultar um cliente");
                    System.out.println("favor informar o cpf");
                    cpf=entrada.nextLong();
                    ClienteVO cliente = ClienteApp1.consultar(cpf);
                    System.out.println(cliente);
                    break;

                }
                case 3://cadastrar
                {
                    System.out.println("[3] cadastrar um novo cliente");
                    System.out.println("favor informar o cpf");
                    cpf=entrada.nextLong();
                    entrada.nextLine();//esvaziar o buffer do teclado
                    System.out.println("favor informar o nome");
                    nome=entrada.nextLine();
                    System.out.println("favor informar o email");
                    email=entrada.nextLine();
                    ClienteVO cliente= new ClienteVO(cpf,nome,email);
                    ClienteApp1.inserir(cliente);
                    break;
                }
                case 4://alterar
                {
                    System.out.println("[4] Alterar um  cliente");
                    System.out.println("favor informar o cpf");
                    cpf=entrada.nextLong();
                    entrada.nextLine();//esvaziar o buffer do teclado
                    System.out.println("favor informar o nome");
                    nome=entrada.nextLine();
                    System.out.println("favor informar o email");
                    email=entrada.nextLine();
                    ClienteVO cliente= new ClienteVO(cpf,nome,email);
                    ClienteApp1.alterar(cliente);
                    break;
                }
                case 5://excluir
                {
                    System.out.println("[5] Excluir um  cliente");
                    System.out.println("favor informar o cpf");
                    cpf=entrada.nextLong();
                    ClienteApp1.excluir(cpf);
                    break;
                }
                case 6://sair
                {
                    System.out.println("Encerrando.....");
                break;
                }
            
            
            }
        }   
        entrada.close();
        desconectar();
        
        
   
    }
}
