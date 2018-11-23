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
		inserirQuestao();
		
		
		return true;
	}

	public boolean inserirQuestao(String questao, long maxTime, String a1, String a2, String a3, String a4, String a5, boolean correct) {
		Question q1 = new Question("", 0, 0);
		Alternative a1 = new Alternative("", 0, 0, q1);
		Alternative a2 = new Alternative("", 0, 0, q1);
		Alternative a3 = new Alternative("", 0, 0, q1);
		Alternative a4 = new Alternative("", 0, 0, q1);
		Alternative a5 = new Alternative("", 0, 0, q1);
		q1.getAlternatives().addAll(Arrays.asList(a1, a2, a3, a4, a5));
		questionService.save(q1);
		alternativeService.saveAll(Arrays.asList(a1, a2, a3, a4, a5));
	}

	
}
