package br.com.ProjetoCRM.demo.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TelaInicialController {

    @GetMapping("/")
    public String home() {
        return "TelaPrincipal";
    }

}