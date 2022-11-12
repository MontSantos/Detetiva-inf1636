package view;

import javax.swing.JButton;

import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;


class FrameMenu extends JFrame implements ItemListener {
	private PainelMenu panel = new PainelMenu();
	private JButton newGame, continuar;
	
	public FrameMenu() {
		
		//cria janela
		super("Detetive - O Jogo");
		int tamTelaX = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		int tamTelaY = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setLocation((tamTelaX - 1000)/2, (tamTelaY - 700)/2);
        panel.setBounds(0, 0, 1000, 700);
        panel.setLayout(null);
        setSize(1000, 700);
        setResizable(false);
        getContentPane().add(panel);
        
        //
        newGame = new JButton("Novo Jogo");
		panel.add(newGame);
		newGame.setBounds(500, 605, 100, 50);
		newGame.setFont(new Font("Serif", Font.BOLD, 12));
		newGame.setForeground(Color.BLACK);
		newGame.setBackground(Color.decode("#efe196"));
		
		newGame.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				FrameSelecao s = new FrameSelecao();
				s.setVisible(true);
				setVisible(false);
			}
		});
		
		
		continuar = new JButton("Continuar");
		panel.add(continuar);
		continuar.setBounds(640, 605, 100, 50);
		continuar.setFont(new Font("Serif", Font.BOLD, 12));
		continuar.setForeground(Color.BLACK);
		continuar.setBackground(Color.decode("#efe196"));
		
		
        setVisible(true);
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		
	}

}