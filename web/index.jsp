
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    if (request.getParameter("cerrar") != null) {
        session.invalidate();
    }
%>
<html lang="es">
    <head>
        <meta charset="UTF-8">
          <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Login</title>
         <link rel="stylesheet" href="css/stylo-login.css">
    </head>
    <body>
        <div class="login-box" >
            <img src="assets/img/user.png" class="avatar" alt="Avatar Image">
            <h1>Iniciar Sesion</h1>
            <form action="ControlValidar" method="POST">
                <!-- ENTRADA DE NOMBRE DE USUARIO -->
                <label for="username">USUARIO</label>
                <input type="text" placeholder="&#128269;Ingresa el Usuario" required="" name="txtuser" value="${requestScope.txtuser}" />
                <!--  ENTRADA DE NOMBRE DE CONTRASEÑA -->
                <label for="password">CONTRASEÑA</label>
                <input type="password"  placeholder="&#128274;Ingresa tu Contraseña" required="" name="txtpass"  value="${requestScope.txtpass}"/>
                <input   type="submit" name="accion" value="Ingresar"  > 
                <p>${requestScope.mensaje}</p>
            </form>
        </div>

    </body>
</html>
 <script src="js/permisos.js" type="text/javascript"></script>