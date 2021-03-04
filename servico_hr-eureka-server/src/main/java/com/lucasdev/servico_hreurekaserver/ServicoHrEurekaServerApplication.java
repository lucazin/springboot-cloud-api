package com.lucasdev.servico_hreurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class ServicoHrEurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServicoHrEurekaServerApplication.class, args);
    }

}
