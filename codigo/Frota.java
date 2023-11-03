public class Frota {
    private int tamanhoFrota;
    private Veiculo Veiculos[];

    //#region Método constutor
    /**
     *  Método constutor no qual o tamanhoFrota determina o tamanho de vetor para os dados dos veículos
     * @param tamanhoFrota
     */
    //#endregion
    public Frota(int tamanhoFrota)
    {
        this.tamanhoFrota = tamanhoFrota;
        Veiculos = new Veiculo[tamanhoFrota];
    }

    //#region
    /**
     * Método para exibir o relatório da forta co seus kilomêtros rodados 
     * tanto no mês quanto no total
     * @return relatorioFrota
     */
    //#endregion

    public String relatorioFrota ()
    {
        StringBuilder relatorioFrota = new StringBuilder();

        relatorioFrota.append("----- Relatório da Frota -----");

        for(int i = 0; i <= tamanhoFrota; i ++)
        {
            relatorioFrota.append("Quanto precisa abastercer : "+Veiculos[i].abastecer(i));
           relatorioFrota.append("Kilometragem no mês "+ Veiculos[i].KmnoMes());
           relatorioFrota.append("Kilometragem no ano " + Veiculos[i].KmTotal());
        }

        return relatorioFrota.toString();
    }

    //#region
    /*
     * Método para localizar um Veiculo na frota pela sua placa
     * e retornar o veículo desejado
     * @param placa 
     * @return Veiculos[i]
     */
    public Veiculo localizadorVeiculo(String placa) {

        for (int i = 0; i < tamanhoFrota; i++) {
            if (Veiculos[i].getPlaca().equals(placa)) {
                return Veiculos[i]; // Retorna o veículo quando a placa é encontrada
            }
        }
    
        return null; // Retorna null se a placa não for encontrada na frota
    }

  //#region
  /*
   * Método para calcular a quilometragem total de todos os
   * veículos da Frota da empresa
   * @return quilometragemtotal
   */
  //#endregion

  public double quilometragemtotal()
  {
    double quilometragemtotal = 0;
    for(int i = 0; i < tamanhoFrota; i ++)
    {
        quilometragemtotal = quilometragemtotal + Veiculos[i].KmTotal();
    }
    return quilometragemtotal;
}

//#region
/*
 * Método no qual seu objetivo e procurar o Veículo com maior quilometragem total
 * @return Veiculo maior
 */
//#endregion
  public Veiculo maiorkmtotal()
  {
    Veiculo maior = Veiculos[0];

    for(int i = 1; i < tamanhoFrota; i ++)
    {
        if(maior.KmTotal() < Veiculos[i].KmTotal())
        {
            maior = Veiculos[i];
        }
    }

    return maior;
  }

  //#region
  /*
   * Método para procurar a maior quilometragem média
   * de um veículo que está na frota
   * @return Mediamaior
   */
  //#endregion
  public Veiculo maiorkmMedia()
  {
      Veiculo Mediamaior = Veiculos[0];

      for(int i = 1; i < tamanhoFrota; i ++)
      {
        if(Mediamaior.KmTotal() <  Veiculos[i].KmTotal())
        {
            Mediamaior = Veiculos[i];
        }
      }
      return Mediamaior;
  }
}
