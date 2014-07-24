package lanceur;

import interface_plugin.PluginLayout;

import javax.swing.*;

import util.Configuration;

import cds.aladin.AladinException;
import cds.aladin.AladinPlugin;

public class LanceurAladin extends AladinPlugin{

	public String menu() { return "ObsTAP Query"; }
	public String description()   {
		return "ObsTAP Query:\n" +
				"-----------------------\n" +
				"It is a plug-in that allow you to perform ObsTAP queries " +
				"easily.";
	}
	public String author() { return "Mallory Marcot et François Bonnarel"; }
	public String version() { return "0.9 - July 2014"; }
	
	@Override
	public void exec() throws AladinException {
		JFrame fen = new JFrame("ObsTAP Query");
		fen.setIconImage(new ImageIcon(Configuration.PATH_TO_ICON).getImage());
		
		PluginLayout plug_lay = new PluginLayout(aladin);
		fen.setContentPane(plug_lay);
		fen.pack();
		fen.setVisible(true);
	}


}
