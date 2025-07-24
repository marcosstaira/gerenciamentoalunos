package br.com.sistema.servico;

import br.com.sistema.excecao.EntidadeNaoEncontradaException;
import br.com.sistema.modelo.*;

import java.util.ArrayList;

/**
 * Centraliza toda a lógica de negócio e o armazenamento de dados da aplicação.
 * Funciona como uma camada de serviço que manipula os objetos do modelo.
 */
public class GerenciadorAcademico {

    private ArrayList<Aluno> alunos = new ArrayList<>();
    private ArrayList<Professor> professores = new ArrayList<>();
    private ArrayList<Curso> cursos = new ArrayList<>();
    private ArrayList<Disciplina> disciplinas = new ArrayList<>();
    private ArrayList<Turma> turmas = new ArrayList<>();

    // --- Métodos para Aluno ---
    public void adicionarAluno(Aluno aluno) {
        alunos.add(aluno);
    }

    public ArrayList<Aluno> listarAlunos() {
        return alunos;
    }

    public Aluno buscarAlunoPorMatricula(String matricula) throws EntidadeNaoEncontradaException {
        for (Aluno aluno : alunos) {
            if (aluno.getMatricula().equalsIgnoreCase(matricula)) {
                return aluno;
            }
        }
        throw new EntidadeNaoEncontradaException("Aluno com matrícula " + matricula + " não encontrado.");
    }

    public void deletarAluno(String matricula) throws EntidadeNaoEncontradaException {
        Aluno aluno = buscarAlunoPorMatricula(matricula);
        alunos.remove(aluno);
    }

    // --- Métodos para Professor ---
    public void adicionarProfessor(Professor professor) {
        professores.add(professor);
    }

    public ArrayList<Professor> listarProfessores() {
        return professores;
    }

    public Professor buscarProfessorPorId(int id) throws EntidadeNaoEncontradaException {
        for (Professor prof : professores) {
            if (prof.getId() == id) {
                return prof;
            }
        }
        throw new EntidadeNaoEncontradaException("Professor com ID " + id + " não encontrado.");
    }

    public void deletarProfessor(int id) throws EntidadeNaoEncontradaException {
        Professor prof = buscarProfessorPorId(id);
        professores.remove(prof);
    }

    // --- Métodos para Curso ---
    public void adicionarCurso(Curso curso) {
        cursos.add(curso);
    }

    public ArrayList<Curso> listarCursos() {
        return cursos;
    }

    public Curso buscarCursoPorCodigo(int codigo) throws EntidadeNaoEncontradaException {
        for (Curso curso : cursos) {
            if (curso.getCodigo() == codigo) {
                return curso;
            }
        }
        throw new EntidadeNaoEncontradaException("Curso com código " + codigo + " não encontrado.");
    }

    public void deletarCurso(int codigo) throws EntidadeNaoEncontradaException {
        Curso curso = buscarCursoPorCodigo(codigo);
        cursos.remove(curso);
    }

    // --- Métodos para Disciplina ---
    public void adicionarDisciplina(Disciplina disciplina) {
        disciplinas.add(disciplina);
    }

    public ArrayList<Disciplina> listarDisciplinas() {
        return disciplinas;
    }

    public Disciplina buscarDisciplinaPorCodigo(int codigo) throws EntidadeNaoEncontradaException {
        for (Disciplina d : disciplinas) {
            if (d.getCodigo() == codigo) {
                return d;
            }
        }
        throw new EntidadeNaoEncontradaException("Disciplina com código " + codigo + " não encontrada.");
    }

    public void deletarDisciplina(int codigo) throws EntidadeNaoEncontradaException {
        Disciplina d = buscarDisciplinaPorCodigo(codigo);
        disciplinas.remove(d);
    }

    // --- Métodos para Turma ---
    public void adicionarTurma(Turma turma) {
        turmas.add(turma);
    }

    public ArrayList<Turma> listarTurmas() {
        return turmas;
    }

    public Turma buscarTurmaPorCodigo(int codigo) throws EntidadeNaoEncontradaException {
        for (Turma t : turmas) {
            if (t.getCodigo() == codigo) {
                return t;
            }
        }
        throw new EntidadeNaoEncontradaException("Turma com código " + codigo + " não encontrada.");
    }

    public void deletarTurma(int codigo) throws EntidadeNaoEncontradaException {
        Turma t = buscarTurmaPorCodigo(codigo);
        turmas.remove(t);
    }
}