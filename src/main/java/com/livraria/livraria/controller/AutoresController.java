package com.livraria.livraria.controller;

import com.livraria.livraria.entity.Autores;
import com.livraria.livraria.services.AutoresServices;
import com.livraria.livraria.dto.AutoresDto;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/autores")
public class AutoresController {

    private final AutoresServices autoresServices;

    @GetMapping("/all")
    public List<AutoresDto> listarAutores(){
        return autoresServices.listarTodosAutores();
    }

    @GetMapping("/{id}")
    public AutoresDto buscarPorId(@PathVariable Long id){
        return autoresServices.buscarPorId(id);
    }

    @GetMapping("/findByName")
    public Optional<Autores> buscarPorNome(String nome){
        return autoresServices.buscarPorNome(nome);
    }

    @PostMapping
    public AutoresDto adicionarAutores(@RequestBody @Valid AutoresDto autor){
        return autoresServices.adicionarAutor(autor);
    }

    @PutMapping("/{id}")
    public Autores editarAutores (@PathVariable Long id, @RequestBody AutoresDto autor){
       return autoresServices.updateAutor(id, autor);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        autoresServices.deletarAutor(id);
    }

    /**
     * quando usar /{id} no endpoint = @PathVariable
     * quando usar ?id=1 no endpoint = @RequestParam
     * qiando for um json no corpo do endpoint = @RequestBody
     */
}
