package org.kgonzalez.java.jdbc.repositorio;

import org.kgonzalez.java.jdbc.models.Producto;
import org.kgonzalez.java.jdbc.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductoRepositorioImpl implements  Repositorio<Producto>{

    private Connection getConnection() throws SQLException {
        return DBConnection.getInstance();
    }
    @Override
    public List<Producto> listar() {
        List<Producto> productos = new ArrayList<>();

        Producto producto = new Producto();
        try(Statement st = getConnection().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM productos")){
            while (rs.next()){
                 producto = getProducto(producto, rs);
                productos.add(producto);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return productos;
    }

    @Override
    public Producto porId(Long id) {

        Producto producto = null;
        try(PreparedStatement st = getConnection().prepareStatement("SELECT * FROM productos WHERE id = ?")){
            st.setLong(1, id);
            ResultSet rs = st.executeQuery();
            if(rs.next()){
                producto = getProducto(producto, rs);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return producto;
    }

    @Override
    public void guardar(Producto producto) {

    }

    @Override
    public void eliminar(Long id) {

    }

    private static Producto getProducto(Producto producto, ResultSet rs) throws SQLException {
        producto = new Producto(rs.getLong("id"), rs.getString("nombre"),
                rs.getBigDecimal("precio"),
                rs.getDate("fecha_registro"));
        return producto;
    }
}
