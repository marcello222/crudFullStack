package br.com.marcello.crudFullStack.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.io.Serializable;

@NoArgsConstructor
@Data
@EqualsAndHashCode
@Entity
public class ItemPedido implements Serializable {

    @EmbeddedId
    private ItemPedidoPk id = new ItemPedidoPk();//Atributo composto (uma outra classe)

    private Double desconto;
    private Integer quantidade;
    private Double preco;

    public ItemPedido(Pedido pedido, Produto produto, Double desconto, Integer quantidade, Double preco) {
        super();
        id.setPedido(pedido);
        id.setProduto(produto);
        this.desconto = desconto;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public Pedido getPedido() {
        return id.getPedido();
    }

    @JsonIgnore
    public Produto getProduto() {
        return id.getProduto();
    }
}
