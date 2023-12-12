public class Furgao implements ItipoVeiculo {

    private String descricao;

    public Furgao(){
        descricao = "Furgão";
    }
    
    @Override
    public boolean manutencaoPeriodica(Rota rota) {
        if(rota.getQuilometragem() >= 10000 ){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public boolean manutencaoTrocaPecas(Rota rota) {
       if(rota.getQuilometragem() >= 12000 ){
        return true;
       }
       else{
        return false;
       }
    }
    
}
