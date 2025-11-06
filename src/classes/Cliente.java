package classes;
import interfaces.IAutenticacao;
import interfaces.IEntrega;
public class Cliente implements IAutenticacao, IEntrega {
    protected int idCliente;
    private String nome;
    private String email;
    private String senha;
    protected String endereco;

    public Cliente(String nome, String email, String senha, String endereco) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.endereco = endereco;
    }

    @Override
    public boolean login(String nome, String email, String senha, String endereco) {
        System.out.println("Cliente autenticado: " + nome);
        return true;
    }

    @Override
    public void finalizarSessao() {
        System.out.println("Sessão encerrada para o cliente " + nome);
    }

    @Override
    public void solicitarEntrega(int idCliente, double peso, String destino) {
        System.out.println("Solicitação de entrega criada pelo cliente " + idCliente +
                           " para destino: " + destino);
    }

    @Override
    public void mostrarHistorico(int idCliente) {
        System.out.println("Exibindo histórico de entregas do cliente " + idCliente);
    }
}