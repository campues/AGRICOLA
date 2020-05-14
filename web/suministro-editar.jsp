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

                </div>

                <!-- Content here-->
                <div class="container-fluid">
                    <form  name="formulario" action="Controlador?menu=Detalles"  class="form-neon" autocomplete="off" method="POST" >
                        <fieldset>
                            <legend><i class="fas fa-store-alt"></i> &nbsp; Verifica los datos antes de guardar</legend>
                            <!--<div class="nav-lateral-barra"></div> --> 
                            <div class="row">
                                <div class="form-group">
                                    <input type="hidden"  name="pk" class="form-control"  value="${detalle.pk_detallesPro}">
                                </div>
                                <div class="col-md-4">
                                    <div class="form-group">
                                        <label  class="">Fecha</label>
                                        <input type="date"  class="form-control" name="txtFecha"  value="${detalle.fechaEntrega}" >
                                    </div>
                                </div>
                                <div class="col-md-4">
                                    <div class="form-group">
                                        <label for="" class="bmd-label-floating">Cantidad</label>
                                        <input type="text"  class="form-control" name="txtCantidad" value="${detalle.cantidad}" >
                                    </div>
                                </div>
                                <div class="col-md-4">
                                    <div class="form-group">
                                        <label for="item" class="bmd-label-floating">Agricultor</label>
                                        <select class="form-control" name="txtAgricultor" id="item"  >
                                            <option value="" selected="" disabled="">Seleccione Agricultor</option>
                                            <c:forEach var="a" items="${listaAgri}" >
                                                <option  value="${a.pk_agricultor}" 
                                                         <c:if test="${a.pk_agricultor == detalle.getFk_agricutor()}">
                                                             selected
                                                         </c:if>
                                                         >${a.nombre1}</option>
                                            </c:forEach>
                                        </select>
                                    </div> 
                                </div>
                                <div class="col-md-4">
                                    <div class="form-group">
                                        <label for="item" class="bmd-label-floating">Producto</label>
                                        <select class="form-control" name="txtProducto" id="item" >
                                            <option value="" selected="" disabled="">Seleccione el Producto</option>
                                            <c:forEach var="p" items="${listaPro}">
                                                <option value="${p.pk_producto}"
                                                        <c:if test="${p.pk_producto == detalle.getFk_producto()}">
                                                            selected
                                                        </c:if>
                                                        >${p.nomInsumos}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                                <div class="col-md-4">
                                    <div class="form-group">
                                        <label for="item" class="bmd-label-floating">Empleado</label>
                                        <select class="form-control" name="txtEmpleado" id="item" >
                                            <option value="" selected="" disabled="">Seleccione Empleado</option>
                                            <c:forEach var="em" items="${listaEmple}">
                                                <option value="${em.pk_empleado}"
                                                        <c:if test="${em.pk_empleado == detalle.getFk_empleado()}">
                                                            selected
                                                        </c:if>
                                                        >${em.nombre}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                            </div>
                        </fieldset>
                        <p class="text-center" >
                            <button   type="submit" name="accion" value="Actualizar" class="btn btn-raised btn-success btn-sm"> ACTUALIZAR</button>
                            <button   type="submit" name="accion" value="Listar" class="btn btn-raised btn-danger btn-sm"> CANCELAR</button>
                        </p>
                    </form>
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