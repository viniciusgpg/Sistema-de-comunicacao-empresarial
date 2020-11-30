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
        String dep=request.getParameter("departamento");
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
                String id=CEOBD.procurarCodDep(dep, empresa);
                if(id==null){
                    response.sendRedirect("http://localhost:8080/Company/CEO/alterar_fun_dep.jsp?erro=N_DEP");
                }
                else if(CEOBD.alterar_Fun_dep(email, empresa, id)){
                   response.sendRedirect("http://localhost:8080/Company/Menu_CEO.jsp?sucesso=alterado");
               }
                else{
                    response.sendRedirect("http://localhost:8080/Company/CEO/alterar_fun_dep.jsp?erro=N_EMAIL");
                }
            }
        }
        %>
    </body>
</html>

    </body>
</html>
