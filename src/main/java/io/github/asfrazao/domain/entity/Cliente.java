package io.github.asfrazao.domain.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class Cliente {

    public Cliente() {
    }

    public Cliente(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Cliente(String nome) {
        this.nome = nome;
    }

    private Integer id;
    private String nome;



}
