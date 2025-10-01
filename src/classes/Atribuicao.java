package classes;
public class Atribuicao {
    protected int idAtribuicao;
    protected int idCliente;     // FK para Cliente
    protected int idDrone;        // FK para Drone
    protected int capacidadeCarga; // Estado do drone no momento da atribuição
    protected String statusBateria; // Estado do drone no momento da atribuição

    // Construtores
    public Atribuicao() {}
    public Atribuicao(int idCliente, int idDrone, int capacidadeCarga, String statusBateria) {
        this.idCliente = idCliente;
        this.idDrone = idDrone;
        this.capacidadeCarga = capacidadeCarga; 
        this.statusBateria = statusBateria;
    }
    //Getters e Setters
    public int getIdAtribuicao() { return idAtribuicao; }
    public void setIdAtribuicao(int idAtribuicao) { this.idAtribuicao = idAtribuicao; }
    public Int getCapacidadeCarga() {return capacidadeCarga;}
    public void setCapacidadeCarga(int capacidadeCarga) { this.capacidadeCarga = capacidadeCarga; }
    public String getStatusBateria() {return statusBateria;}
    public void setStatusBateria(String statusBateria) { this.statusBateria = statusBateria; }
    public int getIdDrone(){ return idDrone; }
    public int getIdCliente() { return idCliente; }
}