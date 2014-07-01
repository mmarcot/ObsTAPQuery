package lanceur;

import interface_plugin.PluginLayout;

import javax.swing.*;

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
	public String author() { return "Mallory Marcot"; }
	public String version() { return "0.1 - June 2014"; }
	
	@Override
	public void exec() throws AladinException {
		JFrame fen = new JFrame("ObsTAP Query");
		
		PluginLayout plug_lay = new PluginLayout();
		
		fen.setContentPane(plug_lay);
		fen.pack();
		fen.setVisible(true);
	}


}
