package classes;
public class HistoricoEntrega {
    protected int idHistorico;
    protected int idDrone;
    protected int idCliente;
    
    public HistoricoEntrega() {}
    public HistoricoEntrega(int idDrone, int idCliente) {
        this.idDrone = idDrone;
        this.idCliente = idCliente;
    }
    // Construtores, Getters e Setters

    public int getIdHistorico() { return idHistorico; }
    @SuppressWarnings("unused")
    private void setIdHistorico(int idHistorico) { 
        this.idHistorico = idHistorico;
     }
    public int getIdDrone(){ return idDrone; }
    public int getIdCliente() { return idCliente; }
    
    
}