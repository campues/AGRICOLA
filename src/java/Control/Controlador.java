package Control;

import Modelo.Agricultor;
import Modelo.Asociacion;
import Modelo.Colmenas;
import Modelo.Cultivo;
import Modelo.Detallespro;
import Modelo.Empleado;
import Modelo.Herramientas;
import Modelo.Lote;
import Modelo.Producto;
import Modelo.Visitas;
import ModeloDao.AgricultorDao;
import ModeloDao.AsociacionDao;
import ModeloDao.ColmenaDao;
import ModeloDao.CultivoDao;
import ModeloDao.DetallesproDao;
import ModeloDao.EmpleadoDao;
import ModeloDao.HerramientasDao;
import ModeloDao.LoteDao;
import ModeloDao.ProductoDao;
import ModeloDao.VisitasDao;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@MultipartConfig(maxFileSize = 16177215)
public class Controlador extends HttpServlet {

    //  private static final long serialVersionUID = 1L;
    EmpleadoDao empleadoDAO;
    AsociacionDao asociacionDAO;
    AgricultorDao agricultorDAO;
    ProductoDao productoDAO;
    CultivoDao cultivoDAO;
    LoteDao loteDAO;
    VisitasDao visitasDAO;
    DetallesproDao detalleDAO;
    HerramientasDao herraDao;
    ColmenaDao colmenaDAO;

    Herramientas h = new Herramientas();
    Empleado em = new Empleado();
    Agricultor ag = new Agricultor();
    Lote lote = new Lote();
    Detallespro de = new Detallespro();
    Producto pro = new Producto();
    Visitas vis = new Visitas();
    Asociacion asoci = new Asociacion();
    Cultivo cu = new Cultivo();
    Colmenas col = new Colmenas();

    int idEmple; // id empleado

    public void init() {
        String jdbcURL = getServletContext().getInitParameter("jdbcURL");
        String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
        String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
        try {
            asociacionDAO = new AsociacionDao(jdbcURL, jdbcUsername, jdbcPassword);
            empleadoDAO = new EmpleadoDao(jdbcURL, jdbcUsername, jdbcPassword);
            agricultorDAO = new AgricultorDao(jdbcURL, jdbcUsername, jdbcPassword);
            cultivoDAO = new CultivoDao(jdbcURL, jdbcUsername, jdbcPassword);
            loteDAO = new LoteDao(jdbcURL, jdbcUsername, jdbcPassword);
            visitasDAO = new VisitasDao(jdbcURL, jdbcUsername, jdbcPassword);
            productoDAO = new ProductoDao(jdbcURL, jdbcUsername, jdbcPassword);
            detalleDAO = new DetallesproDao(jdbcURL, jdbcUsername, jdbcPassword);
            herraDao = new HerramientasDao(jdbcURL, jdbcUsername, jdbcPassword);
            colmenaDAO = new ColmenaDao(jdbcURL, jdbcUsername, jdbcPassword);

        } catch (Exception e) {

        }
    }

    public Controlador() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");
        System.out.println(accion);
        if (menu.equals("Inicio")) {
            request.getRequestDispatcher("home.jsp").forward(request, response);
            Variables.panPrincipal = 0;
            Variables.idAgricultor = 0;
        }

