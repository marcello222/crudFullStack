package br.com.marcello.crudFullStack.repository;

import br.com.marcello.crudFullStack.domain.Pedido;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends CrudRepository<Pedido, Integer> {
}
