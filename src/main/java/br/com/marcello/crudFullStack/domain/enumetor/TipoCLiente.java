package br.com.marcello.crudFullStack.domain.enumetor;

public enum TipoCLiente {

    PESSOAFISICA(1, "Pessoa Fisica"),
    PESSOAJURIDICA(2, "pessoa Juridica");

    private int cod;
    private String descricao;

    private TipoCLiente(int cod, String descricao){
        this.cod = cod;
        this.descricao = descricao;
    }

    public int getCod() {
        return cod;
    }

    public String getDescricao() {
        return descricao;
    }

    public static TipoCLiente toEnum(Integer cod) {
        if (cod == null) {
            return  null;
        }

        for (TipoCLiente tipoCLiente : TipoCLiente.values()) {
            if(cod.equals(tipoCLiente.getCod())) {
                return tipoCLiente;
            }
        }
        throw new IllegalArgumentException("Id invalido: " + cod);
    }
}
