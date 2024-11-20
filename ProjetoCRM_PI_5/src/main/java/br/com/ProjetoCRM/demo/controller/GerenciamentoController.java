package br.com.ProjetoCRM.demo.controller;

import br.com.ProjetoCRM.demo.Services.Solicitacao.SolicaticaoService;
import br.com.ProjetoCRM.demo.model.Solicitacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class GerenciamentoController {

    @Autowired
    SolicaticaoService solicaticaoService;
    @GetMapping("/gerenciamento")
    public String gerenciamento(Model model, Authentication authentication)
    {
        List<Solicitacao> solicitacoes = solicaticaoService.ReadSolicitacao(authentication);
        model.addAttribute("username", authentication.getName());
        model.addAttribute("solicitacoes", solicitacoes);
        return "GerenciamentoTemplate";
    }
}

