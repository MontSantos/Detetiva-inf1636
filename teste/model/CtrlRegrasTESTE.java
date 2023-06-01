package model;

import static org.junit.Assert.*;

import java.util.ArrayList;

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
	
	@Test
	public void testEstado() {
		CtrlRegras teste = new CtrlRegras();
		teste.setEstado(4);
		assertEquals(4, teste.getEstado());
		teste.setEstado(10);
		assertEquals(10, teste.getEstado());
		teste.setEstado(6);
		assertEquals(6, teste.getEstado());
		teste.setEstado(2);
		assertEquals(2, teste.getEstado());
	}
	
}
