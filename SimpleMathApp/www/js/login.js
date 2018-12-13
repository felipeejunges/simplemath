function login() {
    var url = baseUrl + "/usuarios/login/"
    var usuario = {
        email: $('#emailLogin').val(),
        password: $('#passwordLogin').val()
    };
    console.log(usuario);
    $.ajax({
        type: "POST",
        url: url,
        timeout: 3000,
        data: JSON.stringify(usuario),
        datatype: 'JSON',
        contentType: "application/json; charset=utf-8",
        cache: false,
        beforeSend: function() {
            preloadspinner.start();
        },
        error: function () {
            swal({
                type: 'error',
                title: 'Oops...',
                text: 'Aconteceu um erro desconhecido durante sua requisição'
            });
            preloadspinner.end();
        },
        success: function (retorno) {
            $('#emailLogin').val("");
            $('#passwordLogin').val("");
            changeSection("login", "myhome");
            loginLocalStorage(retorno);
            carregarItens_MyHome();
            preloadspinner.end();
        }
    });
}