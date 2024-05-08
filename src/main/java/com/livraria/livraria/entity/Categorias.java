package com.livraria.livraria.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Component;

import java.util.List;

@Entity
@Component
public class Categorias {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String nome;
    @NotNull
    private boolean ativo;
    @OneToMany
    private List<Livros> livros;

    public Categorias() {
    }

    public Categorias(boolean ativo,String nome) {
        this.ativo = ativo;
        this.nome = nome;
    }
    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}
