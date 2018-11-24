function carregarItens_MyHome() {
    var url = baseUrl + "/quiz/resumo/" + getValor("id");
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
            var listaResumo = retorno
            $.each(listaResumo, function (i, resumo) {
                var item = '<span class="title">' + resumo.data + '</span>';
                item += '<p>' + resumo.tempo + '<br>';
                item += '<span>' + resumo.acertos + '/<span>';
                item += '<span>' + resumos.erros + '</span>' + '</p>';
                var li = '<li class="collection-item">' + item + '</li>';
                $('#collectionResumo ul').append(li);
            });
        }
    });
}


function carregarItensTeste_MyHome() {
    var retorno = [];
    for (i = 0; i < 5; i++) {
        var dia = 3 + i;
        var obj = {
            data: '0' + dia + '/11/2018 13:13',
            tempo: '01:2' + i,
            acertos: 9,
            erros: 6
        }
        retorno.push(obj);
    }
    var listaResultado = retorno;
    $.each(listaResultado, function (i, resumo) {
        var item = '<span class="title">' + resumo.data + '</span>';
        item += '<p>' + resumo.tempo + '<br>';
        item += '<span>' + resumo.acertos + '/<span>';
        item += '<span>' + resumo.erros + '</span>' + '</p>';
        var li = '<li class="collection-item">' + item + '</li>';
        $('#collectionResumo').append(li);
        console.log(li);
    });
}