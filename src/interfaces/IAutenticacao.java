package interfaces;

public interface IAutenticacao {
    boolean login(String nome, String email, String senha, String endereco);
    void finalizarSessao();
}
