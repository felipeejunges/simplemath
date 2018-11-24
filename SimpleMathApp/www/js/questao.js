function novoDesafio() {
    quiz = null;
    answers = [];
    $("#respondidos").text("0");
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
    $("#pQuestao").text(pergunta) ;
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
    qntRespondidos = $("#respondidos").text();
    var questionObj = quiz.questions[qntRespondidos];
    var alternative = questionObj.alternatives[i];
    var answer = {
        "alternative": alternative
    }
    answers.push(answer);
    $("#respondidos").text(answers.length);
    console.log(answer);
    if (qntRespondidos == quiz.questions.length - 1) {
        quiz.answers = answers;
        salvarResposta();
    } else {
        getQuestion(qntRespondidos);
    }
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