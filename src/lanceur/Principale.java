package lanceur;

import interface_plugin.PluginLayout;

import javax.swing.*;

public class Principale {

	public static void main(String[] args) {
		JFrame fen = new JFrame("ObsTAPQuery");
		fen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		PluginLayout plugin = new PluginLayout();
		
		fen.setContentPane(plugin);
		fen.pack();
		fen.setVisible(true);
	}

}
