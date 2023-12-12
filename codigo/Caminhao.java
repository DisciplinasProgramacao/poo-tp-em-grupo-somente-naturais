public class Caminhao implements ItipoVeiculo{

    private String descricao;

    public Caminhao()
    {
        descricao = "Caminhão";
    }
    @Override
    public boolean manutencaoPeriodica(Rota rota) {
       if(rota.getQuilometragem() >= 20000){
        return true;
       }
       else{
        return false;
       }
    }

    @Override
    public boolean manutencaoTrocaPecas(Rota rota) {
        if(rota.getQuilometragem() >= 20000){
            return true;
        }
        else{
            return false;
        }
    }
}
