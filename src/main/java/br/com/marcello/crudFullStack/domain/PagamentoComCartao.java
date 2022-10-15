package br.com.marcello.crudFullStack.domain;

import br.com.marcello.crudFullStack.domain.enumetor.EstadoPagamento;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;

@Data
@NoArgsConstructor
@Entity
@FieldDefaults(makeFinal = false, level = AccessLevel.PRIVATE)
public class PagamentoComCartao extends Pagamento {

    Integer numeroDeParcelas;

    public PagamentoComCartao(Integer id, EstadoPagamento estadoPagamento,
                              Pedido pedido, Integer numeroDeParcelas) {
        super(id, estadoPagamento, pedido);
        this.numeroDeParcelas = numeroDeParcelas;
    }

}
