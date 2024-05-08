package com.livraria.livraria.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

@Entity
public class Editoras {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String nome;
    @NotBlank
    @OneToMany
    private List<Livros> livros;

    public Editoras() {
    }

    public Editoras(List<Livros> livros, String nome) {
        this.livros = livros;
        this.nome = nome;
    }

    public List<Livros> getLivros() {
        return livros;
    }

    public void setLivros(List<Livros> livros) {
        this.livros = livros;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
