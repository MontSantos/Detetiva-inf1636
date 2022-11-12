package model;

public class Carta {
	
	// Variaveis
	private int player; // Identificar o jogador que possui a carta;
	private String nome;
	private int tipo; // 0 é Suspeito, 1 é Arma e 2 é Cômodo
	
	// Construtor
	public Carta(String nome, int tipo){
		this.nome = nome;
		this.tipo = tipo;
		}
	
	// Metodos
	public String getNome() {
		return this.nome;
	}
	
	public int getTipo() {
		return this.tipo;
	}
	
	public void setJogador(int jogador) {
		this.player = jogador;
	}
	
	public int getJogador() {
		return this.player;
	}


}