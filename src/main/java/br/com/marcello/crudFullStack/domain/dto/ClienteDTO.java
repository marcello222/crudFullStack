package br.com.marcello.crudFullStack.domain.dto;

import br.com.marcello.crudFullStack.domain.Cliente;
import br.com.marcello.crudFullStack.service.validation.ClienteUpdate;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@NoArgsConstructor
@Data
@FieldDefaults(makeFinal = false, level = AccessLevel.PRIVATE)
@ClienteUpdate
public class ClienteDTO {

    Integer id;

    @NotEmpty(message = "Preenchimento Obrigatorio")
    @Length(min = 5, message = "O tamanho deve ser obrigatorio")
    String nome;

    @NotEmpty(message = "Preenchimento Obrigatorio")
    @Email(message = "Email invalido")
    String email;

    public ClienteDTO(Cliente obj) {
        id = obj.getId();
        nome = obj.getNome();
        email = obj.getEmail();
    }
}
