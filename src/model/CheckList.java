package model;

import java.util.ArrayList;

class CheckList {
	private ArrayList<Armas> arma;
	private ArrayList<Suspeitos> sus;
	private ArrayList<Sala> sala;
	
	public void addCheck(String S, int tipo) {
		if (tipo == 0) {
			switch (S) {
				case "scarlet": {
					sus.add(Suspeitos.SCARLET);
					break;
				}
				case "mustard": {
					sus.add(Suspeitos.MUSTARD);
					break;
				}
				case "white": {
					sus.add(Suspeitos.WHITE);
					break;
				}
				case "green": {
					sus.add(Suspeitos.GREEN);
					break;
				}
				case "peacock": {
					sus.add(Suspeitos.PEACOCK);
					break;
				}
				case "plum":
					sus.add(Suspeitos.PLUM);
					break;
			}
		} else if (tipo == 1) {
			switch (S) {
				case "castical": {
					arma.add(Armas.CASTICAL);
					break;
				}
				case "revolver": {
					arma.add(Armas.REVOLVER);
					break;
				}
				case "faca": {
					arma.add(Armas.FACA);
					break;
				}
				case "cano": {
					arma.add(Armas.CANO);
					break;
				}
				case "corda": {
					arma.add(Armas.CORDA);
					break;
				}
				case "plum":
					arma.add(Armas.CHAVE);
					break;
			}
		} else {
			switch (S) {
				case "jantar": {
					sala.add(Sala.DININGROOM);
					break;
				}
				case "entrada": {
					sala.add(Sala.HALL);
					break;
				}
				case "jogos": {
					sala.add(Sala.BILLIARDROOM);
					break;
				}
				case "cozinha": {
					sala.add(Sala.KITCHEN);
					break;
				}
				case "biblioteca": {
					sala.add(Sala.LIBRARY);
					break;
				}
				case "estar": {
					sala.add(Sala.LOUNGE);
					break;
				}
				case "musica": {
					sala.add(Sala.BALLROOM);
					break;
				}
				case "escritorio": {
					sala.add(Sala.STUDY);
					break;
				}
				case "jardim": {
					sala.add(Sala.CONSERVATORY);
					break;
				}
			}
		}
	}
}
