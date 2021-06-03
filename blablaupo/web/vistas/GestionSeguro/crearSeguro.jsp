<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<html>
    <head>                        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Crear Seguro</title>
        <link href="<s:url value='/design/design.css'></s:url>" rel="stylesheet" type="text/css"/>
        </head>
        <body>
            <div class="container">
                <div class="block-heading">
                    <h2 class="text-info">Pon tu seguro</h2>
                </div>
            <s:form name="RegistroSeguro" action="registrarSeguro" >
                <s:a href="/blablaupo/vistas/inicio.jsp">Volver</s:a>
                    <div class="form-group">
                    <s:label value="Empresa"></s:label>
                    <s:textfield name="empresa" label="Empresa" cssClass="form-control"></s:textfield>
                    </div>
                    <div class="form-group">
                    <s:label value="Tipo"></s:label>
                    <s:textfield name="tipo"  label="Tipo" cssClass="form-control"></s:textfield>
                    </div>
                    <div class="form-group">
                    <s:label value="Descripcion"></s:label>

                    <s:textfield name="descripcion" label="Descripcion" cssClass="form-control" ></s:textfield>
                    </div>
                   
                <s:submit name="aceptar" value="Aceptar" cssClass="btn btn-primary btn-block"></s:submit>
            </s:form>
        </div>

    </body>
</html>

