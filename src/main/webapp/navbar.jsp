<%@ page import="com.example.ef_g1.Beans.Empleado" %>
<%@ page import="java.security.spec.ECParameterSpec" %><%--
  Created by IntelliJ IDEA.
  User: Niurka
  Date: 12/07/2022
  Time: 12:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!--Navbar-->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:useBean id="usuario" type="com.example.ef_g1.Dto.RolesEmpleadosDto" scope="session"/>
<nav class="navbar sticky-top navbar-expand-lg " style="background-color:#052434" >
    <!---->

    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse justify-content-end" id="navbarSupportedContent">

        <ul class="navbar-nav">
            Bienvenido: <%=usuario.getE().getNombre()+" "+usuario.getE().getApellido()+" | Rol: "+usuario.getRol().getNombre()%>
            <li class="nav-item">
                <a  type="submit"
                    name="Cerrar Sesion"
                    class="btn btn-tele border-start-1"
                    class="nav-link" href="<%=request.getContextPath()%>/?action=logout"><b>Cerrar Sesión</b></a>
            </li>

        </ul>

    </div>
</nav>