        // ==============================INSPECCION VISITA=======================================================
        if (menu.equals("Visitas")) {
            try {
                switch (accion) {
                    case "Listar":
                        RequestDispatcher res = request.getRequestDispatcher("inspeccion-lista.jsp");
                        List<Visitas> listaVi = visitasDAO.listarVisitaID();
                        request.setAttribute("listaVi", listaVi);
                        Variables.idVisitas = vis.getPk_visitas();
                        res.forward(request, response);
                        break;
                    case "Nuevo":
                        RequestDispatcher d = request.getRequestDispatcher("inspeccion-nuevo.jsp");
                        //lista de empleado para seleccion Multiple
                        List<Empleado> list = empleadoDAO.listarEmpleados();
                        request.setAttribute("lisEmple", list);
                        d.forward(request, response);
                        break;
                    case "Agregar":
                        vis.setPk_visitas(0);
                        vis.setFecha(request.getParameter("txtFecha"));
                        vis.setNom_informante(request.getParameter("txtInformante"));
                        vis.setParentesco(request.getParameter("opParentesco"));
                        vis.setTipo_auditoria(request.getParameter("opAuditoria"));
                        vis.setCertificado(request.getParameter("checCertf"));
                        vis.setTipoInspeccion(request.getParameter("opInspeccion"));

                        vis.setCon_compromiso(request.getParameter("checContrato"));
                        vis.setNp_organica(request.getParameter("checNormas"));
                        vis.setRc_interno(request.getParameter("checReglamento"));
                        vis.setElab_bocashi(request.getParameter("checElaboracion"));
                        vis.setPco_uvillas(request.getParameter("checProtocolo"));
                        vis.setCos_poscosecha(request.getParameter("checCosecha"));
                        vis.setObHalasgoDete(request.getParameter("txtObserv"));
                        vis.setObPlazoAccion(request.getParameter("txtAcciones"));

                        vis.setFk_lote(Integer.parseInt(request.getParameter("fkLote")));
                        vis.setFk_empleadov(Integer.parseInt(request.getParameter("fkEmpleado")));

                        visitasDAO.insertarVisitaSIN(vis);
                        request.getRequestDispatcher("Controlador?menu=Visitas&accion=Listar").forward(request, response);
                        break;
                    case "VerCultivo":
                        vis = visitasDAO.obtenerPorId(Integer.parseInt(request.getParameter("pk_visitas")));
                        Variables.idVisitas = vis.getPk_visitas();
                        response.sendRedirect("Controlador?menu=Cultivo&accion=Listar");
                        break;
                    case "VerColmena":
                        vis = visitasDAO.obtenerPorId(Integer.parseInt(request.getParameter("pk_visitas")));
                        Variables.idVisitas = vis.getPk_visitas();
                        response.sendRedirect("Controlador?menu=Colmenas&accion=Listar");
                        break;
                    case "Eliminar":
                        Visitas viEliminar = visitasDAO.obtenerPorId(Integer.parseInt(request.getParameter("pk_visitas")));
                        visitasDAO.eliminarVisitas(viEliminar);
                        request.getRequestDispatcher("Controlador?menu=Visitas&accion=Listar").forward(request, response);
                        break;
                    default:
                        break;
                }

            } catch (SQLException e) {
                e.getStackTrace();
            }
        }
        // ==============================COLMENAS===========================================================
        if (menu.equals("Colmenas")) {
            try {
                switch (accion) {
                    case "Listar":
                        RequestDispatcher disCult = request.getRequestDispatcher("colmenas.jsp");
                        List<Colmenas> list = colmenaDAO.listarColmenaID();
                        request.setAttribute("listaCol", list);
                        disCult.forward(request, response);
                        break;
                    case "Agregar":
                        col.setPk_colmenas(0);
                        col.setCodColmena(request.getParameter("txtCodigo"));
                        col.setAbejas(request.getParameter("radioA"));
                        col.setReina(request.getParameter("radioR"));
                        col.setPiso(request.getParameter("txtNumero"));
                        col.setAlimentacion(request.getParameter("txtAlimentacion"));
                        col.setCantidad(request.getParameter("txtCantidad"));
                        col.setDescripcion(request.getParameter("txtDescripcion"));
                        col.setActividad(request.getParameter("txtActividad"));
                        col.setTratamiento(request.getParameter("txtTratamiento"));
                        col.setFk_visitas(Integer.parseInt(request.getParameter("fkVisitas")));
                        colmenaDAO.insertarCol(col);
                        request.getRequestDispatcher("Controlador?menu=Colmenas&accion=Listar").forward(request, response);
                        break;
                    case "Buscar":
                        RequestDispatcher distw = request.getRequestDispatcher("colmenas.jsp");
                        List<Colmenas> colme = colmenaDAO.listarCodigo(request.getParameter("txtBusqueda"));
                        request.setAttribute("listaCol", colme);
                        distw.forward(request, response);
                        break;
                    case "Eliminar":
                        Colmenas colEliminar = colmenaDAO.obtenerPorId(Integer.parseInt(request.getParameter("pk_colmenas")));
                        colmenaDAO.eliminarColmena(colEliminar);
                        request.getRequestDispatcher("Controlador?menu=Colmenas&accion=Listar").forward(request, response);
                        break;
                    default:
                        break;
                }
            } catch (SQLException e) {
                e.getStackTrace();
            }
        }

