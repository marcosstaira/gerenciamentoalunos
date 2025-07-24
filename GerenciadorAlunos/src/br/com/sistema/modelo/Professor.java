package br.com.sistema.modelo;

import br.com.sistema.interfaces.Detalhavel;



public class Professor extends Pessoa implements Detalhavel {
    private String departamento;
    private int id;

    public Professor(String nome, String cpf, String departamento, int id) {
        super(nome, cpf);
        this.departamento = departamento;
        this.id = id;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public void seApresentar() {
        System.out.println("Olá, eu sou o(a) professor(a) " + getNome() + " do departamento de " + departamento + ".");
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("--- Detalhes do Professor ---");
        System.out.println("ID: " + getId());
        System.out.println("Nome: " + getNome());
        System.out.println("CPF: " + getCpf());
        System.out.println("Departamento: " + getDepartamento());
        System.out.println("-----------------------------");
    }
}