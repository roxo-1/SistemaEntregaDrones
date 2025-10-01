package classes;
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

    // Getters e Setters
    public int getId_drone() { return id_drone; }
    public void setId_drone(int id_drone) { this.id_drone = id_drone; }
    public String getstatusBateria() { return statusBateria; }
    public void setstatusBateria(String statusBateria) { this.statusBateria = statusBateria; }
    public int getcapacidadeCarga() { return capacidadeCarga; }
    public void setcapacidadeCarga(int capacidadeCarga) { this.capacidadeCarga = capacidadeCarga; }
}