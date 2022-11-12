package model;

import java.util.Random;

class Dado {
    
    private int dado1;
    
    Random rand = new Random();
    
    public int getDado() {
        return this.dado1;
    }
    
    public void jogaDado() {
        this.dado1 = rand.nextInt(6)+1;
    }
    
    public void setDado(int x) {
        this.dado1 = x;
    }
    
}