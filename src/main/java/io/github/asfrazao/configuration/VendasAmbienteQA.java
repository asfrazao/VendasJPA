package io.github.asfrazao.configuration;

import io.github.asfrazao.QaAmbient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

@QaAmbient
public class VendasAmbienteQA {
    @Bean
    public CommandLineRunner executar(){
        return args -> {
            System.out.println("*****************************************");
            System.out.println("INICIALIZANDO A CONFIG DE TESTE EM QA");
            System.out.println("*****************************************");
        };
    }
}
