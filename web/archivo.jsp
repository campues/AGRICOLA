<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Control.Variables"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <title>Archivo</title>
        <!-- dataTable -->
        <link rel="stylesheet" href="datatables/datatables.min.css"/>
        <link rel="stylesheet" href="datatables/stylo-tabla.css" />
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
                        <i class="fas fa-file text-danger"></i> <i class="fas fa-paperclip fa-fw text-info"></i>  DOCUMENTOS-ANEXOS
                    </h3>
                    <div class="container-fluid">
                        <ul class="full-box list-unstyled page-nav-tabs">
                            <li>
                                <a href="Controlador?menu=Agricultor&accion=Listar"class="text-info " ><i class="fas icon-back fa-fw"></i> &nbsp; Regresar</a>
                            </li>
                        </ul>
                    </div>
                </div>
                <!-- ============================================AGREGAR============================= -->
                <div class="container-fluid">
                    <form action="Control?accion=Agregar"  class="form-neon" method="POST" enctype="multipart/form-data">
                        <fieldset>
                            <legend><i class="far fa-building"></i> &nbsp; Arhivo</legend>
                            <div class="container-fluid">
                                <div class="row">
                                    <div class="col-md-1">
                                        <div class="form-group">
                                            <label class="bmd-label-floating">FK</label>
                                            <input type="text" name="fk" class="form-control" value="<%=Variables.idAgricultor%>">
                                        </div>
                                    </div>
                                    <div class=" col-md-3">
                                        <div class="form-group">
                                            <label class="bmd-label-floating">Nombre del Documento</label>
                                            <input type="text" class="form-control" name="txtNombre">
                                        </div>
                                    </div>
                                    <div class=" col-md-4">
                                        <div class="form-group">
                                            <input type="file" class="form-control" name="fileImagen">
                                        </div>
                                    </div>

                                </div>
                                <p class="text-center" style="margin-top: 40px;">
                                    <button type="submit" class="btn btn-raised btn-info btn-sm" name="accion" value="Agregar"  ><i class="far fa-save"></i> &nbsp; Agregar</button>
                                </p> 
                            </div>
                        </fieldset>
                    </form>
                </div>

                <!-- Content here-->
                <div class="container-fluid">
                    <div class="table-responsive">
                        <table id="tablalist" class="table table-dark table-sm">
                            <thead >
                                <tr class="roboto-medium">
                                    <th>ID</th>
                                    <th>NOMBRE</th>
                                    <th>RUTA</th>
                                    <th class="btnLis  ac text-center">OPCIONES</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="a" items="${archivos}">
                                    <tr > 
                                        <td>${a.pk_archivo}</td>
                                        <td>${a.nomArchivo}</td>
                                        <td><img src="${a.ruta}" height="100" width="100"></td>
                                        <td class="btnLis text-center">
                                            <a  title="Eliminar Eliminar"  id="be" class="btn btn-raised btn-danger btn-sm" href="Control?accion=Eliminar&pk_archivo=${a.pk_archivo}">
                                                <i class="far fa-trash-alt"></i></a>
                                        </td>

                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>

                </div>
                <!-- ===================================================================================================== -->

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