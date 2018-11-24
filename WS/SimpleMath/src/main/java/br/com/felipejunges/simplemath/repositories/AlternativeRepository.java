package br.com.felipejunges.simplemath.repositories;

import br.com.felipejunges.simplemath.domain.Alternative;
import br.com.felipejunges.simplemath.domain.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AlternativeRepository extends JpaRepository<Alternative, Integer> {

    List<Alternative> findByQuestion(Question questao);
}
