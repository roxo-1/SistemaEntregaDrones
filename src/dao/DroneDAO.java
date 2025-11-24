package dao;

import classes.Drone;
import database.ConexaoBD;

import java.sql.*;

public class DroneDAO {

    public DroneDAO() {}

    public void cadastrarDrone(Drone drone) throws Exception {
        String sql = "INSERT INTO Drone (statusBateria, capacidadeCarga) VALUES (?, ?)";
        
        try (Connection conn = ConexaoBD.conectar();
             // RETURN_GENERATED_KEYS é importante para recuperar o ID gerado pelo banco
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            
            // Define os valores para a query
            stmt.setString(1, drone.getStatusBateria());
            stmt.setInt(2, drone.getCapacidadeCarga());
            
            int linhasAfetadas = stmt.executeUpdate();
            
            if (linhasAfetadas > 0) {
                // Se um ID foi gerado, recuperamos e setamos no objeto Drone
                // try (ResultSet rs = stmt.getGeneratedKeys()) {
                //     if (rs.next()) {
                //         drone.getIdDrone(rs.getInt(1));
                //     }
                // }
            }
            
        } catch (Exception e) {
            throw new RuntimeException("Erro ao cadastrar drone: " + e.getMessage(), e);
        }
    }
    
    public Drone buscarDroneDisponivel(int capacidadeCarga) throws Exception{
        String sql = "SELECT idDrone, statusBateria, capacidadeCarga FROM Drone WHERE capacidadeCarga >= ? AND statusBateria = 'DISPONIVEL' LIMIT 1";
        try (Connection conn = ConexaoBD.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, capacidadeCarga);
            
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Drone(
                        rs.getInt("idDrone"),
                        rs.getString("statusBateria"),
                        rs.getInt("capacidadeCarga")
                    );
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar drone disponível: " + e.getMessage(), e);
        }
        return null;
    }


    public void atualizarStatus(int idDrone, String novoStatusBateria) throws Exception {
        String sql = "UPDATE Drone SET statusBateria = ? WHERE idDrone = ?";
        try (Connection conn = ConexaoBD.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, novoStatusBateria);
            stmt.setInt(2, idDrone);
            
            stmt.executeUpdate();
            
        } catch (Exception e) {
            throw new RuntimeException("Erro ao atualizar status do drone: " + e.getMessage(), e);
        }
    }
}