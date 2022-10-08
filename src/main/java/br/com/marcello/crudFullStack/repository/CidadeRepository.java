package br.com.marcello.crudFullStack.repository;

import br.com.marcello.crudFullStack.domain.Cidade;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CidadeRepository extends CrudRepository<Cidade, Integer> {
}
