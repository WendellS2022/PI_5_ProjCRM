function verificarEmail() {
    const emailInput = document.getElementById('Email');
    const botaoEnviar = document.getElementById('botaoEnviar');


    botaoEnviar.disabled = !emailInput.value || !validarFormatoEmail(emailInput.value);
}

function validarFormatoEmail(email) {

    const emailRegex = /^[a-zA-Z0-9_%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
    return emailRegex.test(email);
}

function aplicarMascaraEmail() {
    const emailInput = document.getElementById('Email');


    emailInput.value = emailInput.value
        .replace(/\s+/g, '')
        .replace(/[^a-zA-Z0-9_@-]/g, '');
}

function mostrarMensagem() {
    const emailInput = document.getElementById('Email').value;

    alert(`Seu protocolo foi enviado para o e-mail: ${emailInput}`);
}