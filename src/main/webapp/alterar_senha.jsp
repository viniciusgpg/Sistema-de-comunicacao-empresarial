<%-- 
    Document   : alterar_senha
    Created on : 25/10/2020, 02:32:34
    Author     : edu_p
--%>
<%@page import="dominio.CEO"%>
<%@page import="dominio.Funcionario"%>
<%@page import="banco.CEOBD"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>alterar senha</title>
    </head>
    <body>
        <%
            
        HttpSession sessao = request.getSession();
       
        String senhaV=request.getParameter("senha");
        String senhaN=request.getParameter("nova_senha");
        String confirma=request.getParameter("confirmar_senha");
        
        
         // nome = Normalizer.normalize(nome, Normalizer.Form.NFD);
          //nome = nome.replaceAll("[^\p{ASCII}]", "");
        if(!senhaN.equals(confirma)){
             response.sendRedirect("http://sistema-empresarial.herokuapp.com/alterarsenha.jsp?erro=SENHA_ERRADA");
        }
        else if(sessao.isNew()){
            response.sendRedirect("http://sistema-empresarial.herokuapp.com/index.jsp");
        }
        else{
            CEO ceo=(CEO) session.getAttribute("CEO");
            if(ceo==null){
                Funcionario ger=(Funcionario) sessao.getAttribute("Gerente");
                if(ger==null){
                    Funcionario fun=(Funcionario) sessao.getAttribute("Funcionario");
                    if(fun==null){
                        response.sendRedirect("http://sistema-empresarial.herokuapp.com/index.jsp");
                    }
                    else{
                    if(CEOBD.alterar_Senha_Funcionario(fun.getEmail(), senhaV, senhaN)){
                        response.sendRedirect("http://sistema-empresarial.herokuapp.com/Menu_Funcionario.jsp?sucesso=alterado");
                    
                    }
                    else{
                        response.sendRedirect("http://sistema-empresarial.herokuapp.com/alterarsenha.jsp");
                    
                    }
                    
                    }
                }
                else{
                if(CEOBD.alterar_Senha_Funcionario(ger.getEmail(), senhaV, senhaN)){
                    response.sendRedirect("http://sistema-empresarial.herokuapp.com/Menu_Gerente.jsp?sucesso=alterado");
                }
                else{
                        response.sendRedirect("http://sistema-empresarial.herokuapp.com/alterarsenha.jsp");
                    }
                
                }
            }
            else{
               if(CEOBD.alterar_Senha_CEO(ceo.getEmail(), senhaV, senhaN)){
                   response.sendRedirect("http://sistema-empresarial.herokuapp.com/Menu_CEO.jsp?sucesso=alterado");
               }
               else{
                        response.sendRedirect("http://sistema-empresarial.herokuapp.com/alterarsenha.jsp");
                    }
            }
        }
        %>
    </body>
</html>
