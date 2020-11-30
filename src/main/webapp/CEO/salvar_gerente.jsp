<%@page import="banco.CEOBD"%>
<%@page import="java.util.Date"%>
<%@page import="dominio.CEO"%>
<%@page import="java.text.SimpleDateFormat"%>
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
        HttpSession sessao = request.getSession();
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String telefone = request.getParameter("telefone");
        String RG=request.getParameter("RG");
        String cod ;
        String departamento =request.getParameter("Departamento");
        String botao=request.getParameter("Gerente");
        
        
        if(sessao.isNew()){
            response.sendRedirect("http://sistema-empresarial.herokuapp.com/index.jsp");
        }else{
            Funcionario ger = (Funcionario) sessao.getAttribute("Gerente");
           if(ger==null){
                CEO ceo = (CEO) session.getAttribute("CEO");
                if(ceo==null){
                    response.sendRedirect("http://sistema-empresarial.herokuapp.com/index.jsp?cadsstro=LOGIN_EXPIRADO");
                 }
                else{ 
                     cod=CEOBD.procurarCodDep(departamento, ceo.getEmpresa());
                    if(cod==null){
                        response.sendRedirect("http://sistema-empresarial.herokuapp.com/CEO/cadastrar_funcionario.jsp?erro=DEP_N_EXISTE");
                    }
                    else{
                        Funcionario fun=new Funcionario();
                        fun.setID_departamento(cod);
                        fun.setRG(RG);
                        fun.setNome(nome);
                        
                        if(CEOBD.validarEmail(email)){
                          response.sendRedirect("http://sistema-empresarial.herokuapp.com/CEO/cadastrar_funcionario.jsp?erro=Email_existe");
                        }
                        fun.setEmail(email);
                        fun.setEmpresa(ceo.getEmpresa());
                        if(botao!=null){
                            fun.setStatus_GERENTE(true);
                        }
                        else{
                            fun.setStatus_GERENTE(false);
                        }
                        CEOBD.Cadastrar_Funcionario(fun);
                        response.sendRedirect("http://sistema-empresarial.herokuapp.com/Menu_CEO.jsp?sucesso=criado");
                        //fun.setStatus_GERENTE(status_GERENTE);
                    }
               
                }
           }
           else{
            cod=ger.getID_departamento();
            Funcionario fun=new Funcionario();
            fun.setID_departamento(cod);
            fun.setRG(RG);
            fun.setNome(nome);
            if(CEOBD.validarEmail(email)){
                response.sendRedirect("http://sistema-empresarial.herokuapp.com/CEO/cadastrar_funcionarios.jsp?erro=Email_existe");
            }
            fun.setEmail(email);
            fun.setEmpresa(ger.getEmpresa());
            fun.setStatus_GERENTE(false);
            CEOBD.Cadastrar_Funcionario(fun);
             response.sendRedirect("http://sistema-empresarial.herokuapp.com/Menu_Gerente.jsp?sucesso=criado");
                       
           }
            }
            
                
        %>
        
</html>
