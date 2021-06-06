

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
        <s:if test="%{#session.logado=='si'}">
            <s:include value="../header.jsp"></s:include>
            <s:action name="verSeguros"></s:action>

                <h2 class="text-info">Seguros</h2>
                <form action="/blablaupo/vistas/GestionSeguro/crearSeguro.jsp">
                    <input type="submit" name="crear" value="Crear Seguro!"  class="btn btn-primary btn-block">
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

                            <s:form action="borrarSeguro" method="post" theme="simple">
                                <s:hidden name="id" value="%{idSeguro}"></s:hidden>
                                <s:submit name="botonBorrar" value="Borrar" cssClass="btn btn-primary btn-block"></s:submit>
                            </s:form>
                        </td>
                        <td>

                            <s:form action="modificarSeguro" method="post" theme="simple">
                                <s:hidden name="idSeguro" value="%{idSeguro}"></s:hidden>
                                <s:hidden name="empresa" value="%{empresa}"></s:hidden>
                                <s:hidden name="tipo" value="%{tipo}"></s:hidden>
                                <s:hidden name="descripcion" value="%{descripcion}"></s:hidden>
                                <s:submit name="botonModificar" value="Modificar" cssClass="btn btn-primary btn-block"></s:submit>
                            </s:form>
                        </td>

                    </tr>
                </s:iterator>
            </table>

            <s:include value="../footer.jsp"></s:include> 
        </s:if>
        <s:else>
            <div class="block-heading" style="text-align: center;">
                <h1>BlaBlaCrashed</h1>
                <h3>¡Debe iniciar sesión para acceder al contenido!</h3>
                <br/>
                <s:a href="/blablaupo/vistas/GestionUsuario/login.jsp">
                    Iniciar Sesión
                </s:a>
            </div>

        </s:else>
    </body>

</html>
