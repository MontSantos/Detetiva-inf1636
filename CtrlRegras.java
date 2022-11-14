package model;


import java.io.File;
import java.util.*;

import javax.imageio.ImageIO;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import Controller.*;

public class CtrlRegras implements ObservadoIF{
	
	// Variaveis
	private static CtrlRegras instance = null;
	
	private String sus[] = {"Srta. Scarlet", "Coronel Mustard", "Professor Plum", "Reverendo Green", "Sra. White", "Sra. Peacock"};
	private String guns[] = {"Corda", "Cano", "Faca", "Chave Inglesa", "Castical", "Revolver"}; 
	private String rooms[] = {"Biblioteca", "Cozinha", "Entrada", "Escritorio", "Jardim de Inverno", "Sala de Estar", "Sala de Jantar", "Sala de Musica", "Salao de Jogos"};
	
	private final static int MAXPLAYERS = 6;
	private final static int  MINPLAYERS = 3;
	
	private int estado = 0;
	private int numPlayers = 0;
	private int playerIndex = 0;
	private Player playerAtual;
	private int[] dadosV = new int[2];
	private int somaDados = 0;
	
	private boolean jogouDados;
	private boolean moveu;
	private boolean palpitou;
	private boolean acusou;
	
	private ArrayList<Player> lstPlayer = new ArrayList<Player>();
	private ArrayList<ObservadorIF> observers = new ArrayList<ObservadorIF>();

	
	private Dado dado1 = new Dado();
	private Dado dado2 = new Dado();
	
	private ArrayList<Carta> cartas = new ArrayList<Carta>(); 
	private String[] resposta = new String[3];
	
	private Tabuleiro tab= new Tabuleiro();

	
	
	public void iniciaJogo() {
		tab.cria();
		
		dadosV[0] = 1;
		dadosV[1] = 1;
			
		distribuiCartas();
		
		for (int i = 0; i<numPlayers; i++) {
			switch(lstPlayer.get(i).getNome()) {
			case "Srta. Scarlet":{
				lstPlayer.get(i).setCoordinates(182, 630);
				lstPlayer.get(i).setPosition(7, 24);
				break;
			}
			case "Coronel Mustard":{
				lstPlayer.get(i).setCoordinates(12, 452);
				lstPlayer.get(i).setPosition(0, 17);
				break;
			}
			case "Sra. White": {
				lstPlayer.get(i).setCoordinates(229, 15);
				lstPlayer.get(i).setPosition(9, 0);
				break;
			}
			case "Reverendo Green":{
				lstPlayer.get(i).setCoordinates(349, 15);
				lstPlayer.get(i).setPosition(14, 0);
				break;
			}
			case "Sra. Peacock":{	
				lstPlayer.get(i).setCoordinates(569, 169);
				lstPlayer.get(i).setPosition(23, 6);
				break;
			}
			case "Professor Plum":{
				lstPlayer.get(i).setCoordinates(569, 503);
				lstPlayer.get(i).setPosition(23, 19);
				break;
			}
			}
		}
		
		playerAtual = lstPlayer.get(0);
		dadosV[0] = 1;
		dadosV[1] = 1;
		jogouDados = false;  
		moveu = false;       
		palpitou = false;    
		acusou = false;   
		
			
	}
	
	public void jogo() {
		estado = 0;
		playerIndex = (playerIndex + 1) % numPlayers; // será o próximo jogador
		playerAtual = lstPlayer.get(playerIndex);
		jogouDados = false;
		
		// Pode agir normalmente
		if (estado == 0) {

			
//			tab.movimenta(dadosV, playerAtual, tab.getCasa(pos));			
			estado = 1;
		}
		
//		// Já se moveu
//		if (estado == 1) {
//			if () {
//
//			}
//			else {
//				//moverboneco
//				//continue;
//			}
//			
//		}
		
		// Só pode ver as cartas, usar o bloco e e acabar a jodaga
		if (estado == 2) {
			// faz palpite
			boolean palpite = false;
			if (palpite) {
				// estado++;
			} else {
				// palpite errado
			}
			boolean acusar = false;
			if (acusar)
				estado++;
			//else
				//continue;
		}
		
//		if (estado == 3) {
//			//faz acusaÃ§ao
//			boolean acusacao = false;
//			if (acusacao) {
//				//player venceu;
//				//break;
//			}
//			lstPlayer.remove(playerAtual);
//		}
		
		this.notificaAll();
		//vencedor pisca aqui	
	}
	
	public void turnoPlayer() {
		playerAtual = lstPlayer.get(playerIndex);
		int[] playerPosition = playerAtual.getPawnPosition();
//		if(estado == 1) {
//			
//		}
		this.notificaAll();
		return;
	}
	
	// Instance
	public static CtrlRegras getInstance() {
		if(instance == null)
			instance = new CtrlRegras();
		return instance;
	}

	// Metodos
	public boolean checkQntPlayers(int qnt) {
		if(qnt > MAXPLAYERS || qnt < MINPLAYERS) {
			JOptionPane.showMessageDialog(null, "Número de jogadores inválido. Tente novamente.");
			return false;
		}
		numPlayers = qnt;
		return true;
	}
	
	public int getQntPlayers() {
		return numPlayers;
	}
	
	public void GeraResposta() {
		Random res = new Random();
		resposta[0] = sus[res.nextInt(6)];
		resposta[1] = guns[res.nextInt(6)];
		resposta[2] = rooms[res.nextInt(9)];
	}
	
	public ArrayList<Player> getPlayers(){
		return lstPlayer;
	}
	
	
// Inicialização de componentes do jogo
	
