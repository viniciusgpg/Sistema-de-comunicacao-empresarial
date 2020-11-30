
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="banco.CEOBD"%>

<%@page import="java.util.ArrayList"%>
<%@page import="dominio.CEO"%>
<%@page import="dominio.Funcionario"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet">
        <title>Listar Funcionarios</title>
    </head>
    <body>
    <header>
        <nav class="navbar navbar-default">
            <div class="container-fluid">
                <div class="navbar-header">
                   <a class="navbar-brand" href="http://sistema-empresarial.herokuapp.com/index.jsp">ChatCompany</a>
                </div>
                <ul class="nav navbar-nav">
                  <%CEO ceo=(CEO)session.getAttribute("CEO");
                      if(ceo==null){
                          Funcionario ger=(Funcionario)session.getAttribute("Gerente");
                          if(ger==null){
                             Funcionario fun=(Funcionario)session.getAttribute("Funcionario");
                             if(fun==null){
                                 response.sendRedirect("http://sistema-empresarial.herokuapp.com/index.jsp");
                             }
                             else{%>
                               <li><a href="http://sistema-empresarial.herokuapp.com/Menu_Funcionario.jsp">Menu</a></li>
                               <%
                                   }
                          }else{
                            %>
                               <li><a href="http://sistema-empresarial.herokuapp.com/Menu_Gerente.jsp">Menu</a></li>
                               <%
                            }
                      }else{
                            %>
                               <li><a href="http://sistema-empresarial.herokuapp.com/Menu_CEO.jsp">Menu</a></li>
                               <%
                                   }
                      %>
                  <li><a href="http://sistema-empresarial.herokuapp.com/CEO/sobrenos.jsp">Quem somos</a></li>
                  <li><a href="http://sistema-empresarial.herokuapp.com/CEO/contato.jsp">Fale conosco</a></li>
                </ul>
            </div>
        </nav>
    </header>
        <div class="container" >
            <a class="links" id="paraatrbuit"></a>
                <div class="content">      
                    <div id="dalma">
                        <h1>Lista de Funcionarios</h1>
                        <%
                            //ArrayList<Equipe>eqps=
                        
                        
                        
                        String id_dep="";
                        String departamento=request.getParameter("departamento");
                        if(session.isNew()){
                            response.sendRedirect("http://sistema-empresarial.herokuapp.com/index.jsp");
                        }
                        else{
                            
                            if(ceo==null){
                                Funcionario ger=(Funcionario)session.getAttribute("Gerente");
                                if(ger==null){
                                    response.sendRedirect("http://sistema-empresarial.herokuapp.com/index.jsp");
                                    
                                }
                                else{
                                    id_dep=ger.getID_departamento();
                                    
                                }
                
                            }
                             else{
                                id_dep=CEOBD.procurarCodDep(departamento, ceo.getEmpresa());
                                if(id_dep==null){
                                    response.sendRedirect("http://sistema-empresarial.herokuapp.com/listar_projeto.jsp?erro=N_DEP");
                                }
                            }
                                
                        ArrayList<Funcionario>funs=CEOBD.Mostrar_fun_dep(id_dep);
                                    %>
                                       <table class="tabletest2">
                                    <%                                    
                                    for(int i=0;i<funs.size();i++){
                                        if (i==0){%>
                                            <thead>
                                                <tr class="nhe">                                                           
                                                    <th class="nhi">Nome</th>
                                                    <th class="nhi">Email</th>
                                                    <th class="nhi">Status do Funcionario</th>
                                                    </tr>
                                            </thead><%
                                               }
                                            %>
                                            <tr class="nhe">
                                                <td class="nha"><%=funs.get(i).getNome() %></td>
                                                <td class="nha"><%=funs.get(i).getEmail() %></td>
                                                <td class="nha"><%=funs.get(i).getStt() %> </td>
                                            </tr>
                                        <%
                                    }
                                    %>
                                    </table>
                                    <%
                     
                        
                      
                        }
                        
                        
                        %>
                        <br>
                        <%
                      if(ceo==null){
                          Funcionario ger=(Funcionario)session.getAttribute("Gerente");
                          if(ger==null){
                             Funcionario fun=(Funcionario)session.getAttribute("Funcionario");
                             if(fun==null){
                                 response.sendRedirect("http://sistema-empresarial.herokuapp.com/index.jsp");
                             }
                             else{%>
                              <a href="http://sistema-empresarial.herokuapp.com/Menu_Funcionario.jsp " class="btn btn-primary mb-2 corbotao">Voltar ao Menu</a>
                               <%
                                   }
                          }else{
                            %>
                               <a href="http://sistema-empresarial.herokuapp.com/Menu_Gerente.jsp " class="btn btn-primary mb-2 corbotao">Voltar ao Menu</a>
                               <%
                            }
                      }else{
                            %>
                               <a href="http://sistema-empresarial.herokuapp.com/Menu_CEO.jsp " class="btn btn-primary mb-2 corbotao">Voltar ao Menu</a>
                               <%
                                   }
                      %>
                        
                    </div>
                </div>
        </div>
    </body>
    <div class="footer">
    © ChatCompany 2020
    </div>
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
    min-height: 500px;    
    margin: 0px auto;
    position: relative;   
    }
    .tabletest2 {
        font-size: 15px;
        border-collapse: collapse;
        width: 100%;
    }
    .tabletest2 th, .tabletest2 td {
        padding: 6px;
        text-align: left;
        border-bottom: 1px solid #ddd;
    }
    thead {
        display: table-header-group;
        vertical-align: middle;
        border-color: inherit;
        max-width: 400px;
    }
    .nhe {
        display: table-row;
        vertical-align: middle;
        max-width: 100px;
    }
    .nhi {
        display: table-cell;
        vertical-align: middle;
        max-width: 100px;
    }
    .nha {
        display: table-cell;
        vertical-align: inherit;
        max-width: 100px;
        
    }
    h1{
    font-size: 15px;
    color: #066a75;
    padding: 2px 0 10px 0;
    font-family: Arial,sans-serif;
    font-weight: bold;
    text-align: center;
    padding-bottom: 5px;
    }
    h1:after{
    content: ' ';
    display: block;
    width: 100%;
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
    ::-webkit-input-placeholder  {
    color: #bebcbc; 
    font-style: italic;
    }
    input:-moz-placeholder,
    textarea:-moz-placeholder{
    color: #bebcbc;
    font-style: italic;
    }
    input:not([type="checkbox"]){
    width: 95%;
    margin-top: 4px;
    padding: 10px;    
    border: 1px solid #b2b2b2;
    -webkit-border-radius: 3px;
    border-radius: 3px;
    -webkit-box-shadow: 0px 1px 4px 0px rgba(168, 168, 168, 0.6) inset;
    box-shadow: 0px 1px 4px 0px rgba(168, 168, 168, 0.6) inset;
    -webkit-transition: all 0.2s linear;
    transition: all 0.2s linear;
    }
    input[type="submit"]{
    width: 90%!important;
    cursor: pointer;  
    background: rgb(61, 125, 150);
    padding: 8px 5px;
    color: #fff;
    font-size: 20px;  
    border: 1px solid #fff;   
    margin-bottom: 10px;  
    text-shadow: 0 1px 1px #333;
    -webkit-border-radius: 5px;
    border-radius: 5px;
    transition: all 0.2s linear;
    }
    input[type="submit"]:hover{
    background: #4ab3c6;
    }
    #dalma{
    position: absolute;
    top: 0px;
    width: 100%;   
    padding: 8px 6% 2px 5%;
    margin: 0 0 25px 0;
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
    #paracdtfun:target ~ .content #dalma{
    z-index: 2;
    -webkit-animation-name: fadeInLeft;
    animation-name: fadeInLeft;
     -webkit-animation-delay: .1s;
    animation-delay: .1s;
    }
    .footer {
    position:absolute;
    text-align: center;
    bottom:0;
    width:100%;
    background-color: lemonchiffon;
    }
    .center {
      margin-left: auto;
      margin-right: auto;
    }
    body{
        background-image: url("table.PNG");
        background-repeat: no-repeat;
        background-position:  100% 25%;
        background-size: 100%;

    }
</style>
