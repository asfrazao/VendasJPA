package io.github.asfrazao;

import io.github.asfrazao.domain.entity.Cliente;
import io.github.asfrazao.domain.repository.Clientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;


@SpringBootApplication
public class VendasApplication {

    @Bean
    public CommandLineRunner init(@Autowired Clientes clientes){
        return args -> {
            clientes.save(new Cliente("Alessandro"));
            clientes.save(new Cliente("Fabiana"));
            clientes.save(new Cliente("Ze Ruela"));

            List<Cliente> todosClientes = clientes.findAll();
            todosClientes.forEach(System.out::println);

            todosClientes.forEach(c -> {
                c.setNome(c.getNome() + " atualizado!!");
                clientes.save(c);
            });

            System.out.println("****Buscando Clientes******");
            clientes.findByNomeLike("Ale").forEach(System.out::println);

            System.out.println("****Deletando Clientes*****");
            clientes.findAll().forEach(c -> {
                clientes.delete(c);
            });

            todosClientes = clientes.findAll();

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
