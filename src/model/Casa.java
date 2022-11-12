package model;

import java.util.ArrayList;

class Casa{
	// Variaveis
    protected int jogador = -5;
    private int posX;
    private int posY;
    private ArrayList<Casa> vizinhos = new ArrayList<Casa>();
    private int dist;
    
    protected boolean percorrida = false;
    
    public Casa() {
    	
    }
    
    public Casa (int x, int y, int dist) {
    	this.posX = x;
    	this.posY = y;
    	this.dist = -1;
    }
    
    public void setPerc() {
        percorrida = !percorrida;
    }
    
    public boolean getPerc() {
    	return percorrida;	
    }
    
    public int getX(){
        return posX;
      }
      
    public int getY(){
        return posY;
      }
   
    public void setJogador(int x) {
        jogador = x;
    }
    
    public int getJogador() {
        return jogador;
    }
    
   public void addVizinho(Casa vizinho) {
	   vizinhos.add(vizinho);	   
   }
    
   public ArrayList<Casa> getVizinhos(){
	   return vizinhos;
   }
   
   public void setDistance(int d) {
	   this.dist = d;
   }
   
   public int getDistance() {
	   return this.dist;
   }
   
   public void resetDistance() {
	   this.dist = -1;
   }
}