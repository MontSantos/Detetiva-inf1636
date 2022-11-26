package model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.lang.Math.*;

class Tabuleiro {
    private final static int TAMANHOX = 24;
    private final static int TAMANHOY = 25;
    private static Casa[][] casas = new Casa[TAMANHOX][TAMANHOY];
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
    
    public void movimenta(int vDados, Player jogador, Casa fim, int[] coord) {
    	Casa casaAtual = getCasa(getPos(jogador.getPin()));
    	int dist;
    	if(vDados>0) {
    		dist = Math.abs(casaAtual.getX() - fim.getX()) + Math.abs(casaAtual.getY() - fim.getY());
    		if(dist == 1) {
    			if(fim instanceof Casa && casaAtual instanceof Casa) {
    				if(fim.getJogador()==-5) {
    					if(fim.getPerc() == false) {
    						casaAtual.setPerc();
    						casaAtual.setJogador(-5);
    						jogador.setPosition(fim.getX(), fim.getY());
    						jogador.setCoordinates(coord[0], coord[1]);
    						fim.setJogador(jogador.getPin());
    					}
    				}
    			}
    			if(fim instanceof CasaComodo && casaAtual instanceof Casa) {
    				if(((CasaComodo) fim).getPorta()) {
    					jogador.setPosition(fim.getX(), fim.getY());
    				}
    			}
    			
    			if(fim instanceof Casa && casaAtual instanceof CasaComodo) {
    				
    			}
    		}
    	}
    	
    }
    
    // Para fazer a posi��o das casas no mapa
    public static void cria(){
    	int i;
    	int j;
    	
    	for(i = 0; i < TAMANHOY; i++) {
    		for(j = 0; j < TAMANHOX; j++) {
    			int bias = (24 * i) + j;
    			char c = table.charAt(bias);
    			//int teste = 0;
    			casas[j][i] = new Casa(j,i,-1);
    			//System.out.printf("%c", c);
    			switch(c) {
    				case 'k': 
    					CasaComodo tmp = new CasaComodo(); 
    					tmp.setSala(c);
    					tmp.setPass();
    					casas[j][i] = tmp;
    					break;
    					
    				case 'b': 
    					CasaComodo tmp1 = new CasaComodo(); 
    					tmp1.setSala(c);
    					casas[j][i] = tmp1;
    					break;
    				case 'c': 
    					CasaComodo tmp2 = new CasaComodo(); 
    					tmp2.setSala(c);
    					tmp2.setPass();
    					casas[j][i] = tmp2;
    					break;
    				case 'd': 
    					CasaComodo tmp3 = new CasaComodo(); 
    					tmp3.setSala(c);
    					casas[j][i] = tmp3;
    					break;
    				case 'l': 
    					CasaComodo tmp4 = new CasaComodo(); 
    					tmp4.setSala(c);
    					tmp4.setPass();
    					casas[j][i] = tmp4;
    					break;
    				case 'i' : 
    					CasaComodo tmp5 = new CasaComodo(); 
    					tmp5.setSala(c);
    					casas[j][i] = tmp5;
    					break;
    				case 'h': 
    					CasaComodo tmp6 = new CasaComodo(); 
    					tmp6.setSala(c);
    					casas[j][i] = tmp6;
    					break;
    				case 's': 
    					CasaComodo tmp7 = new CasaComodo(); 
    					tmp7.setSala(c);
    					tmp7.setPass();
    					casas[j][i] = tmp7;
    					break;
    				case 'o': 
    					CasaComodo tmp8 = new CasaComodo(); 
    					tmp8.setSala(c);
    					casas[j][i] = tmp8;
    					break;
    				case 'p':
    					CasaComodo tmp9 = new CasaComodo();
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
//    			if (teste == 1)
//    				continue;
    			//System.out.printf("%d", casas[j][i].getJogador());
    			}
    		//;;System.out.println();
    		}
    	}
    }