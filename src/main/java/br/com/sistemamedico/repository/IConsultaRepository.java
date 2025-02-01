package br.com.sistemamedico.repository;

import br.com.sistemamedico.model.Consulta;
import org.springframework.data.repository.CrudRepository;

public interface IConsultaRepository extends CrudRepository<Consulta, Integer> {
    Consulta findByConsultaId(Integer id);
}
