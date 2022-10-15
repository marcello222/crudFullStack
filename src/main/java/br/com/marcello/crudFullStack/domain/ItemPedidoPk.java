package br.com.marcello.crudFullStack.domain;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.FieldDefaults;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Data
@EqualsAndHashCode
@Embeddable
@FieldDefaults(makeFinal = false, level = AccessLevel.PRIVATE)
public class ItemPedidoPk implements Serializable {

    @ManyToOne
    @JoinColumn(name = "pedido_id")
    Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    Produto produto;

}