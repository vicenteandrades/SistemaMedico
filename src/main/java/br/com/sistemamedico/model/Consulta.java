package br.com.sistemamedico.model;

import jakarta.persistence.*;

@Entity
@Table(name = "consulta")
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "consulta_id")
    private Integer consultaId;

    @OneToOne
    @JoinColumn(name = "crm", referencedColumnName = "crm")
    private Medico medico;

    @OneToOne
    @JoinColumn(name = "paciente_id", referencedColumnName = "paciente_id")
    private Paciente paciente;

    public Integer getConsultaId() {
        return consultaId;
    }

    public void setConsultaId(Integer consultaId) {
        this.consultaId = consultaId;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

}
