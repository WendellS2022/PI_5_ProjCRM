package br.com.ProjetoCRM.demo.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class EmailDTO {
    private String email;
    private String subject;
    private String body;
}
