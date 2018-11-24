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
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value="/quiz")
public class QuizResource {
	
	@Autowired
	private QuizService service;

	@Autowired
    private UsuarioService usuarioService;

	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable int id) {
	    System.out.print(id);
		Quiz obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}

    @RequestMapping(value="/new/{usuarioID}", method=RequestMethod.GET)
	public ResponseEntity<?> newQuiz(@PathVariable int usuarioID) {
		Quiz obj = service.newQuiz(usuarioID);
		return ResponseEntity.ok().body(obj);
	}

    @RequestMapping(value="/save/{id}", method=RequestMethod.PUT)
	public ResponseEntity<?> save(@PathVariable int id, @RequestBody Quiz quiz) {
	    quiz.setId(id);
		service.save(quiz);

		return ResponseEntity.ok().body(new Quiz(quiz.getId()));
	}


    @RequestMapping(value="/resumo/{usuarioID}", method=RequestMethod.GET)
    public ResponseEntity<?> resumo(@PathVariable int usuarioID) {
        Usuario usuario = usuarioService.find(usuarioID);
        List<ResumoDTO> dto = new ArrayList<>();
        for (Quiz quiz :
                usuario.getQuizzes()) {
            dto.add(new ResumoDTO(quiz));
        }
        return ResponseEntity.ok().body(dto);
    }

    @RequestMapping(value="/final/{id}", method=RequestMethod.GET)
    public ResponseEntity<?> finalResume(@PathVariable int id) {
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
