package br.com.marcello.crudFullStack.domain;

import br.com.marcello.crudFullStack.domain.enumetor.EstadoPagamento;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Data
@NoArgsConstructor
@Entity
public class PagamentoComCartao extends Pagamento {

    private Integer numeroDeParcelas;

    public PagamentoComCartao(Integer id, EstadoPagamento estadoPagamento,
                              Pedido pedido, Integer numeroDeParcelas) {
        super(id, estadoPagamento, pedido);
        this.numeroDeParcelas = numeroDeParcelas;
    }

}
