import java.time.LocalDate;
import java.util.Scanner;
import java.util.Random;

public class App 
{ 
    /**
     * Exibe o menu de escolha do tipo de veículo.
     */
    public static void menuVeiculo() {
        System.out.println("Escolha o tipo do veiculo:\n----------------------");
        System.out.println("1- Carro");
        System.out.println("2- Caminhao");
        System.out.println("3- Van");
        System.out.println("4- Furgão");
        
        
    }
    /**
     * Gera um array de veículos com placas e tipos aleatórios.
     *
     * @param quantidade A quantidade de veículos a serem gerados.
     * @param sorteador  O gerador de números aleatórios.
     * @return Um array de veículos gerados.
     */
    public static Veiculo[] gerarVeiculos(int quantidade, Random sorteador)
    {
        Veiculo[] veiculos = new Veiculo[quantidade + 50];

        for(int i = 0; i < veiculos.length - 50; i++) 
        {
            String placa = "100-ABC-" + i;
            int tipoDeVeiculo = sorteador.nextInt(4);
            if(tipoDeVeiculo==0){
                Veiculo veiculo = new Carro(placa);
                veiculos[i] = veiculo;
            }
            else if(tipoDeVeiculo==1){
                Veiculo veiculo = new Van(placa);
                veiculos[i] = veiculo;
            }
            else if(tipoDeVeiculo==2){
                Veiculo veiculo = new Furgao(placa);
                veiculos[i] = veiculo;
            }
            else if(tipoDeVeiculo==3){
                Veiculo veiculo = new Caminhao(placa);
                veiculos[i] = veiculo;
            }
            
        }
        return veiculos;
    }
        /**
         * Gera um array de rotas com datas e distâncias aleatórias.
         *
         * @param veiculos   Array de veículos para vincular rotas.
         * @param quantidade A quantidade de rotas a serem geradas.
         * @param sorteador  O gerador de números aleatórios.
         * @return Um array de rotas geradas.
         */
        public static Rota[] gerarRotas (Veiculo[] veiculos, int quantidade, Random sorteador) 
        {
            Rota[] rotas = new Rota[quantidade];
            int year = 2023;
            int month = sorteador.nextInt(1,13);
            
            int day;
            if(month == 2) 
            {
                day = sorteador.nextInt(1,29);
            } 
            else if (month == 4 || month == 6 || month == 9 || month == 11) 
            {
                day = sorteador.nextInt(1,31);
            } 
            else 
            {
                day = sorteador.nextInt(1,32);
            }

            LocalDate data = LocalDate.of(year, month, day);
            for (int i = 0; i < quantidade; i++) 
            {
                Rota rota = new Rota(data, sorteador.nextDouble(200));
                rotas[i] = rota;
            }
            return rotas;
        }
     /**
     * Adiciona rotas aleatórias a veículos aleatórios.
     *
     * @param rotas      Array de rotas a serem adicionadas.
     * @param veiculos   Array de veículos para vincular rotas.
     * @param sorteador  O gerador de números aleatórios.
     * @throws Exception Se houver um problema ao adicionar a rota a um veículo.
     */
    public static void addRotas(Rota[] rotas, Veiculo[] veiculos, Random sorteador) throws Exception 
    {
        for(int i = 0; i < veiculos.length - 50; i++) 
        {
            veiculos[sorteador.nextInt(veiculos.length - 50)].addRota(rotas[sorteador.nextInt(rotas.length - 1)]);
        }
    
    }
    /**
     * Exibe um menu interativo para interagir com a frota de veículos.
     *
     * @param frota   A frota de veículos a ser gerenciada.
     * @param veiculo Array de veículos disponíveis.
     * @throws Exception Se ocorrer uma exceção durante a execução do menu.
     */
    public static void menu(Frota frota, Veiculo[] veiculo) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        String input;

