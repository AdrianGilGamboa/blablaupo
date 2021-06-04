
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
        <s:form action="/vistas/GestionAnuncio/crearAnuncio.jsp" theme="simple">
            <s:submit name="crear" value="Crea tu anuncio!"  class="btn btn-primary btn-block"></s:submit>
        </s:form>
        <table  border=1 cellspacing=1 cellpadding=2 width="100%"  bgcolor="#FFFFFF">
            <tr>  
                <th>ID</th>
                <th>Coste</th>
                <th>Anunciante</th>
                <th>Fecha Inicio</th>
                <th>Fecha Fin</th>
                <th>Multimedia</th>
                <th><p align= center>Borrar</p></th>
                <th><p align= center>Modificar</p></th>

            <s:iterator value="#session.lista" >

            <tr>
                <td><s:property value="idAnuncio" /></td>
                <td><s:property value="coste" /> €</td>
                <td><s:property value="anunciante" /></td>
                <td><s:property value="fechaInicio" /></td>
                <td><s:property value="fechaFin" /></td>
                <td><s:property value="multimedia" /></td>
                <td>

                    <s:form action="borrarAnuncio" method="post" theme="simple">
                        <s:hidden name="id" value="%{idAnuncio}"></s:hidden>
                        <s:submit name="botonBorrar" value="Borrar" cssClass="btn btn-primary btn-block"></s:submit>
                    </s:form>
                </td>
                <td>
                    <s:form action="modificarAnuncio" method="post" theme="simple">
                        <s:hidden name="idAnuncio" value="%{idAnuncio}"></s:hidden>
                        <s:hidden name="coste" value="%{coste}"></s:hidden>
                        <s:hidden name="anunciante" value="%{anunciante}"></s:hidden>
                        <s:hidden name="fechaInicio" value="%{fechaInicio}"></s:hidden>
                        <s:hidden name="fechaFin" value="%{fechaFin}"></s:hidden>
                        <s:hidden name="multimedia" value="%{multimedia}"></s:hidden>
                        <s:submit name="botonModificar" value="Modificar" cssClass="btn btn-primary btn-block"></s:submit>
                    </s:form>
                </td>
            </tr>
        </s:iterator>
    </table>

    <s:include value="../footer.jsp"></s:include> 
</body>

</html>
