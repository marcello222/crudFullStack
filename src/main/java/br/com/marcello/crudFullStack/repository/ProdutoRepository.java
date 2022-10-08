package br.com.marcello.crudFullStack.repository;

import br.com.marcello.crudFullStack.domain.Produto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends CrudRepository<Produto, Integer> {
}
