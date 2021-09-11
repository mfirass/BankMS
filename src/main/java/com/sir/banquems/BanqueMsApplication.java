package com.sir.banquems;

import com.sir.banquems.entities.Compte;
import com.sir.banquems.entities.TypeCompte;
import com.sir.banquems.repositories.CompteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class BanqueMsApplication {

    public static void main(String[] args) {
        SpringApplication.run(BanqueMsApplication.class, args);
    }

    @Bean
    CommandLineRunner start(CompteRepository compteRepository){
        return args -> {
            compteRepository.save(new Compte(null, Math.random()*900, new Date(), TypeCompte.COURANT));
            compteRepository.save(new Compte(null, Math.random()*900, new Date(), TypeCompte.EPARGNE));
            compteRepository.save(new Compte(null, Math.random()*900, new Date(), TypeCompte.COURANT));
            compteRepository.findAll().forEach(c->{
                System.out.println(c.toString());
            });
        };
    }
}
