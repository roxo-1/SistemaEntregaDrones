package services;

import classes.Drone;
import dao.DroneDAO;

public class DroneService {

    private final DroneDAO droneDAO;

    public DroneService() {
        // Inicializa o DAO uma única vez no construtor
        this.droneDAO = new DroneDAO();
    }
    
    
    public void cadastrarDrone(String statusBateria, int capacidadeCarga) throws Exception{
        Drone d = new Drone(statusBateria, capacidadeCarga);
        try {
            new DroneDAO().cadastrarDrone(d);
            System.out.println("Drones Cadastrados!");
        } catch (Exception e) {
            throw new Exception("Erro ao tentar cadastrar o drone: " + e.getMessage(), e);
        }
    }
}