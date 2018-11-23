package br.com.felipejunges.simplemath.config;

import br.com.felipejunges.simplemath.services.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.text.ParseException;

@Configuration
@Profile("dev")
public class DevConfig {
	
	@Autowired
	private DBService dbService;
	@Autowired
	private QuestionService questionService;
	@Autowired
	private AlternativeService alternativeService;
	
	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String strategy;
	
	@Bean
	public boolean instantiateDatabase() throws ParseException {
	
		if(! "create".equals(strategy)) {
			return false;
		}
		
		dbService.instantiateTestDatabase();

		// Questão 01
		inserirQuestao("", 
			1000,
			"",
			"",
			"",
			"",
			"",
			1);
		
		
		return true;
	}

	public boolean inserirQuestao(String questao, long maxTime, String a1Desc, String a2Desc, String a3Desc, 
	String a4Desc, String a5Desc, int correct) {
		Question q1 = new Question(questao, 0, 0);
		Alternative a1 = new Alternative(a1Desc, correct == 1, 0, q1);
		Alternative a2 = new Alternative(a2Desc, correct == 2, 0, q1);
		Alternative a3 = new Alternative(a3Desc, correct == 3, 0, q1);
		Alternative a4 = new Alternative(a4Desc, correct == 4, 0, q1);
		Alternative a5 = new Alternative(a5Desc, correct == 5, 0, q1);
		q1.getAlternatives().addAll(Arrays.asList(a1, a2, a3, a4, a5));
		questionService.save(q1);
		alternativeService.saveAll(Arrays.asList(a1, a2, a3, a4, a5));
	}

	
}
