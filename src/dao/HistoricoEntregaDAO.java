package dao;

import java.util.List;
import java.util.ArrayList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import classes.HistoricoEntrega;
import database.ConexaoBD;


public class HistoricoEntregaDAO {

    public void registrar(HistoricoEntrega h) {
        String sql = "INSERT INTO HistoricoEntrega (idDrone, idCliente) VALUES (?, ?)";
        try (Connection conn = ConexaoBD.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, h.getIdDrone());
            stmt.setInt(2, h.getIdCliente());
            stmt.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao registrar histórico", e);
        }
    }
    

    public List<HistoricoEntrega> buscarPorCliente(int idCliente) {
        String sql = "SELECT * FROM HistoricoEntrega WHERE idCliente = ?";
        List<HistoricoEntrega> lista = new ArrayList<>();
        try (Connection conn = ConexaoBD.conectar();
        PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setInt(1, idCliente);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            HistoricoEntrega h = new HistoricoEntrega();
            h.setIdDrone(rs.getInt("idDrone"));
            h.setIdCliente(rs.getInt("idCliente"));
            lista.add(h);
        }
        } catch (Exception e) {
            throw new RuntimeException("Erro ao consultar histórico", e);
        }
        return lista;
    }
}
