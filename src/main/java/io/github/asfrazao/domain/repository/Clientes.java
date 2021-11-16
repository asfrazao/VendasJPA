package io.github.asfrazao.domain.repository;


import io.github.asfrazao.domain.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class Clientes {

    private static final String SELECT_ALL= " select * from CLIENTE";
    private static String INSERT = "insert into cliente (nome) values (?)";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Cliente salvar(Cliente cliente){
        jdbcTemplate.update(INSERT, new Object[]{cliente.getNome()});
                return cliente;
    }

    public List<Cliente> obterTodos(){
        return jdbcTemplate.query(SELECT_ALL, new RowMapper<Cliente>(){

            @Override
            public Cliente mapRow(ResultSet resultSets, int rowNum) throws SQLException {
                Integer id =resultSets.getInt("id");
                String nome = resultSets.getString("nome");
                return new Cliente(id, nome);
            }
        });
    }

}
