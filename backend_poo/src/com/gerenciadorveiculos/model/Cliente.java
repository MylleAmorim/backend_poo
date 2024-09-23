package src.com.gerenciadorveiculos.model;

public class Cliente {
    private String nome;
    private String cpf;
    private String telefone;



    public Cliente(String nome, String cpf, String telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;

    }

    public Cliente() {}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return  "nome: " + nome + '\n' +
                "cpf: " + cpf + '\n' +
                "telefone: " + telefone + '\n';
    }
}
