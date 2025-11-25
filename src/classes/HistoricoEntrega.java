// package classes;
// import java.util.List;
// import dao.HistoricoEntregaDAO;

// public class HistoricoEntrega {
//     protected int idHistorico;
//     protected int idDrone;
//     protected int idCliente;
    
//     public HistoricoEntrega(int idHistorico, int idDrone, int idCliente) {
//         this.idHistorico = idHistorico;
//         this.idDrone = idDrone;
//         this.idCliente = idCliente;
//     }
//     public HistoricoEntrega(int idDrone, int idCliente) {
//         this.idDrone = idDrone;
//         this.idCliente = idCliente;
//     }
//     public HistoricoEntrega(){}

//     public int getIdDrone() { return idDrone; }
//     public int getIdCliente() { return idCliente; }
//     public int getIdHistorico(){return idHistorico; }
//     public void setIdDrone(int idDrone) { this.idDrone = idDrone;}
//     public void setIdCliente(int idCliente) {this.idCliente = idCliente;}
//     // Construtores, Getters e Setters
//     public void registrarEntrega() {
//         HistoricoEntregaDAO dao = new HistoricoEntregaDAO();
//         HistoricoEntrega h = new HistoricoEntrega();
//         dao.registrar(h); // salva no banco de dados
//         System.out.println("Entrega registrada. Cliente: " + idCliente + " | Drone: " + idDrone);
//     }

package classes;

// import java.util.List;

// import dao.HistoricoEntregaDAO;

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
    // Construtores, Getters e Setters
    // public void registrarEntrega() {
    //     HistoricoEntregaDAO dao = new HistoricoEntregaDAO();
    //     HistoricoEntrega h = new HistoricoEntrega();
    //     dao.registrar(h); // salva no banco de dados
    //     System.out.println("Entrega registrada. Cliente: " + idCliente + " | Drone: " + idDrone);
    // }

    // @Override
    // public void mostrarHistorico(int idCliente) {
    //     HistoricoEntregaDAO dao = new HistoricoEntregaDAO();
    //     List<HistoricoEntrega> lista = dao.buscarPorCliente(idCliente);

    //     if (lista.isEmpty()) {
    //         System.out.println("Nenhuma entrega encontrada para o cliente " + idCliente);
    //         return;
    //     }

    //     System.out.println("=== Histórico de Entregas do Cliente " + idCliente + " ===");
    //     for (HistoricoEntrega h : lista) {
    //         System.out.println("Drone: " + h.getIdDrone());
    //     }
    // }
}