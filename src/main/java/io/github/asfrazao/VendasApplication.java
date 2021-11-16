package io.github.asfrazao;

import io.github.asfrazao.domain.entity.Cliente;
import io.github.asfrazao.domain.repository.Clientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;

import java.util.List;


@SpringBootApplication
public class VendasApplication {

    @Bean
    public CommandLineRunner init(@Autowired Clientes clientes){
        return args -> {
            clientes.salvar(new Cliente("Alessandro"));
            clientes.salvar(new Cliente("Fabiana"));
            clientes.salvar(new Cliente("Ze Ruela"));

            List<Cliente> todosClientes = clientes.obterTodos();
            todosClientes.forEach(System.out::println);

            todosClientes.forEach(c -> {
                c.setNome(c.getNome() + " atualizado!!");
                clientes.atualizar(c);
            });

            System.out.println("****Buscando Clientes******");
            clientes.buscaPorNome("Ale").forEach(System.out::println);

/*            System.out.println("****Deletando Clientes*****");
            clientes.obterTodos().forEach(c -> {
                clientes.deletar(c);
            });*/

            todosClientes = clientes.obterTodos();

            if(todosClientes.isEmpty()){
                System.out.println("sem clientes para exibir");
            }else {
                todosClientes.forEach(System.out::println);
            }


        };
    }

    public static void main(String[] args) {
        SpringApplication.run(VendasApplication.class, args);

    }
}
