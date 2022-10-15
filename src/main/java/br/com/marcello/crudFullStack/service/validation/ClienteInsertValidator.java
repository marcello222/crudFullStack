package br.com.marcello.crudFullStack.service.validation;

import br.com.marcello.crudFullStack.domain.Cliente;
import br.com.marcello.crudFullStack.domain.dto.ClienteNewDto;
import br.com.marcello.crudFullStack.domain.enumetor.TipoCliente;
import br.com.marcello.crudFullStack.repository.ClienteRepository;
import br.com.marcello.crudFullStack.resources.exception.FieldMessage;
import br.com.marcello.crudFullStack.service.validation.utils.BR;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;


public class ClienteInsertValidator implements ConstraintValidator<ClienteInsert, ClienteNewDto> {

    @Autowired
    ClienteRepository clienteRepository;

    @Override
    public void initialize(ClienteInsert ann) {
    }

    @Override
    public boolean isValid(ClienteNewDto objDto, ConstraintValidatorContext context) {

        List<FieldMessage> list = new ArrayList<>();

            if (objDto.getTipoCliente().equals(TipoCliente.PESSOAFISICA.getCod())
                    && !BR.isValidCPF(objDto.getCpfOuCnpj())) {
                list.add(new FieldMessage("cpfOuCnpj", "CPF invalido"));
            }

            if (objDto.getTipoCliente().equals(TipoCliente.PESSOAJURIDICA.getCod())
                    && !BR.isValidCNPJ(objDto.getCpfOuCnpj())) {
                list.add(new FieldMessage("cpfOuCnpj", "CNPJ invalido"));
            }

            Cliente aux = clienteRepository.findByEmail(objDto.getEmail());
            if (aux != null) {
                list.add(new FieldMessage("email", "email ja existente"));
            }

        // esse for pega meus erros personlizados FildMessage e transpota para o Framework
        for (FieldMessage e : list) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(e.getMessage())
                    .addPropertyNode(e.getFieldName()).addConstraintViolation();
        }
        return list.isEmpty();
    }
}
