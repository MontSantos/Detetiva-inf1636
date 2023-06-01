package model;

import static org.junit.Assert.*;

import model.Carta;

import org.junit.Test;

public class CartaTeste {

	@Test // Cria�ao de cada tipo de carta
	public void testCarta() {
		Carta teste1= new Carta("Faca",2 );
		assertEquals("Erro ArmaId", 2, teste1.getTipo());
		assertEquals("Erro ArmaNome", "Faca", teste1.getNome());
		
		Carta teste2= new Carta("HALL",1 );
		assertEquals("Erro ComodoId", 1, teste2.getTipo());
		assertEquals("Erro ComodoNome", "HALL", teste2.getNome());
		
		Carta teste3= new Carta("Scarlet",0 );
		assertEquals("Erro SusId", 0, teste3.getTipo());
		assertEquals("Erro SusNome", "Scarlet", teste3.getNome());
		
	}

}
