package interfaces;

public interface IGerenciamentoDrone {
    void cadastrarDrone(int id, String statusBateria, int capacidadeCarga);
    void atualizarStatus(int id, String novoStatus);
}
