package io.github.brenodelima.service;

import io.github.brenodelima.exception.RequisicaoInvalidaException;
import io.github.brenodelima.model.CotacaoDolar;
import io.github.brenodelima.restconsultacotacaobcbapi.ConsultaCotacaoBCBResource;
import io.github.brenodelima.util.DataUtil;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

@ApplicationScoped
public class CotacaoDolarService {
    @Inject
    ConsultaCotacaoBCBResource resource;
    public CotacaoDolar consultarCotacaoDolar(String dataRecebida) {
        try {
        List<CotacaoDolar> cotacoes = resource.consultarCotacaoDolarBCB(
                validaFinalDeSemana(DataUtil.stringParaLocalDate(dataRecebida)));
        } catch (RuntimeException e) {
            e.printStackTrace();
            throw new RequisicaoInvalidaException("A API que consulta a cotação do dólar no BCB está" +
                    " fora do ar, tente novamente mais tarde.");
        }
        return null;
    }

    private String validaFinalDeSemana(LocalDate data) {
        if(DayOfWeek.SATURDAY.equals(data.getDayOfWeek()) || DayOfWeek.SUNDAY.equals(data.getDayOfWeek())) {
            throw new RequisicaoInvalidaException("A data informada: "+DataUtil.localDateParaString(data)+
                    ", corresponde ao final de semana, favor informar um dia útil.");
        }
        return DataUtil.localDateParaString(data);
    }
}
