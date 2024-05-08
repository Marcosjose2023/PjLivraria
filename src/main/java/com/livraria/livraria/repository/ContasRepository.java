package com.livraria.livraria.repository;

import com.livraria.livraria.entity.Contas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContasRepository extends JpaRepository<Contas, Long> {
    void deleteAllById(Long id);
}
