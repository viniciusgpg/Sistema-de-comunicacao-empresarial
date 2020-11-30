<%-- 
    Document   : deletar_projeto
    Created on : 25/10/2020, 01:56:29
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
        <title>deletar projeto</title>
    </head>
    <body>
        <%
            
        HttpSession sessao = request.getSession();
       
        String projeto=request.getParameter("projeto");
        
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
                int id_proj=CEOBD.ProcurarIDProjeto(projeto, fun.getID_departamento());
                if(id_proj!=-1){
                    CEOBD.AlterarStatusProjeto(id_proj);
                    response.sendRedirect("http://localhost:8080/Company/Menu_Gerente.jsp?sucesso=removido");
                }
                else{
                    response.sendRedirect("http://localhost:8080/Company/remover_equipe.jsp?erro=N_EQUIPE");
                }
                
                response.sendRedirect("http://localhost:8080/Company/Menu_Gerente.jsp");
            }
            else{
                String empresa=ceo.getEmpresa();
               
                String id_dep=CEOBD.procurarCodDep(departamento, empresa);
                int id_proj=CEOBD.ProcurarIDProjeto(projeto, id_dep);
                if(id_proj!=-1){
                    CEOBD.AlterarStatusProjeto(id_proj);
                    response.sendRedirect("http://localhost:8080/Company/Menu_CEO.jsp?sucesso=removido");
                }
                else{
                    response.sendRedirect("http://localhost:8080/Company/remover_equipes.jsp?erro=N_EQUIPE");
                }  
            }
        }
        %>
    </body>
</html>
