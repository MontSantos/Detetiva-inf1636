package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import model.CtrlRegras;

class FrameVitoria extends JFrame implements ItemListener {
	private PainelVitoria panel = new PainelVitoria();
	private JLabel s1;
	private JButton fim, menu;
	//private static CtrlRegras control = CtrlRegras.getInstance();
	
	public FrameVitoria() {
		super("Vitória de ");
		
		int tamTelaX = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		int tamTelaY = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
		setLocation((tamTelaX - 500) / 2, (tamTelaY - 500) / 2);
		panel.setBounds(0, 0, 500, 500);
		panel.setLayout(null);
		setSize(500, 500);	
		setResizable(false);
		
		int w = getWidth() - getInsets().right - getInsets().left;
		int h = getHeight() - getInsets().top - getInsets().bottom;

		//
		
		fim = new JButton("Sair");
		fim.setBounds(w - 180, h - 120, 100, 40);
		fim.setFont(new Font("Serif", Font.BOLD, 20));
		fim.setForeground(Color.decode("#000000"));
		fim.setBackground(Color.RED);
		panel.add(fim);
		fim.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
        
		
		menu = new JButton("Novo Jogo");
		menu.setBounds(80, h - 120, 100, 40);
		menu.setFont(new Font("Serif", Font.BOLD, 12));
		menu.setForeground(Color.decode("#000000"));
		menu.setBackground(Color.decode("#4fa800"));
		panel.add(menu);
		menu.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				FrameSelecao s = new FrameSelecao();
				s.setVisible(true);
				setVisible(false);
			}
		});
		
		s1 = new JLabel("Sra. Scarlet venceu o jogo");
		s1.setBounds(80, h/2 - 150, 400, 50);
		s1.setFont(new Font("Arial", Font.BOLD, 25));
		panel.add(s1);
		
		setBackground(Color.decode("#f3cc95"));
		getContentPane().add(panel);
		setVisible(true);
		
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
	}

}