        int cont = -1;
        do {
            System.out.println("Escolha a opção referente a função que deseja executar:");
            System.out.println("1- Relatório da frota.");
            System.out.println("2- Relatório de um veículo.");
            System.out.println("3- Veiculo com maior km total.");
            System.out.println("4- veiculo com maior km media.");
            System.out.println("5- total de km percorridos pela frota.");
            System.out.println("6- km total rodada em um mês por um veiculo.");
            System.out.println("7- km total percorrida por um veiculo.");
            System.out.println("8- abastecer um veiculo.");
            System.out.println("9- Relatório das rotas dos veículos.");
            System.out.println("10- Calcular a despesa total de um veiculo.");
            System.out.println("11- Adicionar Veiculo.");
            System.out.println("12- Adicionar Rota a um Veiculo.");
            System.out.println("0- Finalizar programa.");
            int  op = sc.nextInt();
            switch (op) {
                case 0:
                    cont = 0;
                    break;

                case 1:
                    System.out.println(frota.relatorioFrota());
                    break;

                case 2:
                    try {
                        System.out.println("Digite a placa do veiculo:");
                        String placa = sc.next();
                        System.out.println(frota.localizadorVeiculo(placa).relatorio());
                    } catch(NullPointerException e) {
                        System.out.println("Veiculo não encontrado.");
                        menu(frota, veiculo);
                        cont = 0;
                    }
                    
                    break;

                case 3:
                    System.out.println(frota.maiorkmtotal().relatorio());
                    break;

                case 4:
                    System.out.println(frota.maiorkmMedia().relatorio());
                    break;
                case 5:
                    System.out.printf("Km total percorrida pelos veiculos da frota: %.2fKM\n", frota.quilometragemtotal());
                    break;

                case 6:
                    try {
                        System.out.println("Digite a placa do veiculo:");
                    input = sc.next();
                    System.out.println("Km no mês percorrida pelo veiculo:" +
                            frota.localizadorVeiculo(input).KmnoMes() + "km");
                    } catch (NullPointerException e) {
                        System.out.println("Veiculo não encontrado.");
                        menu(frota, veiculo);
                        cont = 0;
                    }
                    
                    break;

                case 7:
                    try {
                        System.out.println("Digite a placa do veiculo:");
                    input = sc.next();
                    System.out.println("Km total percorrida pelo veiculo: " +
                            frota.localizadorVeiculo(input).getKmtotal() + "km");
                    } catch (NullPointerException e) {
                        System.out.println("Veciulo não encontrado.");
                        menu(frota, veiculo);
                        cont = 0;
                    }
                    break;

                case 8:
                    try {
                        System.out.println("Digite a placa do veiculo:");
                        String testeplaca = sc.next();
                        System.out.println("Digite a quantidade de combustível:");
                        double litros = sc.nextDouble();
                        
                        frota.localizadorVeiculo(testeplaca).abastecer(litros);
                        System.out.println("Veiculo abastecido.");
                    } catch (NullPointerException e) {
                        System.out.println("Veiculo não encontrado.");
                        menu(frota, veiculo);
                        cont = 0;
                    } catch (IllegalArgumentException e) {
                        System.out.println("Valor informado não é apropriado.");
                        menu(frota, veiculo);
                        cont = 0;
                    }
                    break;

                case 9:
                    System.out.println(frota.relatRotasVeiculos());
                    break;

                case 10:
                    try {
                        double total = 0;
                        System.out.println("Digite a placa do veiculo:");
                        input = sc.next();
                        double combustiveltotal = frota.localizadorVeiculo(input).calcDespesaCombustivel();
                        double periodicatotal = frota.localizadorVeiculo(input).calcDespesaManutencao();
                        double pecastotal = frota.localizadorVeiculo(input).calcDespesaPecas();
                        total = combustiveltotal + periodicatotal + pecastotal;
                        System.out.println("Despesas:");
                        System.out.println("Combustivel: " + combustiveltotal);
                        System.out.println("Manutenção Periodica: " + periodicatotal);
                        System.out.println("Troca de Peças: " + pecastotal);
                        System.out.println("Total:" + total);
                    } catch (NullPointerException e) {
                        System.out.println("Veiculo não encontrado.");
                        menu(frota, veiculo);
                        cont = 0;
                    }
                    break;
                case 11:
                    boolean verific;
                    try 
                    {
                        menuVeiculo();
                        int input2 = sc.nextInt();
                        do 
                        {
                            verific = true;
                            System.out.println("Digite a placa do veiculo: ");
                            input = sc.next();
                            if (frota.localizadorVeiculo(input) == null) 
                            {
                                switch (input2) 
                                {
                                    case 1:
                                        Carro carro = new Carro(input);
                                        for (int i = 0; i < veiculo.length; i++){
                                            if (veiculo[i] == null) {
                                                veiculo[i] = carro;
                                                break;
                                            }
                                        }
                                        
                                        
                                        break;
                                    case 2:
                                        Caminhao caminhao = new Caminhao(input);
                                        for (int i = 0; i < veiculo.length; i++){
                                            if (veiculo[i] == null) {
                                                veiculo[i] = caminhao;
                                                break;
                                            }
                                        }
                                        break;
                                    case 3:
                                        Van van = new Van(input);
                                        for (int i = 0; i < veiculo.length; i++){
                                            if (veiculo[i] == null) {
                                                veiculo[i] = van;
                                                break;
                                            }
                                        }
                                        break;
                                    case 4:
                                        Furgao furgao = new Furgao(input);
                                        for (int i = 0; i < veiculo.length; i++){
                                            if (veiculo[i] == null) {
                                                veiculo[i] = furgao;
                                                break;
                                            }
                                        }
                                        
                                        break;
                                    default:
                                        System.out.println("Opção inválida");
                                    break;
                                }
                                System.out.println("Veiculo inserido.");
                                verific = true;
                            }
                            else
                            {
                                System.out.println("Placa já existente");
                                verific = false;
                            }
                            
                        } while (verific == false);
                        
                    }
                    catch (IllegalArgumentException e) 
                    {
                        System.out.println("Inseriu valores inapropriados");
                        menu(frota, veiculo);
                        cont = 0;
                    }
                    break;

                case 12:
                    try {
                        boolean verificador = false;
                        System.out.println("Digite a distancia em KM:");
                        double distancia = sc.nextDouble();

                        System.out.println("Digite o dia:");
                        int dia = sc.nextInt();
                        while(dia>32||dia<1){
                            System.out.println("Dia invalido, digite novamente");
                            dia = sc.nextInt();
                        }

                        System.out.println("digite o mês:");
                        int mes = sc.nextInt();
                        while(mes>13||mes<0){
                            System.out.println("Mês invalido, digite novamente");
                            mes = sc.nextInt();
                        }

                        System.out.println("digite o ano:");
                        int ano = sc.nextInt();

                        LocalDate data = LocalDate.of(ano, mes, dia);
                        Rota rota = new Rota(data, distancia);
                        
                        System.out.println("Digite a placa do veiculo: ");
                        input = sc.next();
                        do{
                        if (frota.localizadorVeiculo(input) != null) {
                            frota.localizadorVeiculo(input).addRota(rota);
                            verificador = true;
                        }else{
                            System.out.println("Digite uma placa que existe:");
                        }}while(verificador == false);
                        break;

                    } catch (Exception e) {
                        System.out.println("Não foi possível adicionar nem completar rota.");
                        menu(frota, veiculo);
                        cont = 0;
                    }
                    break;
                    
                    default:
                    System.out.println("Nenhuma opção correspondente.");
                    break;

            }
        } while (cont != 0);

    }
    /**
     * Método principal que inicia o programa.
     *
     * @param args Argumentos da linha de comando (não utilizados neste programa).
     * @throws Exception Se ocorrer uma exceção durante a execução do programa.
     */
    public static void main(String[] args) throws Exception{
        Random sorteador = new Random();
        

        Veiculo[] veiculos = gerarVeiculos(10, sorteador);
        addRotas(gerarRotas(veiculos, sorteador.nextInt(100), sorteador), veiculos, sorteador);
        Frota frota = new Frota(veiculos);

        menu(frota, veiculos);
        // MENU
        
    }
}

