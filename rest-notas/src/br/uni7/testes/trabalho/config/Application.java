package br.uni7.testes.trabalho.config;

import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;

@ApplicationPath("api")
public class Application extends ResourceConfig {

    public Application() {
        packages("br.uni7.testes.trabalho.rest");
    }
}
