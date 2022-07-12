<%--
  Created by IntelliJ IDEA.
  User: Niurka
  Date: 12/07/2022
  Time: 13:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="sinjefe" type="java.lang.Integer" class="java.lang.Integer"/>
<jsp:useBean id="peliculas3d" type="java.lang.Integer" class="java.lang.Integer"/>
<jsp:useBean id="empleados9700" type="java.lang.Integer" class="java.lang.Integer"/>
<jsp:useBean id="cadena" type="com.example.ef_g1.Beans.Cadena" class="com.example.ef_g1.Beans.Cadena"/>
<jsp:include page="head.jsp">
    <jsp:param name="title" value="index"/>
</jsp:include>
<!--Navbar-->
<jsp:include page="navbar.jsp">
    <jsp:param name="page" value=""/>
</jsp:include>




<html>
<head>
    <title>Reportes</title>
    <STYLE TYPE="text/css">
        body{
            font-family: Arial;
        }
        #cerrar {
            position:absolute;
            right:4px;
            top:2px
        }
        #main-container{
            margin: 10px ;
            width: 1200px;
        }
        table.clase{
            background-color: white;
            text-align: center;
            border-collapse: collapse;
            width: 100%;
            position: static;
            left: 100%;
            top: 300%;
            margin-top: 1px;
        }
        th.clase, td.clase{
            padding: 20px;
        }
        thead.clase{
            background-color: #052434;
            border-bottom: solid 5px #353837;
            color: white;
        }
        tr.clase:nth-child(even){
            background-color: #ddd;
        }
        tr.clase:hover td{
            background-color: #706e6e;
            color: white;
        }
    </STYLE>
</head>
<body>
<br><br><br><br><br><br>
<div align="center">
    <a  type="submit"
        href=""
        name="reporte"
        class="btn btn-tele border-start-1"
    > Ir a Funciones</a></div>
<br>

<h2>Cantidad de empleados sin jefe: </h2>
<form method="post" action="<%=request.getContextPath()%>/ReportesServlet?action=listar1">
    <input type="hidden" name="ola">
    <button type="submit"><h2><%=sinjefe%></h2></button>
</form>
<br>
<h2>Cantidad de películas en 3D: </h2>
<h2><%=peliculas3d%></h2>
<br>
<h2>Cantidad de cines cuyos empleados tengan un salario mayor a 9700: </h2>
<h2><%=empleados9700%></h2>
<br>
<h2>Cadena de cine con la mayor cantidad de películas en cartelera: </h2>
<table>
    <thead>
    <tr>
        <td>Razón Social</td><td>Nombre Comercial</td><td>RUC</td>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td><%=cadena.getRazonSocial()%></td><td><%=cadena.getNombreComercial()%></td><td><%=cadena.getRuc()%></td>
    </tr>
    </tbody>
</table>

</body>
</html>
