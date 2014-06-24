package interface_plugin;

import java.awt.*;
import javax.swing.*;

import util.Configuration;


/**
 * JPanel qui contient l'ensemble de l'interface du plug-in Aladin
 * @author Mallory Marcot
 *
 */
public class PluginLayout extends JPanel {

	/**
	 * Constructeur de l'interface principal
	 */
	public PluginLayout() {
		this.setPreferredSize(new Dimension(Configuration.LARGEUR_PLUGIN_PX, Configuration.HAUTEUR_PLUGIN_PX));
		this.setLayout(new BorderLayout());
		
		Select pan_select = new Select();
		JScrollPane scroller = new JScrollPane(pan_select);
		this.add(scroller,BorderLayout.CENTER);
		
		PanneauDroite pan_droite = new PanneauDroite();
		
		this.add(scroller, BorderLayout.LINE_START);
		this.add(pan_droite, BorderLayout.CENTER);
	}
}