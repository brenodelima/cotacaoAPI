package io.github.brenodelima.util;

import io.github.brenodelima.exception.RequisicaoInvalidaException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;

public class DataUtil {
    public static LocalDate stringParaLocalDate(String data) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            formatter = formatter.withLocale(Locale.getDefault());
            return LocalDate.parse(data, formatter);
        } catch (DateTimeParseException e) {
            e.printStackTrace();
            throw new RequisicaoInvalidaException("A data informada: "+data+" é inválida, " +
                    "tente informar uma data no padrão: dd-MM-yyyy.");
        }
    }

    public static String localDateParaString(LocalDate ld) {
        return ld.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    }
}
