<%@page import="Modelo.Detallespro"%>
<%@page import="Modelo.Empleado"%>
<%@page import="Modelo.Producto"%>
<%@page import="Modelo.Agricultor"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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

    <%
        List<Agricultor> agricultor = (List<Agricultor>) request.getAttribute("listaAgri");
        List<Producto> producto = (List<Producto>) request.getAttribute("listaPro");
        List<Empleado> empleado = (List<Empleado>) request.getAttribute("listaEmple");
        List<Detallespro> detalles = (List<Detallespro>) request.getAttribute("listaDe");
    %>
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
                    <ul class="full-box list-unstyled page-nav-tabs">
                        <li>
                            <a  href="#" data-toggle="modal" data-target="#ModalAgregar"><i class="fas fa-plus fa-fw"></i> &nbsp; AGREGAR</a>
                        </li>
                        <li>
                            <a href="Controlador?menu=Detalles&accion=Listar"><i class="fas fa-clipboard-list fa-fw"></i> &nbsp; LISTAR </a>
                        </li>
                        <li>
                            <a href="#" data-toggle="modal" data-target="#ModalBuscar"><i  class="fas fa-search fa-fw"></i> &nbsp; BUSCAR </a>
                        </li>
                    </ul>	
                </div>
                <!-- ============================================MODAL AGREGAR============================= -->
                <div class="modal fade" id="ModalAgregar" tabindex="-1" role="dialog" aria-labelledby="ModalAgregar" aria-hidden="true">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="titulo modal-header">
                                <h5>Nuevo Suministro</h5>
                                <button type="button" class="close" data-dismiss="modal" >
                                    <span class="etiqueta4" >&times;</span>
                                </button>
                            </div>
                            <form class="modal-body" action="Controlador?menu=Detalles" method="POST"  >

                                <div class="form-group">
                                    <input type="hidden"  name="pk" class="form-control" >
                                </div>

                                <div class="form-group">
                                    <label  class="">Fecha</label>
                                    <input type="date"  class="form-control" name="txtFecha" >
                                </div>
                                <div class="form-group">
                                    <label for="" class="bmd-label-floating">Cantidad</label>
                                    <input type="text"  class="form-control" name="txtCantidad" >
                                </div>

                                <div class="form-group">
                                    <label for="item" class="bmd-label-floating">Agricultor</label>

                                    <select class="form-control" name="txtAgricultor" id="item"  >
                                        <option value="" selected disabled>Seleccione Agricultor</option>
                                        <%for (Agricultor ag : agricultor) {%> 
                                        <option value="<%=ag.getPk_agricultor()%>"><%=ag.getNombre1()%> </option>
                                        <%} %>
                                    </select>
                                </div> 
                                <div class="form-group">
                                    <label for="item" class="bmd-label-floating">Producto</label>
                                    <select class="form-control" name="txtProducto" id="item" >
                                        <option value="" selected disabled>Seleccione el Producto</option>
                                        <option value="" selected disabled>Seleccione Agricultor</option>
                                        <%for (Producto pro : producto) {%> 
                                        <option value="<%=pro.getPk_producto()%>"><%=pro.getNomInsumos()%> </option>
                                        <%} %>
                                    </select>
                                </div>
                                <div class="form-group">
                                    <label for="item" class="bmd-label-floating">Empleado</label>
                                    <select class="form-control" name="txtEmpleado" id="item" >
                                        <option value="" selected disabled >Seleccione Empleado</option>
                                        <%for (Empleado em : empleado) {%> 
                                        <option value="<%=em.getPk_empleado()%>"><%=em.getNombre()%> </option>
                                        <%}%>
                                    </select>
                                </div>
                                <p class="text-center">
                                    <button   type="submit" name="accion" value="Agregar" class="btn btn-raised btn-info"><i class=" fas fa-save "></i> &nbsp; AGREGAR</button>
                                </p>
                            </form>
                        </div>
                    </div>
                </div>
                <!-- ============================================MODAL BUSCAR============================= -->
                <div class="modal fade" id="ModalBuscar" tabindex="-1" role="dialog" aria-labelledby="ModalBuscar" aria-hidden="true">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="etiqueta">¿A Agricultor estas buscando?</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <form class="modal-body" action="Controlador?menu=Detalles" method="POST"  >
                                <div class="form-group">
                                    <label  class="bmd-label-floating">Ingresa el Nombre del Agricultor </label>
                                    <input type="text"  class="form-control" name="txtBusqueda" required="" title="Ingresa un nombre">
                                </div>
                                <p class="text-center">
                                    <button   type="submit" name="accion" value="Buscar" class="btn btn-raised btn-info "><i class="fas fa-search "></i> &nbsp; BUSCAR</button>
                                </p>
                            </form>
                        </div>
                    </div>
                </div>
                <!-- Content here-->
                <div class="container-fluid">
                    <div class="table-responsive">
                        <table class="table table-dark table-sm">
                            <thead>
                                <tr class="text-center roboto-medium">
                                    <th>Fecha</th>
                                    <th>Cantidad</th>
                                    <th>Agricultor</th>
                                    <th >Producto</th>
                                    <th >Empleado</th>
                                    <th class="ac">Editar</th>
                                    <th class="ac">Eliminar</th>
                                </tr>
                            </thead>
                            <tbody >
                                <%for (Detallespro de : detalles) {%>
                                <tr class="text-center"> 
                                    <td><%=de.getFechaEntrega()%></td>
                                    <td><%=de.getCantidad()%></td>
                                    <td><%=de.getFk_agricutor()%></td>
                                    <td><%=de.getFk_producto()%></td>
                                    <td><%=de.getFk_empleado()%></td>
                                    <td class="btnLis"><a  title="Actualizar Suministro"  class="btn btn-raised btn-success btn-sm" href="Controlador?menu=Detalles&accion=Editar&pk_detallesPro=<%=de.getPk_detallesPro()%>">
                                            <i class="fas  fa-sync-alt"></i></a>
                                    </td>
                                    <td class="btnLis"><a title="Eliminar Suministro"   class="btn btn-raised btn-danger btn-sm " href="Controlador?menu=Detalles&accion=Eliminar&pk_detallesPro=<%=de.getPk_detallesPro()%>">
                                            <i class="far fa-trash-alt"></i></a>
                                    </td>
                                </tr>
                                <%}%>
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
    </body>
</html>