package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;

import Controller.ObservadorIF;

class FrameAcusacao extends FrameCheckList implements ObservadorIF{
	public FrameAcusacao () {
		super("Acusacao de X");
	}
}