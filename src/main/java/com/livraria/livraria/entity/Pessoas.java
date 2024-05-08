package com.livraria.livraria.entity;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public class Pessoas {

    @NotBlank
    private String nome;
    @NotBlank
    private LocalDate dataNascimento;

    public Pessoas() {
    }

    public Pessoas(LocalDate dataNascimento, String nome) {
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
