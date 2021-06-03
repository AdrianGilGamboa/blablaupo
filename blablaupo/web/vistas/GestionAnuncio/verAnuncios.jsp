
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
    <head>
                <link href="<s:url value='/design/design.css'></s:url>" rel="stylesheet" type="text/css"/>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <s:action name="verAnuncio"></s:action>
        <h1>Ver Anuncios</h1>
         <s:a href="/blablaupo/vistas/inicio.jsp">Inicio</s:a>
        <table border=1 cellspacing=1 cellpadding=2 width="50%" bgcolor="#FFFFFF">
            <tr>  
                <th>Coste</th>
                <th>Anunciante</th>
                <th>Fecha de inicio</th>
                <th>Fecha de fin</th>
                <th>Multimedia</th>
                <th>
                    <form action="add.jsp" method="post">                       
                        <input type="submit" name="btnForm" value="Alta" />
                    </form>
                </th>
            </tr>
               
            </tr>
             <s:iterator value="#session.lista" >

                <tr>
                    <td><b><s:property value="coste" /></b></td>
                    <td><b><s:property value="anuncinate" /></b></td>
                    <td><b><s:property value="fechaInicio" /></b></td>
                    <td><b><s:property value="fechaFin" /></b></td>
                    <td><b><s:property value="multimedia" /></b></td>
                </tr>
            </s:iterator>
        </table>
        
    </body>
</html>
