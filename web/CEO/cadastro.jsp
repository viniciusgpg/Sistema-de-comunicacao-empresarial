<%-- 
    Document   : cadastrar
    Created on : 13/09/2020, 22:56:35
    Author     : Thiago
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet">
        <title>Cadastro de CEO</title>
    </head>
    <body>
        <header>
            <div class="TextoPrincipal">
                Company
            </div>

        </header>

        <div class="container">
            <form name="formCadastro" method="post" action="salvar.jsp">
                <div class="form-row">
                    <div class="form-group form-group col-md-6">
                        <label>Nome</label>
                        <input type="text" class="form-control" name="nome" value=""/>
                    </div>
                    <div class="form-group form-group col-md-6">
                       <label>Nome da Empresa</label>
                        <input type="text" class="form-control" name="nome_empresa" value=""/>
                    </div>
                </div>
                
                <div class="form-row">
                    <div class="form-group form-group col-md-6">
                        <label>Senha</label>
                         <input type="password" class="form-control" name="senha" value=""/>
                    </div>
                    <div class="form-group form-group col-md-6">
                        <label>Confirmar Senha</label>
                        <input type="password"  class="form-control" name="confirmar_senha" value=""/>
                    </div>
                </div>
                
                <div class="form-row">
                    <div class="form-group form-group col-md-6">
                        <label>Email</label>
                        <input type="text" class="form-control" name="email" value=""/>
                    </div>
                    <div class="form-group form-group col-md-6">
                        <label>Telefone</label>
                        <input type="tel" class="form-control" name="telefone" value=""  maxlength="9"/>
                    </div>
                </div>
                
                <div class="form-row">
                    <div class="form-group form-group col-md-4">
                        <label>Data de Nascimento</label>
                        <input type="date" class="form-control" name="idade" placeholder="dd/mm/yyyy" value="">
                    </div>
                </div>
                
                <div class="form-row">
                    <div class="col-md-4"></div>
                    <%
                    String erro = request.getParameter("erro");
                    if (erro != null){
                        if (erro.equals("SENHA_ERRADA")){
                            %>
                            Senha errada. Tente novamente
                            <%
                        } else if(erro.equals("CAMPO_VAZIO")){
                          %>
                          Campo Vazio. Tente novamente
                          <%
                        }else if(erro.equals("EMAIL_EXISTE")){
                          %>
                          Email já foi cadastrado. Tente novamente
                          <%

}
                    }   
                    %>
                    <div><input type="submit" class="btn btn-primary mb-2 corbotao" name="salvar" value="Confirmar"></div>
                </div>
                
            </form>           
        </div>
    </body>
</html>

<style>
    header{
        width: 100%;
        height: 80px;
        margin-bottom: 80px;
        background: #001000;
    }
    .TextoPrincipal{
        position: absolute;
        width: 1440px;
        height: 60px;
        left: 23px;
        top: 21px;

        font-family: 'Montserrat';
        font-style: normal;
        font-weight: 500;
        font-size: 36px;
        line-height: 44px;

        color: #FFFFFF;
    }
    
    .corbotao{
        background-color: #000000;
    }
    .corbotao:hover{
        background-color: #6b6b6b;
    }
    
    
    
    
</style>
