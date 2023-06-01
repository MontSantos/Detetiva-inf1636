package model;

import static org.junit.Assert.*;

import model.Player;

import org.junit.Test;

public class PlayerTeste {

	@Test // Teste Cria�ao de player
	public void test() {
		Player teste= new Player(0,"r",  "Srta. Scarlet", 0);
		assertEquals(0, teste.getPin());
		assertEquals("Srta. Scarlet", teste.getNome());
		assertEquals("r", teste.getCor());
		assertEquals(0, teste.getPlayerId());
		teste.setCoordinates(20, 14);
		assertEquals(20, teste.getPawnCoordinates()[0]);
		assertEquals(14, teste.getPawnCoordinates()[1]);

		Player teste2= new Player(3,"g",  "Rev. Green", 3);
		assertEquals(3, teste2.getPin());
		assertEquals("Rev. Green", teste2.getNome());
		assertEquals("g", teste2.getCor());
		assertEquals(3, teste2.getPlayerId());
		teste2.setSaiuDoJogo();
		assertEquals(true, teste2.getSaiuDoJogo());
		
		Player teste3= new Player(1,"y",  "Col. Mustard", 1);
		assertEquals(1, teste3.getPin());
		assertEquals("Col. Mustard", teste3.getNome());
		assertEquals("y", teste3.getCor());
		assertEquals(1, teste3.getPlayerId());
		teste3.setPosition(20, 14);
		assertEquals(20, teste3.getPawnPosition()[0]);
		assertEquals(14, teste3.getPawnPosition()[1]);
		
		Player teste4= new Player(2,"w",  "Sra. White", 2);
		assertEquals(2, teste4.getPin());
		assertEquals("Sra. White", teste4.getNome());
		assertEquals("w", teste4.getCor());
		assertEquals(2, teste4.getPlayerId());
	}

}
