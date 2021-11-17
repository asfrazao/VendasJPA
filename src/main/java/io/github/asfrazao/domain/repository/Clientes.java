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

    private static String SELECT_ALL = " select * from CLIENTE";
    private static String INSERT = "insert into cliente (nome) values (?)";
    private static String UPDATE = "update cliente set nome = ? where id = ?";
    private static String DELETE = "delete from cliente where id = ?";



    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Cliente salvar(Cliente cliente) {
        jdbcTemplate.update(INSERT, new Object[]{cliente.getNome()});
        return cliente;
    }

    public Cliente atualizar(Cliente cliente) {
        jdbcTemplate.update(UPDATE, new Object[]{
                cliente.getNome(),
                cliente.getId()});
        return cliente;
    }

    public Cliente deletar(Cliente cliente){
        jdbcTemplate.update(DELETE,new Object[]{
                cliente.getId()});
        return cliente;
    }

    public List<Cliente> buscaPorNome (String nome){
        return jdbcTemplate.query(SELECT_ALL.concat(" where nome like ?"),
                new Object[]{"%" + nome + "%"},
                obterClienteMapper());
    }



    public List<Cliente> obterTodos() {
        return jdbcTemplate.query(SELECT_ALL, obterClienteMapper());
    }

    private RowMapper<Cliente> obterClienteMapper() {
        return new RowMapper<Cliente>() {

            @Override
            public Cliente mapRow(ResultSet resultSets, int rowNum) throws SQLException {
                Integer id = resultSets.getInt("id");
                String nome = resultSets.getString("nome");
                return new Cliente(id, nome);
            }
        };
    }

}
