-- Crear la base de datos "proyectosistema"
CREATE DATABASE practicauno CHARACTER SET utf8 COLLATE utf8_general_ci;

-- Usar la base de datos "proyectosistema"
USE practicauno;

-- Tabla de usuarios
CREATE TABLE usuarios (
    id BIGINT PRIMARY KEY AUTO_INCREMENT, -- Identificador único del usuario
    nombre VARCHAR(64) NOT NULL, -- Nombre del usuario
    email VARCHAR(64) NOT NULL UNIQUE, -- Email único
    password VARCHAR(128) NOT NULL -- Contraseña
);

-- Tabla de roles
CREATE TABLE roles (
    id BIGINT PRIMARY KEY AUTO_INCREMENT, -- Identificador único del rol
    nombre VARCHAR(64) NOT NULL UNIQUE -- Nombre único del rol
);

-- Relación muchos a muchos entre usuarios y roles
CREATE TABLE usuario_roles (
    usuario_id BIGINT, -- Clave foránea que referencia a usuarios
    rol_id BIGINT, -- Clave foránea que referencia a roles
    PRIMARY KEY (usuario_id, rol_id),
    FOREIGN KEY (usuario_id) REFERENCES usuarios(id) ON DELETE CASCADE, -- Eliminación en cascada
    FOREIGN KEY (rol_id) REFERENCES roles(id) ON DELETE CASCADE -- Eliminación en cascada
);

-- Insertar roles iniciales
INSERT INTO roles (nombre) VALUES ('ROLE_ADMINISTRADOR'), ('ROLE_USUARIO');

-- Crear el usuario administrador
DROP USER IF EXISTS 'admin'@'localhost';
CREATE USER 'admin'@'localhost' IDENTIFIED BY 'admin';
GRANT ALL PRIVILEGES ON practicauno.* TO 'admin'@'localhost';
FLUSH PRIVILEGES;
