<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <title>Buscar clientes</title>

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

        <link href="css/alertify.min.css" rel="stylesheet" type="text/css"/>
        <link href="css/default.min.css" rel="stylesheet" type="text/css"/>

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
                        <i class="fas fa-search fa-fw"></i> &nbsp; BUSCAR AGRICULTOR
                    </h3>
                    <p class="text-justify">
                        Busca al agricultor
                    </p>
                </div>

                <div class="container-fluid">
                    <ul class="full-box list-unstyled page-nav-tabs">
                        <li>
                            <a href="agricultor-nuevo.jsp"><i class="fas fa-plus fa-fw"></i> &nbsp; AGREGAR AGRICULTORES</a>
                        </li>
                        <li>
                            <a  href="Controlador?menu=Agricultor&accion=Listar"><i class="fas fa-clipboard-list fa-fw"></i> &nbsp; LISTA DE AGRICULTORES</a>
                        </li>
                        <li>
                            <a class="active" href="Controlador?menu=Agricultor&accion=Enlistar"><i class="fas fa-search fa-fw"></i> &nbsp; BUSCAR AGRICULTOR</a>
                        </li>
                    </ul>	
                </div>
                <!-- Content here-->
                <div class="container-fluid">
                    <form class="form-neon" action="Controlador?menu=Agricultor" method="POST"  >
                        <div class="container-fluid">
                            <div class="row justify-content-md-center">
                                <div class="col-12 col-md-6">
                                    <div class="form-group">
                                        <label for="in" class="bmd-label-floating">Ingresa el numero de cedula?</label>
                                        <input type="text" class="form-control" name="txtCedula" id="in"  value="${cedula}" required="" title="Ingresa la cedula">
                                    </div>
                                </div>
                                <div class="col-12">
                                    <p class="text-center" style="margin-top: 40px;">
                                        <button type="submit" name="accion"  onsubmit="return validar2()" value="Buscar" class="btn btn-raised btn-info"><i class="fas fa-search"></i> &nbsp; BUSCAR</button>
                                        <button type="submit"   name="accion" value="Enlistar" class="btn btn-raised btn-danger"><i class="far fa-trash-alt"></i> &nbsp; ELIMINAR BUSQUEDA</button>
                                    </p>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
                <!-- Content here-->
                <div class="container-fluid">
                    <label style="color: black;">Resultados de la busqueda</label>
                    <div class="table-responsive">
                        <table class="table table-dark table-sm">
                            <thead>
                                <tr class="text-center roboto-medium">
                                    <th>ID</th>
                                    <th>Nombre</th>
                                    <th>Apellido</th>
                                    <th>Cedula</th>
                                    <th>Telefono</th>
                                    <th>Estatus</th>
                                    <th>Fecha Afiliacion</th>
                                    <th colspan="3">Accion</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="a" items="${listaAgri}">
                                    <tr class="text-center"> 
                                        <td><c:out value="${a.pk_agricultor}"/></td>
                                        <td><c:out value="${a.nombre1}"/></td>
                                        <td><c:out value="${a.apellido1}"/></td>
                                        <td><c:out value="${a.cedula}"/></td>
                                        <td><c:out value="${a.telefono}"/></td>
                                        <td><c:out value="${a.estatus}"/></td>
                                        <td><c:out value="${a.fechaAfiliacion}"/></td>
                                        <td><a id="" class="btn btn-success" href="Controlador?menu=Agricultor&accion=showedit&pk_agricultor=<c:out value="${a.pk_agricultor}"/>">
                                                <i class="fas  fa-sync-alt"></i></a>
                                        </td>
                                        <td><a id="elimina" class="btn btn-warning" href="Controlador?menu=Agricultor&accion=Eliminar&pk_agricultor=<c:out value="${a.pk_agricultor}"/>">
                                                <i class="far fa-trash-alt"></i></a>
                                        </td>
                                        <td><a class="btn btn-warning" href="Controlador?menu=Agricultor&accion=VerTerreno&pk_agricultor=<c:out value="${a.pk_agricultor}"/>">
                                                <i class="fas fa-box-open"></i></a>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <nav aria-label="Page navigation example">
                        <ul class="pagination justify-content-center">
                            <li class="page-item disabled">
                                <a class="page-link" href="#" tabindex="-1">Previous</a>
                            </li>
                            <li class="page-item"><a class="page-link" href="#">1</a></li>
                            <li class="page-item"><a class="page-link" href="#">2</a></li>
                            <li class="page-item"><a class="page-link" href="#">3</a></li>
                            <li class="page-item">
                                <a class="page-link" href="#">Next</a>
                            </li>
                        </ul>
                    </nav>
                </div>


            </section>
        </main>

        <!--=============================================
        =            Include JavaScript files           =
        ==============================================-->
        <script  >
            function validar2() {
                var n0 = document.getElementsByName("txtCedula").value;

                if (n0.value === "") {
                    n0.focus();
                    alertify.alert("Error", "Ingrese Cedula").set('label', 'OK');
                    return false;
                } else {
                    alertify.success("Busqueda correcta");
                    return true;
                }
            }

        </script>
        <script src="css/alertify.min.js" type="text/javascript"></script>
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