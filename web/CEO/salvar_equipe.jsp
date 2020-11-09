<%-- 
    Document   : salvar_equipe
    Created on : 22/10/2020, 22:38:52
    Author     : edu_p
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="banco.CEOBD"%>
<%@page import="java.text.Normalizer"%>
<%@page import="dominio.CEO"%>
<%@page import="dominio.Equipe"%>
<%@page import="dominio.Funcionario"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gerar equipe</title>
    </head>
    <body>
        
        <%
            
        HttpSession sessao = request.getSession();
       
        String nome=request.getParameter("nome_equipe");
        System.out.println(nome);
        String departamento=request.getParameter("departamento");
         // nome = Normalizer.normalize(nome, Normalizer.Form.NFD);
          //nome = nome.replaceAll("[^\p{ASCII}]", "");
        if(sessao.isNew()){
            response.sendRedirect("http://localhost:8080/Company/index.jsp");
        }
        else{
            CEO ceo=(CEO) session.getAttribute("CEO");
            if(ceo==null){
                Funcionario fun=(Funcionario) sessao.getAttribute("Gerente");
                if(fun==null){
                    response.sendRedirect("http://localhost:8080/Company/index.jsp");
                }
                Equipe equipe=new Equipe();
                equipe.setID_departamento(fun.getID_departamento());
                equipe.setNome(nome);
                CEOBD.Criar_Equipe(equipe);
                response.sendRedirect("http://localhost:8080/Company/Menu_Gerente.jsp");
            }
            else{
                String empresa=ceo.getEmpresa();
               
                String id_dep=CEOBD.procurarCodDep(departamento, empresa);
                Equipe equipe=new Equipe();
                equipe.setID_departamento(id_dep);
                equipe.setNome(nome);
                CEOBD.Criar_Equipe(equipe);
                response.sendRedirect("http://localhost:8080/Company/Menu_CEO.jsp");
            }
        }
        %>
    </body>
</html>
