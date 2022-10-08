package br.com.marcello.crudFullStack.repository;

import br.com.marcello.crudFullStack.domain.Categoria;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends CrudRepository<Categoria, Integer> {
}
