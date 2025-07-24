package br.com.sistema.modelo;

import br.com.sistema.interfaces.Detalhavel;
import java.util.ArrayList;
import java.util.List;

/**
 * Representa um curso oferecido pela instituição.
 */
public class Curso implements Detalhavel {
    private int codigo;
    private String nome;


    private List<Disciplina> disciplinas;

    public Curso(int codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
        this.disciplinas = new ArrayList<>();
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void adicionarDisciplina(Disciplina disciplina) {
        this.disciplinas.add(disciplina);
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("--- Detalhes do Curso ---");
        System.out.println("Código: " + getCodigo());
        System.out.println("Nome: " + getNome());
        System.out.println("Disciplinas Ofertadas: " + disciplinas.size());
        System.out.println("-------------------------");
    }
}