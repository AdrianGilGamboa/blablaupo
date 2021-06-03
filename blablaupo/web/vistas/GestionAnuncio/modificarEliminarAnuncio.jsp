
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <link href="<s:url value='/design/design.css'></s:url>" rel="stylesheet" type="text/css"/>
        </head>
        <body>
            <div class="container">
                <div class="block-heading">
                    <h2 class="text-info">Modifica</h2>
                </div>
            <s:form name="RegistroAnuncio" action="registrarAnuncio" >
                <s:a href="/blablaupo/vistas/inicio.jsp">Inicio</s:a>
                    <div class="form-group">
                    <s:label value="Id"></s:label>
                    <s:textfield name="id" label="id" cssClass="form-control"></s:textfield>
                    </div>
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