        // ==============================CULTIVO===========================================================
        if (menu.equals("Cultivo")) {
            try {
                switch (accion) {
                    case "Listar":
                        RequestDispatcher disCult = request.getRequestDispatcher("cultivo.jsp");
                        List<Cultivo> list = cultivoDAO.listarCultivoID();
                        request.setAttribute("listaCul", list);
                        disCult.forward(request, response);
                        break;
                    case "Agregar":
                        cu.setPk_cultivo(0);
                        cu.setNomCultivo(request.getParameter("txtNombre"));
                        cu.setArea(request.getParameter("txtArea"));
                        cu.setDensidadSiembra(request.getParameter("txtDensidad"));
                        cu.setNumPlantas(request.getParameter("txtNumero"));
                        cu.setFechaPro(request.getParameter("txtFecha"));
                        cu.setEs_cosecha(request.getParameter("txtEstimacion"));
                        cu.setEstatus(request.getParameter("opEstatus"));
                        cu.setAnio_organica(request.getParameter("txtAnio_or"));
                        cu.setAnio_inspeccion(request.getParameter("txtAnio_ins"));
                        cu.setFk_visitasc(Integer.parseInt(request.getParameter("fkVisitas")));
                        cultivoDAO.insertarCul(cu);
                        request.getRequestDispatcher("Controlador?menu=Cultivo&accion=Listar").forward(request, response);
                        break;
                    case "Buscar":
                        RequestDispatcher distw = request.getRequestDispatcher("cultivo.jsp");
                        List<Cultivo> cul = cultivoDAO.listarNom(request.getParameter("txtBusqueda"));
                        request.setAttribute("listaCul", cul);
                        distw.forward(request, response);
                        break;
                   
                    case "Eliminar":
                        Cultivo culEliminar = cultivoDAO.obtenerPorId(Integer.parseInt(request.getParameter("pk_cultivo")));
                        cultivoDAO.eliminarCult(culEliminar);
                        request.getRequestDispatcher("Controlador?menu=Cultivo&accion=Listar").forward(request, response);
                        break;
                    default:
                        break;
                }
            } catch (SQLException e) {
                e.getStackTrace();
            }
        }
        // ==============================Herramientas===========================================================
        if (menu.equals("Herramientas")) {
            try {
                switch (accion) {
                    case "Listar":
                        RequestDispatcher dispatc = request.getRequestDispatcher("lote-datos.jsp");
                        List<Herramientas> listaHe = herraDao.listarHerramientas();
                        request.setAttribute("listaHerra", listaHe);
                        dispatc.forward(request, response);

                        break;
                    case "Agregar":
                        h.setPk_herramientas(0);
                        h.setNomHerramienta(request.getParameter("opHerramientas"));
                        h.setCantidad(request.getParameter("txtCantidad"));
                        h.setFk_loteh(request.getParameter("fk_loteh"));
                        herraDao.insertarHerra(h);
                        request.getRequestDispatcher("Controlador?menu=Herramientas&accion=Listar").forward(request, response);
                        break;
                    case "Editar":
                        h = herraDao.obtenerPorId(Integer.parseInt(request.getParameter("pk_herramientas")));
                        request.setAttribute("herraienta", h);
                        request.getRequestDispatcher("Controlador?menu=Herramientas&accion=Listar").forward(request, response);
                        break;
                    case "Eliminar":
                        h = herraDao.obtenerPorId(Integer.parseInt(request.getParameter("pk_herramientas")));
                        herraDao.eliminarHerr(h);
                        request.getRequestDispatcher("Controlador?menu=Herramientas&accion=Listar").forward(request, response);
                        break;
                    default:
                        break;
                }

            } catch (SQLException e) {
                e.getStackTrace();
            }

        }
        // ==============================DETALLES PRODUCTO===========================================================
        if (menu.equals("Detalles")) {
            try {
                switch (accion) {

                    case "Listar":
                        RequestDispatcher distt = request.getRequestDispatcher("suministro.jsp");
                        List<Detallespro> listaDetalle = detalleDAO.listarDetalles();
                        request.setAttribute("listaDe", listaDetalle);

                        List<Producto> listaProd = productoDAO.listarProducto();
                        request.setAttribute("listaPro", listaProd);

                        List<Empleado> listaEm = empleadoDAO.listarEmpleados();
                        request.setAttribute("listaEmple", listaEm);

                        List<Agricultor> listaAgric = agricultorDAO.listarAgricultor();
                        request.setAttribute("listaAgri", listaAgric);

                        distt.forward(request, response);
                        break;
                    case "Agregar":
                        de.setPk_detallesPro(0);
                        de.setFechaEntrega(request.getParameter("txtFecha"));
                        de.setCantidad(request.getParameter("txtCantidad"));
                        de.setFk_agricutor(request.getParameter("txtAgricultor"));
                        de.setFk_producto(request.getParameter("txtProducto"));
                        de.setFk_empleado(request.getParameter("txtEmpleado"));
                        detalleDAO.insertarDetalle(de);
                        RequestDispatcher distss = request.getRequestDispatcher("Controlador?menu=Detalles&accion=Listar");
                        distss.forward(request, response);
                        break;
                    case "showedit":
                        RequestDispatcher dists = request.getRequestDispatcher("Controlador?menu=Detalles&accion=Listar");
                        de = detalleDAO.obtenerPorId(Integer.parseInt(request.getParameter("pk_detallesPro")));
                        request.setAttribute("detalle", de);
                        request.setAttribute("fk", de.getFk_agricutor());
                        Variables.idAgricultor = Integer.parseInt(de.getFk_agricutor());
                        dists.forward(request, response);
                        break;
                    case "Actualizar":
                        de.setPk_detallesPro(Integer.parseInt(request.getParameter("pk")));
                        de.setFechaEntrega(request.getParameter("txtFecha"));
                        de.setCantidad(request.getParameter("txtCantidad"));
                        de.setFk_agricutor(request.getParameter("txtAgricultor"));

                        de.setFk_producto(request.getParameter("txtProducto"));
                        de.setFk_empleado(request.getParameter("txtEmpleado"));
                        detalleDAO.actualizar(de);
                        request.getRequestDispatcher("Controlador?menu=Detalles&accion=Listar").forward(request, response);
                        break;
                    case "Eliminar":
                        Detallespro detaEliminar = detalleDAO.obtenerPorId(Integer.parseInt(request.getParameter("pk_detallesPro")));
                        detalleDAO.eliminarDe(detaEliminar);
                        request.getRequestDispatcher("Controlador?menu=Detalles&accion=Listar").forward(request, response);
                        break;
                    default:
                        break;
                }

            } catch (SQLException e) {
                e.getStackTrace();
            }
        }

