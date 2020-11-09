<%-- 
    Document   : index
    Created on : 13/09/2020, 21:33:37
    Author     : Thiago
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet" type="text/css" href="style.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet">
        <title>Tela Principal</title>
    </head>
    <body>
        
        <header>
            <div class="TextoPrincipal">
                Bem Vindo a Company
            </div>
        </header>
 
        <%
        String cadsstro = request.getParameter("cadsstro");
        if (cadsstro != null){
            if (cadsstro.equals("SUCESSO")){
                %>
       <script> 
          alert("Cadastro com Sucesso"); 
       </script> 
<%
            }
        }  
        %>
        <div class="container">
            <div class="text-center">
                <div style="margin-top: 20%;margin-bottom: -5%"></div>
                    <div clsas="BB1">
                        <button class="button button1" onclick="window.location.href='http://localhost:8080/Projeto/Pagina_Login.jsp';">
                            Logar
                        </button>
                        </div>
                    <div style="margin:  40px;">
                    </div>    
                    <div class="BB2">
                        <button class="button button2" onclick="window.location.href='http://localhost:8080/Projeto/CEO/cadastro.jsp';">
                            Cadastrar-se
                        </button>
                    </div>
            </div>
        </div>
    </body>
</html>

<style>
header{
    width: 100%;
    height: 81px;
    
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

body{
    background-image: url("Imagem_Fundo.jpg");
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
    background: #000000;
}
.button2{
 
    width: 485px;
    height: 83px;
    left: 481px;
    top: 481px;
    background: #000000;

}
</style>