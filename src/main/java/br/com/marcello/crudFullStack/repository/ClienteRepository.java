package br.com.marcello.crudFullStack.repository;

import br.com.marcello.crudFullStack.domain.Cliente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Integer> {
}
