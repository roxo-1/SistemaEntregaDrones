package classes;
// import interfaces.IGerenciamentoDrone;
// import dao.DroneDAO;
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
    // @Override
    // public void cadastrarDrone(int idDrone, String statusBateria, int capacidadeCarga) throws Exception{
    //     Drone d = new Drone(idDrone, statusBateria, capacidadeCarga);
    //     try {
    //         new DroneDAO().cadastrarDrone(d);
    //     } catch (Exception e) {
    //         throw new Exception("Erro ao tentar cadastrar o drone: " + e.getMessage(), e);
    //     }
    //     new DroneDAO().cadastrarDrone(d);
    // }

    // @Override
    // public void cadastrarDrone(String statusBateria, int capacidadeCarga) {
    //     Drone novoDrone = new Drone(statusBateria, capacidadeCarga);
        
    //     try {
    //         new DroneDAO().cadastrarDrone(novoDrone);
    //         this.statusBateria = novoDrone.getStatusBateria();
    //         this.capacidadeCarga = novoDrone.getCapacidadeCarga();
    //         System.out.println("Drone cadastrado com sucesso!");
    //     } catch (Exception e) {
    //         // Transforma a exceção checada do DAO em uma não checada.
    //         throw new RuntimeException("Erro ao cadastrar drone: ", e);
    //     }
    // }

