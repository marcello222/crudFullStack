package br.com.marcello.crudFullStack.domain.dto;

import br.com.marcello.crudFullStack.domain.Categoria;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@NoArgsConstructor
@Data
@FieldDefaults(makeFinal = false, level = AccessLevel.PRIVATE)
public class CategoriaDTO implements Serializable {

    Integer id;

    @NotEmpty(message = "Preenchimento obrigatorio")
    @Length(min=5, max=80, message="O tamanho deve ser de no minimo 5 a 80 caracteres")
    String nome;

    //Criar um construtor para substituir na List no resource
    public CategoriaDTO(Categoria categoria) {
        id = categoria.getId();
        nome = categoria.getNome();
    }
}
