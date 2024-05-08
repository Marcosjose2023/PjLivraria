package com.livraria.livraria.controller;

import com.livraria.livraria.entity.Categorias;
import com.livraria.livraria.services.CategoriasServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoriasController {

    private Categorias categorias;

    @Autowired
    private CategoriasServices categoriasServices;

    @GetMapping("/listarCategorias")
    public List<Categorias> listarCategorias() {
            return categoriasServices.listarCategorias();
    }

    @PostMapping("/criarCategorias")
    public void criarCategorias(@RequestBody @Valid Categorias categorias){
        categoriasServices.criarCategorias(categorias);
    }

    @PutMapping("/ativar/{ativo}")
    public void alterarAtivacaoCategorias(@RequestBody @Valid boolean ativo){
        categoriasServices.ativar(ativo);
    }
}
