package br.com.marcello.crudFullStack.repository;

import br.com.marcello.crudFullStack.domain.Categoria;
import br.com.marcello.crudFullStack.domain.Cliente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Integer> {
    Page<Cliente> findAll(Pageable pageRequest);

}
