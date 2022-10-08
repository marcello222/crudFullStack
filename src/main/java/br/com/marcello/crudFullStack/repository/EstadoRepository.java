package br.com.marcello.crudFullStack.repository;

import br.com.marcello.crudFullStack.domain.Estado;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoRepository extends CrudRepository<Estado, Integer> {
}
