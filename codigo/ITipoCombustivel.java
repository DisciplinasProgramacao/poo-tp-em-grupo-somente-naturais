public enum ITipoCombustivel {
    /*
     * valores dos combustíveis
     * presentes no sistema
     */
    ALCOOL(7.329),
    GASOLINA(10.519),
    DIESEL(4.609);

    /*
     * atributo final para que não tenha alterações
     */
    private final double valor;

    /*
     * Método constrturo para classe ITipoCombustivel
     * @param valor da gasolina, alcool e diesel
     * pega somente os valores necessários
     */
    private ITipoCombustivel(double valor){
        this.valor = valor;
    }

    /*
     * método get para pegar os valores de alcool, gasolina e diesel
     */
    public double getValor(){
        return valor;
    }
}