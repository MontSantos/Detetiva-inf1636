package model;

import static org.junit.Assert.*;

import model.Dado;

import org.junit.Test;

public class DADOTESTE {

	@Test // teste cria�ao e rolagem de dado
	public void test() {
		Dado teste= new Dado();
		teste.jogaDado();
		boolean x = (teste.getDado()>0||teste.getDado()<7);
		boolean y = (teste.getDado()>0||teste.getDado()<7);
		assertTrue("Erro no dado 1",x);
		assertTrue("Erro no dado 2",y);
	}

}
