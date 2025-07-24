package br.com.sistema.modelo;

/**
 * Classe base para representar uma pessoa no sistema.
 * É abstrata e não pode ser instanciada diretamente.
 */
public abstract class Pessoa {
    private String nome;
    private String cpf;

    public Pessoa(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

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

    // Método que toda classe filha será obrigada a implementar.
    public abstract void seApresentar();
}