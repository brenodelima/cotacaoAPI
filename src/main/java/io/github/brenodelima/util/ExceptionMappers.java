package io.github.brenodelima.util;

import io.github.brenodelima.exception.RequisicaoInvalidaException;
import io.github.brenodelima.exception.ServicoIndisponivelException;
import org.jboss.resteasy.reactive.RestResponse;
import org.jboss.resteasy.reactive.server.ServerExceptionMapper;

import javax.ws.rs.core.Response;

public class ExceptionMappers {
    @ServerExceptionMapper
    public RestResponse<String> mapException(RequisicaoInvalidaException erro) {
        return RestResponse.status(Response.Status.BAD_REQUEST, erro.msg);
    }
    @ServerExceptionMapper
    public RestResponse<String> mapException(ServicoIndisponivelException erro) {
        return RestResponse.status(Response.Status.BAD_REQUEST, erro.msg);
    }
}
