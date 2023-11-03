//importando a biblioteca para o uso de datas na classe
import java.util.Date;
public class Rota {

    // Atributos privados para garantir o encapsulamento
    private Date data; 
    private double quilometragem; 

    // Construtor para inicializar os atributos da classe
    public Rota(Date data, double quilometragem) {
        this.data = data;
        this.quilometragem = quilometragem;
    }

    // Método getter para acessar a data da rota
    public Date getData() {
        return data;
    }

    // Método setter para modificar a data da rota
    public void setData(Date data) {
        this.data = data;
    }

    // Método getter para acessar a quilometragem da rota
    public double getQuilometragem() {
        return quilometragem;
    }

    // Método setter para modificar a quilometragem da rota
    public void setQuilometragem(double quilometragem) {
        this.quilometragem = quilometragem;
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