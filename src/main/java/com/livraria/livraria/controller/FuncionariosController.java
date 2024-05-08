package com.livraria.livraria.controller;

import com.livraria.livraria.entity.Funcionarios;
import com.livraria.livraria.services.FuncionariosServices;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/funcionarios")
public class FuncionariosController {

    private FuncionariosServices funcionariosServices;

    @PostMapping("/cadastrarFuncionarios")
    public void cadastrarFuncionarios(@Valid @RequestBody Funcionarios funcionarios) {
        funcionariosServices.cadastrarFuncionarios(funcionarios);
    }
    @GetMapping("/pegartodosFuncionarios")
    public List<Funcionarios> getALLFuncionarios() {
        return funcionariosServices.listarTodosFuncionarios();
    }
    @DeleteMapping("/deletarFuncionario/{id}")
    public void deletarFuncionarios(@PathVariable long id) {
        funcionariosServices.deletarFuncionarios(id);
    }
    @PutMapping("/editarEnderecos")
    public Funcionarios editarFuncionario (@RequestBody Funcionarios funcionarios) {
        return funcionariosServices.editar(funcionarios);
    }
    @GetMapping("/buscarFuncionarios")
    public Optional<Funcionarios> buscarFuncionarios(long id) {
        return funcionariosServices.buscarFuncionarios(id);
    }
}
