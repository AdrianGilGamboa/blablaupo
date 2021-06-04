
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
    <head>                        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Crear Cupón</title>
        <link href="<s:url value='/design/design.css'></s:url>" rel="stylesheet" type="text/css"/>
        </head>
        <body>
            <s:action name="creaCodigo"></s:action>
            <div class="container">
                <div class="block-heading">
                    <h2 class="text-info">Nuevo Cupón</h2>
                </div>
            <s:form name="RegistroCupon" action="registrarCupon" >
                <s:a href="/blablaupo/vistas/GestionCupon/verCupones.jsp">Volver</s:a>
                    <s:label value="Código Cupón"></s:label>
                    <s:textfield name="codigo" value= "%{#session.codigo}" cssClass="form-control"></s:textfield>
                    <s:label value="Descuento Cupón"></s:label>
                    <s:textfield name="descuento" cssClass="form-control"></s:textfield>
                    <s:label value="Fecha de inicio"></s:label>
                    <s:textfield name="fechaInicio" cssClass="form-control" ></s:textfield>
                    <s:label value="Fecha de fin"></s:label>
                    <s:textfield name="fechaFin" cssClass="form-control" ></s:textfield>                 
                <s:submit name="aceptar" value="Crear Cupón" cssClass="btn btn-primary btn-block" cssStyle="margin-top:5%;"></s:submit>
            </s:form>
        </div>

    </body>
</html>


