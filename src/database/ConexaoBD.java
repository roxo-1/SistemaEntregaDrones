package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBD {

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
