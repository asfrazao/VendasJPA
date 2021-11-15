package io.github.asfrazao.configuration;

import io.github.asfrazao.ProdAmbient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

@ProdAmbient
public class VendasConfigurationProd {

    @Bean
    public CommandLineRunner executar(){
        return args -> {
            System.out.println("*****************************************");
            System.out.println("INICIALIZANDO A CONFIG DE PRODUCAO");
            System.out.println("*****************************************");
        };
    }
}
