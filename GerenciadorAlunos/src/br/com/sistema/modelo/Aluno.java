package br.com.sistema.modelo;

import br.com.sistema.interfaces.Detalhavel;

/**
 * Representa um aluno no sistema.
 */
public class Aluno extends Pessoa implements Detalhavel {
    private String matricula;

    public Aluno(String nome, String cpf, String matricula) {
        super(nome, cpf);
        this.matricula = matricula;
    }

    // Construtor adicional para flexibilidade.
    public Aluno(String nome, String cpf) {
        super(nome, cpf);
        this.matricula = "N/A";
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    @Override
    public void seApresentar() {
        System.out.println("Olá, eu sou o(a) aluno(a) " + getNome() + ".");
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("--- Detalhes do Aluno ---");
        System.out.println("Nome: " + getNome());
        System.out.println("CPF: " + getCpf());
        System.out.println("Matrícula: " + getMatricula());
        System.out.println("-------------------------");
    }
}