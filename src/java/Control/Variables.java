package Control;

import javax.servlet.http.HttpServlet;

public class Variables extends HttpServlet {

    public static int panPrincipal = 0;

    public static int idAgricultor = 0;
    public static int idLote = 0;
    public static int idVisitas = 0;
    public static int idCultivo = 0;

    public static String agriApellido = ""; //variable global agricultor  Apellido
    public static String agriNombre = "";//variable global agricultor  Nombre

    public static String emplUsuario = ""; //variable global empleado  Usuario

// protected void doPost(HttpServletRequest request, HttpServletResponse response)
    //        throws ServletException, IOException {
    // HttpSession ok= request.getSession();
    //globalID = Integer.parseInt(ok.getAttribute("id").toString());
    //globalNombre = ok.getAttribute("nombre").toString();
    //globalApellido = ok.getAttribute("apellido").toString();
    //  }
}
