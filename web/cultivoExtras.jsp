<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="Control.Variables"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <title>Datos de la empresa</title>

        <!-- Normalize V8.0.1 -->
        <link rel="stylesheet" href="./css/normalize.css">
        <link href="assets/fonts/style.css" rel="stylesheet" type="text/css"/>
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
                        <i class="fas fa-building fa-fw"></i> &nbsp; DATOS EXTRAS DEL CULTIVO
                    </h3>

                </div>
                <div class="container-fluid">
                    <ul class="full-box list-unstyled page-nav-tabs">
                        <li>
                            <a href="Controlador?menu=Cultivo&accion=Listar"> Regresar&nbsp; <i class="fas icon-back fa-fw"></i>  </a>
                        </li>
                    </ul>	
                </div>
                <!-- ============================================MODAL AGREGAR ROTACION============================= -->
                <div class="modal fade " id="ModalRotacion" tabindex="-1" role="dialog" aria-labelledby="ModalRotacion" aria-hidden="true">
                    <div class="modal-dialog " role="document">
                        <div class="modal-content "  >
                            <div class="titulo modal-header">
                                <h5>Rotacion del Cultivo</h5>
                                <button type="button" class="close" data-dismiss="modal" >
                                    <span class="etiqueta4" >&times;</span>
                                </button>
                            </div>
                            <form action="Controlador?menu=RotacionCultivo"  class="form-neon" method="POST">
                                <input type="hidden"   name="fk_cultivoc"  value="<%=Variables.idCultivo%>">
                                <div class="form-group">
                                    <label for="" class="etiqueta">A�os Anteriores:</label>
                                    <label style="color: #020202;">Primero</label> <input  type="radio" name="checkAnio" value="1" required="">&nbsp;
                                    <label style="color: #020202;">Segundo</label><input type="radio" name="checkAnio" value="2" required="">&nbsp;
                                    <label style="color: #020202;">Tercero</label><input type="radio" name="checkAnio" value="3" required="">
                                </div>
                                <div class="form-group">
                                    <label  class="bmd-label-floating">Nombre</label>
                                    <input type="text"  class="form-control" name="txtNombre">
                                </div>
                                <div class="form-group">
                                    <label  class="bmd-label-floating">Observaciones</label>
                                    <input type="text"  class="form-control" name="txtObservacion">
                                </div>
                                <p class="text-center">
                                    <button   type="submit" name="accion" value="Agregar" class="btn btn-raised btn-info"><i class=" fas fa-save "></i> &nbsp; AGREGAR</button>
                                </p>
                            </form>
                        </div>
                    </div>
                </div>
                <!--LISTA ROTACION-->
                <div class="container-fluid">
                    <div class="table-responsive">

                        <table class="table table-dark table-sm">
                            <thead>
                                <tr style=" background: #34ce57;">
                                    <th colspan="4" class="text-center "><a class="etiqueta4" href="#" data-toggle="modal" data-target="#ModalRotacion"><i class="fas fa-plus fa-fw"></i> &nbsp;Agregar Rotacion de cultivo</a></th>
                                </tr>
                                <tr class="text-center roboto-medium">
                                    <th>A�o</th>
                                    <th>Nombre</th>
                                    <th>Observacion</th>
                                   <th class="ac">Eliminar</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="r" items="${listaRotacion}">
                                    <tr class="text-center">
                                        <td>${r.anio}</td>
                                        <td>${r.nombre}</td>
                                        <td>${r.observacion}</td>
                                        <td class="btnLis"><a title="Eliminar Registro"   class="btn btn-raised btn-danger btn-sm " href="Controlador?menu=RotacionCultivo&accion=Eliminar&pk_rotacionCultivo=${r.pk_rotacionCultivo}">
                                                <i class="far fa-trash-alt"></i></a>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>

                    </div>
                </div>
                <!-- ============================================MODAL AGREGAR PRODUCTOS APLICADOS============================= -->
                <div class="modal fade " id="ModalProductos" tabindex="-1" role="dialog" aria-labelledby="ModalProductos" aria-hidden="true">
                    <div class="modal-dialog " role="document">
                        <div class="modal-content " >
                            <div class="titulo modal-header">
                                <h5>Agregar Animales</h5>
                                <button type="button" class="close" data-dismiss="modal" >
                                    <span class="etiqueta4" >&times;</span>
                                </button>
                            </div>
                            <form action="Controlador?menu=ProAplicados"  class="form-neon" method="POST">
                                <input type="hidden"   name="fk_cultivop"  value="<%=Variables.idLote%>">
                                <div class="form-group">
                                    <label for="item" class="bmd-label-floating">Tipo de Producto</label>
                                    <select class="form-control" name="opTipo" id="item">
                                        <option value="" selected="" disabled="">Seleccione una opcion</option>
                                        <option value="1">Otros productos utilizados en el Lote</option>
                                        <option value="2">Aplicaci�n del �ltimo producto prohibido</option>
                                    </select>
                                </div>

                                <div class="row">
                                    <div class="col-md-5">
                                        <div class="form-group">
                                            <label for="item" class="bmd-label-floating">Origen</label>
                                            <select class="form-control" name="opOrigen" id="item">
                                                <option value="" selected="" disabled="">Seleccione una opcion</option>
                                                <option value="Propio">Propio</option>
                                                <option value="Comprado">Complado</option>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="col-md-5">
                                        <div class="form-group">
                                            <label  class="bmd-label-floating">Nombre del producto</label>
                                            <input type="text"  class="form-control" name="txtNombre">
                                        </div>
                                    </div>
                                    <div class="col-md-4">
                                        <div class="form-group">
                                            <label  class="bmd-label-floating">Funcionalidad</label>
                                            <input type="text"  class="form-control" name="txtFuncionalidad">
                                        </div>
                                    </div>
                                    <div class="col-md-4">
                                        <div class="form-group">
                                            <label  class="bmd-label-floating">Cantidad Concentracion</label>
                                            <input type="text"  class="form-control" name="txtCantidad">
                                        </div>
                                    </div>

                                    <div class="col-md-4">
                                        <div class="form-group">
                                            <label  class="etiqueta">Fecha</label>
                                            <input type="date"  class="form-control" name="txtFecha">
                                        </div>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label  class="bmd-label-floating">Aspecto de Instalaciones</label>
                                    <input type="text"  class="form-control" name="txtAsInstalacion">
                                </div>
                                <div class="form-group">
                                    <label  class="bmd-label-floating">Aspecto de Insumos</label>
                                    <input type="text"  class="form-control" name="txtAsInsumos">
                                </div>
                                <div class="form-group">
                                    <label  class="bmd-label-floating">Observaciones</label>
                                    <input type="text"  class="form-control" name="txtObservacion">
                                </div>
                                <div class="form-group">
                                    <p class="text-center">
                                        <button   type="submit" name="accion" value="Agregar" class="btn btn-raised btn-info"><i class=" fas fa-save "></i> &nbsp; AGREGAR</button>
                                    </p>
                                </div>
                            </form>

                        </div>
                    </div>
                </div>
                <br><br>
                <!--LISTA PRODUCTOS APLICADOS-->
                <div class="container-fluid">
                    <div class="table-responsive">
                        <table class="table table-dark table-sm">
                            <thead>
                                <tr style="background: #34ce57;">
                                    <th colspan="5" class="text-center "><a class="etiqueta4" href="#" data-toggle="modal" data-target="#ModalProductos"><i class="fas fa-plus fa-fw"></i> &nbsp;Apregar Productos Aplicados</a></th>
                                </tr>
                                <tr class="text-center roboto-medium">

                                    <th>Nombre</th>
                                    <th>Funcionalidad</th>
                                    <th>Cantidad</th>
                                    <th>Fecha</th>
                                    <th class="ac">Eliminar</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="p" items="${listaProducto}">
                                    <tr class="text-center"> 
                                        <td>${p.nomProducto}</td>
                                        <td>${p.funcionalidad}</td>
                                        <td>${p.canConsertracion}</td>
                                        <td>${p.fecha}</td>
                                       <td class="btnLis"><a title="Eliminar Registro"   class="btn btn-raised btn-danger btn-sm " href="Controlador?menu=ProAplicados&accion=Eliminar&pk_proAplicados=${p.pk_proAplicados}">
                                                <i class="far fa-trash-alt"></i></a>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
                <!---------->
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