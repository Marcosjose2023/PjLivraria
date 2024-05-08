package com.livraria.livraria.services;

import com.livraria.livraria.entity.Categorias;
import com.livraria.livraria.entity.Livros;
import com.livraria.livraria.repository.LivrosRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivrosServices {


    private LivrosRepository livrosRepository;

    private Livros livros;

    public LivrosServices(LivrosRepository livrosRepository) {
        this.livrosRepository = livrosRepository;
    }

    public void cadastrarLivros(Livros livros) {
        livrosRepository.save(livros);
    }

    public List<Livros> listarTodosLivros() {
        return livrosRepository.findAll();
    }

    public Optional<Livros> buscarPorId(long id) {
        return livrosRepository.findById(id);
    }

    public Livros editar(Livros livros) {
        return livrosRepository.save(livros);
    }

    public Optional<Livros> buscarPorTitulo(String titulo) {
        return livrosRepository.findByTitulo(titulo);
    }

    public Optional<Livros> buscarPorCategoria(Categorias categorias) {
        return livrosRepository.findByCategorias(categorias);
    }

    public List<Livros> destaque() {
        if (livros.isDestaques() == true) {
            return livrosRepository.findAll();
        }
        throw new RuntimeException("Nenhum livro encontrado");
    }

   /* public List<Livros> destacarLivrosPorAno(int ano) {
        return livrosRepository.findAllByAno(ano);*/

}