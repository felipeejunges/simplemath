function cadastroQuestao() {
    var url = baseUrl + "/questions/"
    var questao = {
        question: $('#questionDescription').val(),
        a: $('#alternativeA').val(),
        b: $('#alternativeB').val(),
        c: $('#alternativeC').val(),
        d: $('#alternativeD').val(),
        e: $('#alternativeE').val(),
        maxtime: $('#maxtimeCadastro').val(),
        correct: $('#selectCorrect').val()
    };
}

function cadastroQuestaoAjax(url, questao) {
    $.ajax({
        type: "POST",
        url: url,
        timeout: 3000,
        data: JSON.stringify(questao),
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
            $('#questionDescription').val("");
            $('#alternativeA').val("");
            $('#alternativeB').val("");
            $('#alternativeD').val("");
            $('#alternativeD').val("");
            $('#alternativeE').val("");
            $('#selectCorrect').val("");
            $('#maxtimeCadastro').val("");
            swal({
                type: 'success',
                title: 'Cadastro realizado com sucesso!',
                timer: 1500
            });
            changeSection("login", "cadastroQuestao");
        }
    });
}