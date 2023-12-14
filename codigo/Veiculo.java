import java.time.LocalDate;


public abstract class Veiculo implements ItipoVeiculo {
    protected final  int MAX_ROTAS = 30;
    protected String placa;
    protected Rota[] rotas = new Rota[MAX_ROTAS];
    protected int quantRotas = 0;
    protected Tanque tanque;
    protected double totalReabastecido;
    protected double KmTotal;
    private static double ValorManutencao = 700.00;
    private static double ValorTrocaPeca = 630.00;
    private int contPeriodica = 0;
    private int contTrocaPeca = 0;
    
    /**
     * Construtor da classe Veiculo.
     * @param placa A placa do veículo.
     * @param tanqueMax A capacidade máxima do tanque do veículo.
     */
    protected Veiculo (String placa, Tanque tanque){
        this.placa = placa;
        this.tanque = tanque;
        totalReabastecido = 0;
        //Rota[] rotas = new Rota[MAX_ROTAS];
    }
    /**
     * Adiciona uma rota ao veículo, desde que haja espaço.
     * @param rota A rota a ser adicionada.
     */
    protected void addRota(Rota rota) throws Exception{
        if(quantRotas< MAX_ROTAS) {
            if(tanque.autonomiaAtual() > rota.getQuilometragem()){
                rotas[quantRotas] = rota;
                quantRotas++;
                percorrerRota(rota);
            } else if (tanque.autonomiaMaxima() > rota.getQuilometragem()) {
                rotas[quantRotas] = rota;
                quantRotas++;
            } else {
                throw new Exception("Não é possível cumprir rota, falta autonomia.");
            }
        } else {
            throw new Exception("Máximo de rotas percorridas alcançado.");
        }
    }
    
    /**
     * Realiza o abastecimento do veículo com a quantidade especificada, respeitando a capacidade máxima do tanque.
     * @param litros A quantidade de litros a ser abastecida.
     * @return A quantidade de litros que não couberam no tanque.
     */
    protected double abastecer(double litros) throws Exception{
        if(litros>0){
            return tanque.abastecer(litros); 
        }
        else{
            throw new Exception("ta errado isso ai");
        }
        
    }

    /**
     * Calcula a quilometragem percorrida no mês atual com base nas rotas registradas.
     * @return A quilometragem total percorrida no mês.
     */
    protected double KmnoMes() {
        LocalDate date = LocalDate.now();
        double kmMes = 0;
        for (int i = 0; i < quantRotas; i++) 
        {
            if(rotas[i].getMonth() == date.getMonth()) {
                kmMes += rotas[i].getQuilometragem();
            }
        }
        return kmMes;
    }

    protected double getKmtotal(){
        return KmTotal;
    }

    /**
     * Percorre uma rota, deduzindo a quilometragem do tanque atual se houver autonomia suficiente.
     * @param rota A rota a ser percorrida.
     */
    protected void percorrerRota(Rota rota) {
        if(tanque.autonomiaAtual()>rota.getQuilometragem()) {
            //tanque.setCapacidadeAtual(rota.getQuilometragem() * tanque.getConsumo());
            KmTotal = KmTotal + rota.getQuilometragem();
        }
    }


    @Override
	public abstract boolean manutencaoTrocaPecas();

    @Override
    public abstract boolean manutencaoPeriodica();

     
    //Método somente para teste
    public String getPlaca() {
        return placa;
    }

    public double getTotalReabastecido() {
        return totalReabastecido;
    }

    public int getQuantRotas() {
        return quantRotas;
    }

    protected String relatorioRotas() {
        StringBuilder relat = new StringBuilder("Rotas do Veiculo: " + placa + "\n");
        for(Rota rota : rotas) {
            relat.append(rota.Relatorio() + "\n");
        }
        return relat.toString();
    }

    protected double calcDespesaCombustivel() {
        double despesa = 0;
        despesa = (KmTotal / tanque.getConsumo()) * tanque.getValorConsumo();
        return despesa;
    }
    protected double calcDespesaManutencao() {
        double despesa = 0;
        if(manutencaoPeriodica()){
            despesa = 5999;
        }
        return despesa;
    }

    protected  abstract String relatorio();
   
}
