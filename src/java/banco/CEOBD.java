package banco;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;

import dominio.CEO;

public class CEOBD  {
    // Connect to your database.
    // Replace server name, username, and password with your credentials
    public static void Inserir(CEO ceoNew){
        
        String connectionUrl =
                "jdbc:sqlserver://projsofsge1.database.windows.net:1433;databaseName=WebSof [SGE_@projsofsge1 em db_datawriter];"
                        + "database=WebSof;"
                        + "user=SGE_@projsofsge1;"
                        + "password=Calebeodeiadualboot2020_;"
                        + "encrypt=true;"
                        + "trustServerCertificate=false;"
                        + "loginTimeout=30;";
        
        int resultSet ;
     
        try (Connection connection = DriverManager.getConnection(connectionUrl);
                PreparedStatement statement = connection.prepareStatement("INSERT INTO dbo.CEO (nomeCeo,empresa,email ,senha,telefone,dataN) VALUES(?,?,?,?,?,?)");) {
            
            statement.setString(1,ceoNew.getNome());
            statement.setString(2,ceoNew.getEmpresa());
            statement.setString(3,ceoNew.getEmail());
            statement.setString(4,ceoNew.getSenha());
            statement.setString(5,ceoNew.getTelefone());
            statement.setDate(6,ceoNew.getData());
            // Create and execute a SELECT SQL statement.
     
            resultSet=statement.executeUpdate();

            // Print results from select statement
            connection.close();   
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void excluir(String email){
    String connectionUrl =
                "jdbc:sqlserver://projsofsge1.database.windows.net:1433;"
                        + "database=WebSof;"
                        + "user=SGE_@projsofsge1;"
                        + "password=Calebeodeiadualboot2020_;"
                        + "encrypt=true;"
                        + "trustServerCertificate=false;"
                        + "loginTimeout=30;";
        
        int resultSet ;
     
        try (Connection connection = DriverManager.getConnection(connectionUrl);
                PreparedStatement statement = connection.prepareStatement("DELETE FROM dbo.CEO WHERE(email=?)");) {

            // Create and execute a SELECT SQL statement.
            statement.setString(1, email);
            
            resultSet=statement.executeUpdate();

            // Print results from select statement
            connection.close();   
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void alterar(CEO c){
        String connectionUrl =
                "jdbc:sqlserver://projsofsge1.database.windows.net:1433;"
                        + "database=WebSof;"
                        + "user=SGE_@projsofsge1;"
                        + "password=Calebeodeiadualboot2020_;"
                        + "encrypt=true;"
                        + "trustServerCertificate=false;"
                        + "loginTimeout=30;";
        
        int resultSet ;
     
        try (Connection connection = DriverManager.getConnection(connectionUrl);
                PreparedStatement statement = connection.prepareStatement("UPDATE dbo.CEO SET telefone=?,senha=? WHERE email=?;");) {
            
            // Create and execute a SELECT SQL statement.
            statement.setString(1, c.getTelefone());
            statement.setString(2, c.getSenha());
            statement.setString(3, c.getEmail());
            
            resultSet=statement.executeUpdate();

            // Print results from select statement
            connection.close();   
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static boolean validarEmail(String email){
        String connectionUrl =
                "jdbc:sqlserver://projsofsge1.database.windows.net:1433;"
                        + "database=WebSof;"
                        + "user=SGE_@projsofsge1;"
                        + "password=Calebeodeiadualboot2020_;"
                        + "encrypt=true;"
                        + "trustServerCertificate=false;"
                        + "loginTimeout=30;";
        
        ResultSet resultSet ;
        //String sql="SELECT * FROM dbo.CEO WHERE email=? AND senha=? ;";
       
        try (Connection connection = DriverManager.getConnection(connectionUrl);
                PreparedStatement statement = connection.prepareStatement("SELECT email ,senha  FROM dbo.CEO WHERE email=?;");) {
            
            // Create and execute a SELECT SQL statement.
            statement.setString(1, email);
            
            
            resultSet=statement.executeQuery();
            
            //String s = resultSet.next().getString("email");
            if (resultSet.next() == false) {
               System.out.println("ResultSet in empty in Java");
               return false;
           } else {

              String s = resultSet.getString("email");
              if(s.equals("")){
                  return true;
              }
           }
      
            
            connection.close();
            return true;
            // Print results from select statement
               
        }
        catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    
    }
    public static boolean procurarPorLoginSenha(String email, String senha){
        String connectionUrl =
                "jdbc:sqlserver://projsofsge1.database.windows.net:1433;"
                        + "database=WebSof;"
                        + "user=SGE_@projsofsge1;"
                        + "password=Calebeodeiadualboot2020_;"
                        + "encrypt=true;"
                        + "trustServerCertificate=false;"
                        + "loginTimeout=30;";
        
        ResultSet resultSet ;
        //String sql="SELECT * FROM dbo.CEO WHERE email=? AND senha=? ;";
       
        try (Connection connection = DriverManager.getConnection(connectionUrl);
                PreparedStatement statement = connection.prepareStatement("SELECT email ,senha  FROM dbo.CEO WHERE email=? AND senha=? ;");) {
            
            // Create and execute a SELECT SQL statement.
            statement.setString(1, email);
            statement.setString(2, senha);
            
            resultSet=statement.executeQuery();
            
            //String s = resultSet.next().getString("email");
            if (resultSet.next() == false) {
               System.out.println("ResultSet in empty in Java");
               return false;
           } else {

              String s = resultSet.getString("email");
              if(s.equals("")){
                  return true;
              }
           }
      
            
            connection.close();
            return true;
            // Print results from select statement
               
        }
        catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        
    }
    
    public static void main(String[] args) {
        String nome="matheus";
        String email="1maumau@gmail.com";
        String empresa="super anime";
        String senha="eviil";
        System.out.println(validarEmail(email));
        Date data = Date.valueOf("1997-03-31");
        String tel="40028922";
        CEO c=new CEO();
        c.setNome(nome);
        c.setData(data);
        c.setEmpresa(empresa);
        c.setTelefone(tel);
        c.setSenha(senha);
        c.setEmail(email);
        
        //alterar(c);
        Inserir(c);
        //excluir(email);
        String connectionUrl =
                "jdbc:sqlserver://projsofsge1.database.windows.net:1433;"
                        + "database=WebSof;"
                        + "user=SGE_@projsofsge1;"
                        + "password=Calebeodeiadualboot2020_;"
                        + "encrypt=true;"
                        + "trustServerCertificate=false;"
                        + "loginTimeout=30;";
        
        ResultSet resultSet ;
     
        try (Connection connection = DriverManager.getConnection(connectionUrl);
                Statement statement = connection.createStatement();) {

            // Create and execute a SELECT SQL statement.
            String insertSql = "INSERT INTO dbo.CEO (nomeCeo,empresa,email ,senha,telefone,dataN) VALUES \n" + "("+"'"+nome+"'"+","+"'"+empresa+"'"+", "+"'"+email+"'"+", "+"'"+senha+"'"+","+"'"+tel+"'"+","+"'"+data+"'"+ ");" ;
            String selectSql = "SELECT * from dbo.CEO ";
            resultSet = statement.executeQuery(selectSql);
            if(resultSet==null){
            System.out.println("teste\n");
            }
            // Print results from select statement
           while (resultSet!=null&&resultSet.next()) {
               int i=1;
               while(i<7){}

                    System.out.print(resultSet.getString(i)+"    " );
                    i++;
                              System.out.print("\n" );
            }
           
            connection.close();   
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
};
    