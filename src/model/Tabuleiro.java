package model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.lang.Math.*;

class Tabuleiro {
    private final static int TAMANHOX = 24;
    private final static int TAMANHOY = 25;
    private static Casa[][] casas = new Casa[TAMANHOX][TAMANHOY];
    private boolean moveu = false;
    private static String table = 
              "vvvvvvvvvwbbbbgvvvvvvvvv"
            + "kkkkkkvqqqbbbbqqqvcccccc"
            + "kkkkkkqqbbbbbbbbqqcccccc"
            + "kkkkkkqqbbbbbbbbqqcccccc"
            + "kkkkkkqqbbbbbbbbqqcccccc"
            + "kkkkkkqqpbbbbbbpqqqpcccv"
            + "vkkkpkqqbbbbbbbbqqqqqqqz"
            + "vqqqqqqqbpbbbbpbqqqqqqqv"
            + "vqqqqqqqqqqqqqqqqqiiiiii"
            + "dddddqqqqqqqqqqqqqpiiiii"
            + "ddddddddqqvvvvvqqqiiiiii"
            + "ddddddddqqvvvvvqqqiiiiii"
            + "dddddddpqqvvvvvqqqiiiipi"
            + "ddddddddqqvvvvvqqqqqqqqv"
            + "ddddddddqqvvvvvqqqoopoov"
            + "ddddddpdqqvvvvvqqooooooo"
            + "vqqqqqqqqqvvvvvqqpoooooo"
            + "yqqqqqqqqqqqqqqqqooooooo"
            + "vqqqqqqqqhhpphhqqqooooov"
            + "llllllpqqhhhhhhqqqqqqqqx"
            + "lllllllqqhhhhhpqqqqqqqqv"
            + "lllllllqqhhhhhhqqpssssss"
            + "lllllllqqhhhhhhqqsssssss"
            + "lllllllqqhhhhhhqqsssssss"
            + "llllllvrvhhhhhhvqvssssss";
    
    // Vai procurar a posição do peão
    public int[] getPos(int x) {
    	int[] pos = new int[2];
    	for(int i = 0; i < TAMANHOY; i++) {
    		for(int j = 0; j < TAMANHOX; j++) {
    			if(casas[j][i].getJogador() == x) {
    				pos[0] = j;
    				pos[1] = i;
    				return pos;
    			}
    		}
    	}
    	return pos;
    }
    
    // Casa onde o peão está no momento
    public Casa getCasa(int[] x) {
    	return casas[x[0]][x[1]];
    }  
    
    public void setJogadorCasa(int[] pos, int pin) {
    	casas[pos[0]][pos[1]].setJogador(pin);
    }
    
