package io.github.asfrazao.domain.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDate;


@Getter
@Setter
@ToString
public class Pedido {

    private Integer id;
    private Cliente cliente;
    private LocalDate data;
    private BigDecimal total;
}
