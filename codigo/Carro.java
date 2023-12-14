public class Carro extends Veiculo {
    private int trocaPecaKM = 10000; //Static para as variáveis, contar as manutenções
    private int manutencaoKM = 10000;
    private String descricao = "Carro";

    public Carro(String placa) {
        super(placa , new Tanque(TipoTanque.CARRO, ITipoCombustivel.ALCOOL));
    }

    @Override
    public boolean manutencaoPeriodica() { //contador com a kilometragem total, sen
        if(getKmtotal() >= manutencaoKM)
        {
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public boolean manutencaoTrocaPecas() {
        if(getKmtotal() >= trocaPecaKM)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
   
    @Override
    public String relatorio() {
        StringBuilder relatVeiculo = new StringBuilder("Placa: " + placa + "\n");
        relatVeiculo.append("Tipo de veiculo: " + descricao + "\n");
        relatVeiculo.append("Quantidade de rotas: " + quantRotas + "\n");
        relatVeiculo.append("Km total: " + String.format("%,.2f\n", KmTotal));
        relatVeiculo.append("Combustivel Disponivel no tanque: " + tanque.getCapacidadeAtual());
        return relatVeiculo.toString();
    }

    

}
