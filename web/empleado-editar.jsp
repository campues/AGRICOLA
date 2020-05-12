<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <title>Nuevo usuario</title>
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
                </div>
                <!-- Content -->
                <div class="container-fluid">
                    <form action="Controlador?menu=Empleado" class="form-neon" autocomplete="off" method="POST">
                        <fieldset>
                            <legend><i class="fas fa-sync-alt"></i> &nbsp; Verifica los datos antes de guardar</legend>
                            <div class="container-fluid">
                                <div class="row">
                                    <div class="col-md-5">
                                        <div class="form-group">
                                            <input type="hidden" class="form-control" name="pk" value="${emple.getPk_empleado()}">
                                            <label for="usuario_nombre" class="bmd-label-floating">Nombres</label>
                                            <input type="text" class="form-control" name="txtNombre" value="${emple.getNombre()}">
                                        </div>
                                    </div>
                                    <div class=" col-md-5">
                                        <div class="form-group">
                                            <label for="usuario_apellido" class="bmd-label-floating">Apellidos</label>
                                            <input type="text"  class="form-control" name="txtApellido" value="${emple.getApellido()}">
                                        </div>
                                    </div>
                                    <div class="col-md-5">
                                        <div class="form-group">
                                            <label for="usuario_usuario" class="bmd-label-floating">Usuario</label>
                                            <input type="text"  class="form-control" name="txtUsuario" value="${emple.getUsuario()}">
                                        </div>
                                    </div>
                                    <div class="col-md-5">
                                        <div class="form-group">
                                            <label for="pass" class="bmd-label-floating">Contraseña</label>
                                            <input type="password" class="form-control" name="txtContrasena"  id="pass" value="${emple.getContrasena()}">
                                        </div>
                                    </div>
                                    <div class="form-group" style="padding-top:45px;">
                                        <i class=" fa fa-eye etiqueta" id="show" onclick="mostrar()"></i>
                                    </div>
                                </div>
                            </div>
                        </fieldset>

                        <fieldset>
                            <legend><i class="fas fa-medal"></i> &nbsp; Nivel de privilegio</legend>
                            <div class="container-fluid">
                                <div class="row">
                                    <div class="col-12">
                                        <span class="badge badge-info">Control total</span> <label class=" etiqueta">Permisos para registrar, actualizar y eliminar</label> <br>
                                        <span class="badge badge-success">Edicion</span> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label class="etiqueta">Permisos para registrar y actualizar</label> <br>
                                        <span class="badge badge-dark">Registrar</span> &nbsp;&nbsp;&nbsp;&nbsp;<label class="etiqueta"> Solo permisos para registrar</label>
                                        <div class="form-group">
                                            <select class="form-control" name="opTipo">
                                                <option value="1" <c:if test="${emple.tipo == '1'}"> selected </c:if>>Control total</option>
                                                <option value="2" <c:if test="${emple.tipo == '2'}"> selected</c:if>>Edicion</option>
                                                <option value="3"<c:if test="${emple.tipo == '3'}">selected </c:if>>Registrar</option>
                                            </select>
                                        </div>
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
        <script src="js/codigo.js" type="text/javascript"></script>
        <!-- jQuery V3.4.1 -->
        <script src="./js/jquery-3.4.1.min.js" ></script>

        <!-- popper -->
        <script src="./js/popper.min.js" ></script>

        <!-- Bootstrap V4.3 -->
        <script src="./js/bootstrap.min.js" ></script>

        <!-- jQuery Custom Content Scroller V3.1.5 -->
        <script src="./js/jquery.mCustomScrollbar.concat.min.js" ></script>

        <!-- Bootstrap Material Design V4.0 -->
        <script src="./js/bootstrap-material-design.min.js" ></script>
        <script>$(document).ready(function () {
                                                $('body').bootstrapMaterialDesign();
                                            });
        </script>

        <script src="./js/main.js" ></script>
        <script>
                                            function mostrar() {
                                                var tipo = document.getElementById("pass");
                                                if (tipo.type == "password") {
                                                    tipo.type = "text";
                                                    $("#show").addClass('fa-eye-slash').removeClass('fa-eye');
                                                } else {
                                                    tipo.type = "password";
                                                    $('#show').addClass('fa-eye').removeClass('fa-eye-slash');
                                                }
                                            }
        </script>
    </body>
</html>