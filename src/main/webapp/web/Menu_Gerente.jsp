<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
       <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet">
        <title>Menu Gerente</title>
    </head>
    <body>
            <nav class="navbar navbar-default">
                <div class="container-fluid">
                  <div class="navbar-header">
                    <a class="navbar-brand" href="http://sistema-empresarial.herokuapp.com/index.jsp">ChatCompany</a>
                  </div>
                  <ul class="nav navbar-nav">
                    <li><a href="#">Sobre nós</a></li>
                    <li><a href="#">Serviço</a></li>
                    <li><a href="#">Contato</a></li>
                  </ul>
                </div>
             </nav>
   
        <div class="container ">
            <div class ="row">
                    <div class="card-body text-center col-md-4">
                    <img src="users.png" alt="funcionario" width="190" height="190">
                    <h5 class="card-title">Funcionario</h5>
                    <a href="http://sistema-empresarial.herokuapp.com/CEO/cadastrar_funcionarios.jsp" class="btn btn-info btn-block">Cadastrar Funcionario</a>
                    <a href="http://sistema-empresarial.herokuapp.com/CEO/Atribuir_Departamento_Equipe.jsp" class="btn btn-info btn-block">Atribuir Equipe</a>
                    <a href="http://sistema-empresarial.herokuapp.com/CEO/remover_funcionario.jsp" class="btn btn-info btn-block">Remover Funcionario</a>
                    </div>
                
                <div class="card col-md-4" >
                    <div class="card-body text-center"  >
                    <img src="department.png" alt="companhia" width="190" height="190">
                    <h5 class="card-title">Companhia</h5>
                    <a href="http://sistema-empresarial.herokuapp.com/CEO/compor_equipe.jsp" class="btn btn-info btn-block">Atribuir Tarefa</a>
                    <a href="http://sistema-empresarial.herokuapp.com/CEO/criarprojeto.jsp" class="btn btn-info btn-block">Criar Projeto</a>
                    <a href="http://sistema-empresarial.herokuapp.com/CEO/atribuirtarefa.jsp" class="btn btn-info btn-block">Criar Equipe</a>
                    <a href="http://sistema-empresarial.herokuapp.com/CEO/deletartarefa.jsp" class="btn btn-info btn-block">Remover Tarefa</a>
                    <a href="http://sistema-empresarial.herokuapp.com/CEO/remover_projeto.jsp" class="btn btn-info btn-block">Remover Projeto</a>
                    </div>
                </div>
                <div class="card bg-light col-md-4 text-center">
                <div class="card-body">
                  <img src="conversation.png" alt="chat" width="190" height="190">
                  <h5 class="card-title">Chat</h5>
                  <a href="#" class="btn btn-info btn-block">Enviar Mensagem Geral </a>
                  <a href="#" class="btn btn-info btn-block">Enviar Mensagem Departamento</a>
                  <a href="#" class="btn btn-info btn-block">Enviar Mensagem Equipe</a>
                </div>
                </div>
            </div>
            </div>
            </div>
        </div>    
    <div class="footer">
    © ChatCompany 2020
    </div>
    </body>
</html>
<style>
    
    
    .card-body{
    top: 0px;
    height:450px;
    width:350px;
    padding: 18px 6% 60px 6%;
    margin: 0 0 35px 0;
    background: #f7f7f7;
    border: 1px solid rgba(147, 184, 189,0.8);
    -webkit-box-shadow: 5px;
    border-radius: 5px;
    -webkit-animation-duration: 0.5s;
    -webkit-animation-timing-function: ease;
    -webkit-animation-fill-mode: both;
    animation-duration: 0.5s;
    animation-timing-function: ease;
    animation-fill-mode: both;
    }
    .card-title{
        color:#001000;
        font-weight:bold;
        
    }
    header {
    width: 100%;
    height: 20px;
    }
    .navbar-default {
        background-color: #ACFBF5;
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
    .container col-sm-10{
        display: flex;
        width: 100vw;
        justify-content: space-around;
        margin-top: 100px;
    }
    .footer {
        position:absolute;
        text-align: center;
        bottom:0;
        width:100%;
        background-color: lemonchiffon;
    }

    body{
        background-image: url("table.PNG");
        background-repeat: no-repeat;
        background-position:  100% 25%;
        background-size: 100%;
    }

    .btn-info{
        font-weight: bold;
      
    }
</style>
