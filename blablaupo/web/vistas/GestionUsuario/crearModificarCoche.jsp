

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro</title>
        <link href="<s:url value='/design/design.css'></s:url>" rel="stylesheet" type="text/css"/>
        </head>
        <body>
            <div class="container">
                <div class="block-heading">
                    <h2 class="text-info">Registra tu coche</h2>
                </div>
            <s:form name="RegistroCoche" action="registrarCoche" >
                <s:a href="registroUsuario.jsp">Volver</s:a>
                    <div class="form-group">
                    <s:label value="Matricula"></s:label>
                    <s:textfield name="matricula" label="Matricula" cssClass="form-control"></s:textfield>
                    </div>
                    <div class="form-group">
                    <s:label value="Color"></s:label>
                    <s:textfield name="color" label="Color" cssClass="form-control"></s:textfield>
                    </div>
                <s:label value="Modelo"></s:label>
                <s:textfield name="modelo" label="Modelo" cssClass="form-control"></s:textfield>
                    <div class="form-group">
                    <s:label value="Marca"></s:label>
                    <s:textfield name="marca" label="Marca" cssClass="form-control"></s:textfield>
                    </div>
                    <div class="form-group">
                    <s:label value="Dni del conductor: "></s:label> 
                    <s:textfield value="%{#session.dni}"  cssClass="form-control" readonly="true"></s:textfield>
                    </div>

                <s:submit name="aceptar" value="Aceptar" cssClass="btn btn-primary btn-block"></s:submit>
            </s:form>
        </div>

    </body>
</html>
