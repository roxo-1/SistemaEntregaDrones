package classes;

// import dao.AtribuicaoDAO;

public class Atribuicao {
    protected int idAtribuicao;
    protected int idCliente;     // FK para Cliente
    protected int idDrone;        // FK para Drone
    protected int capacidadeCarga; // Estado do drone no momento da atribuição
    protected String statusBateria; // Estado do drone no momento da atribuição

    // Construtores
    public Atribuicao() {}
    public Atribuicao(int idCliente, int idDrone, String statusBateria) {
        this.idCliente = idCliente;
        this.idDrone = idDrone;
        this.capacidadeCarga = 0; 
        this.statusBateria = statusBateria;
    }
    public int getIdCliente() { return idCliente; }
    public int getIdDrone() { return idDrone; }
    public double getCapacidadeCarga() { return capacidadeCarga; }
    public String getStatusBateria() { return statusBateria; }
}

