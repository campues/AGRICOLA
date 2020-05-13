<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html lang="es">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <title>Datos de la empresa</title>
        <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.21/css/dataTables.bootstrap4.min.css"/> 
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
                        <i class="fas fa-building fa-fw"></i> &nbsp; INFORMACION DE SUMINISTRO DE PRODUCTOS
                    </h3>
                    <p class="text-justify">
                        Suministrar productos al agricultor
                    </p>
                </div>
                <div class="container-fluid">
                    <form  action="Controlador?menu=Productos"  class="form-neon"  method="POST" >
                        <fieldset>
                            <legend><i class="far fa-building"></i> &nbsp; Agregar Productos</legend>
                            <div class="container-fluid">
                                <div class="row">

                                    <div class="col-12 col-md-2">
                                        <div class="form-group">
                                            <label for="" class="bmd-label-floating">Nombre Producto</label>
                                            <input type="text"  class="form-control" name="txtNombre" >
                                        </div>
                                    </div>
                                    <div class="col-12 col-md-2">
                                        <div class="form-group">
                                            <label for="" class="bmd-label-floating">Stock</label>
                                            <input type="text"  class="form-control" name="txtStock" >
                                        </div>
                                    </div>
                                    <div class="col-12 col-md-2">
                                        <div class="form-group">
                                            <label for="" class="bmd-label-floating">Tipo Producto</label>
                                            <input type="text"  class="form-control" name="txtTipo" >
                                        </div>
                                    </div>
                                    <p class="text-center" style="margin-top: 40px;">
                                        <button type="submit" class="btn btn-raised btn-info btn-sm" name="accion" value="Agregar"  ><i class="far fa-save"></i> &nbsp; Agregar</button>
                                    </p>
                                </div>
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
                                    <th>Id</th>
                                    <th>Nombre</th>
                                    <th>Stock</th>
                                    <th>Tipo</th>
                                    <th class="ac" >Accion</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="pro" items="${listaPro}">
                                    <tr > 
                                        <td><c:out value="${pro.pk_producto}"/></td>
                                        <td><c:out value="${pro.nomInsumos}"/></td>
                                        <td><c:out value="${pro.stock}"/></td>
                                        <td><c:out value="${pro.tipoInsumo}"/></td>
                                        <td class="btnLis text-center"><a title="Eliminar Producto"   class="btn btn-warning" href="Controlador?menu=Productos&accion=Eliminar&pk_producto=<c:out value="${pro.pk_producto}"/>">
                                                <i class="far fa-trash-alt"></i></a>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>

                </div>


            </section>
        <!--    Datatables-->
            <script src="js/jquery-3.4.1.min.js" type="text/javascript"></script>
            <script type="text/javascript" src="https://cdn.datatables.net/v/bs4/dt-1.10.20/datatables.min.js"></script> 
            <script src="js/datetable.js" type="text/javascript"></script>
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