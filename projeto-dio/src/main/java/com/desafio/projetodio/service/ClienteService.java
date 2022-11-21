package com.desafio.projetodio.service;

import com.desafio.projetodio.model.Cliente;
import com.desafio.projetodio.model.ClienteRepository;
import com.desafio.projetodio.model.EndRepository;
import com.desafio.projetodio.model.Endereco;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

//Como utilizei o Intellij como IDE, não achei necessário criar um
// subpacote para separar as interfaces das classes que as implementam,
// já que a IDE identifica o tipo do arquivo com ícones diferentes.

public class ClienteService implements ClienteServiceInterface{
    @Autowired
    private ClienteRepository cRepository;
    @Autowired
    private EndRepository eRepository;
    @Autowired
    private CepService cepService;

    @Override
    public Iterable<Cliente> buscarClientes() {
        return cRepository.findAll();
    }

    @Override
    public Cliente buscarId(Long id) {
        Optional<Cliente> cliente = cRepository.findById(id);
        return cliente.get();
    }

    @Override
    public void inserirCliente(Cliente cliente) {
        salvarClientePorCep(cliente);


    }

    private void salvarClientePorCep(Cliente cliente) {
        String cep = cliente.getEndereco().getCep();
        Endereco endereco = (Endereco) eRepository.findById(cep).orElseGet(() -> {
            Endereco novoEndereco = cepService.consultarCep(cep);
            eRepository.save(novoEndereco);
            return novoEndereco;});
        cliente.setEndereco(endereco);
        cRepository.save(cliente);
    }

    @Override
    public void atualizarCliente(Long id, Cliente cliente) {
        Optional<Cliente> clientedb = cRepository.findById(id);
        if(clientedb.isPresent()){
            salvarClientePorCep(cliente);
        }

    }

    @Override
    public void deletarCLiente(Long id) {
        cRepository.deleteById(id);

    }
}
