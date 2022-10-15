package br.com.marcello.crudFullStack.domain;

import br.com.marcello.crudFullStack.domain.enumetor.EstadoPagamento;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NoArgsConstructor
@EqualsAndHashCode
@Data
@Inheritance(strategy = InheritanceType.JOINED)//mapeando herança a strategia para gerar a tabela no banco
@FieldDefaults(makeFinal = false, level = AccessLevel.PRIVATE)
public abstract class Pagamento implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    Integer id;

    Integer estadoPagamento;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "pedido_id")
    @MapsId//garante que seja o mesmo id do pedido
    Pedido pedido;

    public Pagamento(Integer id, EstadoPagamento estadoPagamento, Pedido pedido) {
        this.id = id;
        this.estadoPagamento = (estadoPagamento==null) ? null : estadoPagamento.getCod();
        this.pedido = pedido;
    }

    public EstadoPagamento getEstadoPagamento() {
        return EstadoPagamento.toEnum(estadoPagamento);
    }

    public void setEstadoPagamento(EstadoPagamento estadoPagamento) {
        this.estadoPagamento = estadoPagamento.getCod();
    }

}
