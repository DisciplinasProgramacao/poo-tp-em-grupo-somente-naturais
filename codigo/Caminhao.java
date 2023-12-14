public class Caminhao extends Veiculo{
    private int trocaPecaKM = 20000;
    private int manutencaoKM = 20000;
    private String descricao = "Caminhao";
    
    public Caminhao( String placa) {
        super(placa , new Tanque(TipoTanque.CAMINHAO, ITipoCombustivel.DIESEL));
    }

    @Override
    public boolean manutencaoTrocaPecas() {
         if(getKmtotal() >= trocaPecaKM){
             return true;
         }
         else{
             return false;
         }
    }

    @Override
    public boolean manutencaoPeriodica() {
        if(getKmtotal() >= manutencaoKM){
            return true;
        }
        else{
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
