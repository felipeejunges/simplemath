package br.com.felipejunges.simplemath.services; 

import br.com.felipejunges.simplemath.domain.Alternative;
import br.com.felipejunges.simplemath.domain.Question;
import br.com.felipejunges.simplemath.repositories.AlternativeRepository;
import br.com.felipejunges.simplemath.repositories.QuestionRepository;
import br.com.felipejunges.simplemath.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Arrays;

@Service
public class DBService {

	@Autowired
	private BCryptPasswordEncoder pe;

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private QuestionRepository questionRepository;
	@Autowired
	private AlternativeRepository alternativeRepository;
		
	public void instantiateTestDatabase() throws ParseException {

		// Questão 01
		inserirQuestao("A proposição funcional 'Para todo e qualquer valor de n, tem-se 6n < n² + 8' será verdadeira, se n for um número real",
				1000,
				"maior que 3",
				"menor que 8",
				"menor que 4",
				"menor que 2",
				"maior que 2",
				4);

		// Questão 02
		inserirQuestao("De acordo com o Plano Nacional de Viação (PNV) de 2009, a malha de estradas não pavimentadas de Goiás tem 62.868km a mais do que a  malha de estradas pavimentadas." +
						"Sabe-se, também, que a extensão total, em quilômetros, das estradas não pavimentadas supera em 393km o sêxtuplo da extensão das estradas pavimentadas." +
						"Quantos quilômetros de estradas pavimentadas há em Goiás?",
				1000,
				"12.495",
				"12.535",
				"12.652",
				"12.886",
				"12.912",
				1);

		// Questão 03
		inserirQuestao("Margarete ao voltar das compras em um supermercado, resolveu conferir o que pagou por cada produto. Sabe-se que não encontrara a nota das compras e que um dos produtos não apresentava o preço. Resolveu fazer os cálculos vendo que comprara 3 unidades de um produto ao valor de R$ 3,85 cada, quatro unidades de um produto por R$ 2,55 cada e duas unidades de um produto por valor desconhecido. Lembrou-se, ainda, ter recebido um troco de R$ 1,75 após entregar ao caixa três notas de R$ 10,00. Somando-se os algarismos do número referente ao preço desconhecido encontra-se:",
				1000,
				"9",
				"10",
				"11",
				"12",
				"13",
				2);

		// Questão 04
		inserirQuestao("(Objetiva Concursos - 2015 - Pref. São Pedro do Sul/RS) - Em relação à numeração dos prédios de determinada universidade, sabe-se que: o primeiro prédio possui número 6, o segundo, 12, e assim por diante, formando uma progressão geométrica. Qual é a número do 12º prédio?",
				1000,
				"16.466",
				"14.377",
				"12.228",
				"10.199",
				"11.938",
				3);

		// Questão 05
		inserirQuestao("João, Pedro e Maria fizeram uma caixinha. João tinha 3 quotas, Pedro tinha 2 quotas e Maria 5 cotas. No final do ano a caixinha tinha saldo de R$ 1.200,00, que foi dividido em partes diretamente proporcionais às quotas de cada um. A quantia recebida por Pedro foi igual a",
				1000,
				"R$ 600,00",
				"R$ 480,00",
				"R$ 360,00",
				"R$ 240,00",
				"R$ 420,00",
				4);

		// Questão 06
		inserirQuestao("No Brasil, os setores industrial e comercial consumiram, juntos, 231.199 GWh de energia em 2009. Sabendo que o consumo do setor industrial correspondeu ao dobro do consumo do setor comercial, mais 34.498 GWh, quantos GWh de energia foram consumidos pelo setor comercial brasileiro em 2009?",
				1000,
				"56.885",
				"65.567",
				"88.565",
				"124.656",
				"165.632",
				2);

		// Questão 07
		inserirQuestao("Considere MMC (15, b) = 90. Dividindo-se b pelo maior divisor comum entre 15 e b, encontra-se um número:",
				1000,
				"Divisor de 15",
				"Primo",
				"Ímpar",
				"Múltiplo de 5",
				"Divisor de 12",
				5);

		// Questão 08
		inserirQuestao("(FCC - 2012 - Banese) Considere que em uma indústria todos os seus operários trabalham com desempenhos iguais e constantes. Sabese que 24 desses operários, trabalhando 6 horas por dia, durante 10 dias, conseguem realizar 75% de uma determinada tarefa. O número de operários que conseguirão realizar toda a tarefa em 15 dias, trabalhando 8 horas por dia, é igual a",
				1000,
				"12",
				"15",
				"16",
				"18",
				"20",
				3);

		// Questão 09
		inserirQuestao("(Objetiva Concursos - 2015 - Pref. São Pedro do Sul/RS) - A taxa de juros simples de 6% ao mês é proporcional à taxa trimestral de:",
				1000,
				"18%",
				"30%",
				"24%",
				"12%",
				"16%",
				1);

		// Questão 10
		inserirQuestao("Um investidor aplicou certa quantia em um fundo de ações.\n" +
						"Nesse fundo, 1/3 das ações eram da empresa A, 1/2 da empresa B e as restantes, da empresa C. Em um ano, o valor das ações da empresa A  aumentou 20%, o das ações da empresa B diminuiu 30% e o das ações da empresa C aumentou 17%. Em relação à quantia total aplicada, ao final desse ano, este investidor obteve",
				1000,
				"Lucro de 10,3%",
				"Lucro de 7%",
				"Prejuízo de 5,5%",
				"Prejuízo de 12,4%",
				"Prejuízo de 16,5%",
				3);

		// Questão 11
		inserirQuestao("Questão Exemplo - PATROCINADO: BURN ENERGETICOS",
				1000,
				"94kcal",
				"23g",
				"31mg",
				"3mg",
				"0.19mg",
				1);

		// Questão 12
		inserirQuestao("Questão Exemplo - Até que Horas fiquei acordado fazendo essa atividade ?",
				1000,
				"4 Horas",
				"2 Horas",
				"1 Horas",
				"Nem durmi",
				"Meia noite tava pronto",
				1);

		// Questão 13
		inserirQuestao("Questão Exemplo 13 - Resposta é a 3",
				1000,
				"1",
				"2",
				"3",
				"4",
				"5",
				3);

		// Questão 14
		inserirQuestao("\"Questão Exemplo 14 - Resposta é a 2",
				1000,
				"1",
				"2",
				"3",
				"4",
				"5",
				2);

		// Questão 15
		inserirQuestao("Estava preenchedo estas questões em que horario ?",
				1000,
				"Das 20:00 - 22:22",
				"Das 23:00 - 00:00",
				"Das 01:30 - 02:30",
				"Das 02:00 - 02:20",
				"Das 02:02 - 07:00",
				4);
		
	}

	public boolean inserirQuestao(String questao, long maxTime, String a1Desc, String a2Desc, String a3Desc,
								  String a4Desc, String a5Desc, int correct) {
		Question q1 = new Question(questao, false, 0);
		Alternative a1 = new Alternative(a1Desc, correct == 1, false, q1);
		Alternative a2 = new Alternative(a2Desc, correct == 2, false, q1);
		Alternative a3 = new Alternative(a3Desc, correct == 3, false, q1);
		Alternative a4 = new Alternative(a4Desc, correct == 4, false, q1);
		Alternative a5 = new Alternative(a5Desc, correct == 5, false, q1);
		q1.getAlternatives().addAll(Arrays.asList(a1, a2, a3, a4, a5));
		questionRepository.save(q1);
		alternativeRepository.saveAll(Arrays.asList(a1, a2, a3, a4, a5));
		return true;
	}
}
