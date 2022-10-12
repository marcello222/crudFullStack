package br.com.marcello.crudFullStack.service;

import br.com.marcello.crudFullStack.domain.Categoria;
import br.com.marcello.crudFullStack.domain.Pedido;
import br.com.marcello.crudFullStack.repository.PedidoRepository;
import br.com.marcello.crudFullStack.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    PedidoRepository pedidoRepository;

    public Optional<Pedido> find(Integer id) {
        Optional<Pedido> obj = pedidoRepository.findById(id);
        if (obj.isEmpty()) {
            throw new ObjectNotFoundException("Objeto não encontrado! id: " + id + ", Tipo" +
                    Categoria.class.getName());
        }
        return obj;
    }
}
