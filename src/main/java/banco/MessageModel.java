/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;


import dominio.Mensagens;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MessageModel {
    
    public ArrayList<Mensagens> get(int id_proj){
        
        ArrayList<Mensagens> mensagens = new ArrayList<Mensagens>();
        
        
        String connectionUrl =
                "jdbc:mysql://WEBSOFT.chlhdmd5beba.us-east-1.rds.amazonaws.com:3306/WEBSOFT?user=SGE&password=alebeodeiadualboot2020";
        
        ResultSet rs ;
        
       
       try {
            //String sql="SELECT * FROM dbo.CEO WHERE email=? AND senha=? ;";
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        Connection connection = DriverManager.getConnection(connectionUrl);
                PreparedStatement statement = connection.prepareStatement(" SELECT id, id_projeto, nome, mensagem,email, DATE_FORMAT(criado, '%d-%m-%y a las %h:%i:%s %p') as date from Mensagens where(id_projeto=?)\n"  
                        +"ORDER BY id ASC\n" 
                        +"LIMIT 100;");
            statement.setInt(1, id_proj);
            rs=statement.executeQuery();
            while(rs.next()){
                mensagens.add(new Mensagens(rs.getInt("id"),rs.getInt("id_projeto") ,rs.getString("nome"), rs.getString("mensagem"), rs.getString("date"),rs.getNString("email")));
                
            }
            
        }
        catch (SQLException e) {
            e.printStackTrace();
            
        }
        return mensagens;
    }
    
    public boolean Novas(Mensagens m){
        
        boolean flag = false;
        
       String connectionUrl =
                "jdbc:mysql://WEBSOFT.chlhdmd5beba.us-east-1.rds.amazonaws.com:3306/WEBSOFT?user=SGE&password=alebeodeiadualboot2020";
        
        ResultSet rs ;
        
       System.out.println(m.getEmail());
       try {
            //String sql="SELECT * FROM dbo.CEO WHERE email=? AND senha=? ;";
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        Connection connection = DriverManager.getConnection(connectionUrl);
            
           PreparedStatement pst = connection.prepareStatement
            ("INSERT INTO Mensagens "
            + "(id,email,ID_Projeto,mensagem,nome,criado) "
            + "VALUES(null,?,?,?,?,?)");
            
            pst.setString(1, m.getEmail());
            
            pst.setInt(2, m.getId_projeto());
            pst.setString(3, m.getMensagens());
            pst.setString(4, m.getNome());
            pst.setString(5, m.getCreated_at());
           
            flag = pst.executeUpdate() == 1;
            
            
            pst.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return flag;
        
    }
    
     public static void main(String[] args) {
         
         MessageModel mm=new MessageModel() ;
         Mensagens mes=new Mensagens(9,"dauma","teeste 2 bd","2020-11-06","dauma@1.com");
         //System.out.println("id="+mes.getId()+" nome="+mes.getNome()+" email="+mes.getEmail()+" mensagem="+mes.getMensagens()+" data="+mes.getCreated_at());
         //mm.Novas(mes);
         ArrayList<Mensagens> me=mm.get(9);
         if(me.isEmpty()){
            System.out.println("vazia");
         }
         else{
             System.out.println(me.get(0).getNome());
         }
         System.out.println(me.get(0).getNome());
         
     }
    
    
}

