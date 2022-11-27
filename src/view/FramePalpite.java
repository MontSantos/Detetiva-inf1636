package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.util.Enumeration;
import javax.swing.AbstractButton;

import Controller.ObservadoIF;
import Controller.ObservadorIF;
import model.CtrlRegras;

class FramePalpite extends JFrame implements ItemListener, ObservadorIF, ActionListener{
	protected PainelPalpite panel = new PainelPalpite();
	//private Border a,b,c = null;
	private String[] palpite = new String[3];
	private JLabel sus, cmd, armas;
	private JButton ok,cancelar;
	private JRadioButton green, mustard, white, peacock, scarlet, plum, jantar, entrada, jogos,
	cozinha, biblioteca, estar, musica, escritorio, jardim, castical, revolver, faca, cano, corda, chave;
	private static CtrlRegras control = CtrlRegras.getInstance();
	
	public FramePalpite () {
		super("Palpite de " + control.getPlayerAtualNome());
		ButtonGroup grupoS = new ButtonGroup();
		ButtonGroup grupoA = new ButtonGroup();
		
		
		//cria janela
		int tamTelaX = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		int tamTelaY = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
        
		setLocation((tamTelaX - 630) / 2, (tamTelaY - 630) / 2);
		panel.setBounds(0, 0, 630, 630);
		panel.setLayout(null);
		setSize(630, 630);	
		setResizable(false);
		
		
		int w = getWidth() - getInsets().right - getInsets().left;
		int h = getHeight() - getInsets().top - getInsets().bottom;
		
		int botaoX = (w - 104)/3;
		int botaoY = (h - 130)/9;
		
		
		sus = new JLabel("Suspeito(s):");
		sus.setBounds(52, 44, h/3, 20);
		sus.setFont(new Font("Arial", Font.BOLD, 15));
		panel.add(sus);
		
		scarlet = new JRadioButton("Srta. Scarlet");
		panel.add(scarlet);
		scarlet.setBounds(46, 65, botaoX - 6, botaoY);
		scarlet.setFont(new Font("Serif", Font.BOLD, 15));
		scarlet.setForeground(Color.BLACK);
		scarlet.setBackground(Color.decode("#e9c28b"));
		grupoS.add(scarlet);
		
		mustard = new JRadioButton("Col. Mustarda");
		panel.add(mustard);
		mustard.setBounds(46, 65 + botaoY, botaoX - 6, botaoY);
		mustard.setFont(new Font("Serif", Font.BOLD, 15));
		mustard.setForeground(Color.BLACK);
		mustard.setBackground(Color.decode("#e9c28b"));
		grupoS.add(mustard);
		
		white = new JRadioButton("Sra. White");
		panel.add(white);
		white.setBounds(46, 65 + 2*botaoY, botaoX - 6, botaoY);
		white.setFont(new Font("Serif", Font.BOLD, 15));
		white.setForeground(Color.BLACK);
		white.setBackground(Color.decode("#e9c28b"));
		grupoS.add(white);
		
		green = new JRadioButton("Rev. Green");
		panel.add(green);
		green.setBounds(46, 65 + 3*botaoY, botaoX - 6, botaoY);               
		green.setFont(new Font("Serif", Font.BOLD, 15));                                
		green.setForeground(Color.BLACK);                                               
		green.setBackground(Color.decode("#e9c28b")); 
		grupoS.add(green);
		
		peacock = new JRadioButton("Sra. Peacock");
		panel.add(peacock);
		peacock.setBounds(46, 65 + 4*botaoY, botaoX - 6, botaoY);     
		peacock.setFont(new Font("Serif", Font.BOLD, 15));                      
		peacock.setForeground(Color.BLACK);                                     
		peacock.setBackground(Color.decode("#e9c28b"));  
		grupoS.add(peacock);
		
		plum = new JRadioButton("Prof. Plum");
		panel.add(plum);
		plum.setBounds(46, 65 + 5*botaoY, botaoX - 6, botaoY);     
		plum.setFont(new Font("Serif", Font.BOLD, 15));                      
		plum.setForeground(Color.BLACK);                                     
		plum.setBackground(Color.decode("#e9c28b"));     
		grupoS.add(plum);
		
		//

		cmd = new JLabel("Arma(s):");
		cmd.setBounds(64 + 2*botaoX, 44, h/3, 20);
		cmd.setFont(new Font("Arial", Font.BOLD, 15));
		panel.add(cmd);
		
		castical = new JRadioButton("Castical");
		panel.add(castical);
		castical.setBounds(46 + 2*botaoX + 12, 65, botaoX - 18, botaoY);   
		castical.setFont(new Font("Serif", Font.BOLD, 15));                        
		castical.setForeground(Color.BLACK);                                       
		castical.setBackground(Color.decode("#e9c28b")); 
		grupoA.add(castical);
		
		revolver = new JRadioButton("Revólver");
		panel.add(revolver);
		revolver.setBounds(46 + 2*botaoX + 12, 65 + botaoY, botaoX - 18, botaoY);   
		revolver.setFont(new Font("Serif", Font.BOLD, 15));                        
		revolver.setForeground(Color.BLACK);                                       
		revolver.setBackground(Color.decode("#e9c28b")); 
		grupoA.add(revolver);
		
		faca = new JRadioButton("Faca");
		panel.add(faca);
		faca.setBounds(46 + 2*botaoX + 12, 65 + 2*botaoY, botaoX - 18, botaoY);   
		faca.setFont(new Font("Serif", Font.BOLD, 15));                        
		faca.setForeground(Color.BLACK);                                       
		faca.setBackground(Color.decode("#e9c28b"));   
		grupoA.add(faca);
		     
		cano = new JRadioButton("Cano");
		panel.add(cano);
		cano.setBounds(46 + 2*botaoX + 12, 65 + 3*botaoY, botaoX - 18, botaoY);   
		cano.setFont(new Font("Serif", Font.BOLD, 15));                        
		cano.setForeground(Color.BLACK);                                       
		cano.setBackground(Color.decode("#e9c28b"));   
		grupoA.add(cano);
		
		corda = new JRadioButton("Corda");
		panel.add(corda);
		corda.setBounds(46 + 2*botaoX +12, 65 + 4*botaoY, botaoX - 18, botaoY);   
		corda.setFont(new Font("Serif", Font.BOLD, 15));                        
		corda.setForeground(Color.BLACK);                                       
		corda.setBackground(Color.decode("#e9c28b"));  
		grupoA.add(corda);
		      
		chave = new JRadioButton("Chave Inglesa");
		panel.add(chave);
		chave.setBounds(46 + 2*botaoX + 12, 65 + 5*botaoY, botaoX - 18, botaoY);   
		chave.setFont(new Font("Serif", Font.BOLD, 15));                        
		chave.setForeground(Color.BLACK);                                       
		chave.setBackground(Color.decode("#e9c28b"));   
		grupoA.add(chave);
		//
		
		cancelar = new JButton("Cancelar");
		panel.add(cancelar);
		cancelar.setBounds(46, 65 + 6 * botaoY,  botaoX - 5, ((h - 140) - 6*botaoY) - 7);
		cancelar.setFont(new Font("Serif", Font.BOLD, 20));
		cancelar.setForeground(Color.BLACK);
		cancelar.setBackground(Color.RED);
		cancelar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		ok = new JButton("Confirmar");
		panel.add(ok);
		ok.setBounds(46 + 2*(botaoX) + 2, 65 + 6 * botaoY,  botaoX - 4, ((h - 140) - 6*botaoY) - 7);
		ok.setFont(new Font("Serif", Font.BOLD, 20));
		ok.setForeground(Color.BLACK);
		ok.setBackground(Color.GREEN);
		ok.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				 for(Enumeration<AbstractButton> AllgrupoS=grupoS.getElements(); AllgrupoS.hasMoreElements(); ){  
					   JRadioButton tempS=(JRadioButton)AllgrupoS.nextElement(); 
					   if(tempS.isSelected())  
					   {  
					    palpite[0] = tempS.getText();  
					   }
					}
				 
				 for(Enumeration<AbstractButton> AllgrupoA=grupoA.getElements(); AllgrupoA.hasMoreElements(); ){   
			           JRadioButton tempA=(JRadioButton)AllgrupoA.nextElement(); 
			           if(tempA.isSelected()) {
			        	palpite[1] = tempA.getText(); 
			           }
			        }
				 
				 palpite[2] = control.getComodo();
			        
			     String resPalpite = control.palpita(control.getPlayerAtual(), palpite);	
			        
			        if(resPalpite == null) {
			        	JOptionPane.showMessageDialog(null, "Ninguém possuia as cartas do seu palpite");
			        	dispose();
			        }
			        
			        else {
			        	JOptionPane.showMessageDialog(null, String.format("A carta %s foi encontrada", resPalpite));
			        	dispose();
			        }
			}
			
		});
		
		
		//
		
		setBackground(Color.decode("#f3cc95"));
		getContentPane().add(panel);
		setVisible(true);
	}

	@Override
	public void notify(ObservadoIF o) {
		this.repaint();
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}
}