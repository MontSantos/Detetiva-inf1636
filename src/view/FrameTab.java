package view;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

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
	
	int x;
	int y;
	int xCasa;
	int yCasa ;
	
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
		int tabX = (int) ((float) 600*(h/625));
		//System.out.println(getInsets().bottom);
		int i = 0;
        
        addMouseListener(this);
        
        //cria botões
        
        pass = new JButton("Passagem Secreta");
        pass.setBounds((tabX)  + 40, 40, (w - tabX) - 80, tamB);
		pass.setFont(new Font("Serif", Font.BOLD, 20));
		pass.setForeground(Color.decode("#000000"));
		pass.setBackground(Color.decode("#e9c28b"));
		panel.add(pass);
		i++;
        
		cartas = new JButton("Mostrar Cartas");
		cartas.setBounds(tabX + 40,(int) (40 + tamB*i), (w - tabX) - 80, tamB);
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
		bloco.setBounds(tabX + 40, (int) (40 + tamB*i), (w - tabX) - 80, tamB);
		bloco.setFont(new Font("Serif", Font.BOLD, 20));
		bloco.setForeground(Color.decode("#000000"));
		bloco.setBackground(Color.decode("#e9c28b"));
		panel.add(bloco);
		i++;
		
		bloco.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				FrameBloco fb = new FrameBloco();
				fb.setVisible(true);
			}
		});
		
		palpite = new JButton("Palpite");
		palpite.setBounds(tabX + 40, (int) (40 + tamB*i), (w - tabX) - 80, tamB);
        palpite.setFont(new Font("Serif", Font.BOLD, 20));
        palpite.setForeground(Color.decode("#000000"));
		palpite.setBackground(Color.decode("#e9c28b"));
        panel.add(palpite);
        i++;
        
        palpite.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				FramePalpite fp = new FramePalpite();
				fp.setVisible(true);
			}
		});
        
        acusar = new JButton("Acusar");
        acusar.setBounds(tabX + 40, (int) (40 + tamB*i), (w - tabX) - 80, tamB);
		acusar.setFont(new Font("Serif", Font.BOLD, 20));
		acusar.setForeground(Color.decode("#000000"));
		acusar.setBackground(Color.decode("#e9c28b"));
		panel.add(acusar);
		i++;
		
		acusar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				FrameAcusacao fa = new FrameAcusacao();
				fa.setVisible(true);
			}
		});
		
		saveGame = new JButton("Salvar Jogo");
		saveGame.setBounds(tabX + 40, (int) (40 + tamB*i), (w - tabX) - 80, tamB);
		saveGame.setFont(new Font("Serif", Font.BOLD, 20));
		saveGame.setForeground(Color.decode("#000000"));
		saveGame.setBackground(Color.decode("#e9c28b"));
		panel.add(saveGame);
		i++;
		
		proximo = new JButton("Próximo");
		proximo.setBounds(tabX + 40, (int) (40 + tamB*i), (w - tabX) - 80, tamB);
		proximo.setFont(new Font("Serif", Font.BOLD, 20));
		proximo.setForeground(Color.decode("#000000"));
		proximo.setBackground(Color.decode("#e9c28b"));
		panel.add(proximo);
		i++;
		proximo.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				control.jogo(); 
			}
		});
		
		s1 = new JLabel("Jogador(a) da Vez:");
		s1.setBounds(tabX + 70, h/2, 200, tamB/2);
		s1.setFont(new Font("Arial", Font.BOLD, 15));
		panel.add(s1);
		
		s2 = new JLabel(control.getPlayerAtualNome());
		s2.setBounds(tabX + (70), h/2+tamB/2 , 200, tamB/2);
		s2.setFont(new Font("Arial", Font.BOLD, 15));
		panel.add(s2);
		
		String[] val = {"1", "2", "3", "4", "5", "6"};
		
		dado1 = new JComboBox<String>(val);
		dado1.setBounds(tabX + 40, h - 120, 45, tamB/2);
		dado1.setFont(new Font("Arial", Font.PLAIN, 15));
		dado1.setForeground(Color.decode("#000000"));
		dado1.setBackground(Color.decode("#e9c28b"));
		panel.add(dado1);
		
		dado2 = new JComboBox<String>(val);
		dado2.setBounds(tabX + 40, h - 100, 45, tamB/2);
		dado2.setFont(new Font("Arial", Font.PLAIN, 15));
		dado2.setForeground(Color.decode("#000000"));
		dado2.setBackground(Color.decode("#e9c28b"));
		panel.add(dado2);
		
		escolher = new JButton("Escolher Dados");
		panel.add(escolher);
		escolher.setBounds(tabX + 85, h - 120, (w - tabX) - 125, tamB);
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
		dados.setBounds(tabX + 40, h - 80, (w - tabX) - 80, tamB);
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
	
	public void mudaBotao(JButton Button) {
        Button.setEnabled(!Button.isEnabled());
    }

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub


	}

	@Override
	public void mouseClicked(MouseEvent e) {
		this.x = e.getX() - getInsets().right - getInsets().left - 4;
		this.y = e.getY() - getInsets().top - getInsets().bottom - 4 ;
		this.xCasa = (int) (x/24);
		this.yCasa = (int) (y/(25.5));
		int[] pos = {xCasa, yCasa};
		int[] coord = {x, y};
		
		if(x > 0 && x < 578 && y > 0 && y < 637 ) {
			if (control.jogouDados() == false) {
				JOptionPane.showMessageDialog(null, "É necessário jogar os dados");
			}
			else {
				control.movimenta(pos, coord);
			}
		}

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
		this.s2.setText(control.getPlayerAtualNome());
		this.repaint();
	}

}