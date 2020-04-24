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
                <div class="full-box page-header">
                    <h3 class="text-left">
                        <i class="fas fa-building fa-fw"></i> &nbsp; INFORMACION DE SUMINISTRO DE PRODUCTOS
                    </h3>
                    <p class="text-justify">
                        Suministrar productos al agricultor
                    </p>
                </div>
                <div class="container-fluid">
                    <form  name="frm" action="Controlador?menu=Detalles"  class="form-neon"  method="POST" >
                        <fieldset>
                            <legend><i class="far fa-building"></i> &nbsp;Suministrar Producto</legend>
                            <div class="container-fluid">
                                <div class="row">
                                    <div class="form-group label-floating">
                                        <div class="form-group">
                                            <input type="hidden"  name="pk" class="form-control"  value="${detalle.pk_detallesPro}">
                                        </div>
                                    </div>
                                    <div class="col-12 col-md-2">
                                        <div class="form-group">
                                            <label  class="">Fecha</label>
                                            <input type="date"  class="form-control" name="txtFecha"  value="${detalle.fechaEntrega}" >
                                        </div>
                                    </div>
                                    <div class="col-12 col-md-1">
                                        <div class="form-group">
                                            <label for="" class="bmd-label-floating">Cantidad</label>
                                            <input type="text"  class="form-control" name="txtCantidad" value="${detalle.cantidad}" >
                                        </div>
                                    </div>

                                    <div class="col-12 col-md-2">
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
                                    <div class="col-12 col-md-3">
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
                                    <div class="col-12 col-md-3">
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
                                    <th>Id</th>
                                    <th>Fecha</th>
                                    <th>Cantidad</th>
                                    <th>Agricultor</th>
                                    <th >Producto</th>
                                    <th >Empleado</th>
                                    <th class="ac">Editar</th>
                                    <th class="ac">Eliminar</th>

                                </tr>
                            </thead>
                            <tbody  >
                                <c:forEach var="de" items="${listaDe}">
                                    <tr class="text-center"> 
                                        <td>${de.pk_detallesPro}</td>
                                        <td>${de.fechaEntrega}</td>
                                        <td>${de.cantidad}</td>
                                        <td>${de.fk_agricutor}</td>
                                        <td>${de.fk_producto}</td>
                                        <td>${de.fk_empleado}</td>
                                        <td class="btnLis"><a  title="Actualizar Suministro"  class="btn btn-raised btn-success btn-sm" href="Controlador?menu=Detalles&accion=showedit&pk_detallesPro=${de.pk_detallesPro}">
                                                <i class="fas  fa-sync-alt"></i></a>
                                        </td>
                                        <td ><a title="Eliminar Suministro"   class="btn btn-raised btn-danger btn-sm " href="Controlador?menu=Detalles&accion=Eliminar&pk_detallesPro=${de.pk_detallesPro}">
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