package view;

import java.awt.*;

import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.*;

import Controller.ObservadoIF;
import Controller.ObservadorIF;

class FrameBloco extends JFrame implements ObservadorIF{
	private PainelBloco panel = new PainelBloco();
	private Border a,b,c = null;
	private JCheckBox green, mustard, white, peacock, scarlet, plum, jantar, entrada, jogos,
	cozinha, biblioteca, estar, musica, escritorio, jardim, castical, revolver, faca, cano, corda, chave;
	
	public FrameBloco () {
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
		
		scarlet = new JCheckBox("Srta. Scarlet");
		sus.add(scarlet);
		scarlet.setFont(new Font("Serif", Font.BOLD, 15));
		scarlet.setForeground(Color.BLACK);
		
		mustard = new JCheckBox("Col. Mustarda");
		sus.add(mustard);
		mustard.setFont(new Font("Serif", Font.BOLD, 15));
		mustard.setForeground(Color.BLACK);
		
		white = new JCheckBox("Sra. White");
		sus.add(white);
		white.setFont(new Font("Serif", Font.BOLD, 15));
		white.setForeground(Color.BLACK);
		
		green = new JCheckBox("Rev. Green");
		sus.add(green);
		green.setFont(new Font("Serif", Font.BOLD, 15));
		green.setForeground(Color.BLACK);
		
		peacock = new JCheckBox("Sra. Peacock");
		sus.add(peacock);
		peacock.setFont(new Font("Serif", Font.BOLD, 15));
		peacock.setForeground(Color.BLACK);
		
		plum = new JCheckBox("Prof. Plum");
		sus.add(plum);
		plum.setFont(new Font("Serif", Font.BOLD, 15));
		plum.setForeground(Color.BLACK);
		
		//
		
		jantar = new JCheckBox("Sala de Jantar");
		cmd.add(jantar);
		jantar.setFont(new Font("Serif", Font.BOLD, 15));
		jantar.setForeground(Color.BLACK);

		entrada = new JCheckBox("Entrada");
		cmd.add(entrada);
		entrada.setFont(new Font("Serif", Font.BOLD, 15));
		entrada.setForeground(Color.BLACK);

		jogos = new JCheckBox("Salão de Jogos");
		cmd.add(jogos);
		jogos.setFont(new Font("Serif", Font.BOLD, 15));
		jogos.setForeground(Color.BLACK);
		
		cozinha = new JCheckBox("Cozinha");
		cmd.add(cozinha);
		cozinha.setFont(new Font("Serif", Font.BOLD, 15));
		cozinha.setForeground(Color.BLACK);
		
		biblioteca = new JCheckBox("Biblioteca");
		cmd.add(biblioteca);
		biblioteca.setFont(new Font("Serif", Font.BOLD, 15));
		biblioteca.setForeground(Color.BLACK);
		
		estar = new JCheckBox("Sala de Estar");
		cmd.add(estar);
		estar.setFont(new Font("Serif", Font.BOLD, 15));
		estar.setForeground(Color.BLACK);
		
		musica = new JCheckBox("Sala de Música");
		cmd.add(musica);
		musica.setFont(new Font("Serif", Font.BOLD, 15));
		musica.setForeground(Color.BLACK);
		
		escritorio = new JCheckBox("Escritório");
		cmd.add(escritorio);
		escritorio.setFont(new Font("Serif", Font.BOLD, 15));
		escritorio.setForeground(Color.BLACK);
		
		jardim = new JCheckBox("Jardim");
		cmd.add(jardim);
		jardim.setFont(new Font("Serif", Font.BOLD, 15));
		jardim.setForeground(Color.BLACK);
		
		//
		
		castical = new JCheckBox("Castical");
		armas.add(castical);
		castical.setFont(new Font("Serif", Font.BOLD, 15));
		castical.setForeground(Color.BLACK);
		
		revolver = new JCheckBox("Revólver");
		armas.add(revolver);
		revolver.setFont(new Font("Serif", Font.BOLD, 15));
		revolver.setForeground(Color.BLACK);
		
		faca = new JCheckBox("Faca");
		armas.add(faca);
		faca.setFont(new Font("Serif", Font.BOLD, 15));
		faca.setForeground(Color.BLACK);
		
		cano = new JCheckBox("Cano");
		armas.add(cano);
		cano.setFont(new Font("Serif", Font.BOLD, 15));
		cano.setForeground(Color.BLACK);
		
		corda = new JCheckBox("Corda");
		armas.add(corda);
		corda.setFont(new Font("Serif", Font.BOLD, 15));
		corda.setForeground(Color.BLACK);
		
		chave = new JCheckBox("Chave Inglesa");
		armas.add(chave);
		chave.setFont(new Font("Serif", Font.BOLD, 15));
		chave.setForeground(Color.BLACK);
		
		//
		setBackground(Color.decode("#f3cc95"));
		setVisible(true);
	}

	@Override
	public void notify(ObservadoIF o) {
		this.repaint();
	}
}
