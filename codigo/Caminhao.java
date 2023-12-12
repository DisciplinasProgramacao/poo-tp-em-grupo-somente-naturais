public class Caminhao implements ItipoVeiculo{

    private String descricao;

    public Caminhao()
    {
        descricao = "Caminhão";
    }
    @Override
    public boolean manutencaoPeriodica() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'manutencaoPeriodica'");
    }

    @Override
    public boolean manutencaoTrocaPecas() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'manutencaoTrocaPecas'");
    }
}
