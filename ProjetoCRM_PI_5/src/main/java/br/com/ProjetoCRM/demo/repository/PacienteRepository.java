package br.com.ProjetoCRM.demo.repository;
import br.com.ProjetoCRM.demo.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
    Optional<Paciente> findByCpf(Long cpf);

}