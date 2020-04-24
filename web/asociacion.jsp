<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <title>Datos de la empresa</title>

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
                <div class="page-header">
                    <h4 class="text-left">
                        <i class="fas fa-building fa-fw"></i> &nbsp; CENTROS DE ACOPIOS
                    </h4>Entidades de apoyo comunitario
                    <div class="text-center">
                        <a class="etiqueta3" href="Controlador?menu=Asociacion&accion=Listar"><i class="fas fa-clipboard-list fa-fw"></i> &nbsp; LISTAS ASOCIACION</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <a class="etiqueta3" href="#" data-toggle="modal" data-target="#ModalBuscar"><i class="fas fa-search fa-fw"></i> &nbsp; BUSCAR ASOCIACION</a>
                    </div>
                </div>
                <!-- ============================================MODAL HERRAMIENTAS=============================0 -->
                <div class="modal fade" id="ModalBuscar" tabindex="-1" role="dialog" aria-labelledby="ModalBuscar" aria-hidden="true">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="etiqueta">¿A que asociacion estas buscando?</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <form class="modal-body" action="Controlador?menu=Asociacion" method="POST"  >
                                <div class="form-group">
                                    <label  class="bmd-label-floating">Ingresa el Nombre</label>
                                    <input type="text"  class="form-control" name="txtBusqueda" required="" title="Ingresa el nombre">
                                </div>
                                <p class="text-center">
                                    <button   type="submit" name="accion" value="Buscar" class="btn btn-raised btn-info "><i class="fas fa-search "></i> &nbsp; BUSCAR</button>
                                </p>
                            </form>
                        </div>
                    </div>
                </div>
                <!-- ===================================================================================================== -->
                <div class="container-fluid">
                    <form  name="frm" action="Controlador?menu=Asociacion"  class="form-neon"  method="POST" >
                        <fieldset>
                            <legend><i class="far fa-building"></i> &nbsp;Información de la asociacion</legend>
                            <div class="container-fluid">
                                <div class="row">
                                    <div class="form-group label-floating">
                                        <div class="form-group">
                                            <input type="hidden"  name="pk" class="form-control"  value="${aso.pk_asociacion}">
                                        </div>
                                    </div>
                                    <div class="col-12 col-md-4">
                                        <div class="form-group">
                                            <label  class="bmd-label-floating">Nombre</label>
                                            <input type="text"  class="form-control" name="txtNombre"  value="${aso.nombre}" >
                                        </div>
                                    </div>
                                    <div class="col-12 col-md-4">
                                        <div class="form-group">
                                            <label for="" class="bmd-label-floating">Direccion</label>
                                            <input type="text"  class="form-control" name="txtDireccion" value="${aso.direccion}" >
                                        </div>
                                    </div>
                                    <div class="col-12 col-md-4">
                                        <div class="form-group">
                                            <label for="" class="bmd-label-floating">Telefono</label>
                                            <input type="text"  class="form-control" name="txtTelefono" pattern="[0-9]+"   value="${aso.telefono}" >
                                        </div>
                                    </div>

                                    <p class="text-center" style="margin-top: 40px;">
                                        <input type="submit" class="btn btn-raised btn-success btn-sm" name="accion" value="Actualizar">
                                        <input id="btn4" type="submit" class="btn btn-raised btn-info btn-sm" name="accion" value="Agregar">
                                    </p>
                                </div>
                            </div>
                        </fieldset>
                    </form>
                </div>
                <!-- Content here-->
                <div class="container-fluid">
                    <div class="table-responsive">
                        <table class="table table-dark table-sm">
                            <thead>
                                <tr class="text-center roboto-medium">
                                    <th>Nombre</th>
                                    <th>Doreccion</th>
                                    <th>Telefono</th>
                                    <th class="ac">Editar</th>
                                    <th class="ac">Eliminar</th>
                                </tr>
                            </thead>
                            <tbody  >
                                <c:forEach var="a" items="${listaAso}">
                                    <tr class="text-center"> 
                                        <td>${a.nombre}</td>
                                        <td>${a.direccion}</td>
                                        <td>${a.telefono}</td>
                                        <td class="btnLis"><a  title="Actualizar Asociacion"  class="btn btn-raised btn-success btn-sm" href="Controlador?menu=Asociacion&accion=showedit&pk_asociacion=${a.pk_asocaciacon}">
                                                <i class="fas  fa-sync-alt"></i></a>
                                        </td>
                                        <td ><a title="Eliminar Asociacion"   class="btn btn-raised btn-danger btn-sm " href="Controlador?menu=Asociacion&accion=Eliminar&pk_asociacion=${a.pk_asocaciacon}">
                                                <i class="far fa-trash-alt"></i></a>
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
        <script src="./js/jquery-3.4.1.min.js"></script>
        <!-- popper -->
        <script src="./js/popper.min.js"></script>

        <!-- Bootstrap V4.3 -->
        <script src="./js/bootstrap.min.js"></script>

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

    </body></html>