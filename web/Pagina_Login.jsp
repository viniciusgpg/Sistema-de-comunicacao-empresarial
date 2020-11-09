<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet">
        <title>Pagina de Login</title>
    </head>
    <body>
        <header>
            <div class="TextoPrincipal">
                Company
            </div>
        </header>

        <div class="container">
            <div class="col-md-3" > </div>
            <div class="col-md-8 ml-md-auto row align-items-center ">
                <form name="formlogin" method="post" action="logar.jsp">
                    <div class="form-row">
                        <div class=" form-group form-group col-md-5">
                            <label>Login</label>
                            <input type="text" name="email" class="form-control" value="" placeholder="Insira o Email"/>
                        </div>
                        <div class="form-group form-group col-md-4">
                            <label>Senha</label>
                            <input type="password" name="senha" class="form-control" value=""/>               
                        </div>
                    </div>

                    <div class="form-row">
                        <div class="form-group form-group col-md-6">
                            <input type="submit" class="btn btn-primary mb-2 corbotao" name="entrar" value="Acessar"/>
                            <%
                            String erro = request.getParameter("erro");
                            if (erro != null){
                                if (erro.equals("USUARIO_NAO_EXISTE")){
                                    %>
                                    Senha ou Usuario incorreto
                                    <%
                                }
                            }   
                            %>
                        </div>           
                    </div>
                </form>                
            </div>
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