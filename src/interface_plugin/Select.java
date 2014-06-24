package interface_plugin;

import java.awt.*;
import javax.swing.*;

import util.Configuration;


/**
 * Classe JPanel qui représente le select (vue) à gauche
 * @author Mallory Marcot
 *
 */
public class Select extends JPanel {
	
	/**
	 * Constructeur de la vue sur le select
	 */
	public Select() {
		this.setBackground(Color.red);
		this.setPreferredSize(new Dimension(Configuration.LARGEUR_SELECT_PX, Configuration.HAUTEUR_SELECT_PX));
	}
	

}
