package com.spring.skaiciuotuvas;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
// Servlet yra Java programa veikianit Web serveryje
// Servelet paleidiziamas kai vartotojas paspaudzi nuoroda, pateiki forma ar atlieka kito tipo vieksmus internetineje svetaineje.
// Kikeviena kliento usklausa (request) praeina per Servlet kuris ji perduoda kontrolerio reques tmaping atributui.
public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(InternetinisSkaiciuotuvasApplication.class);
	}

}
