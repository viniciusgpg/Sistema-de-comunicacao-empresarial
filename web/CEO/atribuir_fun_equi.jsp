<%-- 
    Document   : atribuir_fun_equi
    Created on : 24/10/2020, 00:00:43
    Author     : edu_p
--%>
<%@page import="banco.CEOBD"%>
<%@page import="java.text.Normalizer"%>
<%@page import="dominio.CEO"%>
<%@page import="dominio.Funcionario"%>
<%@page import="dominio.Equipe"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>atribuir funcionario a equipe</title>
    </head>
    <body>
        <%
            
        HttpSession sessao = request.getSession();
       
        String email=request.getParameter("email");
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
                Funcionario f=new Funcionario();
                f.setID_departamento(fun.getID_departamento());
                
                f.setEmail(email);
                
                int id_equipe=CEOBD.ProcurarID_Equipe(equipe, fun.getID_departamento());
                Equipe e=new Equipe();
                e.setID(id_equipe);
                e.setID_departamento(fun.getID_departamento());
                CEOBD.Atribuir_Funcionario_Equipe(f, e);
                
                
                response.sendRedirect("http://localhost:8080/Company/Menu_Gerente.jsp");
            }
            else{
                String empresa=ceo.getEmpresa();
               
                String id_dep=CEOBD.procurarCodDep(departamento, empresa);
                Funcionario f=new Funcionario();
                f.setID_departamento(id_dep);
                
                f.setEmail(email);
                
                int id_equipe=CEOBD.ProcurarID_Equipe(equipe,id_dep);
                Equipe e=new Equipe();
                e.setID(id_equipe);
                e.setID_departamento(id_dep);
                CEOBD.Atribuir_Funcionario_Equipe(f, e);
                
                response.sendRedirect("http://localhost:8080/Company/Menu_CEO.jsp");
            }
        }
        %>
    </body>
</html>
