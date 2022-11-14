package view;

import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
//import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
//import javax.swing.JPanel;
//import javax.swing.border.*;

import java.util.ArrayList;

import Controller.ObservadoIF;
import Controller.ObservadorIF;

import model.CtrlRegras;

class FrameBloco extends JFrame implements ObservadorIF, WindowListener{
	protected PainelCheckList panel = new PainelCheckList();
	//private Border a,b,c = null;
	private JLabel sus, cmd, armas;
	private JButton ok,cancelar;
	private JCheckBox green, mustard, white, peacock, scarlet, plum, jantar, entrada, jogos,
	cozinha, biblioteca, estar, musica, escritorio, jardim, castical, revolver, faca, cano, corda, chave;
	
	private ArrayList<String> anotacoes = new ArrayList<String>();
	
	private CtrlRegras control = CtrlRegras.getInstance();
	
	public FrameBloco () {
		super("Bloco de Notas de X");
		
		/*JPanel armas = new JPanel();
		JPanel sus = new JPanel();
		JPanel cmd  = new JPanel();*/
		
		//setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
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
		System.out.println(h);
		
		//
		//panel.setBackground(Color.decode("#f3cc95"));
		/*sus.setBounds(50, 50, 143, 500);
		a = BorderFactory.createMatteBorder(0, 0, 0 ,0, Color.BLACK);
		sus.setBorder(BorderFactory.createTitledBorder(a,"Suspeitos"));
		panel.add(sus);
		
		cmd.setBounds(243, 50, 143, 500);
		b = BorderFactory.createMatteBorder(0, 0, 0 ,0, Color.decode("#e9c28b"));
		cmd.setBorder(BorderFactory.createTitledBorder(b,"Comodos"));
		panel.add(cmd);
		
		armas.setBounds(436, 50, 143, 500);
		c = BorderFactory.createMatteBorder(0, 0, 0 ,0, Color.decode("#e9c28b"));
		armas.setBorder(BorderFactory.createTitledBorder(c,"Armas"));
		panel.add(armas); */
		
		//
		//
		if(control.getNotasPlayerAtual().size() > 0){
			anotacoes = control.getPlayerAtual().getNotas();
		}
		
		sus = new JLabel("Suspeito(s):");
		sus.setBounds(52, 44, h/3, 20);
		sus.setFont(new Font("Arial", Font.BOLD, 15));
		panel.add(sus);
		
		scarlet = new JCheckBox("Srta. Scarlet");
		panel.add(scarlet);
		scarlet.setBounds(46, 65, botaoX - 6, botaoY);
		scarlet.setFont(new Font("Serif", Font.BOLD, 15));
		scarlet.setForeground(Color.BLACK);
		scarlet.setBackground(Color.decode("#e9c28b"));
		scarlet.addItemListener(new ItemListener() {
		    @Override
		    public void itemStateChanged(ItemEvent e) {
		        if(e.getStateChange() == ItemEvent.SELECTED) {//checkbox has been selected
		        	anotacoes.add("scarlet");
		        } else {//checkbox has been deselected
		        	anotacoes.remove("scarlet");
		        };
		    }
		});
		
		mustard = new JCheckBox("Col. Mustarda");
		panel.add(mustard);
		mustard.setBounds(46, 65 + botaoY, botaoX - 6, botaoY);
		mustard.setFont(new Font("Serif", Font.BOLD, 15));
		mustard.setForeground(Color.BLACK);
		mustard.setBackground(Color.decode("#e9c28b"));
		mustard.addItemListener(new ItemListener() {
		    @Override
		    public void itemStateChanged(ItemEvent e) {
		        if(e.getStateChange() == ItemEvent.SELECTED) {//checkbox has been selected
		        	anotacoes.add("mustard");
		        } else {//checkbox has been deselected
		        	anotacoes.remove("mustard");
		        };
		    }
		});
		
		white = new JCheckBox("Sra. White");
		panel.add(white);
		white.setBounds(46, 65 + 2*botaoY, botaoX - 6, botaoY);
		white.setFont(new Font("Serif", Font.BOLD, 15));
		white.setForeground(Color.BLACK);
		white.setBackground(Color.decode("#e9c28b"));
		white.addItemListener(new ItemListener() {
		    @Override
		    public void itemStateChanged(ItemEvent e) {
		        if(e.getStateChange() == ItemEvent.SELECTED) {//checkbox has been selected
		        	anotacoes.add("white");
		        } else {//checkbox has been deselected
		        	anotacoes.remove("white");
		        };
		    }
		});
		
		green = new JCheckBox("Rev. Green");
		panel.add(green);
		green.setBounds(46, 65 + 3*botaoY, botaoX - 6, botaoY);               
		green.setFont(new Font("Serif", Font.BOLD, 15));                                
		green.setForeground(Color.BLACK);                                               
		green.setBackground(Color.decode("#e9c28b"));  
		green.addItemListener(new ItemListener() {
		    @Override
		    public void itemStateChanged(ItemEvent e) {
		        if(e.getStateChange() == ItemEvent.SELECTED) {//checkbox has been selected
		        	anotacoes.add("green");
		        } else {//checkbox has been deselected
		        	anotacoes.remove("greenn");
		        };
		    }
		});
		
		peacock = new JCheckBox("Sra. Peacock");
		panel.add(peacock);
		peacock.setBounds(46, 65 + 4*botaoY, botaoX - 6, botaoY);     
		peacock.setFont(new Font("Serif", Font.BOLD, 15));                      
		peacock.setForeground(Color.BLACK);                                     
		peacock.setBackground(Color.decode("#e9c28b"));  
		peacock.addItemListener(new ItemListener() {
		    @Override
		    public void itemStateChanged(ItemEvent e) {
		        if(e.getStateChange() == ItemEvent.SELECTED) {//checkbox has been selected
		        	anotacoes.add("peacockk");
		        } else {//checkbox has been deselected
		        	anotacoes.remove("peacock");
		        };
		    }
		});
		
		plum = new JCheckBox("Prof. Plum");
		panel.add(plum);
		plum.setBounds(46, 65 + 5*botaoY, botaoX - 6, botaoY);     
		plum.setFont(new Font("Serif", Font.BOLD, 15));                      
		plum.setForeground(Color.BLACK);                                     
		plum.setBackground(Color.decode("#e9c28b"));    
		plum.addItemListener(new ItemListener() {
		    @Override
		    public void itemStateChanged(ItemEvent e) {
		        if(e.getStateChange() == ItemEvent.SELECTED) {//checkbox has been selected
		        	anotacoes.add("plumm");
		        } else {//checkbox has been deselected
		        	anotacoes.remove("plumm");
		        };
		    }
		});
		//
		
		cmd = new JLabel("Comodo(s):");
		cmd.setBounds(58 + botaoX, 44, h/3, 20);
		cmd.setFont(new Font("Arial", Font.BOLD, 15));
		panel.add(cmd);
		
		jantar = new JCheckBox("Sala de Jantar");
		panel.add(jantar);
		jantar.setBounds(46+ botaoX + 6, 65, botaoX - 12, botaoY); 
		jantar.setFont(new Font("Serif", Font.BOLD, 15));                
		jantar.setForeground(Color.BLACK);                               
		jantar.setBackground(Color.decode("#e9c28b"));
		jantar.addItemListener(new ItemListener() {
		    @Override
		    public void itemStateChanged(ItemEvent e) {
		        if(e.getStateChange() == ItemEvent.SELECTED) {//checkbox has been selected
		        	anotacoes.add("jantar");
		        } else {//checkbox has been deselected
		        	anotacoes.remove("jantar");
		        };
		    }
		});                  

		entrada = new JCheckBox("Entrada");
		panel.add(entrada);
		entrada.setBounds(46+ botaoX + 6, 65 + botaoY, botaoX - 12, botaoY); 
		entrada.setFont(new Font("Serif", Font.BOLD, 15));                
		entrada.setForeground(Color.BLACK);                               
		entrada.setBackground(Color.decode("#e9c28b")); 
		entrada.addItemListener(new ItemListener() {
		    @Override
		    public void itemStateChanged(ItemEvent e) {
		        if(e.getStateChange() == ItemEvent.SELECTED) {//checkbox has been selected
		        	anotacoes.add("entrada");
		        } else {//checkbox has been deselected
		        	anotacoes.remove("entrada");
		        };
		    }
		});

		jogos = new JCheckBox("Salão de Jogos");
		panel.add(jogos);
		jogos.setBounds(46+ botaoX + 6, 65 + 2*botaoY, botaoX - 12, botaoY); 
		jogos.setFont(new Font("Serif", Font.BOLD, 15));                
		jogos.setForeground(Color.BLACK);                               
		jogos.setBackground(Color.decode("#e9c28b"));   
		jogos.addItemListener(new ItemListener() {
		    @Override
		    public void itemStateChanged(ItemEvent e) {
		        if(e.getStateChange() == ItemEvent.SELECTED) {//checkbox has been selected
		        	anotacoes.add("jogos");
		        } else {//checkbox has been deselected
		        	anotacoes.remove("jogos");
		        };
		    }
		});
		
		cozinha = new JCheckBox("Cozinha");
		panel.add(cozinha);
		cozinha.setBounds(46+ botaoX + 6, 65 + 3*botaoY, botaoX - 12, botaoY); 
		cozinha.setFont(new Font("Serif", Font.BOLD, 15));                
		cozinha.setForeground(Color.BLACK);                               
		cozinha.setBackground(Color.decode("#e9c28b")); 
		cozinha.addItemListener(new ItemListener() {
		    @Override
		    public void itemStateChanged(ItemEvent e) {
		        if(e.getStateChange() == ItemEvent.SELECTED) {//checkbox has been selected
		        	anotacoes.add("cozinha");
		        } else {//checkbox has been deselected
		        	anotacoes.remove("cozinha");
		        };
		    }
		});
		
		biblioteca = new JCheckBox("Biblioteca");
		panel.add(biblioteca);
		biblioteca.setBounds(46+ botaoX + 6, 65 + 4*botaoY, botaoX - 12, botaoY); 
		biblioteca.setFont(new Font("Serif", Font.BOLD, 15));                
		biblioteca.setForeground(Color.BLACK);                               
		biblioteca.setBackground(Color.decode("#e9c28b"));
		biblioteca.addItemListener(new ItemListener() {
		    @Override
		    public void itemStateChanged(ItemEvent e) {
		        if(e.getStateChange() == ItemEvent.SELECTED) {//checkbox has been selected
		        	anotacoes.add("biblioteca");
		        } else {//checkbox has been deselected
		        	anotacoes.remove("biblioteca");
		        };
		    }
		});
		
		estar = new JCheckBox("Sala de Estar");
		panel.add(estar);
		estar.setBounds(46+ botaoX + 6, 65 + 5*botaoY, botaoX - 12, botaoY); 
		estar.setFont(new Font("Serif", Font.BOLD, 15));                
		estar.setForeground(Color.BLACK);                               
		estar.setBackground(Color.decode("#e9c28b"));      
		estar.addItemListener(new ItemListener() {
		    @Override
		    public void itemStateChanged(ItemEvent e) {
		        if(e.getStateChange() == ItemEvent.SELECTED) {//checkbox has been selected
		        	anotacoes.add("estar");
		        } else {//checkbox has been deselected
		        	anotacoes.remove("estar");
		        };
		    }
		});
		
		musica = new JCheckBox("Sala de Música");
		panel.add(musica);
		musica.setBounds(46+ botaoX + 6, 65 + 6*botaoY, botaoX - 12, botaoY); 
		musica.setFont(new Font("Serif", Font.BOLD, 15));                
		musica.setForeground(Color.BLACK);                               
		musica.setBackground(Color.decode("#e9c28b"));  
		musica.addItemListener(new ItemListener() {
		    @Override
		    public void itemStateChanged(ItemEvent e) {
		        if(e.getStateChange() == ItemEvent.SELECTED) {//checkbox has been selected
		        	anotacoes.add("musica");
		        } else {//checkbox has been deselected
		        	anotacoes.remove("musica");
		        };
		    }
		});
		
		escritorio = new JCheckBox("Escritório");
		panel.add(escritorio);
		escritorio.setBounds(46+ botaoX + 6, 65 + 7*botaoY, botaoX - 12, botaoY); 
		escritorio.setFont(new Font("Serif", Font.BOLD, 15));                
		escritorio.setForeground(Color.BLACK);                               
		escritorio.setBackground(Color.decode("#e9c28b"));  
		escritorio.addItemListener(new ItemListener() {
		    @Override
		    public void itemStateChanged(ItemEvent e) {
		        if(e.getStateChange() == ItemEvent.SELECTED) {//checkbox has been selected
		        	anotacoes.add("escritorio");
		        } else {//checkbox has been deselected
		        	anotacoes.remove("escritorio");
		        };
		    }
		});
		
		jardim = new JCheckBox("Jardim");
		panel.add(jardim);
		jardim.setBounds(46+ botaoX + 6, 65 + 8*botaoY, botaoX - 12, (int)( botaoY - 6 -  (6*((float)h/600)))); 
		jardim.setFont(new Font("Serif", Font.BOLD, 15));                
		jardim.setForeground(Color.BLACK);                               
		jardim.setBackground(Color.decode("#e9c28b"));
		jardim.addItemListener(new ItemListener() {
		    @Override
		    public void itemStateChanged(ItemEvent e) {
		        if(e.getStateChange() == ItemEvent.SELECTED) {//checkbox has been selected
		        	anotacoes.add("jardim");
		        } else {//checkbox has been deselected
		        	anotacoes.remove("jardim");
		        };
		    }
		});
		
		//

		cmd = new JLabel("Arma(s):");
		cmd.setBounds(64 + 2*botaoX, 44, h/3, 20);
		cmd.setFont(new Font("Arial", Font.BOLD, 15));
		panel.add(cmd);
		
		castical = new JCheckBox("Castical");
		panel.add(castical);
		castical.setBounds(46 + 2*botaoX + 12, 65, botaoX - 18, botaoY);   
		castical.setFont(new Font("Serif", Font.BOLD, 15));                        
		castical.setForeground(Color.BLACK);                                       
		castical.setBackground(Color.decode("#e9c28b"));  
		castical.addItemListener(new ItemListener() {
		    @Override
		    public void itemStateChanged(ItemEvent e) {
		        if(e.getStateChange() == ItemEvent.SELECTED) {//checkbox has been selected
		        	anotacoes.add("castical");
		        } else {//checkbox has been deselected
		        	anotacoes.remove("castical");
		        };
		    }
		});
		
		revolver = new JCheckBox("Revólver");
		panel.add(revolver);
		revolver.setBounds(46 + 2*botaoX + 12, 65 + botaoY, botaoX - 18, botaoY);   
		revolver.setFont(new Font("Serif", Font.BOLD, 15));                        
		revolver.setForeground(Color.BLACK);                                       
		revolver.setBackground(Color.decode("#e9c28b")); 
		revolver.addItemListener(new ItemListener() {
		    @Override
		    public void itemStateChanged(ItemEvent e) {
		        if(e.getStateChange() == ItemEvent.SELECTED) {//checkbox has been selected
		        	anotacoes.add("revolver");
		        } else {//checkbox has been deselected
		        	anotacoes.remove("revolver");
		        };
		    }
		});
		
		faca = new JCheckBox("Faca");
		panel.add(faca);
		faca.setBounds(46 + 2*botaoX + 12, 65 + 2*botaoY, botaoX - 18, botaoY);   
		faca.setFont(new Font("Serif", Font.BOLD, 15));                        
		faca.setForeground(Color.BLACK);                                       
		faca.setBackground(Color.decode("#e9c28b"));   
		faca.addItemListener(new ItemListener() {
		    @Override
		    public void itemStateChanged(ItemEvent e) {
		        if(e.getStateChange() == ItemEvent.SELECTED) {//checkbox has been selected
		        	anotacoes.add("faca");
		        } else {//checkbox has been deselected
		        	anotacoes.remove("faca");
		        };
		    }
		});
		     
		cano = new JCheckBox("Cano");
		panel.add(cano);
		cano.setBounds(46 + 2*botaoX + 12, 65 + 3*botaoY, botaoX - 18, botaoY);   
		cano.setFont(new Font("Serif", Font.BOLD, 15));                        
		cano.setForeground(Color.BLACK);                                       
		cano.setBackground(Color.decode("#e9c28b"));    
		cano.addItemListener(new ItemListener() {
		    @Override
		    public void itemStateChanged(ItemEvent e) {
		        if(e.getStateChange() == ItemEvent.SELECTED) {//checkbox has been selected
		        	anotacoes.add("cano");
		        } else {//checkbox has been deselected
		        	anotacoes.remove("cano");
		        };
		    }
		});
		
		corda = new JCheckBox("Corda");
		panel.add(corda);
		corda.setBounds(46 + 2*botaoX +12, 65 + 4*botaoY, botaoX - 18, botaoY);   
		corda.setFont(new Font("Serif", Font.BOLD, 15));                        
		corda.setForeground(Color.BLACK);                                       
		corda.setBackground(Color.decode("#e9c28b")); 
		corda.addItemListener(new ItemListener() {
		    @Override
		    public void itemStateChanged(ItemEvent e) {
		        if(e.getStateChange() == ItemEvent.SELECTED) {//checkbox has been selected
		        	anotacoes.add("corda");
		        } else {//checkbox has been deselected
		        	anotacoes.remove("corda");
		        };
		    }
		});
		      
		chave = new JCheckBox("Chave Inglesa");
		panel.add(chave);
		chave.setBounds(46 + 2*botaoX + 12, 65 + 5*botaoY, botaoX - 18, botaoY);   
		chave.setFont(new Font("Serif", Font.BOLD, 15));                        
		chave.setForeground(Color.BLACK);                                       
		chave.setBackground(Color.decode("#e9c28b"));   
		chave.addItemListener(new ItemListener() {
		    @Override
		    public void itemStateChanged(ItemEvent e) {
		        if(e.getStateChange() == ItemEvent.SELECTED) {//checkbox has been selected
		        	anotacoes.add("chave");
		        } else {//checkbox has been deselected
		        	anotacoes.remove("chave");
		        };
		    }
		});
		
       addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent e) {
            	control.setNotasPlayerAtual(anotacoes);
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
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		//addWindowListener(new WindowAdapter() { public void windowClosing(WindowEvent evt) { if (JOptionPane.showConfirmDialog(null,"Deseja sair")==JOptionPane.OK_OPTION){ salvarDados(); } } });
		//control.setNotasPlayerAtual(anotacoes);
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
}