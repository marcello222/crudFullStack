package br.com.marcello.crudFullStack.domain;


import br.com.marcello.crudFullStack.domain.enumetor.TipoCliente;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@NoArgsConstructor
@Data
@FieldDefaults(makeFinal = false, level = AccessLevel.PRIVATE)
public class Cliente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String nome;

    @Column(unique = true)//garante que o banco de dados nao deixa inserir dois dados iguais
    String email;

    String cpfOuCnpj;

    Integer tipoCliente;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)//Toda operação que modificar o cliente eu posso apagar os endereços autoamticamente
    List<Endereco> enderecos = new ArrayList<>();

    @ElementCollection
    @CollectionTable(name = "TELEFONE")
    Set<String> telefones = new HashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "cliente")
    List<Pedido> pedidos = new ArrayList<>();

    public Cliente(Integer id, String nome, String email, String cpfOuCnpj, TipoCliente tipoCLiente) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.cpfOuCnpj = cpfOuCnpj;
        this.tipoCliente = (tipoCLiente==null) ? null : tipoCLiente.getCod();
    }

    public TipoCliente getTipoCliente() {
        return TipoCliente.toEnum(tipoCliente);
    }

    public void setTipoCliente(TipoCliente tipoCliente) {
        this.tipoCliente = tipoCliente.getCod();
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
