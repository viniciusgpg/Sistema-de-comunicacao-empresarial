<%@page import="banco.CEOBD"%>
<%@page import="java.util.Date"%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="dominio.CEO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de CEO</title>
    </head>
    <body>
        <%
        
        String nome = request.getParameter("nome");
        String nome_empresa = request.getParameter("nome_empresa");
        String senha = request.getParameter("senha");
        String departamento =request.getParameter("departamento");
        String confirma = request.getParameter("confirmar_senha");
        String data = request.getParameter("idade");
        String email = request.getParameter("email");
        String telefone = request.getParameter("telefone");
        

            //SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            //java.util.Date dataUtil = new java.util.Date();
            //dataUtil = formato.parse(data);
            //java.sql.Date dataN= new java.sql.Date(dataUtil.getTime());
            java.sql.Date dataN= java.sql.Date.valueOf("1997-03-31");
            CEO ceo = new CEO();
            ceo.setNome(nome);
            ceo.setEmpresa(nome_empresa);
            //ceo.setData(dataN);
            ceo.setEmail(email);
            ceo.setTelefone(telefone);
            if(senha.equals(confirma)){
                System.out.println("Entro");
                ceo.setSenha(senha);
                //CEOBD.Inserir(ceo);
                response.sendRedirect("http://sistema-empresarial.herokuapp.com/index.jsp?cadsstro=SUCESSO");
            }else{
                System.out.println("Não Entro");
                response.sendRedirect("http://sistema-empresarial.herokuapp.com/CEO/cadastrar.jsp?erro=SENHA_ERRADA");
            }
        %>
        
</html>
