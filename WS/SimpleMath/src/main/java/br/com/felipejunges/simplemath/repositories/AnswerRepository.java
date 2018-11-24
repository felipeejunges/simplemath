package br.com.felipejunges.simplemath.repositories;

import br.com.felipejunges.simplemath.domain.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AnswerRepository extends JpaRepository<Answer, Integer> {
    
}
