package classes;

import dao.HistoricoEntregaDAO;

public class HistoricoEntrega {
    protected int idHistorico;
    protected int idDrone;
    protected int idCliente;
    
    public HistoricoEntrega(int idHistorico, int idDrone, int idCliente) {
        this.idHistorico = idHistorico;
        this.idDrone = idDrone;
        this.idCliente = idCliente;
    }
    public HistoricoEntrega(int idDrone, int idCliente) {
        this.idDrone = idDrone;
        this.idCliente = idCliente;
    }
    public HistoricoEntrega(){}

    public int getIdDrone() { return idDrone; }
    public int getIdCliente() { return idCliente; }
    public int getIdHistorico(){return idHistorico; }
    public void setIdDrone(int idDrone) { this.idDrone = idDrone;}
    public void setIdCliente(int idCliente) {this.idCliente = idCliente;}
    // Construtores, Getters e Setters
    public void registrarEntrega() {
        HistoricoEntregaDAO dao = new HistoricoEntregaDAO();
        HistoricoEntrega h = new HistoricoEntrega();
        dao.registrar(h); // salva no banco de dados
        System.out.println("Entrega registrada. Cliente: " + idCliente + " | Drone: " + idDrone);
    }
    
    
}