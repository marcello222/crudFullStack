package br.com.marcello.crudFullStack.service.validation;

import br.com.marcello.crudFullStack.domain.Cliente;
import br.com.marcello.crudFullStack.domain.dto.ClienteDTO;
import br.com.marcello.crudFullStack.domain.dto.ClienteNewDto;
import br.com.marcello.crudFullStack.domain.enumetor.TipoCliente;
import br.com.marcello.crudFullStack.repository.ClienteRepository;
import br.com.marcello.crudFullStack.resources.exception.FieldMessage;
import br.com.marcello.crudFullStack.service.validation.utils.BR;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerMapping;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Handler;


public class ClienteUpdateValidator implements ConstraintValidator<ClienteUpdate, ClienteDTO> {


    @Autowired
    HttpServletRequest request;//permite obter o parametro da uri para ver o email repetido

    @Autowired
    ClienteRepository clienteRepository;

    @Override
    public void initialize(ClienteUpdate ann) {
    }

    @Override
    public boolean isValid(ClienteDTO objDto, ConstraintValidatorContext context) {

        Map<String, String> map = (Map<String, String>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
        Integer uriId = Integer.valueOf(map.get("id"));

        List<FieldMessage> list = new ArrayList<>();

            Cliente aux = clienteRepository.findByEmail(objDto.getEmail());
            if (aux != null && !aux.getId().equals(uriId)) {
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