    public boolean estaEmComodo(int[] x) {
    	if(casas[x[0]][x[1]] instanceof CasaComodo) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    
    public String getComodo(int[] pos) {
    	return ((CasaComodo)casas[pos[0]][pos[1]]).getSala();
    }
    
    public void movimentaSecreta(Player jogador) {
    	Casa casaAtual = getCasa(getPos(jogador.getPin()));
    	String nomeSala = ((CasaComodo) casaAtual).getSala();
    	
    	if(((CasaComodo)casaAtual).getPass()) {
        	switch(nomeSala) {
        	
        	case "Cozinha":
            	for(int i = 0; i < TAMANHOY; i++) {
            		for(int j = 0; j < TAMANHOX; j++) {
            			if(casas[j][i] instanceof CasaComodo)
	            			if(((CasaComodo)casas[j][i]).getSala() == "Escritório") {
	            				if(casas[j][i].getJogador() == -5) {
	            					casas[jogador.getPawnPosition()[0]][jogador.getPawnPosition()[1]].setJogador(-5);
	            					jogador.setPosition(j, i);
	            					jogador.setCoordinates((j+1)*24, (i+1)*24);
	            					casas[j][i].setJogador(jogador.getPin());	
	            					break;
	            				}
	            			}
            			}
            		}

        		break;
        		
        	case "Jardim de Inverno":
            	for(int i = 0; i < TAMANHOY; i++) {
            		for(int j = 0; j < TAMANHOX; j++) {
            			if(casas[j][i] instanceof CasaComodo) {
	            			if(((CasaComodo)casas[j][i]).getSala() == "Sala de Estar") {
	            				if(casas[j][i].getJogador() == -5) {
	            					casas[jogador.getPawnPosition()[0]][jogador.getPawnPosition()[1]].setJogador(-5);
	            					jogador.setPosition(j, i);
	            					jogador.setCoordinates((j+1)*24, (i+1)*23);
	            					casas[j][i].setJogador(jogador.getPin());
	            					break;
	            				}
	            			}
            			}
            		}
            	}
            	
        		break;
        		
        	case "Sala de Estar":
            	for(int i = 0; i < TAMANHOY; i++) {
            		for(int j = 0; j < TAMANHOX; j++) {
            			if(casas[j][i] instanceof CasaComodo) {
	            			if(((CasaComodo)casas[j][i]).getSala() == "Jardim de Inverno") {
	            				if(casas[j][i].getJogador() == -5) {
	            					casas[jogador.getPawnPosition()[0]][jogador.getPawnPosition()[1]].setJogador(-5);
	            					jogador.setPosition(j, i);
	            					jogador.setCoordinates((j+1)*24, (i+1)*26);
	            					casas[j][i].setJogador(jogador.getPin());	
	            					break;
	            				}
	            			}
            			}
            		}
            	}
            	
        		break;
        		
        	case "Escritório":
            	for(int i = 0; i < TAMANHOY; i++) {
            		for(int j = 0; j < TAMANHOX; j++) {
            			if(casas[j][i] instanceof CasaComodo) {
	            			if(((CasaComodo)casas[j][i]).getSala() == "Cozinha") {
	            				if(casas[j][i].getJogador() == -5) {
	            					casas[jogador.getPawnPosition()[0]][jogador.getPawnPosition()[1]].setJogador(-5);
	            					jogador.setPosition(j, i);
	            					jogador.setCoordinates((j+1)*24, (i+1)*26);
	            					casas[j][i].setJogador(jogador.getPin());	
	            					break;
	            				}
	            			}
            			}
            		}
            	}
            	
        		break;
        	}
    	}
    		
    }
    
    public void movimenta(int vDados, Player jogador, int[] posFim, int[] coord) {
    	Casa casaAtual = getCasa(getPos(jogador.getPin()));
    	ArrayList<CasaComodo> Portas = new ArrayList<CasaComodo>();
    	
    	int xFim = posFim[0];
    	int yFim = posFim[1];
    	int dist;
    	
    	if(vDados>0) {
    		
			if(casas[xFim][yFim] instanceof Casa && casaAtual instanceof CasaComodo) {
				String nomeSala = ((CasaComodo) casaAtual).getSala();
		    	for(int i = 0; i < TAMANHOY; i++) {
		    		for(int j = 0; j < TAMANHOX; j++) {
		    			if(casas[j][i] instanceof CasaComodo) {
		    				if(((CasaComodo)casas[j][i]).getSala()== nomeSala) {
		    					if(((CasaComodo)casas[j][i]).getPorta()) {
		    						Portas.add((CasaComodo) casas[j][i]);
		    					}
		    				}
		    			}
		    		}
		    		setMoveu();
		    	}
		    	
		    	for(CasaComodo porta: Portas) {
		    		if((Math.abs(porta.getX() - xFim) + Math.abs(porta.getY() - yFim)) == 1) {
		    			if(casas[xFim][yFim].getJogador() == -5) {
		    				jogador.setPosition(xFim, yFim);
		    				jogador.setCoordinates(coord[0], coord[1]);
		    				casas[xFim][yFim].setJogador(jogador.getPin());
		    				casaAtual.setJogador(-5);
		    				setMoveu();
		    			}
						
						return;
		    		}
		    	}
			}
			
			dist = Math.abs(casaAtual.getX() - xFim) + Math.abs(casaAtual.getY() - yFim);
			
    		if(dist == 1) {
    			
    			if(casas[xFim][yFim] instanceof CasaComodo && casaAtual instanceof Casa) {
    				String nomeSala = ((CasaComodo) casas[xFim][yFim]).getSala();
    				if(((CasaComodo) casas[xFim][yFim]).getPorta()) {
    	            	for(int i = 0; i < TAMANHOY; i++) {
    	            		for(int j = 0; j < TAMANHOX; j++) {
    	            			if(casas[j][i] instanceof CasaComodo) {
	    	            			if(((CasaComodo)casas[j][i]).getSala() == nomeSala) {
	    	            				if(casas[j][i].getJogador() == -5) {
	    	            					jogador.setPosition(j, i);
	    	            					jogador.setCoordinates((j+1)*24, (i+1)*25);
	    	            					casaAtual.setJogador(-5);
	    	            					casas[j][i].setJogador(jogador.getPin());	
	    	            					setMoveu();
	    	            					return;
	    	            				}
	    	            			}
    	            			}
    	            		}
    	            	}
    				}
    			}
    			
    			if(casas[xFim][yFim] instanceof Casa && casaAtual instanceof Casa) {
    				if(casas[xFim][yFim].getJogador()==-5) {
    					if(casas[xFim][yFim].getPerc() == false) {
    						casaAtual.setPerc();
    						casaAtual.setJogador(-5);
    						jogador.setPosition(xFim, yFim);
    						jogador.setCoordinates(coord[0], coord[1]);
    						casas[xFim][yFim].setJogador(jogador.getPin());
    						setMoveu();
    						return;
    					}
    				}
    			}
    			
    			
    		}
    	}
    	
    }
    
    public void movimentaPalpite(String nomeSala, Player acusado) {
    	for(int i = 0; i < TAMANHOY; i++) {
    		for(int j = 0; j < TAMANHOX; j++) {
    			if(casas[j][i] instanceof CasaComodo) {
        			if(((CasaComodo)casas[j][i]).getSala() == nomeSala) {
        				if(casas[j][i].getJogador() == -5) {
        					acusado.setPosition(j, i);
        					acusado.setCoordinates((j+1)*24, (i+1)*25);
        					getCasa(getPos(acusado.getPin())).setJogador(-5);
        					casas[j][i].setJogador(acusado.getPin());	
        					return;
        				}
        			}
    			}
    		}
    	}
		
    }
    
    public void movimentaPalpitePeao(String nomeSala, Pawn acusado) {
    	for(int i = 0; i < TAMANHOY; i++) {
    		for(int j = 0; j < TAMANHOX; j++) {
    			if(casas[j][i] instanceof CasaComodo) {
        			if(((CasaComodo)casas[j][i]).getSala() == nomeSala) {
        				if(casas[j][i].getJogador() == -5) {
        					acusado.setPosition(j, i);
        					acusado.setCoordinates((j+1)*24, (i+1)*25);
        					getCasa(getPos(acusado.getPawnNumber())).setJogador(-5);
        					casas[j][i].setJogador(acusado.getPawnNumber());	
        					return;
        				}
        			}
    			}
    		}
    	}
		
    }
    
    public void resetaPassagem() {
    	for(int i = 0; i < TAMANHOY; i++) {
    		for(int j = 0; j < TAMANHOX; j++) {
    			if(casas[j][i].getPerc()) {
    				casas[j][i].setPerc();
    			}
    		}
    	}
    }
    
    public boolean getMoveu(){
    	return moveu;
    }
    
    public void setMoveu() {
    	this.moveu = !moveu;
    }
    
    public void tabReseta() {
		for(int i = 0; i < TAMANHOY; i++) {
    		for(int j = 0; j < TAMANHOX; j++) {
    			if(casas[j][i].getJogador()!= -5 && casas[j][i].getJogador()!= -20) {
    				casas[j][i].setJogador(-5);
    			}
    		}
    	}
    }
    
//    public void printTab() {
//    	for(int i = 0; i < TAMANHOY; i++) {
//    		for(int j = 0; j < TAMANHOX; j++) {
//    			System.out.printf("%d ", casas[j][i].getJogador());
//
//    		}
//    		System.out.printf("\n");
//    	}
//    	
//    	System.out.printf("\n");
//    }

    
    // Para fazer a posi��o das casas no mapa
    public static void cria(){
    	int i;
    	int j;
    	
    	for(i = 0; i < TAMANHOY; i++) {
    		for(j = 0; j < TAMANHOX; j++) {
    			int bias = (24 * i) + j;
    			char c = table.charAt(bias);
    			//int teste = 0;
    			casas[j][i] = new Casa(j,i);
    			//System.out.printf("%c", c);
    			switch(c) {
    				case 'k': 
    					CasaComodo tmp = new CasaComodo(j,i); 
    					tmp.setSala(c);
    					tmp.setPass();
    					casas[j][i] = tmp;
    					break;
    					
    				case 'b': 
    					CasaComodo tmp1 = new CasaComodo(j,i); 
    					tmp1.setSala(c);
    					casas[j][i] = tmp1;
    					break;
    				case 'c': 
    					CasaComodo tmp2 = new CasaComodo(j,i); 
    					tmp2.setSala(c);
    					tmp2.setPass();
    					casas[j][i] = tmp2;
    					break;
    				case 'd': 
    					CasaComodo tmp3 = new CasaComodo(j,i); 
    					tmp3.setSala(c);
    					casas[j][i] = tmp3;
    					break;
    				case 'l': 
    					CasaComodo tmp4 = new CasaComodo(j,i); 
    					tmp4.setSala(c);
    					tmp4.setPass();
    					casas[j][i] = tmp4;
    					break;
    				case 'i' : 
    					CasaComodo tmp5 = new CasaComodo(j,i); 
    					tmp5.setSala(c);
    					casas[j][i] = tmp5;
    					break;
    				case 'h': 
    					CasaComodo tmp6 = new CasaComodo(j,i); 
    					tmp6.setSala(c);
    					casas[j][i] = tmp6;
    					break;
    				case 's': 
    					CasaComodo tmp7 = new CasaComodo(j,i); 
    					tmp7.setSala(c);
    					tmp7.setPass();
    					casas[j][i] = tmp7;
    					break;
    				case 'o': 
    					CasaComodo tmp8 = new CasaComodo(j,i); 
    					tmp8.setSala(c);
    					casas[j][i] = tmp8;
    					break;
    				case 'p':
    					CasaComodo tmp9 = new CasaComodo(j,i);
    					tmp9.setPorta();
    					if (table.charAt(bias-1) != 'q' && table.charAt(bias-1) != 'v' && table.charAt(bias-1) != 'p')
    						tmp9.setSala(table.charAt(bias-1));
    					else if (table.charAt(bias+1) != 'q' && table.charAt(bias+1) != 'v' && table.charAt(bias+1) != 'p')
    						tmp9.setSala(table.charAt(bias+1));
    					else if (table.charAt(bias-24) != 'q' && table.charAt(bias-24) != 'v' && table.charAt(bias-24) != 'p')
    						tmp9.setSala(table.charAt(bias-24));
    					else if (table.charAt(bias+24) != 'q' && table.charAt(bias+24) != 'v' && table.charAt(bias+24) != 'p') 
    						tmp9.setSala(table.charAt(bias+24));
    					casas[j][i] = tmp9;
    					tmp9.setPass();
    					/*teste = 1;
    					System.out.printf("%s", ((CasaComodo) casas[j][i]).getSala());*/
    					
    					break;
    				case 'v':
    					casas[j][i].setJogador(-20);
    					break;
    				case 'r':
    					casas[j][i].setJogador(0);
    					break;
    				case 'y':
    					casas[j][i].setJogador(1);
    					break;
    				case 'w':
    					casas[j][i].setJogador(2);
    					break;
    				case 'g':
    					casas[j][i].setJogador(3);
    					break;
    				case 'z':
    					casas[j][i].setJogador(4);
    					break;
    				case 'x':
    					casas[j][i].setJogador(5);
    					break;
    					}

    			}
    		}
    	}
    }