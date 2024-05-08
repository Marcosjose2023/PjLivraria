package com.livraria.livraria.services;

import com.livraria.livraria.entity.Autores;
import com.livraria.livraria.repository.AutoresRepository;
import com.livraria.livraria.dto.AutoresDto;
import com.livraria.livraria.mapper.AutoresMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AutoresServices {
    private AutoresRepository autoresRepository;

    public AutoresDto adicionarAutor(AutoresDto autor) {
        var autorEntity = new Autores();
        autorEntity.setNome(autor.getNome());
        autorEntity.setAtivo(autor.isAtivo());
        return AutoresMapper.map(autoresRepository.save(autorEntity));
    }

    public List<AutoresDto> listarTodosAutores() {
//        var autores = autoresRepository.findAll();
//
//        var autoresDtoList = new ArrayList<AutoresDto>();
//
//        Forma 1
//        for (var autor : autores) {
//            autoresDtoList.add(AutoresMapper.map(autor));
//        }

//        Forma 2
//        autores.forEach((item) -> autoresDtoList.add(AutoresMapper.map(item)));
//
//        return autoresDtoList;

        // Forma 3
        return autoresRepository.findAll().stream().map(AutoresMapper::map).toList();
    }

    public AutoresDto buscarPorId(long id) {

        var autor = autoresRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                                HttpStatus.BAD_REQUEST,
                                "Autor não encontrado"
                        )
                );

        return AutoresMapper.map(autor);
    }

    public Optional<Autores> buscarPorNome(String nome) {
        return autoresRepository.findByNome(nome);
    }

    public void deletarAutor(Long id) {
        autoresRepository.deleteById(id);
    }

    public Autores updateAutor(Long id, AutoresDto autores) {
        var autor = autoresRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.BAD_REQUEST,
                        "Autor não encontrado"
                ));
        autor.setNome(autores.getNome());
        autor.setAtivo(autores.isAtivo());

        autoresRepository.save(autor);
        return autor;
    }

    public Autores inativarAutores(Long id) {
        var autor = autoresRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.BAD_REQUEST,
                        "Autor não encontrado"
                ));

        autor.setAtivo(false);

        return autoresRepository.save(autor);
    }

    public Autores ativarAutores(Long id) {
        var autor = autoresRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.BAD_REQUEST,
                        "Autor não encontrado"
                ));

        autor.setAtivo(true);

        return autoresRepository.save(autor);
    }

}
