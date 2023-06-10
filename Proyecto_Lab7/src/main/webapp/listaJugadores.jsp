<%--
  Created by IntelliJ IDEA.
  User: Julio César
  Date: 9/06/2023
  Time: 22:08
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.Date"%>
<%@ page import="Beans.JugadorBean" %>
<%
    ArrayList<JugadorBean> listaJugadores = (ArrayList<JugadorBean>) request.getAttribute("listaJugadores");
%>
<html>
<!--Colocar como value: nombre de la presente página -->
<jsp:include page="/static/head.jsp">
    <jsp:param name="title" value="Bienvenido"/>
</jsp:include>
<body>
<div class='container'>
    <!--Colocar como value: artistas, canciones, bandas, tours o tpc  (dependiendo de la pagina a la que corresponda) -->
    <jsp:include page="/includes/navbar.jsp">
        <jsp:param name="page" value=""/>
    </jsp:include>
    <div class="pb-5 pt-4 px-3 titlecolor d-flex justify-content-between align-items-center">
        <div class="col-lg-6">
            <h1 class='text-light'>Lista Total de Jugadores</h1>
        </div>
        <a class="btn btn-warning" href="<%=request.getContextPath()%>/JugadorServlet?action=lj">Agregar Jugadores</a>
    </div>
    <div class="tabla">
        <table class="table table-dark table-transparent table-hover">
            <thead>
            <tr>
                <th>ID JUGADOR</th>
                <th>NOMBRE</th>
                <th>EDAD</th>
                <th>POSICION</th>
                <th>CLUB</th>
                <th>SELECCION</th>
                <th></th>
            </tr>
            </thead>

            <tbody>
            <% for (JugadorBean jugador : listaJugadores) { %>
            <tr>
                <td><%=jugador.getIdJugador()%></td>
                <td><%=jugador.getNombre()%></td>
                <td><%=jugador.getEdad()%></td>
                <td><%=jugador.getPosicion()%></td>
                <td><%=jugador.getClub()%></td>
                <td><%=jugador.getSeleccion()%></td>
            </tr>
            <%  }  %>
            </tbody>
        </table>
    </div>
</div>
<jsp:include page="/static/scripts.jsp"/>
</body>
</html>
