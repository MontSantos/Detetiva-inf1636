package view;

import Controller.ObservadorIF;

class FrameBloco extends FrameCheckList implements ObservadorIF{
	public FrameBloco () {
		super("Bloco de notas de X", 0);
	}
}