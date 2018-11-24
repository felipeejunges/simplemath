package br.com.felipejunges.simplemath.resources;

import br.com.felipejunges.simplemath.domain.Answer;
import br.com.felipejunges.simplemath.domain.Quiz;
import br.com.felipejunges.simplemath.domain.Usuario;
import br.com.felipejunges.simplemath.dto.FinalDTO;
import br.com.felipejunges.simplemath.dto.ResumoDTO;
import br.com.felipejunges.simplemath.services.QuizService;
import br.com.felipejunges.simplemath.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value="/quiz")
public class QuizResource {
	
	@Autowired
	private QuizService service;

	@Autowired
    private UsuarioService usuarioService;

	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable UUID id) {
	    System.out.print(id);
		Quiz obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}

    @RequestMapping(value="/new/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> newQuiz(@PathVariable UUID usuarioID) {
		Quiz obj = service.newQuiz(usuarioID);
		return ResponseEntity.ok().body(obj);
	}

    @RequestMapping(value="/save", method=RequestMethod.PUT)
	public ResponseEntity<?> save(Quiz quiz) {
		service.save(quiz);

		return ResponseEntity.ok().body(new Quiz(quiz.getId()));
	}


    @RequestMapping(value="/resumo/{id}", method=RequestMethod.GET)
    public ResponseEntity<?> resumo(@PathVariable UUID usuarioID) {
        Usuario usuario = usuarioService.find(usuarioID);
        List<ResumoDTO> dto = new ArrayList<>();
        for (Quiz quiz :
                usuario.getQuizzes()) {
            dto.add(new ResumoDTO(quiz));
        }
        return ResponseEntity.ok().body(dto);
    }

    @RequestMapping(value="/final/{id}", method=RequestMethod.GET)
    public ResponseEntity<?> finalResume(@PathVariable UUID id) {
        Quiz quiz = service.find(id);
        long tempoEsperado = 0;
        long tempoTotal = 0;

        for (Answer answer: quiz.getAnswers()) {
            tempoEsperado += answer.getAlternative().getQuestion().getMaxtime();
            tempoTotal += answer.getTime();
        }
        long tempoMedio = tempoTotal / quiz.getAnswers().size();
        FinalDTO dto = new FinalDTO(tempoTotal, tempoMedio, tempoEsperado);

        dto.setAnswer(quiz.getAnswers());
        return ResponseEntity.ok().body(dto);
    }



}
