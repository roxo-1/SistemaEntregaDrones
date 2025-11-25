package classes;

public class HistoricoEntrega {
    protected int idHistorico;
    protected int idDrone;
    protected int idCliente;
    public String destino;
    public Double peso;
    
    public HistoricoEntrega(int idHistorico, int idDrone, int idCliente, String destino, Double peso) {
        this.idHistorico = idHistorico;
        this.idDrone = idDrone;
        this.idCliente = idCliente;
        this.destino = destino;
        this.peso = peso;
    }
    public HistoricoEntrega(int idDrone, int idCliente,String destino, Double peso) {
        this.idDrone = idDrone;
        this.idCliente = idCliente;
        this.destino = destino;
        this.peso = peso;
    }
    public HistoricoEntrega(){}

    public int getIdDrone() { return idDrone; }
    public int getIdCliente() { return idCliente; }
    public String getDestino() { return destino; }
    public Double getPeso() { return peso; }
    public int getIdHistorico(){return idHistorico; }
    public void setIdDrone(int idDrone) { this.idDrone = idDrone;}
    public void setIdCliente(int idCliente) {this.idCliente = idCliente;}
    public String setDestino() { return destino; }
    public Double setPeso() { return peso; }
}