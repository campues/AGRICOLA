<%@page import="Control.Variables"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <title>Lista de items</title>

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
        <script src="./js/sweetalert2.min.js"></script>

        <!-- jQuery Custom Content Scroller V3.1.5 -->
        <link rel="stylesheet" href="./css/jquery.mCustomScrollbar.css">

        <!-- General Styles -->
        <link rel="stylesheet" href="./css/style.css">


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
                        <i class="fas fa-power-off"></i>
                    </a>
                </nav>
                <!-- Page header -->
                <div class="full-box page-header">
                    <h3 class="text-left">
                        <i class="fas fa-clipboard-list fa-fw"></i> &nbsp; LISTA DE INSPECCIONES
                    </h3>
                    <p class="text-justify">
                        lista de Inspecciones realizadas
                    </p>
                </div>
                <div class="container-fluid">
                    <ul class="full-box list-unstyled page-nav-tabs">
                        <li>
                            <a href="Controlador?menu=Visitas&accion=Nuevo"><i class="fas fa-plus fa-fw"></i> &nbsp; NUEVA INSPECCION</a>
                        </li>
                        <li>
                            <a  class="active" href="Controlador?menu=Visitas&accion=Listar"><i class="fas fa-clipboard-list fa-fw"></i> &nbsp; LISTA INSPECCIONES</a>
                        </li>
                        <li>
                            <a href="Controlador?menu=Lote&accion=Listar"><i class="fas fa-backspace fa-fw"></i> &nbsp; Regresar</a>
                        </li>
                    </ul>
                </div>
                <!--CONTENT-->
                <div class="container-fluid">
                    <strong class="text-danger">
                        Nada...!
                    </strong>
                    <div class="table-responsive">
                        <table class="table table-dark table-sm">
                            <thead>
                                <tr class="text-center roboto-medium">
                                    <th>Id</th>
                                    <th>Fecha</th>
                                    <th>Informante</th>
                                    <th>Tipo Inspec.</th>
                                    <th>Lote</th>
                                    <th>Empleado</th>
                                    <th class="ac" >Eliminar</th>
                                    <th class="ac" >Cultivo</th>
                                    <th class="ac" >Apicultura</th>

                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="v" items="${listaVi}">
                                    <tr class="text-center">
                                        <td>${v.pk_visitas}</td>
                                        <td>${v.fecha}</td>
                                        <td>${v.nom_informante}</td>
                                        <td>${v.tipoInspeccion}</td>
                                        <td>${v.fk_lote}</td>
                                        <td>${v.fk_empleadov}</td>

                                        <td  class="btnLis"><a  class="btn btn-raised btn-danger btn-sm" href="Controlador?menu=Visitas&accion=Eliminar&pk_visitas=${v.pk_visitas}">
                                                <i class="far fa-trash-alt"></i></a>
                                        </td >
                                        <td  class="btnLis"><a class="btn btn-raised btn-success btn-sm" href="Controlador?menu=Visitas&accion=VerCultivo&pk_visitas=${v.pk_visitas}">
                                                <i class="fas fa-clipboard-list"></i></a>
                                        </td>
                                        <td  class="btnLis"><a class="btn btn-raised btn-dark btn-sm" href="Controlador?menu=Visitas&accion=VerColmena&pk_visitas=${v.pk_visitas}">
                                                <i class="fas fa-box-open"></i></a>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <nav >

                    </nav>
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
    </body>
</html>