package banco;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import dominio.Mensagens;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
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
    public static boolean Inserir(CEO ceoNew){
        
        String connectionUrl =
               "jdbc:mysql://WEBSOFT.chlhdmd5beba.us-east-1.rds.amazonaws.com:3306/WEBSOFT?user=SGE&password=alebeodeiadualboot2020";
        
        
        int resultSet ;
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            Connection connection = DriverManager.getConnection(connectionUrl);
                PreparedStatement statement = connection.prepareStatement("INSERT INTO CEO (nomeCeo,empresa,email ,senha,telefone) VALUES(?,?,?,?,?)");
                statement.setString(1,ceoNew.getNome());
                statement.setString(2,ceoNew.getEmpresa());
                statement.setString(3,ceoNew.getEmail());
                statement.setString(4,ceoNew.getSenha());
                statement.setString(5,ceoNew.getTelefone());
                // Create and execute a SELECT SQL statement.
                resultSet=statement.executeUpdate();
                // Print results from select statement
                return true;
              
        } catch (SQLException ex) {
            Logger.getLogger(CEOBD.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
    }
    public static boolean  excluir(String email){
    String connectionUrl =
                "jdbc:mysql://WEBSOFT.chlhdmd5beba.us-east-1.rds.amazonaws.com:3306/WEBSOFT?user=SGE&password=alebeodeiadualboot2020";
        
        
        int resultSet ;
        
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            Connection connection = DriverManager.getConnection(connectionUrl);
            PreparedStatement statement = connection.prepareStatement("DELETE FROM CEO WHERE(email=?)");
            // Create and execute a SELECT SQL statement.
            statement.setString(1, email);
            resultSet=statement.executeUpdate();
            // Print results from select statement
            return true;
  
        }
       catch (SQLException ex) {
            Logger.getLogger(CEOBD.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    public static boolean  alterar_Senha_CEO(String email,String senhaV,String senhaN){
        String connectionUrl =
                "jdbc:mysql://WEBSOFT.chlhdmd5beba.us-east-1.rds.amazonaws.com:3306/WEBSOFT?user=SGE&password=alebeodeiadualboot2020";
        
        
        int resultSet ;
     
         try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            Connection connection = DriverManager.getConnection(connectionUrl);
                PreparedStatement statement = connection.prepareStatement("UPDATE CEO SET senha=? WHERE email=? AND senha=?;");
                // Create and execute a SELECT SQL statement.
                statement.setString(1, senhaN);
                statement.setString(2, email);
                statement.setString(3, senhaV);
                resultSet=statement.executeUpdate();
                // Print results from select statement
                return true; 
        }
        catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public static boolean  alterar_Senha_Funcionario(String email,String senhaV,String senhaN){
        String connectionUrl =
                "jdbc:mysql://WEBSOFT.chlhdmd5beba.us-east-1.rds.amazonaws.com:3306/WEBSOFT?user=SGE&password=alebeodeiadualboot2020";
        
        
        int resultSet ;
     
         try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            Connection connection = DriverManager.getConnection(connectionUrl);
                PreparedStatement statement = connection.prepareStatement("UPDATE Funcionario SET senha=? WHERE email=? AND senha=?;");
                // Create and execute a SELECT SQL statement.
                statement.setString(1, senhaN);
                statement.setString(2, email);
                statement.setString(3, senhaV);
                resultSet=statement.executeUpdate();
                // Print results from select statement
                return true;
    
        }
        catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public static boolean validarEmail(String email){
        String connectionUrl =
                "jdbc:mysql://WEBSOFT.chlhdmd5beba.us-east-1.rds.amazonaws.com:3306/WEBSOFT?user=SGE&password=alebeodeiadualboot2020";
        
        
        ResultSet resultSet ;
        //String sql="SELECT * FROM dbo.CEO WHERE email=? AND senha=? ;";
       
         try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            Connection connection = DriverManager.getConnection(connectionUrl);
                PreparedStatement statement = connection.prepareStatement("select * FROM CEO c INNER JOIN Funcionario f on(c.empresa=f.empresa and (c.email=? or f.email=?))");
                
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
            Connection connection = DriverManager.getConnection(connectionUrl);
                PreparedStatement statement = connection.prepareStatement("SELECT *  FROM CEO WHERE email=? AND senha=? ;");
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
                    
                    
                }
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
    public static boolean  Cadastrar_Funcionario(Funcionario novo){
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
            return true;
                
    }    
    catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }  
    public static boolean  Cadastrar_Departamento(Departamento novo){
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
             return true;
        }
        catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    
    }
    public static boolean  Criar_Equipe(Equipe equipe){
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
             return true;
        }
        catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        
        
    }
    public static int ProcurarID_Equipe(String nomeE,String ID_departamento){
    String connectionUrl =
                "jdbc:mysql://WEBSOFT.chlhdmd5beba.us-east-1.rds.amazonaws.com:3306/WEBSOFT?user=SGE&password=alebeodeiadualboot2020";
        int id;
        ResultSet resultSet ;
        //String sql="SELECT * FROM dbo.CEO WHERE email=? AND senha=? ;";
       
        try{
            Connection connection = DriverManager.getConnection(connectionUrl);
            PreparedStatement statement = connection.prepareStatement("select ID FROM Equipe where nomeE=? AND ID_Departamento=? ");
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
    public static boolean  Atribuir_Funcionario_Equipe(Funcionario fun,Equipe equipe){
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
            return true;
        }
         catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        }
        else{
            return false;
        }
    
    }
    public static boolean  Criar_Projeto(Projeto p){
        String connectionUrl =
                "jdbc:mysql://WEBSOFT.chlhdmd5beba.us-east-1.rds.amazonaws.com:3306/WEBSOFT?user=SGE&password=alebeodeiadualboot2020";
        
        int resultSet ;
        try {
            //String sql="SELECT * FROM dbo.CEO WHERE email=? AND senha=? ;";
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        Connection connection = DriverManager.getConnection(connectionUrl);
                PreparedStatement statement = connection.prepareStatement(" insert into Projeto\n" +
"(ID,ID_departamento,Criacao,nomeE,statusP) values(?,?,CURDATE( ),?,'Ativo');");
            statement.setString(1,null);
            statement.setString(2,p.getID_Departamento());
            
            statement.setString(3,p.getNome());
            resultSet=statement.executeUpdate();
            return true;
        }
        catch (SQLException e) {
            e.printStackTrace();
            return false;
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
    public static boolean Status_proj(int id_proj){
        boolean status=false;
        String connectionUrl =
                "jdbc:mysql://WEBSOFT.chlhdmd5beba.us-east-1.rds.amazonaws.com:3306/WEBSOFT?user=SGE&password=alebeodeiadualboot2020";
        
        ResultSet resultSet ;
        
       
       try {
            //String sql="SELECT * FROM dbo.CEO WHERE email=? AND senha=? ;";
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        Connection connection = DriverManager.getConnection(connectionUrl);
                PreparedStatement statement = connection.prepareStatement(" select * from Projeto where ID=? and statusP='Ativo';");
                statement.setInt(1, id_proj);
                
                int id;
                resultSet=statement.executeQuery();
            if (resultSet.next() == false) {
               status=false;
               connection.close();
               
           } else {
                
                status=true;
                connection.close();
                
              
           }
       }
        catch (SQLException e) {
            e.printStackTrace();
            
        }
     return status;
    }
    public static boolean  Atribuir_Projeto_Equipe(Projeto p,Equipe e){
    if(p.getID_Departamento().equals(e.getID_departamento())||Status_proj(p.getId())){
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
            return true;
        }
         catch (SQLException ex) {
            ex.printStackTrace();
            return false;
         }
    }
    else{
        return false;
    }
    }
    public static boolean  Atribuir_Tarefa_Projeto(int ID_Projeto,String Tarefa){
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
            return true;
            
        }
        catch (SQLException e) {
            e.printStackTrace();
            return false;
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
    public static boolean  Deletar_Departamento(String id){
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
            return true;
        }
        catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public static boolean  Deletar_Tarefa(int ID){
        String connectionUrl =
                "jdbc:mysql://WEBSOFT.chlhdmd5beba.us-east-1.rds.amazonaws.com:3306/WEBSOFT?user=SGE&password=alebeodeiadualboot2020";
        
        int resultSet ;
        
       
        try{
            Connection connection = DriverManager.getConnection(connectionUrl);
            PreparedStatement statement = connection.prepareStatement(" delete from Tarefa where (ID=?);");
            statement.setInt(1, ID);
            resultSet=statement.executeUpdate();
            return true;
        }
        catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public static boolean  Deletar_Projeto_Equipe(int ID){
        String connectionUrl =
                "jdbc:mysql://WEBSOFT.chlhdmd5beba.us-east-1.rds.amazonaws.com:3306/WEBSOFT?user=SGE&password=alebeodeiadualboot2020";
        
        int resultSet ;
        
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        Connection connection = DriverManager.getConnection(connectionUrl);
                PreparedStatement statement = connection.prepareStatement(" delete from Projeto_Equipe where (ID=?);");
            statement.setInt(1, ID);
            resultSet=statement.executeUpdate();
            return true;
        }
        catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public static boolean  Deletar_Projeto(int id){
        String connectionUrl =
                "jdbc:mysql://WEBSOFT.chlhdmd5beba.us-east-1.rds.amazonaws.com:3306/WEBSOFT?user=SGE&password=alebeodeiadualboot2020";
        
        ResultSet resultSet ;
        
       Deletar_Mensagens(id);
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
            return true;
        }
        catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public static boolean  Deletar_Equipe(int id){
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
            return true;
        }
        catch (SQLException e) {
            e.printStackTrace();
            return false;
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
    public static boolean  Deletar_Funcionario_Equipe(int ID){
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
            return true;
        }
        catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public static boolean Deletar_Funcionario(String email){
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
                
                if(!Deletar_Funcionario_Equipe(resultSet.getInt(1))){
                    return false;
                }
            }
            PreparedStatement statement2 = connection.prepareStatement("DELETE FROM Funcionario where email=?");
            statement2.setString(1, email);
            int result=statement2.executeUpdate();
            return true;
        }
        catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public static boolean Deletar_Funcionario_Empresa(String email,String empresa){
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
                
                if(Deletar_Funcionario(resultSet.getString(1))){
                    return false;
                }
            }
           return true;
        }
        catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public static boolean Deletar_Funcionario_Departamento(String email,String id_dep){
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
            return true;
        }
        catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public static ArrayList<Departamento> listar_Departamento(String empresa){
        ArrayList<Departamento>deps=new ArrayList<Departamento>();
         String connectionUrl =
                "jdbc:mysql://WEBSOFT.chlhdmd5beba.us-east-1.rds.amazonaws.com:3306/WEBSOFT?user=SGE&password=alebeodeiadualboot2020";
        
        ResultSet resultSet ;
        
       
       try {
            //String sql="SELECT * FROM dbo.CEO WHERE email=? AND senha=? ;";
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        Connection connection = DriverManager.getConnection(connectionUrl);
                PreparedStatement statement = connection.prepareStatement(" select * from Departamento WHERE empresa=? ;");
            statement.setString(1, empresa);
           
           
            resultSet=statement.executeQuery();
            
            while(resultSet.next()){
                Departamento dep=new Departamento();
                dep.setID(resultSet.getString("ID"));
                dep.setNome(resultSet.getString("nomeD"));
                deps.add(dep);
            }
       }
            catch (SQLException e) {
            e.printStackTrace();
            
        }
        return deps;
        
}
    public static ArrayList<Equipe> listar_equipes(String id){
        ArrayList<Equipe> eqps=new ArrayList<Equipe>();
         String connectionUrl =
                "jdbc:mysql://WEBSOFT.chlhdmd5beba.us-east-1.rds.amazonaws.com:3306/WEBSOFT?user=SGE&password=alebeodeiadualboot2020";
        
        ResultSet resultSet ;
        
       
       try {
            //String sql="SELECT * FROM dbo.CEO WHERE email=? AND senha=? ;";
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        Connection connection = DriverManager.getConnection(connectionUrl);
                PreparedStatement statement = connection.prepareStatement(" select * from Equipe WHERE ID_Departamento=? ;");
            statement.setString(1, id);
           
           
            resultSet=statement.executeQuery();
            
            while(resultSet.next()){
                Equipe eqp=new Equipe();
                eqp.setID(resultSet.getInt("ID"));
                eqp.setNome(resultSet.getString("nomeE"));
                
                eqps.add(eqp);
            }
       }
            catch (SQLException e) {
            e.printStackTrace();
            
        }
        return eqps;
    }
    public static ArrayList<Funcionario> Lista_funcionario_equipe(int id){
        ArrayList<Funcionario> funs=new ArrayList<Funcionario>();
        String connectionUrl =
                "jdbc:mysql://WEBSOFT.chlhdmd5beba.us-east-1.rds.amazonaws.com:3306/WEBSOFT?user=SGE&password=alebeodeiadualboot2020";
        
        ResultSet resultSet ;
        
       
       try {
            //String sql="SELECT * FROM dbo.CEO WHERE email=? AND senha=? ;";
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        Connection connection = DriverManager.getConnection(connectionUrl);
            PreparedStatement statement = connection.prepareStatement(" select * from Funcionario_Equipe fe inner join Funcionario f \n" +
"on(fe.email_Funcionario=f.email and ID_Equipe=?); ;");
            statement.setInt(1, id);
           
           
            resultSet=statement.executeQuery();
            
            while(resultSet.next()){
                Funcionario fun=new Funcionario();
                fun.setEmail(resultSet.getString("email"));
                fun.setNome(resultSet.getString("nomeF"));
                if(resultSet.getString("Status_gerente").equals("Gerente")){
                    fun.setStatus_GERENTE(true);
                }else{
                    fun.setStatus_GERENTE(false);
                }
                
                funs.add(fun);
            }
       }
            catch (SQLException e) {
            e.printStackTrace();
            
        }
        return funs;
    }
    public static ArrayList<Projeto> Listar_projeto(String id_dep,boolean ativo){
        String stt;
        if(ativo){
            stt="Ativo";
        }
        else{
            stt="Inativo";
        }
        ArrayList<Projeto> projs=new ArrayList<Projeto>();
        String connectionUrl =
                "jdbc:mysql://WEBSOFT.chlhdmd5beba.us-east-1.rds.amazonaws.com:3306/WEBSOFT?user=SGE&password=alebeodeiadualboot2020";
        
        ResultSet resultSet ;
        
       
       try {
            //String sql="SELECT * FROM dbo.CEO WHERE email=? AND senha=? ;";
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        Connection connection = DriverManager.getConnection(connectionUrl);
            PreparedStatement statement = connection.prepareStatement(" select * from Projeto where (statusP=? AND ID_Departamento=? );");
            statement.setString(1,stt);
            statement.setString(2,id_dep);
           
            resultSet=statement.executeQuery();
            
            while(resultSet.next()){
                Projeto proj=new Projeto();
                proj.setId(resultSet.getInt("ID"));
                proj.setNome(resultSet.getString("nomeE"));
                if(resultSet.getString("statusP").equals("Ativo")){
                    proj.setStatus(true);
                }
                else{
                    proj.setStatus(false);
                }
               
                proj.setPrazo(resultSet.getString("Criacao") );
                projs.add(proj);
            }
       }
            catch (SQLException e) {
            e.printStackTrace();
            
        }
        return projs;
    }
     public static ArrayList<Projeto> Listar_projeto_funcionario(String email,boolean ativo){
        String stt;
        if(ativo){
            stt="Ativo";
        }
        else{
            stt="Inativo";
        }
        ArrayList<Projeto> projs=new ArrayList<Projeto>();
        String connectionUrl =
                "jdbc:mysql://WEBSOFT.chlhdmd5beba.us-east-1.rds.amazonaws.com:3306/WEBSOFT?user=SGE&password=alebeodeiadualboot2020";
        
        ResultSet resultSet ;
        
       
       try {
            //String sql="SELECT * FROM dbo.CEO WHERE email=? AND senha=? ;";
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        Connection connection = DriverManager.getConnection(connectionUrl);
            PreparedStatement statement = connection.prepareStatement(" select * from Projeto p inner join Projeto_Equipe pe ON(p.ID=pe.ID_projeto and p.statusP=?)\n" +
"inner join Funcionario_Equipe fe on(fe.ID_Equipe=pe.ID_equipe and fe.email_Funcionario=?);");
            statement.setString(1,stt);
            statement.setString(2,email);
           
            resultSet=statement.executeQuery();
            
            while(resultSet.next()){
                Projeto proj=new Projeto();
                proj.setId(resultSet.getInt("ID_projeto"));
                proj.setNome(resultSet.getString("nomeE"));
                if(resultSet.getString("statusP").equals("Ativo")){
                    proj.setStatus(true);
                }
                else{
                    proj.setStatus(false);
                }
                proj.setId(resultSet.getInt("ID_projeto"));
                proj.setPrazo(resultSet.getString("Criacao") );
                projs.add(proj);
            }
       }
            catch (SQLException e) {
            e.printStackTrace();
            
        }
        return projs;
    }
     public static ArrayList<String>Listar_tarefa(int id){
         ArrayList<String> tarefas=new ArrayList<String>();
        String connectionUrl =
                "jdbc:mysql://WEBSOFT.chlhdmd5beba.us-east-1.rds.amazonaws.com:3306/WEBSOFT?user=SGE&password=alebeodeiadualboot2020";
        
        ResultSet resultSet ;
        
       
       try {
            //String sql="SELECT * FROM dbo.CEO WHERE email=? AND senha=? ;";
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        Connection connection = DriverManager.getConnection(connectionUrl);
            PreparedStatement statement = connection.prepareStatement(" select * from Tarefa where(ID_projeto=?) ;");
            statement.setInt(1, id);
           
           
            resultSet=statement.executeQuery();
            
            while(resultSet.next()){
                
                tarefas.add(resultSet.getString("nomeT"));
            }
       }
            catch (SQLException e) {
            e.printStackTrace();
            
        }
        return tarefas;
    } 
    public static ArrayList<Mensagens> receber_mensagem(int id_proj){
        ArrayList<Mensagens> mens=new ArrayList<Mensagens>();
        String connectionUrl =
                "jdbc:mysql://WEBSOFT.chlhdmd5beba.us-east-1.rds.amazonaws.com:3306/WEBSOFT?user=SGE&password=alebeodeiadualboot2020";
        
        ResultSet resultSet ;
        
       
       try {
            //String sql="SELECT * FROM dbo.CEO WHERE email=? AND senha=? ;";
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        Connection connection = DriverManager.getConnection(connectionUrl);
            PreparedStatement statement = connection.prepareStatement(" select * from Mensagens where(ID_Projeto=?) ;");
            statement.setInt(1, id_proj);
           
           
            resultSet=statement.executeQuery();
            
            while(resultSet.next()){
                /*Mensagens m=new Mensagens();
                m.setEmail(resultSet.getString("nome"));
                m.setCriado(resultSet.getString("criado"));
                m.setMensagem(resultSet.getString("mensagem"));
                m.setId_projeto(id_proj);
                m.setEmail(resultSet.getString("email"));
                mens.add(m);*/
            }
       }
            catch (SQLException e) {
            e.printStackTrace();
            
        }
        return mens;
    }
    public static ArrayList<Funcionario> Mostrar_fun_dep(String id_dep){
        ArrayList<Funcionario> funs=new ArrayList<Funcionario>();
        String connectionUrl =
                "jdbc:mysql://WEBSOFT.chlhdmd5beba.us-east-1.rds.amazonaws.com:3306/WEBSOFT?user=SGE&password=alebeodeiadualboot2020";
        
        ResultSet resultSet ;
        
       
       try {
            //String sql="SELECT * FROM dbo.CEO WHERE email=? AND senha=? ;";
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        Connection connection = DriverManager.getConnection(connectionUrl);
            PreparedStatement statement = connection.prepareStatement(" select * from Funcionario where(ID_departamento=?);");
            statement.setString(1, id_dep); 
           
           
            resultSet=statement.executeQuery();
            
            while(resultSet.next()){
                Funcionario fun=new Funcionario();
                fun.setNome(resultSet.getString("nomeF"));
                fun.setEmail(resultSet.getString("email"));
                fun.setRG(resultSet.getString("RG"));
                if(resultSet.getString("Status_gerente").equals("Gerente")){
                    fun.setStatus_GERENTE(true);
                }
                else{
                    fun.setStatus_GERENTE(false);
                }
                funs.add(fun);
            }
       }
            catch (SQLException e) {
            e.printStackTrace();
            
        }
        return funs;
    }
    public static boolean alterarStatusFun(String email,String empresa){
        boolean f=false;
        String connectionUrl =
                "jdbc:mysql://WEBSOFT.chlhdmd5beba.us-east-1.rds.amazonaws.com:3306/WEBSOFT?user=SGE&password=alebeodeiadualboot2020";
        
        
        int resultSet ;
     
         try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            Connection connection = DriverManager.getConnection(connectionUrl);
           PreparedStatement statement = connection.prepareStatement("UPDATE Funcionario SET Status_gerente='Gerente' WHERE email=? AND empresa=?;");
            // Create and execute a SELECT SQL statement.
            
            statement.setString(1, email);
            statement.setString(2, empresa);
            resultSet=statement.executeUpdate();
            f=true;
            // Print results from select statement
                
            }   
        
        catch (SQLException e) {
            e.printStackTrace();
            
        }
        return f;
    }
    public static boolean AlterarStatusProjeto(int id){
        boolean status=false;
        String connectionUrl =
                "jdbc:mysql://WEBSOFT.chlhdmd5beba.us-east-1.rds.amazonaws.com:3306/WEBSOFT?user=SGE&password=alebeodeiadualboot2020";
        
        
        int resultSet ;
     
         try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            Connection connection = DriverManager.getConnection(connectionUrl);
           PreparedStatement statement = connection.prepareStatement("UPDATE Projeto SET statusP='Inativo' WHERE ID=?;");
            // Create and execute a SELECT SQL statement.
            
            statement.setInt(1, id) ;
            resultSet=statement.executeUpdate();
            status=true;
            // Print results from select statement
                
            }   
        
        catch (SQLException e) {
            e.printStackTrace();
            
        }
        return status;
    }
    public static boolean alterar_Fun_dep(String email,String empresa,String id_dep){
        boolean f=false;
        Deletar_Funcionario_Equipes(email);
        String connectionUrl =
                "jdbc:mysql://WEBSOFT.chlhdmd5beba.us-east-1.rds.amazonaws.com:3306/WEBSOFT?user=SGE&password=alebeodeiadualboot2020";
        
        
        int resultSet ;
     
         try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            Connection connection = DriverManager.getConnection(connectionUrl);
           PreparedStatement statement = connection.prepareStatement("UPDATE Funcionario SET ID_departamento=? WHERE email=? AND empresa=?;");
            // Create and execute a SELECT SQL statement.
            statement.setString(1, id_dep);
            statement.setString(2, email);
            statement.setString(3, empresa);
            resultSet=statement.executeUpdate();
            f=true;
            // Print results from select statement
                
            }   
        
        catch (SQLException e) {
            e.printStackTrace();
            
        }
        return f;
    }
    public static boolean  Deletar_Funcionario_Equipes(String email){
        String connectionUrl =
                "jdbc:mysql://WEBSOFT.chlhdmd5beba.us-east-1.rds.amazonaws.com:3306/WEBSOFT?user=SGE&password=alebeodeiadualboot2020";
        
        int resultSet ;
        
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        Connection connection = DriverManager.getConnection(connectionUrl);
                PreparedStatement statement;
            statement = connection.prepareStatement(" delete from Funcionario_Equipe where (email_Funcionario=?);");
            statement.setString(1, email);
            resultSet=statement.executeUpdate();
            return true;
        }
        catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public static boolean  Deletar_Mensagens(int ID){
        String connectionUrl =
                "jdbc:mysql://WEBSOFT.chlhdmd5beba.us-east-1.rds.amazonaws.com:3306/WEBSOFT?user=SGE&password=alebeodeiadualboot2020";
        
        int resultSet ;
        
       
        try{
            Connection connection = DriverManager.getConnection(connectionUrl);
            PreparedStatement statement = connection.prepareStatement(" delete from Mensagens where (ID_Projeto=?);");
            statement.setInt(1, ID);
            resultSet=statement.executeUpdate();
            return true;
            
        }
        catch (SQLException e) {
            e.printStackTrace();
            return false;
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
        System.out.println("teste11= "+Deletar_Funcionario("wdqef")); 
        System.out.println("teste= "+Deletar_Funcionario_Empresa("wdqef","Bia Bradesco")); 
        ArrayList<Departamento> deps=listar_Departamento("dd");
        ArrayList<Funcionario> funs=Lista_funcionario_equipe(34);
        ArrayList<Projeto> projs=Listar_projeto("1",true);
        ArrayList<String> tasks=Listar_tarefa(9);
        ArrayList<Mensagens> mes=receber_mensagem(9);
        for(int j=0;j<tasks.size();j++){
           
            //System.out.println("NOME="+mes.get(j).getMensagem());
        }
        //Deletar_Funcionario_Departamento("bibi@gmail.com","1111");
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
        String nomeP="testeBD";
        p.setNome(nomeP);
        p.setPrazoD(data);
        p.setID_Departamento("1");
        //Criar_Projeto(p);
        //p.setId(ProcurarIDProjeto(p.getNome(),p.getID_Departamento()));
        //Atribuir_Projeto_Equipe(p,e);
        String Tarefa="fazer banco";
        //Atribuir_Tarefa_Projeto(p.getId(),Tarefa);
        //System.out.println(ProcurarFuncionario("didi@gmail.com","123456").getEmpresa());
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
        //System.out.println(ProcurarIDTarefa("exemplo",6)); 
        //Deletar_Tarefa(5);
        String connectionUrl =
                "jdbc:mysql://WEBSOFT.chlhdmd5beba.us-east-1.rds.amazonaws.com:3306/WEBSOFT?user=SGE&password=alebeodeiadualboot2020";
        
        ResultSet resultSet ;
        
        try {
            Connection connection = DriverManager.getConnection(connectionUrl);
            Statement statement = connection.createStatement(); 

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
    