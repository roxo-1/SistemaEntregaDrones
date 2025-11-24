package classes;
public class Atribuicao {
    protected int idAtribuicao;
    protected int idCliente;     // FK para Cliente
    protected int idDrone;        // FK para Drone
    protected int capacidadeCarga; // Estado do drone no momento da atribuição
    protected String statusBateria; // Estado do drone no momento da atribuição

    // Construtores
    // public Atribuicao() {}
    public Atribuicao(int idCliente, int idDrone, int capacidadeCarga, String statusBateria) {
        this.idAtribuicao = idAtribuicao;
        this.idCliente = idCliente;
        this.idDrone = idDrone;
        this.capacidadeCarga = capacidadeCarga; 
        this.statusBateria = statusBateria;
    }
    //Getters e Setters
    public void atribuirDrone(int idCliente, double peso) {
        System.out.println("Drone atribuído automaticamente ao cliente " + idCliente);
    }
}