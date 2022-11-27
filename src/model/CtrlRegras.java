package model;


import java.awt.Color;
import java.io.*;
import java.util.*;

import javax.imageio.ImageIO;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import java.lang.Math.*;
import javax.swing.filechooser.FileNameExtensionFilter;


import Controller.*;

public class CtrlRegras implements ObservadoIF{
	
	// Variaveis
	private static CtrlRegras instance = null;
	
	private String sus[] = {"Srta. Scarlet", "Col. Mustard", "Prof. Plum", "Rev. Green", "Sra. White", "Sra. Peacock"};
	private String guns[] = {"Corda", "Cano", "Faca", "Chave Inglesa", "Castical", "Revólver"}; 
	private String rooms[] = {"Biblioteca", "Cozinha", "Entrada", "Escritório", "Jardim de Inverno", "Sala de Estar", "Sala de Jantar", "Sala de Música", "Salão de Jogos"};
	
	private ArrayList<String> sus2 = new ArrayList<String>() {
		{
		add("Srta. Scarlet");
		add("Col. Mustard");
		add("Prof. Plum");
		add("Rev. Green");
		add("Sra. White");
		add("Sra. Peacock");
		}
	};
	
	
	private final static int MAXPLAYERS = 6;
	private final static int  MINPLAYERS = 3;
	
	private int estado = 0;
	private int numPlayers = 0;
	private int numPeoes = 0;
	private int playerIndex = 0;
	private Player playerAtual;
	private int[] dadosV = new int[2];
	private int somaDados = 0;
	
	private boolean jogouDados;
	
	private ArrayList<Player> lstPlayer = new ArrayList<Player>();
	private ArrayList<Pawn> lstPeoes = new ArrayList<Pawn>();
	private ArrayList<ObservadorIF> observers = new ArrayList<ObservadorIF>();

	
	private Dado dado1 = new Dado();
	private Dado dado2 = new Dado();
	
	private ArrayList<Carta> cartas = new ArrayList<Carta>(); 
	private String[] resposta = new String[3];
	
	private Tabuleiro tab= new Tabuleiro();

	
	
