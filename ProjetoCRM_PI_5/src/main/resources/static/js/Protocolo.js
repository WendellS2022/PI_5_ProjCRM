// Função para gerar o próximo número do protocolo
function gerarNumeroProtocolo() {
    // Verifica se já há um número do protocolo armazenado no armazenamento local
    var ultimoNumero = localStorage.getItem('ultimoNumeroProtocolo');

    // Se não houver um último número de protocolo, comece com 1
    if (!ultimoNumero) {
        ultimoNumero = 0;
    }

    // Converte o último número do protocolo em um número inteiro
    ultimoNumero = parseInt(ultimoNumero);

    // Incrementa o último número do protocolo
    ultimoNumero++;

    // Formata o número do protocolo com zeros à esquerda se necessário
    var numeroFormatado = ('00' + ultimoNumero).slice(-3);

    // Armazena o novo número do protocolo no armazenamento local
    localStorage.setItem('ultimoNumeroProtocolo', ultimoNumero);

    // Retorna o número do protocolo formatado
    return numeroFormatado;
}


function enviarProtocolo() {
    var numeroProtocolo = gerarNumeroProtocolo();
    var paragrafoProtocolo = document.getElementById("protocolo");
    var emailInput = document.getElementById("Email").value;
    paragrafoProtocolo.textContent = "Seu Protocolo é: " + numeroProtocolo;

    console.log("Protocolo enviado para: " + emailInput);
}
