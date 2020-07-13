package Control;

import Modelo.Agricultor;
import Modelo.Archivo;
import ModeloDao.AgricultorDao;
import ModeloDao.ArchivoDao;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

//@MultipartConfig //LINE DE CODIGO PARA AGREGAR IMAGENES
public class Control extends HttpServlet {

    AgricultorDao agricultorDAO;
    ArchivoDao archivoDao;

    Archivo archivo = new Archivo();
    Agricultor ag = new Agricultor();

    public void init() {
        String jdbcURL = getServletContext().getInitParameter("jdbcURL");
        String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
        String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
        try {
            agricultorDAO = new AgricultorDao(jdbcURL, jdbcUsername, jdbcPassword);
            archivoDao = new ArchivoDao(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (Exception e) {

        }
    }

    public Control() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        // ==============================DOCUMENTOS AGRICULTOR===========================================================
        try {
            switch (accion) {
                case "Listar":
                    RequestDispatcher diste = request.getRequestDispatcher("archivo.jsp");
                    List<Archivo> ar = archivoDao.listarArchivoID();
                    request.setAttribute("arch", ar);
                    diste.forward(request, response);
                    break;
                case "Agregar":
                    ArrayList<String> lista = new ArrayList<>();
                    FileItemFactory file = new DiskFileItemFactory();
                    ServletFileUpload fileUpload = new ServletFileUpload(file);
                    List items = fileUpload.parseRequest(request); //Captura todo los datos del formulario
                    for (int i = 0; i < items.size(); i++) {
                        FileItem fileItem = (FileItem) items.get(i);
                        
                        if (!fileItem.isFormField()) {
                            File f = new File("appservers/apache-tomcat-8.0.48/webapps/Anexos/" + fileItem.getFieldName());
                            //File f = new File("C://apache-tomcat-8.5.57/webapps/Anexos/" + fileItem.getName());
                            fileItem.write(f);
                            archivo.setRuta("http://loscaseritos.com:10626/Anexos/" + fileItem.getName());
                            //archivo.setRuta("http://localhost:8080/Anexos/" + fileItem.getName());
                        } else {
                            lista.add(fileItem.getString()); //Recorre los campos 
                        }
                    }
                    archivo.setFk_agricultord(lista.get(0));
                    archivo.setNomArchivo(lista.get(1));
                    archivo.setTipo(lista.get(2));

                    archivoDao.insertarArchivo(archivo);
                    request.getRequestDispatcher("Control?accion=Listar").forward(request, response);
                    break;
                case "Eliminar":
                    File f = null;
                    archivo = archivoDao.obtenerPorId(Integer.parseInt(request.getParameter("pk_archivo")));
                    String nombre = archivo.getRuta().split("/")[4];
                    f = new File("/home/loscaser/appservers/apache-tomcat-8.0.48/webapps/Anexos/" + nombre);
                    // f = new File("C://apache-tomcat-8.5.57/webapps/Anexos/" + nombre);
                    f.delete();
                    archivoDao.eliminarArchivo(archivo);
                    request.getRequestDispatcher("Control?accion=Listar").forward(request, response);
                    break;
                default:
                    throw new AssertionError();
            }
        } catch (Exception e) {
            System.out.println("error" + e);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

}
