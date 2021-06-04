<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<html>
     <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <s:head/>
        <title>Registro</title>
        <link href="<s:url value='/design/design.css'></s:url>" rel="stylesheet" type="text/css"/>
        </head>
        <body>
            <div class="container">
                <div class="block-heading">
                    <h2 class="text-info">Modificar Seguro</h2>
                </div>

            <s:form name="Modificar" action="editarSeguro" cssStyle="width:100%;">
                <s:a href="/blablaupo/vistas/GestionSeguro/verSeguros.jsp">Volver</s:a>
                <s:hidden value="%{idSeguro}" name="idSeguro"></s:hidden>
                <s:label value="Empresa"></s:label>
                <s:textfield name="empresa" cssClass="form-control"></s:textfield>
                <s:label value="Tipo"></s:label>
                <s:textfield name="tipo" cssClass="form-control"></s:textfield>
                <s:label value="Descripcion"></s:label>
                <s:textfield name="descripcion" cssClass="form-control"></s:textfield>   
            <s:submit name="aceptar" value="Aceptar" cssClass="btn btn-primary btn-block"></s:submit>
              
        </s:form>
    </div>
    <div class="container" style="margin-top: 3%" >
        <img src="/blablaupo/vistas/logo.png" class="logo"/>
    </div>
</body>
</html>


