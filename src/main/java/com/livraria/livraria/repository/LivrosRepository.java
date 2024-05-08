package com.livraria.livraria.repository;

import com.livraria.livraria.entity.Categorias;
import com.livraria.livraria.entity.Livros;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LivrosRepository extends JpaRepository<Livros,Long> {
    Optional<Livros> findByTitulo(String titulo);

    Optional<Livros> findByCategorias(Categorias categoria);

}
