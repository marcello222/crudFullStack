package br.com.marcello.crudFullStack.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(makeFinal = false, level = AccessLevel.PRIVATE)
public class Endereco implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String logradouro;
    String numero;
    String complemento;
    String bairro;
    String cep;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "cidade_id")
    Cidade cidade;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Endereco endereco = (Endereco) o;
        return id != null && Objects.equals(id, endereco.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
