package dao;

import classes.Cliente;
import database.ConexaoBD;

import java.sql.*;

public class ClienteDAO {

    public void cadastrar(Cliente c) {
        String sql = "INSERT INTO Cliente (nome, email, senha, endereco) VALUES (?, ?, ?, ?)";

        try (Connection conn = ConexaoBD.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, c.getNome());
            stmt.setString(2, c.getEmail());
            stmt.setString(3, c.getSenhaHash());
            stmt.setString(4, c.getEndereco());
            stmt.executeUpdate();

        } catch (Exception e) { // agora captura Exception genérica
            throw new RuntimeException("Erro ao cadastrar cliente.", e);
        }
    }
}
