package services;
import classes.Atribuicao;
import classes.Drone;
import classes.HistoricoEntrega;
import dao.AtribuicaoDAO;
import dao.DroneDAO;
import dao.HistoricoEntregaDAO;
import java.util.List;

public class HistoricoEntregaService {
    private final DroneDAO droneDAO;
    private final AtribuicaoDAO atribDAO;
    private final HistoricoEntregaDAO histDAO;

    public HistoricoEntregaService() {
        this.droneDAO = new DroneDAO();
        this.atribDAO = new AtribuicaoDAO();
        this.histDAO = new HistoricoEntregaDAO();
    }

    
    public void solicitarEntrega(int idCliente, double pesoPacote, String destino) {
        int capacidadeCarga = (int) pesoPacote;
        
        try {
            // 1. Buscar o Drone Mais Adequado (Atribuição Automática)
            Drone droneDisponivel = droneDAO.buscarDroneDisponivel(capacidadeCarga); 
            
            if (droneDisponivel == null) {
                System.out.println("Nenhum drone disponível para esse peso (" + capacidadeCarga + ")");
                return;
            }

            // 2. Registrar a Atribuição (Necessário para a lógica do sistema)
            Atribuicao atribuicao = new Atribuicao(idCliente, droneDisponivel.getIdDrone(), droneDisponivel.getStatusBateria());
            atribDAO.salvar(atribuicao);
            System.out.println("Drone " + droneDisponivel.getIdDrone() + " atribuído ao cliente " + idCliente);

            // 3. Registrar o Histórico (Cria o registro da nova entrega)
            HistoricoEntrega historico = new HistoricoEntrega(droneDisponivel.getIdDrone(), idCliente, destino, pesoPacote);
            histDAO.registrar(historico);
            
            System.out.println("Entrega registrada no histórico para cliente " + idCliente);
            
        } catch (Exception e) { 
            // Envolve a checked exception em uma unchecked para a camada superior.
            throw new RuntimeException("Erro no processo de Solicitação/Atribuição (DB): " + e.getMessage(), e);
        }
    }


    public void mostrarHistorico(int idCliente) {
        // Note: A responsabilidade de exibição (System.out.println) pode ser movida para a camada View/Main
        // Aqui, focamos em obter os dados.
        
        List<HistoricoEntrega> lista = histDAO.buscarPorCliente(idCliente);

        if (lista.isEmpty()) {
            System.out.println("Nenhuma entrega encontrada para o cliente " + idCliente);
            return;
        }

        System.out.println("\n=== Histórico de Entregas do Cliente " + idCliente + " ===");
        for (HistoricoEntrega h : lista) {
            // Usamos o toString da entidade HistoricoEntrega para uma exibição completa
            System.out.println("→ ID Drone: " + h.getIdDrone() + " | ID Cliente: " + h.getIdCliente());
        }
    }
}
