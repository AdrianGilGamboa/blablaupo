
<%@taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>                        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Crear Anuncio</title>
        <link href="<s:url value='/design/design.css'></s:url>" rel="stylesheet" type="text/css"/>
        </head>
        <body>
            <div class="container">
                <div class="block-heading">
                    <h2 class="text-info">Nuevo Viaje</h2>
                </div>
            <s:form name="RegistroViaje" action="crearViaje" >
                <s:a href="/blablaupo/vistas/inicio.jsp">Volver</s:a>
                <s:label value="Origen"></s:label>
                <s:textfield name="origen" cssClass="form-control"></s:textfield>
                <s:label value="Destino"></s:label>
                <s:textfield name="destino" cssClass="form-control"></s:textfield>
                <s:label value="Fecha-Hora Salida (dd/MM/yyyy HH:mm)"></s:label>
                <s:textfield name="fechaSalida" cssClass="form-control" ></s:textfield>
                <s:label value="Fecha-Hora Llegada (dd/MM/yyyy HH:mm)"></s:label>
                <s:textfield name="fechaLlegada" cssClass="form-control" ></s:textfield>
                <s:label value="Coste"></s:label>
                <s:textfield name="coste" cssClass="form-control" ></s:textfield>
                <s:label value="Seguro"></s:label>
                <s:textfield name="seguro" cssClass="form-control" ></s:textfield>
                <s:label value="Numero de Pasajeros"></s:label>
                <s:textfield name="numPasajeros" cssClass="form-control" ></s:textfield>
                <s:submit name="aceptar" value="Crear Viaje" cssClass="btn btn-primary btn-block" cssStyle="margin-top:5%;"></s:submit>
            </s:form>
        </div>

    </body>
</html>
