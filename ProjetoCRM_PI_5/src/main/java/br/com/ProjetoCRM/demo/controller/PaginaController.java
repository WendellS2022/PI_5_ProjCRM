package br.com.ProjetoCRM.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class PaginaController {
    @GetMapping("/termos")
    public String mostrarTermos() {
        return "Termos";
    }

    @GetMapping("/Sobre")
    public String mostrarQuemSomos() {
        return "QuemSomos";
    }
}
