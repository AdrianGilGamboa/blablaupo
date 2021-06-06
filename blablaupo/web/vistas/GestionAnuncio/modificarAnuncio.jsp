

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
    <head>                        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modificar Anuncio</title>
        <link href="<s:url value='/design/design.css'></s:url>" rel="stylesheet" type="text/css"/>
        </head>
        <body>
        <s:if test="%{#session.logado=='si'}">
            <div class="container">
                <div class="block-heading">
                    <h2 class="text-info">Modificar Anuncio</h2>
                </div>
                <s:form name="editarAnuncio" action="editarAnuncio" >
                    <s:a href="/blablaupo/vistas/GestionAnuncio/verAnuncios.jsp">Volver</s:a>
                    <s:hidden value="%{idAnuncio}" name="idAnuncio"></s:hidden>
                    <s:label value="Coste"></s:label>
                    <s:textfield name="coste" cssClass="form-control"></s:textfield>
                    <s:label value="Anunciante"></s:label>
                    <s:textfield name="anunciante" cssClass="form-control"></s:textfield>
                    <s:label value="Fecha Inicio (dd/MM/yyyy)"></s:label>
                    <s:textfield name="fechaInicio" cssClass="form-control" ></s:textfield>
                    <s:label value="Fecha Fin (dd/MM/yyyy)"></s:label>
                    <s:textfield name="fechaFin" cssClass="form-control" ></s:textfield>
                    <s:label value="Multimedia"></s:label>
                    <s:textfield name="multimedia" cssClass="form-control" ></s:textfield>
                    <s:submit name="aceptar" value="Modificar" cssClass="btn btn-primary btn-block" cssStyle="margin-top:5%;"></s:submit>
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

