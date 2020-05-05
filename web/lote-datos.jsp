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

                </div>
                <div class="container-fluid">
                    <ul class="full-box list-unstyled page-nav-tabs">
                        <li>
                            <a href="Controlador?menu=Lote&accion=Listar"> Regresar&nbsp; <i class="fas icon-back fa-fw"></i>  </a>
                        </li>
                    </ul>	
                </div>
                <!-- ============================================MODAL AGREGAR HERRAMIENTAS============================= -->
                <div class="modal fade " id="ModalAgregar" tabindex="-1" role="dialog" aria-labelledby="ModalAgregar" aria-hidden="true">
                    <div class="modal-dialog " role="document">
                        <div class="modal-content "  >
                            <div class="titulo modal-header">
                                <h5>Agregar Herramientas</h5>
                                <button type="button" class="close" data-dismiss="modal" >
                                    <span class="etiqueta4" >&times;</span>
                                </button>
                            </div>
                            <form action="Controlador?menu=Herramientas"  class="form-neon" method="POST">
                                <input type="hidden"   name="fk_loteh"  value="<%=Variables.idLote%>">
                                <div class="form-group">
                                    <label for="item" class="bmd-label-floating">Herramienta</label>
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
                                <div class="form-group">
                                    <label  class="bmd-label-floating">Cantidad</label>
                                    <input type="text"  class="form-control" name="txtCantidad">
                                </div>
                                <p class="text-center">
                                    <button   type="submit" name="accion" value="Agregar" class="btn btn-raised btn-info"><i class=" fas fa-save "></i> &nbsp; AGREGAR</button>
                                </p>
                            </form>
                        </div>
                    </div>
                </div>
                <!--LISTA HERRAMIENTAS-->
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-md-3">

                            <div class="table-responsive">
                                <table class=" table table-dark table-sm">
                                    <thead>
                                        <tr style="background: #34ce57;">
                                            <th colspan="3" class="text-center "><a class="etiqueta4" href="#" data-toggle="modal" data-target="#ModalAgregar"><i class="fas fa-plus fa-fw"></i> &nbsp;Herramientas</a></th>
                                        </tr>
                                        <tr class="text-center roboto-medium">
                                            <th>Nombre</th>
                                            <th>Cantidad</th>
                                            <th>Eliminar</th>
                                        </tr>
                                    </thead>
                                    <tbody  >
                                        <c:forEach var="h" items="${listaHerra}">
                                            <tr class="text-center">
                                                <td>${h.nomHerramienta}</td>
                                                <td>${h.cantidad}</td>
                                                <td class="btnLis"><a title="Eliminar Herramienta"   class="btn btn-raised btn-danger btn-sm " href="Controlador?menu=Herramientas&accion=Eliminar&pk_herramientas=${h.pk_herramientas}">
                                                        <i class="far fa-trash-alt"></i></a>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                        <!-- ============================================MODAL AGREGAR ANIMALES============================= -->
                        <div class="modal fade " id="ModalAnimales" tabindex="-1" role="dialog" aria-labelledby="ModalAnimales" aria-hidden="true">
                            <div class="modal-dialog " role="document">
                                <div class="modal-content "  >
                                    <div class="titulo modal-header">
                                        <h5>Agregar Animales</h5>
                                        <button type="button" class="close" data-dismiss="modal" >
                                            <span class="etiqueta4" >&times;</span>
                                        </button>
                                    </div>
                                    <form action="Controlador?menu=Animales"  class="form-neon" method="POST">
                                        <input type="hidden"   name="fk_lotea"  value="<%=Variables.idLote%>">
                                        <div class="form-group">
                                            <label for="item" class="bmd-label-floating">Especie</label>
                                            <select class="form-control" name="opAnimales" id="item">
                                                <option value="" selected="" disabled="">Seleccione una opcion</option>
                                                <option value="Ganado">Ganado</option>
                                                <option value="Cuyes">Cuyes</option>
                                                <option value="Ovejas">Ovejas</option>
                                                <option value="Chanchos">Chanchos</option>
                                                <option value="Gallinas">Gallinas</option>
                                                <option value="Otros">Otros</option>
                                            </select>
                                        </div>
                                        <div class="form-group">
                                            <label  class="bmd-label-floating">Cantidad</label>
                                            <input type="text"  class="form-control" name="txtCantidad">
                                        </div>
                                        <p class="text-center">
                                            <button   type="submit" name="accion" value="Agregar" class="btn btn-raised btn-info"><i class=" fas fa-save "></i> &nbsp; AGREGAR</button>
                                        </p>
                                    </form>
                                </div>
                            </div>
                        </div>
                        <!--LISTA ANIMALES-->
                        <div class="col-md-3">
                            <div class="table-responsive">
                                <table class=" table table-dark table-sm">
                                    <thead>
                                        <tr style="background: #34ce57;">
                                            <th colspan="3" class="text-center "><a class="etiqueta4" href="#" data-toggle="modal"  data-target="#ModalAnimales"><i class="fas fa-plus fa-fw"></i> &nbsp;Animales</a></th>
                                        </tr>
                                        <tr class="text-center roboto-medium">
                                            <th>Especie</th>
                                            <th>Cantidad</th>
                                            <th>Eliminar</th>
                                        </tr>
                                    </thead>
                                    <tbody  >
                                        <c:forEach var="a" items="${listaAnim}">
                                            <tr class="text-center">
                                                <td>${a.especie}</td>
                                                <td>${a.cantidad}</td>
                                                <td class="btnLis"><a title="Eliminar Especie"   class="btn btn-raised btn-danger btn-sm " href="Controlador?menu=Animales&accion=Eliminar&pk_animales=${a.pk_animales}">
                                                        <i class="far fa-trash-alt"></i></a>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                        <!-- ============================================MODAL AGREGAR MANO OBRA============================= -->
                        <div class="modal fade " id="ModalManObra" tabindex="-1" role="dialog" aria-labelledby="ModalManObra" aria-hidden="true">
                            <div class="modal-dialog " role="document">
                                <div class="modal-content "  >
                                    <div class="titulo modal-header">
                                        <h5>Agregar Trabajadores</h5>
                                        <button type="button" class="close" data-dismiss="modal" >
                                            <span class="etiqueta4" >&times;</span>
                                        </button>
                                    </div>
                                    <form action="Controlador?menu=ManObra"  class="form-neon" method="POST">
                                        <input type="hidden"   name="fk_lotem"  value="<%=Variables.idLote%>">
                                        <div class="form-group">
                                            <label for="item" class="bmd-label-floating">Mano de Obra</label>
                                            <select class="form-control" name="opfamilia" id="item">
                                                <option value="" selected="" disabled="">Seleccione una opcion</option>
                                                <option value="Permanente">Permanente</option>
                                                <option value="Temporal">Temporal</option>
                                            </select>
                                        </div>
                                        <div class="form-group">
                                            <label for="item" class="bmd-label-floating">Edad</label>
                                            <select class="form-control" name="opEdad" id="item">
                                                <option value="" selected="" disabled="">Seleccione una opcion</option>
                                                <option value="Mayor 18">Adulto Mayor de 18 años</option>
                                                <option value="Entre 12-18">Adolescentes 12 a 18 años</option>
                                                <option value="Menor 12">Niños menor a 12 años</option>
                                            </select>
                                        </div>
                                        <div class="form-group">
                                            <label for="item" class="bmd-label-floating">Sexo</label>
                                            <select class="form-control" name="opSexo" id="item">
                                                <option value="" selected="" disabled="">Seleccione una opcion</option>
                                                <option value="Hombre">Hombre</option>
                                                <option value="Mujer">Mujer</option>
                                            </select>
                                        </div>
                                        <div class="form-group">
                                            <label  class="bmd-label-floating">Cantidad</label>
                                            <input type="text"  class="form-control" name="txtCantidad">
                                        </div>
                                        <p class="text-center">
                                            <button   type="submit" name="accion" value="Agregar" class="btn btn-raised btn-info"><i class=" fas fa-save "></i> &nbsp; AGREGAR</button>
                                        </p>
                                    </form>
                                </div>
                            </div>
                        </div>
                        <!--Lista mano Obra-->
                        <div class="col-md-5">
                            <div class="table-responsive">
                                <table class=" table table-dark table-sm">
                                    <thead>
                                        <tr style="background: #34ce57;">
                                            <th colspan="5" class="text-center "><a class="etiqueta4" href="#" data-toggle="modal"  data-target="#ModalManObra"><i class="fas fa-plus fa-fw"></i> &nbsp;Trabajadores</a></th>
                                        </tr>
                                        <tr class="text-center roboto-medium">
                                            <th>Mano Obra</th>
                                            <th>Edad</th>
                                            <th>Sexo</th>
                                            <th>Cantidad</th>
                                            <th>Eliminar</th>
                                        </tr>
                                    </thead>
                                    <tbody  >
                                        <c:forEach var="m" items="${listaMan}">
                                            <tr class="text-center">
                                                <td>${m.familia}</td>
                                                <td>${m.edad}</td>
                                                <td>${m.sexo}</td>
                                                <td>${m.cantidad}</td>
                                                <td class="btnLis"><a title="Eliminar Mano Obra"   class="btn btn-raised btn-danger btn-sm " href="Controlador?menu=ManObra&accion=Eliminar&pk_manObra=${m.pk_manObra}">
                                                        <i class="far fa-trash-alt"></i></a>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                        <!---------->
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