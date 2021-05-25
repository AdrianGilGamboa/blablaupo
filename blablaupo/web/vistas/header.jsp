
<%@taglib prefix="s" uri="/struts-tags"%>

<header>
    <link href="design/designIndex.css" rel="stylesheet" type="text/css"/>

    <nav>
        <div class="topnav">

            <!-- Centered link -->
            <div class="topnav-centered">
                <s:a href="inicio.jsp" cssClass="img-header" cssStyle="padding:0;"><img src="logo.png" width="80%"/></s:a>
            </div>

                <!-- Left-aligned links (default) -->
            <s:a href="inicio.jsp">Viajes</s:a>
            <s:a href="../vistas/GestionCupon/verCupones.jsp">Cupones</s:a>
            <s:a href="../vistas/GestionAnuncio/verAnuncios.jsp">Anuncios</s:a>
            <s:a href="../vistas/GestionSeguro/verSeguros.jsp">Seguros</s:a>

                <!-- Right-aligned links -->
                <div class="topnav-right">
                    <a href="">Mi Perfil</a>
                <s:a>
                        <form action="cerrarSesion" method="post">
                      <s:submit name="salir" value="Cerrar Sesion" cssClass="btn btn-primary btn-block"></s:submit>
                    </form>
                </s:a>
            </div>

        </div>
    </nav>
</header>
