/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;
import dominio.CEO;
import dominio.Funcionario ;
import dominio.Mensagens;
import banco.MessageModel;
import com.pusher.rest.Pusher;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet(name = "NewMessage", urlPatterns = {"/create"})
public class NewMessage extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession sessao = request.getSession();
       String id;
       if(sessao.isNew()){
          response.sendRedirect("http://localhost:8080/Company/index.jsp");
       }
        id=(String)sessao.getAttribute("id_proj");
        String nome="",email="";
        CEO ceo=(CEO)sessao.getAttribute("CEO");
        if(ceo==null){
            Funcionario ger=(Funcionario)sessao.getAttribute("Gerente");
            if(ger==null){
                Funcionario fun=(Funcionario)sessao.getAttribute("Funcionario");
                if(fun==null){
                    response.sendRedirect("http://localhost:8080/Company/index.jsp");
                }
                else{
                    nome=fun.getNome();
                    email=fun.getEmail();
                }
            }
            else{
                nome=ger.getNome();
                email=ger.getEmail();
            }
        }
        else{
            nome=ceo.getNome();
            email=ceo.getEmail();
        }
          int id_projeto = Integer.parseInt(id);
        String name = request.getParameter("name");
        String message = request.getParameter("message");
        
        MessageModel mm = new MessageModel();
        
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        
        Date date = new Date(); 
        
        Mensagens msg = new Mensagens(id_projeto,nome, message, "2020-11-06",email);
        
        mm.Novas(msg);
        
        DateFormat dateFormat2 = new SimpleDateFormat("dd-MM-yy 'a las' hh:mm:ss a");
        
       Pusher pusher = new Pusher("1102949", "e15436bca8cc094862cc", "92c20b3dc74f65e652f3");
pusher.setCluster("us2");
pusher.setEncrypted(true);
        pusher.trigger("chat", "new-message", msg.getJsonObject());
        
       
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

