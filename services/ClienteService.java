package services;

import classes.Cliente;
import dao.ClienteDAO;
public class ClienteService {

    private final ClienteDAO clienteDAO;

    public ClienteService() {
        this.clienteDAO = new ClienteDAO();
    }

    /**
     * @funcionalidade Cadastro de Clientes
     */
    public void cadastrarCliente(String nome, String email, String senha, String endereco) {
        // 1. Lógica de Validação (Opcional, mas recomendado)
        if (senha == null || senha.length() < 6) {
             throw new IllegalArgumentException("A senha deve ter pelo menos 6 caracteres.");
        }
        
        // 2. Lógica de Segurança: Geração do HASH
        String senhaHash = hashSenha(senha); // Chamada a uma função de hash segura.

        // Cria o objeto cliente com o HASH
        Cliente novoCliente = new Cliente(nome, email, senha, endereco);
        
        try {
            // 3. Persistência: Chama o DAO
            clienteDAO.cadastrar(novoCliente);
            System.out.println("✅ Cliente " + nome + " cadastrado com sucesso!");
        } catch (RuntimeException e) {
            throw new RuntimeException("❌ Erro ao cadastrar cliente: " + e.getMessage(), e);
        }
    }

    private String hashSenha(String senha) {
        // simplificação de hash
        return "HASH_" + senha.toUpperCase() + "_SECURE"; 
    }
}