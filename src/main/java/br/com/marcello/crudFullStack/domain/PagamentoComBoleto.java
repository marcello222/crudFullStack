package br.com.marcello.crudFullStack.domain;


import br.com.marcello.crudFullStack.domain.enumetor.EstadoPagamento;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@FieldDefaults(makeFinal = false, level = AccessLevel.PRIVATE)
public class PagamentoComBoleto extends Pagamento {

    @JsonFormat(pattern = "dd/MM/yyyy")
    Date dataVencimento;

    @JsonFormat(pattern = "dd/MM/yyyy")
    Date dataPagamento;

    public PagamentoComBoleto(Integer id, EstadoPagamento estadoPagamento, Pedido pedido,
                              Date dataVencimento, Date dataPagamento) {
        super(id, estadoPagamento, pedido);
        this.dataVencimento = dataVencimento;
        this.dataPagamento = dataPagamento;
    }
}
