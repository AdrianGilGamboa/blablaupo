<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="Expires" content="0">
        <meta http-equiv="Last-Modified" content="0">
        <meta http-equiv="Cache-Control" content="no-cache, mustrevalidate">
        <meta http-equiv="Pragma" content="no-cache">
        <link href="<s:url value='/design/design.css'></s:url>" rel="stylesheet" type="text/css"/>
            <title>Login</title>
        <s:head/>
    </head>
    <body>
        <div class="container">
            <div class="block-heading">
                <h2 class="text-info">Inicar Sesión</h2>
            </div>
            <s:form action="comprobarLogin" method="post">
                <div class="form-group">
                    <s:label value="Email"></s:label>
                    <s:textfield name="email" cssClass="form-control"></s:textfield>
                    </div>
                    <div class="form-group">
                    <s:label value="Contraseña"></s:label>
                    <s:password name="password" cssClass="form-control"></s:password>
                    </div>
                <s:submit name="acceder" value="Acceder" cssClass="btn btn-primary btn-block"></s:submit>
                    <p style="text-align: center; margin-top: 5%; margin-bottom: 0;">
                    <s:text name="¿No tienes cuenta aún? "></s:text><s:a href="../vistas/GestionUsuario/registroUsuario.jsp">Regístrate</s:a>
                    </p>
            </s:form>

        </div>
        <div class="container" style="margin-top: 3%">
            <img src="/blablaupo/vistas/logo.png" width="100%"/>
        </div>
    </body>
</html>

