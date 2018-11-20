package br.com.felipejunges.simplemath.services;

import br.com.felipejunges.simplemath.domain.Usuario;
import br.com.felipejunges.simplemath.dto.CredenciaisDTO;
import br.com.felipejunges.simplemath.dto.UsuarioDTO;
import br.com.felipejunges.simplemath.dto.UsuarioNewDTO;
import br.com.felipejunges.simplemath.repositories.UsuarioRepository;
import br.com.felipejunges.simplemath.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repo;

    @Autowired
    private BCryptPasswordEncoder pe;

    public Usuario find(UUID id) {
        Optional<Usuario> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Usuario.class.getName()));
    }

    public List<Usuario> findAll() {
        return repo.findAll();
    }

    public Page<Usuario> findPage(int page, int linesPerPage, String orderBy, String direction) {
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
        return repo.findAll(pageRequest);
    }

    public Usuario findByEmail(String email) {
        Usuario obj = repo.findByEmail(email);
        return obj;
    }

    @Transactional
    public Usuario insert(Usuario obj) {
        obj.setId(null);
        obj = repo.save(obj);
        return obj;
    }

    public Usuario update(Usuario obj) {
        Usuario newObj = find(obj.getId());
        updateData(newObj, obj);
        return obj;
    }

    public Usuario findByEmailAndPassword(Usuario obj) {
        System.out.println("Senha Crypto:" + obj.getPassword());
        Optional<Usuario> optObj = repo.findByEmailAndPassword(obj.getEmail(), obj.getPassword());
        return optObj.orElseThrow(() -> new ObjectNotFoundException(
                "Usuario não encontrado! E-mail: " + obj.getEmail() + ", Tipo: " + Usuario.class.getName()));
    }


    private void updateData(Usuario newObj, Usuario obj) {
        newObj.setName(obj.getName());
        newObj.setEmail(obj.getCelphoneNumber());
        newObj.setCelphoneNumber(obj.getCelphoneNumber());
    }

    public Usuario fromDTO(UsuarioDTO objDTO) {
        return new Usuario(objDTO.getId(), objDTO.getName(), objDTO.getEmail(), objDTO.getCelphoneNumber(), null);
    }

    public Usuario fromDTO(CredenciaisDTO credenciaisDTO) {
        System.out.println("Usuario: " + credenciaisDTO.getEmail() + " Senha: " + credenciaisDTO.getPassword());
        return new Usuario(credenciaisDTO.getEmail(), credenciaisDTO.getPassword());
//        return new Usuario(credenciaisDTO.getEmail(), pe.encode(credenciaisDTO.getPassword()));
    }

    public Usuario fromDTO(UsuarioNewDTO objDto) {
        return new Usuario(null, objDto.getName(), objDto.getEmail(),
                objDto.getCelphoneNumber(), objDto.getPassword());
//        return new Usuario(null, objDto.getName(), objDto.getEmail(),
//                objDto.getCelphoneNumber(), pe.encode(objDto.getPassword()));
    }


}