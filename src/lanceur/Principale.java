package lanceur;

import java.awt.*;

import interface_plugin.PluginLayout;

import javax.swing.*;

import util.Configuration;

public class Principale {

	public static void main(String[] args) {
		JFrame fen = new JFrame("ObsTAPQuery");
		fen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fen.setIconImage(new ImageIcon(Configuration.PATH_TO_ICON).getImage());
		
		PluginLayout plugin = new PluginLayout();
		
		fen.setContentPane(plugin);
		fen.pack();
		fen.setVisible(true);
	}

}
