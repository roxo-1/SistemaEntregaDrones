package sistemas;

public class BancoDeDados {
    public void salvar(Object objeto) {
        System.out.println("Salvando objeto: " + objeto.getClass().getSimpleName());
    }

    public void consultar(String tabela, int id) {
        System.out.println("Consultando " + tabela + " com ID " + id);
    }
}
