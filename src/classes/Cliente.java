package classes;


public class Cliente{

    private int idCliente;
    private String nome;
    private String email;
    private String senha;
    private String endereco;


    public Cliente(){}
    public Cliente(String nome, String email, String senha, String endereco) {
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
}