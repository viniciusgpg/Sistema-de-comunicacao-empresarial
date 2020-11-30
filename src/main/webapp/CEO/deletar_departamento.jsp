<%-- 
    Document   : deletar_departamento
    Created on : 25/10/2020, 01:04:46
    Author     : edu_p
--%>
<%@page import="banco.CEOBD"%>
<%@page import="java.text.Normalizer"%>
<%@page import="dominio.CEO"%>
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
    
        
        String departamento=request.getParameter("departamento");
        
         // nome = Normalizer.normalize(nome, Normalizer.Form.NFD);
          //nome = nome.replaceAll("[^\p{ASCII}]", "");
        if(sessao.isNew()){
            response.sendRedirect("http://localhost:8080/Company/index.jsp");
        }
        else{
            CEO ceo=(CEO) session.getAttribute("CEO");
            if(ceo==null){
                response.sendRedirect("http://localhost:8080/Company/index.jsp");
                
            }
            else{
                String empresa=ceo.getEmpresa();
               
                String id_dep=CEOBD.procurarCodDep(departamento, empresa);
                if(id_dep==null){
                    response.sendRedirect("http://localhost:8080/Company/Menu_CEO.jsp?error=DEP_N_EXISTE");
                }
                else{
                    CEOBD.Deletar_Departamento(id_dep);
                    
                response.sendRedirect("http://localhost:8080/Company/Menu_CEO.jsp?sucesso=removido");
            }
        }
        }
        %>
    </body>
</html>
