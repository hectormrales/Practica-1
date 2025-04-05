package practica.proyecto.auth.SistemaAutenticacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import practica.proyecto.auth.service.DatabaseConnectionTest;

@Component
public class DatabaseConnectionRunner implements CommandLineRunner {

    @Autowired
    private DatabaseConnectionTest connectionTest;

    @Override
    public void run(String... args) throws Exception {
        connectionTest.checkConnection();
    }
}
