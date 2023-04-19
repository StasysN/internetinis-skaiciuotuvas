package com.spring.skaiciuotuvas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// SpringBootApplicationSi anotacija yra lygi @Configuration, @EnbelAutoConfiguration ir @ComponentScan
// Si anotacija norodoma klaseje turincioje pgrindini Main metoda
@SpringBootApplication
public class InternetinisSkaiciuotuvasApplication {

    public static void main(String[] args) {
        // Programos kontrole deleguojama statiniam klases metodui run
		// nurodant aplikacijos saknini komponenta (root)
		// Spring kakrkasas paleis aplikacija tai yra startuos tomcat serveri
		SpringApplication.run(InternetinisSkaiciuotuvasApplication.class, args);
    }

}
