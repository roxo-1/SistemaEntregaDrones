import classes.Cliente;
import classes.Drone;
import dao.ClienteDAO;
import dao.DroneDAO;
// import dao.AtribuicaoDAO;
// import dao.HistoricoEntregaDAO;

public class Main {

    public static void main(String[] args) {

        System.out.println("=== TESTE DO SISTEMA DE DRONES ===");

        // ==============================
        // 1) Criar cliente e salvar no BD
        // ==============================
        Cliente c1 = new Cliente(0, "João", "joao@gmail.com", "123", "Rua A");
        ClienteDAO clienteDAO = new ClienteDAO();
        clienteDAO.cadastrar(c1);

        System.out.println("Cliente cadastrado!");

        // ==============================
        // 2) Criar drone e salvar
        // ==============================
        Drone d1 = new Drone("100%", 20);
        DroneDAO droneDAO = new DroneDAO();
        try {
            // A linha que pode falhar
            droneDAO.cadastrarDrone(d1); 
            
            // Esta linha só é executada se o cadastro for bem-sucedido
            System.out.println("Drone cadastrado!"); 
            
        } catch (Exception e) {
            // Captura qualquer exceção lançada pelo método cadastrarDrone
            System.err.println("❌ Erro ao cadastrar o drone: " + e.getMessage());
            e.printStackTrace(); // Imprime o rastreamento completo da exceção para debug
        }

        // ==============================
        // 3) Atribuir entrega (cliente -> drone)
        // ==============================
        c1.solicitarEntrega(c1.getIdCliente(), 10, "Av. Brasil");

        // ==============================
        // 4) Mostrar histórico
        // ==============================
        c1.mostrarHistorico(c1.getIdCliente());

        System.out.println("=== FIM DOS TESTES ===");
    }
}
