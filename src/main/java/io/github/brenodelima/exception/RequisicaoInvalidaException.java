package io.github.brenodelima.exception;

import javax.ws.rs.BadRequestException;

public class RequisicaoInvalidaException extends BadRequestException {
    public final String msg;

    public RequisicaoInvalidaException(String msg) {
        this.msg = msg;
    }
}
