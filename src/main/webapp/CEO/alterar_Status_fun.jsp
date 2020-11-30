<%-- 
    Document   : alterar_Status_fun
    Created on : 18/11/2020, 23:24:08
    Author     : edu_p
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="dominio.CEO"%>
<%@page import="banco.CEOBD"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>

        <%
            
        HttpSession sessao = request.getSession();
       
        String email=request.getParameter("email");
        
        if(sessao.isNew()){
            response.sendRedirect("http://sistema-empresarial.herokuapp.com/index.jsp");
        }
        else{
            CEO ceo=(CEO) session.getAttribute("CEO");
            if(ceo==null){
                response.sendRedirect("http://sistema-empresarial.herokuapp.com/index.jsp");
            }
            else{
                String empresa=ceo.getEmpresa();
               if(CEOBD.alterarStatusFun(email, empresa)){
                   response.sendRedirect("http://sistema-empresarial.herokuapp.com/Menu_CEO.jsp?sucesso=alterado");
               }
                else{
                    response.sendRedirect("http://sistema-empresarial.herokuapp.com/CEO/alterar_Status_funs.jsp?erro=N_EMAIL");
                }
            }
        }
        %>
    </body>
</html>

    </body>
</html>
