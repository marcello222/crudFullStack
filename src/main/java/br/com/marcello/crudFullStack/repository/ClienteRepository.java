package br.com.marcello.crudFullStack.repository;

import br.com.marcello.crudFullStack.domain.Cliente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Integer> {
    Page<Cliente> findAll(Pageable pageRequest);

    @Transactional(readOnly=true)//nao necessida de ser envolvida como um transação no banco de dados
    Cliente findByEmail(String email);

}
