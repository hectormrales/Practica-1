# Practica-1
El proyecto individual será un sistema completamente separado del proyecto grupal y deberá enfocarse exclusivamente en la implementación de un sistema de login y registro básico con autenticación y manejo de roles como fundación técnica para futuras expansiones.

## Manejo Seguro de Contraseñas

En este proyecto, se asegura el manejo seguro de contraseñas mediante el uso de criptografía, específicamente con el algoritmo BCrypt. A continuación, se detallan los aspectos clave del manejo seguro de contraseñas:

### 1. Configuración de Seguridad

El archivo `SecurityConfig.java` es donde se configura la seguridad del proyecto. Aquí se define el uso de BCrypt para la codificación de contraseñas.

```java
package practica.proyecto.auth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import practica.proyecto.auth.service.CustomAuthenticationSuccessHandler;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .authorizeHttpRequests((requests) -> requests
                .requestMatchers("/api/auth/**").permitAll()
                .requestMatchers("/admin").hasRole("ADMINISTRADOR")
                .requestMatchers("/home").authenticated()
                .anyRequest().permitAll())
            .formLogin((form) -> form
                .loginPage("/login")
                .successHandler(new CustomAuthenticationSuccessHandler())
                .permitAll())
            .logout((logout) -> logout.permitAll());

        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
```

### 2. Dependencias de Seguridad

El archivo `pom.xml` incluye las dependencias necesarias para la seguridad y el uso de BCrypt.

```xml
<dependencies>
    <!-- Spring Boot Starter Web for building web applications -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>

    <!-- Spring Security for securing web applications -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-security</artifactId>
    </dependency>

    <!-- Spring Data JPA for database access with JPA -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>

    <!-- MySQL Connector for database connectivity -->
    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
        <version>8.0.28</version>
    </dependency>

    <!-- Spring Boot DevTools for live reload during development -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-devtools</artifactId>
        <scope>runtime</scope>
        <optional>true</optional>
    </dependency>

    <!-- Spring Boot Thymeleaf for rendering HTML templates -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-thymeleaf</artifactId>
    </dependency>

    <!-- BCrypt for password encryption -->
    <dependency>
        <groupId>org.springframework.security</groupId>
        <artifactId>spring-security-crypto</artifactId>
    </dependency>

    <!-- Spring Boot Starter Test for unit testing and integration testing -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-test</artifactId>
        <scope>test</scope>
    </dependency>
</dependencies>
```

### Resumen

- **Algoritmo de Criptografía:** BCrypt, para asegurar la codificación de contraseñas.
- **Configuración:** Definida en `SecurityConfig.java`, donde se configura la codificación de contraseñas y las reglas de seguridad.
- **Dependencias:** Incluidas en `pom.xml`, asegurando que todas las bibliotecas necesarias para la seguridad y la criptografía estén disponibles.


## Instrucciones para ejecutar el proyecto

### 1. Clonar el repositorio

Clona el repositorio usando el siguiente comando:

```bash
git clone https://github.com/GusValverde01/Practica1.git
```

### 2. Configurar el puerto de MySQL

Modifica el archivo `application.properties` para cambiar el puerto de MySQL al que utiliza tu computadora.

### 3. Configurar la base de datos

El esquema de la base de datos del proyecto se encuentra en el archivo `schema.sql`.

### 4. Acceder a la carpeta del proyecto

Navega a la carpeta del proyecto con el siguiente comando:

```bash
cd Practica1
```

### 5. Ejecutar el proyecto con Maven

Ejecuta el proyecto usando Maven con el siguiente comando:

```bash
mvn spring-boot:run
```

### 6. Acceder al endpoint

Abre tu navegador y accede al siguiente endpoint:

```
http://localhost:8080/login
```

![Login](https://github.com/hectormrales/Practica-1/blob/main/Capturas/Screenshot%202025-04-04%20222955.png?raw=true)
![Home](https://github.com/hectormrales/Practica-1/blob/main/Capturas/Screenshot%202025-04-04%20223009.png?raw=true)
![Registro](https://github.com/hectormrales/Practica-1/blob/main/Capturas/Screenshot%202025-04-04%20223018.png?raw=true)
![Ejecutandose](https://github.com/hectormrales/Practica-1/blob/main/Capturas/Screenshot%202025-04-04%20223351.png?raw=true)
