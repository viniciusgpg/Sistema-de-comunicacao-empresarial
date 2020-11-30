<%@page import="dominio.CEO"%>
<%@page import= "banco.CEOBD "%>

<%
String login = request.getParameter("email");
String senha = request.getParameter("senha");

boolean CEOEncontrado = CEOBD.procurarPorLoginSenha(login, senha);
if (CEOEncontrado){
    session.setAttribute("CEO", CEOEncontrado);
    response.sendRedirect("http://localhost:8080/Company/Menu_CEO.jsp");
}else{
    response.sendRedirect("http://localhost:8080/Company/Pagina_Login.jsp?erro=USUARIO_NAO_EXISTE");
}
%>
