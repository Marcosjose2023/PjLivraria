package com.livraria.livraria.controller;

import com.livraria.livraria.entity.Categorias;
import com.livraria.livraria.entity.Livros;
import com.livraria.livraria.services.LivrosServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class   LivrosController {

    @Autowired
    private LivrosServices livrosServices;

    @GetMapping("/listarLivros")
    public List<Livros> listarLivros(){
        return livrosServices.listarTodosLivros();
    }

    @PostMapping("/adicionarLivro")
    public void adicionarLivro (@RequestBody @Valid Livros livros){
        livrosServices.cadastrarLivros(livros);
    }

    @GetMapping("/buscar/{id}")
    public Optional<Livros> buscarLivro (@PathVariable @Valid Long id){
       return livrosServices.buscarPorId(id);
    }

    @GetMapping("/buscar/{titulo}")
    public Optional<Livros> buscarLivro (@PathVariable @Valid String titulo){
        return livrosServices.buscarPorTitulo(titulo);
    }

    @PutMapping("/editarLivro")
    public Livros editar (@RequestBody Livros livros) {
        return livrosServices.editar(livros);
    }

    public List<Livros> destaque(){
        return livrosServices.destaque();
    }
    @GetMapping("/buscarCategoria/{categorias}")
    public Optional<Livros> buscarCategoria(@PathVariable Categorias categorias){
        return livrosServices.buscarPorCategoria(categorias);
    }
   /* @GetMapping("/livrosDestacadosPorAno")
    public List<Livros> getLivrosDestacadosPorAno(@RequestParam int ano) {
        return livrosServices.destacarLivrosPorAno(ano);*/

}