	public void iniciaJogo() {
		Tabuleiro.cria();
		
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
			case "Col. Mustard":{
				lstPlayer.get(i).setCoordinates(12, 452);
				lstPlayer.get(i).setPosition(0, 17);
				break;
			}
			case "Sra. White": {
				lstPlayer.get(i).setCoordinates(229, 15);
				lstPlayer.get(i).setPosition(9, 0);
				break;
			}
			case "Rev. Green":{
				lstPlayer.get(i).setCoordinates(349, 15);
				lstPlayer.get(i).setPosition(14, 0);
				break;
			}
			case "Sra. Peacock":{	
				lstPlayer.get(i).setCoordinates(569, 169);
				lstPlayer.get(i).setPosition(23, 6);
				break;
			}
			case "Prof. Plum":{
				lstPlayer.get(i).setCoordinates(569, 503);
				lstPlayer.get(i).setPosition(23, 19);
				break;
			}
			}
		}
		
		for (int i = 0; i< numPeoes; i++) {
			switch(lstPeoes.get(i).getPawnNumber()) {
				case 0:{
					lstPeoes.get(i).setCoordinates(182, 630);
					lstPeoes.get(i).setPosition(7, 24);
					break;
				}
				case 1:{
					lstPeoes.get(i).setCoordinates(12, 452);
					lstPeoes.get(i).setPosition(0, 17);
					break;
				}
				case 2: {
					lstPeoes.get(i).setCoordinates(229, 15);
					lstPeoes.get(i).setPosition(9, 0);
					break;
				}
				case 3:{
					lstPeoes.get(i).setCoordinates(349, 15);
					lstPeoes.get(i).setPosition(14, 0);
					break;
				}
				case 4:{	
					lstPeoes.get(i).setCoordinates(569, 169);
					lstPeoes.get(i).setPosition(23, 6);
					break;
				}
				case 5:{
					lstPeoes.get(i).setCoordinates(569, 503);
					lstPeoes.get(i).setPosition(23, 19);
					break;
				}
			}
		}
		
		playerAtual = lstPlayer.get(0);
		dadosV[0] = 1;
		dadosV[1] = 1;
		jogouDados = false;
			
	}
	
	public void jogo() {
		this.estado = 0;
		playerIndex = (playerIndex + 1) % numPlayers; // será o próximo jogador
		playerAtual = lstPlayer.get(playerIndex);
		jogouDados = false;
		tab.resetaPassagem();
		
		if(playerAtual.getSaiuDoJogo()) {
			jogo();
		}

		turnoPlayer();
		
		this.notificaAll();
	}
	
	// Turno do jogador
	public void turnoPlayer() {
		playerAtual = lstPlayer.get(playerIndex);
		
		// 0 pode jogar os dados
		
		// 1 pode se movimentar
		
		// 2 já se moveu
		
		// 3 só pode ver as cartas e bloco de notas
		
		this.notificaAll();
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
		numPeoes= 6 - numPlayers;
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
                    nome = "Col. Mustard";
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
                    nome = "Rev. Green";
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
                    nome = "Prof. Plum";
                    break;
                }
            
            }
            sus2.remove(sus2.indexOf(nome));
	        lstPlayer.add(new Player(i+1, auxColor, nome, pawnNumber));
	    
        }
        
        for(int j = 0; j<sus2.size(); j++) {
        	switch(sus2.get(j)) {
	            case "Srta. Scarlet":{
	                pawnNumber = 0;
	                break;
	            }
	            case "Col. Mustard":{
	                pawnNumber = 1;
	                break;
	            }
	            case "Sra. White":{
	                pawnNumber = 2;
	                break;
	            }
	            case "Rev. Green":{
	                pawnNumber = 3;
	                break;
	            }
	            case "Sra. Peacock":{
	                pawnNumber = 4;
	                break;
	            }
	            case "Prof. Plum":{
	                pawnNumber = 5;
	                break;
	            }
        	}
        	lstPeoes.add(new Pawn(pawnNumber));
        }
        	        
    }
	
	public void carregaPlayers(int nPlayers, String[] pColors, String[] pNames, int posicao[][], boolean[] saiuDoJogo) {
		String auxColor = "r";
		int pinNumber = 0;
	    String nome = "Srta. Scarlet"; 
	    
		for (int i = 0; i < nPlayers; i++) {
			switch (pColors[i]) {
				case "r": {
					auxColor = "r";
					pinNumber = 0;
					nome = "Srta. Scarlet";
					break;
				}
				case "y": {
					auxColor = "y";
					pinNumber = 1;
					nome = "Col. Mustard";
					break;
				}
				case "w": {
					auxColor = "w";
					pinNumber = 2;
					nome = "Sra. White";
					break;
				}
				case "g": {
					auxColor = "g";
					pinNumber = 3;
					nome = "Rev. Green";
					break;
				}
				case "z": {
					auxColor = "z";
					pinNumber = 4;
					nome = "Sra. Peacock";
					break;
				}
				case "x": {
					auxColor = "x";
					pinNumber = 5;
					nome = "Prof. Plum";
					break;
				}

			}
			
			lstPlayer.add(new Player(i+1, auxColor, nome, pinNumber));

			Player p = lstPlayer.get(i);

			p.setPosition(posicao[i][0], posicao[i][1]);
			//System.out.printf("%d - %d\n", p.getPawnPosition()[0], p.getPawnPosition()[1]);
			
			
			tab.setJogadorCasa(posicao[i], pinNumber);

			if (saiuDoJogo[i]) {
				p.setSaiuDoJogo();
			}

		}
	}
	
	public void carregaPeoes(int nPeoes, int[] idPeoes, int posicao[][]) {
		int pinNumber = 0; 
	    
		for (int i = 0; i < nPeoes; i++) {
			switch (idPeoes[i]) {
				case 0: {
					pinNumber = 0;
					break;
				}
				case 1: {
					pinNumber = 1;
					break;
				}
				case 2: {
					pinNumber = 2;
					break;
				}
				case 3: {
					pinNumber = 3;
					break;
				}
				case 4: {
					pinNumber = 4;
					break;
				}
				case 5: {
					pinNumber = 5;
					break;
				}

			}
			
			lstPeoes.add(new Pawn(pinNumber));

			Pawn p = lstPeoes.get(i);

			p.setPosition(posicao[i][0], posicao[i][1]);
						
			tab.setJogadorCasa(posicao[i], pinNumber);
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
	
//	public void imprimeTab() {
//		tab.printTab();
//	}
	
/// Lida com jogadores	
	
	public void setEstado(int x) {
		this.estado = x;
	}
	
	public int getEstado() {
		return this.estado;
	}
	
	public Player getPlayer(int i) {
		return lstPlayer.get(i);
	}
	
	public Player getPlayerAtual() {
		return playerAtual;
	}
	
	public void eliminaPlayer() {
		this.playerAtual.setSaiuDoJogo();
	}
	
	public void podeJogar() {
		this.playerAtual.getSaiuDoJogo();
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
	
	public boolean[] getNotasPlayerAtual(){
		return playerAtual.getNotas();
	}
	
	public void setNotasPlayerAtual(boolean[] notas) {
		playerAtual.setNotas(notas);
	}
	
	public String[] getListaNomes() {
		String[] nomes = new String[numPlayers];
		for (int i = 0; i < numPlayers; i++) {
			nomes[i] = lstPlayer.get(i).getNome();
		}
		
		return nomes;
	}
	
	public int[] getNumPeoes() {
		int[] peoes = new int[numPeoes];
		for(int i = 0; i< numPeoes; i++) {
			peoes[i] = lstPeoes.get(i).getPawnNumber();
		}
		return peoes;
	}
	
	public int[][] getListaCoord() {
		int[][] coords = new int[numPlayers][2];
		for (int i = 0; i < numPlayers; i++) {
			coords[i] = lstPlayer.get(i).getPawnCoordinates();
		}
		
		return coords;
	}
	
	public int[][] getListaCoordPeao(){
		int[][] coords = new int[numPeoes][2];
		for(int i = 0; i< numPeoes; i++) {
			coords[i] = lstPeoes.get(i).getCoordinates();
		}
		
		return coords;
	}
	
	public boolean acusa(Player player, String[] acusacao) {
		if(acusacao[0].equals(this.resposta[0]) && acusacao[1].equals(this.resposta[1]) && acusacao[2].equals(this.resposta[2])) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean podePalpitar(Player player) {
		return tab.estaEmComodo(player.getPawnPosition());
	}
	
    public String getComodo() {
    	return tab.getComodo(playerAtual.getPawnPosition());
    }
	
	public String palpita(Player player, String[] palpite) {
		String resposta = null;
		Player playerVerificado;
		
		for(Player playerAcusado: lstPlayer) {
			if(playerAcusado.getNome().equals(palpite[0])) {
				tab.movimentaPalpite(palpite[2], playerAcusado);
			}
		}
		
		for(int i = 0; i < numPeoes; i++) {
			if(palpite[0] == "Srta. Scarlet") {
				for(Pawn peao: lstPeoes) {
					if(peao.getPawnNumber() == 0) {
						tab.movimentaPalpitePeao(palpite[2], peao);
					}
				}
			}
			else if(palpite[0] == "Col. Mustard") {
				for(Pawn peao: lstPeoes) {
					if(peao.getPawnNumber() == 1) {
						tab.movimentaPalpitePeao(palpite[2], peao);
					}
				}
			}
			else if(palpite[0] == "Sra. White") {
				for(Pawn peao: lstPeoes) {
					if(peao.getPawnNumber() == 2) {
						tab.movimentaPalpitePeao(palpite[2], peao);
					}
				}
			}
			else if(palpite[0] == "Rev. Green") {
				for(Pawn peao: lstPeoes) {
					if(peao.getPawnNumber() == 3) {
						tab.movimentaPalpitePeao(palpite[2], peao);
					}
				}
			}
			else if(palpite[0] == "Sra. Peacock") {
				for(Pawn peao: lstPeoes) {
					if(peao.getPawnNumber() == 4) {
						tab.movimentaPalpitePeao(palpite[2], peao);
					}
				}
			}
			else if(palpite[0] == "Prof. Plum") {
				for(Pawn peao: lstPeoes) {
					if(peao.getPawnNumber() == 5) {
						tab.movimentaPalpitePeao(palpite[2], peao);
					}
				}
			}
			
		}
		
		notificaAll();
		
		int indexPlayerAtual = lstPlayer.indexOf(player);
		
		for(int i = indexPlayerAtual+1; i < lstPlayer.size(); i++) {
			playerVerificado = lstPlayer.get(i);
			resposta = verificaPalpite(playerVerificado, palpite);
			
			if (resposta != null) {
				return resposta;
			}
			
		}
		
		for(int i = 0; i<indexPlayerAtual; i++){
			playerVerificado = lstPlayer.get(i);
			
			resposta = verificaPalpite(playerVerificado, palpite);
			
			if (resposta != null) {
				return resposta;
			}
			
		}
		
		setEstado(3);
				
		return null;
	}
	
	public String verificaPalpite(Player playerVerificado, String[] palpite) {
		
		for(Carta carta: playerVerificado.getCartasPlayer()) {
			String nomeCarta = carta.getNome();
			
			if(nomeCarta.equals(palpite[0])) {
				return palpite[0];
			}
			
			if(nomeCarta.equals(palpite[1])) {
				return palpite[1];
			}
			
			if(nomeCarta.equals(palpite[2])) {
				return palpite[2];
			}
		}
		
		return null;
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
		
		setEstado(1);
		
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
	
	public void setSomaDados() {
		this.somaDados-=1;
	}
	
	public void movimenta(int[] pos, int[] coord) {

		if(somaDados>0) {
			tab.movimenta(this.somaDados, playerAtual, pos, coord);
			notificaAll();
			if(tab.estaEmComodo(playerAtual.getPawnPosition()) && somaDados < (dadosV[0]+dadosV[1])) {
				somaDados = 0;
			}
			if(tab.getMoveu()) {
				somaDados-=1;
				tab.setMoveu();
			}
		}
		
		if(somaDados == 0) {
			setEstado(2);
			turnoPlayer();
		}
	}
	
	public void movimentaSecreta() {
		tab.movimentaSecreta(playerAtual);
		setEstado(2);
		turnoPlayer();
		notificaAll();
	}
	

//
	
	public void saveGame() {
		JFileChooser fc = new JFileChooser(".");
		fc.setFileFilter(new FileNameExtensionFilter("TXT Files (*.txt)", "txt"));

		if (fc.showOpenDialog(null) != JFileChooser.APPROVE_OPTION) {
			// cancelar save caso tenha clicado cancel ou X
			return;
		}
		
		File file = fc.getSelectedFile();

		FileWriter writer;
		try {
			// numero de jogadores
			writer = new FileWriter(file);
			writer.append("" + numPlayers);
			writer.append("\n");
			
			// cor
			writer.append("Cores");
			writer.append("\n");
			for (int i = 0; i < this.numPlayers; i++) {
				writer.append(lstPlayer.get(i).getCor());
				writer.append("\n");
			}
			writer.append("\n");
			
			// nome
			writer.append("Nomes");
			writer.append("\n");
			for (int i = 0; i < this.numPlayers; i++) {
				writer.append(lstPlayer.get(i).getNome());
				writer.append("\n");
			}
			writer.append("\n");
			
			// Numero dos peoes avulsos
			writer.append("Numeros Peoes");
			writer.append("\n");
			for (int i = 0; i < this.numPeoes; i++) {
				writer.append("" + lstPeoes.get(i).getPawnNumber());
				writer.append("\n");
			}
			writer.append("\n");
			
			// posicao
			writer.append("Posicoes");
			writer.append("\n");
			for (int i = 0; i < this.numPlayers; i++) {
				writer.append("" + lstPlayer.get(i).getPawnPosition()[0]);
				writer.append("\n");
				writer.append("" + lstPlayer.get(i).getPawnPosition()[1]);
				writer.append("\n");
			}
			writer.append("\n");
			
			// posicao peao
			writer.append("Posicoes Peoes");
			writer.append("\n");
			for (int i = 0; i < this.numPeoes; i++) {
				writer.append("" + lstPeoes.get(i).getPosition()[0]);
				writer.append("\n");
				writer.append("" + lstPeoes.get(i).getPosition()[1]);
				writer.append("\n");
			}
			writer.append("\n");
			
			// coordenada
			writer.append("Coordenadas");
			writer.append("\n");
			for (int i = 0; i < this.numPlayers; i++) {
				writer.append("" + lstPlayer.get(i).getPawnCoordinates()[0]);
				writer.append("\n");
				writer.append("" + lstPlayer.get(i).getPawnCoordinates()[1]);
				writer.append("\n");
			}
			writer.append("\n");
			
			// coordenada
			writer.append("Coordenadas Peoes");
			writer.append("\n");
			for (int i = 0; i < this.numPeoes; i++) {
				writer.append("" + lstPeoes.get(i).getCoordinates()[0]);
				writer.append("\n");
				writer.append("" + lstPeoes.get(i).getCoordinates()[1]);
				writer.append("\n");
			}
			writer.append("\n");
			
			// Cartas
			writer.append("Carta");
			writer.append("\n");
			for (int i = 0; i < this.numPlayers; i++) {
				writer.append("" + lstPlayer.get(i).getCartasPlayer().size());
				writer.append("\n");
				for(Carta carta: lstPlayer.get(i).getCartasPlayer()) {
					writer.append("" + carta.getNome());
					writer.append("\n");
					writer.append("" + carta.getTipo());
					writer.append("\n");
					
				};
			}
			writer.append("\n");
			
			// Bloco de Notas
			writer.append("Bloco de Notas");
			writer.append("\n");
			for (int i = 0; i < this.numPlayers; i++) {
				for(boolean anotacao: lstPlayer.get(i).getNotas()) {
					writer.append("" + anotacao);
					writer.append("\n");
				}
			}
			writer.append("\n");

			// saiuDoJogo
			writer.append("saiu do Jogo");
			writer.append("\n");
			for (int i = 0; i < this.numPlayers; i++) {
				writer.append("" + lstPlayer.get(i).getSaiuDoJogo());
				writer.append("\n");
			}
			writer.append("\n");
			
			// Resposta
			writer.append("Resposta");
			writer.append("\n");
			for (String res: resposta) {
				writer.append("" + res);
				writer.append("\n");
			}
			writer.append("\n");
			
			// Jogador Atual
			writer.append("playerAtual");
			writer.append("\n");
			writer.append(playerAtual.getPlayerId() + "\n");
			
			writer.close();

			JOptionPane.showMessageDialog(null, "O jogo foi salvo com sucesso!");
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
	}
	
	public void organizeLoadedGame() {
		// referente ao jogo salvo
		JFileChooser fc = new JFileChooser(".txt");
		fc.setFileFilter(new FileNameExtensionFilter("TXT Files (*.txt)", "txt"));

		if (fc.showOpenDialog(null) != JFileChooser.APPROVE_OPTION) {
			// sair caso tenha clicado cancel ou X
			System.exit(0);
		}

		File file = fc.getSelectedFile();

		if (fc.getSelectedFile().length() > 10000) {
			JOptionPane.showMessageDialog(null,
					"Erro: arquivo muito grande. Provavelmente não foi gerado pelo jogo.");
			System.exit(0);
		}

		String cores[] = null;
		String nomes[] = null;
		String resposta[] = null;
		int qntCartas[] = null;
		int idPeoes[] = null;
		int posicoes[][] = null;
		int posicoesPeoes[][] = null;
		int coordenadas[][] = null;
		int coordenadasPeoes[][] = null;
		boolean notas[][] = null;
		boolean saiuJogo[] = null;

		int pA=1;
		
		Tabuleiro.cria();
		
		tab.tabReseta();

		ArrayList<Carta> cartas = new ArrayList<Carta>();

		try {

			// load saved game
			Scanner s = null;

			try {
				s = new Scanner(new BufferedReader(new FileReader(file)));
				while (s.hasNextLine()) {
					String line = s.nextLine();
					if (numPlayers == 0) {
						numPlayers = Integer.parseInt(line);
						numPeoes = 6 - numPlayers;
					}
					
					if (line.compareTo("Cores") == 0) {
						cores = new String[numPlayers];
						for (int k = 0; k < numPlayers; k++) {
							cores[k] = s.nextLine();
						}
					}
					if (line.compareTo("Nomes") == 0) {
						nomes = new String[numPlayers];
						for (int k = 0; k < numPlayers; k++) {
							nomes[k] = s.nextLine();
						}
					}
					
					if (line.compareTo("Numeros Peoes") == 0) {
						idPeoes = new int[numPeoes];
						for (int k = 0; k < numPeoes; k++) {
							idPeoes[k] = Integer.parseInt(s.nextLine());
						}
					}
					
					if (line.compareTo("Posicoes") == 0) {
						posicoes = new int[numPlayers][2];
						for (int k = 0; k < numPlayers; k++) {
							posicoes[k][0] = Integer.parseInt(s.nextLine());
							posicoes[k][1] = Integer.parseInt(s.nextLine());
						}
					}
					
					if (line.compareTo("Posicoes Peoes") == 0) {
						posicoesPeoes = new int[numPeoes][2];
						for (int k = 0; k < numPeoes; k++) {
							posicoesPeoes[k][0] = Integer.parseInt(s.nextLine());
							posicoesPeoes[k][1] = Integer.parseInt(s.nextLine());
						}
					}
					
					if (line.compareTo("Coordenadas") == 0) {
						coordenadas = new int[numPlayers][2];
						for (int k = 0; k < numPlayers; k++) {
							coordenadas[k][0] = Integer.parseInt(s.nextLine());
							coordenadas[k][1] = Integer.parseInt(s.nextLine());
						}
					}
					
					if (line.compareTo("Coordenadas Peoes") == 0) {
						coordenadasPeoes = new int[numPeoes][2];
						for (int k = 0; k < numPeoes; k++) {
							coordenadasPeoes[k][0] = Integer.parseInt(s.nextLine());
							coordenadasPeoes[k][1] = Integer.parseInt(s.nextLine());
						}
					}
					
					if (line.compareTo("Carta") == 0) {
						qntCartas = new int[numPlayers];
						for (int k = 0; k < numPlayers; k++) {
							qntCartas[k] = Integer.parseInt(s.nextLine());
							for(int j = 0; j<qntCartas[k]; j++){
								String nomeCarta = s.nextLine();
								int tipo = Integer.parseInt(s.nextLine());
								cartas.add(new Carta(nomeCarta, tipo));
							}
						}
					}

					if (line.compareTo("Bloco de Notas") == 0) {
						notas = new boolean[numPlayers][21];
						for (int k = 0; k < numPlayers; k++) {
							for(int j = 0; j<21;j++) {
								notas[k][j] = Boolean.parseBoolean(s.nextLine());
							}
						}
					}

					if (line.compareTo("saiu do Jogo") == 0) {
						saiuJogo = new boolean[numPlayers];
						for (int k = 0; k < numPlayers; k++) {
							saiuJogo[k] = Boolean.parseBoolean(s.nextLine());
						}
					}
					
					if (line.compareTo("Resposta") == 0) {
						resposta = new String[3];
						for (int k = 0; k < 3; k++) {
							resposta[k] = s.nextLine();
						}
					}
					
					if (line.compareTo("playerAtual") == 0) {
						pA = Integer.parseInt(s.nextLine());
					}

				}
			}	 finally {
				if (s != null) {
					s.close();
				}
			}
		
			carregaPlayers(numPlayers, cores, nomes, posicoes, saiuJogo);
			carregaPeoes(numPeoes,idPeoes, posicoesPeoes);

			dadosV[0]=1;
			dadosV[1]=1;

			playerIndex = pA-1;
			playerAtual = lstPlayer.get(playerIndex);
			
			for (int i = 0; i < numPlayers; i++) {
				int coordX = coordenadas[i][0];
				int coordY = coordenadas[i][1];
				lstPlayer.get(i).setCoordinates(coordX, coordY);
			}
			
			for(int i = 0; i < numPeoes; i++) {
				int coordX = coordenadasPeoes[i][0];
				int coordY = coordenadasPeoes[i][1];
				lstPeoes.get(i).setCoordinates(coordX, coordY);
			}

			for(int i = 0; i<numPlayers; i++) {
				for(int j = 0; j< qntCartas[i]; j++) {
					lstPlayer.get(i).daCarta(cartas.get(0));
					cartas.remove(0);
				}
				lstPlayer.get(i).setNotas(notas[i]);
			}					
			
			// end of load saved game
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Erro: arquivo não encontrado.");
			System.exit(0);
		}
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
