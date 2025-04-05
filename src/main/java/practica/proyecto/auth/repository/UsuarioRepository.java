package practica.proyecto.auth.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import practica.proyecto.auth.entity.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
  Optional<Usuario> findByNombre(String nombre);  // EL campo es "nombre"
}