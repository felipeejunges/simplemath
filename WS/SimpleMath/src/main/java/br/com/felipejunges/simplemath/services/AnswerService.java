package br.com.felipejunges.simplemath.services;

import br.com.felipejunges.simplemath.domain.Alternative;
import br.com.felipejunges.simplemath.domain.Answer;
import br.com.felipejunges.simplemath.dto.AnswerDTO;
import br.com.felipejunges.simplemath.repositories.AnswerRepository;
import br.com.felipejunges.simplemath.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AnswerService {

	@Autowired
	private AnswerRepository repo;
	
	public Answer find(UUID id) {
		Optional<Answer> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Answer.class.getName()));
	}

	public List<Answer> findAll() {
		return repo.findAll();
	}
	
	public Page<Answer> findPage(int page, int linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page,  linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}

	@Transactional
	public Answer insert(Answer obj) {
		obj.setId(null);
		return repo.save(obj);
	}

	public Answer fromDTO(AnswerDTO dto) {
		return new Answer(dto.getId(), dto.getTime(), new Alternative(dto.getAlternativeId()));
	}
	
}
