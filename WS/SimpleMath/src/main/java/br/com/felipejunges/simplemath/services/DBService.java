package br.com.felipejunges.simplemath.services;

import br.com.felipejunges.simplemath.domain.Alternative;
import br.com.felipejunges.simplemath.domain.Question;
import br.com.felipejunges.simplemath.domain.Usuario;
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

		usuarioRepository.save(new Usuario(0, "Usuario de Testes", "42@test",
				"41999999999", "a"));

		// Questão 01
		inserirQuestao("A proposição funcional 'Para todo e qualquer valor de n, tem-se 6n < n² + 8' será verdadeira, se n for um número real",
				25000,
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
				25000,
				"12.495",
				"12.535",
				"12.652",
				"12.886",
				"12.912",
				1);

		// Questão 03
		inserirQuestao("Margarete ao voltar das compras em um supermercado, resolveu conferir o que pagou por cada produto. Sabe-se que não encontrara a nota das compras e que um dos produtos não apresentava o preço. Resolveu fazer os cálculos vendo que comprara 3 unidades de um produto ao valor de R$ 3,85 cada, quatro unidades de um produto por R$ 2,55 cada e duas unidades de um produto por valor desconhecido. Lembrou-se, ainda, ter recebido um troco de R$ 1,75 após entregar ao caixa três notas de R$ 10,00. Somando-se os algarismos do número referente ao preço desconhecido encontra-se:",
				25000,
				"9",
				"10",
				"11",
				"12",
				"13",
				2);

		// Questão 04
		inserirQuestao("(Objetiva Concursos - 2015 - Pref. São Pedro do Sul/RS) - Em relação à numeração dos prédios de determinada universidade, sabe-se que: o primeiro prédio possui número 6, o segundo, 12, e assim por diante, formando uma progressão geométrica. Qual é a número do 12º prédio?",
				25000,
				"16.466",
				"14.377",
				"12.228",
				"10.199",
				"11.938",
				3);

		// Questão 05
		inserirQuestao("João, Pedro e Maria fizeram uma caixinha. João tinha 3 quotas, Pedro tinha 2 quotas e Maria 5 cotas. No final do ano a caixinha tinha saldo de R$ 1.200,00, que foi dividido em partes diretamente proporcionais às quotas de cada um. A quantia recebida por Pedro foi igual a",
				25000,
				"R$ 600,00",
				"R$ 480,00",
				"R$ 360,00",
				"R$ 240,00",
				"R$ 420,00",
				4);

		// Questão 06
		inserirQuestao("No Brasil, os setores industrial e comercial consumiram, juntos, 231.199 GWh de energia em 2009. Sabendo que o consumo do setor industrial correspondeu ao dobro do consumo do setor comercial, mais 34.498 GWh, quantos GWh de energia foram consumidos pelo setor comercial brasileiro em 2009?",
				25000,
				"56.885",
				"65.567",
				"88.565",
				"124.656",
				"165.632",
				2);

		// Questão 07
		inserirQuestao("Considere MMC (15, b) = 90. Dividindo-se b pelo maior divisor comum entre 15 e b, encontra-se um número:",
				25000,
				"Divisor de 15",
				"Primo",
				"Ímpar",
				"Múltiplo de 5",
				"Divisor de 12",
				5);

		// Questão 08
		inserirQuestao("(FCC - 2012 - Banese) Considere que em uma indústria todos os seus operários trabalham com desempenhos iguais e constantes. Sabese que 24 desses operários, trabalhando 6 horas por dia, durante 10 dias, conseguem realizar 75% de uma determinada tarefa. O número de operários que conseguirão realizar toda a tarefa em 15 dias, trabalhando 8 horas por dia, é igual a",
				25000,
				"12",
				"15",
				"16",
				"18",
				"20",
				3);

		// Questão 09
		inserirQuestao("(Objetiva Concursos - 2015 - Pref. São Pedro do Sul/RS) - A taxa de juros simples de 6% ao mês é proporcional à taxa trimestral de:",
				25000,
				"18%",
				"30%",
				"24%",
				"12%",
				"16%",
				1);

		// Questão 10
		inserirQuestao("Um investidor aplicou certa quantia em um fundo de ações." +
						"Nesse fundo, 1/3 das ações eram da empresa A, 1/2 da empresa B e as restantes, da empresa C. Em um ano, o valor das ações da empresa A  aumentou 20%, o das ações da empresa B diminuiu 30% e o das ações da empresa C aumentou 17%. Em relação à quantia total aplicada, ao final desse ano, este investidor obteve",
				25000,
				"Lucro de 10,3%",
				"Lucro de 7%",
				"Prejuízo de 5,5%",
				"Prejuízo de 12,4%",
				"Prejuízo de 16,5%",
				3);

		// Questão 11
		inserirQuestao(" (UDESC 2008) Sabendo que log3(7x - 1) = 3 e que log2(y3 + 3) = 7 pode-se afirmar que logy(x2 + 9) é igual a:",
				25000,
				"6",
				"2",
				"4",
				"-2",
				"-4",
				2);

		// Questão 12
		inserirQuestao("(UFMG 2009) Numa calculadora científica, ao se digitar um número positivo qualquer e, em seguida, se apertar a tecla log, aparece, no visor, o logaritmo decimal do número inicialmente digitado.\n Digita-se o número 10.000 nessa calculadora e, logo após, aperta-se, N vezes, a tecla log, até aparecer um número negativo no visor. Então, é CORRETO afirmar que o número N é igual a:",
				25000,
				"2",
				"3",
				"4",
				"5",
				"6",
				2);

		// Questão 13
		inserirQuestao("(UDESC 2008) Se LOGa b = 3 e LOGab c = 4, então LOGa c é:",
				25000,
				"12",
				"16",
				"24",
				"8",
				"7",
				2);

		// Questão 14
		inserirQuestao("(UFRGS 2017) Se log5 x = 2 e log10 y = 4, então log20 y/x é:",
				25000,
				"2",
				"4",
				"6",
				"8",
				"10",
				1);

		// Questão 15
		inserirQuestao("(PUC-RIO 2010) Em uma turma de Ciências da Computação formada de 40rapazes e 40 moças, tem-se a seguinte estatística:20% dos rapazes são fumantes;30% das moças são fumantes.Logo, a porcentagem dos que não fumam na turma é de:",
				25000,
				"25%",
				"50%",
				"60%",
				"65%",
				"75%",
				5);

		// Questão 16
		inserirQuestao("(PUC-RIO 2009) João recebeu um aumento de 10% e com isso seu salário chegou a R$1.320,00. O salário de João antes do aumento era igual a? ",
				25000,
				"R$1.188,00",
				"R$1.200,00",
				"R$1.220,00",
				"R$1.310,00",
				"R$1.452,00",
				2);

		// Questão 17
		inserirQuestao("(PUC-RIO 2007) Que número deve ser somado ao numerador e ao denominador da fração 2/3 para que ela tenha um aumento de 25%?",
				25000,
				"3",
				"1/3",
				"3/4",
				"1",
				"1/2",
				1);

		// Questão 18
		inserirQuestao("(PUC-RIO 2007) 30% de 30% são",
				25000,
				"3000%",
				"300%",
				"900%",
				"9%",
				"0,3%",
				4);

		// Questão 19
		inserirQuestao("(UDESC 2010) No final do primeiro semestre deste ano, 40 acadêmicos participaram de uma pesquisa que objetivou analisar a frequência com que estes utilizaram o atendimento extraclasse do professor e/ou do monitor de uma determinada disciplina. Obteve-se o seguinte resultado: 20% dos acadêmicos procuraram atendimento tanto do professor quanto do monitor; 30% dos acadêmicos procuraram somente o atendimento do monitor; 15% dos acadêmicos não opinaram e 4 acadêmicos não procuraram atendimento do professor nem do monitor. Então o número de acadêmicos que procurou o atendimento somente do professor é igual a:",
				25000,
				"24",
				"18",
				"8",
				"10",
				"20",
				4);

		// Questão 20
		inserirQuestao("(UFMG 2010)\n" +
						"O preço de venda de determinado produto tem a seguinte composição: 60% referentes ao custo, 10% referentes ao lucro e 30% referentes a impostos. Em decorrência da crise econômica, houve um aumento de 10% no custo desse produto, porém, ao mesmo tempo, ocorreu uma redução de 20% no valor dos impostos. Para aumentar as vendas do produto, o fabricante decidiu, então, reduzir seu lucro à metade. É CORRETO afirmar, portanto, que, depois de todas essas alterações, o preço do produto sofreu redução de:",
				25000,
				"5%",
				"10%",
				"11%",
				"19%",
				"15%",
				1);

		// Questão 21
		inserirQuestao("(UFMG 2009) No período de um ano, certa aplicação financeira obteve um rendimento de 26%. No mesmo período, porém, ocorreu uma inflação de 20%. Então, é CORRETO afirmar que o rendimento efetivo da referida aplicação foi de:",
				25000,
				"3%",
				"5%",
				"5,2%",
				"6%",
				"4%",
				2);

		// Questão 22
		inserirQuestao("(ADVISE 2009) A soma dos inversos das raízes da equação x² -10x + 22 = 0 é igual a:",
				25000,
				"5/11",
				"11/5",
				"10",
				"-10",
				"5/22",
				1);

		// Questão 23
		inserirQuestao("(PUC-RIO 2009) Considerando-se os algarismos significativos dos números 28,7 e 1,03, podemos afirmar que a soma destes números é dada por:",
				25000,
				"29,7",
				"29,73",
				"29",
				"29,74",
				"29,0",
				1);

		// Questão 24
		inserirQuestao("(PUC-RIO 2009) Comprando dois milk shakes e um bolo gastamos R$13,00. Comprando um milk shake e dois bolos gastamos R$11,00. Quanto gastamos comprando um milk shake e um bolo?",
				25000,
				"R$ 6,00",
				"R$ 7,00",
				"R$ 8,00",
				"R$ 9,00",
				"R$ 10,00",
				3);

		// Questão 25
		inserirQuestao("(PUC-RIO 2009) As notas de uma turma de alunos no teste de matemática foram 10, 10, 9, 8, 8, 8, 7, 7, 4 e 2. Qual a média da turma?",
				25000,
				"8,5",
				"8,2",
				"8,0",
				"7,8",
				"7,3",
				5);

		// Questão 26
		inserirQuestao("(PUC-RIO 2009) O dono de um restaurante comprou oito caixas, cada uma contendo doze latas de doce em calda por R$6,00 a lata. Em cada caixa, duas latas se estragaram e foram jogadas fora. Por quanto ele deve vender cada lata para ter um lucro total de R$72,00?",
				25000,
				"R$ 7,00",
				"R$ 7,50",
				"R$ 8,10",
				"R$ 8,50",
				"R$ 9,00",
				3);

		// Questão 27
		inserirQuestao("(PUC-RIO 2008) Foi feita uma pesquisa sobre a qualidade do doce de abóbora da empresa Bora-Bora. Cada entrevistado dava ao produto uma nota de 0 a 10. Na primeira etapa da pesquisa foram entrevistados 1000 consumidores e a média das notas foi igual a 7. Após a realização da segunda etapa da pesquisa, constatou-se que a média das notas dadas pelos entrevistados nas duas etapas foi igual a 8. O número de entrevistados na segunda etapa foi no mínimo igual a:",
				25000,
				"300",
				"400",
				"500",
				"700",
				"800",
				3);

		// Questão 28
		inserirQuestao("(PUC-RIO 2007) Na revisão de prova de uma turma de quinze alunos, apenas uma nota foi alterada, passando a ser 7,5. Considerando-se que a média da turma aumentou em 0,1, a nota do aluno antes da revisão era:",
				25000,
				"7,6",
				"7,0",
				"7,4",
				"6,0",
				"6,4",
				4);

		// Questão 29
		inserirQuestao("(UFPB 2008) Uma atleta participou das três provas de uma determinada competição. Suas notas, nas duas últimas provas, foram, respectivamente, o dobro e o triplo da nota da primeira. Sabendo-se que a média aritmética das três notas foi 28,6pontos, é correto afirmar que a nota da primeira prova foi:",
				25000,
				"12",
				"9,2",
				"10,5",
				"15",
				"14,3",
				5);

		// Questão 30
		inserirQuestao("(FUVEST 2016) Em uma classe com 14 alunos, 8 são mulheres e 6 são homens. A média das notas das mulheres no final do semestre ficou 1 ponto acima da média da classe. A soma das notas dos homens foi metade da soma das notas das mulheres. Então, a média das notas dos homens ficou mais próxima de:",
				25000,
				"4,3",
				"4,5",
				"4,7",
				"4,9",
				"5,1",
				3);

		// Questão 31
		inserirQuestao("Um aluno prestou vestibular em apenas duas Universidades. Suponha que, em uma delas, a probabilidade de que ele seja aprovado é de 30%, enquanto na outra, pelo fato de a prova ter sido mais fácil, a probabilidade de sua aprovação sobe para 40%. Nessas condições, a probabilidade deque esse aluno seja aprovado em pelo menosuma dessas Universidades é de:",
				25000,
				"70%",
				"68%",
				"60%",
				"58%",
				"52%",
				4);

		// Questão 32
		inserirQuestao("(PUC-RIO 2010) Quatro moedas são lançadas simultaneamente. Qual é a probabilidade de ocorrer coroa em uma só moeda?",
				25000,
				"1/9",
				"2/9",
				"1/4",
				"1/3",
				"3/8",
				3);

		// Questão 33
		inserirQuestao("(PUC-RIO 2009) Jogamos dois dados comuns. Qual a probabilidade de que o total de pontos seja igual a 10?",
				25000,
				"1/12",
				"1/11",
				"1/10",
				"2/23",
				"1/6",
				1);

		// Questão 34
		inserirQuestao("(PUC-RIO 2008) No jogo de Lipa sorteia-se um número entre 1 e 600 (cada número possui a mesma probabilidade). A regra do jogo é: se o número sorteado for múltiplo de 6 então o jogador ganha uma bola branca e se o número sorteado for múltiplo de 10 então o jogador ganha uma bola preta. Qual a probabilidade de o jogador não ganhar nenhuma bola?",
				25000,
				"13/17",
				"11/15",
				"23/30",
				"2/3",
				"1/2",
				3);

		// Questão 35
		inserirQuestao("(PUC-RIO 2008) A probabilidade de um casal com quatro filhos ter dois do sexo masculino e dois do sexo feminino é:",
				25000,
				"60%",
				"50%",
				"45%",
				"37,5%",
				"25%",
				4);

		// Questão 36
		inserirQuestao("(PUC-RIO 2007)  probabilidade de um dos cem números 1, 2, 3, 4, ..., 100 ser múltiplo de 6 e de 10 ao mesmo tempo é:",
				25000,
				"3%",
				"6%",
				"2%",
				"10%",
				"60%",
				1);

		// Questão 37
		inserirQuestao("(UFMG 2008) Considere uma prova de Matemática constituída de quatro questões de múltipla escolha, com quatro alternativas cada uma, das quais apenas uma é correta. Um candidato decide fazer essa prova escolhendo, aleatoriamente, uma alternativa em cada questão. Então, é CORRETO afirmar que a probabilidade de esse candidato acertar, nessa prova, exatamente uma questão é:",
				25000,
				"27/64",
				"27/256",
				"9/64",
				"9/256",
				"8/512",
				1);

		// Questão 38
		inserirQuestao("(FUVEST 2009) Dois dados cúbicos, não viciados, com faces numeradas de 1 a 6, serão lançados simultaneamente. A probabilidade de que sejam sorteados dois números consecutivos, cuja soma seja um número primo, é de:",
				25000,
				"2/9",
				"1/3",
				"4/9",
				"5/9",
				"2/3",
				1);

		// Questão 39
		inserirQuestao("(ADVISE 2009) O quadro funcional de uma empresa é composto de 35 pessoas efetivas e 15 pessoas prestadoras de serviços. Do pessoal efetivo 20 são homens e do pessoal prestador de serviço 5 são mulheres. Escolhendo aleatoriamente uma pessoa dessa empresa, a probabilidade dessa pessoa ser homem ou prestar serviço é:",
				25000,
				"1/5",
				"7/10",
				"9/10",
				"3//5",
				"4/5",
				2);

		// Questão 40
		inserirQuestao("(PUC-RIO 2007) Um altere de massa desprezível possui uma haste de 30,0 cm de comprimento onde anilhas (pesos) podem ser fixados. Se colocarmos uma anilha de 2,0 kg na extremidade esquerda do altere e uma de 1kg na extremidade direita, o centro de massa do altere estará:",
				25000,
				"deslocado 10,0 cm para a direita a partir do centro do altere.",
				"deslocado 5,0 cm para a direita a partir do centro do altere.",
				"localizado no centro do altere.",
				"deslocado 5,0 cm para a esquerda a partir do centro do altere.",
				"deslocado 10,0 cm para a esquerda a partir do centro do altere.",
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
