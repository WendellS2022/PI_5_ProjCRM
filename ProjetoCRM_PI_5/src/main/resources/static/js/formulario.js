function hideAllSections() {
    $("#financiero, #ambulatorio, #exames").hide();
}

function showSection(sectionId) {
    $(sectionId).show();
}

$(document).ready(function () {
    const queryString = window.location.search;
    const urlParams = new URLSearchParams(queryString);
    const setor = urlParams.get('setor');

    hideAllSections();
    switch (parseInt(setor)) {
        case 0:
            showSection("#financiero");
            $("#setor").val("financiero");
            break;
        case 1:
            showSection("#ambulatorio");
            $("#setor").val("ambulatorio");
            break;
        case 2:
            showSection("#exames");
            $("#setor").val("exames");
            break;
        default:
            console.log("Setor não encontrado", "setor=" + setor);
            window.location.href = "/";
            break;
    }

    // Função para validar CPF sem aplicação de máscara
    // function validarCPF(cpf) {
    //     cpf = cpf.replace(/\D/g, ""); // Remove qualquer caractere não numérico
    //     if (cpf.length !== 11 || /^(\d)\1+$/.test(cpf)) return false;
    //     let soma = 0;
    //     for (let i = 0; i < 9; i++) soma += parseInt(cpf.charAt(i)) * (10 - i);
    //     let resto = (soma * 10) % 11;
    //     if (resto === 10 || resto === 11) resto = 0;
    //     if (resto !== parseInt(cpf.charAt(9))) return false;
    //     soma = 0;
    //     for (let i = 0; i < 10; i++) soma += parseInt(cpf.charAt(i)) * (11 - i);
    //     resto = (soma * 10) % 11;
    //     return resto === parseInt(cpf.charAt(10));
    // }

    function validarData(dataInput) {
        const data = new Date(dataInput);
        const dataAtual = new Date();
        dataAtual.setHours(0, 0, 0, 0);
        if (isNaN(data.getTime())) return "Insira uma data no formato: Dia/Mês/Ano.";
        if (data > dataAtual) return "A data não pode ser futura.";
        return "";
    }

    $("#cpf").on("input", function () {
        const rawCPF = this.value.replace(/\D/g, ""); // Remove qualquer máscara visual
        if (!validarCPF(rawCPF)) {
            $(this).get(0).setCustomValidity("CPF inválido.");
            $(this).next(".error-message").text("CPF inválido.");
        } else {
            $(this).get(0).setCustomValidity("");
            $(this).next(".error-message").text("");
        }
    });

    $("#dataNascimento, #ultimaConsulta").on("input", function () {
        const mensagemErro = validarData(this.value);
        if (mensagemErro) {
            $(this).get(0).setCustomValidity(mensagemErro);
            $(this).next(".error-message").text(mensagemErro);
        } else {
            $(this).get(0).setCustomValidity("");
            $(this).next(".error-message").text("");
        }
    });

    $("#pacienteForm").on("submit", function (e) {
        if (!$("#financiero input:checked, #ambulatorio input:checked, #exames input:checked").length) {
            e.preventDefault();
            $("#checkbox-error").text("Por favor, selecione pelo menos uma opção.");
        } else {
            $("#checkbox-error").text("");
        }
    });
});