        // ==============================LOTE===========================================================
        if (menu.equals("Lote")) {
            try {
                switch (accion) {
                    case "Listar":
                        RequestDispatcher dlote = request.getRequestDispatcher("lote-lista.jsp");
                        if (Variables.panPrincipal > 0) {
                            List<Lote> listaLo = loteDAO.listarLoteID();
                            request.setAttribute("listaLote", listaLo);
                            Variables.idLote = lote.getPk_lote();
                        } else {
                            List<Lote> listaLo = loteDAO.listarLote();
                            request.setAttribute("listaLote", listaLo);
                            Variables.idAgricultor = 0;
                            Variables.agriNombre = "";
                            Variables.agriApellido = "";
                        }
                        dlote.forward(request, response);
                        break;
                    case "Listarr":
                        RequestDispatcher dlotee = request.getRequestDispatcher("lote-lista.jsp");
                        List<Lote> listaLo = loteDAO.listarLoteID();
                        request.setAttribute("listaLote", listaLo);
                        Variables.idLote = lote.getPk_lote();
                        request.setAttribute("global", Variables.panPrincipal);
                        dlotee.forward(request, response);
                        break;
                    case "Buscar":
                        RequestDispatcher distw = request.getRequestDispatcher("lote-lista.jsp");
                        List<Lote> l = loteDAO.listarCod(request.getParameter("txtCodigo"));
                        request.setAttribute("listaAgri", l);
                        Variables.panPrincipal = 10;
                        distw.forward(request, response);
                        break;
                    case "Nuevo":
                        RequestDispatcher d = request.getRequestDispatcher("lote-nuevo.jsp");
                        //lista de asociacion para seleccion 
                        List<Asociacion> list = asociacionDAO.listarAsociacion();
                        request.setAttribute("lisAso", list);
                        d.forward(request, response);
                        break;
                    case "VerVisitas":
                        lote = loteDAO.obtenerPorId(Integer.parseInt(request.getParameter("pk_lote")));
                        Variables.idLote = lote.getPk_lote();
                        response.sendRedirect("Controlador?menu=Visitas&accion=Listar");
                        break;
                    case "LoteDatos":
                        lote = loteDAO.obtenerPorId(Integer.parseInt(request.getParameter("pk_lote")));
                        Variables.idLote = lote.getPk_lote();
                        List<Herramientas> listaHe = herraDao.listarHerramientas();
                        request.setAttribute("listaHerra", listaHe);
                        response.sendRedirect("lote-datos.jsp");
                        // request.getRequestDispatcher("Controlador?menu=Lote=Listar").forward(request, response);
                        break;
                    case "Agregar":
                        lote.setPk_lote(0);
                        lote.setUbi_Geografica(request.getParameter("txtUbi"));
                        lote.setAltura(request.getParameter("txtAlt"));
                        lote.setCodigo(request.getParameter("txtCod"));

                        lote.setCertificado(request.getParameter("txtCertificado"));

                        lote.setBanio(request.getParameter("checBanio"));
                        lote.setAgua_potable(request.getParameter("checAguaP"));
                        lote.setLuz_electrica(request.getParameter("checLuzE"));
                        lote.setAgua_riego(request.getParameter("checAguaR"));

                        lote.setBodega(request.getParameter("checBodega"));
                        lote.setOb_bodega(request.getParameter("txtObBodega"));
                        lote.setPoscosecha(request.getParameter("checPoscosecha"));
                        lote.setOb_poscosecha(request.getParameter("txtOb_poscosecha"));

                        lote.setCapacitacion(request.getParameter("checCapacitacion"));
                        lote.setOb_capacitacion(request.getParameter("txtObCapacitacion"));
                        lote.setM_transporte(request.getParameter("checTransp"));
                        lote.setOb_transporte(request.getParameter("txtObTransporte"));

                        lote.setInc_abono(request.getParameter("txtInserAbono"));
                        lote.setRiesgo_erosion(request.getParameter("txtRiegoE"));

                        lote.setRegistr_lote(request.getParameter("opRegistro"));

                        lote.setUsopp(request.getParameter("checUsopp"));
                        lote.setEn_prdoduc(request.getParameter("checEnpro"));
                        lote.setCont_lateral(request.getParameter("checContLateral"));
                        lote.setAgua_procesamiento(request.getParameter("checAguaPro"));

                        lote.setDes_produccion(request.getParameter("txtDesProduccion"));

                        lote.setParroquia(request.getParameter("txtPar"));
                        lote.setObservaciones(request.getParameter("txtObserv"));
                        lote.setRecomendaciones(request.getParameter("txtRecom"));
                        lote.setFk_provincia(Integer.parseInt(request.getParameter("selectProvi")));

                        lote.setFk_agricultorl(Integer.parseInt(request.getParameter("fkAgricultor")));

                        lote.setFk_asociacion(Integer.parseInt(request.getParameter("selectAso")));
                        loteDAO.insertarLoteSIN(lote);
                        request.getRequestDispatcher("Controlador?menu=Lote&accion=Listarr").forward(request, response);
                        break;
                    case "Eliminar":
                        Lote loEliminar = loteDAO.obtenerPorId(Integer.parseInt(request.getParameter("pk_lote")));
                        loteDAO.eliminarLote(loEliminar);
                        request.getRequestDispatcher("Controlador?menu=Lote&accion=Listarr").forward(request, response);
                        break;
                    default:
                        break;
                }

            } catch (SQLException e) {
                e.getStackTrace();
            }
        }
        // ==============================AGRICULTOR===========================================================
        if (menu.equals("Agricultor")) {
            try {
                switch (accion) {
                    case "Listar":
                        RequestDispatcher dist = request.getRequestDispatcher("agricultor-lista.jsp");
                        List<Agricultor> listaAgric = agricultorDAO.listarAgricultor();
                        request.setAttribute("listaAgri", listaAgric);
                        Variables.panPrincipal = 10;
                        dist.forward(request, response);
                        break;
                    case "Agregar":
                        ag.setPk_agricultor(0);
                        ag.setNombre1(request.getParameter("txtNom1"));
                        ag.setNombre2(request.getParameter("txtNom2"));
                        ag.setApellido1(request.getParameter("txtApe1"));
                        ag.setApellido2(request.getParameter("txtApe2"));
                        ag.setCedula(request.getParameter("txtCed"));
                        ag.setDireccion(request.getParameter("txtDir"));
                        ag.setTelefono(request.getParameter("txtTel"));
                        ag.setFechaAfiliacion(request.getParameter("txtFec"));
                        ag.setEstatus(request.getParameter("txtEst"));
                        ag.setLiderAsociacion(request.getParameter("radioL"));
                        agricultorDAO.insertarAgr(ag);
                        request.getRequestDispatcher("Controlador?menu=Agricultor&accion=Listar").forward(request, response);
                        break;
                    case "Actualizar":
                        ag.setPk_agricultor(Integer.parseInt(request.getParameter("pk")));
                        ag.setNombre1(request.getParameter("txtNom1"));
                        ag.setNombre2(request.getParameter("txtNom2"));
                        ag.setApellido1(request.getParameter("txtApe1"));
                        ag.setApellido2(request.getParameter("txtApe2"));
                        ag.setCedula(request.getParameter("txtCed"));
                        ag.setDireccion(request.getParameter("txtDir"));
                        ag.setTelefono(request.getParameter("txtTel"));
                        ag.setFechaAfiliacion(request.getParameter("txtFec"));
                        ag.setEstatus(request.getParameter("txtEst"));
                        ag.setLiderAsociacion(request.getParameter("radioL"));
                        agricultorDAO.actualizarAg(ag);
                        RequestDispatcher dispatcherw = request.getRequestDispatcher("agricultor-nuevo.jsp");
                        dispatcherw.forward(request, response);
                        break;
                    case "showedit":
                        String valor1 = "ACTIVO";
                        String valor2 = "INACTIVO";
                        RequestDispatcher dists = request.getRequestDispatcher("agricultor-nuevo.jsp");
                        ag = agricultorDAO.obtenerPorId(Integer.parseInt(request.getParameter("pk_agricultor")));
                        request.setAttribute("agricul", ag);
                        request.setAttribute("estatus", ag.getEstatus());
                        request.setAttribute("result1", valor1);
                        request.setAttribute("result2", valor2);

                        dists.forward(request, response);
                        break;
                    case "Buscar":
                        RequestDispatcher distw = request.getRequestDispatcher("agricultor-lista.jsp");
                        List<Agricultor> liss = agricultorDAO.listarAgriCed(request.getParameter("txtCedula"));
                        request.setAttribute("listaAgri", liss);
                        Variables.panPrincipal = 10;
                        distw.forward(request, response);
                        break;
                    case "Enlistar":
                        RequestDispatcher distq = request.getRequestDispatcher("agricultor-buscar.jsp");
                        List<Agricultor> listaAgricc = agricultorDAO.listarAgricultor();
                        request.setAttribute("listaAgri", listaAgricc);
                        Variables.panPrincipal = 10;
                        distq.forward(request, response);
                        break;

                    case "Editar":
                        ag = agricultorDAO.obtenerPorId(Integer.parseInt(request.getParameter("pk_agricultor")));
                        request.setAttribute("agricul", ag);
                        Variables.idAgricultor = ag.getPk_agricultor();
                        request.setAttribute("global", Variables.idAgricultor);

                        request.getRequestDispatcher("Controlador?menu=Agricultor&accion=Listar").forward(request, response);
                        break;
                    case "VerTerreno":
                        ag = agricultorDAO.obtenerPorId(Integer.parseInt(request.getParameter("pk_agricultor")));
                        Variables.idAgricultor = ag.getPk_agricultor();
                        Variables.agriNombre = ag.getNombre1();
                        Variables.agriApellido = ag.getApellido1();
                        response.sendRedirect("Controlador?menu=Lote&accion=Listar");
                        // request.getRequestDispatcher("Controlador?menu=Lote=Listar").forward(request, response);
                        break;
                    case "Eliminar":
                        Agricultor agEliminar = agricultorDAO.obtenerPorId(Integer.parseInt(request.getParameter("pk_agricultor")));
                        agricultorDAO.eliminarAgri(agEliminar);
                        request.getRequestDispatcher("Controlador?menu=Agricultor&accion=Listar").forward(request, response);
                        break;
                    default:
                        break;
                }

            } catch (SQLException e) {
                e.getStackTrace();
            }
        }

