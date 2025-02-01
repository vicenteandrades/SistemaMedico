package br.com.sistemamedico.controller;

import br.com.sistemamedico.model.Paciente;
import br.com.sistemamedico.repository.IPacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PacienteController {

    @Autowired
    private IPacienteRepository repository;


    @GetMapping("/pacientes")
    public ResponseEntity<List<Paciente>> get() {
        List<Paciente> list = (List<Paciente>) repository.findAll();
        return list.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(list);
    }

    @GetMapping("/paciente/{id}")
    public ResponseEntity<Optional<Paciente>> getById(@PathVariable Integer id){
        Optional<Paciente> paciente = repository.findById(id);
        return paciente.isPresent() ? ResponseEntity.ok(paciente) : ResponseEntity.noContent().build();
    }

    @PostMapping("/paciente/criar")
    public ResponseEntity<String> post(@RequestBody Paciente paciente){
        if(paciente == null)
            return ResponseEntity.badRequest().build();

        repository.save(paciente);
        return ResponseEntity.status(201).body("Paciente cadastrado com sucesso!");
    }

    @PutMapping("/paciente/update/{id}")
    public ResponseEntity<String> put(@PathVariable Integer id, @RequestBody Paciente paciente){
        Optional<Paciente> findPaciente = repository.findById(id);

        if(findPaciente.isEmpty() || paciente == null)
        {
            return ResponseEntity.notFound().build();
        }

        paciente.setPacienteId(id);
        repository.save(paciente);
        return ResponseEntity.ok().body("Paciente atualizado com sucesso!");
    }

    @DeleteMapping("/paciente/remover/{id}")
    public ResponseEntity<Paciente> delete(@PathVariable Integer id){
        Paciente paciente = repository.getPacienteByPacienteId(id);

        if(paciente == null)
            ResponseEntity.notFound().build();


        repository.delete(paciente);
        return ResponseEntity.noContent().build();
    }

}
