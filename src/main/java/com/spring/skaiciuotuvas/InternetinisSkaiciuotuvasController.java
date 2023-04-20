package com.spring.skaiciuotuvas;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

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
    @RequestMapping(method = RequestMethod.GET, value = "/skaiciuoti")
    //@RequestParam anotacija perduoda siuo atveju per URL perduotus duomenis(du skaiciai ir operacijos zenklas)
    // kurie patalpinami i sarasa HasMap <raktas, reiksme>
    // pirmas stringas yra raktas (sk1, sk2, zenklas) antras Stringas yra reiksme pvz (8,6,+)
    // raktai tiek frontende tiek backende turi sutapti!
    // URL pavizdys http://localhost:8080/skaiciuoti?sk1=2&sk2+2&zenklas=*
    // Koduoti matematinius simbolius https://meyerweb.com/eric/tools/dencoder/
    public String skaiciuoti(@RequestParam HashMap<String, String> skaiciai) {
        //per URL perduodamas raktas turi pavadinima sk1
        //pagal rakta sk1 istrukiama reiksme pvz(tarkim ivede 8)
        //vadinasi reiki konvertuoti is stringo i Int kad paskaiciuotume rezultata
        int sk1 = Integer.parseInt(skaiciai.get("sk1"));
        int sk2 = Integer.parseInt(skaiciai.get("sk2"));
        String zenklas = skaiciai.get("zenklas");
        double rezultatas = 0;
        if (zenklas.equals("+")) {
            rezultatas = sk1 + sk2;
        } else if (zenklas.equals("-")) {
            rezultatas = sk1 - sk2;
        } else if (zenklas.equals("*")) {
            rezultatas = sk1 * sk2;
        } else if (zenklas.equals("/") && sk2!=0) {
            rezultatas = sk1 / sk2;
        }
        return sk1 + " " + zenklas +"" + sk2 + " "  + "=" + " " + rezultatas;
        // ApplicationContext yra interfeisas skirtas suteikiti info apie aplikacijos konfiguracija
        // siuo atveju naudojam konfiguracija paimamam is beans.xml failo
        // ApplicationContext appContext = new ClassPathXmlApplicationContext("beans.xml");
        // bean atitinka  singelton sablona (vienetinis), (beanai pagal klases sukurti objektai)
        //HelloWorld bean = (HelloWorld) appContext.getBean("helloWorld");
        //return bean.getHello();
        /*return "Internetinis Skaiciuotuvas <p>" +
                "Galimos operacijos:<br>" +
                "<li> &nbsp &nbsp; sudeti<br> " +
                "<li> &nbsp &nbsp; dauginti<br> " +
                "<li> &nbsp &nbsp; dalinti<br> " +
                "<li> &nbsp &nbsp; atimti<br>";*/
    }

}
