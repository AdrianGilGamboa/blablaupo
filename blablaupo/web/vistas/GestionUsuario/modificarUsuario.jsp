

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

            <div class="container">
                <div class="block-heading">
                    <h2 class="text-info">Mi Perfil</h2>
                </div>
            <s:form name="Modificar" action="modificarUsuario" >
                <div class="form-group">
                    <div class="form-group">
                        <s:label value="Teléfono"></s:label>
                        <s:textfield name="telefono" value="%{#session.usuario.telefono}" label="Telefono" cssClass="form-control"></s:textfield>
                        </div>

                        <div class="form-group">
                        <s:label value="¿Tienes coche?"></s:label>
                            <div class="group-radio">
                            <s:radio name="tipo" list="{'Si','No'}" value="%{#session.usuario.tipo}" cssClass="radio-form"></s:radio>     
                            </div>            
                        </div>
                        <div class="form-group">
                        <s:label value="Contraseña Nueva"></s:label>
                        <s:password name="passwordNueva" label="Contraseña" cssClass="form-control"></s:password>
                        </div>
                        <div class="form-group">
                        <s:label value="Contraseña actual para modificar los datos"></s:label>
                        <s:password name="password" label="Contraseña" cssClass="form-control"></s:password>
                        </div>
                    <s:submit name="modificar" value="Modificar Datos" cssClass="btn btn-primary btn-block"></s:submit>
                    </div>
            </s:form>

            <br/>
            <s:form name="Eliminar" action="eliminarUsuario" cssStyle="padding-top:12px;padding-bottom:1px">
                <div class="form-group">
                    <s:submit name="eliminarUsuario" value="Eliminar Usuario" cssClass="btn btn-primary btn-block"></s:submit>
                    </div>    
            </s:form>

        </div>
    </body>
</html>
