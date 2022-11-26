package model;

class CasaComodo extends Casa{
    
    private boolean porta;
    private boolean passSct;
    private String nome;
    
    public CasaComodo() {
        porta = false;
        passSct = false;
    }
    
    public boolean getPass() {
        return passSct;
    }
    
    public void setPass() {
        if (this.nome == "Cozinha" || this.nome == "Jardim de Inverno" || this.nome =="Sala de Estar" || this.nome == "Escritório")
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
            nome = "Cozinha";
            break;
        case 'b':
            nome = "Sala de Música";
            break;
        case 'c':
            nome = "Jardim de Inverno";
            break;
        case 'd':
            nome = "Sala de Jantar";
            break;
        case 'l':
            nome = "Sala de Estar";
            break;
        case 'i':
            nome = "Salão de Jogos";
            break;
        case 'h':
            nome =  "Entrada";
            break;
        case 's':
            nome = "Escritório";
            break;
        case 'o':
            nome = "Biblioteca";
            break;
        }
    }
    
    public String getSala() {
        return nome;
    }
    
}