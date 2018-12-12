package br.com.felipejunges.simplemath.resources;

import br.com.felipejunges.simplemath.domain.Question;
import br.com.felipejunges.simplemath.dto.CredenciaisDTO;
import br.com.felipejunges.simplemath.dto.QuestionDTO;
import br.com.felipejunges.simplemath.dto.QuestionNewDTO;
import br.com.felipejunges.simplemath.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value="/questions")
public class QuestionResource {
	
	@Autowired
	private QuestionService service;

	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable int id) {
	    System.out.print(id);
		Question obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}

    @RequestMapping(method=RequestMethod.GET)
    public ResponseEntity<List<QuestionDTO>> findAll() {
        List<Question> list = service.findAll();
        List<QuestionDTO> listDTO = list.stream().map
                (obj -> new QuestionDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    @RequestMapping(method=RequestMethod.POST)
    public ResponseEntity<Void> insert(@RequestBody QuestionNewDTO objDto) {
	    Question obj = service.fromDTO(objDto);
	    obj = service.insertWithAlternatives(obj);
	    URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(obj.getId()).toUri();
	    return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public ResponseEntity<Void> update(@Valid @RequestBody QuestionDTO objDto,
                                       @PathVariable int id) {
        Question obj = service.fromDTO(objDto);
        obj.setId(id);
        obj = service.update(obj);
        return ResponseEntity.noContent().build();
    }
    @RequestMapping(value="/page", method=RequestMethod.GET)
    public ResponseEntity<Page<QuestionDTO>> findPage(
            @RequestParam(value="page", defaultValue="0") int page,
            @RequestParam(value="linesPerPage", defaultValue="24") int linesPerPage,
            @RequestParam(value="orderBy", defaultValue="nome") String orderBy,
            @RequestParam(value="direction", defaultValue="ASC") String direction) {
        Page<Question> list = service.findPage(page, linesPerPage, orderBy, direction);
        Page<QuestionDTO> listDTO = list.map(obj -> new QuestionDTO(obj));
        return ResponseEntity.ok().body(listDTO);
    }

}
