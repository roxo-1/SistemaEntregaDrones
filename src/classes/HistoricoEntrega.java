package classes;
public class HistoricoEntrega {
    protected int idHistorico;
    protected int idDrone;
    protected int idCliente;
    
    public HistoricoEntrega(int idDrone, int idCliente) {
        this.idHistorico = idHistorico;
        this.idDrone = idDrone;
        this.idCliente = idCliente;
    }
    // Construtores, Getters e Setters
    public void registrarEntrega() {
        System.out.println("Entrega registrada. Cliente: " + idCliente + " | Drone: " + idDrone);
    }
    
    
}