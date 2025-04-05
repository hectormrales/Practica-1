package practica.proyecto.auth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import practica.proyecto.auth.entity.Usuario;
import practica.proyecto.auth.repository.UsuarioRepository;

@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String nombre) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByNombre(nombre)
            .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado: " + nombre));
        return new CustomUserDetails(usuario);
    }

}
