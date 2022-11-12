package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Insets;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import model.CtrlRegras;

class PainelCards extends JPanel{
	private Image[] carta = null;
	
	public void paintComponent(Graphics g) {
		Graphics2D G2D = (Graphics2D) g;
		int x = getWidth();
		int y = getHeight();
		
		G2D.setColor(Color.decode("#2f1e16"));
		G2D.fillRect(10, 10, x - 20, y - 20);
		G2D.setColor(Color.decode("#422900"));
		G2D.fillRect(20, 20, x - 40, y - 40);
		G2D.setColor(Color.decode("#573b16"));
		G2D.fillRect(30, 30, x - 60, y - 60);
		G2D.setColor(Color.decode("#e9c28b"));
		G2D.fillRect(40, 40, x - 80, y - 80);
		
		CtrlRegras control = CtrlRegras.getInstance();
		
		ArrayList<String> cartasPlayer =  control.getNomeCardPlayer();
		ArrayList<Integer> tipoCarta = control.getTipoCardPlayer();
		
		if (carta == null) {
			carta = new Image[cartasPlayer.size()];
			try {
				for(int i = 0; i< cartasPlayer.size(); i++) {
					if(tipoCarta.get(i) == 0) {
						switch(cartasPlayer.get(i)){
						case "Srta. Scarlet":
							carta[i] = ImageIO.read(new File("images/Suspeitos/Scarlet.jpg"));
							break;
							
						case "Coronel Mustard":
							carta[i] = ImageIO.read(new File("images/Suspeitos/Mustard.jpg"));
							break;
							
						case "Sra. White":
							carta[i] = ImageIO.read(new File("images/Suspeitos/White.jpg"));
							break;
						
						case  "Reverendo Green":
							carta[i] = ImageIO.read(new File("images/Suspeitos/Green.jpg"));
							break;
							
						case  "Sra. Peacock":
							carta[i] = ImageIO.read(new File("images/Suspeitos/Peacock.jpg"));
							break;
						case "Professor Plum":
							carta[i] = ImageIO.read(new File("images/Suspeitos/Plum.jpg"));
							break;
							
						}
						
					}
					else if(tipoCarta.get(i)== 1) {
						switch(cartasPlayer.get(i)) {
						case "Corda":
							carta[i] = ImageIO.read(new File("images/Armas/Corda.jpg"));
							break;
							
						case "Cano":
							carta[i] = ImageIO.read(new File("images/Armas/Cano.jpg"));
							break;
							
						case "Faca":
							carta[i] = ImageIO.read(new File("images/Armas/Faca.jpg"));
							break;
						
						case  "Revolver":
							carta[i] = ImageIO.read(new File("images/Armas/Revolver.jpg"));
							break;
							
						case  "Chave Inglesa":
							carta[i] = ImageIO.read(new File("images/Armas/ChaveInglesa.jpg"));
							break;
						case "Castical":
							carta[i] = ImageIO.read(new File("images/Armas/Castical.jpg"));
							break;
						
						}
						
					}
					else {
						switch(cartasPlayer.get(i)) {
						case "Biblioteca":
							carta[i] = ImageIO.read(new File("images/Comodos/Biblioteca.jpg"));
							break;
							
						case "Cozinha":
							carta[i] = ImageIO.read(new File("images/Comodos/Cozinha.jpg"));
							break;
							
						case "Entrada":
							carta[i] = ImageIO.read(new File("images/Comodos/Entrada.jpg"));
							break;
						
						case  "Escritorio":
							carta[i] = ImageIO.read(new File("images/Comodos/Escritorio.jpg"));
							break;
							
						case  "Jardim de Inverno":
							carta[i] = ImageIO.read(new File("images/Comodos/JardimInverno.jpg"));
							break;
						case "Sala de Estar":
							carta[i] = ImageIO.read(new File("images/Comodos/SalaDeEstar.jpg"));
							break;
						case "Sala de Jantar":
							carta[i] = ImageIO.read(new File("images/Comodos/SalaDeJantar.jpg"));
							break;
						case "Sala de Musica":
							carta[i] = ImageIO.read(new File("images/Comodos/SalaDeMusica.jpg"));
							break;
						case "Salao de Jogos":
							carta[i] = ImageIO.read(new File("images/Comodos/SalaoDeJogos.jpg"));
							break;
						
						}
						
					}
				}
				
			} catch (IOException e) {
				System.err.println(e.getMessage());
				System.exit(-1);
			}
		}
		
		for (int i = 0; i < 3; i++) {
			// G2D.drawImage(carta[i], 150, 25 + (50*i*4), 100, 159, null);
			G2D.drawImage(carta[i], 150, 25 + (184 * i), 100, 159, null);
			
		}
	
	}
}
