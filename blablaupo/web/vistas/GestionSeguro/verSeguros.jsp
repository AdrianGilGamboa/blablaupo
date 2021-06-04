

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
        <s:action name="verSeguros"></s:action>

            <h2 class="text-info">Seguros</h2>
        <form action="/blablaupo/vistas/GestionSeguro/crearSeguro.jsp">
            <input type="submit" name="crear" value="Crea un seguro"  class="btn btn-primary btn-block">
        </form>
        <table  border=1 cellspacing=1 cellpadding=2 width="100%"  bgcolor="#FFFFFF">
            <tr>  
                <th>ID</th>
                <th>Empresa</th>
                <th>Tipo</th>
                <th>Descripcion</th>
                <th><p align= center>Borrar</p></th>
                <th><p align= center>Modificar</p></th>

            <s:iterator value="#session.listaSeguros" >

            <tr>
                <td><s:property value="idSeguro" /></td>
                <td><s:property value="empresa" /></td>
                <td><s:property value="tipo" /></td>
                <td><s:property value="descripcion" /></td>
                <td>

                    <form action="borrarSeguro" method="post">
                        <input type="hidden" name="id" value="<s:property value="idSeguro"/>"/>
                        <input type="submit" name="botonBorrar" value="Borrar" class="btn btn-primary btn-block"/>
                    </form>
                </td>
                <td>
                    
                    <form action="modificarSeguro.jsp" method="post">
                        <input type="hidden" name="id" value=<s:property value="idSeguro"/>/>
                        <input type="submit" name="botonModificar" value="Modificar" class="btn btn-primary btn-block"/>
                    </form>
                </td>

            </tr>
        </s:iterator>
    </table>

    <s:include value="../footer.jsp"></s:include> 
</body>

</html>
