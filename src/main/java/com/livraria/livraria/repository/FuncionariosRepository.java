package com.livraria.livraria.repository;

import com.livraria.livraria.entity.Funcionarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionariosRepository extends JpaRepository<Funcionarios,Long> {
    void deleteAllById(Long id);
}
