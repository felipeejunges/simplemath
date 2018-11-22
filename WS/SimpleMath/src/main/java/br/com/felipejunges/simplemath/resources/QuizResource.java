package br.com.felipejunges.simplemath.resources;

import br.com.felipejunges.simplemath.domain.Quiz;
import br.com.felipejunges.simplemath.dto.CredenciaisDTO;
import br.com.felipejunges.simplemath.dto.QuizDTO;
import br.com.felipejunges.simplemath.dto.QuizNewDTO;
import br.com.felipejunges.simplemath.services.QuizService;
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
@RequestMapping(value="/quiz")
public class QuizResource {
	
	@Autowired
	private QuizService service;

	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable UUID id) {
	    System.out.print(id);
		Quiz obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}

    @RequestMapping(value="/new/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable UUID usuarioID) {
		Quiz obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}

    @RequestMapping(value="/save", method=RequestMethod.PUT)
	public ResponseEntity<?> find(@PathVariable UUID usuarioID) {
		Quiz obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}

    @RequestMapping(value="/page", method=RequestMethod.GET)
    public ResponseEntity<Page<QuizDTO>> findPage(
            @RequestParam(value="page", defaultValue="0") int page,
            @RequestParam(value="linesPerPage", defaultValue="24") int linesPerPage,
            @RequestParam(value="orderBy", defaultValue="nome") String orderBy,
            @RequestParam(value="direction", defaultValue="ASC") String direction) {
        Page<Quiz> list = service.findPage(page, linesPerPage, orderBy, direction);
        Page<QuizDTO> listDTO = list.map(obj -> new QuizDTO(obj));
        return ResponseEntity.ok().body(listDTO);
    }


}
