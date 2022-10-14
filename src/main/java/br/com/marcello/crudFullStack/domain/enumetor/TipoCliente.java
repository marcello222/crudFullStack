package br.com.marcello.crudFullStack.domain.enumetor;

public enum TipoCliente {

    PESSOAFISICA(1, "Pessoa Fisica"),
    PESSOAJURIDICA(2, "pessoa Juridica");

    private int cod;
    private String descricao;

    private TipoCliente(int cod, String descricao){
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
