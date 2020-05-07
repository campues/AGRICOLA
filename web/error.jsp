<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error</title>
        <link href="css/error.css" rel="stylesheet" type="text/css"/>
    </head>

    <body>
        <br><br><br>
        <div class="contenedor">
            <p>  Se ha producido el siguiente error: <%=request.getAttribute("error")%></p>
            <br>  
            <input type="submit" value="Regresar" onclick="window.location.href = 'Controlador?menu=Inicio'" />
        </div>

    </body>
</html>
