package com.livraria.livraria.repository;

import com.livraria.livraria.entity.Pedidos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidosRepository extends JpaRepository<Pedidos,Long> {
}
