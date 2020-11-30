<%-- 
    Document   : atribuir_equipe_proj
    Created on : 23/10/2020, 23:02:54
    Author     : edu_p
--%>
<%@page import="banco.CEOBD"%>
<%@page import="java.text.Normalizer"%>
<%@page import="dominio.CEO"%>
<%@page import="dominio.Funcionario"%>
<%@page import="dominio.Equipe"%>
<%@page import="dominio.Projeto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            
        HttpSession sessao = request.getSession();
       
        String projeto=request.getParameter("nome_projeto");
        String equipe=request.getParameter("equipe");
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
                else{
                Projeto p=new Projeto();
                p.setID_Departamento(fun.getID_departamento());
                int id_proj=CEOBD.ProcurarIDProjeto(projeto, fun.getID_departamento());
                p.setId(id_proj);
                int id_equipe=CEOBD.ProcurarID_Equipe(equipe, fun.getID_departamento());
                Equipe e=new Equipe();
                e.setID(id_equipe);
                e.setID_departamento(fun.getID_departamento());
                if(id_equipe==-1){
                    response.sendRedirect("http://localhost:8080/Company/CEO/equipe_projeto.jsp?erro=N_EQUIPE");
                }
                else if(id_proj==-1){
                    response.sendRedirect("http://localhost:8080/Company/CEO/equipe_projeto.jsp?erro=N_PROJ");
                }
                else if(CEOBD.Atribuir_Projeto_Equipe(p, e)){ 
                    response.sendRedirect("http://localhost:8080/Company/Menu_CEO.jsp?sucesso=atribuido");
                } else{
                    response.sendRedirect("http://localhost:8080/Company/CEO/equipe_projeto.jsp?erro=N_BANCO");
               }
                
            }
            }
            else{
                String empresa=ceo.getEmpresa();
               
                String id_dep=CEOBD.procurarCodDep(departamento, empresa);
                Projeto p=new Projeto();
                p.setID_Departamento(id_dep);
                int id_proj=CEOBD.ProcurarIDProjeto(projeto, id_dep);
                p.setId(id_proj);
                int id_equipe=CEOBD.ProcurarID_Equipe(equipe, id_dep);
                Equipe e=new Equipe();
                e.setID(id_equipe);
                e.setID_departamento(id_dep);
                if(id_dep==null){
                    response.sendRedirect("http://localhost:8080/Company/CEO/equipe_projetos.jsp?erro=N_DEP");
                
                }
                else if(id_equipe==-1){
                    response.sendRedirect("http://localhost:8080/Company/CEO/equipe_projetos.jsp?erro=N_EQUIPE");
                }
                else if(id_proj==-1){
                    response.sendRedirect("http://localhost:8080/Company/CEO/equipe_projetos.jsp?erro=N_PROJ");
                }
                else if(CEOBD.Atribuir_Projeto_Equipe(p, e)){ 
                    response.sendRedirect("http://localhost:8080/Company/Menu_CEO.jsp?sucesso=atribuido");
                } else{
                    response.sendRedirect("http://localhost:8080/Company/CEO/equipe_projetos.jsp?erro=N_BANCO");
               }
                
                
            }
        }
        %>
    </body>
</html>
