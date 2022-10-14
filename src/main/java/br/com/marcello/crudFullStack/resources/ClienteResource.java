package br.com.marcello.crudFullStack.resources;


import br.com.marcello.crudFullStack.domain.Categoria;
import br.com.marcello.crudFullStack.domain.Cliente;
import br.com.marcello.crudFullStack.domain.dto.CategoriaDTO;
import br.com.marcello.crudFullStack.domain.dto.ClienteDTO;
import br.com.marcello.crudFullStack.domain.dto.ClienteNewDto;
import br.com.marcello.crudFullStack.service.ClienteService;
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
@RequestMapping(value = "/clientes")
public class ClienteResource {

    @Autowired
    ClienteService clienteService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> find(@PathVariable Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(clienteService.find(id));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@Valid @RequestBody ClienteDTO objDTO, @PathVariable Integer id) {
        Cliente clientesDTO = clienteService.fromDTO(objDTO);
        objDTO.setId(id);
        clientesDTO = clienteService.update(clientesDTO);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        clienteService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<ClienteDTO>> findAll() {
        List<Cliente> clientes = clienteService.findAll();
        List<ClienteDTO> clientesDTO = clientes.stream()
                .map(ClienteDTO::new).collect(Collectors.toList());//para converter uma lista de CLiente em CLienteDTO
        return ResponseEntity.ok().body(clientesDTO);
    }

    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public ResponseEntity<Page<ClienteDTO>> findPage
            (@RequestParam(value = "page", defaultValue = "0") Integer page,
             @RequestParam(value = "linesPerPAge", defaultValue = "24") Integer linesPerPAge,
             @RequestParam(value = "orderBy", defaultValue = "nome") String orderBy,
             @RequestParam(value = "direction", defaultValue = "ASC") String direction) {
        Page<Cliente> clientes = clienteService.findPage(page, linesPerPAge, orderBy, direction);
        Page<ClienteDTO> clientesDTO = clientes
                .map(ClienteDTO::new);//para converter uma lista de CLiente em CLienteDTO
        return ResponseEntity.ok().body(clientesDTO);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> insert(@Valid @RequestBody ClienteNewDto objDTO) {
        Cliente obj = clienteService.fromDTO(objDTO);
        obj = clienteService.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
