package banco;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;

import dominio.CEO;
import dominio.Funcionario;
import dominio.Departamento;
import dominio.Projeto;
import dominio.Equipe;
import java.util.logging.Level;
import java.util.logging.Logger;


public class CEOBD  {
    // Connect to your database.
    // Replace server name, username, and password with your credentials
    public static void Inserir(CEO ceoNew){
        
        String connectionUrl =
               "jdbc:mysql://WEBSOFT.chlhdmd5beba.us-east-1.rds.amazonaws.com:3306/WEBSOFT?user=SGE&password=alebeodeiadualboot2020";
        
        
        int resultSet ;
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            try (Connection connection = DriverManager.getConnection(connectionUrl)) {
                PreparedStatement statement = connection.prepareStatement("INSERT INTO CEO (nomeCeo,empresa,email ,senha,telefone) VALUES(?,?,?,?,?)");
                statement.setString(1,ceoNew.getNome());
                statement.setString(2,ceoNew.getEmpresa());
                statement.setString(3,ceoNew.getEmail());
                statement.setString(4,ceoNew.getSenha());
                statement.setString(5,ceoNew.getTelefone());
                // Create and execute a SELECT SQL statement.
                resultSet=statement.executeUpdate();
                // Print results from select statement
            }   
        } catch (SQLException ex) {
            Logger.getLogger(CEOBD.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
    }
    public static void excluir(String email){
    String connectionUrl =
                "jdbc:mysql://WEBSOFT.chlhdmd5beba.us-east-1.rds.amazonaws.com:3306/WEBSOFT?user=SGE&password=alebeodeiadualboot2020";
        
        
        int resultSet ;
        
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        try (Connection connection = DriverManager.getConnection(connectionUrl);
            PreparedStatement statement = connection.prepareStatement("DELETE FROM CEO WHERE(email=?)");){
            // Create and execute a SELECT SQL statement.
            statement.setString(1, email);
            resultSet=statement.executeUpdate();
            // Print results from select statement
        }   
        }
       catch (SQLException ex) {
            Logger.getLogger(CEOBD.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    }
    public static void alterar_Senha_CEO(String email,String senhaV,String senhaN){
        String connectionUrl =
                "jdbc:mysql://WEBSOFT.chlhdmd5beba.us-east-1.rds.amazonaws.com:3306/WEBSOFT?user=SGE&password=alebeodeiadualboot2020";
        
        
        int resultSet ;
     
         try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            try (Connection connection = DriverManager.getConnection(connectionUrl);
                PreparedStatement statement = connection.prepareStatement("UPDATE CEO SET senha=? WHERE email=? AND senha=?;");){
                // Create and execute a SELECT SQL statement.
                statement.setString(1, senhaN);
                statement.setString(2, email);
                statement.setString(3, senhaV);
                resultSet=statement.executeUpdate();
                // Print results from select statement
            }   
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void alterar_Senha_Funcionario(String email,String senhaV,String senhaN){
        String connectionUrl =
                "jdbc:mysql://WEBSOFT.chlhdmd5beba.us-east-1.rds.amazonaws.com:3306/WEBSOFT?user=SGE&password=alebeodeiadualboot2020";
        
        
        int resultSet ;
     
         try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            try (Connection connection = DriverManager.getConnection(connectionUrl);
                PreparedStatement statement = connection.prepareStatement("UPDATE Funcionario SET senha=? WHERE email=? AND senha=?;");){
                // Create and execute a SELECT SQL statement.
                statement.setString(1, senhaN);
                statement.setString(2, email);
                statement.setString(3, senhaV);
                resultSet=statement.executeUpdate();
                // Print results from select statement
            }   
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static boolean validarEmail(String email){
        String connectionUrl =
                "jdbc:mysql://WEBSOFT.chlhdmd5beba.us-east-1.rds.amazonaws.com:3306/WEBSOFT?user=SGE&password=alebeodeiadualboot2020";
        
        
        ResultSet resultSet ;
        //String sql="SELECT * FROM dbo.CEO WHERE email=? AND senha=? ;";
       
         try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            try (Connection connection = DriverManager.getConnection(connectionUrl);
                PreparedStatement statement = connection.prepareStatement("select * FROM CEO c INNER JOIN Funcionario f on(c.empresa=f.empresa and (c.email=? or f.email=?))");) {
                
                // Create and execute a SELECT SQL statement.
                statement.setString(1, email);
                statement.setString(2, email);
                
                resultSet=statement.executeQuery();
                
                //String s = resultSet.next().getString("email");
                if (resultSet.next() == false) {
                    System.out.println("ResultSet in empty in Java");
                    return false;
                } else {
                    
                    //String s = resultSet.getString("email");
                    return true ;
                }}
            
            // Print results from select statement
               
        }
        catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    
    }
    public static CEO procurarPorLoginSenha(String email, String senha){
        String connectionUrl =
                "jdbc:mysql://WEBSOFT.chlhdmd5beba.us-east-1.rds.amazonaws.com:3306/WEBSOFT?user=SGE&password=alebeodeiadualboot2020";
        
        ResultSet resultSet ;
        //String sql="SELECT * FROM dbo.CEO WHERE email=? AND senha=? ;";
       
         try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            CEO ceo_novo;
            try (Connection connection = DriverManager.getConnection(connectionUrl);
                PreparedStatement statement = connection.prepareStatement("SELECT *  FROM CEO WHERE email=? AND senha=? ;");) {
                // Create and execute a SELECT SQL statement.
                statement.setString(1, email);
                statement.setString(2, senha);
                ceo_novo = new CEO();
                resultSet=statement.executeQuery();
                //String s = resultSet.next().getString("email");
                if (resultSet.next() == false) {
                    System.out.println("ResultSet in empty in Java");
                    return null;
                } else {
                    ceo_novo.setEmpresa(resultSet.getString("empresa"));
                    ceo_novo.setEmail(resultSet.getString("email"));
                    ceo_novo.setNome(resultSet.getString("nomeCeo"));
                    
                    
                }}
            return ceo_novo;
            // Print results from select statement
               
        }
        catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        
    }
    public static String procurarCodDep(String nomeD,String empresa){
        String connectionUrl =
                "jdbc:mysql://WEBSOFT.chlhdmd5beba.us-east-1.rds.amazonaws.com:3306/WEBSOFT?user=SGE&password=alebeodeiadualboot2020";
        
        ResultSet resultSet ;
        try {
            //String sql="SELECT * FROM dbo.CEO WHERE email=? AND senha=? ;";
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            Connection connection = DriverManager.getConnection(connectionUrl);
            PreparedStatement statement = connection.prepareStatement("SELECT ID  FROM Departamento WHERE nomeD=? AND empresa=? ;");
            
            // Create and execute a SELECT SQL statement.
            statement.setString(1, nomeD);
            statement.setString(2, empresa);
            String ID_departamento;
            resultSet=statement.executeQuery();
            
            //String s = resultSet.next().getString("email");
            if (resultSet.next() == false) {
               System.out.println("ResultSet in empty in Java");
               connection.close();
               return null;
           } else {
                ID_departamento=resultSet.getString(1);
                connection.close();
                return ID_departamento;
           }
      
        
            
            // Print results from select statement
               
        }
        catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
     
               
      
    }
    public static void Cadastrar_Funcionario(Funcionario novo){
        String connectionUrl =
                "jdbc:mysql://WEBSOFT.chlhdmd5beba.us-east-1.rds.amazonaws.com:3306/WEBSOFT?user=SGE&password=alebeodeiadualboot2020";
        
        int resultSet ;
        try {
            //String sql="SELECT * FROM dbo.CEO WHERE email=? AND senha=? ;";
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
           Connection connection = DriverManager.getConnection(connectionUrl);
           PreparedStatement statement = connection.prepareStatement("insert into Funcionario"
                        +" (nomeF,senha,email,RG,Status_gerente,ID_departamento,empresa) values(?,?,?,?,?,?,?)");
            statement.setString(1,novo.getNome());
            statement.setString(2,"123456");
            statement.setString(3,novo.getEmail());
            statement.setString(4,novo.getRG());
            if(novo.isStatus_GERENTE()){
                statement.setString(5,"Gerente");
            }
            else{
               statement.setString(5,"Funcionario");
            }
            statement.setString(6,novo.getID_departamento());
            statement.setString(7,novo.getEmpresa());
            resultSet=statement.executeUpdate();
                
    }    
    catch (SQLException e) {
            e.printStackTrace();
        }
    }  
    public static void Cadastrar_Departamento(Departamento novo){
    String connectionUrl =
                "jdbc:mysql://WEBSOFT.chlhdmd5beba.us-east-1.rds.amazonaws.com:3306/WEBSOFT?user=SGE&password=alebeodeiadualboot2020";
        
        int resultSet ;
        try {
            //String sql="SELECT * FROM dbo.CEO WHERE email=? AND senha=? ;";
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            Connection connection = DriverManager.getConnection(connectionUrl);
                PreparedStatement statement = connection.prepareStatement("insert into Departamento\n" +
"(nomeD,empresa,ID,coordenador) values(?,?,?,?)");
            statement.setString(1,novo.getNome());
            statement.setString(2,novo.getEmpresa());
            statement.setString(3,novo.getID());
            statement.setString(4,novo.getCoodenador());
             resultSet=statement.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    
    }
    public static void Criar_Equipe(Equipe equipe){
        String connectionUrl =
                "jdbc:mysql://WEBSOFT.chlhdmd5beba.us-east-1.rds.amazonaws.com:3306/WEBSOFT?user=SGE&password=alebeodeiadualboot2020";
        
        int resultSet ;
        try {
            //String sql="SELECT * FROM dbo.CEO WHERE email=? AND senha=? ;";
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            Connection connection = DriverManager.getConnection(connectionUrl);
                PreparedStatement statement = connection.prepareStatement(" insert into Equipe\n" +
"(ID,ID_departamento,nomeE)values(?,?,?)");
            statement.setString(1,null);
            statement.setString(2,equipe.getID_departamento());
            statement.setString(3,equipe.getNome());
            
             resultSet=statement.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        
        
    }
    public static int ProcurarID_Equipe(String nomeE,String ID_departamento){
    String connectionUrl =
                "jdbc:mysql://WEBSOFT.chlhdmd5beba.us-east-1.rds.amazonaws.com:3306/WEBSOFT?user=SGE&password=alebeodeiadualboot2020";
        int id;
        ResultSet resultSet ;
        //String sql="SELECT * FROM dbo.CEO WHERE email=? AND senha=? ;";
       
        try (Connection connection = DriverManager.getConnection(connectionUrl);
                PreparedStatement statement = connection.prepareStatement("select ID FROM Equipe where nomeE=? AND ID_Departamento=? ");) {
            statement.setString(1,nomeE);
            statement.setString(2,ID_departamento);
            resultSet=statement.executeQuery();
            if (resultSet.next() == false) {
               System.out.println("ResultSet in empty in Java");
               connection.close();
               return -1;
           } else {
                
                id=resultSet.getInt(1);
                connection.close();
                return id;
              
           }
        }   
        catch (SQLException e) {
            e.printStackTrace();
           return -1;
        }
        
}
    public static void Atribuir_Funcionario_Equipe(Funcionario fun,Equipe equipe){
        if(fun.getID_departamento().equals(equipe.getID_departamento())){
             String connectionUrl =
                "jdbc:mysql://WEBSOFT.chlhdmd5beba.us-east-1.rds.amazonaws.com:3306/WEBSOFT?user=SGE&password=alebeodeiadualboot2020";
        
        int resultSet ;
            try {
                //String sql="SELECT * FROM dbo.CEO WHERE email=? AND senha=? ;";
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            Connection connection = DriverManager.getConnection(connectionUrl);
                PreparedStatement statement = connection.prepareStatement(" insert into Funcionario_Equipe\n" +
"(ID,ID_departamento,ID_Equipe,email_Funcionario) values(?,?,?,?);");
            statement.setString(1,null);
            statement.setString(2,fun.getID_departamento());
            statement.setInt(3,equipe.getID());
            statement.setString(4,fun.getEmail());
            resultSet=statement.executeUpdate();
        }
         catch (SQLException e) {
            e.printStackTrace();
        }
        }
    
    }
    public static void Criar_Projeto(Projeto p){
        String connectionUrl =
                "jdbc:mysql://WEBSOFT.chlhdmd5beba.us-east-1.rds.amazonaws.com:3306/WEBSOFT?user=SGE&password=alebeodeiadualboot2020";
        
        int resultSet ;
        try {
            //String sql="SELECT * FROM dbo.CEO WHERE email=? AND senha=? ;";
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        Connection connection = DriverManager.getConnection(connectionUrl);
                PreparedStatement statement = connection.prepareStatement(" insert into Projeto\n" +
"(ID,ID_departamento,Criacao,nomeE) values(?,?,CURDATE( ),?);");
            statement.setString(1,null);
            statement.setString(2,p.getID_Departamento());
            
            statement.setString(3,p.getNome());
            resultSet=statement.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static int  ProcurarIDProjeto(String nomeP,String ID_departamento){
        String connectionUrl =
                "jdbc:mysql://WEBSOFT.chlhdmd5beba.us-east-1.rds.amazonaws.com:3306/WEBSOFT?user=SGE&password=alebeodeiadualboot2020";
        
        ResultSet resultSet ;
        try {
            //String sql="SELECT * FROM dbo.CEO WHERE email=? AND senha=? ;";
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        Connection connection = DriverManager.getConnection(connectionUrl);
                PreparedStatement statement = connection.prepareStatement("SELECT ID  FROM Projeto WHERE nomeE=? AND ID_departamento=? ;");
            
            // Create and execute a SELECT SQL statement.
            statement.setString(1, nomeP);
            statement.setString(2, ID_departamento);
            resultSet=statement.executeQuery();
            int id;
            //String s = resultSet.next().getString("email");
            if (resultSet.next() == false) {
               System.out.println("ResultSet in empty in Java");
               connection.close();
               return -1;
           } else {
                id=resultSet.getInt(1);
                connection.close();
                return id;
           }
      
        
            
            // Print results from select statement
               
        }
        catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
     
    }
    public static void Atribuir_Projeto_Equipe(Projeto p,Equipe e){
    if(p.getID_Departamento().equals(e.getID_departamento())){
             String connectionUrl =
                "jdbc:mysql://WEBSOFT.chlhdmd5beba.us-east-1.rds.amazonaws.com:3306/WEBSOFT?user=SGE&password=alebeodeiadualboot2020";
        
        int resultSet ;
        try {
            //String sql="SELECT * FROM dbo.CEO WHERE email=? AND senha=? ;";
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        Connection connection = DriverManager.getConnection(connectionUrl);
                PreparedStatement statement = connection.prepareStatement(" insert into Projeto_Equipe\n" +
"(ID,ID_Equipe,ID_departamento,ID_projeto) values(?,?,?,?);");
            statement.setString(1,null);
            statement.setInt(2,e.getID());
            statement.setString(3,p.getID_Departamento());
            statement.setInt(4,p.getId());
            resultSet=statement.executeUpdate();
        }
         catch (SQLException ex) {
            ex.printStackTrace();
         }
    }
    
    }
    public static void Atribuir_Tarefa_Projeto(int ID_Projeto,String Tarefa){
        String connectionUrl =
                "jdbc:mysql://WEBSOFT.chlhdmd5beba.us-east-1.rds.amazonaws.com:3306/WEBSOFT?user=SGE&password=alebeodeiadualboot2020";
        
        int resultSet ;
        try {
            //String sql="SELECT * FROM dbo.CEO WHERE email=? AND senha=? ;";
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        Connection connection = DriverManager.getConnection(connectionUrl);
                PreparedStatement statement = connection.prepareStatement(" insert into Tarefa\n" +
"(ID,ID_projeto,nomeT) VALUES(?,?,?)");
            statement.setString(1,null);
            statement.setInt(2,ID_Projeto);
            statement.setString(3,Tarefa);
            resultSet=statement.executeUpdate();
            
        }
        catch (SQLException e) {
            e.printStackTrace();
         }
        
    }
    public static Funcionario ProcurarFuncionario(String email,String senha){
       String connectionUrl =
                "jdbc:mysql://WEBSOFT.chlhdmd5beba.us-east-1.rds.amazonaws.com:3306/WEBSOFT?user=SGE&password=alebeodeiadualboot2020";
        
        ResultSet resultSet ;
        try {
            //String sql="SELECT * FROM dbo.CEO WHERE email=? AND senha=? ;";
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        Connection connection = DriverManager.getConnection(connectionUrl);
        PreparedStatement statement = connection.prepareStatement("SELECT *  FROM Funcionario WHERE email=? AND senha=? ;");
            
            // Create and execute a SELECT SQL statement.
            statement.setString(1, email);
            statement.setString(2, senha);
            Funcionario fun= new Funcionario();
            resultSet=statement.executeQuery();
            
            //String s = resultSet.next().getString("email");
            if (resultSet.next() == false) {
               System.out.println("ResultSet in empty in Java");
               connection.close();
               return null;
           } else {
              fun.setEmpresa(resultSet.getString("empresa"));
              fun.setEmail(resultSet.getString("email")); 
              fun.setNome(resultSet.getString("nomeF"));
              fun.setID_departamento(resultSet.getString("ID_departamento"));
              if("Gerente".equals(resultSet.getString("Status_Gerente"))){
                  fun.setStatus_GERENTE(true);
              }
              else{
                fun.setStatus_GERENTE(false);
              }
              connection.close();
              return fun;
              
           }
      
            
            
            // Print results from select statement
               
        }
        catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
   }
    public static void Deletar_Departamento(String id){
        String connectionUrl =
                "jdbc:mysql://WEBSOFT.chlhdmd5beba.us-east-1.rds.amazonaws.com:3306/WEBSOFT?user=SGE&password=alebeodeiadualboot2020";
        
        ResultSet resultSet ;
        
       
       try {
            //String sql="SELECT * FROM dbo.CEO WHERE email=? AND senha=? ;";
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        Connection connection = DriverManager.getConnection(connectionUrl);
                PreparedStatement statement = connection.prepareStatement(" select ID from Projeto where(ID_departamento=?);");
            statement.setString(1, id);
            resultSet=statement.executeQuery();
            while(resultSet.next()){
                Deletar_Projeto(resultSet.getInt(1));
                
            }
            statement = connection.prepareStatement(" select ID from Equipe where(ID_Departamento=?);");
            statement.setString(1, id);
            resultSet=statement.executeQuery();
            while(resultSet.next()){
              
                Deletar_Equipe(resultSet.getInt(1));
            }
            statement = connection.prepareStatement(" select email from Funcionario where(ID_Departamento=?);");
            statement.setString(1, id);
            resultSet=statement.executeQuery();
            while(resultSet.next()){
              
                Deletar_Funcionario(resultSet.getString(1));
            }
            PreparedStatement statement2 = connection.prepareStatement("DELETE FROM Departamento where ID=?");
            statement2.setString(1, id);
            int result=statement2.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void Deletar_Tarefa(int ID){
        String connectionUrl =
                "jdbc:mysql://WEBSOFT.chlhdmd5beba.us-east-1.rds.amazonaws.com:3306/WEBSOFT?user=SGE&password=alebeodeiadualboot2020";
        
        int resultSet ;
        
       
        try (Connection connection = DriverManager.getConnection(connectionUrl);
                PreparedStatement statement = connection.prepareStatement(" delete from Tarefa where (ID=?);");) {
            statement.setInt(1, ID);
            resultSet=statement.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void Deletar_Projeto_Equipe(int ID){
        String connectionUrl =
                "jdbc:mysql://WEBSOFT.chlhdmd5beba.us-east-1.rds.amazonaws.com:3306/WEBSOFT?user=SGE&password=alebeodeiadualboot2020";
        
        int resultSet ;
        
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        Connection connection = DriverManager.getConnection(connectionUrl);
                PreparedStatement statement = connection.prepareStatement(" delete from Projeto_Equipe where (ID=?);");
            statement.setInt(1, ID);
            resultSet=statement.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void Deletar_Projeto(int id){
        String connectionUrl =
                "jdbc:mysql://WEBSOFT.chlhdmd5beba.us-east-1.rds.amazonaws.com:3306/WEBSOFT?user=SGE&password=alebeodeiadualboot2020";
        
        ResultSet resultSet ;
        
       
       try {
            //String sql="SELECT * FROM dbo.CEO WHERE email=? AND senha=? ;";
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        Connection connection = DriverManager.getConnection(connectionUrl);
                PreparedStatement statement = connection.prepareStatement(" select ID from Projeto_Equipe where(ID_projeto=?);");
            statement.setInt(1, id);
            resultSet=statement.executeQuery();
            while(resultSet.next()){
                Deletar_Projeto_Equipe(resultSet.getInt(1));
                
            }
            statement = connection.prepareStatement(" select ID from Tarefa where(ID_projeto=?);");
            statement.setInt(1, id);
            resultSet=statement.executeQuery();
            while(resultSet.next()){
              
                Deletar_Tarefa(resultSet.getInt(1));
            }
            PreparedStatement statement2 = connection.prepareStatement("DELETE FROM Projeto where ID=?");
            statement2.setInt(1, id);
            int result=statement2.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void Deletar_Equipe(int id){
        String connectionUrl =
                "jdbc:mysql://WEBSOFT.chlhdmd5beba.us-east-1.rds.amazonaws.com:3306/WEBSOFT?user=SGE&password=alebeodeiadualboot2020";
        
        ResultSet resultSet ;
        
       
       try {
            //String sql="SELECT * FROM dbo.CEO WHERE email=? AND senha=? ;";
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        Connection connection = DriverManager.getConnection(connectionUrl);
                PreparedStatement statement = connection.prepareStatement(" select ID from Projeto_Equipe WHERE ID_Equipe=?;");
            statement.setInt(1, id);
            resultSet=statement.executeQuery();
            while(resultSet.next()){
                Deletar_Projeto_Equipe(resultSet.getInt(1));
                
            }
            statement = connection.prepareStatement(" select ID from Funcionario_Equipe WHERE ID_Equipe=?;");
            statement.setInt(1, id);
            resultSet=statement.executeQuery();
            while(resultSet.next()){
                
                Deletar_Funcionario_Equipe(resultSet.getInt(1));
            }
            PreparedStatement statement2 = connection.prepareStatement("DELETE FROM Equipe where ID=?");
            statement2.setInt(1, id);
            int result=statement2.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static int ProcurarIDTarefa(String tarefa,int id_projeto){
        String connectionUrl =
                "jdbc:mysql://WEBSOFT.chlhdmd5beba.us-east-1.rds.amazonaws.com:3306/WEBSOFT?user=SGE&password=alebeodeiadualboot2020";
        
        ResultSet resultSet ;
        
       
       try {
            //String sql="SELECT * FROM dbo.CEO WHERE email=? AND senha=? ;";
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        Connection connection = DriverManager.getConnection(connectionUrl);
                PreparedStatement statement = connection.prepareStatement(" select ID from Tarefa where ID_projeto=? and nomeT=?;");
                statement.setInt(1, id_projeto);
                statement.setString(2, tarefa);
                int id;
                resultSet=statement.executeQuery();
            if (resultSet.next() == false) {
               System.out.println("ResultSet in empty in Java");
               connection.close();
               return -1;
           } else {
                
                id=resultSet.getInt(1);
                connection.close();
                return id;
              
           }
       }
        catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }
    public static void Deletar_Funcionario_Equipe(int ID){
        String connectionUrl =
                "jdbc:mysql://WEBSOFT.chlhdmd5beba.us-east-1.rds.amazonaws.com:3306/WEBSOFT?user=SGE&password=alebeodeiadualboot2020";
        
        int resultSet ;
        
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        Connection connection = DriverManager.getConnection(connectionUrl);
                PreparedStatement statement;
            statement = connection.prepareStatement(" delete from Funcionario_Equipe where (ID=?);");
            statement.setInt(1, ID);
            resultSet=statement.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void Deletar_Funcionario(String email){
        String connectionUrl =
                "jdbc:mysql://WEBSOFT.chlhdmd5beba.us-east-1.rds.amazonaws.com:3306/WEBSOFT?user=SGE&password=alebeodeiadualboot2020";
        
        ResultSet resultSet ;
        
       
       try {
            //String sql="SELECT * FROM dbo.CEO WHERE email=? AND senha=? ;";
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        Connection connection = DriverManager.getConnection(connectionUrl);
                PreparedStatement statement = connection.prepareStatement(" select ID from Funcionario_Equipe WHERE email_Funcionario=?;");
            statement.setString(1, email);
            resultSet=statement.executeQuery();
            while(resultSet.next()){
                
                Deletar_Funcionario_Equipe(resultSet.getInt(1));
            }
            PreparedStatement statement2 = connection.prepareStatement("DELETE FROM Funcionario where email=?");
            statement2.setString(1, email);
            int result=statement2.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void Deletar_Funcionario_Empresa(String email,String empresa){
        String connectionUrl =
                "jdbc:mysql://WEBSOFT.chlhdmd5beba.us-east-1.rds.amazonaws.com:3306/WEBSOFT?user=SGE&password=alebeodeiadualboot2020";
        
        ResultSet resultSet ;
        
       
       try {
            //String sql="SELECT * FROM dbo.CEO WHERE email=? AND senha=? ;";
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        Connection connection = DriverManager.getConnection(connectionUrl);
                PreparedStatement statement = connection.prepareStatement(" select email from Funcionario WHERE email=? and empresa=?;");
            statement.setString(1, email);
            statement.setString(2, empresa);
            resultSet=statement.executeQuery();
            while(resultSet.next()){
                
                Deletar_Funcionario(resultSet.getString(1));
            }
           
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void Deletar_Funcionario_Departamento(String email,String id_dep){
        String connectionUrl =
                "jdbc:mysql://WEBSOFT.chlhdmd5beba.us-east-1.rds.amazonaws.com:3306/WEBSOFT?user=SGE&password=alebeodeiadualboot2020";
        
        ResultSet resultSet ;
        
       
       try {
            //String sql="SELECT * FROM dbo.CEO WHERE email=? AND senha=? ;";
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        Connection connection = DriverManager.getConnection(connectionUrl);
                PreparedStatement statement = connection.prepareStatement(" select ID from Funcionario_Equipe WHERE email_Funcionario=? and  ID_departamento=?;");
            statement.setString(1, email);
           
            statement.setString(2, id_dep);
            resultSet=statement.executeQuery();
            while(resultSet.next()){
                
                Deletar_Funcionario_Equipe(resultSet.getInt(1));
            }
            PreparedStatement statement2 = connection.prepareStatement("DELETE FROM Funcionario where email=?");
            statement2.setString(1, email);
            int result=statement2.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        String nome="edy",Rg="23434354";
        boolean gerente=true;
        String email="didi@gmail1.com";
        String empresa="nettttflix";
        String senha="12345",Depp="anime";
        System.out.println("EXISTE="+validarEmail(email));
        Date data = Date.valueOf("1997-03-31");
        String tel="4002--8921";
        String nomeD="series",ID_dep="122",cood="edu";
        Departamento dep=new Departamento();
        Equipe e=new Equipe();
        e.setID_departamento(ID_dep);
        e.setNome("animação");
        //Criar_Equipe(e);
        e.setID(5);
        dep.setCoodenador(cood);
        dep.setEmpresa(empresa);
        dep.setID(ID_dep);
        dep.setNome(nomeD);
        Deletar_Funcionario_Departamento("bibi@gmail.com","1111");
        //Deletar_Funcionario_Empresa("BBB@BB.COM","super anime");
        //Deletar_Departamento("1");
        //Deletar_Funcionario("111@aa.com");
        //Deletar_Equipe(6);
        //Deletar_Funcionario_Equipe(5);
        //Deletar_Projeto(15);
        //Cadastrar_Departamento(dep);
        Funcionario fun=new Funcionario();
        fun.setDepartamento(dep);
        fun.setID_departamento(ID_dep);
        fun.setEmail(email);
        fun.setEmpresa(empresa);
        fun.setStatus_GERENTE(gerente);
        fun.setNome(nome);
        fun.setRG(Rg);
        //Atribuir_Funcionario_Equipe(fun,e);
        //Cadastrar_Funcionario(fun);
        Projeto p=new Projeto();
        String nomeP="BANCO DE DADOS";
        p.setNome(nomeP);
        p.setPrazoD(data);
        p.setID_Departamento(ID_dep);
        //Criar_Projeto(p);
        p.setId(ProcurarIDProjeto(p.getNome(),p.getID_Departamento()));
        //Atribuir_Projeto_Equipe(p,e);
        String Tarefa="fazer banco";
        //Atribuir_Tarefa_Projeto(p.getId(),Tarefa);
        System.out.println(ProcurarFuncionario("didi@gmail.com","123456").getEmpresa());
        CEO c=new CEO();
        c.setNome(nome);
        c.setEmpresa(empresa);
        c.setTelefone(tel);
        c.setSenha(senha);
        c.setEmail(email);
        //Inserir(c);
        //alterar(c);
        //Inserir(c);
        //excluir(email);*/
        //alterar_Senha_CEO("gomes@gmail.com","12345","1234567");
        //alterar_Senha_Funcionario("didi@gmail.com","123456","duedu");
        System.out.println(ProcurarIDTarefa("exemplo",6)); 
        //Deletar_Tarefa(5);
        String connectionUrl =
                "jdbc:mysql://WEBSOFT.chlhdmd5beba.us-east-1.rds.amazonaws.com:3306/WEBSOFT?user=SGE&password=alebeodeiadualboot2020";
        
        ResultSet resultSet ;
   
        try (Connection connection = DriverManager.getConnection(connectionUrl);
                Statement statement = connection.createStatement();) {

            // Create and execute a SELECT SQL statement.
            String insertSql = "INSERT INTO CEO (nomeCeo,empresa,email ,senha,telefone,dataN) VALUES \n" + "("+"'"+nome+"'"+","+"'"+empresa+"'"+", "+"'"+email+"'"+", "+"'"+senha+"'"+","+"'"+tel+"'"+","+"'"+data+"'"+ ");" ;
            String selectSql = "SELECT * from CEO ";
            //statement.executeUpdate(insertSql);
            resultSet=statement.executeQuery(selectSql);
            if(resultSet!=null){
           System.out.println("teste\n");
            //}
            // Print results from select statement
           while (resultSet!=null&&resultSet.next()) {
               int i=1;
               while(i<6){
                    System.out.print(resultSet.getString(i)+"    " );
                    i++;
                    
               }
               System.out.print("\n" );
            }
           
            connection.close();   
        }
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
};
    