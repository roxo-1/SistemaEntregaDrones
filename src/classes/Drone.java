package classes;
import interfaces.IGerenciamentoDrone;
public class Drones implements IGerenciamentoDrone {
    protected int idDrone;
    private String statusBateria;
    private int capacidadeCarga;

    // Construtores
    public Drones() {}

    public Drones(String statusBateria, int capacidadeCarga) {
        this.idDrone = idDrone;
        this.statusBateria = statusBateria;
        this.capacidadeCarga = capacidadeCarga;
    }
    public int getIdDrone() { return idDrone; }
    public String getStatusBateria() { return statusBateria; }
    public int getCapacidadeCarga() { return capacidadeCarga; }

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