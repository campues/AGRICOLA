<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Control.Variables"%>
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
                        <i class="fas fa-clipboard-list fa-fw"></i> &nbsp; LISTA Colmenas
                    </h3>
                    <p class="text-justify">
                        Numero de colmenas
                    </p>
                </div>

                <div class="container-fluid">
                    <ul class="full-box list-unstyled page-nav-tabs">
                        <li>
                            <a  href="#" data-toggle="modal" data-target="#ModalAgregar"><i class="fas fa-plus fa-fw"></i> &nbsp; AGREGAR</a>
                        </li>
                        <li>
                            <a href="Controlador?menu=Colmenas&accion=Listar"><i class="fas fa-clipboard-list fa-fw"></i> &nbsp; LISTAR </a>
                        </li>
                        <li>
                            <a href="#" data-toggle="modal" data-target="#ModalBuscar"><i  class="fas fa-search fa-fw"></i> &nbsp; BUSCAR </a>
                        </li>
                        <li>
                            <a href="Controlador?menu=Visitas&accion=Listar"><i class="fas icon-back fa-fw"></i> &nbsp; Regresar</a>
                        </li>
                    </ul>	
                </div>

                <!-- ============================================MODAL AGREGAR============================= -->
                <div class="modal fade" id="ModalAgregar" tabindex="-1" role="dialog" aria-labelledby="ModalAgregar" aria-hidden="true">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="titulo modal-header">
                                <h5>Agregar Colmena</h5>
                                <button type="button" class="close" data-dismiss="modal" >
                                    <span class="etiqueta4" >&times;</span>
                                </button>
                            </div>
                            <form class="modal-body" action="Controlador?menu=Colmenas" method="POST"  >
                                <fieldset>
                                    <div class="row">
                                        <input type="hidden"  class="" name="fkVisitas"   value="<%=Variables.idVisitas%>" id="item_codigo" readonly="readonly" >

                                        <div class="col-md-5">
                                            <div class="form-group">
                                                <label for="" style="color: #007065;">Abejas:</label>
                                                <label style="color: #020202;">SI</label> <input  type="radio" name="radioA" value="SI" required="">&nbsp;
                                                <label style="color: #020202;">NO</label><input type="radio" name="radioA" value="NO" required="">
                                            </div>
                                        </div>
                                        <div class="col-md-4">
                                            <div class="form-group">
                                                <label for="" style="color: #007065;">Reina:</label>
                                                <label style="color: #020202;">SI</label> <input  type="radio" name="radioR" value="SI" required="">&nbsp;
                                                <label style="color: #020202;">NO</label><input type="radio" name="radioR" value="NO" required="">
                                            </div>
                                        </div>
                                        <div class="col-md-5">
                                            <div class="form-group">
                                                <label  class="bmd-label-floating">Codigo</label>
                                                <input type="text"  class="form-control" name="txtCodigo" required="" >
                                            </div>
                                        </div>
                                        <div class="col-md-3">
                                            <div class="form-group">
                                                <label  class="bmd-label-floating">Pisos</label>
                                                <input type="number"  class="form-control" name="txtNumero" required="" >
                                            </div>
                                        </div>
                                        <div class="col-md-3">
                                            <div class="form-group">
                                                <label  class="bmd-label-floating">Cantidad</label>
                                                <input type="number"  class="form-control" name="txtCantidad" required="" >
                                            </div>
                                        </div>
                                        <div class="col-md-5">
                                            <div class="form-group">
                                                <label  class="bmd-label-floating">Alimentacion</label>
                                                <input type="text"  class="form-control" name="txtAlimentacion" required="" title="Ingresa la fecha">
                                            </div>
                                        </div>
                                        <div class="col-md-5">
                                            <div class="form-group">
                                                <label  class="bmd-label-floating">Descripcion</label>
                                                <input type="text"  class="form-control" name="txtDescripcion" required="">
                                            </div>
                                        </div>

                                        <div class="col-md-11">
                                            <div class="form-group">
                                                <label  class="bmd-label-floating">Actividad</label>
                                                <input type="text"  class="form-control" name="txtActividad" required="">
                                            </div>
                                        </div>

                                        <div class="col-md-11">
                                            <div class="form-group">
                                                <label  class="bmd-label-floating">Tratamiento</label>
                                                <input type="text"  class="form-control" name="txtTratamiento" required="" >
                                            </div>
                                        </div>
                                </fieldset>
                                <p class="text-center" >
                                    <button   type="submit" name="accion" value="Agregar" class="btn btn-raised btn-info"><i class=" fas fa-save "></i> &nbsp; AGREGAR</button>
                                </p>
                        </div>
                        </form>
                    </div>
                </div>
                </div>
                <!-- ============================================MODAL BUSCAR============================= -->
                <div class="modal fade" id="ModalBuscar" tabindex="-1" role="dialog" aria-labelledby="ModalBuscar" aria-hidden="true">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="etiqueta">¿Busca el Colmena?</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <form class="modal-body" action="Controlador?menu=Colmenas" method="POST"  >
                                <div class="form-group">
                                    <label  class="bmd-label-floating">Ingresa el codigo</label>
                                    <input type="text"  class="form-control" name="txtBusqueda" required="" title="Ingresa el codigo">
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
                                    <th>Codigo</th>
                                    <th>Ajebas</th>
                                    <th>Piso</th>
                                    <th>Cantidad</th>
                                    <th class="ac">Editar</th>
                                    <th class="ac">Eliminar</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="abe" items="${listaCol}">
                                    <tr class="text-center"> 
                                        <td>${abe.pk_colmenas}</td>
                                        <td>${abe.codColmena}</td>
                                        <td>${abe.abejas}</td>
                                        <td>${abe.piso}</td>
                                        <td>${abe.cantidad}</td>
                                        <td class="btnLis"><a  title="Actualizar Colmena"  class="btn btn-raised btn-success btn-sm"   href="Controlador?menu=Colmenas&accion=Editar&pk_colmenas=${abe.pk_colmenas}">
                                                <i class="fas  fa-sync-alt"></i></a>
                                        </td>
                                        <td class="btnLis"><a title="Eliminar Colmena"   class="btn btn-raised btn-danger btn-sm " href="Controlador?menu=Cultivo&accion=Eliminar&pk_colmenas=${abe.pk_colmenas}">
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