package io.github.asfrazao.domain.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ItemPedido {

    private Integer id;
    private Pedido pedido;
    private Produto produto;
    private Integer quantidade;

}
