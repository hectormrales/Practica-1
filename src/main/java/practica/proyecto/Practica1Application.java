package practica.proyecto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@ComponentScan(basePackages = {
    "practica.proyecto.auth.config",
    "practica.proyecto.auth.controller",
    "practica.proyecto.auth.entity",
    "practica.proyecto.auth.repository",
    "practica.proyecto.auth.service",
    "practica.proyecto.auth.SistemaAutenticacion"
})
@EnableJpaRepositories(basePackages = "practica.proyecto.auth.repository")
@EntityScan(basePackages = "practica.proyecto.auth.entity")
public class Practica1Application {

	public static void main(String[] args) {
		SpringApplication.run(Practica1Application.class, args);
	}
}
