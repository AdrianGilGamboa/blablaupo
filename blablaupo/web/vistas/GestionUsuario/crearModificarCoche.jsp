

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
        <s:if test="%{#session.logado=='si'}">
            <div class="container">
                <div class="block-heading">
                    <h2 class="text-info">Mi Coche</h2>
                </div>
                <s:form name="RegistroCoche" action="registrarCoche" >
                    <s:label value="Matricula"></s:label>
                    <s:textfield name="matricula" value="%{#session.coche.matricula}"  cssClass="form-control"></s:textfield>
                    <s:label value="Color"></s:label>
                    <s:textfield name="color" value="%{#session.coche.color}"  cssClass="form-control"></s:textfield>
                    <s:label value="Modelo"></s:label>
                    <s:textfield name="modelo" value="%{#session.coche.modelo}" cssClass="form-control"></s:textfield>
                    <s:label value="Marca"></s:label>
                    <s:textfield name="marca" value="%{#session.coche.marca}"  cssClass="form-control"></s:textfield>
                    <s:label value="Dni del conductor "></s:label> 
                    <s:textfield name="dni" value="%{#session.usuario.dni}"  cssClass="form-control" readonly="true"></s:textfield>
                    <s:submit name="aceptar" value="Aceptar" cssClass="btn btn-primary btn-block" cssStyle="margin-top:5%;"></s:submit>
                </s:form>
            </div>
            <div class="container" style="margin-top: 3%">
                <img src="/blablaupo/vistas/logo.png" class="logo"/>
            </div>
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
