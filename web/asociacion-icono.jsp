<%@page import="Modelo.Asociacion"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">

        <title>JSP Page</title>
       
        <link href="assets/bootstrap.min.css" rel="stylesheet" type="text/css"/>
      
    </head>
    <style>
        .cont{
            width: 100px;
            padding: 50px;
            margin-left: 50px;
            margin-top: 50px;
        }
        .cont-datos{
            display: flex;
        }
        .contenedor-lista-hab{
            width: 100px;
            height: 120px;
            background: chartreuse;
            margin-left: 50px;
        }
       
    </style>
    <%List<Asociacion> asociacion = (List<Asociacion>) request.getAttribute("asocia");%>
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

                <div class="cont">
                    <table>
                        <tr>
                        <div style="text-align: center">
                            <span class="badge-info" style="padding: 25px;font-size: 15px;border-radius: 5px;">LISTADO DE ASOCIACIONES</span> <br/><br/><br/>
                        </div>
                        </tr>    
                        <tr>
                            <%  int salto = 0;
                                for (Asociacion asoTemporal : asociacion) {
                            %>
                            <td>
                                <%if (asoTemporal.getFk_provinciaa().equals("1")) {%>
                                <div class="p-3 mb-2 bg-success text-white contenedor-lista-hab" onclick="window.location.href = 'ControladorHabitacion'" style="cursor: pointer;" title="Lista De Asociaciones">
                                    <%} else if (asoTemporal.getFk_provinciaa().equals("2")) {%>
                                    <div class="p-3 mb-2 bg-info text-white contenedor-lista-hab" onclick="window.location.href = 'ControladorHabitacion'" style="cursor: pointer;" title="Lista De Asociaciones">
                                        <%} else if (asoTemporal.getFk_provinciaa().equals("3")) {%>
                                        <div class="p-3 mb-2 bg-danger text-white contenedor-lista-hab" onclick="window.location.href = 'ControladorHabitacion'" style="cursor: pointer;" title="Lista De Asociaciones">
                                            <%} else if (asoTemporal.getFk_provinciaa().equals("4")) {%> 
                                            <div class="p-3 mb-2 bg-warning text-white contenedor-lista-hab" onclick="window.location.href = 'ControladorHabitacion'" style="cursor: pointer;"title="Lista De Asociaciones">
                                                <%}%>        
                                                <div class="cont-datos">
                                                    <div class="estado">
                                                        <%if (asoTemporal.getFk_provinciaa().equals("1")) {%>
                                                        Disponible
                                                        <%} else if (asoTemporal.getFk_provinciaa().equals("2")) {%>
                                                        Limpieza
                                                        <%} else if (asoTemporal.getFk_provinciaa().equals("3")) {%>    
                                                        Ocupada
                                                        <%} else if (asoTemporal.getFk_provinciaa().equals("4")) {%> 
                                                        Mantenimiento
                                                        <%}%>    
                                                    </div>
                                                    <div class="icon-">
                                                        <%if (asoTemporal.getFk_provinciaa().equals("1")) {%>
                                                        <i class="fas fa-arrow-circle-right"></i>
                                                        <%} else if (asoTemporal.getFk_provinciaa().equals("2")) {%>
                                                        <i class="fas fa-broom"></i>
                                                        <%} else if (asoTemporal.getFk_provinciaa().equals("3")) {%>        
                                                        <i class="fas fa-ban"></i>
                                                        <%} else if (asoTemporal.getFk_provinciaa().equals("4")) {%> 
                                                        <i class="fas fa-person-booth"></i>
                                                        <%}%>
                                                    </div>
                                                </div>
                                                <hr style="background: white;">
                                                <div class="icon-hab">
                                                    <i class="fas fa-bed" style="font-size: 25px;margin-left: 25px;"></i><span style="font-size: 25px;margin-left: 15px;"><%=asoTemporal.getFk_provinciaa()%></span>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div><br>
                            </td>
                            <%
                                salto++;
                                if (salto == 4) {
                            %>
                        </tr>
                        <tr>
                            <%salto = 0;
                                    }
                                }
                            %>
                        </tr>
                    </table>
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