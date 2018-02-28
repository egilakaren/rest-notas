package br.uni7.testes.trabalho.config;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("api")
public class Application extends ResourceConfig {

    public Application() {
        packages("br.uni7.testes.trabalho.rest", "br.uni7.testes.trabalho.filter");
    }
}
