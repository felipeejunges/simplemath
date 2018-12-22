var baseUrl = 'http://localhost:8080';

function limparConfigServer() {
    $("#networkAddress").val("");
}

function salvarConfigServer() {
    baseUrl =  $("#networkAddress").val();
    limparConfigServer();
}