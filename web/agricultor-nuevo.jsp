<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="es">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <title>Nuevo Agricultor</title>
        <link href="css/alertify.min.css" rel="stylesheet" type="text/css"/>
        <link href="css/default.min.css" rel="stylesheet" type="text/css"/>
        <script src="css/alertify.min.js" type="text/javascript"></script>
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
                        <i class="fas fa-plus fa-fw"></i> &nbsp; AGREGAR AGRICULTOR
                    </h3>
                    <p class="text-justify">
                        Agrega a un nuevo Agricultor!! trata de ingresar los datos correctos
                    </p>
                </div>

                <div class="container-fluid">
                    <ul class="full-box list-unstyled page-nav-tabs">
                        <li>
                            <a class="active" href="agricultor-nuevo.jsp"><i class="fas fa-plus fa-fw"></i> &nbsp; AGREGAR AGRICULTORES</a>
                        </li>
                        <li>
                            <a  href="Controlador?menu=Agricultor&accion=Listar"><i class="fas fa-clipboard-list fa-fw"></i> &nbsp; LISTA DE AGRICULTORES</a>
                        </li>

                    </ul>	
                </div>

                <!-- Content here-->
                <p id="error"></p>
                <div class="container-fluid">
                    <form  name="formulario" action="Controlador?menu=Agricultor"  class="form-neon" autocomplete="off" method="POST" >
                        <fieldset>
                            <legend><i class="fas fa-user "></i> &nbsp; Informacion basica</legend>
                            <!--<div class="nav-lateral-barra"></div> --> 
                            <div class="container-fluid">
                                <div class="row">

                                    <div class="form-group label-floating">
                                        <div class="form-group">
                                            <input type="hidden"  name="pk" class="form-control"  value="${agricul.pk_agricultor}">
                                        </div>
                                    </div>

                                    <div class="col-12 col-md-2">
                                        <div class="form-group">
                                            <label for="cliente_nombre" class="bmd-label-floating">Primer Nombre:</label>
                                            <input type="text"  class="form-control"  name="txtNom1" value="${agricul.nombre1}" required="" pattern="[A-Za-z]+" id="nombre1"  onkeyup="Generar()">
                                        </div>
                                    </div>
                                    <div class="col-12 col-md-2">
                                        <div class="form-group">
                                            <label for="cliente_nombre" class="bmd-label-floating">Segundo Nombre:</label>
                                            <input type="text" class="form-control" name="txtNom2" value="${agricul.nombre2}" required="" pattern="[A-Za-z]+">
                                        </div>
                                    </div>
                                    <div class="col-12 col-md-2">
                                        <div class="form-group">
                                            <label for="" class="bmd-label-floating">Primer Apellido</label>
                                            <input type="text" class="form-control" name="txtApe1"  value="${agricul.apellido1}"required="" pattern="[A-Za-z]+" id="apellido1" onkeyup="Generar()">
                                        </div>
                                    </div>
                                    <div class="col-12 col-md-2">
                                        <div class="form-group">
                                            <label for="" class="bmd-label-floating">Segundo Apellido</label>
                                            <input type="text" class="form-control"name="txtApe2" value="${agricul.apellido2}" required="" pattern="[A-Za-z]+">
                                        </div>
                                    </div>
                                    <div class="col-12 col-md-2">
                                        <div class="form-group">
                                            <label for="" class="bmd-label-floating">Cedula</label>
                                            <input type="text" class="form-control" name="txtCed" value="${agricul.cedula}" minlength="10" maxlength="10" pattern="[0-9]+" required id="cedula" onkeyup="Generar()">
                                        </div>
                                    </div>
                                    <div class="col-12 col-md-1">
                                        <div class="form-group">
                                            <label   class="bmd-label-floating" style="color: #ec0505;">Codigo:</label>
                                            <input type="text" class="form-control" name="txtCodigo" id="cod" value="${agricul.codigo}" readonly >
                                        </div> 
                                    </div> 

                                    <div class="col-12 col-md-2">
                                        <div class="form-group">
                                            <label for="cliente_telefono" class="bmd-label-floating">Telefono</label>
                                            <input type="text" class="form-control" name="txtTel" value="${agricul.telefono}" minlength="10" maxlength="10" pattern="[0-9]+" required>
                                        </div>
                                    </div>
                                    <div class="col-12 col-md-4">
                                        <div class="form-group">
                                            <label for="cliente_direccion" class="bmd-label-floating">Direccion</label>
                                            <input type="text"  class="form-control"  name="txtDir" value="${agricul.direccion}" required="">
                                        </div>
                                    </div>
                                    <div class="col-12 col-md-4">
                                        <div class="form-group">
                                            <label >Fecha Afiliacion</label>
                                            <input type="date" class="form-control" name="txtFec"  value="${agricul.fechaAfiliacion}" required >

                                        </div>
                                    </div>

                                    <div class="col-12 col-md-4">
                                        <div class="form-group">
                                            <label for="item" class="bmd-label-floating">Estatus</label>
                                            <select class="form-control" name="txtEst" id="item" required="">
                                                <option value="" selected="" disabled="">Seleccione una opcion</option>
                                                <option value="ACTIVO"<c:if test="${agricul.estatus == 'ACTIVO'}">selected</c:if> >Activo</option>
                                                <option value="INACTIVO" <c:if test="${agricul.estatus == 'INACTIVO'}">selected </c:if>>Inactivo</option>
                                                </select>
                                            </div>
                                        </div> 

                                        <div class="col-12 col-md-4">
                                            <div class="form-group">
                                                <label for="" style="color: #007065;">Lider Asociacion:</label>
                                                <label style="color: #020202;">SI</label> <input  type="radio" name="radioL" value="SI" required="" <c:if test="${agricul.liderAsociacion == 'SI'}">checked</c:if>>&nbsp;
                                            <label style="color: #020202;">NO</label><input type="radio" name="radioL" value="NO" required="" <c:if test="${agricul.liderAsociacion == 'NO'}">checked</c:if>>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </fieldset>
                        <br><br><br>
                        <p class="text-center" style="margin-top: 40px;">
                            <button type="reset" class="btn btn-raised btn-secondary btn-sm"><i class="fas fa-paint-roller"></i> &nbsp; LIMPIAR</button>
                            &nbsp; &nbsp;
                            <button type="submit" class="btn btn-raised btn-success btn-sm" name="accion" value="Actualizar"><i class="fas fa-sync-alt"></i> &nbsp; ACTUALIZAR</button>
                            &nbsp; &nbsp;
                            <button type="submit" class="btn btn-raised btn-info btn-sm" name="accion" value="Agregar" ><i class="far fa-save"></i> &nbsp; AGREGAR</button>
                        </p>
                    </form>
                </div>	

            </section>
        </main>


        <!--=============================================
        =            Include JavaScript files           =
        ==============================================-->
        <script src="js/codigo.js" type="text/javascript"></script>
        <!-- jQuery V3.4.1 -->
        <script src="./js/jquery-3.4.1.min.js" ></script>
        <script src="./js/bootstrap.min.js"></script>
        <!-- popper -->
        <script src="./js/popper.min.js" ></script>
        <!-- Bootstrap V4.3 -->
        <script src="./js/bootstrap.min.js" ></script>
        <script src="./js/Validar.js" ></script>


        <!-- VENTANA ENERGENTE-->
        <script src="js/sweetalert2.min.js" type="text/javascript"></script>
        <script src="js/codigo.js" type="text/javascript"></script>

        <!-- jQuery Custom Content Scroller V3.1.5 -->
        <script src="./js/jquery.mCustomScrollbar.concat.min.js" ></script>

        <!-- Bootstrap Material Design V4.0 -->
        <script src="./js/bootstrap-material-design.min.js" ></script>
        <script>$(document).ready(function () {
                                                    $('body').bootstrapMaterialDesign();
                                                });</script>

        <script src="./js/main.js" ></script>
        <script src="js/Riesgo.js" type="text/javascript"></script>

    </body>
</html>