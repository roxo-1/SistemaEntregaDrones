package sistemas;

public class SistemaAutenticacao {
    public boolean validarLogin(String email, String senha) {
        System.out.println("Validando credenciais...");
        return true;
    }

    public void encerrarSessao(int idCliente) {
        System.out.println("Sessão encerrada para o cliente ID " + idCliente);
    }
}
