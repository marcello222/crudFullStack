package br.com.marcello.crudFullStack.domain.enumetor;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@FieldDefaults(makeFinal = false, level = AccessLevel.PRIVATE)
public enum TipoCliente {

    PESSOAFISICA(1, "Pessoa Fisica"),
    PESSOAJURIDICA(2, "pessoa Juridica");

    int cod;
    String descricao;

    TipoCliente(int cod, String descricao){
        this.cod = cod;
        this.descricao = descricao;
    }

    public int getCod() {
        return cod;
    }

    public String getDescricao() {
        return descricao;
    }

    public static TipoCliente toEnum(Integer cod) {
        if (cod == null) {
            return  null;
        }

        for (TipoCliente tipoCLiente : TipoCliente.values()) {
            if(cod.equals(tipoCLiente.getCod())) {
                return tipoCLiente;
            }
        }
        throw new IllegalArgumentException("Id invalido: " + cod);
    }
}
