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
                    <h2 class="text-info">Registro</h2>
                </div>
            <s:form name="Registro" action="registroUsuario" >
                <s:a href="login.jsp">Volver</s:a>
                    <div class="form-group">
                    <s:label value="Nombre"></s:label>
                    <s:textfield name="nombre" label="Nombre" cssClass="form-control"></s:textfield>
                    </div>
                    <div class="form-group">
                    <s:label value="Apellidos"></s:label>
                    <s:textfield name="apellidos" label="Apellidos" cssClass="form-control"></s:textfield>
                    </div>
                <s:label value="Contraseña"></s:label>
                <s:password name="password" label="Contraseña" cssClass="form-control"></s:password>
                    <div class="form-group">
                    <s:label value="Email"></s:label>
                    <s:textfield name="email" label="Email" cssClass="form-control"></s:textfield>
                    </div>
                    <div class="form-group">
                    <s:label value="DNI"></s:label>
                    <s:textfield name="dni" label="DNI" cssClass="form-control"></s:textfield>
                    </div>
                    <div class="form-group">
                    <s:label value="Teléfono"></s:label>
                    <s:textfield name="telefono" label="Telefono" cssClass="form-control"></s:textfield>
                    </div>
                    <div class="form-group">
                    <s:label value="¿Tienes coche?"></s:label>
                        <div class="group-radio">
                        <s:radio name="tipo" list="{'Si','No'}" value="False" cssClass="radio-form"></s:radio>     
                        </div>            
                    </div>
                <s:submit name="registrar" value="Registrar" cssClass="btn btn-primary btn-block"></s:submit>
            </s:form>
        </div>
        <div class="container" style="margin-top: 3%">
            <img src="/blablaupo/vistas/logo.png" width="100%"/>
        </div>
    </body>
</html>
