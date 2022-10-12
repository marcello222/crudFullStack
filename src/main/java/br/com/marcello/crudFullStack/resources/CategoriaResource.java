package br.com.marcello.crudFullStack.resources;


import br.com.marcello.crudFullStack.domain.Categoria;
import br.com.marcello.crudFullStack.domain.dto.CategoriaDTO;
import br.com.marcello.crudFullStack.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {

    @Autowired
    CategoriaService categoriaService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> find(@PathVariable Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(categoriaService.find(id));
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> insert(@Valid @RequestBody CategoriaDTO objDTO) {
        Categoria categoriaDTO = categoriaService.fromDTO(objDTO);
        categoriaDTO = categoriaService.insert(categoriaDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(objDTO.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@Valid @RequestBody CategoriaDTO objDTO, @PathVariable Integer id) {
        Categoria categoriaDTO = categoriaService.fromDTO(objDTO);
        objDTO.setId(id);
        categoriaDTO = categoriaService.update(categoriaDTO);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        categoriaService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity <List<CategoriaDTO>> findAll() {
        List<Categoria> categorias = categoriaService.findAll();
        List<CategoriaDTO> categoriaDTO = categorias.stream()
                .map(obj -> new CategoriaDTO(obj)).collect(Collectors.toList());//para converter uma lista de Categoria em CateroiaDTO
        return ResponseEntity.ok().body(categoriaDTO);
    }

    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public ResponseEntity <Page<CategoriaDTO>> findPage
            (@RequestParam(value = "page", defaultValue = "0") Integer page,
             @RequestParam(value = "linesPerPAge", defaultValue = "24") Integer linesPerPAge,
             @RequestParam(value = "orderBy", defaultValue = "nome") String orderBy,
             @RequestParam(value = "direction", defaultValue = "ASC") String direction) {
        Page<Categoria> categorias = categoriaService.findPage(page, linesPerPAge, orderBy, direction);
        Page<CategoriaDTO> categoriaDTO = categorias
                .map(obj -> new CategoriaDTO(obj));//para converter uma lista de Categoria em CateroiaDTO
        return ResponseEntity.ok().body(categoriaDTO);
    }
}
