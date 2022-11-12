package model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

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
    
    	
    
    void movimenta(int [] vDados, Player jogador, Casa fim ) {
    	Casa casaAtual = getCasa(getPos(jogador.getPlayerId()));
    	Queue<Casa> fila = new LinkedList<>();
    	
    	casaAtual.setDistance(0);
    	fila.add(casaAtual);
    	
    	while(fila.size()>0) {
    		Casa casa = fila.remove();
    		if(casa == fim) {
    			if(casa.getDistance() == vDados[0]+vDados[1])
    				jogador.setCoordinates(casa.getX(), casa.getY());
    		}
    		for(Casa n : casa.getVizinhos()) {
    			if(n.getJogador() != -5) {
    				n.setDistance(casa.getDistance()+1);
    				fila.add(n);
    			}
    		}
    	}
    }
    
    void validaMovimento(int xIni, int yIni, int xFim, int yFim, int [] vDados, Player jogador) {
    	Casa dest = casas[xFim][yFim];
    	
    	if (xIni == xFim && yIni ==yFim) {
    		return;
    	}
    	
    	if(dest instanceof Casa) {
    		movimenta(vDados, jogador, dest);
    		return;
    	}
    	if(dest instanceof CasaComodo) {
    		if (((CasaComodo) dest).getPorta()) {
    			movimenta(vDados, jogador, dest);
    			return;
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
    			/*if (teste == 1)
    				continue;
    			System.out.printf("%d", casas[j][i].getJogador());*/
    			}
    		//System.out.println();
    		}
    	}
    }