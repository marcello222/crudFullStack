package br.com.marcello.crudFullStack.domain;


import br.com.marcello.crudFullStack.domain.enumetor.EstadoPagamento;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
public class PagamentoComBoleto extends Pagamento {

    private Date dataVencimento;
    private Date dataPagamento;

    public PagamentoComBoleto(Integer id, EstadoPagamento estadoPagamento, Pedido pedido,
                              Date dataVencimento, Date dataPagamento) {
        super(id, estadoPagamento, pedido);
        this.dataVencimento = dataVencimento;
        this.dataPagamento = dataPagamento;
    }
}
