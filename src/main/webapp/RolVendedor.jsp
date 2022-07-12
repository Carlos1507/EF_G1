<%@ page import="com.example.ef_g1.Beans.Cartelera" %><%--
  Created by IntelliJ IDEA.
  User: Niurka
  Date: 12/07/2022
  Time: 11:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="ListaCartelera" scope="request" type="java.util.ArrayList<com.example.ef_g1.Beans.Cartelera>"/>
<jsp:include page="head.jsp">
    <jsp:param name="title" value="index"/>
</jsp:include>
<!--Navbar-->
<jsp:include page="navbar.jsp">
    <jsp:param name="page" value=""/>
</jsp:include>

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
<br><br><br>

</table>
</form>
</center>
<br><br>
<br><br>
<center>
    <h1><b><font color="Black">PELÍCULAS EN CARTELERA</font> </b></h1>
</center>
<br>
<center>
    <div id="main-container" >

        <table class="clase">
            <thead class="clase">
            <tr class="clase">
                <th class="clase">Cadena</th >
                <th class="clase">Cine</th >
                <th class="clase">Película</th >
                <th class="clase">Horario</th >
            </tr>
            </thead>
            <tbody>
            <% for(Cartelera cartelera : ListaCartelera){ %>
            <tr class="clase">
                <td class="clase"><%=cartelera.getCine().getCadena().getNombreComercial()%></td>
                <td class="clase"><%=cartelera.getCine().getNombre()%></td>
            <%String nombrePeli = "";
              nombrePeli+=cartelera.getPelicula().getNombre();
              if(cartelera.getTresD()==1){
                  nombrePeli+=" - 3D";
              }else{
                  nombrePeli+=" -";
              }
              if(cartelera.getSubtitulada()==1){
                  nombrePeli+=" Subtitulada";
              }
              if(cartelera.getDoblada()==1){
                  nombrePeli+=" Doblada";
              }
              nombrePeli+=".";
            %>
                <td class="clase"><%=nombrePeli%></td>
                <td class="clase"><%=cartelera.getHorario()%></td>
            </tr>
            <%}%>
            </tbody>
        </table>
    </div>
</center>