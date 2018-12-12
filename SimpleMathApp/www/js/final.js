function carregarItens_Final() {
    var url = baseUrl + "/quiz/final/" + quiz.id;
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
            var acertos = 0;
            var erros = 0;
            var tempototal = retorno.tempoTotal;
            var tempomedio =  retorno.tempoMedio;
            var tempoesperado =  retorno.tempoEsperado;
            var listaResultado = retorno.answer;
            var j = 0;
            $.each(listaResultado, function (i, resultado) {
                var resultColor = ' red-text';
                var result ='Incorreta';
                if(resultado.alternative.correct == true) { 
                    acertos += 1;
                    result = 'Correta';
                    resultColor = ' green-text';
                }
                else { erros += 1 }
                var item = '<strong class="title col s9 left-align ' + resultColor + '">Resposta ' + result + ' da questão ' + j + '</strong>';
                item += '<span class="right-align">' + msToTime(resultado.time) + '</span>';
                var li = '<li class="collection-item">' + item + '</li>';
                $('#collectionResultado').append(li);
                j++;
            });
            $("#qntAcertos_Final").text(acertos);
            $("#qntErros_Final").text(erros);
            $("#tempoMedio_Final").text(msToTime(tempototal));
            $("#tempoTotal_Final").text(msToTime(tempomedio));
            $("#tempoEsperado_Final").text(msToTime(tempoesperado));
        }
    });
}

function finalizar() {
    changeSection("final", "myhome")
    carregarItens_MyHome();
    // $( "#final" ).addClass("hide");
    // $( "#myhome" ).removeClass("hide");
}

function carregarItensTeste_Final() {
    var retorno = [];
    for (i = 0; i < 5; i++) {
        var isCorrect = i % 2 ? 0 : 1; 
        var obj = {
            correto: isCorrect,
            tempo: '01:2' + i
        }
        retorno.push(obj);
    }
    var listaResultado = retorno;
    var j = 0;
    $.each(listaResultado, function (i, resultado) {
        j++;
        var resultColor = ' red-text';
        var result ='Incorreta';
        if(resultado.correto == true) {
            result = 'Correta'
            resultColor = ' green-text'
        }
        var item = '<strong class="title col s9 left-align ' + resultColor + '">Resposta ' + result + ' da questão ' + j + '</strong>';
        item += '<span class="right-align">' + resultado.tempo + '</span>';
        var li = '<li class="collection-item">' + item + '</li>';
        $('ul#collectionResultado').append(li);
        console.log(li);
    });
}