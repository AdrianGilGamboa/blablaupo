
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
        <s:if test="%{#session.logado=='si'}">
            <div class="container">
                <div class="block-heading">
                    <h2 class="text-info">Valoración del Viaje</h2>
                </div>
                <s:form name="valorarViaje" action="enviarValoracion" >
                    <s:hidden name="id" />
                    <s:label value="Puntuación (1 -> Muy Malo ... 10 -> Muy Bueno)"></s:label>
                    <s:textfield name="puntuacion" cssClass="form-control"></s:textfield>
                    <s:label value="Descripción"></s:label>
                    <s:textfield name="descripcion" cssClass="form-control"></s:textfield>
                    <s:submit name="aceptar" value="Enviar Valoración" cssClass="btn btn-primary btn-block" cssStyle="margin-top:5%;"></s:submit>
                </s:form>
            </div>
            <div class="container" style="margin-top: 3%" >
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
