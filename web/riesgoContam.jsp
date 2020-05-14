<%@page import="Modelo.RiesgoContam"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Control.Variables"%>
<html lang="es">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <title>Nuevo usuario</title>
        <link href="css/alertify.min.css" rel="stylesheet" type="text/css"/>
        <link href="css/default.min.css" rel="stylesheet" type="text/css"/>
        <script src="css/alertify.min.js" type="text/javascript"></script>
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
    </head>

    <%
        List<RiesgoContam> riesgo = (List<RiesgoContam>) request.getAttribute("lisRiesgo");
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
                <div class="full-box text-center">
                    <h1 style="color: #fff;"> EVALUACIÓN DE RIESGOS</h1>
                    <p >
                        De acuerdo con la descripción existe a los literales del 1 al 3, inserte el numero correspondiente en el recuadro del puntaje
                    </p>
                    <p id="error"></p>
                    <a href="Controlador?menu=Cultivo&accion=Listar" class="etiqueta4"> Regresar&nbsp; <i class="fas icon-back fa-fw etiqueta4"></i>  </a>
                </div>

                <!-- Content -->
                <div class="container-fluid" >
                    <form  name="formulario" action="Controlador?menu=Rcontaminacion"  class="form-neon"  method="POST" >
                        <div class="form-group">
                            <label for="item" class="bmd-label-floating">Riesgo de Contaminación</label>
                            <select class="form-control" name="opSelect" id="opRiesgo" required="required">
                                <option selected disabled>Seleccione una opcion</option>
                                <option value="CEstablecimiento">Cultivo en Establecimiento</option>
                                <option value="CProducion">Cultivo en Producción</option>
                            </select>
                        </div>
                        <div class="container-fluid">
                            <input type="hidden"   name="fk_cultivor"  value="<%=Variables.idCultivo%>">
                            <table class="table table-dark table-sm "style="font-size: 13px;">
                                <thead >
                                    <tr class="roboto-medium">
                                        <th>ITEM</th>
                                        <th >PUNTAJE</th>
                                        <th>DESCRIPCIÓN</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td class="tu">Tamaño de Cultivo</td>
                                        <td ><input type="number" name="n1" class="entrada" id="txtTamCultivo" onkeyup="CalcularTotal()" required> </td>
                                        <td>
                                            1)&nbsp;Pequeña(menor a 2 hectáreas)<br>
                                            2)&nbsp;Mediana (de 2 a 4 hertáreas)<br>
                                            3)&nbsp;Grande (Mayor a 4 Hectáreas)
                                        </td>
                                    </tr>
                                    <tr>
                                        <td> Tipo de cultivo</td>
                                        <td><input type="number" name="n2" class="entrada" id="txtTipCultivo" onkeyup="CalcularTotal()" required> </td>
                                        <td> 
                                            1)&nbsp;Uvillas + autoconsumo + barbecho<br>
                                            2)&nbsp;Uvilla +Maíz, Trigo, Arveja, Chochos, Quinoa<br>
                                            3)&nbsp;Solo Uvilla o barbecho
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>Tipo de aplicación</td>
                                        <td><input type="number" name="n3" class="entrada" id="txtTipAplicacion" onkeyup="CalcularTotal()" required> </td>
                                        <td>
                                            1)&nbsp;Tiene mochila manual<br>
                                            2)&nbsp;mochila mecánica o de motor<br>
                                            3)&nbsp;Fumigadora de tractor
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>Situación de los vecinos</td>
                                        <td><input type="number" name="n4" class="entrada" id="txtSitVecinos"onkeyup="CalcularTotal()"  required> </td>
                                        <td> 
                                            1)&nbsp;El vecino no representa riesgol<br>
                                            2) &nbsp;El vecino poco riesgol<br>
                                            3)&nbsp;El vecino representa muchos riesgos
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>Trayectoria agricola organica</td>
                                        <td><input type="number" name="n5" class="entrada" id="txtTrayAgricola"onkeyup="CalcularTotal()" required> </td>
                                        <td>
                                            1)&nbsp;Agricultor tradicional organica<br>
                                            2) &nbsp;Agricultor que maneja su cultivo de forma intensiva sin quimicos<br>
                                            3) &nbsp;Agricultor totalmente nuevo 
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>Potencial productivo</td>
                                        <td><input type="number" name="n6" class="entrada" id="txtPotProductivo"onkeyup="CalcularTotal()" required> </td>
                                        <td>
                                            1)&nbsp;1 a 5 kg/planta ciclo<br>
                                            2)&nbsp;5,1 a 10 kg/planta clico<br>
                                            3)&nbsp;>10 kg/planta ciclo
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>Recepcion de la fruta</td>
                                        <td><input type="number" name="n7" class="entrada" id="txtRecFruta" onkeyup="CalcularTotal()" required> </td>
                                        <td>
                                            1)&nbsp;siempre cumple con fruta de calidad<br>
                                            2) &nbsp;Ha representado problemas esporádicos<br>
                                            3)  &nbsp;Ha tenido quejas cosntantes
                                        </td>
                                    </tr>

                                </tbody>
                            </table>
                            <table class="table table-dark table-sm "style="font-size: 13px;">
                                <tbody>
                                    <tr>
                                        <td class="badge-dark"> PUNTUACIÓN</td>
                                        <td colspan=""><input type="number" id="total" name="total"  class="txte" readonly="" ></td>
                                        <td class="etiqueta4">espacioespacioespacioespacio</td>
                                    </tr>
                                    <tr>
                                        <td class="badge-success">OBSERVACIONES </td>
                                        <td colspan="2">
                                            <input name="txtObserv" id="Observ" class="txte"  readonly >
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="badge-secondary">TIPO RIESGO</td>
                                        <td colspan="2"><input class="txte" name="txtTipoRiesgo" type="text" id="tipoR"    >
                                        </td>
                                    </tr>
                                <tbody>
                            </table>
                        </div>
                        <p class="text-center">
                            <button id="btn4"  type="submit" name="accion" value="Agregar" class="btn btn-raised btn-info btn-sm"><i class="far fa-save"></i> &nbsp; GUARDAR</button>
                        </p>
                    </form>
                </div>
                <!-- ===================================================================================================== -->
                <!-- Content here-->
                <div class="container-fluid">
                    <div class="table-responsive">
                        <table class="table table-dark table-sm">
                            <thead>
                                <tr class="text-center roboto-medium">
                                    <th>Tipo</th>
                                    <th>Puntaje</th>
                                    <th>Observación</th>
                                    <th>Riesgo</th>
                                        <%if (session.getAttribute("tipo").equals("1")) {%>
                                    <th class="ac">Eliminar</th>
                                        <%} else {%>

                                    <%}%>
                                </tr>
                            </thead>

                            <tbody>
                                <%for (RiesgoContam r : riesgo) {%>
                                <tr class="text-center">

                                    <td><%=r.getSelecCultivo()%></td>
                                    <td><%=r.getTotal()%></td>
                                    <td><%=r.getObCultivo()%></td>
                                    <td>
                                        <% if (r.getTipoRiesgo().equals("Bajo")) { %>
                                        <h6 class="badge-success">Bajo</h6>
                                        <% } else if (r.getTipoRiesgo().equals("Medio")) { %>
                                        <h6 class="badge-warning">Medio</h6>
                                        <%} else { %>
                                        <h6 class="badge-danger">Alto</h6>
                                        <%}%>
                                    </td>
                                    <%if (session.getAttribute("tipo").equals("1")) {%>
                                    <td class="btnLis"><a title="Eliminar Registro"   class="btn btn-raised btn-danger btn-sm " href="Controlador?menu=RContaminacion&accion=Eliminar&pk_riesgoContam=<%=r.getPk_riesgoContam()%>">
                                            <i class="far fa-trash-alt"></i></a>
                                    </td>
                                    <%} else {%>

                                    <%}%>
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
        <script src="js/codigo.js" type="text/javascript"></script>
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
                                            });
        </script>
        <script src="./js/main.js" ></script>
        <script src="js/Riesgo.js" type="text/javascript"></script>

    </body>
</html>