	public void initPlayers(ArrayList<String> personagens) {
		String auxColor = "r";
	    int pawnNumber = 0;
	    String nome = "Srta. Scarlet"; 
        for(int i = 0; i < numPlayers; i++) {
            
            switch(personagens.get(i)) {
                case "Scarlet":{
                    auxColor = "r";
                    pawnNumber = 0;
                    nome = "Srta. Scarlet";
                    break;
                }
                case "Mustard":{
                    auxColor = "y";
                    pawnNumber = 1;
                    nome = "Coronel Mustard";
                    break;
                }
                case "White":{
                    auxColor = "w";
                    pawnNumber = 2;
                    nome = "Sra. White";
                    break;
                }
                case "Green":{
                    auxColor = "g";
                    pawnNumber = 3;
                    nome = "Reverendo Green";
                    break;
                }
                case "Peacock":{
                    auxColor = "z";
                    pawnNumber = 4;
                    nome = "Sra. Peacock";
                    break;
                }
                case "Plum":{
                    auxColor = "x";
                    pawnNumber = 5;
                    nome = "Professor Plum";
                    break;
                }
            
            }
	        lstPlayer.add(new Player(i+1, auxColor, nome, pawnNumber));
        }
        	        
    }
	
	void embaralhaCartas() {
		for(int i = 0;i<6;i++) {
			if(!sus[i].equals(resposta[0])) {
				cartas.add(new Carta(sus[i], 0));
			}
			if(!guns[i].equals(resposta[1])) {
				cartas.add(new Carta(guns[i], 1));
			}
		}
		for(int i = 0; i<9 ; i++) {
			if(!rooms[i].equals(resposta[2])) {
				cartas.add(new Carta(rooms[i], 2));
			}
		}
		
		Collections.shuffle(cartas);
	}
	
	public void distribuiCartas() {
		this.GeraResposta();
		this.embaralhaCartas();
		
		int sobra = cartas.size() % getQntPlayers();
		int qntPorJogador =  (cartas.size() - sobra)/getQntPlayers();
		
		if(sobra == 0) {
			for(Player player : lstPlayer) {
				for(int j = 0; j< qntPorJogador; j++) {
					player.daCarta(cartas.get(0));
					cartas.remove(0);
				}					
			}
		}
		else {
			for (Player player: lstPlayer) {
				for(int j = 0; j< qntPorJogador; j++) {
					player.daCarta(cartas.get(0));
					cartas.remove(0);
				}
				if (sobra > 0) {
					player.daCarta(cartas.get(0));
					sobra--;
				}
			}
		}
	}
	
/// Lida com jogadores	
	
	public Player getPlayer(int i) {
		return lstPlayer.get(i);
	}
	
	public Player getPlayerAtual() {
		return playerAtual;
	}
	
	public String getPlayerAtualNome() {
		return playerAtual.getNome();
	}
	
	public int getPLayerAtualId() {
		return playerAtual.getPlayerId();
	}
	
	public int getQtdCartasAtual() {;
		return playerAtual.getQtdCartas();
	}
	
	public ArrayList<String> getNotasPlayerAtual(){
		return playerAtual.getNotas();
	}
	
	public void setNotasPlayerAtual(ArrayList<String> notas) {
		playerAtual.setNotas(notas);
	}
	
	public String[] getListaNomes() {
		String[] nomes = new String[numPlayers];
		for (int i = 0; i < numPlayers; i++) {
			nomes[i] = lstPlayer.get(i).getNome();
		}
		
		return nomes;
	}
	
	public int[][] getListaCoord() {
		int[][] coords = new int[numPlayers][2];
		for (int i = 0; i < numPlayers; i++) {
			coords[i] = lstPlayer.get(i).getPawnCoordinates();
		}
		
		return coords;
	}
	
// Lida com as Cartas
	
	public ArrayList<String> getNomeCardPlayer(){
		ArrayList<String> cartas = new ArrayList<String>();
		for (Carta carta: playerAtual.getCartasPlayer()) {
			cartas.add(carta.getNome());
		}
		
		return cartas;
	}
	
	public ArrayList<Integer> getTipoCardPlayer(){
		ArrayList<Integer> tipo = new ArrayList<Integer>();
		for(Carta carta: playerAtual.getCartasPlayer()) {
			tipo.add(carta.getTipo());
		}
		
		return tipo;
	}
	
	public void jogaDados() {
		dado1.jogaDado();
		dado2.jogaDado();
		dadosV[0] = dado1.getDado();
		dadosV[1] = dado2.getDado();
		somaDados = dadosV[0] + dadosV[1];
		jogouDados = true;
		
		notificaAll();
	}
	
// Lida com os dados
	public boolean jogouDados() {
		return this.jogouDados;
	}
	
	public int[] getValorDados() {
		return dadosV;
	}
	
	public void setValorDados(int d1, int d2) {
		this.dadosV[0] = d1;
		this.dadosV[1] = d2;
		this.somaDados = dadosV[0] + dadosV[1];
		jogouDados = true;
		
		notificaAll();
	}
	
	public void movimenta(int[] pos) {
		tab.movimenta(this.dadosV, playerAtual, tab.getCasa(pos));
		this.estado = 1;
		playerAtual.setCoordinates((pos[0]+1)*12, (pos[1]+1)*12);
		turnoPlayer();
	}

//
	@Override
	public void add(ObservadorIF o) {
		observers.add(o);
		
	}


	@Override
	public void remove(ObservadorIF o) {
		observers.remove(o);
	}


	@Override
	public int get(int var) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	private void notificaAll() {
		for (ObservadorIF obs : observers) {
			obs.notify(this);
		}
	}
	
		
}
