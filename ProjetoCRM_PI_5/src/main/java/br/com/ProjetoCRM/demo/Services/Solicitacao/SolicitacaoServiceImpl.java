package br.com.ProjetoCRM.demo.Services.Solicitacao;

import br.com.ProjetoCRM.demo.DTO.SolicitacaoDTO;
import br.com.ProjetoCRM.demo.model.Paciente;
import br.com.ProjetoCRM.demo.model.Solicitacao;
import br.com.ProjetoCRM.demo.repository.PacienteRepository;
import br.com.ProjetoCRM.demo.repository.SolicitacaoRepository;
import jakarta.transaction.Transactional;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;
import org.springframework.security.core.Authentication;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class SolicitacaoServiceImpl implements SolicaticaoService {

    private final PacienteRepository pacienteRepository;
    private final SolicitacaoRepository solicitacaoRepository;


    public SolicitacaoServiceImpl(PacienteRepository pacienteRepository, SolicitacaoRepository solicitacaoRepository) {
        this.pacienteRepository = pacienteRepository;
        this.solicitacaoRepository = solicitacaoRepository;
    }

    private String GerarProtoocolo() {
        // Generate a random UUID
        UUID uuid = UUID.randomUUID();
        String formattedId = "V-" + uuid.toString().replace("-", "").toUpperCase().substring(0, 8);
        return formattedId;
    }

    @Override
    @Transactional
    public String CriarSolicitacao(SolicitacaoDTO solicitacaoDTO) {
        Paciente paciente;

        // Check if the patient exists and retrieve them if they do
        Optional<Paciente> existingPaciente = pacienteRepository.findByCpf(solicitacaoDTO.getCpf());

        if (existingPaciente.isEmpty()) {
            // Create a new Paciente if not found
            paciente = new Paciente();
            paciente.setCpf(solicitacaoDTO.getCpf());
            paciente.setNome(solicitacaoDTO.getNome());
            paciente.setDataNascimento(solicitacaoDTO.getDataNascimento());
            pacienteRepository.save(paciente); // Save and reassign to capture the saved entity
        }

        // Create and populate the Solicitacao with details from the DTO
        Solicitacao solicitacao = new Solicitacao();
        solicitacao.setUltimaConsulta(solicitacaoDTO.getUltimaConsulta());
        solicitacao.setDescricaoSolicitacao(solicitacaoDTO.getDescricaoSolicitacao());
        solicitacao.setNotaDetalhada(solicitacaoDTO.isNotaDetalhada());
        solicitacao.setNotaFiscal(solicitacaoDTO.isNotaFiscal());
        solicitacao.setDevolucao(solicitacaoDTO.isDevolucao());
        solicitacao.setReceitaOculos(solicitacaoDTO.isReceitaOculos());
        solicitacao.setRelatorioMedico(solicitacaoDTO.isRelatorioMedico());
        solicitacao.setPedidoMedico(solicitacaoDTO.isPedidoMedico());
        solicitacao.setAtestadoMedico(solicitacaoDTO.isAtestadoMedico());
        solicitacao.setDeclaracaoHoras(solicitacaoDTO.isDeclaracaoHoras());
        solicitacao.setResultadoExames(solicitacaoDTO.isResultadoExames());
        solicitacao.setCpf(Long.valueOf(solicitacaoDTO.getCpf()));
        solicitacao.setSetor(solicitacaoDTO.getSetor());
        solicitacao.setStatus("pendente");

        String protocolo = GerarProtoocolo();

        solicitacao.setProtocolo(protocolo);
        solicitacaoRepository.save(solicitacao);

        return protocolo;
    }


    @Override
    public List<Solicitacao> ReadSolicitacao(Authentication authentication) {


        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

        // Assuming each user has exactly one role
        String role = authorities.iterator().next().getAuthority();

        List<Solicitacao> solicitacoes = solicitacaoRepository.findBySetor(role.replaceFirst("^ROLE_", ""));
        // Collect all unique CPFs from solicitacoes
        Set<Long> cpfs = solicitacoes.stream()
                .map(Solicitacao::getCpf)
                .collect(Collectors.toSet());
        // Fetch all Paciente entities in a batch
        List<Paciente> pacientes = pacienteRepository.findAllById(cpfs);
        // Map of CPF to Paciente
        Map<Long, Paciente> cpfToPacienteMap = pacientes.stream()
                .collect(Collectors.toMap(Paciente::getCpf, Function.identity()));

        // Set Paciente for each Solicitacao
        solicitacoes.forEach(solicitacao -> {
            Paciente paciente = cpfToPacienteMap.get(solicitacao.getCpf());
            solicitacao.setPaciente(paciente);
        });

        return solicitacoes;
    }


}
