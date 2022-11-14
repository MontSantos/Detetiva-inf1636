package model;

import static org.junit.Assert.*;

import model.CtrlRegras;

import org.junit.Test;

public class CtrlRegrasTESTE {

	@Test
	public void testNumero() {
		CtrlRegras teste=new CtrlRegras();
		assertFalse(teste.checkQntPlayers(2));
		assertTrue(teste.checkQntPlayers(5));
		assertFalse(teste.checkQntPlayers(8));
		
	}
	
}
