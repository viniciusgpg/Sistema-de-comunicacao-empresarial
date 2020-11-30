<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="dominio.CEO"%>
<%@page import="dominio.Funcionario"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet">
        <!-- Latest compiled and minified JavaScript -->
       
        <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
        
        <title>Chat Online</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        </head>
    <body>
        <header>
            <nav class="navbar navbar-default">
                <div class="container-fluid">
                  <div class="navbar-header">
                    <a class="navbar-brand" href="http://localhost:8080/Company/index.jsp">ChatCompany</a>
                  </div>
                  <ul class="nav navbar-nav">
                      <%CEO ceo=(CEO)session.getAttribute("CEO");
                      if(ceo==null){
                          Funcionario ger=(Funcionario)session.getAttribute("Gerente");
                          if(ger==null){
                             Funcionario fun=(Funcionario)session.getAttribute("Funcionario");
                             if(fun==null){
                                 response.sendRedirect("http://localhost:8080/Company/index.jsp");
                             }
                             else{%>
                               <li><a href="http://localhost:8080/Company/Menu_Funcionario.jsp">Menu</a></li>
                               <%
                                   }
                          }else{
                            %>
                               <li><a href="http://localhost:8080/Company/Menu_Gerente.jsp">Menu</a></li>
                               <%
                            }
                      }else{
                            %>
                               <li><a href="http://localhost:8080/Company/Menu_CEO.jsp">Menu</a></li>
                               <%
                                   }
                      %>
                    <li><a href="http://localhost:8080/Company/CEO/sobrenos.jsp">Quem somos</a></li>
                    <li><a href="http://localhost:8080/Company/CEO/contato.jsp">Fale conosco</a></li>
                  </ul>
                </div>
             </nav>
        </header>
        <div>
            <div class="chat-box">
                <div class="panel panel-primary">
                    <div class="panel-heading">
                        <% 
                         
                        session.setAttribute("id_proj", request.getParameter("id"));
                        %>
                       
                        <span class="glyphicon glyphicon-comment"></span> Chat
                        <div class="btn-group pull-right">
                            <button type="button" class="btn btn-default btn-xs dropdown toggle" data-toggle="dropdown">
                                <span class="glyphicon glyphicon-chevron-down"></span>
                            </button>
                            <ul class="dropdown-menu slidedown">
                               
                                <%
                        
                      if(ceo==null){
                          Funcionario ger=(Funcionario)session.getAttribute("Gerente");
                          if(ger==null){
                             Funcionario fun=(Funcionario)session.getAttribute("Funcionario");
                             if(fun==null){
                                 response.sendRedirect("http://localhost:8080/Company/index.jsp");
                             }
                             else{%>
                               <li><a href="http://localhost:8080/Company/Menu_Funcionario.jsp"><span class="glyphicon glyphicon-off"></span>Sair</a></li>
                               <%
                                   }
                          }else{
                            %>
                               <li><a href="http://localhost:8080/Company/Menu_Gerente.jsp"><span class="glyphicon glyphicon-off"></span>Sair</a></li>
                               <%
                            }
                      }else{
                            %>
                               <li><a href="http://localhost:8080/Company/Menu_CEO.jsp"><span class="glyphicon glyphicon-off"></span>Sair</a></li>
                               <%
                                   }
                      %>
                                
                            </ul>
                        </div>
                        
                    </div>
                    
                    <div class="panel-body chat-widget">
                        <ul class="chat chat-messages">                
  
                            
                        </ul>
                    </div>
                    
                    
                    
                </div>
            </div>
        </div>
        <script src="https://js.pusher.com/7.0/pusher.min.js"></script>
        <script src="js/chat.js"></script>
        <script>

 var pusher = new Pusher('e15436bca8cc094862cc', {
      cluster: 'us2'
    });
     var chat = new ChatWidget(pusher);
  </script>
        <div class="footer">
        © ChatCompany 2020
        </div>
    </body>
</html>

<style>
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
    ul{list-style: none;
    }
    li {
    float: left;
    text-decoration: none;
    }

    li a {
      display: block;
      color: white;
      text-align: center;
      padding: 14px 16px;
      text-decoration: none;
    }
    .content{
    width: 500px;
    min-height: 560px;    
    margin: 0px auto;
    position: relative;   
    }
    h1{
    font-size: 25px;
    color: #066a75;
    padding: 2px 0 10px 0;
    font-family: Arial,sans-serif;
    font-weight: bold;
    text-align: center;
    padding-bottom: 30px;
    }
    h1:after{
    content: ' ';
    display: block;
    width: 90%;
    height: 2px;
    margin-top: 10px;
    background: -webkit-linear-gradient(left, rgba(147,184,189,0) 0%,rgba(147,184,189,0.8) 20%,rgba(147,184,189,1) 53%,rgba(147,184,189,0.8) 79%,rgba(147,184,189,0) 100%); 
    background: linear-gradient(left, rgba(147,184,189,0) 0%,rgba(147,184,189,0.8) 20%,rgba(147,184,189,1) 53%,rgba(147,184,189,0.8) 79%,rgba(147,184,189,0) 100%); 
    }
    p{
    margin-bottom:15px;
    }
    .content p:first-child{
    margin: 0px;
    }
    .chat-box{
        justify-content: center;
        display: block;
        padding-right: 300px;
        padding-left: 300px;
    }
    .chat{
        list-style: none;
        margin: 0;
        padding: 0;
        min-width: 350px;
    }
    .chat li{
        margin-bottom: 10px;
        padding-bottom: 5px;
        border-bottom: 1px dotted #B3A9A9;
        width: 100%;
    }
    .chat li .chat-body p{
        margin: 0;
        color: #777777;
    }
    .panel .slidedown .glyphicon, .chat .glyphicon{
        margin-right: 5px;
    }
    .panel-body{
        overflow-y: scroll;
        height: 250px;
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
</style>