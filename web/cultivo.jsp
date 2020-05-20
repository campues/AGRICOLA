<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Control.Variables"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <title>Datos de la empresa</title>
        <!-- dataTable -->
        <link rel="stylesheet" href="datatables/datatables.min.css"/>
        <link rel="stylesheet" href="datatables/stylo-tabla.css" />
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
                        <i class="fas fa-clipboard-list fa-fw"></i> &nbsp; LISTA DE CULTIVO
                    </h3>
                    <p class="text-justify">
                        CULTIVO EXISTENTES
                    </p>

                    <div class="container-fluid">
                        <ul class="full-box list-unstyled page-nav-tabs">
                            <li>
                                <a  href="#" data-toggle="modal" data-target="#ModalAgregar"><i class="fas fa-plus fa-fw"></i> &nbsp; AGREGAR</a>
                            </li>
                            <li>
                                <a href="Controlador?menu=Cultivo&accion=Listar"><i class="fas fa-clipboard-list fa-fw"></i> &nbsp; LISTAR </a>
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
                                    <h5>Agregar Cultivo</h5>
                                    <button type="button" class="close" data-dismiss="modal" >
                                        <span class="etiqueta4" >&times;</span>
                                    </button>
                                </div>
                                <form class="modal-body" action="Controlador?menu=Cultivo" method="POST"  >
                                    <fieldset>
                                        <div class="row">
                                            <input type="hidden"  class="" name="fkVisitas"   value="<%=Variables.idVisitas%>" id="item_codigo" readonly="readonly" >
                                            <div class="col-md-3">
                                                <div class="form-group">
                                                    <label  class="bmd-label-floating">Nombre</label>
                                                    <input type="text"  class="form-control" name="txtNombre" required="" title="Ingresa el nombre del cultivo">
                                                </div>
                                            </div>
                                            <div class="col-md-3">
                                                <div class="form-group">
                                                    <label  class="bmd-label-floating">Area</label>
                                                    <input type="text"  class="form-control" name="txtArea" required="" title="Ingresa el area">
                                                </div>
                                            </div>
                                            <div class="col-md-3">
                                                <div class="form-group">
                                                    <label  class="bmd-label-floating">Densidad</label>
                                                    <input type="text"  class="form-control" name="txtDensidad" required="" title="Ingresa la densidad">
                                                </div>
                                            </div>
                                            <div class="col-md-3">
                                                <div class="form-group">
                                                    <label  class="bmd-label-floating">Numero</label>
                                                    <input type="number"  class="form-control" name="txtNumero" required="" title="Ingresa el numero de plantas">
                                                </div>
                                            </div>
                                            <div class="col-md-5">
                                                <div class="form-group">
                                                    <label  class="">Aplicación del último producto prohibido,fecha</label>
                                                    <input type="date"  class="form-control" name="txtFecha" required="" title="Ingresa la fecha">
                                                </div>
                                            </div>
                                            <div class="col-md-3">
                                                <div class="form-group">
                                                    <label  class="bmd-label-floating">Estimado de cosecha</label>
                                                    <input type="number"  class="form-control" name="txtEstimacion" required="" title="Ingresa la estimacion">
                                                </div>
                                            </div>
                                            <div class="col-md-4">
                                                <div class="form-group">
                                                    <label for="item" class="bmd-label-floating">Estatus</label>
                                                    <select class="form-control" name="opEstatus" id="item">
                                                        <option value="" selected="" disabled="">Seleccione una opcion</option>
                                                        <option  value="Organico">Organico</option>
                                                        <option value="Convencional">Convencional</option>
                                                    </select>
                                                </div>
                                            </div>

                                            <div class="col-md-6">
                                                <div class="form-group">
                                                    <label  class="bmd-label-floating">Manejo Organicamente desde(Año)</label>
                                                    <input type="number"  class="form-control" name="txtAnio_or" required="" title="Ingresa el Año ">
                                                </div>
                                            </div>
                                            <div class="col-md-6">
                                                <div class="form-group">
                                                    <label  class="bmd-label-floating">Año de la primera preinspección</label>
                                                    <input type="number"  class="form-control" name="txtAnio_ins" required="" title="Ingresa el Año">
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
                    <!-- ============================================MODAL BUSCAR============================= -->
                    <div class="modal fade" id="ModalBuscar" tabindex="-1" role="dialog" aria-labelledby="ModalBuscar" aria-hidden="true">
                        <div class="modal-dialog" role="document">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="etiqueta">¿Busca el cultivo?</h5>
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                                </div>
                                <form class="modal-body" action="Controlador?menu=Cultivo" method="POST"  >
                                    <div class="form-group">
                                        <label  class="bmd-label-floating">Ingresa el Nombre del cultivo</label>
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
                    <div class="table-responsive">
                        <table id="tablalist" class="table table-dark table-sm">
                            <thead >
                                <tr class="roboto-medium">
                                    <th>ID</th>
                                    <th>Cultivo</th>
                                    <th>Numero plantas</th>
                                    <th>Estatus</th>
                                    <th class="ac text-center">Opciones</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="cu" items="${listaCul}">
                                    <tr> 
                                        <td>${cu.pk_cultivo}</td>
                                        <td>${cu.nomCultivo}</td>
                                        <td>${cu.numPlantas}</td>
                                        <td>${cu.estatus}</td>

                                        <td class="col-re text-center">
                                            <%if (session.getAttribute("tipo").equals("1")) {%>
                                            <a  title="Actualizar Cultivo"  class="btn btn-raised btn-success btn-sm"   href="Controlador?menu=Cultivo&accion=Editar&pk_cultivo=${cu.pk_cultivo}">
                                                <i class="fas  fa-sync-alt"></i></a>

                                            <a title="Eliminar Cultivo"   class="btn btn-raised btn-danger btn-sm " href="Controlador?menu=Cultivo&accion=Eliminar&pk_cultivo=${cu.pk_cultivo}">
                                                <i class="far fa-trash-alt"></i></a>

                                            <a title="Agregar datos Extras al Lote" class="btn btn-raised btn-dark btn-sm" href="Controlador?menu=Cultivo&accion=CultivoExtras&pk_cultivo=${cu.pk_cultivo}">
                                                <i class="fas icon-text-document-inverted"></i></a>

                                            <a title="Riesgo de contaminacion" class="btn btn-raised btn-warning btn-sm" href="Controlador?menu=Cultivo&accion=CultivoRiesgo&pk_cultivo=${cu.pk_cultivo}">
                                                <i class="fas icon-add-to-list"></i></a>
                                                <%} else if (session.getAttribute("tipo").equals("2")) {%>
                                            <a  title="Actualizar Cultivo"  class="btn btn-raised btn-success btn-sm"   href="Controlador?menu=Cultivo&accion=Editar&pk_cultivo=${cu.pk_cultivo}">
                                                <i class="fas  fa-sync-alt"></i></a>
                                            <a title="Agregar datos Extras al Lote" class="btn btn-raised btn-dark btn-sm" href="Controlador?menu=Cultivo&accion=CultivoExtras&pk_cultivo=${cu.pk_cultivo}">
                                                <i class="fas icon-text-document-inverted"></i></a>

                                            <a title="Riesgo de contaminacion" class="btn btn-raised btn-warning btn-sm" href="Controlador?menu=Cultivo&accion=CultivoRiesgo&pk_cultivo=${cu.pk_cultivo}">
                                                <i class="fas icon-add-to-list"></i></a>

                                            <%} else {%>
                                            <a title="Agregar datos Extras al Lote" class="btn btn-raised btn-dark btn-sm" href="Controlador?menu=Cultivo&accion=CultivoExtras&pk_cultivo=${cu.pk_cultivo}">
                                                <i class="fas icon-text-document-inverted"></i></a>

                                            <a title="Riesgo de contaminacion" class="btn btn-raised btn-warning btn-sm" href="Controlador?menu=Cultivo&accion=CultivoRiesgo&pk_cultivo=${cu.pk_cultivo}">
                                                <i class="fas icon-add-to-list"></i></a>
                                                <%}%>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>

            </section>

            <script src="js/bootstrap.min.js" type="text/javascript"></script>
            <script src="js/jquery-3.4.1.min.js" type="text/javascript"></script>
            <script src="js/popper.min.js" type="text/javascript"></script>

            <!-- jQuery, dataTable -->
            <script src="datatables/datatables.min.js" type="text/javascript" ></script>    
            <script src="datatables//stylo-tabla.js" type="text/javascript"></script>
        </main>
        <!-- popper -->
        <script src="./js/popper.min.js"></script>
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