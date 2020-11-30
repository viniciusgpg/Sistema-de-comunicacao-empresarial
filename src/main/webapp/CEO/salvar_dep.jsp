<%-- 
    Document   : salvar_dep
    Created on : 22/10/2020, 21:35:55
    Author     : edu_p
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="dominio.CEO"%>
<%@page import="banco.CEOBD"%>
<%@page import="dominio.Departamento"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>gerar departamento</title>
    </head>
    <body> 
        <%
        HttpSession sessao = request.getSession();
        String id=  request.getParameter("ID");  
        String nome=request.getParameter("nome_departamento");
        String coordenador=request.getParameter("coordenador");
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
                Departamento dep=new Departamento();
                dep.setCoodenador(coordenador);
                dep.setEmpresa(empresa);
                dep.setID(id);
                dep.setNome(nome);
                if(CEOBD.Cadastrar_Departamento(dep)){
                    response.sendRedirect("http://sistema-empresarial.herokuapp.com/Menu_CEO.jsp?sucesso=criado");
                }
                else{
                    response.sendRedirect("http://sistema-empresarial.herokuapp.com/CEO/gerar_Departamento.jsp?erro=falhou");
                }
                
            }
        }
        %>
       
    </body>
</html>
