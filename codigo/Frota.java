public class Frota {
    private int tamanhoFrota;
    private Veiculo Veiculos[];

    //#region Método constutor
    /**
     *  Método constutor no qual o tamanhoFrota determina o tamanho de vetor para os dados dos veículos
     */
    //#endregion
    public Frota(Veiculo[] veiculos)
    {
        this.Veiculos = veiculos;
        tamanhoFrota = veiculos.length;
        
    }

    //#region
    /**
     * Método para exibir o relatório da forta co seus kilomêtros rodados
     * tanto no mês quanto no total
     * @return relatorioFrota
     */
    //#endregion

     public String relatorioFrota () throws Exception
     {
        StringBuilder relatorioFrota = new StringBuilder();

        relatorioFrota.append("----- Relatório da Frota -----\n");

        for(int i = 0; i < tamanhoFrota; i ++)
        {
           relatorioFrota.append("Kilometragem no mês "+ Veiculos[i].relatorio() + "\n");
            //relatorioFrota.append("Kilometragem no ano " + Veiculos[i].getKmtotal() + "\n");
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
    //  public Veiculo localizadorVeiculo(String placa) throws Exception {

    //    for (int i = 0; i < tamanhoFrota; i++) {
    //        if (Veiculos[i].getPlaca().equals(placa)) {
    //             return Veiculos[i]; // Retorna o veículo quando a placa é encontrada
    //        }
    //     }
    //     throw new Exception("Veiculo nao encontrado.");
    // }

    public Veiculo localizadorVeiculo(String placa)throws Exception {
        try {
            boolean achou = false;
            int aux = 0;
            for (int i = 0; i < tamanhoFrota-1 && achou == false; i++) {
                if (Veiculos[i].getPlaca().equals(placa)) {
                    achou = true;
                    aux = i;
                    //return Veiculos[i]; // Retorna o veículo quando a placa é encontrada
                }
            }
            
            if(achou){
                return Veiculos[aux];
            }
            else{
                throw new Exception("NAO ACHOU");
                
            }

        } catch (Exception e) {
            // Lidar com a exceção aqui (ou rethrow, se necessário)
            System.err.println("Erro: " + e.getMessage());
            e.printStackTrace();
            return null; // Ou outra ação apropriada para indicar que o veículo não foi encontrado
        }
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
            quilometragemtotal = quilometragemtotal + Veiculos[i].getKmtotal();
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
            if(maior.getKmtotal() < Veiculos[i].getKmtotal())
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
            if((Mediamaior.getKmtotal() / Mediamaior.getQuantRotas()) < (Veiculos[i].getKmtotal() / Veiculos[i].getQuantRotas()))
            {
                Mediamaior = Veiculos[i];
            }
        }
        return Mediamaior;
    }

    public String relatRotasVeiculos() {
        StringBuilder relat = new StringBuilder("Relatórios dos carros:\n");
        for(Veiculo veiculo : Veiculos) {
            relat.append(veiculo.relatorioRotas() + "\n");
        }
        return relat.toString();
    }
}
