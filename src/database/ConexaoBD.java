package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBD {

    // private static final String URL  = "jdbc:mysql://localhost:3306/dronesdb";
    // private static final String USER = "root";
    // private static final String PASS = "senha";

    // public static Connection conectar() {
    //     try {
    //         return DriverManager.getConnection(URL, USER, PASS);
    //     } catch (Exception e) {
    //         throw new RuntimeException("Erro ao conectar ao banco.", e);
    //     }
    // }

    public static Connection conectar() throws Exception {
        String url = "jdbc:mysql://localhost:3306/database";
        String user = "root";
        String pass = "senha123";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(url, user, pass);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao conectar ao banco.", e);
        }
    }
}
