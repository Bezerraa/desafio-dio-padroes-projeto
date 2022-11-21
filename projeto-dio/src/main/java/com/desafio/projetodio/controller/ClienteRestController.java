package com.desafio.projetodio.controller;

import com.desafio.projetodio.model.Cliente;
import com.desafio.projetodio.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public class ClienteRestController {
    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<Iterable<Cliente>> buscarClientes(){
        return ResponseEntity.ok(clienteService.buscarClientes());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscarId(@PathVariable Long id) {
        return ResponseEntity.ok(clienteService.buscarId(id));

    }
    @PostMapping
    public ResponseEntity<Cliente> inserirCliente (@RequestBody Cliente cliente) {
        clienteService.inserirCliente(cliente);
        return ResponseEntity.ok(cliente);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Cliente> atualizarCliente (@PathVariable Long id, @RequestBody Cliente cliente) {
        clienteService.atualizarCliente(id, cliente);
        return ResponseEntity.ok(cliente);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCliente (@PathVariable Long id){
        clienteService.deletarCLiente(id);
        return ResponseEntity.ok().build();
}}
