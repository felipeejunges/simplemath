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
    
    $( "#btnLogout").removeClass("hide");
}
function logoutLocalStorage() {
    window.localStorage.clear();
    estaLogado();
}

function getValor(chaveSimples) {
    chave = lsk + "." + chaveSimples;
    return window.localStorage.getItem(chave);
}

function estaLogado() {
    $( "#cadastro" ).addClass("hide");
    $( "#final" ).addClass("hide");
    $( "#question" ).addClass("hide");
   // $( "#login" ).addClass("hide");
    $( "#cadastroQuestao" ).addClass("hide");
    if (window.localStorage.getItem(keyID) == null) {
         $( "#myhome" ).addClass("hide");
        $( "#login" ).removeClass("hide");
         $( "#btnLogout").addClass("hide");
    }  else {
        $( "#login" ).addClass("hide");
        $( "#myhome" ).removeClass("hide");
        $( "#btnLogout").removeClass("hide");
        carregarItens_MyHome();
    }
}