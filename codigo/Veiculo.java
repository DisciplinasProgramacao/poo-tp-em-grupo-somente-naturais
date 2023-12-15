import java.time.LocalDate;


public abstract class Veiculo {
    protected final  int MAX_ROTAS = 30;
    protected String placa;
    protected Rota[] rotas = new Rota[MAX_ROTAS];
    protected int quantRotas = 0;
    protected Tanque tanque;
    protected double KmTotal;
    protected static double ValorManutencao = 700.00;
    protected static double ValorTrocaPeca = 630.00;
    protected int contPeriodica = 0;
    protected int contTrocaPeca = 0;
    protected int trocaPecaKM; //Static para as variáveis, contar as manutenções
    protected int manutencaoKM;
    
    /**
     * Construtor da classe Veiculo.
     *
     * @param placa        A placa do veículo.
     * @param tanque       O tanque do veículo.
     * @param trocaPecaKM  A quilometragem para troca de peça.
     * @param manutencaoKM A quilometragem para manutenção periódica.
     */
    protected Veiculo (String placa, Tanque tanque, int trocaPecaKM, int manutencaoKM){
        this.placa = placa;
        this.tanque = tanque;
        this.trocaPecaKM = trocaPecaKM;
        this.manutencaoKM = manutencaoKM;
    }
    
    /**
     * Realiza o abastecimento do veículo com a quantidade especificada, respeitando a capacidade máxima do tanque.
     *
     * @param litros A quantidade de litros a ser abastecida.
     * @return A quantidade de litros que não couberam no tanque.
     * @throws Exception Se a quantidade de litros for inválida.
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
     *
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
    /**
     * Obtém a quilometragem total do veículo.
     *
     * @return A quilometragem total percorrida pelo veículo.
     */
    protected double getKmtotal(){
        return KmTotal;
    }

    /**
     * Percorre uma rota, deduzindo a quilometragem do tanque atual se houver autonomia suficiente.
     * @param rota A rota a ser percorrida.
     */
    protected void percorrerRota(Rota rota) {
        if(tanque.autonomiaAtual()>rota.getQuilometragem()) {
            tanque.setCapacidadeAtual(tanque.getCapacidadeAtual()-(rota.getQuilometragem() * tanque.getConsumo()));
            KmTotal = KmTotal + rota.getQuilometragem();
        }
    }
     
    /**
     * Método somente para teste. Obtém a placa do veículo.
     *
     * @return A placa do veículo.
     */
    public String getPlaca() {
        return placa;
    }
    /**
     * Obtém a quantidade de rotas registradas no veículo.
     *
     * @return A quantidade de rotas registradas.
     */
    public int getQuantRotas() {
        return quantRotas;
    }
    /**
     * Gera um relatório das rotas do veículo.
     *
     * @return Uma string contendo informações sobre as rotas do veículo.
     */
    protected String relatorioRotas() {
        StringBuilder relat = new StringBuilder("Rotas do Veiculo: " + placa + "\n");
        for(Rota rota : rotas) {
             if (rota == null) {
                break;
            } else {
                relat.append(rota.Relatorio() + "\n");
            }
        }
        return relat.toString();
    }
    /**
     * Calcula a despesa com combustível do veículo.
     *
     * @return O valor total gasto com combustível.
     */
    protected double calcDespesaCombustivel() {
        double despesa = 0;
        despesa = (KmTotal / tanque.getConsumo()) * tanque.getValorConsumo();
        return despesa;
    }
    /**
     * Calcula a despesa com manutenção periódica do veículo.
     *
     * @return O valor total gasto com manutenção periódica.
     */
    protected double calcDespesaManutencao() {
        double despesa = 0;
        if(manutencaoPeriodica()){
            despesa = ValorManutencao * contPeriodica;
        }
        return despesa;
    }
    /**
     * Calcula a despesa com troca de peças do veículo.
     *
     * @return O valor total gasto com troca de peças.
     */
    protected double calcDespesaPecas() {
        double despesa = 0;
        if(manutencaoPeriodica()){
            despesa = ValorTrocaPeca * contTrocaPeca;
        }
        return despesa;
    }
    /**
    * Adiciona uma rota ao veículo, desde que haja espaço e autonomia suficiente.
    *
    * @param rota A rota a ser adicionada.
    * @throws Exception Se ocorrer um problema ao adicionar a rota, como falta de autonomia ou atingir o máximo de rotas.
    */
    protected void addRota(Rota rota)throws Exception
    {
        if(quantRotas< MAX_ROTAS) {
            if(tanque.autonomiaAtual() > rota.getQuilometragem()){
                rotas[quantRotas] = rota;
                quantRotas++;
                percorrerRota(rota);
                if (manutencaoPeriodica()) {
                    contPeriodica++;
                }
                if (manutencaoKM()) {
                    contTrocaPeca++;
                }
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
     * Gera um relatório do veículo.
     *
     * @return Uma string contendo informações sobre o veículo.
     */
    protected  abstract String relatorio();
    /**
     * Verifica se é necessário realizar manutenção periódica no veículo.
     *
     * @return true se for necessário, false caso contrário.
     */
    protected boolean manutencaoPeriodica() {
        int aux = (int)KmTotal / manutencaoKM;
        return aux > contPeriodica;
    }
    /**
     * Verifica se é necessário realizar troca de peças no veículo.
     *
     * @return true se for necessário, false caso contrário.
     */
    protected boolean manutencaoKM() {
        int aux = (int)KmTotal / trocaPecaKM;
        return aux > contTrocaPeca;
    }
   
}
