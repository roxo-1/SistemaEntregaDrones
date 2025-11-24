package interfaces;

import classes.Drone;

public interface IGerenciamentoDrone {
    void atualizarStatus(int idDrone, String novoStatus); 
    void cadastrarDrone(String statusBateria, int capacidadeCarga);
    Drone buscarDroneDisponivel(int capacidadeCarga);
}
