package classes;
import interfaces.IGerenciamentoDrone;
public class Drones {
    protected int idDrone;
    private String statusBateria;
    private int capacidadeCarga;

    // Construtores
    public Drones() {}

    public Drones(String statusBateria, int capacidadeCarga) {
        this.statusBateria = statusBateria;
        this.capacidadeCarga = capacidadeCarga;
    }

    @Override
    public void cadastrarDrone(int id, String statusBateria, int capacidadeCarga) {
        System.out.println("Drone cadastrado: ID=" + id + ", Bateria=" + statusBateria);
    }

    @Override
    public void atualizarStatus(int id, String novoStatus) {
        this.statusBateria = novoStatus;
        System.out.println("Drone " + id + " atualizado para status: " + novoStatus);
    }
}