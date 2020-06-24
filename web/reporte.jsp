<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.io.*"%>
<%@page import="java.util.*"%>

<%@page import="net.sf.jasperreports.engine.*"%>
<%@page import="net.sf.jasperreports.view.JasperViewer"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="javax.servlet.ServletResponse"%>
<%@include file="Conexion.jsp" %>
<%@include file="Vista.html" %>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <%       
            
            
            
            /*Establecemos la ruta del reporte*/
            File reportFile = new File(application.getRealPath("reporte/report2.jasper"));
            /* No enviamos parámetros porque nuestro reporte no los necesita asi que escriba 
            cualquier cadena de texto ya que solo seguiremos el formato del método runReportToPdf*/
            Map parameters = new HashMap();
            //parameters.put("Id_Historial", "18");
            out.println(reportFile.getPath());
            /*Enviamos la ruta del reporte, los parámetros y la conexión(objeto Connection)*/
            try {
                byte[] bytes = JasperRunManager.runReportToPdf(reportFile.getPath(), parameters, cone);
                /*Indicamos que la respuesta va a ser en formato PDF*/
                response.setContentType("application/pdf");
                response.setContentLength(bytes.length);
                ServletOutputStream ouputStream = response.getOutputStream();
                ouputStream.write(bytes, 0, bytes.length);
                /*Limpiamos y cerramos flujos de salida*/ ouputStream.flush();
                ouputStream.flush();
                ouputStream.close();

            } catch (NumberFormatException ex) {//El bloque catch indica el error que captura.
                out.println(ex.getMessage());
            }
        %>

    </body>
</html>
