package view;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import model.CtrlRegras;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;


class PainelVitoria extends JPanel {
	private Image carta = null;
	
	public void paintComponent(Graphics g) {
		Graphics2D G2D = (Graphics2D) g;
		
		CtrlRegras control = CtrlRegras.getInstance();
		String nome = control.getPlayerAtualNome();
		
		int x = getWidth() - getInsets().right - getInsets().left; ;
		int y = (getHeight() - getInsets().top - getInsets().bottom);
		
		G2D.setColor(Color.decode("#2f1e16"));
		G2D.fillRect(10, 10, x - 20, y - 20);
		G2D.setColor(Color.decode("#422900"));
		G2D.fillRect(20, 20, x - 40, y - 40);
		G2D.setColor(Color.decode("#573b16"));
		G2D.fillRect(30, 30, x - 60, y - 60);
		G2D.setColor(Color.decode("#e9c28b"));
		G2D.fillRect(40, 40, x - 80, y - 80);
		
		if (carta == null) {
			try {
				
				switch (nome){
					case "Srta. Scarlet":{
						carta = ImageIO.read(new File("images/Suspeitos/Scarlet.jpg"));
						break;
					}
					case "Col. Mustard":{
						carta = ImageIO.read(new File("images/Suspeitos/Mustard.jpg"));
						break;
					}
					case "Sra. White": {
						carta = ImageIO.read(new File("images/Suspeitos/White.jpg"));
						break;
					}
					case "Rev. Green":{
						carta = ImageIO.read(new File("images/Suspeitos/Green.jpg"));
						break;
					}
					case "Sra. Peacock":{
						carta = ImageIO.read(new File("images/Suspeitos/Peacock.jpg"));
						break;
					}
					case "Prof. Plum":{
						carta = ImageIO.read(new File("images/Suspeitos/Plum.jpg"));
						break;
					}
				}
			} catch (IOException e) {
				System.err.print(e.getMessage());
				System.exit(1);
			}

		}
		
		G2D.drawImage(carta, x/2 - 33, y/2, 66, 100, null);
	}
	
}
