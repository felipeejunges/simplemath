function novoDesafio() {
    quiz = null;
    answers = [];
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

function carregarItensTeste() {
    quiz = {
        questions: [],
        answers: []
    };
    for (i = 0; i < 10; i++) {
        var question = {
            description: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer condimentum ipsum nec rhoncus vulputate. Morbi sodales, purus nec consectetur congue, diam dolor vulputate justo, a posuere turpis velit in enim. Nullam vulputate placerat consequat. Vivamus interdum sapien diam. Donec viverra augue sed ultrices rutrum. Donec semper tellus lobortis, laoreet odio eget, hendrerit ipsum. Aenean feugiat mollis aliquet. In quis tempor nisi, vel aliquet erat.',
            alternatives: []
        };
        for (j = 0; j < 5; j++) {
            var alternative = {
                answer: j + i,
                correct: j = 3 ? 1 : 0
            };
            question.alternatives.push(alternative)
        }
        quiz.questions.push(question);
    }
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
    var questionObj = quiz.questions[i];
    var alternative = questionObj.alternatives[i];
    var answer = {
        answer: alternative
    }
    answers.push(answer);
    $("#respondidos").text(answers.length);
    console.log(answer);
    if (qntRespondidos == quiz.questions.length) {
        quiz.answers = answers;
        salvarResposta();
    } else {
        getQuestion(qntRespondidos);
    }
}

function salvarResposta() {
    var url = baseUrl + "/quiz/save/" + quiz.id;
    delete quiz.id;
    delete quiz.unactive;
    $.ajax({
        type: "PUT",
        url: url,
        data: quiz,
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
            changeSection("question", "final")
        }
    });
}