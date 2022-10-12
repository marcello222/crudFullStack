package br.com.marcello.crudFullStack.domain;

import br.com.marcello.crudFullStack.domain.enumetor.EstadoPagamento;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NoArgsConstructor
@EqualsAndHashCode
@Data
@Inheritance(strategy = InheritanceType.JOINED)//mapeando herança a strategia para gerar a tabela no banco
public abstract class Pagamento implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    private Integer estadoPagamento;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "pedido_id")
    @MapsId//garante que seja o mesmo id do pedido
    private Pedido pedido;

    public Pagamento(Integer id, EstadoPagamento estadoPagamento, Pedido pedido) {
        this.id = id;
        this.estadoPagamento = estadoPagamento.getCod();
        this.pedido = pedido;
    }

    public EstadoPagamento getEstadoPagamento() {
        return EstadoPagamento.toEnum(estadoPagamento);
    }

    public void setEstadoPagamento(EstadoPagamento estadoPagamento) {
        this.estadoPagamento = estadoPagamento.getCod();
    }

}
