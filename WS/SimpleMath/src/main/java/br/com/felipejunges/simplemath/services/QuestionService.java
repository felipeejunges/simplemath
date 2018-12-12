package br.com.felipejunges.simplemath.services;

import br.com.felipejunges.simplemath.domain.Alternative;
import br.com.felipejunges.simplemath.domain.Question;
import br.com.felipejunges.simplemath.dto.QuestionDTO;
import br.com.felipejunges.simplemath.dto.QuestionNewDTO;
import br.com.felipejunges.simplemath.repositories.QuestionRepository;
import br.com.felipejunges.simplemath.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {

	@Autowired
	private QuestionRepository repo;

	@Autowired
    private AlternativeService alternativeService;
	
	public Question find(int id) {
		Optional<Question> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Question.class.getName()));
	}

	public List<Question> findAll() {
		return repo.findAll();
	}

	public List<Question> findQuestions() {
		List<Question> questoes = repo.randomQuestion();
		for (Question questao :
				questoes) {
			questao.getAlternatives().addAll(alternativeService.findByQuestion(questao));
		}
		return questoes;
	}

	public Question insertWithAlternatives(Question q) {
		repo.save(q);
		alternativeService.insertAll(q.getAlternatives());
		return q;
	}
	
	public Page<Question> findPage(int page, int linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page,  linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}

    @Transactional
    public Question insert(Question obj) {
        obj.setId(0);
        return repo.save(obj);
    }

	@Transactional
	public Question update(Question obj) {
		return repo.save(obj);
	}

    public Question fromDTO(QuestionDTO dto) {
	    return new Question(dto.getId(), dto.getDescription(), dto.getMaxtime(),
                alternativeService.getAlternativesFromDTO(dto.getAlternativeDTOs()));
    }

	public Question fromDTO(QuestionNewDTO dto) {
		Question q = new Question(dto.getQuestion(), false, dto.getMaxtime());
		q.getAlternatives().add(new Alternative(dto.getA(), dto.getCorrect() == 1, false, q));
		q.getAlternatives().add(new Alternative(dto.getB(), dto.getCorrect() == 2, false, q));
		q.getAlternatives().add(new Alternative(dto.getC(), dto.getCorrect() == 3, false, q));
		q.getAlternatives().add(new Alternative(dto.getD(), dto.getCorrect() == 4, false, q));
		q.getAlternatives().add(new Alternative(dto.getE(), dto.getCorrect() == 5, false, q));
		return q;
    }



}
