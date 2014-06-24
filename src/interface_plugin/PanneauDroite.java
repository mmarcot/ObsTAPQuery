package interface_plugin;

import java.awt.*;
import javax.swing.*;


/**
 * Classe JPanel qui représente la partie de droite du plug-in (where et requete)
 * @author Mallory Marcot
 *
 */
public class PanneauDroite extends JPanel {

	/**
	 * Contructeur du panneau de droite
	 */
	public PanneauDroite() {
		this.setBackground(Color.blue);
		this.setLayout(new GridLayout(2, 1));
		
		Where pan_where = new Where();
		Requete pan_requete = new Requete();
		
		this.add(pan_where);
		this.add(pan_requete);
	}
}
