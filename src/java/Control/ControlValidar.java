package Control;

import Modelo.Empleado;
import ModeloDao.EmpleadoDao;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.PageContext;

@WebServlet("/ControlValidar")
public class ControlValidar extends HttpServlet {

    Variables global = new Variables(); //Clase de variables globales
    private static final long serialVersionUID = 1L;
    EmpleadoDao edao;
    Empleado em = new Empleado();

    public void init() {
        String jdbcURL = getServletContext().getInitParameter("jdbcURL");
        String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
        String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
        try {
            edao = new EmpleadoDao(jdbcURL, jdbcUsername, jdbcPassword);

        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public ControlValidar() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if (accion.equals("Ingresar")) {
            try {
                String user = request.getParameter("txtuser");
                String pass = request.getParameter("txtpass");
                em = edao.validar(user, pass);
                if (em.getUsuario() != null) {
                    HttpSession sesionOK = request.getSession();
                    sesionOK.setAttribute("nom", em.getNombre());
                    sesionOK.setAttribute("ape", em.getApellido());
                    sesionOK.setAttribute("usu", em.getUsuario());
                    sesionOK.setAttribute("pass", em.getContrasena());
                    sesionOK.setAttribute("tipo", em.getTipo());
                    global.emplUsuario = em.getTipo();
                    request.getRequestDispatcher("Controlador?menu=Inicio").forward(request, response);
                }
            } catch (Exception e) {
                RequestDispatcher res = request.getRequestDispatcher("index.jsp");
                request.setAttribute("mensaje", "Usuario/Contraseña Incorrecta");
                res.forward(request, response);
            }
        }

    }

}
