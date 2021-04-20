<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro</title>
    </head>
    <body>
        <s:form name="Registro" action="registro">
            <s:textfield name="nombre" label="Nombre"></s:textfield>
            <s:textfield name="apellidos" label="Apellidos"></s:textfield>
            <s:textfield name="password" label="Contraseña"></s:textfield>
            <s:textfield name="email" label="Email"></s:textfield>
            <s:textfield name="dni" label="DNI"></s:textfield>
            <s:textfield name="telefono" label="Telefono"></s:textfield>
            

        </s:form>
    </body>
</html>
