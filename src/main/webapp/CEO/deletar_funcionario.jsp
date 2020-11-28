<%-- 
    Document   : deletar_funcionario
    Created on : 24/10/2020, 23:23:30
    Author     : edu_p
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="dominio.CEO"%>
<%@page import="dominio.Funcionario"%>
<%@page import="banco.CEOBD"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            
        HttpSession sessao = request.getSession();
       
        String email=request.getParameter("email");
        
        if(sessao.isNew()){
            response.sendRedirect("http://sistema-empresarial.herokuapp.com/index.jsp");
        }
        else{
            CEO ceo=(CEO) session.getAttribute("CEO");
            if(ceo==null){
                Funcionario fun=(Funcionario) sessao.getAttribute("Gerente");
                if(fun==null){
                    response.sendRedirect("http://sistema-empresarial.herokuapp.com/index.jsp");
                }
                if(CEOBD.Deletar_Funcionario_Departamento(email, fun.getID_departamento())){
                    response.sendRedirect("http://sistema-empresarial.herokuapp.com/Menu_Gerente.jsp?sucesso=removido");
                }
                else{
                    response.sendRedirect("http://sistema-empresarial.herokuapp.com/CEO/remover_funcionario.jsp?erro=N_EMAIL");
                }
            }
            else{
                String empresa=ceo.getEmpresa();
               if(CEOBD.Deletar_Funcionario_Empresa(email, empresa)){
                   response.sendRedirect("http://sistema-empresarial.herokuapp.com/Menu_CEO.jsp?sucesso=removido");
               }
                else{
                    response.sendRedirect("http://sistema-empresarial.herokuapp.com/CEO/remover_funcionarios.jsp?erro=N_EMAIL");
                }
            }
        }
        %>
    </body>
</html>
