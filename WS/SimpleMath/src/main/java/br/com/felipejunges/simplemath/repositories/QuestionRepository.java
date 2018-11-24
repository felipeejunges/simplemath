package br.com.felipejunges.simplemath.repositories;

import br.com.felipejunges.simplemath.domain.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;


@Repository
public interface QuestionRepository extends JpaRepository<Question, UUID> {

    @Transactional(readOnly=true)
    @Query("SELECT q FROM Question q ORDER BY RAND() LIMIT 10")
    List<Question> randomQuestion();

//    @Transactional(readOnly=true)
//    List<Question> findAllOrderByRand();

}
