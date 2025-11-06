package interfaces;

public interface IEntrega {
    void solicitarEntrega(int idCliente, double peso, String destino);
    void mostrarHistorico(int idCliente);
}
