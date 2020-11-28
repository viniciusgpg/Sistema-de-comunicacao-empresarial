<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet" type="text/css" href="style.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet">
        <title>Tela principal</title>
    </head>
    <body>
        <%
        if(!session.isNew()){
            session.invalidate();
        }
        %>
        <header>
            <nav class="navbar navbar-default">
                <div class="container-fluid">
                  <div class="navbar-header">
                    <a class="navbar-brand" href="http://sistema-empresarial.herokuapp.com/index.jsp">ChatCompany</a>
                  </div>
                  <ul class="nav navbar-nav">
                    <li><a href="http://sistema-empresarial.herokuapp.com/CEO/sobrenos.jsp">Quem somos</a></li>
                    <li><a href="http://sistema-empresarial.herokuapp.com/CEO/contato.jsp">Fale conosco</a></li>
                  </ul>
                </div>
             </nav>
        </header>
        <%
        String cadsstro = request.getParameter("cadastro");
        if (cadsstro != null){
            if (cadsstro.equals("SUCESSO")){
                %>
                alert("Cadastro com Sucesso");
                <%
            }
        }   
        %>
        <div class="container">
            <div class="text-center">
                <div style="margin-top: 20%;margin-bottom: -5%"></div>
                    <div clsas="BB1">
                        <button class="button button1" onclick="window.location.href='http://sistema-empresarial.herokuapp.com/Pagina_Login.jsp';">
                            Logar
                        </button>
                        </div>
                    <div style="margin:  40px;">
                    </div>    
                    <div class="BB2">
                        <button class="button button2" onclick="window.location.href='http://sistema-empresarial.herokuapp.com/CEO/cadastrar.jsp';">
                            Cadastrar-se
                        </button>
                    </div>
            </div>
        </div>
        <div class="footer">
        © ChatCompany 2020
        </div>
    </body>
</html>
<style>
    header {
    width: 100%;
    height: 20px;
    }
    .navbar-default {
        background-color: #887799;
        border-color: #5A76E7;
    }
    
    .navbar-brand {
        float: left;
        padding: 15px 15px;
        font-weight: bolder;
        font-size: 18px;
        line-height: 20px;
        color: #001000;
    }
    ul{
        list-style: none;
    }
    li {
        float: left;
        text-decoration: none;
        color: #001000;
    }
    li a {
      display: block;
      color: white;
      text-align: center;
      padding: 14px 16px;
      text-decoration: none;
    }
    .footer {
        position:absolute;
        text-align: center;
        bottom:0;
        width:100%;
        background-color: lemonchiffon;
    }
    
    body{
        background-image: url("img.jpg");
        background-repeat: no-repeat;
        background-position:  100% 25%;
        background-size: 100%;
        

    }
    .button {
        border: none;
        color: white;
        padding: 15px 32px;
        text-align: center;
        text-decoration: none;
        font-family: 'Itim';
        font-size: 22px;
        display: inline-block;
        font-size: 16px;
        margin: 4px 2px;
        cursor: pointer;
        box-shadow: 7px 10px 12px rgba(0, 0, 0, 0.3);
        border-radius: 50px;
    }

    .button1{
        width: 478px;
        height: 82px;
        left: 481px;
        top: 324px;
        background: #ACFBF5;
        color: #001000;
    }
    .button2{

        width: 485px;
        height: 83px;
        left: 481px;
        top: 481px;
        background: #ACFBF5;
        color: #001000;
    }
</style>
