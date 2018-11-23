function cadastro() {
    var url = baseUrl + "/usuarios/"
    var usuario = {
        name: $('#nome').val(),
        email: $('#email').val(),
        celphoneNumber: $('#telefone').val(),
        password: $('#password').val()
    };
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
            swal({
                type: 'success',
                title: 'Cadastro realizado com sucesso!',
                timer: 1500
            });
            changeSection("login", "cadastro");
        }
    });
}