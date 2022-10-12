package br.com.marcello.crudFullStack.service;

import br.com.marcello.crudFullStack.domain.Categoria;
import br.com.marcello.crudFullStack.domain.dto.CategoriaDTO;
import br.com.marcello.crudFullStack.repository.CategoriaRepository;
import br.com.marcello.crudFullStack.service.exception.DataIntegrityException;
import br.com.marcello.crudFullStack.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    CategoriaRepository categoriaRepository;

    public Optional<Categoria> find(Integer id) {
        Optional<Categoria> obj = categoriaRepository.findById(id);
        if (obj.isEmpty()) {
            throw new ObjectNotFoundException("Objeto não encontrado! id: " + id + ", Tipo" +
                    Categoria.class.getName());
        }
        return obj;
    }

    public Categoria insert(Categoria obj) {
        obj.setId(null);
        return categoriaRepository.save(obj);
    }

    public Categoria update(Categoria obj) {
        return categoriaRepository.save(obj);
    }

    public void delete(Integer id) {
        find(id);
        try {
            categoriaRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Não é possivel excluir uma categoria que contem produtos");
        }
    }

    public List<Categoria> findAll() {
        return (List<Categoria>) categoriaRepository.findAll();
    }

    public Page<Categoria> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        return  categoriaRepository.findAll(pageRequest);
    }


    //MEtodo auxiliar que instancia uma categoria a partir de um metodo DTO
    public Categoria fromDTO(CategoriaDTO objDTO) {
        return new Categoria(objDTO.getId(), objDTO.getNome());
    }
}
