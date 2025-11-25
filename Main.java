import services.ClienteService;
import services.DroneService;
import services.HistoricoEntregaService;
// import classes.Cliente;
// import classes.Drone;
// import dao.ClienteDAO;
// import dao.DroneDAO;
// // import dao.AtribuicaoDAO;
// // import dao.HistoricoEntregaDAO;
// import interfaces.IAutenticacao;
// import interfaces.IEntrega;
// import interfaces.IGerenciamentoDrone;
// import sistemas.SistemaAutenticacao;



public class Main {
    public static void main(String[] args) {
        
        // 1. Inicializa os serviços
        ClienteService clienteService = new ClienteService();
        DroneService droneService = new DroneService();
        HistoricoEntregaService entregaService = new HistoricoEntregaService();

        System.out.println("=========================================");
        System.out.println("🚀 INÍCIO DO TESTE DE FLUXO DE ENTREGAS");
        System.out.println("=========================================");

        // --- A. CADASTRO DE CLIENTE (Funcionalidade 1) ---
        System.out.println("\n--- A. Teste: Cadastro de Cliente ---");
        try {
            clienteService.cadastrarCliente("José Rosa", "joser@test.com", "joser123", "Rua J, 108");
        } catch (RuntimeException e) {
            System.err.println("Falha no cadastro de cliente: " + e.getMessage());
        }

        // --- B. CADASTRO DE DRONES (Funcionalidade 2) ---
        System.out.println("\n--- B. Teste: Cadastro de Drones ---");
        try {
            // Drone 1: Alta capacidade e bateria (Adequado para pacotes grandes)
            droneService.cadastrarDrone("ALTO", 1500);
            
            // Drone 2: Média capacidade e bateria (Adequado para pacotes pequenos/médios)
            droneService.cadastrarDrone("MEDIO", 500);
            
            // Drone 3: Capacidade e bateria baixas (Será o menos adequado)
            droneService.cadastrarDrone("BAIXO", 200);

        } catch (Exception e) {
            System.err.println("Falha no cadastro de drone: " + e.getMessage());
        }
        
        int idClienteTeste = 1; // ID fictício para o cliente cadastrado

        // --- C. SOLICITAÇÃO E ATRIBUIÇÃO AUTOMÁTICA (Funcionalidade 3 & 4) ---
        System.out.println("\n--- C. Teste: Solicitação de Entrega e Atribuição ---");
        
        // C.1. Solicitação Grande (Busca o Drone #1, 1500g)
        System.out.println("\n[C.1] Solicitando pacote de 1200g:");
        try {
            entregaService.solicitarEntrega(idClienteTeste, 1200.00, "Av. Central, 50");
        } catch (RuntimeException e) {
            System.err.println("Falha na solicitação: " + e.getMessage());
        }

        // C.2. Solicitação Média (Busca o Drone #2, 500g ou #1 se #2 estiver em missão)
        System.out.println("\n[C.2] Solicitando pacote de 400g:");
        try {
            entregaService.solicitarEntrega(idClienteTeste, 400.0, "Rua B, 250");
        } catch (RuntimeException e) {
            System.err.println("Falha na solicitação: " + e.getMessage());
        }
        
        // C.3. Solicitação que Falha (Nenhum drone com capacidade > 2000g)
        System.out.println("\n[C.3] Solicitando pacote de 3000g (deve falhar):");
        try {
             // O DAO (simulado) deve retornar NULL, resultando na mensagem de erro no service.
            entregaService.solicitarEntrega(idClienteTeste, 3000.0, "Prédio Y");
        } catch (RuntimeException e) {
            System.err.println("Falha na solicitação: " + e.getMessage());
        }
        
        // --- D. VISUALIZAÇÃO DO HISTÓRICO (Funcionalidade 5) ---
        System.out.println("\n--- D. Teste: Mostrar Histórico ---");
        try {
            entregaService.mostrarHistorico(idClienteTeste);
        } catch (RuntimeException e) {
            System.err.println("Falha ao buscar histórico: " + e.getMessage());
        }
        
        System.out.println("\n=========================================");
        System.out.println("✅ TESTE DE FLUXO CONCLUÍDO");
        System.out.println("=========================================");
    }
}
