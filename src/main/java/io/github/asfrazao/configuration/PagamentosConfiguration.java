package io.github.asfrazao.configuration;

import io.github.asfrazao.model.Pagamentos;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PagamentosConfiguration {

    @Bean(name = "cartao")
    public Pagamentos cartao() {
        return new Pagamentos() {
            @Override
            public void pagar() {
                System.out.println("*********************");
                System.out.println("*  Pago com Cartao  *");
                System.out.println("*********************");

            }
        };
    }

    @Bean(name = "boleto")
    public Pagamentos boleto() {
        return new Pagamentos() {
            @Override
            public void pagar() {
                System.out.println("*********************");
                System.out.println("*  Pago com boleto  *");
                System.out.println("*********************");

            }
        };
    }
}
