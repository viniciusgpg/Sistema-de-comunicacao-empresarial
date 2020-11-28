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
            response.sendRedirect("http://sistema-empresarial.herokuapp.com/index.jsp");
        }
        else{
            CEO ceo=(CEO) session.getAttribute("CEO");
            if(ceo==null){
                Funcionario fun=(Funcionario) sessao.getAttribute("Gerente");
                if(fun==null){
                    response.sendRedirect("http://sistema-empresarial.herokuapp.com/index.jsp");
                }
                Equipe equipe=new Equipe();
                equipe.setID_departamento(fun.getID_departamento());
                equipe.setNome(nome);
                if(CEOBD.Criar_Equipe(equipe)){
                    response.sendRedirect("http://sistema-empresarial.herokuapp.com/Menu_Gerente.jsp?sucesso=criado");
                }
                else{
                    response.sendRedirect("http://sistema-empresarial.herokuapp.com/CEO/compor_equipe.jsp?erro=N_EQUIPE");
                }
            }
            else{
                String empresa=ceo.getEmpresa();
               
                String id_dep=CEOBD.procurarCodDep(departamento, empresa);
                Equipe equipe=new Equipe();
                equipe.setID_departamento(id_dep);
                equipe.setNome(nome);
                if(id_dep==null){
                    response.sendRedirect("http://sistema-empresarial.herokuapp.com/CEO/compor_equipes.jsp?erro=N_DEP");
                }
                
                else if(CEOBD.Criar_Equipe(equipe)){
                    response.sendRedirect("http://sistema-empresarial.herokuapp.com/Menu_CEO.jsp?sucesso=criado");
                }
                else{
                    response.sendRedirect("http://sistema-empresarial.herokuapp.com/CEO/compor_equipes.jsp?erro=N_EQUIPE");
                }
            }
        }
        %>
    </body>
</html>
