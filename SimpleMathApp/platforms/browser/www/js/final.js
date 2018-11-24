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
            $.each(listaResultado, function (i, resultado) {
                if(resultado.alternative.correct == true) { acertos += 1 }
                else { erros += 1 }
                var item = '<span class="title">' + resultado.alternative.correct + '</span>';
                item += '<p>' + resultado.time + '</p>';
                var li = '<li class="collection-item">' + item + '</li>';
                $('#collectionResultado').append(li);
            });
            $("#qntAcertos_Final").text(acertos);
            $("#qntErros_Final").text(erros);
            $("#tempoMedio_Final").text(tempototal);
            $("#tempoTotal_Final").text(tempomedio);
            $("#tempoEsperado_Final").text(tempoesperado);
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
        var obj = {
            correto: 1,
            tempo: '01:2' + i
        }
        retorno.push(obj);
    }
    var listaResultado = retorno;
    $.each(listaResultado, function (i, resultado) {
        var item = '<span class="title">' + resultado.correto ? 'Correto' : 'Errado' + '</span>';
        item += '<p>' + resultado.tempo + '</p>';
        var li = '<li class="collection-item">' + item + '</li>';
        $('ul#collectionResultado').append(li);
        console.log(li);
    });
}