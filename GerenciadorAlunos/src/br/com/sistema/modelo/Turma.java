package br.com.sistema.modelo;

import java.util.ArrayList;
import java.util.List;
public class Turma {
    private int codigo;
    private Disciplina disciplina;
    private Professor professor;
    private List<Aluno> alunosMatriculados;

    public Turma(int codigo, Disciplina disciplina, Professor professor) {
        this.codigo = codigo;
        this.disciplina = disciplina;
        this.professor = professor;
        this.alunosMatriculados = new ArrayList<>();
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public List<Aluno> getAlunosMatriculados() {
        return alunosMatriculados;
    }

    public void matricularAluno(Aluno aluno) {
        // Lógica para evitar matricular o mesmo aluno duas vezes (opcional, mas bom)
        if (!this.alunosMatriculados.contains(aluno)) {
            this.alunosMatriculados.add(aluno);
        }
    }

    // ALTERAÇÃO SIGNIFICATIVA AQUI
    public void exibirDetalhesTurma() {
        System.out.println("------------------------------------");
        System.out.println("DETALHES DA TURMA");
        System.out.println("Código da Turma: " + getCodigo());
        System.out.println("Disciplina: " + disciplina.getNome());
        System.out.println("Professor: " + professor.getNome());
        System.out.println("Total de Alunos: " + alunosMatriculados.size());

        // Agora, o método também lista os alunos matriculados
        if (alunosMatriculados.isEmpty()) {
            System.out.println("Alunos Matriculados: Nenhum aluno matriculado nesta turma.");
        } else {
            System.out.println("Alunos Matriculados:");
            for (Aluno aluno : alunosMatriculados) {
                System.out.println("  - Matrícula: " + aluno.getMatricula() + ", Nome: " + aluno.getNome());
            }
        }
        System.out.println("------------------------------------");
    }
}