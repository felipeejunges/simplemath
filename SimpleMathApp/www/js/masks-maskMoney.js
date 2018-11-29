// Require JQuery, JQueryMaskMoney (Plentz) and JQuery Mask (IgorEscobar)
$(document).ready(function () {
    multipleFormat();
});

function multipleFormat() {
    $('.moeda').maskMoney({ prefix: 'R$ ', allowNegative: true, thousands: ".", decimal: ",", affixesStay: true, allowZero: true });
    var valor = $('.money-brl-allowNegative').each(function () {
        $(this).maskMoney('mask', $(this).val())[0].value;
    });
    console.log("Tipo: " + typeof (valor) + ", Valor: " + valor)

    $('.moedasemnegativo').maskMoney({ prefix: 'R$ ', allowNegative: false, thousands: ".", decimal: ",", affixesStay: true, allowZero: true });
    var valor = $('.money-brl').each(function () {
        $(this).maskMoney('mask', $(this).val())[0].value;
    });
    console.log("Tipo: " + typeof (valor) + ", Valor: " + valor)

    $('.porcentagem').maskMoney({ suffix: '%', allowNegative: false, thousands: ".", decimal: ",", affixesStay: true, allowZero: true });
    var valor = $('.percent').each(function () {
        $(this).maskMoney('mask', $(this).val())[0].value;
    });

    $('.numeral').maskMoney({allowNegative: false, thousands: ".", decimal: ",", affixesStay: true, allowZero: true });
    var valor = $('.numeral').each(function () {
        $(this).maskMoney('mask', $(this).val())[0].value;
    });

    $('.centimetro').maskMoney({ suffix: ' cm', allowNegative: false, thousands: ".", decimal: ",", affixesStay: true, allowZero: true });
    var valor = $('.centimeter').each(function () {
        $(this).maskMoney('mask', $(this).val())[0].value;
    });

    $('.milimitro').maskMoney({ suffix: ' mm', allowNegative: false, thousands: ".", decimal: ",", affixesStay: true, allowZero: true });
    var valor = $('.millimeter').each(function () {
        $(this).maskMoney('mask', $(this).val())[0].value;
    });

    $('.metro').maskMoney({ suffix: ' m', allowNegative: false, thousands: ".", decimal: ",", affixesStay: true, allowZero: true });
    var valor = $('.meter').each(function () {
        $(this).maskMoney('mask', $(this).val())[0].value;
    });

}