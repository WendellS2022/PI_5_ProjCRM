function mascaraCPF(campo) {
    let cpf = campo.value.replace(/\D/g, ""); // Remove caracteres não numéricos
    cpf = cpf.replace(/(\d{3})(\d)/, "$1.$2"); // Adiciona o primeiro ponto
    cpf = cpf.replace(/(\d{3})(\d)/, "$1.$2"); // Adiciona o segundo ponto
    cpf = cpf.replace(/(\d{3})(\d{1,2})$/, "$1-$2"); // Adiciona o hífen

    campo.value = cpf; // Atualiza o campo visível com a máscara
    document.getElementById('cpfHidden').value = campo.value.replace(/\D/g, ""); // Atualiza o campo oculto sem a máscara
}

function validarCPF(campo) {
    let cpf = campo.value.replace(/\D/g, ""); // Remove caracteres não numéricos
    let erroMsg = document.getElementById('cpfErro');

    if (cpf.length !== 11 || /^(\d)\1+$/.test(cpf)) {
        // Verifica se o CPF tem 11 dígitos e não é uma sequência de números repetidos
        erroMsg.style.display = 'inline';
        campo.setCustomValidity("CPF inválido");
        return false;
    }

    let soma = 0;
    let resto;

    // Validação do primeiro dígito verificador
    for (let i = 1; i <= 9; i++) {
        soma += parseInt(cpf.charAt(i - 1)) * (11 - i);
    }
    resto = (soma * 10) % 11;
    if (resto === 10 || resto === 11) resto = 0;
    if (resto !== parseInt(cpf.charAt(9))) {
        erroMsg.style.display = 'inline';
        campo.setCustomValidity("CPF inválido");
        return false;
    }

    // Validação do segundo dígito verificador
    soma = 0;
    for (let i = 1; i <= 10; i++) {
        soma += parseInt(cpf.charAt(i - 1)) * (12 - i);
    }
    resto = (soma * 10) % 11;
    if (resto === 10 || resto === 11) resto = 0;
    if (resto !== parseInt(cpf.charAt(10))) {
        erroMsg.style.display = 'inline';
        campo.setCustomValidity("CPF inválido");
        return false;
    }

    // CPF é válido
    erroMsg.style.display = 'none';
    campo.setCustomValidity("");
    return true;
}

function enviarCPF() {
    // Garante que o valor enviado ao backend será o do campo oculto (sem máscara)
    document.getElementById('cpf').value = document.getElementById('cpfHidden').value;
}