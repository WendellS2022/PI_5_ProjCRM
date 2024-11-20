package br.com.ProjetoCRM.demo.Services.Solicitacao;

import br.com.ProjetoCRM.demo.DTO.SolicitacaoDTO;
import br.com.ProjetoCRM.demo.model.Solicitacao;
import org.springframework.security.core.Authentication;


import java.util.List;


public interface SolicaticaoService
{
    String CriarSolicitacao(SolicitacaoDTO solicitacaoDTO);
    List<Solicitacao> ReadSolicitacao(Authentication authentication);
}
