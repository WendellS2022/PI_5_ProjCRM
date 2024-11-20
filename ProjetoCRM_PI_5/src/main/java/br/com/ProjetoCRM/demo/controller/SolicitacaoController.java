package br.com.ProjetoCRM.demo.controller;
import br.com.ProjetoCRM.demo.DTO.SolicitacaoDTO;
import br.com.ProjetoCRM.demo.Services.Solicitacao.SolicaticaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class SolicitacaoController {

    @Autowired
    SolicaticaoService solicaticaoService;

    @GetMapping("/formulario")
    public String formulario() {
        return "SolicitacaoTemplate";
    }


    @PostMapping("/criarSolicitacao")
    public String create(SolicitacaoDTO solicitacaoDTO, RedirectAttributes redirectAttributes)
    {
         String protocolo = solicaticaoService.CriarSolicitacao(solicitacaoDTO);
         redirectAttributes.addFlashAttribute("protocolo", protocolo);
         return "redirect:protocolo";
    }
}

