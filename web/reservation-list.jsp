<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <title>Lista de prestamos</title>

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
                        <i class="fas fa-clipboard-list fa-fw"></i> &nbsp; LISTA DE PRÉSTAMOS
                    </h3>
                    <p class="text-justify">
                        Lorem ipsum dolor sit amet, consectetur adipisicing elit. Officia fugiat est ducimus inventore, repellendus deserunt cum aliquam dignissimos, consequuntur molestiae perferendis quae, impedit doloribus harum necessitatibus magnam voluptatem voluptatum alias!
                    </p>
                </div>
                <div class="container-fluid">
                    <ul class="full-box list-unstyled page-nav-tabs">
                        <li>
                            <a href="reservation-new.html"><i class="fas fa-plus fa-fw"></i> &nbsp; NUEVO PRÉSTAMO</a>
                        </li>
                        <li>
                            <a class="active" href="reservation-list.html"><i class="fas fa-clipboard-list fa-fw"></i> &nbsp; LISTA DE PRÉSTAMOS</a>
                        </li>
                        <li>
                            <a href="reservation-search.html"><i class="fas fa-search-dollar fa-fw"></i> &nbsp; BUSCAR PRÉSTAMOS</a>
                        </li>
                        <li>
                            <a href="reservation-pending.html"><i class="fas fa-hand-holding-usd fa-fw"></i> &nbsp; PRÉSTAMOS PENDIENTES</a>
                        </li>
                    </ul>
                </div>

                <!--CONTENT-->

                <div class="container-fluid">
                    <div class="table-responsive">
                        <table class="table table-dark table-sm">
                            <thead>
                                <tr class="text-center roboto-medium">
                                    <th>#</th>
                                    <th>CLIENTE</th>
                                    <th>FECHA DE PRÉSTAMO</th>
                                    <th>FECHA DE ENTREGA</th>
                                    <th>ESTADO</th>
                                    <th>FACTURA</th>
                                    <th>ACTUALIZAR</th>
                                    <th>PAGOS</th>
                                    <th>ELIMINAR</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr class="text-center" >
                                    <td>1</td>
                                    <td>NOMBRE CLIENTE</td>
                                    <td>2017/10/8</td>
                                    <td>2017/10/10</td>
                                    <td>Pendiente</td>
                                    <td>
                                        <a href="#" class="btn btn-info">
                                            <i class="fas fa-file-pdf"></i>	
                                        </a>
                                    </td>
                                    <td>
                                        <a href="reservation-update.html" class="btn btn-success">
                                            <i class="fas fa-sync-alt"></i>	
                                        </a>
                                    </td>
                                    <td>
                                        <a href="payment.html" class="btn btn-info">
                                            <i class="fas fa-dollar-sign"></i>	
                                        </a>
                                    </td>
                                    <td>
                                        <form action="">
                                            <button type="button" class="btn btn-warning">
                                                <i class="far fa-trash-alt"></i>
                                            </button>
                                        </form>
                                    </td>
                                </tr>
                                <tr class="text-center" >
                                    <td>2</td>
                                    <td>NOMBRE CLIENTE</td>
                                    <td>2017/10/8</td>
                                    <td>2017/10/10</td>
                                    <td>Finalizado</td>
                                    <td>
                                        <a href="#" class="btn btn-info">
                                            <i class="fas fa-file-pdf"></i>	
                                        </a>
                                    </td>
                                    <td>
                                        <a href="reservation-update.html" class="btn btn-success">
                                            <i class="fas fa-sync-alt"></i>	
                                        </a>
                                    </td>
                                    <td>
                                        <a href="payment.html" class="btn btn-info">
                                            <i class="fas fa-dollar-sign"></i>	
                                        </a>
                                    </td>
                                    <td>
                                        <form action="">
                                            <button type="button" class="btn btn-warning">
                                                <i class="far fa-trash-alt"></i>
                                            </button>
                                        </form>
                                    </td>
                                </tr>
                                <tr class="text-center" >
                                    <td>3</td>
                                    <td>NOMBRE CLIENTE</td>
                                    <td>2017/10/8</td>
                                    <td>2017/10/10</td>
                                    <td>Finalizado</td>
                                    <td>
                                        <a href="#" class="btn btn-info">
                                            <i class="fas fa-file-pdf"></i>	
                                        </a>
                                    </td>
                                    <td>
                                        <a href="reservation-update.html" class="btn btn-success">
                                            <i class="fas fa-sync-alt"></i>	
                                        </a>
                                    </td>
                                    <td>
                                        <a href="payment.html" class="btn btn-info">
                                            <i class="fas fa-dollar-sign"></i>	
                                        </a>
                                    </td>
                                    <td>
                                        <form action="">
                                            <button type="button" class="btn btn-warning">
                                                <i class="far fa-trash-alt"></i>
                                            </button>
                                        </form>
                                    </td>
                                </tr>
                                <tr class="text-center" >
                                    <td>4</td>
                                    <td>NOMBRE CLIENTE</td>
                                    <td>2017/10/8</td>
                                    <td>2017/10/10</td>
                                    <td>Pendiente</td>
                                    <td>
                                        <a href="#" class="btn btn-info">
                                            <i class="fas fa-file-pdf"></i>	
                                        </a>
                                    </td>
                                    <td>
                                        <a href="reservation-update.html" class="btn btn-success">
                                            <i class="fas fa-sync-alt"></i>	
                                        </a>
                                    </td>
                                    <td>
                                        <a href="payment.html" class="btn btn-info">
                                            <i class="fas fa-dollar-sign"></i>	
                                        </a>
                                    </td>
                                    <td>
                                        <form action="">
                                            <button type="button" class="btn btn-warning">
                                                <i class="far fa-trash-alt"></i>
                                            </button>
                                        </form>
                                    </td>
                                </tr>
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