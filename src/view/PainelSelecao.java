package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

class PainelSelecao extends JPanel{
	private Image[] jog = null;
	private BufferedImage logo = null;

	public void paintComponent(Graphics g) {
		Graphics2D G2D = (Graphics2D) g;
		
		int x = getWidth();
		int y = getHeight()/2;
		
		G2D.setColor(Color.decode("#2f1e16"));
		G2D.fillRect(10, y + 10, (x/4) - 20, y - 20);
		G2D.setColor(Color.decode("#422900"));
		G2D.fillRect(20, y + 20, (x/4) - 40, y - 40);
		G2D.setColor(Color.decode("#573b16"));
		G2D.fillRect(30, y + 30, (x/4) - 60, y - 60);
		G2D.setColor(Color.decode("#e9c28b"));
		G2D.fillRect(40, y + 40, (x/4) - 80, y - 80);
		
		if (jog == null) {
			jog = new Image[6];
			try {
				jog[0] = ImageIO.read(new File("images/Suspeitos/Scarlet.jpg"));
				jog[1] = ImageIO.read(new File("images/Suspeitos/Mustard.jpg"));
				jog[2] = ImageIO.read(new File("images/Suspeitos/White.jpg"));
				jog[3] = ImageIO.read(new File("images/Suspeitos/Green.jpg"));
				jog[4] = ImageIO.read(new File("images/Suspeitos/Peacock.jpg"));
				jog[5] = ImageIO.read(new File("images/Suspeitos/Plum.jpg"));
			} catch (IOException e) {
				System.err.println(e.getMessage());
				System.exit(-1);
			}
		}
		for (int i = 0; i < 6; i++) {
			G2D.drawImage(jog[i], (x/4)*i - (3*(x/4)*(i/4)), y*(i/4), (x/4), y, null);
		}
		
		if (logo == null)
			try {
				logo = ImageIO.read(new File("images/logoCLue.png"));
			} catch (IOException e) {
				System.err.println(e.getMessage());
				System.exit(-1);
			}
		G2D.drawImage(logo, 30, y + y/3 + 10, (x/4) - 50, y/4, null);
		//G2D.drawImage(logo, 0, 336, 250, 336, null);
		
	}
	
}