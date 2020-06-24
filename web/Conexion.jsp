
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <%

            Connection cone = null;
            String urll = "jdbc:mysql://localhost:3306/loscaser_agricola?serverTimezone=EST5EDT";
            String userr = "root";
            String passs = "123456";

            try {
                Class.forName("com.mysql.jdbc.Driver");
                cone = (Connection) DriverManager.getConnection(urll, userr, passs);
                out.print("Conexion en Linea");
            } catch (Exception ex) {
                out.print("Error: " + ex.getMessage());
            }
        %>

    </body>
</html>
