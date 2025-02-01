package br.com.sistemamedico.repository;

import br.com.sistemamedico.model.Paciente;
import org.springframework.data.repository.CrudRepository;

public interface IPacienteRepository extends CrudRepository<Paciente, Integer> {
    Paciente getPacienteByPacienteId(Integer id);

}
