<%--
  Created by IntelliJ IDEA.
  User: Julio César
  Date: 10/06/2023
  Time: 11:25
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.Date"%>
<%@ page import="Beans.SeleccionBean" %>
<%
  ArrayList<SeleccionBean> listaSelecciones = (ArrayList<SeleccionBean>) request.getAttribute("listaSelecciones");
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
    <a class="btn btn-warning" href="<%=request.getContextPath()%>/SeleccionServlet?action=ls">Agregar Partidos</a>
  </div>
  <div class="tabla">
    <table class="table table-dark table-transparent table-hover">
      <thead>
      <tr>
        <th>ID SELECCIÓN</th>
        <th>NOMBRE</th>
        <th>TÉCNICO</th>
        <th>ESTADIO</th>
        <th>ID SELECCION LOCAL</th>
        <th>ID SELECCION VISITANTE</th>
        <th>FECHA PARTIDO</th>
        <th></th>
      </tr>
      </thead>

      <tbody>
      <% for (SeleccionBean seleccion : listaSelecciones) { %>
      <tr>
        <td><%=seleccion.getIdSeleccion()%></td>
        <td><%=seleccion.getNombre()%></td>
        <td><%=seleccion.getTecnico()%></td>
        <td><%=seleccion.getNombreEstadio()%></td>
        <td><%=seleccion.getIdSeleccionLocal()%></td>
        <td><%=seleccion.getIdSeleccionVisitante()%></td>
        <td><%=seleccion.getFecha()%></td>
      </tr>
      <%  }  %>
      </tbody>
    </table>
  </div>
</div>
<jsp:include page="/static/scripts.jsp"/>
</body>
</html>

