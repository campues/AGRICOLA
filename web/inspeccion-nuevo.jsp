<%@page import="Control.Variables"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <title>Agregar Inspeccion</title>
        < <link href="css/alertify.min.css" rel="stylesheet" type="text/css"/>
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
                <!--================Encabezado de página ======================-->
                <div class="page-header">
                    <h3 class="text-danger">
                       INSPECCION
                    </h3>
                    <p class="text-justify">
                        <i class="fas fa-plus fa-fw"></i> &nbsp;  LOTE:<%=Variables.idLote%> <br>
                        Ingresa nueva inspeccion de lote
                    </p>
                </div>
                <div class="container-fluid">
                    <ul class="full-box list-unstyled page-nav-tabs">
                        <li>
                            <a class="active" href="lote-nuevo.jsp"><i class="fas fa-plus fa-fw"></i> &nbsp; AGREGAR INSPECCION</a>
                        </li>
                        <li>
                            <a   href="Controlador?menu=Visitas&accion=Listar"><i class="fas fa-clipboard-list fa-fw"></i> &nbsp; LISTA DE INSPECCION</a>
                        </li>
                        <li>
                            <a href="#"><i class="fas fa-search fa-fw"></i> &nbsp; BUSCAR INSPECCION</a>
                        </li>
                    </ul>
                </div>

                <!--======================CONTENIDO==========================00-->
                <div class="container-fluid">
                    <form action="Controlador?menu=Visitas"  class="form-neon" method="POST" >
                        <fieldset>
                            <legend><i class="far fa-plus-square"></i> &nbsp; Datos de la inspección</legend>
                            <input type="hidden"  class="" name="fkLote"   value="<%=Variables.idLote%>" id="item_codigo" readonly="readonly" >
                            <div class="container-fluid">
                                <div class="row">
                                    <div class="col-12 col-md-3">
                                        <div class="form-group">
                                            <label for="item" class="etiqueta">Tipo de Inspeccion<label style="color: red">*</label></label>
                                            <select class="form-control" name="opInspeccion" id="item" required>
                                                <option value="" selected="" disabled="">Seleccione una opción</option>
                                                <option  value="VISITA NUEVA">VISITA NUEVA (RDA-0302)</option>
                                                <option value="VISITA SCI">VISITA SCI (RDA-0103)</option>
                                            </select>
                                        </div>
                                    </div>
                                    <div class=col-md-2">
                                        <div class="form-group">
                                            <label  class="etiqueta">Fecha</label>
                                            <input type="date"  class="form-control" name="txtFecha"  >
                                        </div>
                                    </div>

                                    <div class="col-md-3">
                                        <div class="form-group">
                                            <label class="bmd-label-floating">Informante</label>
                                            <input title="Nombre del informante"  type="text"  class="form-control" name="txtInformante"  >
                                        </div>
                                    </div>
                                    <div class="col-12 col-md-3">
                                        <div class="form-group">
                                            <label for="item" class="etiqueta">Parentesco</label>
                                            <select class="form-control" name="opParentesco" >
                                                <option value="" selected="" disabled="">Seleccione una opcion</option>
                                                <option value="Hijo">Hijo</option>
                                                <option value="Nieto">Nieto</option>
                                                <option value="Sobrino">Sobrino</option>
                                                <option value="Tia">Tia</option>
                                                <option value="Abuelo/a">Abuelo</option>
                                                <option value="Otro">Otro</option>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="col-12 col-md-3">
                                        <div class="form-group">
                                            <label for="item" class="etiqueta">Tipo de Auditoria<label style="color: red">*</label></label>
                                            <select class="form-control" name="opAuditoria" >
                                                <option value="" selected="" disabled="">Seleccione una opción</option>
                                                <option  value="Normal">Normal</option>
                                                <option value="Extraordinaria">Extraordinaria</option>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="col-12 col-md-3">
                                        <div class="form-group">
                                            <label for="item" class="bmd-label-floating">Empleado<label style="color: red">*</label></label>
                                            <select class="form-control" name="fkEmpleado" id="item" required>
                                                <option value="" selected="" disabled="">Seleccione Empleado</option>
                                                <c:forEach var="em" items="${lisEmplea}">
                                                    <option value="${em.pk_empleado}">${em.nombre}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                    </div> 
                                </div>
                            </div>
                        </fieldset>
                        <br>
                        <fieldset>

                            <legend><i class="fas fa-file-pdf fa-fw"></i> &nbsp; Documentación</legend>

                            <div class="row fondo">

                                <div class="col-md-5">
                                    <label class="etiqueta">Contrato de Compromiso A 19-01-1</label> 
                                    <input type="checkbox"  value="SI"  name="checContrato" >
                                </div>
                                <div class="col-md-5">
                                    <label class="etiqueta">Normas de Producción Organica A 19-01-4</label>
                                    <input type="checkbox"  value="SI"  name="checNormas" >
                                </div>
                                <div class="col-md-5">
                                    <label  class="etiqueta">Reglamento de control internoA 19-01-3</label>
                                    <input type="checkbox"  value="SI"  name="checReglamento" >
                                </div>
                                <div class="col-md-5">
                                    <label class="etiqueta">Elaboración de estractos, bocashi N/A</label>
                                    <input type="checkbox"  value="SI"  name="checElaboracion">
                                </div>
                                <div class="col-md-5">
                                    <label class="etiqueta">Protodolo de cultivo orgánico de uvillas N/A</label>
                                    <input type="checkbox"  value="SI"  name="checProtocolo">
                                </div>
                                <div class="col-md-5">
                                    <label class="etiqueta">Cosecha y Poscosecha N/A</label>
                                    <input type="checkbox"  value="SI"  name="checCosecha">
                                </div>
                            </div>
                            <div class="row ">
                                <div class="col-md-5">
                                    <div class="form-group">
                                        <label for="item" class="bmd-label-floating">Observaciones Detectadas</label>
                                        <input type="text" class="form-control" name="txtObserv" id="item" >
                                    </div>
                                </div>
                                <div class="col-md-5">
                                    <div class="form-group">
                                        <label for="item" class="bmd-label-floating">Acciones Correctivas</label>
                                        <input type="text" class="form-control" name="txtAcciones"  id="item" >
                                    </div>
                                </div>
                            </div>
                        </fieldset>
                        <fieldset >
                            <legend><i class="fas fa-file-pdf fa-fw"></i> &nbsp; Riesgo de Contaminación<label style="color: red">*</label></legend>

                            <div class="container-fluid">
                                <select class="form-control" name="opSelect" id="opRiesgo" required>
                                    <option selected disabled>Seleccione una opcion</option>
                                    <option value="CEstablecimiento">Cultivo en Establecimiento</option>
                                    <option value="CProducion">Cultivo en Producción</option>
                                </select>
                                <br> 
                                <table   class="table table-dark table-sm  "style="font-size: 13px;">
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
                                                <input name="txtObservCul"  class="txte"   id="obCultivoo" >
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
                            <div class="col-md-4">
                                <div class="form-group">
                                    <label  class="etiqueta">Aprueba Certificacion</label>
                                    <label class="etiqueta">SI</label> <input  type="radio" name="checCertf" value="SI" required="">&nbsp;
                                    <label class="etiqueta">NO</label><input type="radio" name="checCertf" value="NO" required="">
                                </div>
                            </div>
                        </fieldset>
                        <p class="text-center" style="margin-top: 40px;">
                            <button type="reset" class="btn btn-raised btn-secondary btn-sm"><i class="fas fa-paint-roller"></i> &nbsp; LIMPIAR</button>
                            &nbsp; &nbsp;
                            <button type="submit" class="btn btn-raised btn-info btn-sm" name="accion" value="Agregar"><i class="far fa-save"></i> &nbsp; AGREGAR</button>
                        </p>
                    </form>
                </div>
            </section>
        </main>
        <!--=============================================
        =            Include JavaScript files           =
        ==============================================-->
        <script src="js/codigo.js" type="text/javascript"></script>
        <!-- jQuery V3.4.1 -->
        <script src="js/permisos.js" type="text/javascript"></script>

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
        <script src="js/Riesgo.js" type="text/javascript"></script>
    </body>
</html>