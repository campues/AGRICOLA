<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
                <div class="full-box page-header">
                    <h3 class="text-left">
                        <i class="fas fa-clipboard-list fa-fw"></i> &nbsp; LISTA DE ASOCIACIONES
                    </h3>
                    <p class="text-justify">
                        Lista de ASOCIACIONES
                    </p>
                </div>

                <div class="container-fluid">
                    <ul class="full-box list-unstyled page-nav-tabs">
                        <li>
                            <a  href="#" data-toggle="modal" data-target="#ModalAgregar"><i class="fas fa-plus fa-fw"></i> &nbsp; AGREGAR</a>
                        </li>
                        <li>
                            <a href="Controlador?menu=Asociacion&accion=Listar"><i class="fas fa-clipboard-list fa-fw"></i> &nbsp; LISTAR </a>
                        </li>
                        <li>
                            <a href="#" data-toggle="modal" data-target="#ModalBuscar"><i  class="fas fa-search fa-fw"></i> &nbsp; BUSCAR </a>
                        </li>
                    </ul>	
                </div>

                <!-- ============================================MODAL AGREGAR============================= -->
                <div class="modal fade" id="ModalAgregar" tabindex="-1" role="dialog" aria-labelledby="ModalAgregar" aria-hidden="true">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="titulo modal-header">
                                <h5>Nueva Asociacion</h5>
                                <button type="button" class="close" data-dismiss="modal" >
                                    <span class="etiqueta4" >&times;</span>
                                </button>
                            </div>
                            <form class="modal-body" action="Controlador?menu=Asociacion" method="POST"  >
                                <div class="row">
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <label  class="bmd-label-floating">Nombre Asociacion</label>
                                            <input type="text"  class="form-control" name="txtNombre" required=""  pattern="[A-Za-z]+"  >
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <label  class="bmd-label-floating">Ruc</label>
                                            <input type="number"  class="form-control" name="txtRuc" required="" >
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <label  class="bmd-label-floating">Geolocalización</label>
                                            <input type="text"  class="form-control" name="txtGeoloc" required="" >
                                        </div>
                                    </div>

                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <label  class="bmd-label-floating">Telefono</label>
                                            <input type="number"  class="form-control" name="txtTelefono" required=""  >
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label  class="bmd-label-floating">Nombres Completos (Responsable)</label>
                                    <input type="text"  class="form-control" name="txtResponsable" required=""  >
                                </div>


                                <div class="form-group">
                                    <label  class="bmd-label-floating">Direccion</label>
                                    <input type="text"  class="form-control" name="txtDireccion" required="" >
                                </div>
                                <div class="form-group">
                                    <label  class="bmd-label-floating">Parroquia</label>
                                    <input type="text"  class="form-control" name="txtParroquia" required="" pattern="[A-Za-z]+"  >
                                </div>
                                <div class="form-group">
                                    <label for="item" class="bmd-label-floating">Provincia</label>
                                    <select class="form-control" name="opProvincia" id="item">
                                        <option value="" selected="" disabled="">Seleccione una opcion</option>
                                        <c:forEach var="p" items="${lisPro}" >
                                            <option value="${p.pk_provincia}">${p.nomProvincia}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <p class="text-center">
                                    <button   type="submit" name="accion" value="Agregar" class="btn btn-raised btn-info"><i class=" fas fa-save "></i> &nbsp; AGREGAR</button>
                                </p>
                            </form>
                        </div>
                    </div>
                </div>
                <!-- ============================================MODAL BUSCAR============================= -->
                <div class="modal fade" id="ModalBuscar" tabindex="-1" role="dialog" aria-labelledby="ModalBuscar" aria-hidden="true">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="etiqueta">¿A que Asocianción estas buscando?</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <form class="modal-body" action="Controlador?menu=Asociacion" method="POST"  >
                                <div class="form-group">
                                    <label  class="bmd-label-floating">Ingresa el Nombre </label>
                                    <input type="text"  class="form-control" name="txtBusqueda" required="" title="Ingresa un nombre">
                                </div>
                                <p class="text-center">
                                    <button   type="submit" name="accion" value="Buscar" class="btn btn-raised btn-info "><i class="fas fa-search "></i> &nbsp; BUSCAR</button>
                                </p>
                            </form>
                        </div>
                    </div>
                </div>
                <!-- ===================================================================================================== -->
                <!-- Content here-->
                <div class="container-fluid">
                    <div class="table-responsive">
                        <table class="table table-dark table-sm">
                            <thead>
                                <tr class="text-center roboto-medium">
                                    <th>ID</th>
                                    <th>Nombre</th>
                                    <th>Ruc</th>
                                    <th>Provincia</th>
                                    <th>Telefono</th>
                                    <th class="ac">Editar</th>
                                    <th class="ac">Eliminar</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="as" items="${asocia}">
                                    <tr class="text-center"> 
                                        <td>${as.pk_asociacion}</td>
                                        <td>${as.nomAsociacion}</td>
                                        <td>${as.ruc}</td>
                                        <td>${as.fk_provinciaa}</td>
                                        <td>${as.telefono}</td>
                                        <td class="btnLis"><a  title="Actualizar Asociacion"  class="btn btn-raised btn-success btn-sm"   href="Controlador?menu=Asociacion&accion=Editar&pk_asociacion=${as.pk_asociacion}">
                                                <i class="fas  fa-sync-alt"></i></a>
                                        </td>
                                        <td class="btnLis"><a title="Eliminar Asociacion"   class="btn btn-raised btn-danger btn-sm " href="Controlador?menu=Asociacion&accion=Eliminar&pk_asociacion=${as.pk_asociacion}">
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
    </body>
</html>