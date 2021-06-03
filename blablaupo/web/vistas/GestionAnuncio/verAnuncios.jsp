
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
    <head>
        <link href="<s:url value='/design/designIndex.css'></s:url>" rel="stylesheet" type="text/css"/>
        <link href="<s:url value='/design/designTable.css'></s:url>" rel="stylesheet" type="text/css"/>
            <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons%22%3E">
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>JSP Page</title>
        </head>
        <body>
        <s:include value="../header.jsp"></s:include>
        <s:action name="verAnuncio"></s:action>

            <h2 class="text-info">Anuncios</h2>
        <form action="/blablaupo/vistas/GestionAnuncio/crearAnuncio.jsp" class="boton">
            <input type="submit" name="crear" value="Crea tu anuncio!">
        </form>
        <table  border=1 cellspacing=1 cellpadding=2 width="100%"  bgcolor="#FFFFFF">
            <tr>  
                <th>ID</th>
                <th>Coste</th>
                <th>Anunciante</th>
                <th>Fecha de inicio</th>
                <th>Fecha de fin</th>
                <th>Multimedia</th>
                <th><p align= center>Borrar</p></th>
                <th><p align= center>Modificar</p></th>

            <s:iterator value="#session.lista" >

            <tr>
                <td><s:property value="idAnuncio" /></td>
                <td><s:property value="coste" /></td>
                <td><s:property value="anuncinate" /></td>
                <td><s:property value="fechaInicio" /></td>
                <td><s:property value="fechaFin" /></td>
                <td><s:property value="multimedia" /></td>
                <td>

                    <form action="borrarAnuncio" method="post">
                        <input type="hidden" name="id" value=<s:property value="idAnuncio" />/>
                        <input type="submit" name="botonBorrar" value="Borrar" />
                    </form>
                </td>
                <td>

                    <form action="/blablaupo/vistas/GestionAnuncio/modificarAnuncio.jsp" method="post">
                        <input type="hidden" name="id" value=<s:property value="idAnuncio" /> />
                        <input type="submit" name="botonModificar" value="Modificar" />
                    </form>
                </td>

            </tr>
        </s:iterator>
    </table>

    <s:include value="../footer.jsp"></s:include> 
</body>

</html>
