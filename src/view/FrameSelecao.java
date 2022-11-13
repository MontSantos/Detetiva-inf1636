	package view;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
//import Controller.MouseClickHandle;

import model.CtrlRegras;

class FrameSelecao extends JFrame implements ItemListener{
	private PainelSelecao panel = new PainelSelecao();
	private JButton continuar;
	private JCheckBox scarlet, mustard, white, green, peacock, plum;
	
	private ArrayList<String> personagensEscolhidos = new ArrayList<String>();
	
	static int qntPlayers = 0;
	
	private static boolean isBlocked = false;
	
	public FrameSelecao() {
		
		//cria janela
		super("Detetive - Selecao de Personagens");
		int tamTelaX = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		int tamTelaY = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setLocation((tamTelaX - 1000)/2, (tamTelaY - 700)/2);
        panel.setBounds(0, 0, 1000, 700);
        panel.setLayout(null);
        setSize(1000, 700);
        setResizable(false);
        getContentPane().add(panel);
        setVisible(true);
        
		int w = getWidth() - getInsets().right - getInsets().left;
		int h = getHeight() - getInsets().top - getInsets().bottom;
		int botaoH = (int) (((float) (h/2)/7)) + 1;
        
        //botoes
        
        continuar = new JButton("Iniciar Jogo");
		panel.add(continuar);
		continuar.setBounds(3*(w/4), h/2, w/4, botaoH);
		continuar.setFont(new Font("Serif", Font.BOLD, 20));
		continuar.setForeground(Color.BLACK);
		continuar.setBackground(Color.LIGHT_GRAY);
         
		//checkbox
		
		scarlet = new JCheckBox("Srta. Scarlet");
		panel.add(scarlet);
		scarlet.addItemListener(new ItemListener() {
		    @Override
		    public void itemStateChanged(ItemEvent e) {
		        if(e.getStateChange() == ItemEvent.SELECTED) {//checkbox has been selected
		        	personagensEscolhidos.add(0,"Scarlet");
					qntPlayers+=1;
		        } else {//checkbox has been deselected
		        	qntPlayers-=1;
		        	personagensEscolhidos.remove("Scarlet");
		        };
		    }
		});
		scarlet.setBounds(3*(w/4), h/2 + botaoH, w/4, botaoH);
		scarlet.setFont(new Font("Serif", Font.BOLD, 20));
		scarlet.setForeground(Color.BLACK);
		scarlet.setBackground(Color.decode("#991017"));
		
		mustard = new JCheckBox("Col. Mustarda");
		panel.add(mustard);
		mustard.addItemListener(new ItemListener() {
		    @Override
		    public void itemStateChanged(ItemEvent e) {
		        if(e.getStateChange() == ItemEvent.SELECTED) {//checkbox has been selected
					qntPlayers+=1;
					if (personagensEscolhidos.size() == 0 || !personagensEscolhidos.contains("Scarlet")) {
						personagensEscolhidos.add(0,"Mustard");
					}
					else{
						personagensEscolhidos.add(1,"Mustard");
					}
		        } else {//checkbox has been deselected
		        	qntPlayers-=1;
		        	personagensEscolhidos.remove("Mustard");
		        };
		    }
		});
		mustard.setBounds(3*(w/4), h/2 + 2*botaoH, w/4, botaoH);
		mustard.setFont(new Font("Serif", Font.BOLD, 20));
		mustard.setForeground(Color.BLACK);
		mustard.setBackground(Color.decode("#b7920e"));
		
		white = new JCheckBox("Sra. White");
		panel.add(white);
		white.addItemListener(new ItemListener() {
		    @Override
		    public void itemStateChanged(ItemEvent e) {
		        if(e.getStateChange() == ItemEvent.SELECTED) {//checkbox has been selected
					qntPlayers+=1;
					if (personagensEscolhidos.size() == 0 || (!personagensEscolhidos.contains("Scarlet") && !personagensEscolhidos.contains("Mustard"))) {
						personagensEscolhidos.add(0,"White");
					}
					else if(!personagensEscolhidos.contains("Scarlet") || !personagensEscolhidos.contains("Mustard")){
						personagensEscolhidos.add(1,"White");
					}
					else {
						personagensEscolhidos.add(2,"White");
					}
		        } else {//checkbox has been deselected
		        	qntPlayers-=1;
		        	personagensEscolhidos.remove("White");
		        };
		    }
		});
		white.setBounds(3*(w/4), h/2 + (3*botaoH), w/4, botaoH);
		white.setFont(new Font("Serif", Font.BOLD, 20));
		white.setForeground(Color.BLACK);
		white.setBackground(Color.decode("#7780a1"));
		
		green = new JCheckBox("Rev. Green");
		panel.add(green);
		green.addItemListener(new ItemListener() {
		    @Override
		    public void itemStateChanged(ItemEvent e) {
		        if(e.getStateChange() == ItemEvent.SELECTED) {//checkbox has been selected
					qntPlayers+=1;
					if(personagensEscolhidos.size() == 0) {
						personagensEscolhidos.add("Green");
					}
					

					else if(personagensEscolhidos.contains("White")|| personagensEscolhidos.contains("Scarlet") || personagensEscolhidos.contains("Mustard")) {
						if(personagensEscolhidos.contains("White")){
							personagensEscolhidos.add(personagensEscolhidos.indexOf("White")+1, "Green");
						}
						
						else if(personagensEscolhidos.contains("Mustard")){
							personagensEscolhidos.add(personagensEscolhidos.indexOf("Mustard")+1, "Green");
						}
						else {
							personagensEscolhidos.add(personagensEscolhidos.indexOf("Scarlet")+1, "Green");
						}
					}
					else {
						personagensEscolhidos.add(0,"Green");
					}

		        } else {//checkbox has been deselected
		        	qntPlayers-=1;
		        	personagensEscolhidos.remove("Green");
		        };
		    }
		});
		green.setBounds(3*(w/4), h/2 + 4*botaoH, w/4, botaoH);
		green.setFont(new Font("Serif", Font.BOLD, 20));
		green.setForeground(Color.BLACK);
		green.setBackground(Color.decode("#045c4c"));
		
		peacock = new JCheckBox("Sra. Peacock");
		panel.add(peacock);
		peacock.addItemListener(new ItemListener() {
		    @Override
		    public void itemStateChanged(ItemEvent e) {
		        if(e.getStateChange() == ItemEvent.SELECTED) {//checkbox has been selected
					qntPlayers+=1;
					if(personagensEscolhidos.size()== 0) {
						personagensEscolhidos.add("Peacock");
					}
					
					else if(personagensEscolhidos.contains("Green") || personagensEscolhidos.contains("White")|| personagensEscolhidos.contains("Mustard") || personagensEscolhidos.contains("Scarlet")) {
						if(personagensEscolhidos.contains("Green")) {
							personagensEscolhidos.add(personagensEscolhidos.indexOf("Green")+1, "Peacock");
						}
						else if(personagensEscolhidos.contains("White")) {
							personagensEscolhidos.add(personagensEscolhidos.indexOf("White")+1, "Peacock");
						}
						else if(personagensEscolhidos.contains("Mustard")) {
							personagensEscolhidos.add(personagensEscolhidos.indexOf("Mustard")+1, "Peacock");
						}
						else {
							personagensEscolhidos.add(personagensEscolhidos.indexOf("Scarlet")+1, "Peacock");

						}
						
					}
					
					else {
						personagensEscolhidos.add(0,"Peacock");
					}
					
		        } else {//checkbox has been deselected
		        	qntPlayers-=1;
		        	personagensEscolhidos.remove("Peacock");
		        };
		    }
		});
		peacock.setBounds(3*(w/4), h/2 + 5*botaoH, w/4, botaoH);
		peacock.setFont(new Font("Serif", Font.BOLD, 20));
		peacock.setForeground(Color.BLACK);
		peacock.setBackground(Color.decode("#183980"));
		
		plum = new JCheckBox("Prof. Plum");
		panel.add(plum);
		plum.addItemListener(new ItemListener() {
		    @Override
		    public void itemStateChanged(ItemEvent e) {
		        if(e.getStateChange() == ItemEvent.SELECTED) {//checkbox has been selected
					personagensEscolhidos.add("Plum");
					qntPlayers+=1;
		        } else {//checkbox has been deselected
		        	qntPlayers-=1;
		        	personagensEscolhidos.remove("Plum");
		        };
		    }
		});
		plum.setBounds(3*(w/4), h/2 + 6*botaoH, w/4, botaoH);
		plum.setFont(new Font("Serif", Font.BOLD, 20));
		plum.setForeground(Color.BLACK);
		plum.setBackground(Color.decode("#4b293a"));
        
		setBackground(Color.decode("#f3cc95"));
        
        continuar.addActionListener((ActionListener) new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(!isBlocked) {
        			if(CtrlRegras.getInstance().checkQntPlayers(qntPlayers)) {
        				setVisible(false);
        				CtrlRegras.getInstance().initPlayers(personagensEscolhidos);
        				CtrlRegras.getInstance().iniciaJogo();
        				FrameTab f = new FrameTab();
        				f.setVisible(true);
        			}
        		}
        		
        	}
        });
        
	}
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
	}
}
		