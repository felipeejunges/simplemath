package br.com.felipejunges.simplemath.repositories;

import br.com.felipejunges.simplemath.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;


@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, UUID> {

    @Transactional(readOnly=true)
    Usuario findByEmail(String email);

    @Transactional(readOnly=true)
    Optional<Usuario> findByEmailAndPassword(String email, String password);
}
