package io.github.brenodelima.model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CotacaoDolar extends PanacheEntityBase {
    private Double valorDolar;
    private LocalDateTime cotacaoDolar;
    private Double valorDolarAnterior;
    private LocalDateTime cotacaoDolarAnterior;
}
