var baseUrl = 'http://localhost:8080';
$("#enderecoAtual").text(baseUrl);

function limparConfigServer() {
    $("#networkAddress").val("");
}

function salvarConfigServer() {
    baseUrl =  $("#networkAddress").val();
    $("#enderecoAtual").text(baseUrl);
    limparConfigServer();
}