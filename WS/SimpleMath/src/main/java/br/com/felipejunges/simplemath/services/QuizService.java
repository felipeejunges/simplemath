package br.com.felipejunges.simplemath.services;

import br.com.felipejunges.simplemath.domain.Answer;
import br.com.felipejunges.simplemath.domain.Quiz;
import br.com.felipejunges.simplemath.domain.Usuario;
import br.com.felipejunges.simplemath.repositories.AnswerRepository;
import br.com.felipejunges.simplemath.repositories.QuizRepository;
import br.com.felipejunges.simplemath.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class QuizService {

	@Autowired
	private QuizRepository repo;
	@Autowired
	private AnswerRepository answerRepo;
	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private AlternativeService alternativeService;
	@Autowired
	private QuestionService questionService;

	public Quiz save(Quiz quiz) {
		List<Answer> answers = new ArrayList<>();
		for(Answer answer : quiz.getAnswers()) {
			answer.setQuiz(quiz);
		}
		answerRepo.saveAll(answers);
		quiz.setAnswers(answers);
		repo.save(quiz);
		return quiz;
	}

	public Quiz newQuiz(UUID usuarioID) {
		Quiz obj = new Quiz(false, usuarioService.find(usuarioID));
		obj.setQuestions(questionService.findQuestions());
		return obj;
	}
	
	public Quiz find(UUID id) {
		Optional<Quiz> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Quiz.class.getName()));
	}

	public List<Quiz> findAll() {
		return repo.findAll();
	}
	
	public Page<Quiz> findPage(int page, int linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page,  linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}

	@Transactional
	public Quiz insert(Quiz obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
}
