package org.kgonzalez.java.jdbc;

import com.mysql.jdbc.Driver;
import org.kgonzalez.java.jdbc.models.Producto;
import org.kgonzalez.java.jdbc.repositorio.ProductoRepositorioImpl;
import org.kgonzalez.java.jdbc.repositorio.Repositorio;
import org.kgonzalez.java.jdbc.util.DBConnection;

import java.sql.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        try ( Connection conn =  DBConnection.getInstance()){
            Repositorio<Producto> repositorio = new ProductoRepositorioImpl();
            repositorio.listar().forEach(System.out::println);
            System.out.println(repositorio.porId(1L));
        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }
}