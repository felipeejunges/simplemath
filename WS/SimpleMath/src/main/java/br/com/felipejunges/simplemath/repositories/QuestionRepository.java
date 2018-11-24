package br.com.felipejunges.simplemath.repositories;

import br.com.felipejunges.simplemath.domain.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {

    @Transactional(readOnly=true)
    @Query(value="SELECT * FROM Question ORDER BY RAND() LIMIT 10", nativeQuery = true)
    //@Query("SELECT q FROM Question q order by function('RAND')")
    List<Question> randomQuestion();

//    @Transactional(readOnly=true)
//    List<Question> findAllOrderByRand();

}
