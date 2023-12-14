import java.time.LocalDate;
import java.time.Month;

public class Rota {
    // Atributos privados para garantir o encapsulamento
    private LocalDate data;
    private double quilometragem;

    // Construtor para inicializar os atributos da classe
    public Rota(LocalDate data, double quilometragem) {
        this.data = data;
        this.quilometragem = quilometragem;
    }

	// Método getter para acessar a data da rota
    public LocalDate getData() {
        return data;
    }

    public Month getMonth() {
        return this.data.getMonth();
    }


    // Método getter para acessar a quilometragem da rota
    public double getQuilometragem() {
        return quilometragem;
    }



    // Método para gerar um relatório detalhado da rota

    public String Relatorio() {
        StringBuilder relatorio = new StringBuilder();

        relatorio.append("----- Relatório da Rota -----\n");

        relatorio.append("Data da Rota: ").append(data.toString()).append("\n");

        relatorio.append("Quilometragem: ").append(quilometragem).append(" km\n");

        relatorio.append("----------------------------\n");

        return relatorio.toString();

    }
}
