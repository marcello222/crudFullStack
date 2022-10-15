package br.com.marcello.crudFullStack.domain;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@FieldDefaults(makeFinal = false, level = AccessLevel.PRIVATE)
public class Pedido implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @OneToMany
    Set<ItemPedido> itens = new HashSet<>();

    Date instante;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "pedido")// cascade para nao dar erro em entidade trasiente pedido e pagamento
    Pagamento pagamento;

    @ManyToOne
    @JoinColumn(name = "endereco_de_entrega_id")
    Endereco enderecoDeEntrega;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    Cliente cliente;

    public Pedido(Integer id, Date instante, Endereco enderecoDeEntrega, Cliente cliente) {
        this.id = id;
        this.instante = instante;
        this.enderecoDeEntrega = enderecoDeEntrega;
        this.cliente = cliente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pedido pedido = (Pedido) o;

        return id.equals(pedido.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}