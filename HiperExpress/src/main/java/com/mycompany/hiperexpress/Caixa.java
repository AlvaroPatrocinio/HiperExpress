package com.mycompany.hiperexpress;

public class Caixa {

    private int numero;
    private String tipo;

    /**
     * Construtor da classe Caixa.
     *
     * @param numero O número do caixa.
     * @param tipo   O tipo do caixa ("Rápida", "Preferencial", "Normal").
     */
    public Caixa(int numero, String tipo) {
        this.numero = numero;
        this.tipo = tipo;
    }

    /**
     * Obtém o número do caixa.
     *
     * @return O número do caixa.
     */
    public int getNumero() {
        return numero;
    }

    /**
     * Define o número do caixa.
     *
     * @param numero O número do caixa.
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     * Obtém o tipo do caixa.
     *
     * @return O tipo do caixa.
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Define o tipo do caixa.
     *
     * @param tipo O tipo do caixa.
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Retorna uma representação de string deste objeto.
     *
     * @return Uma string que representa o objeto.
     */
    @Override
    public String toString() {
        return "Caixa " +
                "numero: " + numero +
                ", tipo: " + tipo;
    }
}