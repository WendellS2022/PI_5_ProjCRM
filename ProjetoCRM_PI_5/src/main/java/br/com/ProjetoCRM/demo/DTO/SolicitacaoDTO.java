package br.com.ProjetoCRM.demo.DTO;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Getter @Setter
public class SolicitacaoDTO {
    // Paciente fields
    private Long cpf;
    private String nome;
    private LocalDate dataNascimento;

    // Solicitacao fields
    private LocalDate ultimaConsulta;
    private String descricaoSolicitacao;
    private String setor;
    private boolean notaDetalhada;
    private boolean notaFiscal;
    private boolean devolucao;
    private boolean receitaOculos;
    private boolean relatorioMedico;
    private boolean pedidoMedico;
    private boolean atestadoMedico;
    private boolean declaracaoHoras;
    private boolean resultadoExames;
    private Long sol_cpf;
    private String status;

}
