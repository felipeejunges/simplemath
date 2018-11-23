function novoDesafio() {
    quiz = null;
    answers = [];
    var url = baseUrl + "/quiz/new/" + usuario.id
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
    var question = quiz.questions[i];
    var pergunta = question.question;
    $("#pQuestao").val() + pergunta;
    question.alternatives.foreach(forEachAlternative);
}
function forEachAlternative(item, index) {
    var opcao = "a) "
    if(index == 1) opcao = "b) "
    if(index == 2) opcao = "c) "
    if(index == 3) opcao = "d) "
    if(index == 4) opcao = "e) "
    $("#pQuestao").val() = $("#pQuestao").val() + "<br>" + opcao + item;
}

function answerQuestion(i) {
    qntRespondidos = $("#respondidos").val();
    var question = quiz.questions[i];
    var alternative = question.alternatives[0];
    var answer = {
        question: question,
        answer: alternative
    }
    answers.add(answer);
    $("#respondidos").val(answers.length);

    if (qntRespondidos == answers.size()) {
        quiz.answers = answers;
        salvarResposta();
    } else {
        getQuestion(qntRespondidos.val());
    }
}

function salvarResposta() {
    var url = baseUrl + "/quiz/save/" + id
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