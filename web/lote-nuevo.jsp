<%@page import="Control.Variables"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <title>Nuevo lote</title>

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
                <!--================Encabezado de página ======================-->
                <div class="page-header">
                    <h3 class="text-danger">
                        AGRICULTOR:
                        <%=Variables.agriNombre%>  &nbsp; <%=Variables.agriApellido%> &nbsp;
                        ID LOTE:<%=Variables.idLote%>
                    </h3>
                    <p class="text-justify">
                        <i class="fas fa-plus fa-fw"></i> &nbsp; AGREGAR LOTE <br>
                        Ingresa un nuevo lote
                    </p>
                </div>
                <div class="container-fluid">
                    <ul class="full-box list-unstyled page-nav-tabs">
                        <li>
                            <a class="active" href="lote-nuevo.jsp"><i class="fas fa-plus fa-fw"></i> &nbsp; AGREGAR LOTE</a>
                        </li>
                        <li>
                            <a   href="Controlador?menu=Lote&accion=Listar"><i class="fas fa-clipboard-list fa-fw"></i> &nbsp; LISTA DE LOTES</a>
                        </li>

                    </ul>
                </div>

                <!--======================CONTENIDO==========================00-->
                <div class="container-fluid">
                    <form action="Controlador?menu=Lote"  class="form-neon" method="POST" enctype="multipart/form-data" >
                        <fieldset>
                            <legend><i class="far fa-plus-square"></i> &nbsp; Informacion del lote</legend>
                            <input type="hidden"  class="" name="fkAgricultor"   value="<%=Variables.idAgricultor%>" id="item_codigo" readonly="readonly" >
                            <div class="container-fluid">
                                <div class="row">

                                    <div class=col-md-2">
                                        <div class="form-group">
                                            <label  class="bmd-label-floating">Ubicacion Geografica</label>
                                            <input type="text"  class="form-control" name="txtUbi"  >
                                        </div>
                                    </div>

                                    <div class="col-md-2">
                                        <div class="form-group">
                                            <label class="bmd-label-floating">Altura</label>
                                            <input type="text"  class="form-control" name="txtAlt"  >
                                        </div>
                                    </div>
                                    <div class="col-md-2">
                                        <div class="form-group">
                                            <label  class="bmd-label-floating">Codigo</label>
                                            <input type="text" class="form-control" name="txtCod"  >
                                        </div>
                                    </div>

                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <label for="item" class="bmd-label-floating">Provincia</label>
                                            <select class="form-control" name="opProvincia" id="item">
                                                <option value="" selected="" disabled="">Seleccione una opcion</option>
                                                <c:forEach var="p" items="${lisPro}" >
                                                    <option value="${p.pk_provincia}"
                                                            <c:if test="${p.pk_provincia == asoc.getFk_provinciaa()}">
                                                                selected
                                                            </c:if>
                                                            >${p.nomProvincia}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <label  class="bmd-label-floating">Parroquia</label>
                                            <input type="text" class="form-control" name="txtPar">
                                        </div>
                                    </div>
                                    <div class="col-12 col-md-6">
                                        <div class="form-group">
                                            <label for="item" class="bmd-label-floating">Asociacion</label>
                                            <select class="form-control" name="selectAso" id="item">
                                                <option value="" selected="" disabled="">Seleccione una opcion</option>
                                                <c:forEach var="a" items="${lisAso}" >
                                                    <option value="${a.pk_asociacion}">${a.nomAsociacion}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                    </div>

                                    <div class="col-md-3">
                                        <div class="form-group">
                                            <label for="" class="etiqueta">Certificado:</label>
                                            <label style="color: #020202;">SI</label> <input  type="radio" name="txtCertificado" value="SI" required="">&nbsp;
                                            <label style="color: #020202;">NO</label><input type="radio" name="txtCertificado" value="NO" required="">
                                        </div>

                                    </div>

                                    <div class="col-12 col-md-4">
                                        <div class="form-group">
                                            <label for="item" class="bmd-label-floating">Observaciones</label>
                                            <input type="text" class="form-control" name="txtObserv" id="item" >
                                        </div>
                                    </div>
                                    <div class="col-12 col-md-4">
                                        <div class="form-group">
                                            <label for="item" class="bmd-label-floating">Recomendaciones</label>
                                            <input type="text" class="form-control" name="txtRecom"  id="item" >
                                        </div>
                                    </div>

                                </div>
                            </div>
                        </fieldset>

                        <!-- ===================================================================================================== -->

                        <fieldset>
                            <legend><i class="fas fa-store-alt fa-fw"></i> &nbsp; Infraestructura que posee la unidad productiva(Servicios Basicos)</legend>
                            <div class="container-fluid">
                                <div class="row">
                                    <div class="col-md-7">
                                        <label class="etiqueta">Baño</label>
                                        <input type="checkbox"  value="SI"  name="checBanio" >
                                        <label class="etiqueta">Agua potable</label>
                                        <input type="checkbox"  value="SI"  name="checAguaP" >
                                        <label  class="etiqueta">Luz Electrica</label>
                                        <input type="checkbox"  value="SI"  name="checLuzE" >
                                        <label class="etiqueta">Agua Riego</label>
                                        <input type="checkbox"  value="SI"  name="checAguaR">
                                    </div>
                                    <br><br>
                                    <!--=========================Infraestructura======================-->
                                    <div class="col-md-6">
                                        <label class="etiqueta">Bodega</label>
                                        <input type="checkbox"   value="SI"  id="boton" name="checBodega" >
                                        <input type="text" class="texto"   id="caja" name="txtObBodega" placeholder="Describe alguna observacion">
                                    </div>
                                    <div class="col-md-6">
                                        <label class="etiqueta">Poscosecha</label>
                                        <input type="checkbox"   value="SI"  name="checPoscosecha" >
                                        <input type="text" class="texto"   id="cajaa"   name="txtOb_poscosecha"  placeholder="Alguna Observacion" >
                                    </div>
                                    <br><br>
                                    <div class="col-md-6">
                                        <label for="" class="etiqueta">Capacitacion</label>
                                        <input type="checkbox" value="SI"  name="checCapacitacion" >
                                        <input type="text" class="texto"   id="caja" name="txtObCapacitacion" placeholder="Describe alguna observacion">
                                    </div>
                                    <div class="col-md-6">
                                        <label for="" class="etiqueta"> Medio de Trasporte</label>
                                        <input type="checkbox"  value="SI"  name="checTransp">
                                        <input type="text" class="texto"   id="caja" name="txtObTransporte" placeholder="Describe alguna observacion">
                                    </div>

                                    <div class="col-md-5">
                                        <div class="form-group">
                                            <label class="bmd-label-floating">Incorporacion de maleza propia del terreno</label>
                                            <input type="text"  class="form-control" name="txtInserAbono"  >
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <label class="bmd-label-floating">Riesgo de erosión y sus respectivas medidas de prevencion:Lanza minima</label>
                                            <input type="text"  class="form-control" name="txtRiegoE"  >
                                        </div>
                                    </div>
                                    <div class="col-12 col-md-6">
                                        <div class="form-group">
                                            <label for="item" class="bmd-label-floating">Documentación Disponible (Registro del lote)</label>
                                            <select class="form-control" name="opRegistro" id="item">
                                                <option value="" selected="" disabled="">Seleccione una opcion</option>
                                                <option value="SI">SI</option>
                                                <option value="NO">NO</option>
                                                <option value="NO">LIBRETA</option>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="col-md-9">
                                        <label class="etiqueta">Uso PP</label>
                                        <input type="checkbox"  value="SI"  name="checUsopp" >
                                        <label class="etiqueta">Endose Produccion</label>
                                        <input type="checkbox"  value="SI"  name="checEnpro" >
                                        <label  class="etiqueta">Contaminacion Lateral</label>
                                        <input type="checkbox"  value="SI"  name="checContLateral" >
                                        <label class="etiqueta">Agua procesamiento</label>
                                        <input type="checkbox"  value="SI"  name="checAguaPro">
                                    </div>
                                    <div class="col-md-7">
                                        <div class="form-group">
                                            <label class="bmd-label-floating">Breve descripción del sistema y comentarios adicionales</label>
                                            <input type="text"  class="form-control" name="txtDesProduccion"  >
                                        </div>
                                    </div>
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
    </body>
</html>