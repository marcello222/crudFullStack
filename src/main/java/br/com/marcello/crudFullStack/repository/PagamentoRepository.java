package br.com.marcello.crudFullStack.repository;

import br.com.marcello.crudFullStack.domain.Pagamento;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagamentoRepository extends CrudRepository<Pagamento, Integer> {
}
