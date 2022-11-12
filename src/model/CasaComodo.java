package model;

class CasaComodo extends Casa{
    
    private boolean porta;
    private boolean passSct;
    Sala nome;
    
    public CasaComodo() {
        porta = false;
        passSct = false;
    }
    
    public boolean getPass() {
        return passSct;
    }
    
    public void setPass() {
        if (this.nome == Sala.KITCHEN || this.nome == Sala.CONSERVATORY || this.nome == Sala.LOUNGE || this.nome == Sala.STUDY)
            passSct = true;
    }
    
    public boolean getPorta() {
        return porta;
    }
    
    public void setPorta() {
        porta = true;
    }
    
    public void setSala(char c) {
        switch(c) {
        case 'k':
            nome = Sala.KITCHEN;
            break;
        case 'b':
            nome = Sala.BALLROOM;
            break;
        case 'c':
            nome = Sala.CONSERVATORY;
            break;
        case 'd':
            nome = Sala.DININGROOM;
            break;
        case 'l':
            nome = Sala.LOUNGE;
            break;
        case 'i':
            nome = Sala.BILLIARDROOM;
            break;
        case 'h':
            nome = Sala.HALL;
            break;
        case 's':
            nome = Sala.STUDY;
            break;
        case 'o':
            nome = Sala.LIBRARY;
            break;
        }
    }
    
    public Sala getSala() {
        return nome;
    }
    
}