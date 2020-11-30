<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
       <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet">
        <title>Menu Gerente</title>
    </head>
    <body> 
          <% 
           String sucesso=request.getParameter("sucesso");
        if(sucesso!=null){
           if(sucesso.equals("criado")){
               %>
                <script> 
                   alert("Criado com Sucesso"); 
               </script> 
               <%
           }else if(sucesso.equals("removido")){
               %>
                <script> 
                    alert("Removido com Sucesso"); 
                </script> 
                 <%
            }else if(sucesso.equals("alterado")){
               
                %>
                <script> 
                    alert("Senha alterada com sucesso"); 
                </script> 
                <%
            }
            else if(sucesso.equals("atribuido")){
               
                %>
                <script> 
                    alert("Atribuido com sucesso"); 
                </script> 
                <%
                }
             else if(sucesso.equals("cadastro")){
               
                %>
                <script> 
                    alert("Cadastrado com sucesso"); 
                </script> 
                <%
                }
            }
           %>
            <nav class="navbar navbar-default">
                <div class="container-fluid">
                  <div class="navbar-header">
                    <a class="navbar-brand" href="http://sistema-empresarial.herokuapp.com/index.jsp">ChatCompany</a>
                  </div>
                  <ul class="nav navbar-nav">
                    <li><a href="http://sistema-empresarial.herokuapp.com/Menu_Gerente.jsp">Menu</a></li>
                    <li><a href="http://sistema-empresarial.herokuapp.com/CEO/sobrenos.jsp">Quem somos</a></li>
                    <li><a href="http://sistema-empresarial.herokuapp.com/CEO/contato.jsp">Fale conosco</a></li>
                  </ul>
                </div>
             </nav>
   
        <div class="container ">
            <div class ="row">
                    <div class="card-body text-center col-md-4">
                    <img src="users.png" alt="funcionario" width="150" height="150">
                    <h5 class="card-title">Funcionario</h5>
                    <a href="http://sistema-empresarial.herokuapp.com/CEO/Atribuir_Funcionario_Equipe_Gerente.jsp" class="btn btn-info btn-block">Atribuir Equipe</a>
                    <a href="http://sistema-empresarial.herokuapp.com/CEO/compor_equipe.jsp" class="btn btn-info btn-block">Criar Equipe</a>
                    <a href="http://sistema-empresarial.herokuapp.com/CEO/equipe_projeto.jsp" class="btn btn-info btn-block">Atribuir Projeto a Equipe</a>
                    <a href="http://sistema-empresarial.herokuapp.com/CEO/cadastrar_funcionarios.jsp" class="btn btn-info btn-block">Cadastrar Funcionario</a>
                    <a href="http://sistema-empresarial.herokuapp.com/CEO/remover_funcionario.jsp" class="btn btn-info btn-block">Remover Funcionario</a>
                    <a href="http://sistema-empresarial.herokuapp.com/alterarsenha.jsp" class="btn btn-info btn-block">Alterar Senha</a>
                    </div>
                
                <div class="card col-md-4" >
                    <div class="card-body text-center"  >
                    <img src="department.png" alt="companhia" width="150" height="150">
                    <h5 class="card-title">Companhia</h5>
                    <a href="http://sistema-empresarial.herokuapp.com/CEO/compor_equipe.jsp" class="btn btn-info btn-block">Atribuir Tarefa</a>
                    <a href="http://sistema-empresarial.herokuapp.com/CEO/criarprojeto.jsp" class="btn btn-info btn-block">Criar Projeto</a>
                    
                    <a href="http://sistema-empresarial.herokuapp.com/CEO/atribuirtarefa.jsp" class="btn btn-info btn-block">Atribuir Tarefa</a>
                    <a href="http://sistema-empresarial.herokuapp.com/CEO/deletartarefa.jsp" class="btn btn-info btn-block">Remover Tarefa</a>
                    <a href="http://sistema-empresarial.herokuapp.com/CEO/alterar_status_projeto.jsp" class="btn btn-info btn-block">Desativar o Projeto</a>
                    <a href="http://sistema-empresarial.herokuapp.com/CEO/remover_equipe.jsp" class="btn btn-info btn-block">Remover Equipe</a>
                    </div>
                </div>
                <div class="card bg-light col-md-4 text-center">
                <div class="card-body">
                  <img src="conversation.png" alt="chat" width="150" height="150">
                  <h5 class="card-title">Outros</h5>
                   <a href="http://sistema-empresarial.herokuapp.com/listar_dep_fun.jsp" class="btn btn-info btn-block">Mostrar Funcionarios do Departamento</a>
                  <a href="http://sistema-empresarial.herokuapp.com/listar_eqp.jsp" class="btn btn-info btn-block">Mostrar Todas Equipes</a>
                  <a href="http://sistema-empresarial.herokuapp.com/listar_fun_equipe.jsp" class="btn btn-info btn-block">Mostrar Funcionarios da Equipe</a>
                  <a href="http://sistema-empresarial.herokuapp.com/listar_projetos.jsp" class="btn btn-info btn-block">Mostrar Todos Projetos</a>
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
