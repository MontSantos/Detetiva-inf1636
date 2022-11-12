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
    
//    public void movePawn(int dado) {
//        pawn.move(dado);
//    }
    
    public void daCarta(Carta carta) {
    	this.cartas.add(carta);
    }
    
    public ArrayList<Carta> getCartasPlayer() {
        return this.cartas;
    }
    
    public int[] getPawnCoordinates() {
        return pawn.getCoordinates();
    }
    
    public void setCoordinates(int x, int y) {
        pawn.setCoordinates(x,y);
    }
    
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