        // ==============================EMPLEADOS===========================================================
        if (menu.equals("Empleado")) {
            try {
                switch (accion) {
                    case "Listar":
                        RequestDispatcher dispatc = request.getRequestDispatcher("empleado-lista.jsp");
                        List<Empleado> listaEm = empleadoDAO.listarEmpleados();
                        request.setAttribute("empleados", listaEm);
                        dispatc.forward(request, response);
                        break;
                    case "Agregar":
                        em.setPk_empleado(0);
                        em.setNombre(request.getParameter("txtNombre"));
                        em.setApellido(request.getParameter("txtApellido"));
                        em.setUsuario(request.getParameter("txtUsuario"));
                        em.setContrasena(request.getParameter("txtContrasena"));
                        em.setTipo(request.getParameter("opTipo"));
                        empleadoDAO.insertarEm(em);
                        request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                        break;
                    case "Editar":
                        RequestDispatcher rest = request.getRequestDispatcher("empleado-nuevo.jsp");
                        idEmple = Integer.parseInt(request.getParameter("pk_empleado"));
                        Empleado e = empleadoDAO.obtenerPorId(idEmple);
                        request.setAttribute("emple", e);
                        request.setAttribute("tipo", e.getTipo());
                        request.setAttribute("n1", 1);
                        request.setAttribute("n2", 2);
                        request.setAttribute("n3", 3);
                        request.setAttribute("n", 4);
                        rest.forward(request, response);
                        break;
                    case "Actualizar":
                        em.setPk_empleado(idEmple);
                        em.setNombre(request.getParameter("txtNombre"));
                        em.setApellido(request.getParameter("txtApellido"));
                        em.setUsuario(request.getParameter("txtUsuario"));
                        em.setContrasena(request.getParameter("txtContrasena"));
                        em.setTipo(request.getParameter("opTipo"));
                        empleadoDAO.actualizar(em);
                        request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                        break;
                    case "Buscar":
                        RequestDispatcher distw = request.getRequestDispatcher("empleado-lista.jsp");
                        List<Empleado> liss = empleadoDAO.buscarNom(request.getParameter("txtBusqueda"));
                        request.setAttribute("empleados", liss);
                        distw.forward(request, response);
                        break;
                    case "Eliminar":
                        idEmple = Integer.parseInt(request.getParameter("pk_empleado"));
                        empleadoDAO.eliminarEm(idEmple);
                        request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                        break;
                    default:
                        throw new AssertionError();
                }

            } catch (SQLException e) {
                e.getStackTrace();
            }
        }
        // ==============================ASOCIACION===========================================================
        if (menu.equals("Asociacion")) {
            try {
                switch (accion) {
                    case "Listar":
                        RequestDispatcher asocd = request.getRequestDispatcher("asociaciones.jsp");
                        List<Asociacion> list = asociacionDAO.listarAsociacion();
                        request.setAttribute("asocia", list);
                        asocd.forward(request, response);
                        break;
                    case "Agregar":
                        asoci.setPk_asociacion(0);
                        asoci.setNombre(request.getParameter("txtNombre"));
                        asoci.setDireccion(request.getParameter("txtDireccion"));
                        asoci.setTelefono(request.getParameter("txtTelefono"));
                        asociacionDAO.insertarAso(asoci);
                        request.getRequestDispatcher("Controlador?menu=Asociacion&accion=Listar").forward(request, response);
                        break;
                    case "Editar":
                        RequestDispatcher restt = request.getRequestDispatcher("asociacion-editar.jsp");
                        asoci = asociacionDAO.obtenerPorId(Integer.parseInt(request.getParameter("pk_asociacion")));
                        request.setAttribute("asoc", asoci);
                        restt.forward(request, response);
                        break;
                    case "Actualizar":
                        asoci.setPk_asociacion(Integer.parseInt(request.getParameter("pk")));
                        asoci.setNombre(request.getParameter("txtNombre"));
                        asoci.setDireccion(request.getParameter("txtDireccion"));
                        asoci.setTelefono(request.getParameter("txtTelefono"));
                        asociacionDAO.actualizar(asoci);
                        request.getRequestDispatcher("Controlador?menu=Asociacion&accion=Listar").forward(request, response);
                        break;
                    case "Buscar":
                        RequestDispatcher distwg = request.getRequestDispatcher("asociaciones.jsp");
                        List<Asociacion> lisst = asociacionDAO.BuscarNombre(request.getParameter("txtBusqueda"));
                        request.setAttribute("asocia", lisst);
                        distwg.forward(request, response);
                        break;
                    case "Eliminar":
                        Asociacion asEliminar = asociacionDAO.obtenerPorId(Integer.parseInt(request.getParameter("pk_asociacion")));
                        asociacionDAO.eliminarAso(asEliminar);
                        request.getRequestDispatcher("Controlador?menu=Asociacion&accion=Listar").forward(request, response);
                        break;

                    default:
                        break;
                }

            } catch (SQLException e) {
                e.getStackTrace();
            }
        }

// ==============================PRODUCTO===========================================================
        if (menu.equals("Productos")) {
            try {
                switch (accion) {

                    case "Agregar":
                        pro.setPk_producto(0);
                        pro.setNomInsumos(request.getParameter("txtNombre"));
                        pro.setStock(request.getParameter("txtStock"));
                        pro.setTipoInsumo(request.getParameter("txtTipo"));
                        productoDAO.insertarPro(pro);
                        request.getRequestDispatcher("Controlador?menu=Productos&accion=Listar").forward(request, response);
                        break;
                    case "Listar":
                        RequestDispatcher dist = request.getRequestDispatcher("producto.jsp");
                        List<Producto> listaProd = productoDAO.listarProducto();
                        request.setAttribute("listaPro", listaProd);
                        dist.forward(request, response);
                        break;
                    case "Eliminar":
                        Producto proEliminar = productoDAO.obtenerPorId(Integer.parseInt(request.getParameter("pk_producto")));
                        productoDAO.eliminarPro(proEliminar);
                        request.getRequestDispatcher("Controlador?menu=Productos&accion=Listar").forward(request, response);
                        break;
                    default:
                        break;
                }

            } catch (SQLException e) {
                e.getStackTrace();
            }
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("Hola Soy doGET..");
        doPost(request, response);
    }

}
