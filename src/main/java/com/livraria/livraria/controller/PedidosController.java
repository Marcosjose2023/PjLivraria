package com.livraria.livraria.controller;

import com.livraria.livraria.entity.Pedidos;
import com.livraria.livraria.services.PedidosServices;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/pedidos")
public class PedidosController {

    private final PedidosServices pedidosServices;

    @GetMapping
    public List<Pedidos> listarTodosPedidos() {
        return pedidosServices.listarTodosPedidos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pedidos> buscarPedidoPorId(@PathVariable Long id) {
        Optional<Pedidos> pedido = pedidosServices.buscarPedidoPorId(id);
        return pedido.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Pedidos> cadastrarPedido(@RequestBody Pedidos pedido) {
        Pedidos novoPedido = pedidosServices.cadastrarPedidos(pedido);
        return new ResponseEntity<>(novoPedido, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> atualizarPedido(@PathVariable Long id, @RequestBody Pedidos pedidos) {
        pedidos.setId(id);
        pedidosServices.atualizarPedidos(pedidos);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/inativar/{id}")
    public ResponseEntity<Void> inativarPedidos(@PathVariable Long id) {
        pedidosServices.inativarPedidos(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/ativar/{id}")
    public ResponseEntity<Void> ativarPedidos(@PathVariable Long id) {
        pedidosServices.ativarPedidos(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
