package com.desafio.projetodio.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//Não é necessário utilizar abaixo a anotação, porque o Spring já reconhece que é
// uma implementação de Interface Repository. Mas, para uma melhor leitura, deixei marcado.
@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long> {
}
