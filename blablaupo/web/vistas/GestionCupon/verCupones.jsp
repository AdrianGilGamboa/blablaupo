
<%@page import="java.util.List"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
    <head>
        <link href="<s:url value='/design/designIndex.css'></s:url>" rel="stylesheet" type="text/css"/>
        <link href="<s:url value='/design/designTable.css'></s:url>" rel="stylesheet" type="text/css"/>
            <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons%22%3E">
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>Cupones</title>
        </head>
        <body>
        <s:if test="%{#session.logado=='si'}">
            <s:include value="../header.jsp"></s:include>
            <s:action name="mostrarCupones"></s:action>
            <s:if test="%{#session.usuario.tipo=='Admin'}">
                <s:form action="/vistas/GestionCupon/crearCupon.jsp" theme="simple">
                    <s:submit name="crear" value="Crear Cupón!" cssClass="btn btn-primary btn-block" cssStyle="margin-top: 5%;"></s:submit>
                </s:form>
            <table  border=1 cellspacing=1 cellpadding=2 width="100%"  bgcolor="#FFFFFF">
            </s:if>
            <s:else>
                <table  border=1 cellspacing=1 cellpadding=2 width="100%"  bgcolor="#FFFFFF" style="margin-top: 10%;">
                </s:else>
                <tr>  
                    <th>Codigo Cupón</th>
                    <th>Porcentaje Descuento</th>
                    <th>Fecha Inicio</th>
                    <th>Fecha Fin</th>
                        <s:if test="%{#session.usuario.tipo=='Admin'}">
                        <th><p align= center>Borrar</p></th>
                        <th><p align= center>Modificar</p></th>
                        </s:if>

                    <s:iterator value="#session.lista" >

                    <tr>
                        <td><s:property value="numeroCupon" /></td>
                        <td><s:property value="descCupon" /> %</td>
                        <td><s:date name="fechaInicio"  format="dd/MM/yyyy"/></td>
                        <td><s:date name="fechaFin"  format="dd/MM/yyyy"/></td>
                        <s:if test="%{#session.usuario.tipo=='Admin'}">
                            <td>
                                <s:form action="borrarCupon" method="post" theme="simple">
                                    <s:hidden name="codigo" value="%{numeroCupon}"></s:hidden>
                                    <s:submit name="botonBorrar" value="Borrar" cssClass="btn btn-primary btn-block"></s:submit>
                                </s:form>
                            </td>
                            <td>
                                <s:form  action="modificarCupon" theme="simple">
                                    <s:hidden name="numeroCupon" value="%{numeroCupon}" ></s:hidden>
                                    <s:hidden name="descCupon" value="%{descCupon}" ></s:hidden>
                                    <s:hidden name="fechaInicio" value="%{fechaInicio}" ></s:hidden>
                                    <s:hidden name="fechaFin" value="%{fechaFin}" ></s:hidden>
                                    <s:submit name="botonModificar" value="Modificar" cssClass="btn btn-primary btn-block"/>
                                </s:form>
                            </td>
                        </s:if>
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
