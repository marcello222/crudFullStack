package br.com.marcello.crudFullStack.service;

import br.com.marcello.crudFullStack.domain.Categoria;
import br.com.marcello.crudFullStack.repository.CategoriaRepository;
import br.com.marcello.crudFullStack.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    CategoriaRepository categoriaRepository;

    public Optional<Categoria> buscar(Integer id) {
        Optional<Categoria> obj = categoriaRepository.findById(id);

        if (obj.isEmpty()) {
            throw  new ObjectNotFoundException("Objeto não encontrado! id: " + id + ", Tipo" +
                    Categoria.class.getName());
        }
       return obj;
    }
}
