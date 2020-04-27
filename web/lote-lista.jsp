<%@page import="Control.Variables"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <title>Lista de items</title>

        <!-- Normalize V8.0.1 -->
        <link rel="stylesheet" href="./css/normalize.css">

        <!-- Bootstrap V4.3 -->
        <link rel="stylesheet" href="./css/bootstrap.min.css">

        <!-- Bootstrap Material Design V4.0 -->
        <link rel="stylesheet" href="./css/bootstrap-material-design.min.css">

        <!-- Font Awesome V5.9.0 -->
        <link rel="stylesheet" href="./css/all.css">
        <link href="assets/fonts/style.css" rel="stylesheet" type="text/css"/>
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
                        <i class="fas fa-clipboard-list fa-fw"></i> &nbsp; LISTA DE LOTES
                    </h3>
                    <p class="text-justify">
                        lista de lotes existentes
                    </p>
                </div>
                <div class="container-fluid">
                    <ul class="full-box list-unstyled page-nav-tabs">
                        <li>
                            <a href="Controlador?menu=Lote&accion=Nuevo"><i class="fas fa-plus fa-fw"></i> &nbsp; AGREGAR LOTE</a>
                        </li>
                        <li>
                            <a href="Controlador?menu=Lote&accion=Listar"><i class="fas fa-clipboard-list fa-fw"></i> &nbsp; LISTA DE LOTES</a>
                        </li>
                        <li>
                            <a href="" data-toggle="modal" data-target="#ModalBuscar"><i  class="fas fa-search fa-fw"></i> &nbsp; BUSCAR LOTE</a>
                        </li>
                        <li>
                            <a href="Controlador?menu=Agricultor&accion=Listar"><i class="fas fa-backspace fa-fw"></i> &nbsp; Regresar</a>
                        </li>
                    </ul>
                </div>
                  <!-- ============================================MODAL HERRAMIENTAS=============================0 -->
                <div class="modal fade" id="ModalBuscar" tabindex="-1" role="dialog" aria-labelledby="ModalBuscar" aria-hidden="true">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="etiqueta">¿Busca algun lote en especial?</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <form class="modal-body" action="Controlador?menu=Lote" method="POST"  >
                                <div class="form-group">
                                    <label  class="bmd-label-floating">Ingresa el Codigo del lote</label>
                                    <input type="text"  class="form-control" name="txtCodigo" required="" title="Ingresa el dato ">
                                </div>
                                <p class="text-center">
                                    <button   type="submit" name="accion" value="Buscar" class="btn btn-raised btn-info "><i class="fas fa-search "></i> &nbsp; BUSCAR</button>
                                </p>
                            </form>
                        </div>
                    </div>
                </div>
                <!-- ===================================================================================================== -->
                <!--CONTENT-->
                <div class="container-fluid">
                    <strong class="text-danger">
                        COD: <%=Variables.idAgricultor%>
                        <%=Variables.agriNombre%>  &nbsp; <%=Variables.agriApellido%>&nbsp;
                    </strong>
                    <div class="table-responsive">
                        <table class="table table-dark table-sm">
                            <thead>
                                <tr class="text-center roboto-medium">
                                    <th>ID</th>
                                    <th>UbGeograafica</th>
                                    <th>Codigo</th>
                                    <th>Observaciones</th>
                                    <th>Recomendaciones</th>
                                    <th class="ac">Eliminar</th>
                                    <th class="ac">D.Extras</th>
                                    <th class="ac">Inspeccion</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="l" items="${listaLote}">
                                    <tr class="text-center">
                                        <td>${l.pk_lote}</td>
                                        <td>${l.ubi_Geografica}</td>
                                        <td>${l.codigo}</td>
                                        <td>${l.observaciones}</td>
                                        <td>${l.recomendaciones}</td>

                                        <td class="btnLis"><a class="btn btn-raised btn-danger btn-sm" href="Controlador?menu=Lote&accion=Eliminar&pk_lote=${l.pk_lote}">
                                                <i class="far fa-trash-alt"></i></a>
                                        </td>
                                        <td class="btnLis"><a title="Agregar datos Extras al Lote" class="btn btn-raised btn-success btn-sm" href="Controlador?menu=Lote&accion=LoteDatos&pk_lote=${l.pk_lote}">
                                                <i class="fas icon-text-document-inverted"></i></a>
                                        </td>
                                        <td class="btnLis"><a title="Lista de Visitas" class="btn btn-raised btn-dark btn-sm" href="Controlador?menu=Lote&accion=VerVisitas&pk_lote=${l.pk_lote}">
                                                <i class="fas fa-clipboard-list"></i></a>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <nav >

                    </nav>
                </div>
            </section>
        </main>


        <!--=============================================
        =            Include JavaScript files           =
        ==============================================-->
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
            });</script>

        <script src="./js/main.js" ></script>
    </body>
</html>