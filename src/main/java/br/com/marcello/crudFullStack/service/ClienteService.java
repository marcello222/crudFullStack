package br.com.marcello.crudFullStack.service;

import br.com.marcello.crudFullStack.domain.Cidade;
import br.com.marcello.crudFullStack.domain.Cliente;
import br.com.marcello.crudFullStack.domain.Endereco;
import br.com.marcello.crudFullStack.domain.dto.ClienteDTO;
import br.com.marcello.crudFullStack.domain.dto.ClienteNewDto;
import br.com.marcello.crudFullStack.domain.enumetor.TipoCliente;
import br.com.marcello.crudFullStack.repository.CidadeRepository;
import br.com.marcello.crudFullStack.repository.ClienteRepository;
import br.com.marcello.crudFullStack.repository.EnderecoRepository;
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
public class ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    CidadeRepository cidadeRepository;

    @Autowired
    EnderecoRepository enderecoRepository;





    public Optional<Cliente> find(Integer id) {
        Optional<Cliente> obj = clienteRepository.findById(id);
        if (obj.isEmpty()) {
            throw new ObjectNotFoundException("Objeto não encontrado! id: " + id + ", Tipo" +
                    Cliente.class.getName());
        }
        return obj;
    }



    public Cliente update(Cliente obj) {
        return clienteRepository.save(obj);
    }

    public void delete(Integer id) {
        find(id);
        try {
            clienteRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Não é possivel excluir porue tem entidades realcionadas");
        }
    }

    public List<Cliente> findAll() {
        return (List<Cliente>) clienteRepository.findAll();
    }

    public Page<Cliente> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        return clienteRepository.findAll(pageRequest);
    }

    public Cliente fromDTO(ClienteDTO objDTO) {
        return new Cliente(objDTO.getId(), objDTO.getNome(),
                objDTO.getEmail(), null, null);
    }

    public Cliente fromDTO(ClienteNewDto objDTO) {
        Cliente cli = new Cliente(null, objDTO.getNome(), objDTO.getEmail(), objDTO.getCpfOuCnpj(),
                TipoCliente.toEnum(objDTO.getTipoCLiente()));
        Cidade cidade =new Cidade(objDTO.getCidadeId(), null, null);
        Endereco endereco = new Endereco(null, objDTO.getLogradouro(), objDTO.getNumero(), objDTO.getComplemento(),
                objDTO.getBairro(), objDTO.getCep(), cli, cidade);
        cli.getEnderecos().add(endereco);
        cli.getTelefones().add(objDTO.getTelefone1());
        if (objDTO.getTelefone2() != null) {
            cli.getTelefones().add(objDTO.getTelefone2());
        }if (objDTO.getTelefone3() != null) {
            cli.getTelefones().add(objDTO.getTelefone2());
        }
        return cli;
    }

    public Cliente insert(Cliente obj) {
        obj.setId(null);
        obj = clienteRepository.save(obj);
        enderecoRepository.saveAll(obj.getEnderecos());
        return obj;
    }

    private void updateData(Cliente newObj, Cliente obj) {
        newObj.setNome(obj.getNome());
        newObj.setEmail(obj.getEmail());
    }

}
