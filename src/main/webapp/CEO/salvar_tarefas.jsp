<%-- 
    Document   : salvar_tarefas
    Created on : 23/10/2020, 20:45:40
    Author     : edu_p
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="banco.CEOBD"%>
<%@page import="java.text.Normalizer"%>
<%@page import="dominio.CEO"%>

<%@page import="dominio.Funcionario"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            
        HttpSession sessao = request.getSession();
       
        String projeto=request.getParameter("projeto_existente");
        String tarefa1=request.getParameter("tarefa1");
        String departamento=request.getParameter("departamento");
        String tarefa2=request.getParameter("tarefa2");
        String tarefa3=request.getParameter("tarefa3");
         // nome = Normalizer.normalize(nome, Normalizer.Form.NFD);
          //nome = nome.replaceAll("[^\p{ASCII}]", "");
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
                int id_proj=CEOBD.ProcurarIDProjeto(projeto, fun.getID_departamento());
                
                
                if(tarefa1!=null){
                    
                   if( !CEOBD.Atribuir_Tarefa_Projeto(id_proj, tarefa1)){
                       response.sendRedirect("http://sistema-empresarial.herokuapp.com/CEO/atribuirtarefa.jsp?erro=tarefa1");
                   
                   }
                }
                if(tarefa2!=null){
                    
                    if( !CEOBD.Atribuir_Tarefa_Projeto(id_proj, tarefa2)){
                       response.sendRedirect("http://sistema-empresarial.herokuapp.com/CEO/atribuirtarefa.jsp?erro=tarefa2");
                   
                   }
                }
                if(tarefa3!=null){
                    
                    if( !CEOBD.Atribuir_Tarefa_Projeto(id_proj, tarefa3)){
                       response.sendRedirect("http://sistema-empresarial.herokuapp.com/CEO/atribuirtarefa.jsp?erro=tarefa3");
                   
                   }
                }
                response.sendRedirect("http://sistema-empresarial.herokuapp.com/Menu_Gerente.jsp?sucesso=criado");
            }
            else{
                String empresa=ceo.getEmpresa();
               
                String id_dep=CEOBD.procurarCodDep(departamento, empresa);
                int id_proj=CEOBD.ProcurarIDProjeto(projeto, id_dep);
                
                if(id_proj!=-1){
                    if(tarefa1!=null){
                    
                       if( !CEOBD.Atribuir_Tarefa_Projeto(id_proj, tarefa1)){
                           response.sendRedirect("http://sistema-empresarial.herokuapp.com/CEO/atribuirtarefas.jsp?erro=tarefa1");
                   
                       }
                   }
                    if(tarefa2!=null){
                    
                        if( !CEOBD.Atribuir_Tarefa_Projeto(id_proj, tarefa2)){
                           response.sendRedirect("http://sistema-empresarial.herokuapp.com/CEO/atribuirtarefas.jsp?erro=tarefa2");
                   
                       }
                   }
                    if(tarefa3!=null){
                    
                       if( !CEOBD.Atribuir_Tarefa_Projeto(id_proj, tarefa3)){
                           
                           response.sendRedirect("http://sistema-empresarial.herokuapp.com/CEO/atribuirtarefas.jsp?erro=tarefa3");
                   
                       }
                   }
                    response.sendRedirect("http://sistema-empresarial.herokuapp.com/Menu_CEO.jsp?sucesso=criado");
                
                }else{    
                    response.sendRedirect("http://sistema-empresarial.herokuapp.com/CEO/atribuirtarefas.jsp?erro=projeto_n_existe");
                }
            }
            
        }
        %>
    </body>
</html>
