package io.github.brenodelima.exception;

public class ServicoIndisponivelException extends RuntimeException{
    public final String msg;

    public ServicoIndisponivelException(String msg) {
        this.msg = msg;
    }
}
