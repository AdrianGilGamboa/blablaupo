<%-- 
    Document   : login
    Created on : 20-abr-2021, 20:05:09
    Author     : manum
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <s:form action="comprobarLogin" method="post">
            <s:textfield name="email" label="Email"></s:textfield>
            <s:password name="password" label="Contraseña"></s:password>
            <s:submit name="acceder" value="Acceder"></s:submit>
        </s:form>
    </body>
</html>

