
var temperatura;
var estadoLampada;

//função chamada no momento que a página é carregada
function atualizarEstadoDosObjetos(){
    $.get(
            '192.168.2.2:8080/App/webresources/arcondicionado',
            function (response){
                var resp = JSON.stringify(response);
                var data = JSON.parse(resp);
                temperatura = data.valorTemperatura;
                atualizarExibicaoTemperatura(temperatura);
            }
    );

    $.get(
            '192.168.2.2:8080/App/webresources/lampada',
            function (response){
                estadoLampada = response;
                atualizarExibicaoDoEstatusDaLampada(response);
            }
    );
}


function aumentarTemperatura(){
    alterarTemperatura(temperatura + 1);
}

function diminuirTemperatura(){
    alterarTemperatura(temperatura - 1);
}

function ligarLampada(){
    alterarEstadoDaLampada("Ligada");
    estadoLampada = "Ligada";
}

function desligarLampada(){
    alterarEstadoDaLampada("Desligada");
    estadoLampada = "Desligada";
}

function alterarTemperatura(temperatura) {
    $.ajax({
            url:'192.168.2.2:8080/App/webresources/arcondicionado',
            type: 'PUT',
            contentType: 'application/json; charset=utf-8',
            data: { temperatura: temperatura} ,
            success: function (response) {
                var resp = JSON.stringify(response);
                var data = JSON.parse(resp);
                temperatura = data.valorTemperatura;
                atualizarExibicaoTemperatura(data.valorTemperatura);
            },
            error: function () {
                alert("deu erro!");
            }
        });
}

function alterarEstadoDaLampada(estado) {
    $.ajax({
            url:'192.168.2.2:8080/App/webresources/lampada',
            type: 'PUT',
            contentType: 'application/json; charset=utf-8',
            data: { temperatura: temperatura} ,
            success: function (response) {
                var resp = JSON.stringify(response);
                var data = JSON.parse(resp);
                temperatura = data.estadoLampada;
                atualizarExibicaoDoEstatusDaLampada(data.estadoLampada);
            },
            error: function () {
                alert("deu erro!");
            }
        });
}

function atualizarExibicaoTemperatura(t) {
    document.getElementById("spanTemp").innerHTML = t;
}

function atualizarExibicaoDoEstatusDaLampada(status) {
    document.getElementById("spanLampada").innerHTML = status;
}