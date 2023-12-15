public class Carro extends Veiculo {
    private String descricao = "Carro";

    public Carro(String placa) {
        super(placa, new Tanque(TipoTanque.CARRO, ITipoCombustivel.ALCOOL), 10000, 10000);
    }

   
    /**
     * Relatorio do veiculo com todas as suas informações principais.
     * 
     * @return Uma String com os principais atributos do veiculo
     */
    @Override
    public String relatorio() {
        StringBuilder relatVeiculo = new StringBuilder(String.format("Placa: %s\n", placa));
        relatVeiculo.append(String.format("Tipo de veiculo: %s\n",descricao));
        relatVeiculo.append(String.format("Quantidade de rotas: %d\n", quantRotas));
        relatVeiculo.append(String.format("Km total: %.2f\n", KmTotal));
        relatVeiculo.append(String.format("Quantidade de manutenções periódicas: %d\n", contPeriodica));
        relatVeiculo.append(String.format("Quantidade de manutenções para troca de peças: %d\n", contTrocaPeca));

        return relatVeiculo.toString();
    }

}
