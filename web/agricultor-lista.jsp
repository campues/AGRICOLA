<%@page import="Control.Variables"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <title>Lista de clientes</title>

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
                        <i class="fas fa-clipboard-list fa-fw"></i> &nbsp; LISTA DE AGRICULTORES
                    </h3>
                    <p class="text-justify">
                        Lista de agricultores
                    </p>
                </div>

                <div class="container-fluid">
                    <ul class="full-box list-unstyled page-nav-tabs">
                        <li>
                            <a href="agricultor-nuevo.jsp"><i class="fas fa-plus fa-fw"></i> &nbsp; AGREGAR AGRICULTORES</a>
                        </li>
                        <li>
                            <a class="active" href="Controlador?menu=Agricultor&accion=Listar"><i class="fas fa-clipboard-list fa-fw"></i> &nbsp; LISTA DE AGRICULTORES</a>
                        </li>
                        <li>
                            <a  href="Controlador?menu=Agricultor&accion=Enlistar"><i class="fas fa-search fa-fw"></i> &nbsp; BUSCAR AGRICULTOR</a>
                        </li>
                    </ul>	
                </div>

                <!-- Content here-->
                <div class="container-fluid">
                    <div class="table-responsive">
                        <table class="table table-dark table-sm">
                            <thead>
                                <tr class="text-center roboto-medium">
                                    <th>ID</th>
                                    <th>Nombre</th>
                                    <th>Apellido</th>
                                    <th>Cedula</th>
                                    <th>Telefono</th>
                                    <th>Estatus</th>
                                    <th>Fecha Afiliacion</th>
                                    <th class="ac">Editar</th>
                                    <th class="ac">Eliminar</th>
                                    <th class="ac" >Lotes</th>

                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="a" items="${listaAgri}">
                                    <tr class="text-center"> 
                                        <td>${a.pk_agricultor}</td>
                                        <td>${a.nombre1}</td>
                                        <td>${a.apellido1}</td>
                                        <td>${a.cedula}</td>
                                        <td>${a.telefono}</td>
                                        <td>${a.estatus}</td>
                                        <td>${a.fechaAfiliacion}</td>

                                        <td class="btnLis"><a  title="Actualizar datos del Agricultor" class="btn btn-raised btn-success btn-sm" href="Controlador?menu=Agricultor&accion=showedit&pk_agricultor=${a.pk_agricultor}">
                                                <i class="fas  fa-sync-alt"></i></a>
                                        </td>
                                        <td class="btnLis"><a title="Eliminar Agricultor"  id="elimina" class="btn btn-raised btn-danger btn-sm" href="Controlador?menu=Agricultor&accion=Eliminar&pk_agricultor=${a.pk_agricultor}">
                                                <i class="far fa-trash-alt"></i></a>
                                        </td>
                                        <td class="btnLis"><a title="Lotes del Agricultor" class="btn btn-raised btn-dark btn-sm" href="Controlador?menu=Agricultor&accion=VerTerreno&pk_agricultor=${a.pk_agricultor}">
                                                <i class="fas fa-box-open"></i></a>
                                        </td>

                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>

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