package io.github.asfrazao.configuration;

import io.github.asfrazao.DevAmbient;
import io.github.asfrazao.ProdAmbient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@DevAmbient
public class VendasConfigurationDev {

 /*   @Bean(name = "applicationName")
    public String applicationName(){
        return "Sistema de Vendas";
    }*/


    @Bean
      public CommandLineRunner executar(){
      return args -> {
          System.out.println("*****************************************");
          System.out.println("INICIALIZANDO A CONFIG DE DESENVOLVIMENTO");
          System.out.println("*****************************************");
      };
    }

}
