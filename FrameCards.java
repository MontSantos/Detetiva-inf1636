package view;

import javax.swing.JFrame;
import javax.swing.JLabel;

import Controller.ObservadoIF;
import Controller.ObservadorIF;

import java.awt.*;

import model.CtrlRegras;

class FrameCards extends JFrame implements ObservadorIF{
	private PainelCards panel = new PainelCards();
	private static CtrlRegras control = CtrlRegras.getInstance();
	
	public FrameCards() {
		super("Cartas de " + control.getPlayerAtualNome());
		
		//cria janela
		int tamTelaX = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		int tamTelaY = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		//int tamB = (int) (((float)h/671) * 40);
		
		setLocation((tamTelaX - 340) / 2, (tamTelaY - 602) / 2);
		panel.setBounds(0, 0, 340, 602);
		panel.setLayout(null);
		setVisible(true);
		setSize(340, 602);
		setResizable(false);
        
        
		getContentPane().add(panel);
        setBackground(Color.decode("#f3cc95"));
        
        //System.out.println(getWidth() - getInsets().left -  getInsets().right);
        
        control.add(this);
	}

	@Override
	public void notify(ObservadoIF o) {
		this.repaint();
		
	}
}