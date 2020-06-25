<%@page import="Modelo.Lote"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="Control.Variables"%>

<!DOCTYPE html>
<html lang="es">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <title>Datos de la empresa</title>
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
                </div>
                <%
                    Lote lot = (Lote) request.getAttribute("lot");
                %>
                <!--======================CONTENIDO==========================00-->
                <div class="container-fluid">
                    <form action="Controlador?menu=Lote"  id="registro" class="form-neon" method="POST"  >
                        <fieldset>
                            <legend><i class="fas icon-edit"></i> &nbsp; Verifica los datos antes de guardar</legend>
                            <input type="hidden"  name="pk" class="form-control"  value="${lot.pk_lote}">
                            <input type="hidden"  name="fkAgricultor" class="form-control"  value="${lot.fk_agricultorl}">
                            <div class="container-fluid">
                                <a href="#" title="Obtener Cordenas para el registro de la Ubicación Geografica" id="pedirvan" class="btn-raised btn-danger" > <i class="icon-location-pin"></i></a> 
                                &nbsp;&nbsp;
                                <label style="color: black"  id="nlat" ></label>/
                                <label  style="color: black"  id="nlon" ></label>
                                <div class="row">
                                    <div class=col-md-3">
                                        <div class="form-group">
                                            <label class="bmd-label-floating">Geolocalización</label>
                                            <input type="text"  title="Latitud/Longitud -> 0.0440903/-78.142985" class="form-control" name="txtUbi" id="txtUbi"   value="${lot.ubi_Geografica}"> >
                                        </div>
                                    </div>

                                    <div class="col-md-2">
                                        <div class="form-group">
                                            <label class="bmd-label-floating">Altura</label>
                                            <input type="text"  class="form-control" name="txtAlt"  value="${lot.altura}" >
                                        </div>
                                    </div>
                                    <div class="col-md-2">
                                        <div class="form-group">
                                            <label  class="bmd-label-floating">Codigo</label>
                                            <input type="text" readonly class="form-control" name="txtCod"  value="${lot.cod}"  >

                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <label for="item" class="bmd-label-floating">Provincia</label>
                                            <select class="form-control" name="opProvincia" id="item">
                                                <option value="" selected="" disabled="">Seleccione una opcion</option>
                                                <c:forEach var="p" items="${lisPro}" >
                                                    <option value="${p.pk_provincia}"
                                                            <c:if test="${p.pk_provincia == lot.getFk_provincia()}">
                                                                selected
                                                            </c:if>
                                                            >${p.nomProvincia}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="col-md-3">
                                        <div class="form-group">
                                            <label  class="bmd-label-floating">Parroquia</label>
                                            <input type="text" class="form-control" name="txtPar" value="${lot.parroquia}"  >
                                        </div>
                                    </div>
                                    <div class="col-12 col-md-6">
                                        <div class="form-group">
                                            <label for="item" class="bmd-label-floating">Asociacion</label>
                                            <select class="form-control" name="selectAso" id="item">
                                                <option value="" selected="" disabled="">Seleccione una opcion</option>
                                                <c:forEach var="a" items="${lisAso}" >
                                                    <option value="${a.pk_asociacion}"
                                                            <c:if test="${a.pk_asociacion == lot.getFk_asociacion()}">
                                                                selected
                                                            </c:if>
                                                            >${a.nomAsociacion}</option>
                                                </c:forEach>
                                            </select>
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
                                        <input type="checkbox"  value="SI"  name="checBanio" 
                                               <%if (lot.getBanio() == null) {%> <%} else {%>checked="checked"<%}%>>
                                        <label class="etiqueta">Agua potable</label>
                                        <input type="checkbox"  value="SI"  name="checAguaP"
                                               <%if (lot.getAgua_potable() == null) {%> <%} else {%>checked="checked"<%}%>>
                                        <label  class="etiqueta">Luz Electrica</label>
                                        <input type="checkbox"  value="SI"  name="checLuzE"
                                               <%if (lot.getLuz_electrica() == null) {%> <%} else {%>checked="checked"<%}%>>
                                        <label class="etiqueta">Agua Riego</label>
                                        <input type="checkbox"  value="SI"  name="checAguaR" 
                                               <%if (lot.getAgua_riego() == null) {%> <%} else {%>checked="checked"<%}%>>
                                    </div>
                                    <br><br>
                                    <!--=========================Infraestructura======================-->
                                    <div class="col-md-6">
                                        <label class="etiqueta">Bodega</label>
                                        <input type="checkbox"   value="SI"  name="checBodega" >
                                        <input type="text" class="texto"    name="txtObBodega" placeholder="Describe alguna observacion" value="${lot.ob_bodega}">
                                    </div>
                                    <div class="col-md-6">
                                        <label class="etiqueta">Poscosecha</label>
                                        <input type="checkbox"   value="SI"  name="checPoscosecha" >
                                        <input type="text" class="texto"      name="txtOb_poscosecha"  placeholder="Alguna Observacion" value="${lot.ob_poscosecha}">
                                    </div>
                                    <br><br>
                                    <div class="col-md-6">
                                        <label for="" class="etiqueta">Capacitacion</label>
                                        <input type="checkbox" value="SI"  name="checCapacitacion" >
                                        <input type="text" class="texto"   name="txtObCapacitacion" placeholder="Describe alguna observacion" value="${lot.ob_capacitacion}">
                                    </div>
                                    <div class="col-md-6">
                                        <label for="" class="etiqueta"> Medio de Trasporte</label>
                                        <input type="checkbox"  value="SI"  name="checTransp">
                                        <input type="text" class="texto"   name="txtObTransporte" placeholder="Describe alguna observacion" value="${lot.ob_transporte}">
                                    </div>

                                    <div class="col-md-5">
                                        <div class="form-group">
                                            <label class="bmd-label-floating">Incorporacion de maleza propia del terreno</label>
                                            <input type="text"  class="form-control" name="txtInserAbono"  value="${lot.inc_abono}">
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <label class="bmd-label-floating">Riesgo de erosión y sus respectivas medidas de prevencion:Lanza minima</label>
                                            <input type="text"  class="form-control" name="txtRiegoE" value="${lot.riesgo_erosion}" >
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
                                        <input type="checkbox"  value="SI"  name="checUsopp" 
                                               <%if (lot.getUsopp() == null) {%> <%} else {%>checked="checked"<%}%>>
                                        <label class="etiqueta">Endose Produccion</label>
                                        <input type="checkbox"  value="SI"  name="checEnpro" 
                                               <%if (lot.getEn_prdoduc() == null) {%> <%} else {%>checked="checked"<%}%>>
                                        <label  class="etiqueta">Contaminacion Lateral</label>
                                        <input type="checkbox"  value="SI"  name="checContLateral"
                                               <%if (lot.getCont_lateral() == null) {%> <%} else {%>checked="checked"<%}%>>
                                        <label class="etiqueta">Agua procesamiento</label>
                                        <input type="checkbox"  value="SI"  name="checAguaPro"
                                               <%if (lot.getAgua_procesamiento() == null) {%> <%} else {%>checked="checked"<%}%>>
                                    </div>
                                    <div class="col-md-7">
                                        <div class="form-group">
                                            <label class="bmd-label-floating">Breve descripción del sistema y comentarios adicionales</label>
                                            <input type="text"  class="form-control" name="txtDesProduccion"  value="${lot.des_produccion}" >
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </fieldset>
                        <p class="text-center" >
                            <button   type="submit" name="accion" value="Actualizar" class="btn btn-raised btn-success btn-sm"> ACTUALIZAR</button>
                            <button   type="submit" name="accion" value="Listar" class="btn btn-raised btn-danger btn-sm"> CANCELAR</button>
                        </p>
                    </form>
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