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
        error: function () {
            swal({
                type: 'error',
                title: 'Oops...',
                text: 'Aconteceu um erro desconhecido durante sua requisição'
            });
        },
        success: function (retorno) {
            changeSection("login", "myhome");
            carregarItens_MyHome();
        }
    });
}