<%@taglib prefix="s" uri="/struts-tags"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="<s:url value='/design/designIndex.css'></s:url>" rel="stylesheet" type="text/css"/>
        <link href="<s:url value='/design/designTable.css'></s:url>" rel="stylesheet" type="text/css"/>
            <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons%22%3E">
        </head>
        <body>
        <s:if test="%{#session.logado=='si'}">
            <s:include value="../header.jsp"></s:include>


                <table  border=1 cellspacing=1 cellpadding=2 width="100%"  bgcolor="#FFFFFF" style="margin-top: 10%;">

                    <tr>  
                        <th>Origen</th>
                        <th>Destino</th>
                        <th>Coste</th>
                        <th>Fecha-Hora Salida</th>
                        <th>Fecha-Hora Llegada</th>
                        <th>Seguro</th>
                        <th>Teléfono Conductor</th>
                        <th><p align= center>Eliminar Reserva</p></th>
                        <th><p align= center>Valorar Viaje</p></th>

                    </tr>

                <s:iterator value="%{listaMisViajesReservados}">

                    <tr>
                        <td><s:property value="origen" /></td>
                        <td><s:property value="destino" /></td>
                        <td><s:property value="coste" /> €</td>
                        <td><s:date name="horaSalida"  format="dd/MM/yyyy - HH:mm"/></td>
                        <td><s:date name="horaLlegada"  format="dd/MM/yyyy - HH:mm"/></td>
                        <td><s:property value="usuario.dni" /></td>
                        <td><s:property value="seguros.idSeguro" /></td>
                        <td>
                            <s:form action="eliminarReserva" method="post" theme="simple">
                                <s:hidden name="id" value="%{idViaje}"></s:hidden>
                                <s:submit name="eliminarReserva" value="Eliminar" cssClass="btn btn-primary btn-block"></s:submit>
                            </s:form>
                        </td>
                        <td>
                            <s:form action="valorarViaje" method="post" theme="simple">
                                <s:hidden name="id" value="%{idViaje}"></s:hidden>
                                <s:submit name="valorarViaje" value="Valorar" cssClass="btn btn-primary btn-block"></s:submit>
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

