package view;

import javax.swing.JFrame;
import javax.swing.JLabel;

import Controller.ObservadoIF;
import Controller.ObservadorIF;

import java.awt.*;

import model.CtrlRegras;

class FrameCards extends JFrame implements ObservadorIF{
	private PainelCards panel = new PainelCards();
	private JLabel carta1, carta2, carta3;
	
	public FrameCards() {
		super("Cartas de X");
		
		CtrlRegras control = CtrlRegras.getInstance();
		
		//cria janela
		int tamTelaX = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		int tamTelaY = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		//int tamB = (int) (((float)h/671) * 40);
		
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setLocation((tamTelaX - 400) / 2, (tamTelaY - 602) / 2);
		panel.setBounds(0, 0, 400, 602);
		panel.setLayout(null);
		getContentPane().add(panel);
		setSize(400, 602);
		setResizable(false);

		carta1 = new JLabel("Suspeito(s):");
		carta1.setBounds(25, 120, 200, 20);
		carta1.setFont(new Font("Arial", Font.BOLD, 15));
		panel.add(carta1);

		carta2 = new JLabel("Comodo(s):");
		carta2.setBounds(25, 304, 200, 20);
		carta2.setFont(new Font("Arial", Font.BOLD, 15));
		panel.add(carta2);

		carta3 = new JLabel("Arma(s):");
		carta3.setBounds(25, 488, 200, 20);
		carta3.setFont(new Font("Arial", Font.BOLD, 15));
		panel.add(carta3);
        
        
		getContentPane().add(panel);
        setBackground(Color.decode("#efe196"));
        setVisible(true);
        
        control.add(this);
	}

	@Override
	public void notify(ObservadoIF o) {
		this.repaint();
		
	}
}
