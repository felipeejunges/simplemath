function carregarItens_Final() {
    var url = baseUrl + "/quiz/resultado/" + id
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
            var listaResultado = retorno.answers;
            $.each(listaResultado, function (i, resultado) {
                var item = '<span class="title">' + resultado.correct + '</span>';
                item += '<p>' + resultado.tempo + '</p>';
                var li = '<li class="collection-item">' + item + '</li>';
                $('#collectionResultado ul').append(li);
            });
        }
    });
}

function finalizar() {
    changeSection("final", "myhome")
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