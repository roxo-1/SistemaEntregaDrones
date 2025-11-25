package classes;

// import java.util.List;
// import interfaces.IAutenticacao;
// import interfaces.IEntrega;
// import sistemas.SistemaAutenticacao;
// import dao.AtribuicaoDAO;
// import dao.HistoricoEntregaDAO;

public class Cliente{

    private int idCliente;
    private String nome;
    private String email;
    private String senha;
    private String endereco;


    public Cliente(){}
    public Cliente(String nome, String email, String senha, String endereco) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.endereco = endereco;
    }

    public int getIdCliente() { return idCliente; }
    public String getNome() { return nome; }
    public String getEmail() { return email; }
    public String getSenhaHash() { return senha; }
    public String getEndereco() { return endereco; }
}
    // @Override
    // public void solicitarEntrega(int idCliente, double capacidadeCarga, String destino) {
    //     Drone droneDAO = new Drone();
    //     Drone droneDisponivel = droneDAO.buscarDroneDisponivel((int)capacidadeCarga);
    //     if (droneDisponivel == null) {
    //         System.out.println("Nenhum drone disponível para capacidadeCarga " + capacidadeCarga);
    //         return;
    //     }
    //     // Criar atribuição e salvar no BD
    //     Atribuicao atribuicao = new Atribuicao(this.getIdCliente(),droneDisponivel.getIdDrone(), droneDisponivel.getStatusBateria());
    //     AtribuicaoDAO atribDAO = new AtribuicaoDAO();
    //     atribDAO.salvar(atribuicao);
    //     // Registrar histórico automaticamente
    //     HistoricoEntrega historico = new HistoricoEntrega(droneDisponivel.getIdDrone(), this.getIdCliente());
    //     HistoricoEntregaDAO histDAO = new HistoricoEntregaDAO();
    //     histDAO.registrar(historico);
    //     System.out.println("Entrega registrada no banco para cliente " + idCliente);
    // }
