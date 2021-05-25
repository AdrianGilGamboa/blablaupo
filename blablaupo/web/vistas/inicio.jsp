<%@taglib prefix="s" uri="/struts-tags"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="<s:url value='/design/designIndex.css'></s:url>" rel="stylesheet" type="text/css"/>
        <link href="<s:url value='/design/designTable.css'></s:url>" rel="stylesheet" type="text/css"/>
            <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons%22%3E">
        </head>
        <body>
        <s:if test="%{#session.logado=='si'}">
            <s:include value="header.jsp"></s:include>
                <div class="cuerpo">
                    <h1>1Hello World!</h1>
                    <h1>2Hello World!</h1>
                    <h1>Hello World!</h1><h1>Hello World!</h1><h1>Hello World!</h1>
                    <h1>Hello World!</h1>
                    <h1>Hello World!</h1>
                    <h1>Hello World!</h1>
                    <h1>Hello World!</h1><h1>Hello World!</h1><h1>Hello World!</h1><h1>Hello World!</h1>
                    <h1>Hello World!</h1><h1>Hello World!</h1><h1>Hello World!</h1><h1>Hello World!</h1>


                </div>     
            <s:include value="footer.jsp"></s:include> 
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
