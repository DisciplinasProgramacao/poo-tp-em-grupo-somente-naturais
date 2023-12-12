public class Carro implements ItipoVeiculo {
    private String descricao;

    public Carro(){
        descricao = "Carro";
    }

    @Override
    public boolean manutencaoPeriodica(Rota rota) {
        if(rota.getQuilometragem() >= 10000){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public boolean manutencaoTrocaPecas(Rota rota) {
        if(rota.getQuilometragem() >= 10000){
            return true;
        }
        else{
            return false;
        }
    }


}
