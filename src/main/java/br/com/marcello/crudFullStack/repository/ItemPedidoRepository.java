package br.com.marcello.crudFullStack.repository;

import br.com.marcello.crudFullStack.domain.ItemPedido;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemPedidoRepository extends CrudRepository<ItemPedido, Integer> {
}
