package io.github.asfrazao.domain.repository;


import io.github.asfrazao.domain.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class Clientes {

    private static String SELECT_ALL = " select * from CLIENTE";
//    private static String INSERT = "insert into cliente (nome) values (?)";
    private static String UPDATE = "update cliente set nome = ? where id = ?";
    private static String DELETE = "delete from cliente where id = ?";

    @Autowired
    private EntityManager entityManager;



    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional
    public Cliente salvar(Cliente cliente) {
        entityManager.persist(cliente);
//        jdbcTemplate.update(INSERT, new Object[]{cliente.getNome()}); //usado para Injecão de SQL do projeto antigo
        return cliente;
    }

    @Transactional
    public Cliente atualizar(Cliente cliente){
        entityManager.merge(cliente);
        return cliente;
    }

/*    public Cliente atualizar(Cliente cliente) {
        jdbcTemplate.update(UPDATE, new Object[]{
                cliente.getNome(),
                cliente.getId()});
        return cliente;
    }*/

    @Transactional
    public void deletar(Cliente cliente){
        if (!entityManager.contains(cliente)){
            cliente = entityManager.merge(cliente);
        }
        entityManager.remove(cliente);
    }

    @Transactional
    public void deletar(Integer id){
        Cliente cliente = entityManager.find(Cliente.class, id);
        deletar(cliente);
    }


/*    public Cliente deletar(Cliente cliente){
        jdbcTemplate.update(DELETE,new Object[]{
                cliente.getId()});
        return cliente;
    }*/


    @Transactional
    public List<Cliente>buscaPorNome(String nome){
        String jpql = " select c from Cliente c where c.nome = :nome";
       TypedQuery<Cliente> query= entityManager.createQuery(jpql, Cliente.class);
       query.setParameter("nome", "%" + nome + "%");
       return query.getResultList();
    }

/*    public List<Cliente> buscaPorNome (String nome){
        return jdbcTemplate.query(SELECT_ALL.concat(" where nome like ?"),
                new Object[]{"%" + nome + "%"},
                obterClienteMapper());
    }*/


    @Transactional
    public List<Cliente> obterTodos(){
        return entityManager
                .createQuery("from Cliente", Cliente.class)
                .getResultList();
    }

/*    public List<Cliente> obterTodos() {
        return jdbcTemplate.query(SELECT_ALL, obterClienteMapper());
    }*/

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
