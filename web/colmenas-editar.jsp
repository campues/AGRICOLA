<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="Control.Variables"%>
<jsp:useBean id="c" class="Modelo.Colmenas" scope="request" />

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
                    <form  name="formulario" action="Controlador?menu=Colmenas"  class="form-neon" autocomplete="off" method="POST" >
                        <fieldset>
                            <legend><i class="fas fa-store-alt"></i> &nbsp; Verifica los datos antes de guardar</legend>
                            <!--<div class="nav-lateral-barra"></div> --> 
                            <div class="row">
                                <input type="hidden"  class="" name="fkVisitas"   value="<%=Variables.idVisitas%>" id="item_codigo" readonly="readonly" >
                                <input type="hidden"  name="pk" class="form-control"  value="${colm.pk_colmenas}">

                                <div class="col-md-5">
                                    <div class="form-group">
                                        <label for="" style="color: #007065;">Abejas:</label>
                                        <label style="color: #020202;">SI</label> 
                                        <input  type="radio" name="radioA" value="SI"<c:if test="${colm.abejas == 'SI'}">checked</c:if> >&nbsp;
                                        <label style="color: #020202;">NO</label>
                                        <input type="radio" name="radioA" value="NO"<c:if test="${colm.abejas == 'NO'}">checked</c:if> >
                                    </div>
                                </div>
                                <div class="col-md-4">
                                    <div class="form-group">
                                        <label for="" style="color: #007065;">Reina:</label>
                                        <label style="color: #020202;">SI</label> <input  type="radio" name="radioR" value="SI" <c:if test="${colm.reina == 'SI'}">checked</c:if> >&nbsp;
                                        <label style="color: #020202;">NO</label><input type="radio" name="radioR" value="NO" <c:if test="${colm.reina == 'NO'}">checked</c:if> >
                                    </div>
                                </div>
                                <div class="col-md-5">
                                    <div class="form-group">
                                        <label  class="bmd-label-floating">Codigo</label>
                                        <input type="text"  class="form-control" name="txtCodigo" required="" value="${colm.codColmena}">
                                    </div>
                                </div>
                                <div class="col-md-3">
                                    <div class="form-group">
                                        <label  class="bmd-label-floating">Pisos</label>
                                        <input type="number"  class="form-control" name="txtNumero" required="" value="${colm.piso}">
                                    </div>
                                </div>
                                <div class="col-md-3">
                                    <div class="form-group">
                                        <label  class="bmd-label-floating">Cantidad</label>
                                        <input type="number"  class="form-control" name="txtCantidad" required="" value="${colm.cantidad}">
                                    </div>
                                </div>
                                <div class="col-md-5">
                                    <div class="form-group">
                                        <label  class="bmd-label-floating">Alimentacion</label>
                                        <input type="text"  class="form-control" name="txtAlimentacion" required="" title="Ingresa la fecha" value="${colm.alimentacion}">
                                    </div>
                                </div>
                                <div class="col-md-5">
                                    <div class="form-group">
                                        <label  class="bmd-label-floating">Descripcion</label>
                                        <input type="text"  class="form-control" name="txtDescripcion" required="" value="${colm.descripcion}">
                                    </div>
                                </div>

                                <div class="col-md-11">
                                    <div class="form-group">
                                        <label  class="bmd-label-floating">Actividad</label>
                                        <input type="text"  class="form-control" name="txtActividad" required="" value="${colm.actividad}">
                                    </div>
                                </div>

                                <div class="col-md-11">
                                    <div class="form-group">
                                        <label  class="bmd-label-floating">Tratamiento</label>
                                        <input type="text"  class="form-control" name="txtTratamiento" required="" value="${colm.tratamiento}">
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