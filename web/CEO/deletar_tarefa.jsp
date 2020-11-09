<%@page import="banco.CEOBD"%>
<%@page import="java.text.Normalizer"%>
<%@page import="dominio.CEO"%>
<%@page import="dominio.Funcionario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>deleta tarefa</title>
    </head>
    <body>
        <%
            
        HttpSession sessao = request.getSession();
       
        String projeto=request.getParameter("nome_projeto");
        String tarefa1=request.getParameter("tarefa_deletada");
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
                
                
                if(tarefa1!=null){
                    
                  int id=CEOBD.ProcurarIDTarefa(tarefa1, id_proj);
                  CEOBD.Deletar_Tarefa(id);
                }
                
                response.sendRedirect("http://localhost:8080/Company/Menu_Gerente.jsp");
            }
            else{
                String empresa=ceo.getEmpresa();
               
                String id_dep=CEOBD.procurarCodDep(departamento, empresa);
                int id_proj=CEOBD.ProcurarIDProjeto(projeto, id_dep);
                
                
                if(tarefa1!=null){
                    
                   int id=CEOBD.ProcurarIDTarefa(tarefa1, id_proj);
                  CEOBD.Deletar_Tarefa(id);
                }
                
                response.sendRedirect("http://localhost:8080/Company/Menu_CEO.jsp");
            }
        }
        %>
    </body>
</html>
