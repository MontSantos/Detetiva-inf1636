package view;

import Controller.ObservadorIF;
import java.awt.*;

import javax.swing.JButton;

class FramePalpite extends FrameCheckList implements ObservadorIF{
	public FramePalpite () {
		super("Palpite de X");
		
	}
}