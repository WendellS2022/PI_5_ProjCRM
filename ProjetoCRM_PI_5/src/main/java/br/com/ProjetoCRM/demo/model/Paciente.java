package br.com.ProjetoCRM.demo.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.Id;

import java.time.LocalDate;
import java.util.List;


@Entity @Getter
@Setter
public class Paciente {

    private Long id;

    @Column(nullable=false)
    private String nome;

    @Id
    private Long cpf;

    @Column(nullable=false)
    private LocalDate dataNascimento;

    @OneToMany(mappedBy = "cpf")
    private List<Solicitacao> solicitacao;


}
