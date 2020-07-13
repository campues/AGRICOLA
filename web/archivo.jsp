<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Modelo.Archivo"%>
<%@page import="java.util.List"%>
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

    <%
        List<Archivo> archivos = (List<Archivo>) request.getAttribute("arch");
    %>

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
                <div class="container-fluid">
                    <br>
                    <h3 class="text-left">
                        <i class="fas fa-paperclip fa-fw "style="color: yellow"></i> DOCUMENTOS-ANEXOS
                    </h3>
                </div>

                <!-- ============================================AGREGAR============================= -->
                <div class="container col-md-7 ">

                    <ul class="full-box list-unstyled page-nav-tabs">
                        <li>
                            <a href="Controlador?menu=Agricultor&accion=Listar"class="text-info " ><i class="fas icon-back fa-fw"></i> &nbsp; Regresar</a>
                        </li>
                    </ul>
                    <form action="Control?accion=Agregar"   class="form-neon " method="POST" enctype="multipart/form-data">
                        <input type="hidden" name="fk" class="form-control" value="<%=Variables.idAgricultor%>">
                        <div class="row">
                            <div class=" col-md-6">
                                <div class="form-group">
                                    <label class="bmd-label-floating">Nombre del Archivo </label>
                                    <input type="text" class="form-control" name="txtNombre" required="">
                                </div>
                            </div>
                            <div class="col-md-4">
                                <div class="form-group">
                                    <label for="item" class="bmd-label-floating">Tipo</label>
                                    <select class="form-control" name="opTipo" required="">
                                        <option value="" selected="" disabled="">Seleccione una opcion</option>
                                        <option  value="IMAGEN">IMAGEN</option>
                                        <option value="PDF">PDF</option>
                                        <option value="WORD">WORD</option>
                                        <option value="OTRO">OTRO</option>
                                    </select>
                                </div>
                            </div>
                            <div class=" col-md-4">
                                <div class="form-group">
                                    <input type="file" class="btn btn-primary btn-sm float-left " name="fileImagen" required="">
                                </div>
                            </div>
                        </div>

                        <p class="text-center" style="margin-top: 40px;">
                            <button type="submit" class="btn btn-raised btn-info btn-sm" name="accion" value="Agregar"  ><i class="far fa-save"></i> &nbsp; Agregar</button>
                        </p> 
                </div>
                </form>
                </div>

                <!-- Content here-->
                <div class="container">
                    <div class="table-responsive">
                        <table class="table table-dark table-sm">
                            <thead >
                                <tr class="roboto-medium">
                                    <th>NOMBRE</th>
                                    <th>ARCHIVO</th>
                                    <th class="btnLis  ac text-center">OPCIONES</th>
                                </tr>
                            </thead>
                            <tbody>
                                <%for (Archivo a : archivos) {%>
                                <tr > 
                                    <td><%=a.getNomArchivo()%></td>
                                    <td >
                                        <% if (a.getTipo().equals("IMAGEN")) { %>
                                        <i class="fas fa-file-image" style="font-size: 30px;color: #ff9b67" title="Imagen"></i>
                                        <% } else if (a.getTipo().equals("PDF")) { %>
                                        <i class="fas fa-file-pdf text-danger" style="font-size:30px" title="Documento PDF" ></i> 
                                        <% } else if (a.getTipo().equals("WORD")) { %>
                                        <i class="fas fa-file-word text-info"  style="font-size:30px"  title="Documento Word"></i>
                                        <%} else { %>
                                        <i class="fas fa-file-archive btn-outline-primary"  style="font-size:30px"  title="Archivo Desconocido"></i>
                                        <%}%>
                                    </td>
                                    <td class="btnLis text-center">
                                        <%if (session.getAttribute("tipo").equals("1")) {%>
                                        <a  title="Eliminar Archivo"  id="be" class="btn btn-raised btn-danger btn-sm" href="Control?accion=Eliminar&pk_archivo=<%=a.getPk_archivo()%>">
                                            <i class="far fa-trash-alt"></i></a>
                                        <a  title="Abrir Archivo"  target="_blank" class="btn btn-raised btn-primary btn-sm" href="<%=a.getRuta()%>">
                                            <i class="far fa-folder-open"></i></a>
                                            <%} else {%>
                                        <a  title="Abrir Archivo"  target="_blank" class="btn btn-raised btn-primary btn-sm" href="<%=a.getRuta()%>">
                                            <i class="far fa-folder-open"></i></a>
                                            <%}%>
                                    </td>
                                </tr>
                                <%}%>
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