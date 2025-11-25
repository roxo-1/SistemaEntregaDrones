package classes;
public class Drone{
    protected int idDrone;
    private String statusBateria;
    private int capacidadeCarga;

    public Drone(){}
    public Drone(int idDrone, String statusBateria, int capacidadeCarga) {
        this.idDrone = idDrone;
        this.statusBateria = statusBateria;
        this.capacidadeCarga = capacidadeCarga;
    }
    public Drone(String statusBateria, int capacidadeCarga) {
        this.statusBateria = statusBateria;
        this.capacidadeCarga = capacidadeCarga;
    }

    public int getIdDrone() { return idDrone; }
    public String getStatusBateria() { return statusBateria; }
    public int getCapacidadeCarga() { return capacidadeCarga; }
}