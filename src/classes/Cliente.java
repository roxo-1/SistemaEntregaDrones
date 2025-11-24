package classes;

import java.util.List;
import interfaces.IAutenticacao;
import interfaces.IEntrega;
import sistemas.SistemaAutenticacao;
import dao.AtribuicaoDAO;
import dao.HistoricoEntregaDAO;

public class Cliente implements IAutenticacao, IEntrega {

    private int idCliente;
    private String nome;
    private String email;
    private String senha;
    private String endereco;


    public Cliente(){}
    public Cliente(int idCliente, String nome, String email, String senha, String endereco) {
        this.idCliente = idCliente;
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

    @Override
    public boolean login(String email, String senha) {
        if(this.email.equals(email) && this.senha.equals(senha)) {
            System.out.println("Login realizado com sucesso: " + nome);
            return true;
        }
        System.out.println("Falha no login.");
        return false;
    }

    @Override
    public void finalizarSessao() {
        SistemaAutenticacao auth = new SistemaAutenticacao();
        auth.encerrarSessao(this.idCliente);
    }

    @Override
    public void solicitarEntrega(int idCliente, double capacidadeCarga, String destino) {
        Drone droneDAO = new Drone();
        Drone droneDisponivel = droneDAO.buscarDroneDisponivel((int)capacidadeCarga);
        if (droneDisponivel == null) {
            System.out.println("Nenhum drone disponível para capacidadeCarga " + capacidadeCarga);
            return;
        }
        // Criar atribuição e salvar no BD
        Atribuicao atribuicao = new Atribuicao(this.getIdCliente(),droneDisponivel.getIdDrone(), droneDisponivel.getStatusBateria());
        AtribuicaoDAO atribDAO = new AtribuicaoDAO();
        atribDAO.salvar(atribuicao);
        // Registrar histórico automaticamente
        HistoricoEntrega historico = new HistoricoEntrega(droneDisponivel.getIdDrone(), this.getIdCliente());
        HistoricoEntregaDAO histDAO = new HistoricoEntregaDAO();
        histDAO.registrar(historico);
        System.out.println("Entrega registrada no banco para cliente " + idCliente);
    }

    @Override
    public void mostrarHistorico(int idCliente) {
        HistoricoEntregaDAO dao = new HistoricoEntregaDAO();
        List<HistoricoEntrega> lista = dao.buscarPorCliente(idCliente);

        if (lista.isEmpty()) {
            System.out.println("Nenhuma entrega encontrada para o cliente " + idCliente);
            return;
        }

        System.out.println("=== Histórico de Entregas do Cliente " + idCliente + " ===");
        for (HistoricoEntrega h : lista) {
            System.out.println("Drone: " + h.getIdDrone());
        }
    }
}
