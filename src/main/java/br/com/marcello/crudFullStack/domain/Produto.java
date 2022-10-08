package br.com.marcello.crudFullStack.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Produto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private Double preco;

    @JsonBackReference //para de buscar os objetos que ja foram buscados do outro lado
    @ManyToMany
    @JoinTable(name = "PRODUTO_CATEGORIA", joinColumns = @JoinColumn(name = "produto_id"),
    inverseJoinColumns = @JoinColumn(name = "categoria_id"))
    private List<Categoria> categorias = new ArrayList<>();

    public Produto(Long id, String nome, Double preco) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }

    public Produto() {
    }

}
