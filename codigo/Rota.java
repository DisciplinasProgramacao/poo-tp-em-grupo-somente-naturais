import java.time.LocalDate;
import java.time.Month;
/**
 * Classe que representa uma rota realizada por um veículo.
 */
public class Rota {
    // Atributos privados para garantir o encapsulamento
    private LocalDate data;
    private double quilometragem;

    /**
     * Construtor para inicializar os atributos da classe.
     *
     * @param data         A data em que a rota foi realizada.
     * @param quilometragem A quantidade de quilômetros percorridos na rota.
     */
    public Rota(LocalDate data, double quilometragem) {
        this.data = data;
        this.quilometragem = quilometragem;
    }

	/**
     * Obtém a data da rota.
     *
     * @return A data da rota.
     */
    public LocalDate getData() {
        return data;
    }
    /**
     * Obtém o mês da data da rota.
     *
     * @return O mês da data da rota.
     */
    public Month getMonth() {
        return this.data.getMonth();
    }


    /**
     * Obtém a quilometragem da rota.
     *
     * @return A quantidade de quilômetros percorridos na rota.
     */
    public double getQuilometragem() {
        return quilometragem;
    }



    /**
     * Gera um relatório detalhado da rota.
     *
     * @return Uma string contendo informações sobre a rota.
     */
    public String Relatorio() {
        StringBuilder relatorio = new StringBuilder();

        relatorio.append("----- Relatório da Rota -----\n");

        relatorio.append("Data da Rota: ").append(data.toString()).append("\n");

        relatorio.append("Quilometragem: ").append(quilometragem).append(" km\n");

        relatorio.append("----------------------------\n");

        return relatorio.toString();

    }
}
