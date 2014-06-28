package interface_plugin;

import java.awt.*;
import javax.swing.*;


/**
 * Classe JPanel qui représente la partie de droite du plug-in (where et requete)
 * @author Mallory Marcot
 *
 */
public class PanneauDroite extends JPanel {

	private Where pan_where;
	private Requete pan_requete;
	/**
	 * Contructeur du panneau de droite
	 */
	public PanneauDroite() {
		this.setBackground(Color.blue);
		this.setLayout(new GridLayout(2, 1));
		
		pan_where = new Where();
		pan_requete = new Requete();
		
		this.add(pan_where);
		this.add(pan_requete);
	}
	
	
	/**
	 * @return the pan_where
	 */
	public Where getWhere() {
		return pan_where;
	}
	
	
	/**
	 * @return the pan_requete
	 */
	public Requete getRequete() {
		return pan_requete;
	}
}
