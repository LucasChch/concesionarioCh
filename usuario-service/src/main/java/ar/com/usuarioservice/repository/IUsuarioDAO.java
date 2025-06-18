package ar.com.usuarioservice.repository;

import ar.com.usuarioservice.models.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface IUsuarioDAO extends CrudRepository<Usuario, Long> {
    public Usuario findByEmailAndDni(String email, String dni);
}
