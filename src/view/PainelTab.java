package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import model.CtrlRegras;


class PainelTab extends JPanel{
	private Image tabClue =  null;
	private Image[] dados =  null;
	private Image[] jog = null;
	
	private int numPlayers = CtrlRegras.getInstance().getQntPlayers();
	CtrlRegras control = CtrlRegras.getInstance();
	
	private int[][] coords = control.getListaCoord();
	private String[] nomes = control.getListaNomes();
	
	private int pinHeight = 20;
	private int pinWidth = 20;
	private int pinWidthAtual = 20;
	private int pinHeightAtual = 20;
	
	public void paintComponent(Graphics g) {
		Graphics2D G2D = (Graphics2D) g;
		
		CtrlRegras control = CtrlRegras.getInstance();
		int w = getWidth();
		int h = getHeight();
		int tabX = (int) ((float) 600*(h/625));
		int cartaX = (int)(((float) h / 671) * 66);
		int cartaY = (int)(((float) h / 671) * 100);
		
		G2D.setColor(Color.decode("#2f1e16"));
		G2D.fillRect(tabX + 10, 10, (w - 20) -tabX, h - 20);
		G2D.setColor(Color.decode("#422900"));
		G2D.fillRect(tabX + 20, 20, w - 40 - tabX, h - 40);
		G2D.setColor(Color.decode("#573b16"));
		G2D.fillRect(tabX + 30, 30, w - 60 - tabX, h - 60);
		G2D.setColor(Color.decode("#e9c28b"));
		G2D.fillRect(tabX + 40, 40, w - 80 - tabX, h - 80);
		//System.out.println(h);
		
		
		// tabuleiro
		
		if (tabClue == null) {
			try {
				tabClue = ImageIO.read(new File("images/Tabuleiros/Tabuleiro-Clue-C.jpg"));
			} catch (IOException e) {
				System.err.println(e.getMessage());
				System.exit(-1);
			}
		}
		
		
		G2D.drawImage(tabClue, 0, 0, tabX, h, null);
		
		//dados
		if (dados == null) {
			dados = new Image[6];
			try {
				for (int i = 0; i < 6; i++)
					dados[i] = ImageIO.read(new File(String.format("images/Tabuleiros/dado%d.jpg", i+1)));
			} catch (IOException e) {
				System.err.println(e.getMessage());
				System.exit(-1);
			}
		}
		
		int dadoX = (int)(((float) h / 671) * 95);
		int dadoY = (int)(((float) h / 671) * 106);
		float biasX = tabX + ((w - tabX)/2);
		//float biasX = h + ((w - h)/2) - ((h / 672) * 95);
		//System.out.println(h);
		
		G2D.drawImage(dados[control.getValorDados()[0] - 1], (int) (biasX - dadoX), h/2 + cartaY +5, dadoX, dadoY, null);
		G2D.drawImage(dados[control.getValorDados()[1] - 1], (int) (biasX), h/2 + cartaY +5, dadoX, dadoY, null);
		
		//jogador		
		if (jog == null) {
			jog = new Image[6];
			try {
				for (int i = 0; i < numPlayers; i++) {
					switch (nomes[i]){
						case "Srta. Scarlet":{
							jog[i] = ImageIO.read(new File("images/Suspeitos/Scarlet.jpg"));
							break;
						}
						case "Coronel Mustard":{
							jog[i] = ImageIO.read(new File("images/Suspeitos/Mustard.jpg"));
							break;
						}
						case "Sra. White": {
							jog[i] = ImageIO.read(new File("images/Suspeitos/White.jpg"));
							break;
						}
						case "Reverendo Green":{
							jog[i] = ImageIO.read(new File("images/Suspeitos/Green.jpg"));
							break;
						}
						case "Sra. Peacock":{
							jog[i] = ImageIO.read(new File("images/Suspeitos/Peacock.jpg"));
							break;
						}
						case "Professor Plum":{
							jog[i] = ImageIO.read(new File("images/Suspeitos/Plum.jpg"));
							break;
						}
					}
				}
			} catch (IOException e) {
				System.err.print(e.getMessage());
				System.exit(1);
			}

		}

		G2D.drawImage(jog[control.getPLayerAtualId() - 1], (int) (biasX + (dadoX - cartaX)) , h/2, cartaX, cartaY, null);

		//peÃµes
		
		for (int j = 0; j < numPlayers; j++) {
			int x = coords[j][0];
			int y = coords[j][1];
			if (control.getPlayerAtual() == control.getPlayer(j)) {
				switch (nomes[j]){
				case "Srta. Scarlet":{
					G2D.setColor(Color.decode("#991017"));
					G2D.fillOval(x,y,pinWidthAtual,pinHeightAtual);
					break;
				}
				case "Coronel Mustard":{
					G2D.setColor(Color.YELLOW);
					G2D.fillOval(x,y,pinWidthAtual,pinHeightAtual);
					break;
				}
				case "Sra. White": {
					G2D.setColor(Color.decode("#7780a1"));
					G2D.fillOval(x,y,pinWidthAtual,pinHeightAtual);
					break;
				}
				case "Reverendo Green":{
					G2D.setColor(Color.decode("#045c4c"));
					G2D.fillOval(x,y,pinWidthAtual,pinHeightAtual);
					break;
				}
				case "Sra. Peacock":{
					G2D.setColor(Color.decode("#183980"));
					G2D.fillOval(x,y,pinWidthAtual,pinHeightAtual);
					break;
				}
				case "Professor Plum":{
					G2D.setColor(Color.decode("#4b293a"));
					G2D.fillOval(x,y,pinWidthAtual,pinHeightAtual);
					break;
				}
			}
				
			} else {
				switch (nomes[j]){
				case "Srta. Scarlet":{
					G2D.setColor(Color.decode("#991017"));
					G2D.fillOval(x,y,pinWidth,pinHeight);
					break;
				}
				case "Coronel Mustard":{
					G2D.setColor(Color.YELLOW);
					G2D.fillOval(x,y,pinWidth,pinHeight);
					break;
				}
				case "Sra. White": {
					G2D.setColor(Color.decode("#7780a1"));
					G2D.fillOval(x,y,pinWidth,pinHeight);
					break;
				}
				case "Reverendo Green":{
					G2D.setColor(Color.decode("#045c4c"));
					G2D.fillOval(x,y,pinWidth,pinHeight);
					break;
				}
				case "Sra. Peacock":{
					G2D.setColor(Color.decode("#183980"));
					G2D.fillOval(x,y,pinWidth,pinHeight);
					break;
				}
				case "Professor Plum":{
					G2D.setColor(Color.decode("#4b293a"));
					G2D.fillOval(x,y,pinWidth,pinHeight);
					break;
				}
			}
			}
		}
	}
}