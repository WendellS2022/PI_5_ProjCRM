package br.com.ProjetoCRM.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


@Entity @Getter
@Setter
public class Solicitacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate UltimaConsulta;
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
    private Long cpf;
    private String protocolo;
    private String status;

    @OneToOne
    @JoinColumn(name = "cpf", referencedColumnName = "cpf", insertable = false, updatable = false)
    private Paciente paciente;

    @Override
    public String toString() {
        return "Solicitacao{" +
                "id=" + id +
                ", ultimaConsulta=" + UltimaConsulta +
                ", descricaoSolicitacao='" + descricaoSolicitacao + '\'' +
                ", setor='" + setor + '\'' +
                ", notaDetalhada=" + notaDetalhada +
                ", notaFiscal=" + notaFiscal +
                ", devolucao=" + devolucao +
                ", receitaOculos=" + receitaOculos +
                ", relatorioMedico=" + relatorioMedico +
                ", pedidoMedico=" + pedidoMedico +
                ", atestadoMedico=" + atestadoMedico +
                ", declaracaoHoras=" + declaracaoHoras +
                ", resultadoExames=" + resultadoExames +
                ", cpf=" + cpf +
                ", protocolo='" + protocolo + '\'' +
                '}';
    }

}
