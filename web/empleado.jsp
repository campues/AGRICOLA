<%@page import="Modelo.Empleado"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <title>Lista usuarios</title>
        <!-- dataTable -->
        <link rel="stylesheet" href="datatables/datatables.min.css"/>
        <link rel="stylesheet" href="datatables/stylo-tabla.css" />
    </head>
    <%
        List<Empleado> emplea = (List<Empleado>) request.getAttribute("empleados");
        //Empleado empleaa = (Empleado) request.getAttribute("emple");
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
                <!-- Page header -->
                <div class="full-box page-header">
                    <h3 class="text-left">
                        <i class="fas fa-clipboard-list fa-fw"></i> &nbsp; LISTA DE USUARIOS
                    </h3>
                    <p class="text-justify">
                        Lista de usuarios
                    </p>

                    <div class="container-fluid">
                        <ul class="full-box list-unstyled page-nav-tabs">
                            <li>
                                <a  href="#" data-toggle="modal" data-target="#ModalAgregar"><i class="fas fa-plus fa-fw"></i> &nbsp; AGREGAR</a>
                            </li>
                            <li>
                                <a href="Controlador?menu=Empleados&accion=Listar"><i class="fas fa-clipboard-list fa-fw"></i> &nbsp; LISTA DE USUARIOS</a>
                            </li>
                            <li>
                                <a  href="#" data-toggle="modal" data-target="#ModalBuscar"><i  class="fas fa-search fa-fw"></i> &nbsp; BUSCAR USUARIO</a>
                            </li>
                        </ul>	
                    </div>
                    <!-- ============================================MODAL AGREGAR============================= -->
                    <div class="modal fade" id="ModalAgregar" tabindex="-1" role="dialog" aria-labelledby="ModalAgregar" aria-hidden="true">
                        <div class="modal-dialog" role="document">
                            <div class="modal-content">
                                <div class="titulo modal-header">
                                    <i class="fas icon-v-card"></i> &nbsp;  <h5>Nuevo Empleado</h5>
                                    <button type="button" class="close" data-dismiss="modal" >
                                        <span class="etiqueta4" >&times;</span>
                                    </button>
                                </div>
                                <form action="Controlador?menu=Empleados" class="form-neon" autocomplete="off" method="POST">
                                    <fieldset>
                                        <div class="container-fluid">
                                            <div class="row">
                                                <div class="col-md-5">
                                                    <div class="form-group">
                                                        <input type="hidden" class="form-control" name="pk" >
                                                        <label for="usuario_nombre" class="bmd-label-floating">Nombres</label>
                                                        <input type="text" class="form-control" name="txtNombre">
                                                    </div>
                                                </div>
                                                <div class=" col-md-5">
                                                    <div class="form-group">
                                                        <label for="usuario_apellido" class="bmd-label-floating">Apellidos</label>
                                                        <input type="text"  class="form-control" name="txtApellido" >
                                                    </div>
                                                </div>
                                                <div class="col-md-5">
                                                    <div class="form-group">
                                                        <label for="usuario_usuario" class="bmd-label-floating">Usuario</label>
                                                        <input type="text"  class="form-control" name="txtUsuario" >
                                                    </div>
                                                </div>
                                                <div class="col-md-5">
                                                    <div class="form-group">
                                                        <label for="pass" class="bmd-label-floating">Contraseña</label>
                                                        <input type="password" class="form-control" name="txtContrasena"  id="pass">
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
                                                        <select class="form-control" name="opTipo" >
                                                            <option disabled selected>Seleccione una opcion</option>
                                                            <option value="1" >Control total</option>
                                                            <option value="2" >Edicion</option>
                                                            <option value="3">Registrar</option>
                                                        </select>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </fieldset>
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
                                    <h5 class="etiqueta">¿A que empleado estas buscando?</h5>
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                                </div>
                                <form class="modal-body" action="Controlador?menu=Empleados" method="POST"  >
                                    <div class="form-group">
                                        <label  class="bmd-label-floating">Ingresa el Nombre</label>
                                        <input type="text"  class="form-control" name="txtBusqueda" required="" title="Ingresa un nombre">
                                    </div>
                                    <p class="text-center">
                                        <button   type="submit" name="accion" value="Buscar" class="btn btn-raised btn-info "><i class="fas fa-search "></i> &nbsp; BUSCAR</button>
                                    </p>
                                </form>
                            </div>
                        </div>
                    </div>
                    <!-- ===================================================================================================== -->

                    <!-- Content -->
                  
                    <div class="table-responsive">
                        <table id="tablalist" class="table table-dark table-sm">
                            <thead >
                                <tr class="roboto-medium">
                                    <th>Nombre</th>
                                    <th>Apellido</th>
                                    <th>Usuario</th>
                                    <th>Acceso</th>
                                    <th class="ac">Opciones</th>
                                </tr>
                            </thead>
                            <% for (Empleado em : emplea) {%>
                            <tr >
                                <td><%=em.getNombre()%></td>
                                <td><%=em.getApellido()%></td>
                                <td><%=em.getUsuario()%></td>
                                <td> 
                                    <% if (em.getTipo().equals("1")) {%>
                                    Control Total
                                    <%} else if (em.getTipo().equals("2")) { %>
                                    Edición
                                    <%} else { %>
                                    Registro
                                    <%}%>
                                </td>
                                <td class="btnLis text-center">
                                    <a title="Actualizar Registro" class="btn btn-raised btn-success btn-sm"   href="Controlador?menu=Empleados&accion=Editar&pk_empleado=<%=em.getPk_empleado()%>" >
                                        <i class="fas  fa-sync-alt"></i></a>
                                    <a title="Eliminar Registro" class="btn btn-raised btn-danger btn-sm" href="Controlador?menu=Empleados&accion=Eliminar&pk_empleado=<%=em.getPk_empleado()%>" >
                                        <i class="far fa-trash-alt"></i></a>
                                </td>
                            </tr>
                            <%}%>
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
        <script src="./js/jquery.mCustomScrollbar.concat.min.js" ></script>

        <!-- Bootstrap Material Design V4.0 -->
        <script src="./js/bootstrap-material-design.min.js" ></script>
        <script>$(document).ready(function () {
                                                            $('body').bootstrapMaterialDesign();
                                                        });</script>

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