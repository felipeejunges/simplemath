// Require JQuery, JQueryMaskMoney (Plentz) and JQuery Mask (IgorEscobar)
$(document).ready(function () {
    formatPhonenumber();
    formatDocument();
    formatZIPCode();
});
function formatPhonenumber() {
    var SPMaskBehavior = function (val) {
        return val.replace(/\D/g, '').length === 11 ? '(00) 00000-0000' : '(00) 0000-00009';
    },
        spOptions = {
            onKeyPress: function (val, e, field, options) {
                field.mask(SPMaskBehavior.apply({}, arguments), options);
            }
        };
    $('.telefone').mask(SPMaskBehavior, spOptions);
}


function formatDocument() {
    var SPMaskBehavior = function (val) {
        return val.replace(/\D/g, '').length > 11 ? '00.000.000/0000-00' : '000.000.000-009';
    },
        spOptions = {
            onKeyPress: function (val, e, field, options) {
                field.mask(SPMaskBehavior.apply({}, arguments), options);
            }
        };
    $('.cnpjcpf').mask(SPMaskBehavior, spOptions);
    $('.cnpjcpf').mask(SPMaskBehavior, spOptions);
    $('.cpf').mask('000.000.000-00', { reverse: true });
    $('.cnpj').mask('00.000.000/0000-00', { reverse: true });
}

function formatZIPCode() {
    $(".cep").mask("99999-999");
}