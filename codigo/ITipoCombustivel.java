public enum ITipoCombustivel {
    /*
     * valores dos combustíveis
     * presentes no sistema
     */
    ALCOOL(3.29, 7.00),
    GASOLINA(5.19, 10.00),
    DIESEL(6.09,4.00);

    /*
     * atributo final para que não tenha alterações
     */
    private final double Consumo_medio;
    private final double valor;

    /*
     * Método constrturo para classe ITipoCombustivel
     * @param valor da gasolina, alcool e diesel
     * pega somente os valores necessários
     */
    private ITipoCombustivel(double valor, double Consumo_medio){
        this.Consumo_medio = Consumo_medio;
        this.valor = valor;

    }

    /**
     * método get para pegar o consumo médio
     * @return Consumo_medio
     */
    public double getConsumoMedio(){
        return Consumo_medio;
    }

/**
     * método get para pegar os valores de alcool, gasolina e diesel
     * @return Consumo_medio
     */
    public double getValor(){
        return valor;
    }
}