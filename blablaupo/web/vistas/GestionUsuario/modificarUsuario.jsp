

<%@page import="dao.UsuariosDAO"%>
<%@page import="entidades.Usuarios"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>BlaBlaUPO-Mi perfil</title>
        <link href="<s:url value='/design/design.css'></s:url>" rel="stylesheet" type="text/css"/>
        </head>
        <body>
 <s:if test="%{#session.logado=='si'}">
            <div class="container">
                <div class="block-heading">
                    <h2 class="text-info">Mi Perfil</h2>
                </div>
            <s:form name="Modificar" action="modificarUsuario" >
                <s:a href="/blablaupo/vistas/inicio.jsp">Volver</s:a>
                <s:label value="Teléfono"></s:label>
                <s:textfield name="telefono" value="%{#session.usuario.telefono}" cssClass="form-control"></s:textfield>
                <s:label value="¿Tienes coche?"></s:label>
                <s:radio name="tipo" list="{'Si','No'}" value="%{#session.usuario.tipo}" cssClass="radio-form"></s:radio>     
                <s:label value="Contraseña Nueva (Opcional)"></s:label>
                <s:password name="passwordNueva" cssClass="form-control"></s:password>
                <s:label value="Contraseña actual para modificar los datos" cssStyle="margin-top:15%;"></s:label>
                <s:password name="password" cssClass="form-control" ></s:password>
                <s:submit name="modificar" value="Modificar Datos" cssClass="btn btn-primary btn-block" cssStyle="margin-top:5%;"></s:submit>
            </s:form>

            <br/>

            <s:if test="%{#session.coche!=null}">
                <s:form name="Mi Coche" action="verCoche" cssStyle="padding-top:1px;padding-bottom:1px">
                    <s:submit name="verCoche" value="Mi Coche" cssClass="btn btn-primary btn-block"></s:submit>
                </s:form>
                <s:form name="Mis Viajes Creados" action="verMisViajes" cssStyle="padding-top:0px;padding-bottom:0px;margin-top:3%;">
                    <s:submit name="verMisViajes" value="Mis Viajes Creados" cssClass="btn btn-primary btn-block"></s:submit>
                </s:form>
            </s:if>

            <s:form name="Eliminar" action="eliminarUsuario" cssStyle="padding-top:0px;padding-bottom:0px;margin-top:3%;">
                <s:submit name="eliminarUsuario" value="Eliminar Usuario" cssClass="btn btn-primary btn-block"></s:submit>
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
