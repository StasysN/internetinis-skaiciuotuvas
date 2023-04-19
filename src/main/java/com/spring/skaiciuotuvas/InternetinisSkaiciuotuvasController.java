package com.spring.skaiciuotuvas;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

// Web kontroleris leidizia viduje naudoti @RequestMapping
//
@RestController
//Zymi konfiguracija komponento viduje leidzia kurti bean per metodus su @Bean anotacija
// Sic klases lygio anotacija nurodo Spring karkasui "Atspeti" konfiguracija
// Remiantis priklausomuybemis (Jar bibliotekomis) kuris programuotojas itraukia i projekta (Pom Xml)
//Siuo atveju veikia kartu su main metodu
@EnableAutoConfiguration
public class InternetinisSkaiciuotuvasController {
    // galima ir nerasyti sitos dalies (method = RequestMethod.GET, value = ) o tiesiog "/"
    @RequestMapping(method = RequestMethod.GET, value = "/")
    public String index() {
        // ApplicationContext yra interfeisas skirtas suteikiti info apie aplikacijos konfiguracija
        // siuo atveju naudojam konfiguracija paimamam is beans.xml failo
        ApplicationContext appContext = new ClassPathXmlApplicationContext("beans.xml");
        // bean atitinka  singelton sablona (vienetinis), (beanai pagal klases sukurti objektai)
        HelloWorld bean = (HelloWorld) appContext.getBean("helloWorld");
        return bean.getHello();
        /*return "Internetinis Skaiciuotuvas <p>" +
                "Galimos operacijos:<br>" +
                "<li> &nbsp &nbsp; sudeti<br> " +
                "<li> &nbsp &nbsp; dauginti<br> " +
                "<li> &nbsp &nbsp; dalinti<br> " +
                "<li> &nbsp &nbsp; atimti<br>";*/
    }
}
