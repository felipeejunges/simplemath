package br.com.felipejunges.simplemath.repositories;

import br.com.felipejunges.simplemath.domain.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;


@Repository
public interface QuestionRepository extends JpaRepository<Question, UUID> {

}
