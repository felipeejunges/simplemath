package br.com.felipejunges.simplemath.services;

import br.com.felipejunges.simplemath.domain.Alternative;
import br.com.felipejunges.simplemath.domain.Question;
import br.com.felipejunges.simplemath.dto.AlternativeDTO;
import br.com.felipejunges.simplemath.repositories.AlternativeRepository;
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

@Service
public class AlternativeService {

	@Autowired
	private AlternativeRepository repo;

	public Alternative find(int id) {
		Optional<Alternative> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Alternative.class.getName()));
	}

	public List<Alternative> findAll() {
		return repo.findAll();
	}

	public Page<Alternative> findPage(int page, int linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page,  linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}

    @Transactional
    public Alternative insert(Alternative obj) {
        obj.setId(0);
        return repo.save(obj);
    }

    public List<Alternative> insert(List<Alternative> lista) {
        return repo.saveAll(lista);
    }

	public Alternative fromDTO(AlternativeDTO dto) {
		return new Alternative(dto.getId(), dto.getAnswer(), dto.isCorrect());
	}

	public  List<Alternative>  getAlternativesFromDTO(List<AlternativeDTO> alternativesDTO) {
        List<Alternative> alternatives = new ArrayList<>();
//        for (AlternativeDTO alternativeDTO: alternativesDTO) {
//            alternatives.add(fromDTO(alternativeDTO));
//        }
        return alternatives;
    }

	public List<Alternative> findByQuestion(Question questao) {
		return repo.findByQuestion(questao);
	}

    public List<Alternative> insertAll(List<Alternative> alternatives) {
		return repo.saveAll(alternatives);
    }
}
