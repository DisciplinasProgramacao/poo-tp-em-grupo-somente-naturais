import java.util.Date;

public class App {
    public static void main(String[] args) {
        Veiculo carro1 = new Veiculo("123456", 55);
        System.out.println("Tanque abastecido. Sobraram: " + carro1.abastecer(35) + "L");

        Date data1 = new Date();

        Rota rota1 = new Rota(data1,20.5);

        System.out.println(rota1.Relatorio());
        carro1.addRota(rota1);

        System.out.println("Quilometragem rodada no mês: " + carro1.KmnoMes());

        System.out.println("Quilometragem total percorrida: " + carro1.KmTotal());

        Veiculo[] veiculos = new Veiculo[1];
        veiculos[0] = carro1;

        Frota frota = new Frota(veiculos);

        System.out.println("\n" + frota.relatorioFrota());

        StringBuilder pesquisa = new StringBuilder("----- Veiculo pesquisado -----\n");
        Veiculo veiculoPesquisado = frota.localizadorVeiculo("123456");
        pesquisa.append("KM no mês: " + veiculoPesquisado.KmnoMes() + "\n");
        pesquisa.append("KM total: " + veiculoPesquisado.KmTotal() + "\n");
        System.out.println(pesquisa);

        System.out.println("Quilometragem total da frota: " + frota.quilometragemtotal());
        Veiculo maiorKmTotal = frota.maiorkmtotal();
        System.out.println("Placa do veiculo com maior quilometragem total: " + maiorKmTotal.getPlaca());
        Veiculo maiorKmMedia = frota.maiorkmMedia();
        System.out.println("Placa do veiculo com maior quilometragem media: " + maiorKmMedia.getPlaca() + "\n");

        Tanque tanque1 = new Tanque(50, 30);
        System.out.println("Capacidade atual do tanque após abastecimento: " + tanque1.abastecer(25));

        System.out.printf("Autonomia máxima: %.2f\n", tanque1.autonomiaMax());

        System.out.printf("Autonomia atual: %.2f\n", tanque1.autonomiaAtual());
    }
}
