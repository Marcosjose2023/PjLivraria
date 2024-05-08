package com.livraria.livraria.repository;

import com.livraria.livraria.entity.Categorias;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriasRepository extends JpaRepository<Categorias,Long> {

}
