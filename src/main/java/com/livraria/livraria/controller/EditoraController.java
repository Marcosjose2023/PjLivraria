package com.livraria.livraria.controller;

import com.livraria.livraria.entity.Editoras;
import com.livraria.livraria.services.EditoresServices;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public class EditoraController {

    private EditoresServices editoresServices;


    @PostMapping("/cadastrarEditora")
    public void cadastrarEditora(@Valid @RequestBody Editoras editoras) {
        editoresServices.cadastrarEditoras(editoras);
    }
    @DeleteMapping("/{id}")
    public void deletarEditoras(@PathVariable Long id) {
        editoresServices.deletarEditora(id);
    }
    @PutMapping("/editarContas")
    public Editoras editarEditora (@RequestBody Editoras editoras) {
        return editoresServices.editar(editoras);
    }

    @GetMapping("/listarContas")
    public List<Editoras> listarEditoras() {
        return editoresServices.listarTodosEditoras();
    }
    @GetMapping("/buscarPeloNome")
    public Optional<Editoras> buscarPeloNome(String nome) {
        return editoresServices.buscarPorEditora(nome);
    }
}
