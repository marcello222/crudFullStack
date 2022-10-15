package br.com.marcello.crudFullStack.domain.dto;

import br.com.marcello.crudFullStack.domain.enumetor.TipoCliente;
import br.com.marcello.crudFullStack.service.validation.ClienteInsert;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@NoArgsConstructor
@Data
@ClienteInsert
@FieldDefaults(makeFinal = false, level = AccessLevel.PRIVATE)
public class ClienteNewDto implements Serializable {

    @NotEmpty(message = "Preenchimento Obrigatorio")
    @Length(min = 5, message = "O tamanho deve ser obrigatorio")
    String nome;

    @NotEmpty(message = "Preenchimento Obrigatorio")
    @Email(message = "Email invalido")
    String email;

    @NotEmpty(message = "Preenchimento Obrigatorio")
    String cpfOuCnpj;

    @NotEmpty(message = "Preenchimento Obrigatorio")
    String logradouro;

    @NotEmpty(message = "Preenchimento Obrigatorio")
    String numero;

    @NotEmpty(message = "Preenchimento Obrigatorio")
    String cep;

    @NotEmpty(message = "Preenchimento Obrigatorio")
    String telefone1;

    Integer tipoCliente;

    String complemento;

    String bairro;

    String telefone2;

    String telefone3;

    private Integer cidadeId;


}
