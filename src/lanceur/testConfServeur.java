package lanceur;

import interface_plugin.PanneauConfServeur;

import java.awt.*;

import javax.swing.*;

import util.Langage;

public class testConfServeur {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		JFrame fen = new JFrame("Test serveur url");
		
		PanneauConfServeur pan_conf = new PanneauConfServeur();
		
		fen.setContentPane(pan_conf);
		fen.pack();
		fen.setVisible(true);
		fen.setLocationRelativeTo(null);
	}

}
