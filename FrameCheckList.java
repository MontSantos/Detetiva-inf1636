//package view;
//
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.event.ItemEvent;
//import java.awt.event.ItemListener;
//
//import javax.swing.ButtonGroup;
//import javax.swing.JButton;
//import javax.swing.JRadioButton;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JOptionPane;
//
//import java.util.Enumeration;
//import javax.swing.AbstractButton;
//
//import Controller.ObservadoIF;
//import Controller.ObservadorIF;
//import model.CtrlRegras;
//
//class FrameCheckList extends JFrame implements ItemListener, ObservadorIF, ActionListener{
//	protected PainelCheckList panel = new PainelCheckList();
//	//private Border a,b,c = null;
//	private String[] acusacao = new String[3];
//	private JLabel sus, cmd, armas;
//	private JButton ok,cancelar;
//	private JRadioButton green, mustard, white, peacock, scarlet, plum, jantar, entrada, jogos,
//	cozinha, biblioteca, estar, musica, escritorio, jardim, castical, revolver, faca, cano, corda, chave;
//	private CtrlRegras control = CtrlRegras.getInstance();
//
//	
//	public FrameCheckList (String S) {
//		super(S);
//		
//		ButtonGroup grupoS = new ButtonGroup();
//		ButtonGroup grupoC = new ButtonGroup();
//		ButtonGroup grupoA = new ButtonGroup();
//		
//		/*JPanel armas = new JPanel();
//		JPanel sus = new JPanel();
//		JPanel cmd  = new JPanel();*/
//		
//		//cria janela
//		int tamTelaX = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
//		int tamTelaY = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
//        
//		setLocation((tamTelaX - 630) / 2, (tamTelaY - 630) / 2);
//		panel.setBounds(0, 0, 630, 630);
//		panel.setLayout(null);
//		setSize(630, 630);	
//		setResizable(false);
//		
//		
//		int w = getWidth() - getInsets().right - getInsets().left;
//		int h = getHeight() - getInsets().top - getInsets().bottom;
//		
//		int botaoX = (w - 104)/3;
//		int botaoY = (h - 130)/9;
//		
//		//
//		//panel.setBackground(Color.decode("#f3cc95"));
//		/*sus.setBounds(50, 50, 143, 500);
//		a = BorderFactory.createMatteBorder(0, 0, 0 ,0, Color.BLACK);
//		sus.setBorder(BorderFactory.createTitledBorder(a,"Suspeitos"));
//		panel.add(sus);
//		
//		cmd.setBounds(243, 50, 143, 500);
//		b = BorderFactory.createMatteBorder(0, 0, 0 ,0, Color.decode("#e9c28b"));
//		cmd.setBorder(BorderFactory.createTitledBorder(b,"Comodos"));
//		panel.add(cmd);
//		
//		armas.setBounds(436, 50, 143, 500);
//		c = BorderFactory.createMatteBorder(0, 0, 0 ,0, Color.decode("#e9c28b"));
//		armas.setBorder(BorderFactory.createTitledBorder(c,"Armas"));
//		panel.add(armas); */
//		
//		//
//		
//		sus = new JLabel("Suspeito(s):");
//		sus.setBounds(52, 44, h/3, 20);
//		sus.setFont(new Font("Arial", Font.BOLD, 15));
//		panel.add(sus);
//		
//		scarlet = new JRadioButton("Srta. Scarlet");
//		panel.add(scarlet);
//		scarlet.setBounds(46, 65, botaoX - 6, botaoY);
//		scarlet.setFont(new Font("Serif", Font.BOLD, 15));
//		scarlet.setForeground(Color.BLACK);
//		scarlet.setBackground(Color.decode("#e9c28b"));
//		grupoS.add(scarlet);
//		
//		mustard = new JRadioButton("Col. Mustarda");
//		panel.add(mustard);
//		mustard.setBounds(46, 65 + botaoY, botaoX - 6, botaoY);
//		mustard.setFont(new Font("Serif", Font.BOLD, 15));
//		mustard.setForeground(Color.BLACK);
//		mustard.setBackground(Color.decode("#e9c28b"));
//		grupoS.add(mustard);
//		
//		white = new JRadioButton("Sra. White");
//		panel.add(white);
//		white.setBounds(46, 65 + 2*botaoY, botaoX - 6, botaoY);
//		white.setFont(new Font("Serif", Font.BOLD, 15));
//		white.setForeground(Color.BLACK);
//		white.setBackground(Color.decode("#e9c28b"));
//		grupoS.add(white);
//		
//		green = new JRadioButton("Rev. Green");
//		panel.add(green);
//		green.setBounds(46, 65 + 3*botaoY, botaoX - 6, botaoY);               
//		green.setFont(new Font("Serif", Font.BOLD, 15));                                
//		green.setForeground(Color.BLACK);                                               
//		green.setBackground(Color.decode("#e9c28b")); 
//		grupoS.add(green);
//		
//		peacock = new JRadioButton("Sra. Peacock");
//		panel.add(peacock);
//		peacock.setBounds(46, 65 + 4*botaoY, botaoX - 6, botaoY);     
//		peacock.setFont(new Font("Serif", Font.BOLD, 15));                      
//		peacock.setForeground(Color.BLACK);                                     
//		peacock.setBackground(Color.decode("#e9c28b"));  
//		grupoS.add(peacock);
//		
//		plum = new JRadioButton("Prof. Plum");
//		panel.add(plum);
//		plum.setBounds(46, 65 + 5*botaoY, botaoX - 6, botaoY);     
//		plum.setFont(new Font("Serif", Font.BOLD, 15));                      
//		plum.setForeground(Color.BLACK);                                     
//		plum.setBackground(Color.decode("#e9c28b"));     
//		grupoS.add(plum);
//		
//		//
//		
//		cmd = new JLabel("Comodo(s):");
//		cmd.setBounds(58 + botaoX, 44, h/3, 20);
//		cmd.setFont(new Font("Arial", Font.BOLD, 15));
//		panel.add(cmd);
//		
//		jantar = new JRadioButton("Sala de Jantar");
//		panel.add(jantar);
//		jantar.setBounds(46+ botaoX + 6, 65, botaoX - 12, botaoY); 
//		jantar.setFont(new Font("Serif", Font.BOLD, 15));                
//		jantar.setForeground(Color.BLACK);                               
//		jantar.setBackground(Color.decode("#e9c28b"));  
//		grupoC.add(jantar);
//
//		entrada = new JRadioButton("Entrada");
//		panel.add(entrada);
//		entrada.setBounds(46+ botaoX + 6, 65 + botaoY, botaoX - 12, botaoY); 
//		entrada.setFont(new Font("Serif", Font.BOLD, 15));                
//		entrada.setForeground(Color.BLACK);                               
//		entrada.setBackground(Color.decode("#e9c28b"));  
//		grupoC.add(entrada);
//
//		jogos = new JRadioButton("Salão de Jogos");
//		panel.add(jogos);
//		jogos.setBounds(46+ botaoX + 6, 65 + 2*botaoY, botaoX - 12, botaoY); 
//		jogos.setFont(new Font("Serif", Font.BOLD, 15));                
//		jogos.setForeground(Color.BLACK);                               
//		jogos.setBackground(Color.decode("#e9c28b"));
//		grupoC.add(jogos);
//		
//		cozinha = new JRadioButton("Cozinha");
//		panel.add(cozinha);
//		cozinha.setBounds(46+ botaoX + 6, 65 + 3*botaoY, botaoX - 12, botaoY); 
//		cozinha.setFont(new Font("Serif", Font.BOLD, 15));                
//		cozinha.setForeground(Color.BLACK);                               
//		cozinha.setBackground(Color.decode("#e9c28b"));      
//		grupoC.add(cozinha);
//		
//		biblioteca = new JRadioButton("Biblioteca");
//		panel.add(biblioteca);
//		biblioteca.setBounds(46+ botaoX + 6, 65 + 4*botaoY, botaoX - 12, botaoY); 
//		biblioteca.setFont(new Font("Serif", Font.BOLD, 15));                
//		biblioteca.setForeground(Color.BLACK);                               
//		biblioteca.setBackground(Color.decode("#e9c28b"));     
//		grupoC.add(biblioteca);
//		
//		estar = new JRadioButton("Sala de Estar");
//		panel.add(estar);
//		estar.setBounds(46+ botaoX + 6, 65 + 5*botaoY, botaoX - 12, botaoY); 
//		estar.setFont(new Font("Serif", Font.BOLD, 15));                
//		estar.setForeground(Color.BLACK);                               
//		estar.setBackground(Color.decode("#e9c28b"));   
//		grupoC.add(estar);
//		
//		musica = new JRadioButton("Sala de Música");
//		panel.add(musica);
//		musica.setBounds(46+ botaoX + 6, 65 + 6*botaoY, botaoX - 12, botaoY); 
//		musica.setFont(new Font("Serif", Font.BOLD, 15));                
//		musica.setForeground(Color.BLACK);                               
//		musica.setBackground(Color.decode("#e9c28b")); 
//		grupoC.add(musica);
//		
//		escritorio = new JRadioButton("Escritório");
//		panel.add(escritorio);
//		escritorio.setBounds(46+ botaoX + 6, 65 + 7*botaoY, botaoX - 12, botaoY); 
//		escritorio.setFont(new Font("Serif", Font.BOLD, 15));                
//		escritorio.setForeground(Color.BLACK);                               
//		escritorio.setBackground(Color.decode("#e9c28b"));    
//		grupoC.add(escritorio);
//		
//		jardim = new JRadioButton("Jardim");
//		panel.add(jardim);
//		jardim.setBounds(46+ botaoX + 6, 65 + 8*botaoY, botaoX - 12, (int)( botaoY - 6 -  (6*((float)h/600)))); 
//		jardim.setFont(new Font("Serif", Font.BOLD, 15));                
//		jardim.setForeground(Color.BLACK);                               
//		jardim.setBackground(Color.decode("#e9c28b"));         
//		grupoC.add(jardim);
//		
//		//
//
//		cmd = new JLabel("Arma(s):");
//		cmd.setBounds(64 + 2*botaoX, 44, h/3, 20);
//		cmd.setFont(new Font("Arial", Font.BOLD, 15));
//		panel.add(cmd);
//		
//		castical = new JRadioButton("Castical");
//		panel.add(castical);
//		castical.setBounds(46 + 2*botaoX + 12, 65, botaoX - 18, botaoY);   
//		castical.setFont(new Font("Serif", Font.BOLD, 15));                        
//		castical.setForeground(Color.BLACK);                                       
//		castical.setBackground(Color.decode("#e9c28b")); 
//		grupoA.add(castical);
//		
//		revolver = new JRadioButton("Revólver");
//		panel.add(revolver);
//		revolver.setBounds(46 + 2*botaoX + 12, 65 + botaoY, botaoX - 18, botaoY);   
//		revolver.setFont(new Font("Serif", Font.BOLD, 15));                        
//		revolver.setForeground(Color.BLACK);                                       
//		revolver.setBackground(Color.decode("#e9c28b")); 
//		grupoA.add(revolver);
//		
//		faca = new JRadioButton("Faca");
//		panel.add(faca);
//		faca.setBounds(46 + 2*botaoX + 12, 65 + 2*botaoY, botaoX - 18, botaoY);   
//		faca.setFont(new Font("Serif", Font.BOLD, 15));                        
//		faca.setForeground(Color.BLACK);                                       
//		faca.setBackground(Color.decode("#e9c28b"));   
//		grupoA.add(faca);
//		     
//		cano = new JRadioButton("Cano");
//		panel.add(cano);
//		cano.setBounds(46 + 2*botaoX + 12, 65 + 3*botaoY, botaoX - 18, botaoY);   
//		cano.setFont(new Font("Serif", Font.BOLD, 15));                        
//		cano.setForeground(Color.BLACK);                                       
//		cano.setBackground(Color.decode("#e9c28b"));   
//		grupoA.add(cano);
//		
//		corda = new JRadioButton("Corda");
//		panel.add(corda);
//		corda.setBounds(46 + 2*botaoX +12, 65 + 4*botaoY, botaoX - 18, botaoY);   
//		corda.setFont(new Font("Serif", Font.BOLD, 15));                        
//		corda.setForeground(Color.BLACK);                                       
//		corda.setBackground(Color.decode("#e9c28b"));  
//		grupoA.add(corda);
//		      
//		chave = new JRadioButton("Chave Inglesa");
//		panel.add(chave);
//		chave.setBounds(46 + 2*botaoX + 12, 65 + 5*botaoY, botaoX - 18, botaoY);   
//		chave.setFont(new Font("Serif", Font.BOLD, 15));                        
//		chave.setForeground(Color.BLACK);                                       
//		chave.setBackground(Color.decode("#e9c28b"));   
//		grupoA.add(chave);
//		//
//		
//		cancelar = new JButton("Cancelar");
//		panel.add(cancelar);
//		cancelar.setBounds(46, 65 + 6 * botaoY,  botaoX - 5, ((h - 140) - 6*botaoY) - 7);
//		cancelar.setFont(new Font("Serif", Font.BOLD, 20));
//		cancelar.setForeground(Color.BLACK);
//		cancelar.setBackground(Color.RED);
//		cancelar.addActionListener(new ActionListener(){
//			public void actionPerformed(ActionEvent e) {
//				dispose();
//			}
//		});
//		
//		ok = new JButton("Confirmar");
//		panel.add(ok);
//		ok.setBounds(46 + 2*(botaoX) + 2, 65 + 6 * botaoY,  botaoX - 4, ((h - 140) - 6*botaoY) - 7);
//		ok.setFont(new Font("Serif", Font.BOLD, 20));
//		ok.setForeground(Color.BLACK);
//		ok.setBackground(Color.GREEN);
//		ok.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				 for(Enumeration<AbstractButton> AllgrupoS=grupoS.getElements(); AllgrupoS.hasMoreElements(); ){  
//					   JRadioButton tempS=(JRadioButton)AllgrupoS.nextElement(); 
//					   if(tempS.isSelected())  
//					   {  
//					    acusacao[0] = tempS.getText();  
//					   }
//					}
//				 
//				 for(Enumeration<AbstractButton> AllgrupoA=grupoA.getElements(); AllgrupoA.hasMoreElements(); ){   
//			           JRadioButton tempA=(JRadioButton)AllgrupoA.nextElement(); 
//			           if(tempA.isSelected()) {
//			        	acusacao[1] = tempA.getText(); 
//			           }
//			        }
//			      for(Enumeration<AbstractButton> AllgrupoC=grupoC.getElements(); AllgrupoC.hasMoreElements(); ){  
//			           JRadioButton tempC=(JRadioButton)AllgrupoC.nextElement();  
//			           if(tempC.isSelected())  
//			           {  
//			            acusacao[2] = tempC.getText();  
//			           }  
//			        }
//			        
//			        System.out.printf("%s - %s - %s\n",acusacao[0], acusacao[1], acusacao[2]);
//			        
//			        boolean acertou = control.acusa(control.getPlayerAtual(), acusacao);
//			        
//			        if(acertou) {
//			        	setVisible(false);
//			        	FrameVitoria f = new FrameVitoria();
//        				f.setVisible(true);
//        				
//			        }
//			        
//			        else {
//			        	JOptionPane.showMessageDialog(null, String.format("%s, você foi eliminado", control.getPlayerAtualNome()));
//			        }				
//			}
//			
//		});
//		
//		
//		//
//		
//		setBackground(Color.decode("#f3cc95"));
//		getContentPane().add(panel);
//		setVisible(true);
//	}
//
//	@Override
//	public void notify(ObservadoIF o) {
//		this.repaint();
//	}
//
//	@Override
//	public void itemStateChanged(ItemEvent e) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void actionPerformed(ActionEvent e) {
//		
//		
//	}
//	
//
//}