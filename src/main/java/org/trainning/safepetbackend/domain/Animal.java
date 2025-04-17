package org.trainning.safepetbackend.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;
import org.trainning.safepetbackend.domain.enumerated.Porte;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Animal {

    @Id
    private String id;
    private String nome;

    @NotBlank(message = "A especie deve ser informada")
    private String especie;
    private String raca;

    @NotNull
    private Porte porte;

    private LocalDate dataNascimento;

    private LocalDateTime cadastradoEm;

    private String cor;

    public Animal() {
    }

    public LocalDateTime getCadastradoEm() {
        return cadastradoEm;
    }

    public void setCadastradoEm(LocalDateTime cadastradoEm) {
        this.cadastradoEm = cadastradoEm;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getCor() {
        return cor;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public Porte getPorte() {
        return porte;
    }

    public void setPorte(Porte porte) {
        this.porte = porte;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}

