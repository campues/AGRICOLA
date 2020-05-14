<%@page import="Control.Variables"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <title>Lista de items</title>
        <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.21/css/dataTables.bootstrap4.min.css"/> 
    </head>

    <body>
           <!-- Main container -->
        <main class="full-box main-container">
            <!--------------EMCABEZADO------------------->
            <jsp:include page="header.jsp"/>
            <!-- Dialog help -->
            <jsp:include page="ayuda.jsp"/>
            <!-- Page content -->
            <section class="full-box page-content">
                <nav class="full-box navbar-info">
                    <a href="#" class="float-left show-nav-lateral">
                        <i class="fas fa-exchange-alt"></i>
                    </a>
                    <a href="#!" data-toggle="modal"  data-target="#ModalInfo">
                        <i title="Ayuda" class="fas icon-help-with-circle"></i>
                    </a>
                    <a href="#" class="btn-exit-system">
                        <i class="fas fa-power-off"> &nbsp;Salir</i>
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
                            <a href="Controlador?menu=Lote&accion=Listar"><i class="fas icon-back fa-fw"></i> &nbsp; Regresar</a>
                        </li>
                    </ul>
                </div>
                <!--CONTENT-->
                <div class="container-fluid">
                    <strong class="text-danger">
                        Nada...!
                    </strong>
                    <div class="table-responsive">
                        <table id="tablalist" class="table table-dark table-sm">

                            <thead>
                                <tr class="roboto-medium">
                                    <th>Id</th>
                                    <th>Fecha</th>
                                    <th>Informante</th>
                                    <th>Tipo Inspec.</th>
                                    <th>Lote</th>
                                    <th>Empleado</th>

                                    <th class="ac text-center" >Opciones</th>

                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="v" items="${listaVi}">
                                    <tr>
                                        <td>${v.pk_visitas}</td>
                                        <td>${v.fecha}</td>
                                        <td>${v.nom_informante}</td>
                                        <td>${v.tipoInspeccion}</td>
                                        <td>${v.fk_lote}</td>
                                        <td>${v.fk_empleadov}</td>
                                        <td  class="text-center">
                                            <%if (session.getAttribute("tipo").equals("1")) {%> 
                                            <a title="Eliminar registro"  class="btn btn-raised btn-danger btn-sm" href="Controlador?menu=Visitas&accion=Eliminar&pk_visitas=${v.pk_visitas}">
                                                <i class="far fa-trash-alt"></i></a>
                                            <a title="Apicultura" class="btn btn-raised btn-dark btn-sm" href="Controlador?menu=Visitas&accion=VerColmena&pk_visitas=${v.pk_visitas}">
                                                <i class="fas fa-box-open"></i></a>
                                            <a  title="Cultivos" class="btn btn-raised btn-success btn-sm" href="Controlador?menu=Visitas&accion=VerCultivo&pk_visitas=${v.pk_visitas}">
                                                <i class="fas fa-clipboard-list"></i></a>
                                                <%} else {%>
                                            <a title="Apicultura" class="btn btn-raised btn-dark btn-sm" href="Controlador?menu=Visitas&accion=VerColmena&pk_visitas=${v.pk_visitas}">
                                                <i class="fas fa-box-open"></i></a>
                                            <a  title="Cultivos" class="btn btn-raised btn-success btn-sm" href="Controlador?menu=Visitas&accion=VerCultivo&pk_visitas=${v.pk_visitas}">
                                                <i class="fas fa-clipboard-list"></i></a>
                                                <%}%>

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
            <!--    Datatables-->
            <script src="js/jquery-3.4.1.min.js" type="text/javascript"></script>
            <script type="text/javascript" src="https://cdn.datatables.net/v/bs4/dt-1.10.20/datatables.min.js"></script> 
            <script src="js/datetable.js" type="text/javascript"></script>
        </main>
        <!-- jQuery Custom Content Scroller V3.1.5 -->
        <script src="./js/jquery.mCustomScrollbar.concat.min.js"></script>

        <!-- Bootstrap Material Design V4.0 -->
        <script src="./js/bootstrap-material-design.min.js"></script>
        <script>
            $(document).ready(function () {
                $('body').bootstrapMaterialDesign();
            });
        </script>

        <script src="./js/main.js"></script>
    </body>
</html>