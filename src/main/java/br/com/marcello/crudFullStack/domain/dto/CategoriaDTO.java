package br.com.marcello.crudFullStack.domain.dto;

import br.com.marcello.crudFullStack.domain.Categoria;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@Data
public class CategoriaDTO implements Serializable {

    private Integer id;
    private String nome;

    //Criar um construtor para substituir na List no resource
    public CategoriaDTO(Categoria categoria) {
        id = categoria.getId();
        nome = categoria.getNome();
    }
}
