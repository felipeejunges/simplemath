var lsk = "br.com.felipejunges.simplemath";
var keyID = lsk + ".id";
var keyUsuario = lsk + ".email";
var keyNome = lsk + ".nome";
var keyNumero = lsk + ".numero";

function loginLocalStorage(usuario) {
    window.localStorage.setItem(keyID, usuario.id);
    window.localStorage.setItem(keyUsuario, usuario.email);
    window.localStorage.setItem(keyNome, usuario.name);
    window.localStorage.setItem(keyNumero, usuario.numero);
}
function logoutLocalStorage() {
    window.localStorage.clear();
}

function getValor(chaveSimples) {
    chave = lsk + "." + chaveSimples;
    return window.localStorage.getItem(chave);
}

function estaLogado() {
    if (window.localStorage.getItem(keyID) == null) {
        window.href = "/"
    } 
}