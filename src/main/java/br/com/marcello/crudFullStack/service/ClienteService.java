package br.com.marcello.crudFullStack.service;

import br.com.marcello.crudFullStack.domain.Categoria;
import br.com.marcello.crudFullStack.domain.Cliente;
import br.com.marcello.crudFullStack.repository.CategoriaRepository;
import br.com.marcello.crudFullStack.repository.ClienteRepository;
import br.com.marcello.crudFullStack.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    public Optional<Cliente> buscar(Integer id) {
        Optional<Cliente> obj = clienteRepository.findById(id);
        if (obj.isEmpty()) {
            throw  new ObjectNotFoundException("Objeto não encontrado! id: " + id + ", Tipo" +
                    Cliente.class.getName());
        }
       return obj;
    }
}
