package Control;

import Modelo.Agricultor;
import Modelo.Animales;
import Modelo.Asociacion;
import Modelo.Colmenas;
import Modelo.Cultivo;
import Modelo.Detallespro;
import Modelo.Empleado;
import Modelo.Herramientas;
import Modelo.InsumoLote;
import Modelo.Lote;
import Modelo.ManObra;
import Modelo.ProdAplicados;
import Modelo.Producto;
import Modelo.Provincia;
import Modelo.RiesgoContam;
import Modelo.RotacionCultivo;
import Modelo.Visitas;
import ModeloDao.AgricultorDao;
import ModeloDao.AnimalesDao;
import ModeloDao.AsociacionDao;
import ModeloDao.ColmenaDao;
import ModeloDao.CultivoDao;
import ModeloDao.DetallesproDao;
import ModeloDao.EmpleadoDao;
import ModeloDao.HerramientasDao;
import ModeloDao.InsumoLoteDao;
import ModeloDao.LoteDao;
import ModeloDao.ManObraDao;
import ModeloDao.ProAplicadosDao;
import ModeloDao.ProductoDao;
import ModeloDao.ProvinciaDao;
import ModeloDao.RiesgoContamDao;
import ModeloDao.RotacionCultivoDao;
import ModeloDao.VisitasDao;
import config.GenerarSerie;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.swing.JOptionPane;

public class Controlador extends HttpServlet {

