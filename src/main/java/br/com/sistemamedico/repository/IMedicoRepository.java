package br.com.sistemamedico.repository;

import br.com.sistemamedico.model.Medico;
import org.springframework.data.repository.CrudRepository;

public interface IMedicoRepository extends CrudRepository<Medico, String> {
    Medico findByCrm(String crm);
}
