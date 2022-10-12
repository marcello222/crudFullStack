package br.com.marcello.crudFullStack.resources.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class FieldMessage implements Serializable {

    private String fieldName;
    private String message;

}
