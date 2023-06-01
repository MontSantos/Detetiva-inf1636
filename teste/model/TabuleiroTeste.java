package model;
import static org.junit.Assert.*;

import model.Tabuleiro;

import org.junit.Test;

// Esse teste testa tanto o TABULEIRO quanto as classes CASA e CASACOMODO, por estarem interligadas.

public class TabuleiroTeste {

	@Test(timeout=5000) // Teste a inicializacao do mapa e peoes.
	public void testLocais() {
		Tabuleiro tab= new Tabuleiro();
		Tabuleiro.cria();
		int[] pos1 = {7,24};
		assertEquals("Erro Peao1",0, tab.getCasa(pos1).getJogador()); 
		int[] pos2 = {0,17};
		assertEquals("Erro Peao2",1,tab.getCasa(pos2).getJogador());
		int[] pos3 = {9,0};
		assertEquals("Erro Peao3",2, tab.getCasa(pos3).getJogador());
		int[] pos4 = {14,0};
		assertEquals("Erro Peao4",3, tab.getCasa(pos4).getJogador());
		int[] pos5 = {23,6};
		assertEquals("Erro Peao5",4, tab.getCasa(pos5).getJogador());
		int[] pos6 = {23,19};
		assertEquals("Erro Peao6",5,tab.getCasa(pos6).getJogador());
		int[] pos7 = {9,1};
		assertEquals("Erro CasaVazia",-5, tab.getCasa(pos7).getJogador());
		int[] pos8 = {8,0};
		assertEquals("Erro Parede",-20, tab.getCasa(pos8).getJogador());
	}
	
	@Test(timeout=5000) //achar porta
	public void testPorta() {
		Tabuleiro tab= new Tabuleiro();
		Tabuleiro.cria();
		int[] pos1 = {4,6};
		assertTrue("Porta nao encontrada", ((CasaComodo) tab.getCasa(pos1)).getPorta());
		int[] pos2 = {19,5};
		assertTrue("Porta nao encontrada", ((CasaComodo) tab.getCasa(pos2)).getPorta());
		int[] pos3 = {8,5};
		assertTrue("Porta nao encontrada", ((CasaComodo) tab.getCasa(pos3)).getPorta());
	}
	
	@Test(timeout=5000)// Identificar comodo
	public void testComodo() {
		Tabuleiro tab= new Tabuleiro();
		Tabuleiro.cria();
		int[] pos1 = {0, 1};
		assertEquals("Erro cozinha","Cozinha",((CasaComodo)tab.getCasa(pos1)).getSala());
		int[] pos2 = {12, 24};
		assertEquals("Erro hall","Entrada",((CasaComodo)tab.getCasa(pos2)).getSala());
	}

}
