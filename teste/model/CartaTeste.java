package model;

import static org.junit.Assert.*;

import model.Carta;

import org.junit.Test;

public class CartaTeste {

	@Test // Criaçao de cada tipo de carta
	public void testCarta() {
		CartaArma teste1= new CartaArma("Faca",2 );
		assertEquals("Erro ArmaId", 2, teste1.getCardId());
		assertEquals("Erro ArmaNome", "Faca", teste1.getNome());
		
		CartaComodo teste2= new CartaComodo("HALL",1 );
		assertEquals("Erro ComodoId", 1, teste2.getCardId());
		assertEquals("Erro ComodoNome", "HALL", teste2.getNome());
		
		CartaSuspeito teste3= new CartaSuspeito("Scarlet",0 );
		assertEquals("Erro SusId", 0, teste3.getCardId());
		assertEquals("Erro SusNome", "Scarlet", teste3.getNome());
		
	}

}
