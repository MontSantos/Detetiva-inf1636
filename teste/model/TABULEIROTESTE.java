package model;
import static org.junit.Assert.*;

import model.TABULEIRO;

import org.junit.Test;

// Esse teste testa tanto o TABULEIRO quanto as classes CASA e CASACOMODO, por estarem interligadas.

public class TABULEIROTESTE {

	@Test(timeout=5000) // Teste a inicializacao do mapa e peoes.
	public void testLocais() {
		TABULEIRO tab= new TABULEIRO();
		CASA[][] casas= TABULEIRO.cria();
		assertEquals("Erro Peao1",0,casas[7][24].getJogador()); 
		assertEquals("Erro Peao2",1,casas[0][7].getJogador());
		assertEquals("Erro Peao3",2,casas[9][0].getJogador());
		assertEquals("Erro Peao4",3,casas[14][0].getJogador());
		assertEquals("Erro Peao5",4,casas[23][6].getJogador());
		assertEquals("Erro Peao6",5,casas[23][19].getJogador());
		assertEquals("Erro CasaVazia",-5,casas[9][1].getJogador());
		assertEquals("Erro Parede",-20,casas[8][0].getJogador());
	}
	
	@Test(timeout=5000) //achar porta
	public void testPorta() {
		TABULEIRO tab= new TABULEIRO();
		CASA[][] casas= TABULEIRO.cria();
		assertTrue("Porta nao encontrada", ((CASACOMODO)casas[4][6]).getPorta());
		assertTrue("Porta nao encontrada", ((CASACOMODO)casas[19][5]).getPorta());
		assertTrue("Porta nao encontrada", ((CASACOMODO)casas[8][5]).getPorta());
	}
	
	@Test(timeout=5000)// Identificar comodo
	public void testComodo() {
		TABULEIRO tab= new TABULEIRO();
		CASA[][] casas= TABULEIRO.cria();
		assertEquals("Erro cozinha",SALA.KITCHEN,((CASACOMODO)casas[0][0]).getSala());
		assertEquals("Erro hall",SALA.HALL,((CASACOMODO)casas[12][24]).getSala());
	}

}
