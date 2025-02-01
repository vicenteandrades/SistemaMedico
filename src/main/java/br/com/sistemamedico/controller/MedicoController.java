package br.com.sistemamedico.controller;

import br.com.sistemamedico.model.Medico;
import br.com.sistemamedico.repository.IMedicoRepository;
import br.com.sistemamedico.services.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.resource.ResourceUrlProvider;

import java.util.List;

@RestController
public class MedicoController {

    @Autowired
    private IMedicoRepository repository;
    private MedicoService service;

    @GetMapping("medicos")
    public ResponseEntity<List<Medico>> get(){
        List<Medico> list = (List<Medico>) repository.findAll();

        if(list.isEmpty())
            return ResponseEntity.notFound().build();


        return ResponseEntity.ok(list);
    }

    @GetMapping("/medicos/{crm}")
    public ResponseEntity<Medico> getByCrm(@PathVariable String crm) {
        Medico medico = repository.findByCrm(crm);

        if(medico == null)
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(medico);
    }
    @PostMapping("/medicos/criar")
    public ResponseEntity<String> post(@RequestBody Medico medico){
        boolean verificaCrm = service.validarCRM(medico.getCrm());

        if(!verificaCrm)
            return ResponseEntity.status(400).body("Verifique o CRM");

        repository.save(medico);
        return ResponseEntity.status(201).build();
    }

    @PutMapping("/medicos/atualizar/{crm}")
    public ResponseEntity<String> put(@PathVariable String crm, @RequestBody Medico medico){
        boolean verificaCrm = service.validarCRM(medico.getCrm());

        if(!verificaCrm){
            return ResponseEntity.status(400).body("Verifique o CRM");
        }

        Medico procurarMedico = repository.findByCrm(crm);
        if(procurarMedico == null)
            return ResponseEntity.status(404).body("Medico não encontrado");

        repository.save(medico);
        return ResponseEntity.status(204).body("Atualizado com sucesso!");
    }

    @DeleteMapping("/medicos/remover/{crm}")
    public ResponseEntity<String> delete(@PathVariable  String crm){
        Medico medico = repository.findByCrm(crm);

        if(medico == null)
            return ResponseEntity.notFound().build();

        repository.delete(medico);
        return ResponseEntity.status(204).body("Excluido com sucesso!");
    }

}
