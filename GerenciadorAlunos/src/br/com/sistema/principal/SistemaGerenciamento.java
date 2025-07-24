package br.com.sistema.principal;

/*
 * Disciplina: Programação Orientada a Objetos

 * Projeto: Sistema de Gerenciamento Acadêmico
 *
 * Aluno: Marcos Vinícius Taira
 */

import br.com.sistema.excecao.EntidadeNaoEncontradaException;
import br.com.sistema.modelo.*;
import br.com.sistema.servico.GerenciadorAcademico;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class SistemaGerenciamento {


    private static GerenciadorAcademico gerenciador = new GerenciadorAcademico();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;
        do {
            exibirMenuPrincipal();
            opcao = lerOpcao();

            switch (opcao) {
                case 1:
                    menuGerenciarAlunos();
                    break;
                case 2:
                    menuGerenciarProfessores();
                    break;
                case 3:
                    menuGerenciarCursos();
                    break;
                case 4:
                    menuGerenciarDisciplinas();
                    break;
                case 5:
                    menuGerenciarTurmas();
                    break;
                case 0:
                    System.out.println("Saindo do sistema. Até logo!");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);
        scanner.close();
    }

    private static void exibirMenuPrincipal() {
        System.out.println("\n--- SISTEMA DE GERENCIAMENTO ACADÊMICO ---");
        System.out.println("1. Gerenciar Alunos");
        System.out.println("2. Gerenciar Professores");
        System.out.println("3. Gerenciar Cursos");
        System.out.println("4. Gerenciar Disciplinas");
        System.out.println("5. Gerenciar Turmas");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void exibirSubMenu(String entidade) {
        System.out.println("\n--- GERENCIAR " + entidade.toUpperCase() + " ---");
        System.out.println("1. Adicionar");
        System.out.println("2. Listar");
        System.out.println("3. Atualizar");
        System.out.println("4. Deletar");
        System.out.println("0. Voltar ao Menu Principal");
        System.out.print("Escolha uma opção: ");
    }


    private static void exibirMenuTurmas() {
        System.out.println("\n--- GERENCIAR TURMAS ---");
        System.out.println("1. Adicionar Nova Turma");
        System.out.println("2. Listar Todas as Turmas");
        System.out.println("3. Matricular Aluno em Turma"); // NOVA OPÇÃO
        System.out.println("4. Deletar Turma");
        System.out.println("0. Voltar ao Menu Principal");
        System.out.print("Escolha uma opção: ");
    }

    private static int lerOpcao() {
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Erro: Por favor, insira um número válido.");
            return -1;
        } finally {

            scanner.nextLine();
        }
    }

    private static void menuGerenciarAlunos() {
        int opcao;
        do {
            exibirSubMenu("Alunos");
            opcao = lerOpcao();
            switch (opcao) {
                case 1: adicionarAluno(); break;
                case 2: listarAlunos(); break;
                case 3: atualizarAluno(); break;
                case 4: deletarAluno(); break;
                case 0: break;
                default: System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }

    private static void menuGerenciarProfessores() {
        int opcao;
        do {
            exibirSubMenu("Professores");
            opcao = lerOpcao();
            switch (opcao) {
                case 1: adicionarProfessor(); break;
                case 2: listarProfessores(); break;
                case 3: atualizarProfessor(); break;
                case 4: deletarProfessor(); break;
                case 0: break;
                default: System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }

    private static void menuGerenciarCursos() {
        int opcao;
        do {
            exibirSubMenu("Cursos");
            opcao = lerOpcao();
            switch (opcao) {
                case 1: adicionarCurso(); break;
                case 2: listarCursos(); break;
                case 3: atualizarCurso(); break;
                case 4: deletarCurso(); break;
                case 0: break;
                default: System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }

    private static void menuGerenciarDisciplinas() {
        int opcao;
        do {
            exibirSubMenu("Disciplinas");
            opcao = lerOpcao();
            switch (opcao) {
                case 1: adicionarDisciplina(); break;
                case 2: listarDisciplinas(); break;
                case 3: atualizarDisciplina(); break;
                case 4: deletarDisciplina(); break;
                case 0: break;
                default: System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }

    private static void menuGerenciarTurmas() {
        int opcao;
        do {
            exibirMenuTurmas(); // Usa o novo menu
            opcao = lerOpcao();
            switch (opcao) {
                case 1: adicionarTurma(); break;
                case 2: listarTurmas(); break;
                case 3: matricularAlunoEmTurma(); break; // Chama o novo método
                case 4: deletarTurma(); break;
                case 0: break;
                default: System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }



    private static void adicionarAluno() {
        System.out.print("Nome do aluno: ");
        String nome = scanner.nextLine();
        System.out.print("CPF do aluno: ");
        String cpf = scanner.nextLine();
        System.out.print("Matrícula do aluno: ");
        String matricula = scanner.nextLine();

        gerenciador.adicionarAluno(new Aluno(nome, cpf, matricula));
        System.out.println("Aluno adicionado com sucesso!");
    }

    private static void listarAlunos() {
        ArrayList<Aluno> alunos = gerenciador.listarAlunos();
        if (alunos.isEmpty()) {
            System.out.println("Nenhum aluno cadastrado.");
            return;
        }
        System.out.println("\n--- LISTA DE ALUNOS ---");
        for (Aluno aluno : alunos) {
            aluno.exibirDetalhes();
        }
    }

    private static void atualizarAluno() {
        System.out.print("Digite a matrícula do aluno a ser atualizado: ");
        String matricula = scanner.nextLine();
        try {
            Aluno aluno = gerenciador.buscarAlunoPorMatricula(matricula);
            System.out.print("Novo nome (deixe em branco para manter o atual: " + aluno.getNome() + "): ");
            String novoNome = scanner.nextLine();
            if (!novoNome.trim().isEmpty()) {
                aluno.setNome(novoNome);
            }
            System.out.println("Aluno atualizado com sucesso!");
        } catch (EntidadeNaoEncontradaException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private static void deletarAluno() {
        System.out.print("Digite a matrícula do aluno a ser deletado: ");
        String matricula = scanner.nextLine();
        try {
            gerenciador.deletarAluno(matricula);
            System.out.println("Aluno deletado com sucesso!");
        } catch (EntidadeNaoEncontradaException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private static void adicionarProfessor() {
        System.out.print("ID do professor: ");
        int id = lerOpcao();
        System.out.print("Nome do professor: ");
        String nome = scanner.nextLine();
        System.out.print("CPF do professor: ");
        String cpf = scanner.nextLine();
        System.out.print("Departamento: ");
        String depto = scanner.nextLine();
        gerenciador.adicionarProfessor(new Professor(nome, cpf, depto, id));
        System.out.println("Professor adicionado com sucesso!");
    }

    private static void listarProfessores() {
        ArrayList<Professor> professores = gerenciador.listarProfessores();
        if (professores.isEmpty()) {
            System.out.println("Nenhum professor cadastrado.");
            return;
        }
        System.out.println("\n--- LISTA DE PROFESSORES ---");
        for (Professor prof : professores) {
            prof.exibirDetalhes();
        }
    }

    private static void atualizarProfessor() {
        System.out.print("Digite o ID do professor a ser atualizado: ");
        int id = lerOpcao();
        try {
            Professor prof = gerenciador.buscarProfessorPorId(id);
            System.out.print("Novo departamento (atual: " + prof.getDepartamento() + "): ");
            String novoDepto = scanner.nextLine();
            if (!novoDepto.trim().isEmpty()) {
                prof.setDepartamento(novoDepto);
            }
            System.out.println("Professor atualizado com sucesso!");
        } catch (EntidadeNaoEncontradaException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private static void deletarProfessor() {
        System.out.print("Digite o ID do professor a ser deletado: ");
        int id = lerOpcao();
        try {
            gerenciador.deletarProfessor(id);
            System.out.println("Professor deletado com sucesso!");
        } catch (EntidadeNaoEncontradaException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private static void adicionarCurso() {
        System.out.print("Código do curso: ");
        int codigo = lerOpcao();
        System.out.print("Nome do curso: ");
        String nome = scanner.nextLine();
        gerenciador.adicionarCurso(new Curso(codigo, nome));
        System.out.println("Curso adicionado com sucesso!");
    }

    private static void listarCursos() {
        ArrayList<Curso> cursos = gerenciador.listarCursos();
        if (cursos.isEmpty()) {
            System.out.println("Nenhum curso cadastrado.");
            return;
        }
        System.out.println("\n--- LISTA DE CURSOS ---");
        for (Curso curso : cursos) {
            curso.exibirDetalhes();
        }
    }

    private static void atualizarCurso() {
        System.out.print("Digite o código do curso a ser atualizado: ");
        int codigo = lerOpcao();
        try {
            Curso curso = gerenciador.buscarCursoPorCodigo(codigo);
            System.out.print("Novo nome (atual: " + curso.getNome() + "): ");
            String novoNome = scanner.nextLine();
            if (!novoNome.trim().isEmpty()) {
                curso.setNome(novoNome);
            }
            System.out.println("Curso atualizado com sucesso!");
        } catch (EntidadeNaoEncontradaException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private static void deletarCurso() {
        System.out.print("Digite o código do curso a ser deletado: ");
        int codigo = lerOpcao();
        try {
            gerenciador.deletarCurso(codigo);
            System.out.println("Curso deletado com sucesso!");
        } catch (EntidadeNaoEncontradaException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private static void adicionarDisciplina() {
        System.out.print("Código da disciplina: ");
        int codigo = lerOpcao();
        System.out.print("Nome da disciplina: ");
        String nome = scanner.nextLine();
        gerenciador.adicionarDisciplina(new Disciplina(codigo, nome));
        System.out.println("Disciplina adicionada com sucesso!");
    }

    private static void listarDisciplinas() {
        ArrayList<Disciplina> disciplinas = gerenciador.listarDisciplinas();
        if (disciplinas.isEmpty()) {
            System.out.println("Nenhuma disciplina cadastrada.");
            return;
        }
        System.out.println("\n--- LISTA DE DISCIPLINAS ---");
        for (Disciplina d : disciplinas) {
            System.out.println("Código: " + d.getCodigo() + ", Nome: " + d.getNome());
        }
    }

    private static void atualizarDisciplina() {
        System.out.print("Digite o código da disciplina a ser atualizada: ");
        int codigo = lerOpcao();
        try {
            Disciplina d = gerenciador.buscarDisciplinaPorCodigo(codigo);
            System.out.print("Novo nome (atual: " + d.getNome() + "): ");
            String novoNome = scanner.nextLine();
            if(!novoNome.trim().isEmpty()) {
                d.setNome(novoNome);
            }
            System.out.println("Disciplina atualizada com sucesso!");
        } catch (EntidadeNaoEncontradaException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private static void deletarDisciplina() {
        System.out.print("Digite o código da disciplina a ser deletada: ");
        int codigo = lerOpcao();
        try {
            gerenciador.deletarDisciplina(codigo);
            System.out.println("Disciplina deletada com sucesso!");
        } catch (EntidadeNaoEncontradaException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }


    private static void adicionarTurma() {
        System.out.print("Código da nova turma: ");
        int codigoTurma = lerOpcao();

        try {
            System.out.print("Código da disciplina para a turma: ");
            int codigoDisciplina = lerOpcao();
            Disciplina disciplina = gerenciador.buscarDisciplinaPorCodigo(codigoDisciplina);

            System.out.print("ID do professor para a turma: ");
            int idProfessor = lerOpcao();
            Professor professor = gerenciador.buscarProfessorPorId(idProfessor);

            Turma novaTurma = new Turma(codigoTurma, disciplina, professor);
            gerenciador.adicionarTurma(novaTurma);
            System.out.println("Turma criada com sucesso!");

        } catch (EntidadeNaoEncontradaException e) {
            System.out.println("Erro ao criar turma: " + e.getMessage());
        }
    }

    private static void listarTurmas() {
        ArrayList<Turma> turmas = gerenciador.listarTurmas();
        if (turmas.isEmpty()) {
            System.out.println("Nenhuma turma cadastrada.");
            return;
        }
        System.out.println("\n--- LISTA DE TODAS AS TURMAS ---");
        for (Turma t : turmas) {
            t.exibirDetalhesTurma();
        }
    }

    private static void matricularAlunoEmTurma() {
        System.out.print("Digite o código da turma para matricular o aluno: ");
        int codigoTurma = lerOpcao();

        System.out.print("Digite a matrícula do aluno a ser matriculado: ");
        String matriculaAluno = scanner.nextLine();

        try {
            Turma turma = gerenciador.buscarTurmaPorCodigo(codigoTurma);
            Aluno aluno = gerenciador.buscarAlunoPorMatricula(matriculaAluno);

            turma.matricularAluno(aluno);

            System.out.println("\nSucesso! Aluno '" + aluno.getNome() + "' matriculado na turma de " + turma.getDisciplina().getNome() + ".");

        } catch (EntidadeNaoEncontradaException e) {
            System.out.println("\nErro na matrícula: " + e.getMessage());
        }
    }

    private static void deletarTurma() {
        System.out.print("Digite o código da turma a ser deletada: ");
        int codigo = lerOpcao();
        try {
            gerenciador.deletarTurma(codigo);
            System.out.println("Turma deletada com sucesso!");
        } catch (EntidadeNaoEncontradaException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
