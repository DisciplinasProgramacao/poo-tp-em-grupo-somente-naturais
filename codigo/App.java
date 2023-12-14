import java.time.LocalDate;
import java.util.Scanner;
import java.util.Random;

public class App 
{ 
    
    public static Veiculo[] gerarVeiculos(int quantidade, Random sorteador)
    {
        Veiculo[] veiculos = new Veiculo[quantidade];

        for(int i = 0; i < quantidade; i++) 
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

    public static void addRotas(Rota[] rotas, Veiculo[] veiculos, Random sorteador) throws Exception 
    {
        for(int i = 0; i < veiculos.length; i++) 
        {
            veiculos[sorteador.nextInt(veiculos.length - 1)].addRota(rotas[sorteador.nextInt(rotas.length - 1)]);
        }
    
    }
    
    public static void main(String[] args) throws Exception{
        Random sorteador = new Random();
        Scanner sc = new Scanner(System.in);
        String input;

        Veiculo[] veiculos = gerarVeiculos(100, sorteador);
        addRotas(gerarRotas(veiculos, sorteador.nextInt(100), sorteador), veiculos, sorteador);
        Frota frota = new Frota(veiculos);

        // MENU
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
            System.out.println("9- Realizar manutenção periódica de um veiculo.");
            System.out.println("10- Realizar manutenção troca de peças de um veiculo.");
            System.out.println("11- Relatório das rotas dos veículos.");
            System.out.println("12- Calcular a despesa total de um veiculo.");
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
                    System.out.println("Digite a placa do veiculo:");
                    System.out.println(frota.localizadorVeiculo(sc.next()).relatorio());
                    break;

                case 3:
                    System.out.println(frota.maiorkmtotal().relatorio());
                    break;

                case 4:
                    System.out.println(frota.maiorkmMedia().relatorio());
                    break;

                case 5:
                    System.out.println("Km total percorrida pelos veiculos da frota: " + frota.quilometragemtotal() + "Km");
                    break;

                case 6:
                    System.out.println("Digite a placa do veiculo:");
                    input = sc.next();
                    System.out.println("Km no mês percorrida pelo veiculo:" +
                            frota.localizadorVeiculo(input).KmnoMes() + "km");
                    break;

                case 7:
                    System.out.println("Digite a placa do veiculo:");
                    input = sc.nextLine();
                    System.out.println("Km total percorrida pelo veiculo: " +
                            frota.localizadorVeiculo(input).getKmtotal() + "km");
                    break;

                case 8:
                    System.out.println("Digite a placa do veiculo:");
                    String testeplaca = sc.next();
                    System.out.println("Digite a quantidade de combustível:");
                    double litros = sc.nextDouble();
                    
                    frota.localizadorVeiculo(testeplaca).abastecer(litros);
                    System.out.println("Veiculo abastecido.");
                    break;

                case 9:
                    System.out.println("Digite a placa do veiculo:");
                    sc.next();
                    input = sc.nextLine();
                    if (frota.localizadorVeiculo(input).manutencaoPeriodica()) {
                        System.out.println("Manutenção Periódica realizada.");
                    } else {
                        System.out.println("Ainda não é necessário uma manutenção periódica.");
                    }
                    break;

                case 10:
                    System.out.println("Digite a placa do veiculo:");
                    input = sc.nextLine();
                    if (frota.localizadorVeiculo(input).manutencaoTrocaPecas()) {
                        System.out.println("Manutenção de troca de peças realizada.");
                    } 
                    else 
                    {
                        System.out.println("Ainda não é necessário uma manutenção para troca de peças.");
                    }
                    break;

                case 11:
                    System.out.println(frota.relatRotasVeiculos());
                    break;

                case 12:
                    System.out.println("Digite a placa do veiculo:");
                    input = sc.nextLine();
                    System.out.println("Despesa total do veiculo:" +
                            frota.localizadorVeiculo(input).calcDespesaCombustivel());
                    break;

                default:
                    System.out.println("Nenhuma opção correspondente.");
                    break;

            }
        } while (cont != 0);

    }
}

