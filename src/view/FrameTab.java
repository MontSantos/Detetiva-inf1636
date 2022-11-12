package view;

import javax.swing.JButton;
import javax.swing.JLabel;

import Controller.ObservadoIF;
import Controller.ObservadorIF;

import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JComboBox;

import model.CtrlRegras;

class FrameTab extends JFrame implements ItemListener, MouseListener, ObservadorIF {
	private PainelTab panel = new PainelTab();
	private JButton pass, cartas, bloco, palpite, acusar, saveGame, dados, proximo, escolher;
	private JComboBox dado1, dado2;
	private JLabel s1, s2;
	private String[] val = new String[] { "1", "2", "3", "4", "5", "6"};
	private CtrlRegras control = CtrlRegras.getInstance();
	
	private int qntPlayers;
	
	public FrameTab() {
		super("Detetive");
		
		qntPlayers = control.getQntPlayers();
		
		//cria janela
		int tamTelaX = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		int tamTelaY = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setLocation((tamTelaX - 1000)/2, (tamTelaY - 700)/2);
        panel.setBounds(0, 0, 1000, 700);
        panel.setLayout(null);
        setSize(1000, 700);
        setResizable(false);
        setVisible(true);
        
		int w = getWidth() - getInsets().right - getInsets().left;
		int h = getHeight() - getInsets().top - getInsets().bottom;
		int tamB = (int) (((float)h/671) * 40);
		//System.out.println(getInsets().bottom);
		int i = 0;
        
        addMouseListener(this);
        
        //cria botões
        
        pass = new JButton("Passagem Secreta");
        pass.setBounds((h)  + 40, 40, (w - h) - 80, tamB);
		pass.setFont(new Font("Serif", Font.BOLD, 20));
		pass.setForeground(Color.decode("#000000"));
		pass.setBackground(Color.decode("#e9c28b"));
		panel.add(pass);
		i++;
        
		cartas = new JButton("Mostrar Cartas");
		cartas.setBounds(h + 40,(int) (40 + tamB*i), (w - h) - 80, tamB);
		cartas.setFont(new Font("Serif", Font.BOLD, 20));
		cartas.setForeground(Color.decode("#000000"));
		cartas.setBackground(Color.decode("#e9c28b"));
		panel.add(cartas);
		i++;
		
		cartas.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				FrameCards fc = new FrameCards();
				fc.setVisible(true);
			}
		});
		
		
		bloco = new JButton("Bloco de Notas");
		bloco.setBounds(h + 40, (int) (40 + tamB*i), (w - h) - 80, tamB);
		bloco.setFont(new Font("Serif", Font.BOLD, 20));
		bloco.setForeground(Color.decode("#000000"));
		bloco.setBackground(Color.decode("#e9c28b"));
		panel.add(bloco);
		i++;
		
		palpite = new JButton("Palpite");
		palpite.setBounds(h + 40, (int) (40 + tamB*i), (w - h) - 80, tamB);
        palpite.setFont(new Font("Serif", Font.BOLD, 20));
        palpite.setForeground(Color.decode("#000000"));
		palpite.setBackground(Color.decode("#e9c28b"));
        panel.add(palpite);
        i++;
        
        acusar = new JButton("Acusar");
        acusar.setBounds(h + 40, (int) (40 + tamB*i), (w - h) - 80, tamB);
		acusar.setFont(new Font("Serif", Font.BOLD, 20));
		acusar.setForeground(Color.decode("#000000"));
		acusar.setBackground(Color.decode("#e9c28b"));
		panel.add(acusar);
		i++;
		
		saveGame = new JButton("Salvar Jogo");
		saveGame.setBounds(h + 40, (int) (40 + tamB*i), (w - h) - 80, tamB);
		saveGame.setFont(new Font("Serif", Font.BOLD, 20));
		saveGame.setForeground(Color.decode("#000000"));
		saveGame.setBackground(Color.decode("#e9c28b"));
		panel.add(saveGame);
		i++;
		
		proximo = new JButton("Próximo");
		proximo.setBounds(h + 40, (int) (40 + tamB*i), (w - h) - 80, tamB);
		proximo.setFont(new Font("Serif", Font.BOLD, 20));
		proximo.setForeground(Color.decode("#000000"));
		proximo.setBackground(Color.decode("#e9c28b"));
		panel.add(proximo);
		i++;
		
		s1 = new JLabel("Jogador(a) da Vez:");
		s1.setBounds(720, 350, 200, tamB/2);
		s1.setFont(new Font("Arial", Font.BOLD, 15));
		panel.add(s1);
		
		s2 = new JLabel(control.getPlayerAtualNome());
		s2.setBounds(720, 370, 200, tamB/2);
		s2.setFont(new Font("Arial", Font.BOLD, 15));
		panel.add(s2);
		
		String[] val = {"1", "2", "3", "4", "5", "6"};
		
		dado1 = new JComboBox<String>(val);
		dado1.setBounds(h + 40, h - 120, 45, tamB/2);
		dado1.setFont(new Font("Arial", Font.PLAIN, 15));
		dado1.setForeground(Color.decode("#000000"));
		dado1.setBackground(Color.decode("#e9c28b"));
		panel.add(dado1);
		
		dado2 = new JComboBox<String>(val);
		dado2.setBounds(h + 40, h - 100, 45, tamB/2);
		dado2.setFont(new Font("Arial", Font.PLAIN, 15));
		dado2.setForeground(Color.decode("#000000"));
		dado2.setBackground(Color.decode("#e9c28b"));
		panel.add(dado2);
		
		escolher = new JButton("Escolher Dados");
		panel.add(escolher);
		escolher.setBounds(h + 85, h - 120, (w - h) - 125, tamB);
		escolher.setFont(new Font("Serif", Font.BOLD, 15));
		escolher.setForeground(Color.decode("#000000"));
		escolher.setBackground(Color.decode("#e9c28b"));
		escolher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				control.setValorDados(dado1.getSelectedIndex()+1, dado2.getSelectedIndex()+1);
			}
		});
		
		dados = new JButton("Rodar Dados");
		panel.add(dados);
		dados.setBounds(h + 40, h - 80, (w - h) - 80, tamB);
		dados.setFont(new Font("Serif", Font.BOLD, 20));
		dados.setForeground(Color.decode("#000000"));
		dados.setBackground(Color.decode("#e9c28b"));
		dados.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				control.jogaDados();
			}
		});
		
		setBackground(Color.decode("#f3cc95"));
		getContentPane().add(panel);
		
		control.add(this);
		
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		
		//System.out.printf("CordX: %d - CordY: %d\n", x, y);

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int x = e.getX() - getInsets().right - getInsets().left;
		int y = e.getY() - getInsets().top - getInsets().bottom;
		
		System.out.printf("CordX: %d - CordY: %d\n", x, y);
		

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void notify(ObservadoIF o) {
		this.repaint();
	}

}