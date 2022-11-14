package model;

import java.util.ArrayList;

public class Player {
    
    // Variaveis
    
    private int number;
    private String nome;
    private String cor;
    
    private Pawn pawn;
    
    private boolean saiuDoJogo = false;
    
    private ArrayList<Carta> cartas = new ArrayList<Carta>();
    
    private ArrayList<String> notas = new ArrayList<String>();
    
    // Constructor
    
    public Player(int playerId, String cor, String nome, int pin) {
        this.number = playerId;
        this.nome = nome;
        this.cor = cor;
        this.pawn = new Pawn(pin);
    }
    
    // Metodos
    
    public int getPin() {
        return this.pawn.getPawnNumber();
    }
    
    public int getPlayerId() {
        return this.number;
    }
    
    public String getNome() {
        return this.nome;
    }
    
    public String getCor() {
        return this.cor;
    }
    
    public void daCarta(Carta carta) {
    	this.cartas.add(carta);
    }
    
    public ArrayList<Carta> getCartasPlayer() {
        return this.cartas;
    }
    
    public int getQtdCartas() {
    	return cartas.size();
    }
    
    public ArrayList<String> getNotas(){
    	return this.notas;
    }
    
    public void setNotas(ArrayList<String> notas) {
    	this.notas = notas;
    }
    
    // Posicao na matriz do tabuleiro
    public int[] getPawnPosition() {
    	return pawn.getPosition();
    }
    
    // Posicao no componente visual
    public int[] getPawnCoordinates() {
        return pawn.getCoordinates();
    }
    
 // Posicao no componente visual
    public void setCoordinates(int x, int y) {
        pawn.setCoordinates(x,y);
    }
    
    // Posicao na matriz do tabuleiro
    public void setPosition(int x, int y) {
        pawn.setPosition(x,y);
    }
    
    public boolean getSaiuDoJogo() {
        return saiuDoJogo;
    }
    
    public boolean setSaiuDoJogo() {
        saiuDoJogo = !saiuDoJogo;
        return saiuDoJogo;
    }
    
}