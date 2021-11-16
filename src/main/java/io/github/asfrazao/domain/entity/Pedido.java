package io.github.asfrazao.domain.entity;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;


@Getter
@Setter
public class Pedido {

    private Integer id;
    private Cliente cliente;
    private LocalDate data;
    private BigDecimal total;
}
