package br.com.ProjetoCRM.demo.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProtocoloController {

    @GetMapping("/protocolo")
    public String protocolo() {
        return "ProtocoloTemplate";
    }
}
