public interface ItipoVeiculo {

    /*
     * Interface para analisar quando se deve
     * fazer a manutenção peeriódica do veículo
     * e a manutenção de sua  troca de peças
     */

     /*
      * método publico do tipo boolean que retorna se o veículo
      * deve ou não fazer a sua manutenção periódica
      @return boolean
      */
    public boolean manutencaoPeriodica(Rota rota);

    /*
     * Método público do tipo boolan que retorna se o veículo
     * deve ou não fazer a manutenção de suas peças
     * @return boolean
     */

    public boolean manutencaoTrocaPecas(Rota rota);
    
}
