package br.com.felipejunges.simplemath.resources;

import br.com.felipejunges.simplemath.domain.Usuario;
import br.com.felipejunges.simplemath.dto.CredenciaisDTO;
import br.com.felipejunges.simplemath.dto.UsuarioDTO;
import br.com.felipejunges.simplemath.dto.UsuarioNewDTO;
import br.com.felipejunges.simplemath.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value="/usuarios")
public class UsuarioResource {
	
	@Autowired
	private UsuarioService service;

	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable UUID id) {
	    System.out.print(id);
		Usuario obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}

    @RequestMapping(method=RequestMethod.GET)
    public ResponseEntity<List<UsuarioDTO>> findAll() {
        List<Usuario> list = service.findAll();
        List<UsuarioDTO> listDTO = list.stream().map
                (obj -> new UsuarioDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    @RequestMapping(method=RequestMethod.POST)
    public ResponseEntity<Void> insert(@RequestBody UsuarioNewDTO objDto) {
	    Usuario obj = service.fromDTO(objDto);
	    obj = service.insert(obj);
	    URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(obj.getId()).toUri();
	    System.out.println(obj.getId());
	    System.out.println("Procurando" + service.find(obj.getId()).getId());
	    return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public ResponseEntity<Void> update(@Valid @RequestBody UsuarioDTO objDto,
                                       @PathVariable UUID id) {
        Usuario obj = service.fromDTO(objDto);
        obj.setId(id);
        obj = service.update(obj);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value="/email", method=RequestMethod.GET)
    public ResponseEntity<Usuario> find(@RequestParam(value="value") String email) {
        Usuario obj = service.findByEmail(email);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(value="/page", method=RequestMethod.GET)
    public ResponseEntity<Page<UsuarioDTO>> findPage(
            @RequestParam(value="page", defaultValue="0") int page,
            @RequestParam(value="linesPerPage", defaultValue="24") int linesPerPage,
            @RequestParam(value="orderBy", defaultValue="nome") String orderBy,
            @RequestParam(value="direction", defaultValue="ASC") String direction) {
        Page<Usuario> list = service.findPage(page, linesPerPage, orderBy, direction);
        Page<UsuarioDTO> listDTO = list.map(obj -> new UsuarioDTO(obj));
        return ResponseEntity.ok().body(listDTO);
    }

    @RequestMapping(value="/login", method=RequestMethod.POST)
    public ResponseEntity<?> login(@RequestBody CredenciaisDTO objDto) {
        Usuario obj = service.fromDTO(objDto);
        obj = service.findByEmailAndPassword(obj);
        return ResponseEntity.ok().body(obj);
    }


}
