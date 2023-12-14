public class Tanque {
    private TipoTanque capacidademax;
    private double capacidadeAtual;
    private ITipoCombustivel tipoCombustivel;

    /*
     * Alterar a classe tanque para, que tenha 
     */
    public Tanque (TipoTanque tipo, ITipoCombustivel tipoCombustivel) {
        this.capacidademax = tipo;
        this.tipoCombustivel = tipoCombustivel;
        this.capacidadeAtual = capacidademax.getCapacidade();
    }


    public double abastecer(double litros) throws Exception{
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

    public double getCapacidadeAtual() {
        return capacidadeAtual;
    }
    
     public void setCapacidadeAtual(double capacidadeAtual) {
        this.capacidadeAtual = capacidadeAtual;
    }

    public double getConsumo() {
        return tipoCombustivel.getConsumoMedio();
    }

    public double getValorConsumo() {
        return tipoCombustivel.getValor();
    }

}
