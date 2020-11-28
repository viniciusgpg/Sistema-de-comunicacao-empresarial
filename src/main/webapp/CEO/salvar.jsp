<%@page import="banco.CEOBD"%>
<%@page import="java.util.Date"%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="dominio.CEO"%>

<%@page import="dominio.Funcionario"%>
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
       
        String confirma = request.getParameter("confirmar_senha");
        String email = request.getParameter("email");
        String telefone = request.getParameter("telefone");
        String RG=request.getParameter("RG");
       
        
            //CEOBD.validarEmail(email)
            if(CEOBD.validarEmail(email)){
                
                
                    response.sendRedirect("http://sistema-empresarial.herokuapp.com/CEO/cadastrar_funcionario.jsp?erro=Email_existe");
  
            }else{
                
                     CEO ceo = new CEO();
                     ceo.setNome(nome);
                     ceo.setEmpresa(nome_empresa);
                    //ceo.setData(dataN);
                    ceo.setEmail(email);
                    ceo.setTelefone(telefone);
                    if(senha.equals(confirma)){
                        System.out.println("Entro");
                        ceo.setSenha(senha);
                        CEOBD.Inserir(ceo);
                        response.sendRedirect("http://sistema-empresarial.herokuapp.com/index.jsp?cadsstro=SUCESSO");
                    }else{
                        System.out.println("Não Entro");
                        response.sendRedirect("http://sistema-empresarial.herokuapp.com/CEO/cadastrar.jsp?erro=SENHA_ERRADA");
                    }
                }
                
            
        %>
        
</html>
