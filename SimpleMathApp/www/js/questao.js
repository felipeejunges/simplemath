
var totalTempo = new Stopwatch("tempoTotal_Questao");
var mediaTempo = new Stopwatch("tempoAtual_Questao");
 
function novoDesafio() {
    quiz = null;
    answers = [];
    $("#respondidos").text("0");
    totalTempo.start();
    var url = baseUrl + "/quiz/new/" + getValor("id")
    $.ajax({
        type: "GET",
        url: url,
        timeout: 3000,
        datatype: 'JSON',
        contentType: "application/json; charset=utf-8",
        cache: false,
        error: function () {
            swal({
                type: 'error',
                title: 'Oops...',
                text: 'Aconteceu um erro desconhecido durante sua requisição'
            });
        },
        success: function (retorno) {
            quiz = retorno;
            changeSection("myhome", "question");
            getQuestion(0);
        }
    });
}

// Responder
function getQuestion(i) {
    var questionObj = quiz.questions[i];
    var pergunta = questionObj.description;
    for(i = 0; i < 5; i ++) {
        pergunta += forEachAlternative(questionObj.alternatives[i].answer, i);
    }
    $("#pQuestao").text(pergunta);
    mediaTempo.clear();
    mediaTempo.start();
}
function forEachAlternative(item, index) {
    var opcao = "a) "
    if(index == 1) opcao = "b) "
    if(index == 2) opcao = "c) "
    if(index == 3) opcao = "d) "
    if(index == 4) opcao = "e) "
    return "\n\n" + opcao + item;
}

function answerQuestion(i) {
    preloadspinner.start();
    qntRespondidos = $("#respondidos").text();
    var questionObj = quiz.questions[qntRespondidos];
    var alternative = questionObj.alternatives[i];
    var answer = {
        "alternative": alternative,
        "time": timeToMs(mediaTempo.retorno())
    }
    answers.push(answer);
    $("#respondidos").text(answers.length);
    console.log(answer);
    if (qntRespondidos == quiz.questions.length - 1) {
        quiz.answers = answers;
        totalTempo.stop();
        mediaTempo.stop();
        salvarResposta();
        totalTempo.clear();
        mediaTempo.clear();
    } else {
        mediaTempo.stop();
        getQuestion(qntRespondidos);
    }
    preloadspinner.end();
}

function salvarResposta() {
    var url = baseUrl + "/quiz/save"
    $.ajax({
        type: "POST",
        url: url,
        data: JSON.stringify(quiz),
        timeout: 3000,
        datatype: 'JSON',
        contentType: "application/json; charset=utf-8",
        cache: false,
        error: function () {
            swal({
                type: 'error',
                title: 'Oops...',
                text: 'Aconteceu um erro desconhecido durante sua requisição'
            });
        },
        success: function (retorno) {
            carregarItens_Final();
            changeSection("question", "final")
        }
    });
}