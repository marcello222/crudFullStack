package br.com.marcello.crudFullStack.domain;


import br.com.marcello.crudFullStack.domain.enumetor.TipoCLiente;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Data
@Entity
@NoArgsConstructor
public class Cliente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;
    private String email;
    private String cpfOuCnpj;
    private Integer tipoCLiente;

    @JsonManagedReference
    @OneToMany(mappedBy = "cliente")
    private List<Endereco> enderecos = new ArrayList<>();

    @ElementCollection
    @CollectionTable(name = "TELEFONE")
    private Set<String> telefones = new HashSet<>();

    public Cliente(Integer id, String nome, String email, String cpfOuCnpj, TipoCLiente tipoCLiente) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.cpfOuCnpj = cpfOuCnpj;
        this.tipoCLiente = tipoCLiente.getCod();
            }

    public TipoCLiente getTipoCLiente() {
        return TipoCLiente.toEnum(tipoCLiente);
    }

    public void setTipoCLiente(TipoCLiente tipoCLiente) {
        this.tipoCLiente = tipoCLiente.getCod();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Cliente cliente = (Cliente) o;
        return id != null && Objects.equals(id, cliente.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
