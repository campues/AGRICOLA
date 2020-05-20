<%@page import="Control.Variables"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <title>Lista de clientes</title>
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
                        <i class="fas fa-clipboard-list fa-fw"></i> &nbsp; LISTA DE AGRICULTORES
                    </h3>
                    <p class="text-justify">
                        Lista de agricultores
                    </p>
                    <div class="container-fluid">
                        <ul class="full-box list-unstyled page-nav-tabs">
                            <li>
                                <a href="agricultor-nuevo.jsp"><i class="fas fa-plus fa-fw"></i> &nbsp; AGREGAR AGRICULTORES</a>
                            </li>
                            <li>
                                <a href="Controlador?menu=Agricultor&accion=Listar"><i class="fas fa-clipboard-list fa-fw"></i> &nbsp; LISTA DE AGRICULTORES</a>
                            </li>
                            <li>
                                <a  href="" data-toggle="modal" data-target="#ModalBuscar"><i  class="fas fa-search fa-fw"></i> &nbsp; BUSCAR AGRICULTOR</a>
                            </li>
                        </ul>	
                    </div>
                    <!-- ============================================MODAL HERRAMIENTAS=============================0 -->
                    <div class="modal fade" id="ModalBuscar" tabindex="-1" role="dialog" aria-labelledby="ModalBuscar" aria-hidden="true">
                        <div class="modal-dialog" role="document">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="etiqueta">¿A que Agricultor estas buscando?</h5>
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                                </div>
                                <form class="modal-body" action="Controlador?menu=Agricultor" method="POST"  >
                                    <div class="form-group">
                                        <label  class="bmd-label-floating">Ingresa el numero de cedula</label>
                                        <input type="text"  class="form-control" name="txtCedula" required="" title="Ingresa un nombre">
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
                            <thead>
                                <tr class=" roboto-medium">
                                    <th>ID</th>
                                    <th>Nombre</th>
                                    <th>Apellido</th>
                                    <th>Cedula</th>
                                    <th>Telefono</th>
                                    <th>Estatus</th>
                                    <th>Fecha Afiliacion</th>
                                    <th class="ac text-center">Opciones</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="a" items="${listaAgri}">
                                    <tr > 
                                        <td>${a.pk_agricultor}</td>
                                        <td>${a.nombre1}</td>
                                        <td>${a.apellido1}</td>
                                        <td>${a.cedula}</td>
                                        <td>${a.telefono}</td>
                                        <td>${a.estatus}</td>
                                        <td>${a.fechaAfiliacion}</td>

                                        <td class=" text-center">
                                            <%if (session.getAttribute("tipo").equals("1")) {%>
                                            <a  title="Actualizar datos del Agricultor" class="btn btn-raised btn-success btn-sm" href="Controlador?menu=Agricultor&accion=showedit&pk_agricultor=${a.pk_agricultor}">
                                                <i class="fas  fa-sync-alt"></i></a>

                                            <a  title="Eliminar Agricultor"  id="be" class="btn btn-raised btn-danger btn-sm" href="Controlador?menu=Agricultor&accion=Eliminar&pk_agricultor=${a.pk_agricultor}">
                                                <i class="far fa-trash-alt"></i></a>

                                            <a title="Lotes del Agricultor" class="btn btn-raised btn-dark btn-sm" href="Controlador?menu=Agricultor&accion=VerTerreno&pk_agricultor=${a.pk_agricultor}">
                                                <i class="fas fa-box-open"></i></a>

                                            <%} else if (session.getAttribute("tipo").equals("2")) {%>
                                            <a  title="Actualizar datos del Agricultor" class="btn btn-raised btn-success btn-sm" href="Controlador?menu=Agricultor&accion=showedit&pk_agricultor=${a.pk_agricultor}">
                                                <i class="fas  fa-sync-alt"></i></a>
                                            <a title="Lotes del Agricultor" class="btn btn-raised btn-dark btn-sm" href="Controlador?menu=Agricultor&accion=VerTerreno&pk_agricultor=${a.pk_agricultor}">
                                                <i class="fas fa-box-open"></i></a>
                                                <%} else {%>
                                            <a title="Lotes del Agricultor" class="btn btn-raised btn-dark btn-sm" href="Controlador?menu=Agricultor&accion=VerTerreno&pk_agricultor=${a.pk_agricultor}">
                                                <i class="fas fa-box-open"></i></a>
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