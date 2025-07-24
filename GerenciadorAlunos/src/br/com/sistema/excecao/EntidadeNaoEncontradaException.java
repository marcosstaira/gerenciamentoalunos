package br.com.sistema.excecao;

/**
 * Exceção para casos onde uma entidade (Aluno, Professor, etc.) não é encontrada.
 */
public class EntidadeNaoEncontradaException extends Exception {
    public EntidadeNaoEncontradaException(String message) {
        super(message);
    }
}