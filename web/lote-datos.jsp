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
                        <i class="fas fa-building fa-fw"></i> &nbsp; DATOS EXTRAS DEL LOTE
                    </h3>
                    <p class="text-justify">
                        Animales,Herramientas,insumos,Mano de obra

                    </p>
                </div>

                <!--CONTENT-->
                <div class="container-fluid">
                    <form action="Controlador?menu=Herramientas"  class="form-neon" method="POST">
                        <legend><i class="fas fa-pallet "></i> &nbsp; Herramientas</legend>

                        <input type="text"   name="fk_loteh"  value="<%=Variables.idLote%>">
                        <div class="row">
                            <div class="col-12 col-md-2">
                                <div class="form-group">
                                    <label for="item" class="bmd-label-floating">Herramientas</label>
                                    <select class="form-control" name="opHerramientas" id="item">
                                        <option value="" selected="" disabled="">Seleccione una opcion</option>
                                        <option value="Pala">Pala</option>
                                        <option value="Pico">Pico</option>
                                        <option value="Bomba de mochila">Bomba de mochila</option>
                                        <option value="Podadora">Podadora</option>
                                        <option value="Escabadora">Escabadora</option>
                                        <option value="Machete">Machete</option>
                                        <option value="Asadon">Asadon</option>
                                    </select>
                                </div>
                            </div>
                            <div class="col-12 col-md-2">
                                <div class="form-group">
                                    <label  class="bmd-label-floating">Cantidad</label>
                                    <input type="text"  class="form-control" name="txtCantidad">
                                </div>
                            </div>
                            <div class="form-group">
                                <button type="submit" class="btn btn-raised btn-info btn-sm" name="accion" value="Agregar" ><i class="far fa-save"></i> &nbsp; AGREGAR</button>
                            </div>
                        </div>
                    </form>
                </div>
                <div class="container-fluid">
                    <div class="table-responsive">
                        <table class="table table-dark table-sm">
                            <thead>
                                <tr class="text-center roboto-medium">
                                    <th>Cod</th>
                                    <th>Nombre</th>
                                    <th>Cantidad</th>
                                    <th>Lote</th>
                                </tr>
                            </thead>
                            <tbody  >
                                <c:forEach var="h" items="${listaHerra}">
                                    <tr class="text-center">
                                        <td>${h.pk_herramientas}</td>
                                        <td>${h.nomHerramienta}</td>
                                        <td>${h.cantidad}</td>
                                        <td>${h.fk_loteh}</td>
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