

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
    <head>                        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Crear Anuncio</title>
        <link href="<s:url value='/design/design.css'></s:url>" rel="stylesheet" type="text/css"/>
        </head>
        <body>
            <div class="container">
                <div class="block-heading">
                    <h2 class="text-info">Pon tu anuncio</h2>
                </div>
            <s:form name="RegistroAnuncio" action="registrarAnuncio" >
                <s:a href="inicio.jsp">Volver</s:a>
                    <div class="form-group">
                    <s:label value="Coste"></s:label>
                    <s:textfield name="coste" label="Coste" cssClass="form-control"></s:textfield>
                    </div>
                    <div class="form-group">
                    <s:label value="Anunciante"></s:label>
                    <s:textfield name="anunciante" value="%{#session.dni}" label="Anunciante" cssClass="form-control"></s:textfield>
                    </div>
                    <div class="form-group">
                    <s:label value="Fecha de inicio"></s:label>

                    <s:textfield name="fechaInicio" label="Fecha de inicio" cssClass="form-control" ></s:textfield>
                    </div>
                    <div class="form-group">
                    <s:label value="Fecha de fin"></s:label>

                    <s:textfield name="fechaFin" label="Fecha de fin" cssClass="form-control" ></s:textfield>
                    </div>
                    <div class="form-group">
                   <s:label value="Multimedia"></s:label>
                   <s:textfield name="multimedia" cssClass="form-control" label="Multimedia"></s:textfield>
                    </div>
                <s:submit name="aceptar" value="Aceptar" cssClass="btn btn-primary btn-block"></s:submit>
            </s:form>
        </div>

    </body>
</html>


