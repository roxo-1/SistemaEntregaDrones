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
    //Getters e Setters
    // public void atribuirDrone(int idCliente, int capacidadeCarga, String statusBateria) {
    //     Drone droneDAO = new Drone();
    //     AtribuicaoDAO atribDAO = new AtribuicaoDAO();
    //     Drone drone = droneDAO.buscarDroneDisponivel(capacidadeCarga);
    //     if (drone == null) {
    //         System.out.println("Nenhum drone disponível para esse peso (" + capacidadeCarga + ")");
    //         return;
    //     }
    //     Atribuicao atribuicao = new Atribuicao(idCliente, drone.getIdDrone(), drone.getStatusBateria());
    //     atribDAO.salvar(atribuicao);
    //     System.out.println("Drone " + drone.getIdDrone() + " atribuído ao cliente " + idCliente + " e salvo no banco de dados.");
    // }

