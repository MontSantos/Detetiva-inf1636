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
	protected PainelPalpite panel = new PainelPalpite();
	//private Border a,b,c = null;
	private JLabel sus, cmd, armas;
	private JButton ok,cancelar;
	private JCheckBox green, mustard, white, peacock, scarlet, plum, jantar, entrada, jogos,
	cozinha, biblioteca, estar, musica, escritorio, jardim, castical, revolver, faca, cano, corda, chave;
	
	private boolean[] anotacoes = new boolean[21];
	
	private static CtrlRegras control = CtrlRegras.getInstance();
	
	public FrameBloco () {
		super("Bloco de Notas de " + control.getPlayerAtualNome());
		
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
		
		anotacoes = control.getNotasPlayerAtual();
		
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
		scarlet.setSelected(anotacoes[0]);
		scarlet.addItemListener(new ItemListener() {
		    @Override
		    public void itemStateChanged(ItemEvent e) {
		        if(e.getStateChange() == ItemEvent.SELECTED) {//checkbox has been selected
		        	anotacoes[0]= true;
		        } else {//checkbox has been deselected
		        	anotacoes[0] = false;
		        };
		    }
		});
		
		mustard = new JCheckBox("Col. Mustarda");
		panel.add(mustard);
		mustard.setBounds(46, 65 + botaoY, botaoX - 6, botaoY);
		mustard.setFont(new Font("Serif", Font.BOLD, 15));
		mustard.setForeground(Color.BLACK);
		mustard.setBackground(Color.decode("#e9c28b"));
		mustard.setSelected(anotacoes[1]);
		mustard.addItemListener(new ItemListener() {
		    @Override
		    public void itemStateChanged(ItemEvent e) {
		        if(e.getStateChange() == ItemEvent.SELECTED) {//checkbox has been selected
		        	anotacoes[1]= true;
		        } else {//checkbox has been deselected
		        	anotacoes[1]= false;
		        };
		    }
		});
		
		white = new JCheckBox("Sra. White");
		panel.add(white);
		white.setBounds(46, 65 + 2*botaoY, botaoX - 6, botaoY);
		white.setFont(new Font("Serif", Font.BOLD, 15));
		white.setForeground(Color.BLACK);
		white.setBackground(Color.decode("#e9c28b"));
		white.setSelected(anotacoes[2]);
		white.addItemListener(new ItemListener() {
		    @Override
		    public void itemStateChanged(ItemEvent e) {
		        if(e.getStateChange() == ItemEvent.SELECTED) {//checkbox has been selected
		        	anotacoes[2]= true;
		        } else {//checkbox has been deselected
		        	anotacoes[2]= false;		        
		        	};
		    }
		});
		
		green = new JCheckBox("Rev. Green");
		panel.add(green);
		green.setBounds(46, 65 + 3*botaoY, botaoX - 6, botaoY);               
		green.setFont(new Font("Serif", Font.BOLD, 15));                                
		green.setForeground(Color.BLACK);                                               
		green.setBackground(Color.decode("#e9c28b")); 
		green.setSelected(anotacoes[3]);
		green.addItemListener(new ItemListener() {
		    @Override
		    public void itemStateChanged(ItemEvent e) {
		        if(e.getStateChange() == ItemEvent.SELECTED) {//checkbox has been selected
		        	anotacoes[3]= true;
		        } else {//checkbox has been deselected
		        	anotacoes[3]= false;
		        };
		    }
		});
		
		peacock = new JCheckBox("Sra. Peacock");
		panel.add(peacock);
		peacock.setBounds(46, 65 + 4*botaoY, botaoX - 6, botaoY);     
		peacock.setFont(new Font("Serif", Font.BOLD, 15));                      
		peacock.setForeground(Color.BLACK);                                     
		peacock.setBackground(Color.decode("#e9c28b"));
		peacock.setSelected(anotacoes[4]);
		peacock.addItemListener(new ItemListener() {
		    @Override
		    public void itemStateChanged(ItemEvent e) {
		        if(e.getStateChange() == ItemEvent.SELECTED) {//checkbox has been selected
		        	anotacoes[4]= true;
		        } else {//checkbox has been deselected
		        	anotacoes[4]= false;
		        };
		    }
		});
		
		plum = new JCheckBox("Prof. Plum");
		panel.add(plum);
		plum.setBounds(46, 65 + 5*botaoY, botaoX - 6, botaoY);     
		plum.setFont(new Font("Serif", Font.BOLD, 15));                      
		plum.setForeground(Color.BLACK);                                     
		plum.setBackground(Color.decode("#e9c28b"));   
		plum.setSelected(anotacoes[5]);
		plum.addItemListener(new ItemListener() {
		    @Override
		    public void itemStateChanged(ItemEvent e) {
		        if(e.getStateChange() == ItemEvent.SELECTED) {//checkbox has been selected
		        	anotacoes[5]= true;
		        } else {//checkbox has been deselected
		        	anotacoes[5]= false;
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
		jantar.setSelected(anotacoes[6]);
		jantar.addItemListener(new ItemListener() {
		    @Override
		    public void itemStateChanged(ItemEvent e) {
		        if(e.getStateChange() == ItemEvent.SELECTED) {//checkbox has been selected
		        	anotacoes[6]= true;
		        } else {//checkbox has been deselected
		        	anotacoes[6]= false;
		        };
		    }
		});                  

		entrada = new JCheckBox("Entrada");
		panel.add(entrada);
		entrada.setBounds(46+ botaoX + 6, 65 + botaoY, botaoX - 12, botaoY); 
		entrada.setFont(new Font("Serif", Font.BOLD, 15));                
		entrada.setForeground(Color.BLACK);                               
		entrada.setBackground(Color.decode("#e9c28b"));
		entrada.setSelected(anotacoes[7]);
		entrada.addItemListener(new ItemListener() {
		    @Override
		    public void itemStateChanged(ItemEvent e) {
		        if(e.getStateChange() == ItemEvent.SELECTED) {//checkbox has been selected
		        	anotacoes[7]= true;
		        } else {//checkbox has been deselected
		        	anotacoes[7]= true;
		        };
		    }
		});

		jogos = new JCheckBox("Salão de Jogos");
		panel.add(jogos);
		jogos.setBounds(46+ botaoX + 6, 65 + 2*botaoY, botaoX - 12, botaoY); 
		jogos.setFont(new Font("Serif", Font.BOLD, 15));                
		jogos.setForeground(Color.BLACK);                               
		jogos.setBackground(Color.decode("#e9c28b")); 
		jogos.setSelected(anotacoes[8]);
		jogos.addItemListener(new ItemListener() {
		    @Override
		    public void itemStateChanged(ItemEvent e) {
		        if(e.getStateChange() == ItemEvent.SELECTED) {//checkbox has been selected
		        	anotacoes[8]= true;
		        } else {//checkbox has been deselected
		        	anotacoes[8]= false;
		        };
		    }
		});
		
		cozinha = new JCheckBox("Cozinha");
		panel.add(cozinha);
		cozinha.setBounds(46+ botaoX + 6, 65 + 3*botaoY, botaoX - 12, botaoY); 
		cozinha.setFont(new Font("Serif", Font.BOLD, 15));                
		cozinha.setForeground(Color.BLACK);                               
		cozinha.setBackground(Color.decode("#e9c28b")); 
		cozinha.setSelected(anotacoes[9]);
		cozinha.addItemListener(new ItemListener() {
		    @Override
		    public void itemStateChanged(ItemEvent e) {
		        if(e.getStateChange() == ItemEvent.SELECTED) {//checkbox has been selected
		        	anotacoes[9]= true;
		        } else {//checkbox has been deselected
		        	anotacoes[9]= false;
		        };
		    }
		});
		
		biblioteca = new JCheckBox("Biblioteca");
		panel.add(biblioteca);
		biblioteca.setBounds(46+ botaoX + 6, 65 + 4*botaoY, botaoX - 12, botaoY); 
		biblioteca.setFont(new Font("Serif", Font.BOLD, 15));                
		biblioteca.setForeground(Color.BLACK);                               
		biblioteca.setBackground(Color.decode("#e9c28b"));
		biblioteca.setSelected(anotacoes[10]);
		biblioteca.addItemListener(new ItemListener() {
		    @Override
		    public void itemStateChanged(ItemEvent e) {
		        if(e.getStateChange() == ItemEvent.SELECTED) {//checkbox has been selected
		        	anotacoes[10]= true;
		        } else {//checkbox has been deselected
		        	anotacoes[10]= false;
		        };
		    }
		});
		
		estar = new JCheckBox("Sala de Estar");
		panel.add(estar);
		estar.setBounds(46+ botaoX + 6, 65 + 5*botaoY, botaoX - 12, botaoY); 
		estar.setFont(new Font("Serif", Font.BOLD, 15));                
		estar.setForeground(Color.BLACK);                               
		estar.setBackground(Color.decode("#e9c28b")); 
		estar.setSelected(anotacoes[11]);
		estar.addItemListener(new ItemListener() {
		    @Override
		    public void itemStateChanged(ItemEvent e) {
		        if(e.getStateChange() == ItemEvent.SELECTED) {//checkbox has been selected
		        	anotacoes[11]= true;
		        } else {//checkbox has been deselected
		        	anotacoes[11]= false;
		        };
		    }
		});
		
		musica = new JCheckBox("Sala de Música");
		panel.add(musica);
		musica.setBounds(46+ botaoX + 6, 65 + 6*botaoY, botaoX - 12, botaoY); 
		musica.setFont(new Font("Serif", Font.BOLD, 15));                
		musica.setForeground(Color.BLACK);                               
		musica.setBackground(Color.decode("#e9c28b")); 
		musica.setSelected(anotacoes[12]);
		musica.addItemListener(new ItemListener() {
		    @Override
		    public void itemStateChanged(ItemEvent e) {
		        if(e.getStateChange() == ItemEvent.SELECTED) {//checkbox has been selected
		        	anotacoes[12]= true;
		        } else {//checkbox has been deselected
		        	anotacoes[12]= false;
		        };
		    }
		});
		
		escritorio = new JCheckBox("Escritório");
		panel.add(escritorio);
		escritorio.setBounds(46+ botaoX + 6, 65 + 7*botaoY, botaoX - 12, botaoY); 
		escritorio.setFont(new Font("Serif", Font.BOLD, 15));                
		escritorio.setForeground(Color.BLACK);                               
		escritorio.setBackground(Color.decode("#e9c28b")); 
		escritorio.setSelected(anotacoes[13]);
		escritorio.addItemListener(new ItemListener() {
		    @Override
		    public void itemStateChanged(ItemEvent e) {
		        if(e.getStateChange() == ItemEvent.SELECTED) {//checkbox has been selected
		        	anotacoes[13]= true;
		        } else {//checkbox has been deselected
		        	anotacoes[13]= false;
		        };
		    }
		});
		
		jardim = new JCheckBox("Jardim");
		panel.add(jardim);
		jardim.setBounds(46+ botaoX + 6, 65 + 8*botaoY, botaoX - 12, (int)( botaoY - 6 -  (6*((float)h/600)))); 
		jardim.setFont(new Font("Serif", Font.BOLD, 15));                
		jardim.setForeground(Color.BLACK);                               
		jardim.setBackground(Color.decode("#e9c28b"));
		jardim.setSelected(anotacoes[14]);
		jardim.addItemListener(new ItemListener() {
		    @Override
		    public void itemStateChanged(ItemEvent e) {
		        if(e.getStateChange() == ItemEvent.SELECTED) {//checkbox has been selected
		        	anotacoes[14]= true;
		        } else {//checkbox has been deselected
		        	anotacoes[14]= false;
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
		castical.setSelected(anotacoes[15]);
		castical.addItemListener(new ItemListener() {
		    @Override
		    public void itemStateChanged(ItemEvent e) {
		        if(e.getStateChange() == ItemEvent.SELECTED) {//checkbox has been selected
		        	anotacoes[15]= true;
		        } else {//checkbox has been deselected
		        	anotacoes[15]= false;
		        };
		    }
		});
		
		revolver = new JCheckBox("Revólver");
		panel.add(revolver);
		revolver.setBounds(46 + 2*botaoX + 12, 65 + botaoY, botaoX - 18, botaoY);   
		revolver.setFont(new Font("Serif", Font.BOLD, 15));                        
		revolver.setForeground(Color.BLACK);                                       
		revolver.setBackground(Color.decode("#e9c28b")); 
		revolver.setSelected(anotacoes[16]);
		revolver.addItemListener(new ItemListener() {
		    @Override
		    public void itemStateChanged(ItemEvent e) {
		        if(e.getStateChange() == ItemEvent.SELECTED) {//checkbox has been selected
		        	anotacoes[16]= true;
		        } else {//checkbox has been deselected
		        	anotacoes[16]= false;
		        };
		    }
		});
		
		faca = new JCheckBox("Faca");
		panel.add(faca);
		faca.setBounds(46 + 2*botaoX + 12, 65 + 2*botaoY, botaoX - 18, botaoY);   
		faca.setFont(new Font("Serif", Font.BOLD, 15));                        
		faca.setForeground(Color.BLACK);                                       
		faca.setBackground(Color.decode("#e9c28b")); 
		faca.setSelected(anotacoes[17]);
		faca.addItemListener(new ItemListener() {
		    @Override
		    public void itemStateChanged(ItemEvent e) {
		        if(e.getStateChange() == ItemEvent.SELECTED) {//checkbox has been selected
		        	anotacoes[17]= true;
		        } else {//checkbox has been deselected
		        	anotacoes[17]= false;
		        };
		    }
		});
		     
		cano = new JCheckBox("Cano");
		panel.add(cano);
		cano.setBounds(46 + 2*botaoX + 12, 65 + 3*botaoY, botaoX - 18, botaoY);   
		cano.setFont(new Font("Serif", Font.BOLD, 15));                        
		cano.setForeground(Color.BLACK);                                       
		cano.setBackground(Color.decode("#e9c28b"));  
		cano.setSelected(anotacoes[18]);
		cano.addItemListener(new ItemListener() {
		    @Override
		    public void itemStateChanged(ItemEvent e) {
		        if(e.getStateChange() == ItemEvent.SELECTED) {//checkbox has been selected
		        	anotacoes[18]= true;
		        } else {//checkbox has been deselected
		        	anotacoes[18]= false;
		        };
		    }
		});
		
		corda = new JCheckBox("Corda");
		panel.add(corda);
		corda.setBounds(46 + 2*botaoX +12, 65 + 4*botaoY, botaoX - 18, botaoY);   
		corda.setFont(new Font("Serif", Font.BOLD, 15));                        
		corda.setForeground(Color.BLACK);                                       
		corda.setBackground(Color.decode("#e9c28b")); 
		corda.setSelected(anotacoes[19]);
		corda.addItemListener(new ItemListener() {
		    @Override
		    public void itemStateChanged(ItemEvent e) {
		        if(e.getStateChange() == ItemEvent.SELECTED) {//checkbox has been selected
		        	anotacoes[19]= true;
		        } else {//checkbox has been deselected
		        	anotacoes[19]= false;
		        };
		    }
		});
		      
		chave = new JCheckBox("Chave Inglesa");
		panel.add(chave);
		chave.setBounds(46 + 2*botaoX + 12, 65 + 5*botaoY, botaoX - 18, botaoY);   
		chave.setFont(new Font("Serif", Font.BOLD, 15));                        
		chave.setForeground(Color.BLACK);                                       
		chave.setBackground(Color.decode("#e9c28b")); 
		chave.setSelected(anotacoes[20]);
		chave.addItemListener(new ItemListener() {
		    @Override
		    public void itemStateChanged(ItemEvent e) {
		        if(e.getStateChange() == ItemEvent.SELECTED) {//checkbox has been selected
		        	anotacoes[20]= true;
		        } else {//checkbox has been deselected
		        	anotacoes[20]= false;
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