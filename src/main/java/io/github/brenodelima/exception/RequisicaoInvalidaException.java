package io.github.brenodelima.exception;

public class RequisicaoInvalidaException extends RuntimeException{
    public final String msg;

    public RequisicaoInvalidaException(String msg) {
        this.msg = msg;
    }
}
