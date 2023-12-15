public class Tanque {
    private TipoTanque capacidademax;
    private double capacidadeAtual;
    private ITipoCombustivel tipoCombustivel;

    /**
     * Construtor da classe Tanque.
     *
     * @param tipo           O tipo de tanque (ex: capacidade máxima).
     * @param tipoCombustivel O tipo de combustível associado ao tanque.
     */
    public Tanque (TipoTanque tipo, ITipoCombustivel tipoCombustivel) {
        this.capacidademax = tipo;
        this.tipoCombustivel = tipoCombustivel;
        this.capacidadeAtual = capacidademax.getCapacidade();
    }

    /**
     * Realiza o abastecimento do tanque com a quantidade especificada.
     *
     * @param litros A quantidade de litros a ser abastecida.
     * @return A capacidade atual do tanque após o abastecimento.
     * @throws Exception Se a quantidade de litros for inválida.
     */
    public double abastecer(double litros) throws Exception
    {
        if (litros<0 || litros==0 || litros > capacidademax.getCapacidade()) {
            System.out.println(capacidademax.getCapacidade());
            throw new IllegalArgumentException("Valor inapropriado para abastecimento.");
        } else if ((litros + capacidadeAtual) > capacidademax.getCapacidade()) {
            capacidadeAtual = capacidademax.getCapacidade();
        } else {
            capacidadeAtual+=litros;
        }
        return capacidadeAtual;
    }
    /**
     * Calcula a autonomia máxima do veículo com o tanque cheio.
     *
     * @return A autonomia máxima em quilômetros.
     */
    public double autonomiaMaxima(){
        double autonomiamax = 0;
        autonomiamax = tipoCombustivel.getConsumoMedio() * capacidademax.getCapacidade();
        return autonomiamax;
    }
    /**
     * Calcula a autonomia atual do veículo com o tanque atual.
     * @return A autonomia atual em quilômetros.
     */
    public double autonomiaAtual(){
        double autonomiamax = 0;
        autonomiamax = tipoCombustivel.getConsumoMedio() * capacidadeAtual;
        return autonomiamax;
    }
    /**
     * Obtém a capacidade atual do tanque.
     *
     * @return A capacidade atual do tanque.
     */
    public double getCapacidadeAtual() {
        return capacidadeAtual;
    }
    /**
     * Define a capacidade atual do tanque.
     *
     * @param capacidadeAtual A nova capacidade atual do tanque.
     */
     public void setCapacidadeAtual(double capacidadeAtual) {
        this.capacidadeAtual = capacidadeAtual;
    }
    /**
     * Obtém o consumo médio do combustível.
     *
     * @return O consumo médio do combustível.
     */
    public double getConsumo() {
        return tipoCombustivel.getConsumoMedio();
    }
    /**
     * Obtém o valor do combustível por litro.
     *
     * @return O valor do combustível por litro.
     */
    public double getValorConsumo() {
        return tipoCombustivel.getValor();
    }

}
