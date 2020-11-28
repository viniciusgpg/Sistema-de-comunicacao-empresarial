<%-- 
    Document   : deletar_equipe
    Created on : 25/10/2020, 01:39:27
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
        <title>deletar equipe</title>
    </head>
    <body>
        <%
            
        HttpSession sessao = request.getSession();
       
        String equipe=request.getParameter("equipe");
        
        String departamento=request.getParameter("departamento");
        
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
                int id_ep=CEOBD.ProcurarID_Equipe(equipe, fun.getID_departamento());
                if(id_ep!=-1){
                    CEOBD.Deletar_Equipe(id_ep);
                    response.sendRedirect("http://sistema-empresarial.herokuapp.com/Menu_Gerente.jsp?sucesso=removido");
                }
                else{
                    response.sendRedirect("http://sistema-empresarial.herokuapp.com/CEO/remover_equipe.jsp?erro=N_EQUIPE");
                }
                
                response.sendRedirect("http://sistema-empresarial.herokuapp.com/Menu_Gerente.jsp");
            }
            else{
                String empresa=ceo.getEmpresa();
               
                String id_dep=CEOBD.procurarCodDep(departamento, empresa);
                int id_ep=CEOBD.ProcurarID_Equipe(equipe, id_dep);
                if(id_dep==null){
                    response.sendRedirect("http://sistema-empresarial.herokuapp.com/CEO/remover_equipes.jsp?erro=N_DEP");
                
                }
                
                else if(id_ep!=-1){
                    CEOBD.Deletar_Equipe(id_ep);
                    response.sendRedirect("http://sistema-empresarial.herokuapp.com/Menu_CEO.jsp?sucesso=removido");
                }
                else{
                    response.sendRedirect("http://sistema-empresarial.herokuapp.com/CEO/remover_equipes.jsp?erro=N_EQUIPE");
                }
                
                
                
            }
        }
        %>
    </body>
</html>
