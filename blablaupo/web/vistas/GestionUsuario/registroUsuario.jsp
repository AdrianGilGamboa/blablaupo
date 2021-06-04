<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <s:head/>
        <title>Registro</title>
        <link href="<s:url value='/design/design.css'></s:url>" rel="stylesheet" type="text/css"/>
        </head>
        <body>
            <div class="container">
                <div class="block-heading" style="margin-left: 3%;">
                    <h2 class="text-info">Registro Usuario</h2>
                </div>
            <s:form name="Registro" action="registroUsuario" cssStyle="width:100%;">
                <s:label value="Nombre"></s:label>
                <s:textfield name="nombre" cssClass="form-control"></s:textfield>
                <s:label value="Apellidos"></s:label>
                <s:textfield name="apellidos" cssClass="form-control"></s:textfield>
                <s:label value="Contraseña"></s:label>
                <s:password name="password" cssClass="form-control"></s:password>
                <s:label value="Email"></s:label>
                <s:textfield name="email" cssClass="form-control"></s:textfield>
                <s:label value="DNI"></s:label>
                <s:textfield name="dni" cssClass="form-control"></s:textfield>
                <s:label value="Teléfono"></s:label>
                <s:textfield name="telefono" cssClass="form-control"></s:textfield>
                <s:label value="¿Tienes coche?"></s:label>
                    <s:radio name="tipo" list="{'Si','No'}" cssClass="radio-form"></s:radio>     
                </div>
            <s:submit name="registrar" value="Registrar" cssClass="btn btn-primary btn-block"></s:submit>
                <p style="text-align: center; margin-top: 5%; margin-bottom: 0;">
                <s:text name="¿Ya tienes cuenta? "></s:text><s:a href="login.jsp">Iniciar Sesión</s:a>
                </p>
        </s:form>
    </div>
    <div class="container" style="margin-top: 3%" >
        <img src="/blablaupo/vistas/logo.png" class="logo"/>
    </div>
</body>
</html>
