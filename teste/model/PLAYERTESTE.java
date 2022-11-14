package model;

import static org.junit.Assert.*;

import model.PLAYER;

import org.junit.Test;

public class PLAYERTESTE {

	@Test // Teste Criaçao de player
	public void test() {
		PLAYER teste= new PLAYER(3, "Scarlet", "red", 0);
		assertEquals(0, teste.getPin());
		assertEquals("Scarlet", teste.getNome());
		assertEquals("red", teste.getCor());
		assertEquals(3, teste.getplayerId());
	}

}
