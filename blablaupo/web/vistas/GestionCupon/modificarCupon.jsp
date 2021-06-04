
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
            <div class="container">
                <div class="block-heading">
                    <h2 class="text-info">Modificar cupón</h2>
                </div>
            <s:form name="RegistroCupon" action="editarCupon" >
                <s:a href="/blablaupo/vistas/GestionCupon/verCupones.jsp">Volver</s:a>    
                <s:hidden name="id" value="%{numeroCupon}" ></s:hidden>
                    <s:label value="Código Cupón"></s:label>
                    <s:textfield name="numeroCupon" cssClass="form-control"></s:textfield>
                    <s:label value="Descuento Cupón"></s:label>
                    <s:textfield name="descCupon" cssClass="form-control"></s:textfield>
                    <s:label value="Fecha de inicio"></s:label>
                    <s:textfield name="fechaInicio" cssClass="form-control" ></s:textfield>
                    <s:label value="Fecha de fin"></s:label>
                    <s:textfield name="fechaFin" cssClass="form-control" ></s:textfield>               
                <s:submit name="aceptar" value="Modificar" cssClass="btn btn-primary btn-block"></s:submit>
            </s:form>
        </div>

    </body>
</html>


