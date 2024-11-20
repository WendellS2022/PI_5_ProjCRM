package br.com.ProjetoCRM.demo.repository;
import br.com.ProjetoCRM.demo.model.Solicitacao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SolicitacaoRepository extends JpaRepository<Solicitacao, Long> {

    List<Solicitacao> findBySetor(String role);
}