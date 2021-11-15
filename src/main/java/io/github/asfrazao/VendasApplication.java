package io.github.asfrazao;

import io.github.asfrazao.model.Pagamentos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class VendasApplication {


    @Value("${application.name}")
    public String applicationName;

    @PagamentoPorBoleto
    private Pagamentos pagamentos;

    @Bean
    public CommandLineRunner executarPagamentos(){
        return args -> {
            this.pagamentos.pagar();
        };
    }

    @GetMapping("hello")
    public String helloWord(){
        return applicationName;
    }

    public static void main(String[] args) {
        SpringApplication.run(VendasApplication.class, args);



    }
}
