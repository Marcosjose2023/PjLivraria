package com.livraria.livraria.controller;

import com.livraria.livraria.entity.Contas;
import com.livraria.livraria.services.ContasServices;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/contas")
public class ContasController {

    private ContasServices contasServices;

    @PostMapping("/cadastrarConta")
    public void cadastrarContas (@Valid @RequestBody Contas contas) {
        contasServices.cadastrarContas(contas);
    }
    @DeleteMapping("/{id}")
    public void deletarContas (@PathVariable Long id) {
        contasServices.deletarContas(id);
    }
    @PutMapping("/editarContas")
    public Contas editarContas (@RequestBody Contas contas) {
        return contasServices.editarContas(contas);
    }
    @GetMapping("/listarContas")
    public List<Contas> listarContas() {
        return contasServices.listarContas();
    }
    @GetMapping("/buscarPorId")
    public Optional<Contas> buscarPorid(Long id) {
        return contasServices.buscarContas(id);
    }
}
