package dao;

import classes.Atribuicao;
import database.ConexaoBD;
import java.sql.*;

public class AtribuicaoDAO {
    public void salvar(Atribuicao a) {
        String sql = "INSERT INTO Atribuicao (idCliente, idDrone, capacidadeCarga, statusBateria) VALUES (?, ?, ?, ?)";
        try (Connection conn = ConexaoBD.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, a.getIdCliente());
            stmt.setInt(2, a.getIdDrone());
            stmt.setDouble(3, a.getCapacidadeCarga());
            stmt.setString(4, a.getStatusBateria());
            stmt.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao salvar atribuição", e);
        }
    }
}


