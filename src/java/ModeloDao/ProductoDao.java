package ModeloDao;

import Modelo.Empleado;
import Modelo.Producto;
import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductoDao {

    private Conexion con;
    private Connection connection;

    public ProductoDao(String jdbcURL, String jdbcUsername, String jdbcPassword) throws SQLException {
        System.out.println(jdbcURL);
        con = new Conexion(jdbcURL, jdbcUsername, jdbcPassword);
    }

    
    // listar todos las asociaciones
    public List<Producto> listarProducto() throws SQLException {
        List<Producto> listarProd = new ArrayList<Producto>();
        String sql = "SELECT * FROM producto ";
        con.conectar();
        connection = con.getJdbcConnection();
        Statement statement = connection.createStatement();
        ResultSet res = statement.executeQuery(sql);

        while (res.next()) {
            int pk = res.getInt("pk_producto");
            String nom = res.getString("nomInsumos");
            String can = res.getString("stock");
            String tip = res.getString("tipoInsumo");
            Producto producto = new Producto(pk, nom, can, tip);
            listarProd.add(producto);
        }
        con.desconectar();
        return listarProd;
    }

     // Insertar Empleado
    public boolean insertarPro(Producto pro) throws SQLException {
        String sql = "INSERT INTO producto (pk_producto, nomInsumoS, stock, tipoInsumo) "
                + " VALUES (?,?,?,?)";
        System.out.println(pro.getNomInsumos());
        con.conectar();
        connection = con.getJdbcConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, null);
        statement.setString(2, pro.getNomInsumos());
        statement.setString(3, pro.getStock());
        statement.setString(4, pro.getTipoInsumo());

        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        con.desconectar();
        return rowInserted;
    }

    // Obtener por PK
    public Producto obtenerPorId(int pk_pro) throws SQLException {
        Producto pro = null;

        String sql = "SELECT * FROM producto WHERE pk_producto= ? ";
        con.conectar();
        connection = con.getJdbcConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, pk_pro);
        ResultSet res = statement.executeQuery();
        if (res.next()) {
            pro = new Producto(
                    res.getInt("pk_producto"),
                    res.getString("nomInsumo"),
                    res.getString("stock"),
                    res.getString("tipoInsumo")
            );
        }
        res.close();
        con.desconectar();
        return pro;
    }
//eliminar

    public boolean eliminarPro(Producto pro) throws SQLException {
        boolean rowEliminar = false;
        String sql = "DELETE FROM producto WHERE pk_producto=?";
        con.conectar();
        connection = con.getJdbcConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, pro.getPk_producto());
        rowEliminar = statement.executeUpdate() > 0;
        statement.close();
        con.desconectar();
        return rowEliminar;
    }
}
