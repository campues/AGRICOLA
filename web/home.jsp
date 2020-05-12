<%@page import="java.util.List"%>
<%@page import="Modelo.Agricultor"%>
<%@page import="Control.Variables"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true" %>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <title>Home</title>
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

        <link rel="stylesheet" href="./css/icon-centro.css">

    </head>
    <body>

        <!-- Main container -->
        <main class="full-box main-container">
            <!--------------EMCABEZADO------------------->
            <jsp:include page="header.jsp"/>
            <!-- Page content -->
            <section class="full-box page-content">
                <nav class="full-box navbar-info">
                    <a href="#" class="float-left show-nav-lateral">
                        <i class="fas fa-exchange-alt"></i>
                    </a>
                    <a href="user-update.jsp">
                        <i class="fas fa-user-cog"></i>
                    </a>
                    <a href="#" class="btn-exit-system">
                        <i class="fas fa-power-off"> &nbsp;Salir</i>
                    </a>
                </nav>
                <!-- Page header -->
                <div class="full-box page-header">
                    <h3 class="text-left">
                        <img src="assets/img/LOGO.png" style="width: 70px;">&nbsp; SISTEMA AGRICOLA
                    </h3>
                    <p >
                        Los sistemas agrícolas se definen como conjuntos de explotaciones agrícolas individuales con recursos básicos, pautas empresariales, medios familiares de sustento y limitaciones en general similares, a los cuales corresponderían estrategias de desarrollo e intervenciones parecidas. Según el alcance del análisis, un sistema agrícola puede abarcar unas docenas o a muchos millones de familias.
                    </p>
                </div>
               
                <!-- Content -->
                <div class="full-box tile-container">
                    <a href="Controlador?menu=Agricultor&accion=Listar" class="tile">
                        <div class="contenedor">
                            <img class="icon" src="assets/inicio/farmer.png">
                            <p class="tx">Agricultor</p>
                           
                        </div>
                    </a>
                    <a href="Controlador?menu=Lote&accion=Listar" class="tile">
                        <div class="contenedor">
                            <img class="icon" src="assets/inicio/inspeccion.png">
                            <p class="tx">Terrenos</p>
                        </div>
                    </a>
                    <a href="Controlador?menu=Cultivo&accion=Listar" class="tile">
                        <div class="contenedor">
                            <img class="icon" src="assets/inicio/plants.png">
                            <p class="tx">Cultivos</p>
                        </div>
                    </a>

                    <a href="Controlador?menu=Productos&accion=Listar" class="tile">
                        <div class="contenedor">
                            <img class="icon" src="assets/inicio/fertilizer.png">
                            <p class="tx">Productos</p>
                        </div>
                    </a>

                    <a href="Controlador?menu=Empleado&accion=Listar" class="tile">
                        <div class="contenedor">
                            <img class="icon" src="assets/inicio/user01.png">
                            <p class="tx">Usuarios</p>
                        </div>
                    </a>

                </div>

            </section>

        </main>




        <!--=============================================
        =            Include JavaScript files           =
        ==============================================-->
        <!-- jQuery V3.4.1 -->
        <script src="./js/jquery-3.4.1.min.js" ></script>

        <!-- popper -->
        <script src="./js/popper.min.js" ></script>


        <!-- Bootstrap V4.3 -->
        <script src="./js/bootstrap.min.js" ></script>

        <!-- jQuery Custom Content Scroller V3.1.5 -->
        <script src="./js/jquery.mCustomScrollbar.concat.min.js" ></script>

        <!-- Bootstrap Material Design V4.0 -->
        <script src="./js/bootstrap-material-design.min.js" ></script>
        <script>$(document).ready(function () {
                $('body').bootstrapMaterialDesign();
            });</script>
        <script src="./js/main.js" ></script>

        <!-- popper -->
    </body>
</html>