package com.desafio.projetodio.service;

import com.desafio.projetodio.model.Cliente;

public interface ClienteServiceInterface {
    Iterable<Cliente> buscarClientes();
    Cliente buscarId (Long id);
    void inserirCliente(Cliente cliente);
    void atualizarCliente (Long id, Cliente cliente);
    void deletarCLiente(Long id);
}
