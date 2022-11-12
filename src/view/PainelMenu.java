package view;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

class PainelMenu extends JPanel{
	private Image menuImg = null;
	
	public void paintComponent(Graphics g) {
		Graphics2D G2D = (Graphics2D) g;
		
		if (menuImg == null) {
			try {
				menuImg = ImageIO.read(new File("images/clueMenu.jpg"));
			} catch (IOException e) {
				System.err.println(e.getMessage());
				System.exit(-1);
			}
		}
		
		G2D.drawImage(menuImg, 0, 0, 1000, getHeight(), null);
	}
}
