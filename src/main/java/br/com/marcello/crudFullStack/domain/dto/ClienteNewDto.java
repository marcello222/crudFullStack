package br.com.marcello.crudFullStack.domain.dto;

import ch.qos.logback.core.joran.spi.NoAutoStart;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@Data
public class ClienteNewDto implements Serializable {

    private String nome;
    private String email;
    private String cpfOuCnpj;
    private Integer tipoCLiente;

    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String cep;

    private String telefone1;
    private String telefone2;
    private String telefone3;

    private Integer cidadeId;
}
