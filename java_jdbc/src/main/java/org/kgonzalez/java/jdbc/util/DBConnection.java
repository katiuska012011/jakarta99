package org.kgonzalez.java.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Objects;

public class DBConnection {
    private static String url = "jdbc:mysql://localhost:3306/java_curso";
    private static String username= "root";
    private static String pass="Sigef0101@";

    private static Connection connection;

    public static Connection getInstance() throws SQLException {
        if(Objects.isNull(connection)){
            connection = DriverManager.getConnection(url, username, pass);
        }
        return connection;
    }

}
