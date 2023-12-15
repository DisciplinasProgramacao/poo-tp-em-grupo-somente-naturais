public class Frota {
    private int tamanhoFrota;
    private Veiculo Veiculos[];

    /**
     *  Método constutor no qual o tamanhoFrota determina o tamanho de vetor para os dados dos veículos
     */
    public Frota(Veiculo[] veiculos)
    {
        this.Veiculos = veiculos;
        tamanhoFrota = veiculos.length;
        
    }

    //#region
    /**
     * Método para exibir o relatório da frota com seus quilômetros rodados
     * @return relatorioFrota
     */
    //#endregion
     public String relatorioFrota () 
     {
        StringBuilder relatorioFrota = new StringBuilder();

        relatorioFrota.append("----- Relatório da Frota -----\n");

        for(int i = 0; i < tamanhoFrota; i ++)
        {
            if(Veiculos[i] == null) {
                break;
            } else {
                relatorioFrota.append(Veiculos[i].relatorio() + "\n");
            }
        }
        return relatorioFrota.toString();
     }

    /**
     * Método para localizar um Veiculo na frota pela sua placa
     * e retornar o veículo desejado, caso o veículo não seja encontrado, retorna um objeto do tipo veículo nulo
     *
     * @param placa
     * @return veiculo
     */
    public Veiculo localizadorVeiculo(String placa) 
    {   
        Veiculo veiculo = null;
        for (int i = 0; i < tamanhoFrota && Veiculos[i] != null; i++) 
        {
            if (Veiculos[i].getPlaca().equals(placa)) 
            {
                return veiculo = Veiculos[i];
            }
        }

        return veiculo;
    }

    
    /**
     * Método para calcular a quilometragem total de todos os
     * veículos da Frota da empresa
     * @return quilometragemtotal
     */
    protected double quilometragemtotal()
    {
        double quilometragemtotal = 0;
        for(int i = 0; i < tamanhoFrota; i ++)
        {
            if (Veiculos[i] == null) {
                break;
            } else {
                quilometragemtotal = quilometragemtotal + Veiculos[i].getKmtotal();
            }
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
            if (Veiculos[i] == null) {
                break;
            } else {
                if(maior.getKmtotal() < Veiculos[i].getKmtotal())
                {
                    maior = Veiculos[i];
                }
            }
        }
        return maior;
    }

    
    /**
     * Método para procurar a maior quilometragem média
     * de um veículo que está na frota
     * @return Mediamaior
     */
    public Veiculo maiorkmMedia()
    {
        Veiculo Mediamaior = Veiculos[0];

        for(int i = 1; i < tamanhoFrota; i ++)
        {
            if (Veiculos[i] == null) {
                break;
            } else {
                if((Mediamaior.getKmtotal() / Mediamaior.getQuantRotas()) < (Veiculos[i].getKmtotal() / Veiculos[i].getQuantRotas()))
                {
                    Mediamaior = Veiculos[i];
                }
            }
        }
        return Mediamaior;
    }

    /**
     * Método para retornar o relatório de rotas
     * de um veículo que está na frota
     * @return relat
     */ 
    public String relatRotasVeiculos() {
        StringBuilder relat = new StringBuilder("Relatórios dos veiculos:\n");
        for(Veiculo veiculo : Veiculos) {
            if (veiculo == null) {
                break;
            } else {
                relat.append(veiculo.relatorioRotas() + "\n");
            }
        }
        return relat.toString();
    }
}
