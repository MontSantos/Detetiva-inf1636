package view;

import java.awt.*;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.*;

import Controller.ObservadoIF;
import Controller.ObservadorIF;

class FramePalpite extends JFrame implements ObservadorIF{
	private ButtonGroup g1, g2, g3;
	private PainelBloco panel = new PainelBloco();
	private Border a,b,c = null;
	private JRadioButton green, mustard, white, peacock, scarlet, plum, jantar, entrada, jogos,
	cozinha, biblioteca, estar, musica, escritorio, jardim, castical, revolver, faca, cano, corda, chave;
	
	public FramePalpite () {
		super("Bloco de notas de X");
		
		JPanel armas = new JPanel();
		JPanel sus = new JPanel();
		JPanel cmd  = new JPanel();
		
		//cria janela
		int tamTelaX = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		int tamTelaY = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
		setLocation((tamTelaX - 630) / 2, (tamTelaY - 630) / 2);
		panel.setBounds(0, 0, 630, 630);
		panel.setLayout(null);
		setSize(630, 630);	
		setResizable(false);
		getContentPane().add(panel);
		
		//
		sus.setBounds(50, 50, 143, 500);
		a = BorderFactory.createMatteBorder(0, 0, 0 ,0, Color.decode("#e9c28b"));
		sus.setBorder(BorderFactory.createTitledBorder(a,"Suspeitos"));
		panel.add(sus);
		
		cmd.setBounds(243, 50, 143, 500);
		b = BorderFactory.createMatteBorder(0, 0, 0 ,0, Color.decode("#e9c28b"));
		cmd.setBorder(BorderFactory.createTitledBorder(b,"Comodos"));
		panel.add(cmd);
		
		armas.setBounds(436, 50, 143, 500);
		c = BorderFactory.createMatteBorder(0, 0, 0 ,0, Color.decode("#e9c28b"));
		armas.setBorder(BorderFactory.createTitledBorder(c,"Armas"));
		panel.add(armas);
		
		//
		
		g1 = new ButtonGroup();
		
		scarlet = new JRadioButton("Srta. Scarlet");
		sus.add(scarlet);
		scarlet.setFont(new Font("Serif", Font.BOLD, 15));
		scarlet.setForeground(Color.BLACK);
		g1.add(scarlet);
		
		mustard = new JRadioButton("Col. Mustarda");
		sus.add(mustard);
		mustard.setFont(new Font("Serif", Font.BOLD, 15));
		mustard.setForeground(Color.BLACK);
		g1.add(mustard);
		
		white = new JRadioButton("Sra. White");
		sus.add(white);
		white.setFont(new Font("Serif", Font.BOLD, 15));
		white.setForeground(Color.BLACK);
		g1.add(white);
		
		green = new JRadioButton("Rev. Green");
		sus.add(green);
		green.setFont(new Font("Serif", Font.BOLD, 15));
		green.setForeground(Color.BLACK);
		g1.add(green);
		
		peacock = new JRadioButton("Sra. Peacock");
		sus.add(peacock);
		peacock.setFont(new Font("Serif", Font.BOLD, 15));
		peacock.setForeground(Color.BLACK);
		g1.add(peacock);
		
		plum = new JRadioButton("Prof. Plum");
		sus.add(plum);
		plum.setFont(new Font("Serif", Font.BOLD, 15));
		plum.setForeground(Color.BLACK);
		g1.add(plum);
		
		//
		
		g2 = new ButtonGroup();
		
		jantar = new JRadioButton("Sala de Jantar");
		cmd.add(jantar);
		jantar.setFont(new Font("Serif", Font.BOLD, 15));
		jantar.setForeground(Color.BLACK);
		g2.add(jantar);

		entrada = new JRadioButton("Entrada");
		cmd.add(entrada);
		entrada.setFont(new Font("Serif", Font.BOLD, 15));
		entrada.setForeground(Color.BLACK);
		g2.add(entrada);

		jogos = new JRadioButton("Salão de Jogos");
		cmd.add(jogos);
		jogos.setFont(new Font("Serif", Font.BOLD, 15));
		jogos.setForeground(Color.BLACK);
		g2.add(jogos);
		
		cozinha = new JRadioButton("Cozinha");
		cmd.add(cozinha);
		cozinha.setFont(new Font("Serif", Font.BOLD, 15));
		cozinha.setForeground(Color.BLACK);
		g2.add(cozinha);
		
		biblioteca = new JRadioButton("Biblioteca");
		cmd.add(biblioteca);
		biblioteca.setFont(new Font("Serif", Font.BOLD, 15));
		biblioteca.setForeground(Color.BLACK);
		g2.add(biblioteca);
		
		estar = new JRadioButton("Sala de Estar");
		cmd.add(estar);
		estar.setFont(new Font("Serif", Font.BOLD, 15));
		estar.setForeground(Color.BLACK);
		g2.add(estar);
		
		musica = new JRadioButton("Sala de Música");
		cmd.add(musica);
		musica.setFont(new Font("Serif", Font.BOLD, 15));
		musica.setForeground(Color.BLACK);
		g2.add(musica);
		
		escritorio = new JRadioButton("Escritório");
		cmd.add(escritorio);
		escritorio.setFont(new Font("Serif", Font.BOLD, 15));
		escritorio.setForeground(Color.BLACK);
		g2.add(escritorio);
		
		jardim = new JRadioButton("Jardim");
		cmd.add(jardim);
		jardim.setFont(new Font("Serif", Font.BOLD, 15));
		jardim.setForeground(Color.BLACK);
		g2.add(jardim);
		
		//
		
		g3 = new ButtonGroup();
		
		castical = new JRadioButton("Castical");
		armas.add(castical);
		castical.setFont(new Font("Serif", Font.BOLD, 15));
		castical.setForeground(Color.BLACK);
		g3.add(castical);
		
		revolver = new JRadioButton("Revólver");
		armas.add(revolver);
		revolver.setFont(new Font("Serif", Font.BOLD, 15));
		revolver.setForeground(Color.BLACK);
		g3.add(revolver);
		
		faca = new JRadioButton("Faca");
		armas.add(faca);
		faca.setFont(new Font("Serif", Font.BOLD, 15));
		faca.setForeground(Color.BLACK);
		g3.add(faca);
		
		cano = new JRadioButton("Cano");
		armas.add(cano);
		cano.setFont(new Font("Serif", Font.BOLD, 15));
		cano.setForeground(Color.BLACK);
		g3.add(cano);
		
		corda = new JRadioButton("Corda");
		armas.add(corda);
		corda.setFont(new Font("Serif", Font.BOLD, 15));
		corda.setForeground(Color.BLACK);
		g3.add(corda);
		
		chave = new JRadioButton("Chave Inglesa");
		armas.add(chave);
		chave.setFont(new Font("Serif", Font.BOLD, 15));
		chave.setForeground(Color.BLACK);
		g3.add(chave);
		
		//
		
		setBackground(Color.decode("#f3cc95"));
		setVisible(true);
	}

	@Override
	public void notify(ObservadoIF o) {
		this.repaint();
	}
}
