package classes;

import interfaces.IAutenticacao;
import interfaces.IEntrega;

public class Cliente implements IAutenticacao, IEntrega {

    private int idCliente;
    private String nome;
    private String email;
    private String senha;
    private String endereco;

    public Cliente(int idCliente, String nome, String email, String senha, String endereco) {
        this.idCliente = idCliente;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.endereco = endereco;
    }

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
        System.out.println("Sessão encerrada para o cliente " + nome);
    }

    @Override
    public void solicitarEntrega(int idCliente, double peso, String destino) {
        System.out.println("Solicitação de entrega criada pelo cliente " + idCliente +
                           " -> Peso: " + peso + "kg | Destino: " + destino);
    }

    @Override
    public void mostrarHistorico(int idCliente) {
        System.out.println("Exibindo histórico do cliente " + idCliente);
    }
}
