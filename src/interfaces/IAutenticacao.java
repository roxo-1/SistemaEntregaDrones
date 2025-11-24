package interfaces;

public interface IAutenticacao {
    boolean login(String email, String senha);
    void finalizarSessao();
}
