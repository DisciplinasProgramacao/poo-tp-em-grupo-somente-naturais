package veiculo;
import java.util.Date;
/**
 * A classe Veiculo representa um veículo com atributos como placa, capacidade do tanque,
 * rotas percorridas e métodos para controlar o abastecimento, calcular quilometragem,
 * e percorrer rotas.
 */
public class Veiculo {
	private final  int MAX_ROTAS = 3;
	private final  double CONSUMO = 1.5;
	private String placa;
	private Rota[] rotas = new Rota[MAX_ROTAS];
	private int quantRotas = 0;
	private double tanqueAtual;
	private double tanqueMax;
	private double totalReabastecido;
	/**
     * Construtor da classe Veiculo.
     * @param placa A placa do veículo.
     * @param tanqueMax A capacidade máxima do tanque do veículo.
     */
	public Veiculo (String placa, int tanqueMax){
		this.placa = placa;
		this.tanqueMax = tanqueMax;
		//Rota[] rotas = new Rota[MAX_ROTAS];
	}
	 /**
     * Adiciona uma rota ao veículo, desde que haja espaço.
     * @param rota A rota a ser adicionada.
     */
	public void addRota(Rota rota) {
		if(quantRotas< MAX_ROTAS) {
			rotas[quantRotas] = rota;
			quantRotas++;
		}
	}
	 /**
     * Calcula a autonomia máxima do veículo com o tanque atual.
     * @return A autonomia máxima em quilômetros.
     */
	private double autonomiaMaxima(){
		double autonomiamax = 0;
		autonomiamax = CONSUMO * tanqueMax;
		return autonomiamax;
	}
	/**
     * Calcula a autonomia atual do veículo com o tanque atual.
     * @return A autonomia atual em quilômetros.
     */
	private double autonomiaAtual(){
		double autonomiamax = 0;
		autonomiamax = CONSUMO * tanqueAtual;
		return autonomiamax;
	}
	/**
     * Realiza o abastecimento do veículo com a quantidade especificada, respeitando a capacidade máxima do tanque.
     * @param litros A quantidade de litros a ser abastecida.
     * @return A quantidade de litros que não couberam no tanque.
     */
	public double abastecer(double litros) {
		double resto = 0;
		if(tanqueAtual + litros > tanqueMax) {
			resto = tanqueAtual + litros - tanqueMax;
			tanqueAtual = tanqueMax;
			return resto;
		}
		else {
			tanqueAtual = tanqueAtual + litros;
			return resto;
		}
	}
	/**
     * Calcula a quilometragem percorrida no mês atual com base nas rotas registradas.
     * @return A quilometragem total percorrida no mês.
     */
	public double KmnoMes() {
		java.util.Date date = new java.util.Date();  
		System.out.println(date);
		double kmMes = 0;
		for (int i = 0; i < quantRotas; i++) {
			if(rotas[i].getMonth() == date.getMonth()) {
				kmMes += rotas[i].getQuilometragem();
			}
		}
		return kmMes;
		
	}
	/**
     * Calcula a quilometragem total percorrida com base nas rotas registradas.
     * @return A quilometragem total percorrida.
     */
	public double KmTotal() {
		double kmTotal = 0;
		for (int i = 0; i < quantRotas; i++) {
			kmTotal = rotas[i].getQuilometragem();
		}
		return kmTotal;
	}
	/**
     * Percorre uma rota, deduzindo a quilometragem do tanque atual se houver autonomia suficiente.
     * @param rota A rota a ser percorrida.
     */
	public void percorrerRota(Rota rota) {
		if(autonomiaAtual()>rota.getQuilometragem()) {
			tanqueAtual -= rota.getQuilometragem()*CONSUMO;
		}
	}
	
}