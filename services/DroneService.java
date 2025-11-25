package services;

import classes.Drone;
import dao.DroneDAO;
// import java.sql.SQLException;
// import interfaces.IGerenciamentoDrone;
// import dao.DroneDAO;

public class DroneService {

    private final DroneDAO droneDAO;

    public DroneService() {
        // Inicializa o DAO uma única vez no construtor
        this.droneDAO = new DroneDAO();
    }

    // /**
    //  * @funcionalidade Cadastro de Drones
    //  */
    // public void cadastrarDrone(String statusBateria, int capacidadeCarga) {
    //     // ID é 0 (será gerado pelo BD)
    //     Drone novoDrone = new Drone(statusBateria, capacidadeCarga); 
        
    //     try {
    //         // Delega a persistência ao DAO
    //         droneDAO.cadastrarDrone(novoDrone); 
    //         // Os atributos 'this.statusBateria' e 'this.capacidadeCarga' não pertencem aqui.
    //         System.out.println("✅ Drone cadastrado com sucesso!");
    //     } catch (SQLException e) {
    //         // Transforma a exceção checada em RuntimeException
    //         throw new RuntimeException("❌ Erro ao cadastrar drone: " + e.getMessage(), e);
    //     }
    // }
    
    
    public void cadastrarDrone(String statusBateria, int capacidadeCarga) throws Exception{
        Drone d = new Drone(statusBateria, capacidadeCarga);
        try {
            new DroneDAO().cadastrarDrone(d);
        } catch (Exception e) {
            throw new Exception("Erro ao tentar cadastrar o drone: " + e.getMessage(), e);
        }
        new DroneDAO().cadastrarDrone(d);
    }
}