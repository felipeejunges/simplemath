package br.com.felipejunges.simplemath.repositories;

import br.com.felipejunges.simplemath.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    @Transactional(readOnly=true)
    Usuario findByEmail(String email);

    @Transactional(readOnly=true)
    Optional<Usuario> findByEmailAndPassword(String email, String password);
}
