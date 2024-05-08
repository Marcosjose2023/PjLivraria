package com.livraria.livraria.repository;

import com.livraria.livraria.entity.Editoras;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EditorasRepository extends JpaRepository<Editoras,Long> {
    Optional<Editoras> findByNome(String nome);
}
