package br.com.sistemamedico.controller;

import br.com.sistemamedico.model.Consulta;
import br.com.sistemamedico.repository.IConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ConsultaRepository {

    @Autowired
    private IConsultaRepository repository;

    @GetMapping("/consultas")
    public ResponseEntity<List<Consulta>> get(){
        List<Consulta> list = (List<Consulta>) repository.findAll();

        if(list.isEmpty())
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(list);
    }

    @GetMapping("/consultas/{id}")
    public ResponseEntity<Consulta> post(@PathVariable Integer id) {
        Consulta consulta = repository.findByConsultaId(id);

        if(consulta == null)
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(consulta);
    }

    @PostMapping("/consultas/agendar")
    public ResponseEntity<String> post(@RequestBody Consulta consulta){
        if(consulta == null)
            return ResponseEntity.badRequest().build();

        repository.save(consulta);
        return ResponseEntity.ok("Consulta agendada com sucesso!");
    }

    @DeleteMapping("/consultas/deletar/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) {
        if (id == null || id <= 0) {
            return ResponseEntity.badRequest().body("ID inválido.");
        }

        Consulta consulta = repository.findByConsultaId(id);

        if (consulta == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Consulta não encontrada.");
        }

        repository.delete(consulta);
        return ResponseEntity.noContent().build();
    }


}
