package io.github.asfrazao.domain.repository;


import io.github.asfrazao.domain.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface Clientes extends JpaRepository<Cliente, Integer> {


    List<Cliente> findByNomeLike(String cli);
}
