
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
            <s:a href="../vistas/GestionAnuncio/verAnuncios">Anuncios</s:a>
            <s:a href="../vistas/GestionSeguro/verSeguros">Seguros</s:a>

                <!-- Right-aligned links -->
                <div class="topnav-right">
                    <a href="">Mi Perfil</a>
                <s:a href="../vistas/GestionSeguro/verSeguros">Cerrar Sesi�n</s:a>
            </div>

        </div>
    </nav>
</header>
