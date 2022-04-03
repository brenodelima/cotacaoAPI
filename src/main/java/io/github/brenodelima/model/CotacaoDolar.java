package io.github.brenodelima.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class CotacaoDolar {
    private Double valorDolar;
    private LocalDate cotacaoDolar;
    private Double valorDolarAnterior;
    private LocalDate cotacaoDolarAnterior;
}
