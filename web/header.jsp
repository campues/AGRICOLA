
<% HttpSession sesionOK = request.getSession();%>

<%

    if (session.getAttribute("nom") != null && session.getAttribute("usu") != null) {

    } else {
        out.print("<script>location.replace('index.jsp');</script>");
    }
%>

<!--------------ESTILOS------------------->
<!-- Normalize V8.0.1 -->
<link rel="stylesheet" href="./css/normalize.css">

<!-- Bootstrap V4.3 -->
<link rel="stylesheet" href="./css/bootstrap.min.css">

<!-- Bootstrap Material Design V4.0 -->
<link rel="stylesheet" href="./css/bootstrap-material-design.min.css">

<!-- Font Awesome V5.9.0 -->
<link rel="stylesheet" href="./css/all.css">

<!-- Sweet Alerts V8.13.0 CSS file -->
<link rel="stylesheet" href="./css/sweetalert2.min.css">

<!-- Sweet Alert V8.13.0 JS file-->
<script src="./js/sweetalert2.min.js" ></script>

<!-- jQuery Custom Content Scroller V3.1.5 -->
<link rel="stylesheet" href="./css/jquery.mCustomScrollbar.css">

<!-- General Styles -->
<link rel="stylesheet" href="./css/style.css">
<link rel="stylesheet" href="assets/fonts/style.css">


<!-- ===================MENU LATERAL====================================== -->
<!-- Nav lateral -->
<section class="full-box nav-lateral">
    <div class="full-box nav-lateral-bg show-nav-lateral"></div>
    <div class="full-box nav-lateral-content">

        <figure class="full-box nav-lateral-avatar">
            <i class="far fa-times-circle show-nav-lateral"></i>
            <img src="./assets/avatar/Avatar2.png" class="img-fluid" style="background: #03a9f4;" alt="Avatar">
            <figcaption class="roboto-medium text-center">
                <%=sesionOK.getAttribute("nom")%>  <%=sesionOK.getAttribute("ape")%> <br><small class="roboto-condensed-light"><%=sesionOK.getAttribute("usu")%></small>
            </figcaption>
        </figure>

        <div class="full-box nav-lateral-bar"></div>
        <nav class="full-box nav-lateral-menu">
            <ul>
                <li>
                    <a href="Controlador?menu=Inicio"  ><i class="fas fa-home fa-fw"></i> &nbsp; Inicio</a>
                </li>

                <li>
                    <a href="#" class="nav-btn-submenu"><i class="fas fa-users fa-fw"></i> &nbsp; Agricultores <i class="fas fa-chevron-down"></i></a>
                    <ul>
                        <li>
                            <a href="agricultor-nuevo.jsp"><i class="fas fa-plus fa-fw"></i> &nbsp; Agregar Agricultor</a>
                        </li>
                        <li>
                            <a href="Controlador?menu=Agricultor&accion=Listar"><i class="fas fa-clipboard-list fa-fw"></i> &nbsp; Lista de Agricultores</a>
                        </li>
                        <li>
                            <a href="Controlador?menu=BAgricultor&accion=Entrar"><i class="fas fa-search fa-fw"></i> &nbsp; Buscar Agricultor</a>
                        </li>
                    </ul>
                </li>

                <li>
                    <a href="#" class="nav-btn-submenu"><i class="fas fa-pallet fa-fw"></i> &nbsp; Lotes <i class="fas fa-chevron-down"></i></a>
                    <ul>
                        <li>
                            <a href="lote-nuevo.jsp"><i class="fas fa-plus fa-fw"></i> &nbsp; Agregar </a>
                        </li>
                        <li>
                            <a href="Controlador?menu=Lote&accion=Listar"><i class="fas fa-clipboard-list fa-fw"></i> &nbsp; lista</a>
                        </li>
                        <li>
                            <a href="lote-buscar.jsp"><i class="fas fa-search fa-fw"></i> &nbsp; Buscar </a>
                        </li>
                    </ul>
                </li>

                <li>
                    <a href="#" class="nav-btn-submenu"><i class="fas icon-clipboard fa-fw"></i> &nbsp; Inspeccion <i class="fas fa-chevron-down"></i></a>
                    <ul>
                        <li>
                            <a href="inspeccion-nuevo.jsp"><i class="fas fa-plus fa-fw"></i> &nbsp; Nueva Inspeccion</a>
                        </li>
                        <li>
                            <a href="Controlador?menu=Vistas&accion=Listar"><i class="fas fa-clipboard-list fa-fw"></i> &nbsp; Lista </a>
                        </li>
                        <li>
                            <a href="reservation-search.jsp"><i class="fas fa-search-dollar fa-fw"></i> &nbsp; Buscar</a>
                        </li>
                        <li>
                            <a href="reservation-pending.jsp"><i class="fas fa-hand-holding-usd fa-fw"></i> &nbsp; Items</a>
                        </li>
                    </ul>
                </li>

                <li id="tipoU">
                    <a href="#" class="nav-btn-submenu"><i class="fas  fa-user-secret fa-fw"></i> &nbsp; Usuarios <i class="fas fa-chevron-down"></i></a>
                    <ul>

                        <li>
                            <a href="Controlador?menu=Empleados&accion=Listar"><i class="fas fa-clipboard-list fa-fw"></i> &nbsp; Lista de usuarios</a>
                        </li>

                    </ul>
                </li>

                <li>
                    <a href="Controlador?menu=Asociacion&accion=Listar"><i class="icon-hour-glass"></i> &nbsp; Asociaciones</a>
                </li>

                <li>
                    <a href="Controlador?menu=Detalles&accion=Listar"><i class="icon-add-to-list"></i> &nbsp; Suministro</a>
                </li>

            </ul>
        </nav>

    </div>
    <script>
        <%if (sesionOK.getAttribute("tipo").equals("1")) {%>
        <%} else {%>
        document.getElementById('tipoU').style.display = "none";
        <%}%>
    </script>
</section>
