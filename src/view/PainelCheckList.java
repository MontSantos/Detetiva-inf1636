package view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

class PainelCheckList extends JPanel{
	public void paintComponent(Graphics g) {
		Graphics2D G2D = (Graphics2D) g;
		
		int x = getWidth() - getInsets().right - getInsets().left; ;
		int y = (getHeight() - getInsets().top - getInsets().bottom);
		int biasX = (x - 104)/3;
		int biasY = (y - 130)/9;
		int quadY = (y - 92)/9;
		//System.out.printf("a %d", y);
		
		G2D.setColor(Color.decode("#2f1e16"));
		G2D.fillRect(10, 10, x - 20, y - 20);
		G2D.setColor(Color.decode("#422900"));
		G2D.fillRect(20, 20, x - 40, y - 40);
		G2D.setColor(Color.decode("#573b16"));
		G2D.fillRect(30, 30, x - 60, y - 60);
		G2D.setColor(Color.BLACK);
		G2D.fillRect(40, 40, x - 80, y - 80);
		G2D.setColor(Color.decode("#e9c28b"));
		
		G2D.fillRect(46, 46, biasX, y - 92);
		G2D.fillRect(46 + biasX + 6, 46, biasX, y - 92);
		G2D.fillRect(46 + 2*(biasX + 6), 46, biasX, y - 92);
		
		this.setBackground(Color.decode("#f3cc95"));
	}
}