    private static final long serialVersionUID = 1L;
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
    ProvinciaDao proviDAO;
    AnimalesDao animalDAO;
    ManObraDao mObraDAO;
    InsumoLoteDao insumoDAO;
    RotacionCultivoDao rotacionCulDAO;
    ProAplicadosDao prodAplicadosDAO;
    RiesgoContamDao rContaminacionDAO;

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
    Provincia provi = new Provincia();
    Animales anim = new Animales();
    ManObra mObra = new ManObra();
    InsumoLote insumo = new InsumoLote();
    RotacionCultivo roCultivo = new RotacionCultivo();
    ProdAplicados proApli = new ProdAplicados();
    RiesgoContam rcontam = new RiesgoContam();
    String numeroserie = "";

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
            proviDAO = new ProvinciaDao(jdbcURL, jdbcUsername, jdbcPassword);
            animalDAO = new AnimalesDao(jdbcURL, jdbcUsername, jdbcPassword);
            mObraDAO = new ManObraDao(jdbcURL, jdbcUsername, jdbcPassword);
            insumoDAO = new InsumoLoteDao(jdbcURL, jdbcUsername, jdbcPassword);
            rotacionCulDAO = new RotacionCultivoDao(jdbcURL, jdbcUsername, jdbcPassword);
            prodAplicadosDAO = new ProAplicadosDao(jdbcURL, jdbcUsername, jdbcPassword);
            rContaminacionDAO = new RiesgoContamDao(jdbcURL, jdbcUsername, jdbcPassword);

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
        // ==============================AGRICULTOR===========================================================
        if (menu.equals("BAgricultor")) {
            try {
                switch (accion) {
                    case "Entrar":
                        RequestDispatcher distw = request.getRequestDispatcher("Vista.html");
                        distw.forward(request, response);
                        break;
                    case "Buscar":
                        RequestDispatcher distwx = request.getRequestDispatcher("reporte.jsp");
                        ag = agricultorDAO.buscarCed(request.getParameter("txtCedula"));
                        request.setAttribute("cedula", ag);
                        distwx.forward(request, response);
                        break;
                    default:
                        break;
                }

            } catch (SQLException e) {
                request.setAttribute("error", e);
                request.getRequestDispatcher("error.jsp").forward(request, response);
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
                        List<Asociacion> lists = asociacionDAO.listarAsociacion();
                        request.setAttribute("lisAso", lists);
                        //lista provincia y compara
                        List<Provincia> listaproz = proviDAO.listarProvincia();
                        request.setAttribute("lisPro", listaproz);

                        //DATOS DEL AGRICULTOR=============================================================
                        String nombre1 = Variables.agriNombre.split("")[0];
                        String apellido = Variables.agriApellido.split("")[0];
                        String randon = UUID.randomUUID().toString().toUpperCase().substring(0, 3);

                        //generar serie automatica
                        numeroserie = loteDAO.GenerarSerie();
                        if (numeroserie == null) {
                            numeroserie = "0001";
                            request.setAttribute("nserie", nombre1 + apellido + numeroserie);
                        } else {
                            char r1 = numeroserie.charAt(2);
                            char r2 = numeroserie.charAt(3);
                            char r3 = numeroserie.charAt(4);
                            char r4 = numeroserie.charAt(5);
                            String r = "";
                            r = "" + r1 + r2 + r3 + r4;
                            int incrementar = Integer.parseInt(r);
                            GenerarSerie gs = new GenerarSerie();
                            numeroserie = gs.NumeroSerie2(incrementar);
                            request.setAttribute("nserie", nombre1 + apellido + numeroserie);
                        }
                        //genera numero aleatorio de 3 digitos
                        request.setAttribute("random", nombre1 + apellido + randon);

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
                        request.getRequestDispatcher("Controlador?menu=DatosExtras&accion=Listar").forward(request, response);
                        break;
                    case "Agregar":
                        lote.setPk_lote(0);
                        lote.setUbi_Geografica(request.getParameter("txtUbi"));
                        lote.setAltura(request.getParameter("txtAlt"));
                        lote.setCod(request.getParameter("txtCod"));
                        lote.setParroquia(request.getParameter("txtPar"));

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

                        lote.setFk_provincia(Integer.parseInt(request.getParameter("opProvincia")));
                        lote.setFk_agricultorl(Integer.parseInt(request.getParameter("fkAgricultor")));
                        lote.setFk_asociacion(Integer.parseInt(request.getParameter("selectAso")));

                        loteDAO.insertarLoteSIN(lote);
                        request.getRequestDispatcher("Controlador?menu=Lote&accion=Listarr").forward(request, response);
                        break;
                    case "Editar":
                        RequestDispatcher restt = request.getRequestDispatcher("lote-editar.jsp");
                        lote = loteDAO.obtenerPorId(Integer.parseInt(request.getParameter("pk_lote")));
                        request.setAttribute("lot", lote);
                        //lista provincia y compara
                        List<Provincia> lisProv = proviDAO.listarProvincia();
                        request.setAttribute("lisPro", lisProv);

                        List<Asociacion> listaasoc = asociacionDAO.listarAsociacion();
                        request.setAttribute("lisAso", listaasoc);

                        restt.forward(request, response);
                        break;
                    case "Actualizar":
                        lote.setPk_lote(Integer.parseInt(request.getParameter("pk")));
                        lote.setUbi_Geografica(request.getParameter("txtUbi"));
                        lote.setAltura(request.getParameter("txtAlt"));
                        lote.setCod(request.getParameter("txtCod"));
                        lote.setParroquia(request.getParameter("txtPar"));

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

                        lote.setFk_provincia(Integer.parseInt(request.getParameter("opProvincia")));
                        lote.setFk_agricultorl(Integer.parseInt(request.getParameter("fkAgricultor")));
                        lote.setFk_asociacion(Integer.parseInt(request.getParameter("selectAso")));

                        loteDAO.actualizar(lote);
                        request.getRequestDispatcher("Controlador?menu=Lote&accion=Listar").forward(request, response);
                        break;

                    case "Eliminar":
                        Lote loEliminar = loteDAO.obtenerPorId(Integer.parseInt(request.getParameter("pk_lote")));
                        loteDAO.eliminarLote(loEliminar);
                        request.getRequestDispatcher("Controlador?menu=Lote&accion=Listarr").forward(request, response);
                        break;
                    default:
                        break;
                }
            } catch (Exception e) {
                request.setAttribute("error", e);
                request.getRequestDispatcher("error.jsp").forward(request, response);
            }
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
                        List<Empleado> listr = empleadoDAO.listarEmpleados();
                        request.setAttribute("lisEmplea", listr);
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

                        vis.setSelecCultivo(request.getParameter("opSelect"));
                        vis.setTamaCultivo(request.getParameter("n1"));
                        vis.setTipoCultivo(request.getParameter("n2"));
                        vis.setTipoAplicacion(request.getParameter("n3"));
                        vis.setSituacionVecino(request.getParameter("n4"));
                        vis.settAgOrganica(request.getParameter("n5"));
                        vis.setPoProductivo(request.getParameter("n6"));
                        vis.setRecFruta(request.getParameter("n7"));
                        vis.setTotal(request.getParameter("total"));
                        vis.setObCultivo(request.getParameter("txtObservCul"));
                        vis.setTipoRiesgo(request.getParameter("txtTipoRiesgo"));

                        vis.setFk_lote(request.getParameter("fkLote"));
                        vis.setFk_empleadov(request.getParameter("fkEmpleado"));

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
                request.setAttribute("error", e);
                request.getRequestDispatcher("error.jsp").forward(request, response);
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
                    case "Actualizar":
                        col.setPk_colmenas(Integer.parseInt(request.getParameter("pk")));
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
                        colmenaDAO.actualizar(col);
                        request.getRequestDispatcher("Controlador?menu=Colmenas&accion=Listar").forward(request, response);
                        break;
                    case "Editar":
                        RequestDispatcher restt = request.getRequestDispatcher("colmenas-editar.jsp");
                        col = colmenaDAO.obtenerPorId(Integer.parseInt(request.getParameter("pk_colmenas")));
                        request.setAttribute("colm", col);
                        restt.forward(request, response);
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
                request.setAttribute("error", e);
                request.getRequestDispatcher("error.jsp").forward(request, response);
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
                        cu.setRotacion1(request.getParameter("txt1anio"));
                        cu.setRotacion2(request.getParameter("txt2anio"));
                        cu.setRotacion3(request.getParameter("txt3anio"));
                        cu.setObCultivo(request.getParameter("txtobCultivos"));

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
                    case "CultivoExtras":
                        cu = cultivoDAO.obtenerPorId(Integer.parseInt(request.getParameter("pk_cultivo")));
                        Variables.idCultivo = cu.getPk_cultivo();
                        request.getRequestDispatcher("Controlador?menu=ProAplicados&accion=Listar").forward(request, response);
                        break;
                    case "Editar":
                        RequestDispatcher restt = request.getRequestDispatcher("cultivo-editar.jsp");
                        cu = cultivoDAO.obtenerPorId(Integer.parseInt(request.getParameter("pk_cultivo")));
                        request.setAttribute("cult", cu);
                        restt.forward(request, response);
                        break;
                    case "Actualizar":
                        cu.setPk_cultivo(Integer.parseInt(request.getParameter("pk")));
                        cu.setNomCultivo(request.getParameter("txtNombre"));
                        cu.setArea(request.getParameter("txtArea"));
                        cu.setDensidadSiembra(request.getParameter("txtDensidad"));
                        cu.setNumPlantas(request.getParameter("txtNumero"));
                        cu.setFechaPro(request.getParameter("txtFecha"));
                        cu.setEs_cosecha(request.getParameter("txtEstimacion"));
                        cu.setEstatus(request.getParameter("opEstatus"));
                        cu.setAnio_organica(request.getParameter("txtAnio_or"));
                        cu.setAnio_inspeccion(request.getParameter("txtAnio_ins"));
                        cu.setRotacion1(request.getParameter("txt1anio"));
                        cu.setRotacion2(request.getParameter("txt2anio"));
                        cu.setRotacion3(request.getParameter("txt3anio"));
                        cu.setObCultivo(request.getParameter("txtobCultivos"));
                        cu.setFk_visitasc(Integer.parseInt(request.getParameter("fkVisitas")));
                        cultivoDAO.actualizar(cu);
                        request.getRequestDispatcher("Controlador?menu=Cultivo&accion=Listar").forward(request, response);
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
                request.setAttribute("error", e);
                request.getRequestDispatcher("error.jsp").forward(request, response);
            }
        }
        // =============================PRODUCTOS APLICADOS cultivo-> CULTIVO DATOS===========================================================
        if (menu.equals("ProAplicados")) {
            switch (accion) {
                case "Listar":
                    try {
                        RequestDispatcher disCult = request.getRequestDispatcher("cprodCultivo.jsp");
                        List<ProdAplicados> listaProd = prodAplicadosDAO.listarProdID();
                        request.setAttribute("listaProducto", listaProd);
                        disCult.forward(request, response);
                    } catch (Exception e) {
                        request.setAttribute("error", e);
                        request.getRequestDispatcher("error.jsp").forward(request, response);
                    }
                    break;
                case "Agregar":
                    try {
                        proApli.setPk_proAplicados(0);
                        proApli.setTipoProducto(request.getParameter("opTipo"));
                        proApli.setNomProducto(request.getParameter("txtNombre"));
                        proApli.setFuncionalidad(request.getParameter("txtFuncionalidad"));
                        proApli.setCanConsertracion(request.getParameter("txtCantidad"));
                        proApli.setObservacion(request.getParameter("txtObservacion"));
                        proApli.setFecha(request.getParameter("txtFecha"));
                        proApli.setAsInstalacion(request.getParameter("txtAsInstalacion"));
                        proApli.setAsInsumo(request.getParameter("txtAsInsumos"));
                        proApli.setOrigen(request.getParameter("opOrigen"));
                        proApli.setFk_cultivo(request.getParameter("fk_cultivop"));
                        prodAplicadosDAO.insertarProduc(proApli);
                        request.getRequestDispatcher("Controlador?menu=ProAplicados&accion=Listar").forward(request, response);
                    } catch (SQLException e) {
                        request.setAttribute("error", e);
                        request.getRequestDispatcher("error.jsp").forward(request, response);
                    }
                    break;
                case "Eliminar":
                    try {
                        proApli = prodAplicadosDAO.obtenerPorId(Integer.parseInt(request.getParameter("pk_proAplicados")));
                        prodAplicadosDAO.eliminarProd(proApli);
                        request.getRequestDispatcher("Controlador?menu=ProAplicados&accion=Listar").forward(request, response);
                    } catch (SQLException e) {
                        request.setAttribute("error", e);
                        request.getRequestDispatcher("error.jsp").forward(request, response);
                    }
                    break;
                default:
                    break;
            }

        }

        // ==============================HERRAMIENTAS -> DATOS EXTRAS===========================================================
        if (menu.equals("Herramientas")) {
            try {
                switch (accion) {
                    case "Agregar":
                        h.setPk_herramientas(0);
                        h.setNomHerramienta(request.getParameter("opHerramientas"));
                        h.setCantidad(request.getParameter("txtCantidad"));
                        h.setFk_loteh(request.getParameter("fk_loteh"));
                        herraDao.insertarHerra(h);
                        request.getRequestDispatcher("Controlador?menu=DatosExtras&accion=Listar").forward(request, response);
                        break;
                    case "Eliminar":
                        h = herraDao.obtenerPorId(Integer.parseInt(request.getParameter("pk_herramientas")));
                        herraDao.eliminarHerr(h);
                        request.getRequestDispatcher("Controlador?menu=DatosExtras&accion=Listar").forward(request, response);
                        break;
                    default:
                        break;
                }
            } catch (SQLException e) {
                request.setAttribute("error", e);
                request.getRequestDispatcher("error.jsp").forward(request, response);
            }
        }

        // ==============================ANIMALES -> DATOS EXTRAS===========================================================
        if (menu.equals("Animales")) {
            try {
                switch (accion) {
                    case "Agregar":
                        anim.setPk_animales(0);
                        anim.setEspecie(request.getParameter("opAnimales"));
                        anim.setCantidad(request.getParameter("txtCantidad"));
                        anim.setFk_lotea(request.getParameter("fk_lotea"));
                        animalDAO.insertarAnimales(anim);
                        request.getRequestDispatcher("Controlador?menu=DatosExtras&accion=Listar").forward(request, response);
                        break;
                    case "Eliminar":
                        anim = animalDAO.obtenerPorId(Integer.parseInt(request.getParameter("pk_animales")));
                        animalDAO.eliminarAnimal(anim);
                        request.getRequestDispatcher("Controlador?menu=DatosExtras&accion=Listar").forward(request, response);
                        break;
                    default:
                        break;
                }
            } catch (SQLException e) {
                request.setAttribute("error", e);
                request.getRequestDispatcher("error.jsp").forward(request, response);
            }
        }
        // ==============================MANO DE OBRA -> DATOS EXTRAS===========================================================
        if (menu.equals("ManObra")) {
            try {
                switch (accion) {
                    case "Agregar":
                        mObra.setPk_manObra(0);
                        mObra.setFamilia(request.getParameter("opfamilia"));
                        mObra.setEdad(request.getParameter("opEdad"));
                        mObra.setSexo(request.getParameter("opSexo"));
                        mObra.setCantidad(request.getParameter("txtCantidad"));
                        mObra.setFk_lotem(request.getParameter("fk_lotem"));
                        mObraDAO.insertarManObra(mObra);
                        request.getRequestDispatcher("Controlador?menu=DatosExtras&accion=Listar").forward(request, response);
                        break;
                    case "Eliminar":
                        mObra = mObraDAO.obtenerPorId(Integer.parseInt(request.getParameter("pk_manObra")));
                        mObraDAO.eliminarManObra(mObra);
                        request.getRequestDispatcher("Controlador?menu=DatosExtras&accion=Listar").forward(request, response);
                        break;
                    default:
                        break;
                }
            } catch (SQLException e) {
                request.setAttribute("error", e);
                request.getRequestDispatcher("error.jsp").forward(request, response);
            }
        }

        // DATOS EXTRAS-------------------------
        if (menu.equals("DatosExtras")) {
            try {
                switch (accion) {
                    case "Listar":
                        RequestDispatcher dispatc = request.getRequestDispatcher("lote-datos.jsp");
                        //lista Herramientas
                        List<Herramientas> listaHe = herraDao.listarHerramientasID();
                        request.setAttribute("listaHerra", listaHe);
                        // lista Animales
                        List<Animales> listaAni = animalDAO.listarAnimalesID();
                        request.setAttribute("listaAnim", listaAni);
                        // lista Mano Obra
                        List<ManObra> listaMano = mObraDAO.listarManObraID();
                        request.setAttribute("listaMan", listaMano);

                        dispatc.forward(request, response);
                        break;
                    default:
                        break;
                }
            } catch (Exception e) {
                request.setAttribute("error", e);
                request.getRequestDispatcher("error.jsp").forward(request, response);
            }
        }

        // ==============================DETALLES PRODUCTO===========================================================
        if (menu.equals("Detalles")) {
            try {
                String msj;
                switch (accion) {
                    case "Listar":
                        try {
                            List<Agricultor> listaAgric = agricultorDAO.listarAgricultor();
                            request.setAttribute("listaAgri", listaAgric);

                            List<Producto> listaProd = productoDAO.listarProducto();
                            request.setAttribute("listaPro", listaProd);

                            List<Empleado> listaEm = empleadoDAO.listarEmpleados();
                            request.setAttribute("listaEmple", listaEm);

                            List<Detallespro> listaDetalle = detalleDAO.listarDetalles();
                            request.setAttribute("listaDe", listaDetalle);

                            request.getRequestDispatcher("suministro.jsp").forward(request, response);
                        } catch (Exception e) {
                            request.setAttribute("error", e);
                            request.getRequestDispatcher("error.jsp").forward(request, response);
                        }
                        break;
                    case "Agregar":
                        de.setPk_detallesPro(0);
                        de.setFechaEntrega(request.getParameter("txtFecha"));
                        de.setCantidad(request.getParameter("txtCantidad"));
                        de.setFk_agricutor(request.getParameter("txtAgricultor"));
                        de.setFk_producto(request.getParameter("txtProducto"));
                        de.setFk_empleado(request.getParameter("txtEmpleado"));
                        msj = "";
                        // int v = detalleDAO.registrar_Suminstro(de);

                        if (detalleDAO.insertarDetalle(de) == true) {
                            msj = "5"; //si inserto correctamente
                        } else {
                            msj = "6"; //hubo un error en inserccion
                        }
                        RequestDispatcher distss = request.getRequestDispatcher("Controlador?menu=Detalles&accion=Listar&msj=" + msj);
                        distss.forward(request, response);
                        break;
                    case "Editar":
                        RequestDispatcher dists = request.getRequestDispatcher("suministro-editar.jsp");
                        de = detalleDAO.obtenerPorId(Integer.parseInt(request.getParameter("pk_detallesPro")));
                        request.setAttribute("detalle", de);
                        //Lista para realizar la comparacion y seleccion
                        List<Agricultor> listaAgricc = agricultorDAO.listarAgricultor();
                        request.setAttribute("listaAgri", listaAgricc);
                        List<Producto> listaProdd = productoDAO.listarProducto();
                        request.setAttribute("listaPro", listaProdd);
                        List<Empleado> listaEmm = empleadoDAO.listarEmpleados();
                        request.setAttribute("listaEmple", listaEmm);

                        dists.forward(request, response);
                        break;
                    case "Actualizar":
                        de.setPk_detallesPro(Integer.parseInt(request.getParameter("pk")));
                        de.setFechaEntrega(request.getParameter("txtFecha"));
                        de.setCantidad(request.getParameter("txtCantidad"));
                        de.setFk_agricutor(request.getParameter("txtAgricultor"));

                        de.setFk_producto(request.getParameter("txtProducto"));
                        de.setFk_empleado(request.getParameter("txtEmpleado"));
                        msj = "";

                        if (detalleDAO.actualizar(de) == true) {
                            msj = "5"; //si inserto correctamente
                        } else {
                            msj = "6"; //hubo un error en inserccion
                        }
                        request.getRequestDispatcher("Controlador?menu=Detalles&accion=Listar").forward(request, response);
                        break;
                    case "Buscar":
                        RequestDispatcher redic = request.getRequestDispatcher("suministro.jsp");
                        List<Detallespro> lisst = detalleDAO.listarDetalleAgri(request.getParameter("txtBusqueda"));
                        request.setAttribute("listaDe", lisst);
                        redic.forward(request, response);
                        break;
                    case "Eliminar":
                        Detallespro detaEliminar = detalleDAO.obtenerPorId(Integer.parseInt(request.getParameter("pk_detallesPro")));
                        detalleDAO.eliminarDe(detaEliminar);
                        request.getRequestDispatcher("Controlador?menu=Detalles&accion=Listar&msj=1").forward(request, response);
                        break;
                    default:
                        break;
                }

            } catch (SQLException e) {
                request.setAttribute("error", e);
                request.getRequestDispatcher("error.jsp").forward(request, response);
            } catch (Exception ex) {
                Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
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
                        ag.setCodigo(request.getParameter("txtCodigo"));
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
                        ag.setCodigo(request.getParameter("txtCodigo"));
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
                        request.getRequestDispatcher("Controlador?menu=Agricultor&accion=Listar").forward(request, response);
                        break;
                    case "showedit":
                        RequestDispatcher dists = request.getRequestDispatcher("agricultor-nuevo.jsp");
                        ag = agricultorDAO.obtenerPorId(Integer.parseInt(request.getParameter("pk_agricultor")));
                        request.setAttribute("agricul", ag);
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
                request.setAttribute("error", e);
                request.getRequestDispatcher("error.jsp").forward(request, response);
            }
        }

        // ==============================EMPLEADOS===========================================================
        if (menu.equals("Empleados")) {

            switch (accion) {
                case "Listar":
                    try {
                        RequestDispatcher dispatc = request.getRequestDispatcher("empleado.jsp");
                        List<Empleado> listaEm = empleadoDAO.listarEmpleados();
                        request.setAttribute("empleados", listaEm);

                        dispatc.forward(request, response);
                    } catch (Exception e) {
                        request.setAttribute("error", e);
                        request.getRequestDispatcher("error.jsp").forward(request, response);
                    }

                    break;

                case "Agregar":
                    try {
                        em.setPk_empleado(0);
                        em.setNombre(request.getParameter("txtNombre"));
                        em.setApellido(request.getParameter("txtApellido"));
                        em.setUsuario(request.getParameter("txtUsuario"));
                        em.setContrasena(request.getParameter("txtContrasena"));
                        em.setTipo(request.getParameter("opTipo"));
                        empleadoDAO.insertarEm(em);
                        request.getRequestDispatcher("Controlador?menu=Empleados&accion=Listar").forward(request, response);
                    } catch (Exception e) {
                        request.setAttribute("error", e);
                        request.getRequestDispatcher("error.jsp").forward(request, response);
                    }

                    break;
                case "Editar":
                    try {
                        RequestDispatcher restt = request.getRequestDispatcher("empleado-editar.jsp");
                        em = empleadoDAO.obtenerPorId(Integer.parseInt(request.getParameter("pk_empleado")));
                        request.setAttribute("emple", em);
                        restt.forward(request, response);
                    } catch (Exception e) {
                        request.setAttribute("error", e);
                        request.getRequestDispatcher("error.jsp").forward(request, response);
                    }
                    break;
                case "Actualizar":
                    try {
                        em.setPk_empleado(Integer.parseInt(request.getParameter("pk")));
                        em.setNombre(request.getParameter("txtNombre"));
                        em.setApellido(request.getParameter("txtApellido"));
                        em.setUsuario(request.getParameter("txtUsuario"));
                        em.setContrasena(request.getParameter("txtContrasena"));
                        em.setTipo(request.getParameter("opTipo"));
                        empleadoDAO.actualizar(em);
                        request.getRequestDispatcher("Controlador?menu=Empleados&accion=Listar").forward(request, response);
                    } catch (Exception e) {
                        request.setAttribute("error", e);
                        request.getRequestDispatcher("error.jsp").forward(request, response);
                    }
                    break;
                case "Buscar":
                    try {
                        RequestDispatcher distw = request.getRequestDispatcher("empleado.jsp");
                        List<Empleado> liss = empleadoDAO.buscarNom(request.getParameter("txtBusqueda"));
                        request.setAttribute("empleados", liss);
                        distw.forward(request, response);
                    } catch (Exception e) {
                        request.setAttribute("error", e);
                        request.getRequestDispatcher("error.jsp").forward(request, response);
                    }
                    break;
                case "Eliminar":
                    try {
                        em = empleadoDAO.obtenerPorId(Integer.parseInt(request.getParameter("pk_empleado")));
                        empleadoDAO.eliminarEm(em);
                        request.getRequestDispatcher("Controlador?menu=Empleados&accion=Listar").forward(request, response);
                    } catch (Exception e) {
                        request.setAttribute("error", e);
                        request.getRequestDispatcher("error.jsp").forward(request, response);
                    }
                    break;
                default:
                    break;

            }
        }
        // ==============================ASOCIACION===========================================================
        if (menu.equals("Asociacion")) {
            try {
                switch (accion) {
                    case "Listar":
                        RequestDispatcher asocd = request.getRequestDispatcher("asociaciones.jsp");
                        List<Provincia> listapro = proviDAO.listarProvincia();
                        request.setAttribute("lisPro", listapro);
                        List<Asociacion> list = asociacionDAO.listarAsociacion();
                        request.setAttribute("asocia", list);
                        asocd.forward(request, response);
                        break;
                    case "Agregar":
                        asoci.setPk_asociacion(0);
                        asoci.setNomAsociacion(request.getParameter("txtNombre"));
                        asoci.setRuc(request.getParameter("txtRuc"));
                        asoci.setResponsable(request.getParameter("txtResponsable"));
                        asoci.setGeolocalizacion(request.getParameter("txtGeoloc"));
                        asoci.setDireccion(request.getParameter("txtDireccion"));
                        asoci.setTelefono(request.getParameter("txtTelefono"));
                        asoci.setParroquia(request.getParameter("txtParroquia"));
                        asoci.setFk_provinciaa(request.getParameter("opProvincia"));
                        asociacionDAO.insertarAso(asoci);
                        request.getRequestDispatcher("Controlador?menu=Asociacion&accion=Listar").forward(request, response);
                        break;
                    case "Editar":
                        RequestDispatcher restt = request.getRequestDispatcher("asociacion-editar.jsp");
                        asoci = asociacionDAO.obtenerPorId(Integer.parseInt(request.getParameter("pk_asociacion")));
                        request.setAttribute("asoc", asoci);
                        //lista provincia y compara
                        List<Provincia> listaproo = proviDAO.listarProvincia();
                        request.setAttribute("lisPro", listaproo);
                        restt.forward(request, response);
                        break;
                    case "Actualizar":
                        asoci.setPk_asociacion(Integer.parseInt(request.getParameter("pk")));
                        asoci.setNomAsociacion(request.getParameter("txtNombre"));
                        asoci.setRuc(request.getParameter("txtRuc"));
                        asoci.setResponsable(request.getParameter("txtResponsable"));
                        asoci.setGeolocalizacion(request.getParameter("txtGeoloc"));
                        asoci.setDireccion(request.getParameter("txtDireccion"));
                        asoci.setTelefono(request.getParameter("txtTelefono"));
                        asoci.setParroquia(request.getParameter("txtParroquia"));
                        asoci.setFk_provinciaa(request.getParameter("opProvincia"));
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
                request.setAttribute("error", e);
                request.getRequestDispatcher("error.jsp").forward(request, response);
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
                request.setAttribute("error", e);
                request.getRequestDispatcher("error.jsp").forward(request, response);
            }
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("Hola Soy doGET..");
        doPost(request, response);
    }

}
