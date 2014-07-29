package fr.obs.view;

import javax.swing.*;


/**
 * Classe abstraite qui regroupe les caractéristiques communes à chaque
 * ligne du gestionnaire de contrainte
 * @author Mallory Marcot
 *
 */
public class AbstractLigne extends JPanel {
	
	protected boolean liaison;
	/** Combo box de la liaison */
	protected JComboBox combo_liaison;
	
	
	/**
	 * Permet d'enlever la liaison d'une ligne de contrainte
	 */
	public void enleverLiaison() {
		if(combo_liaison != null ) {
			if(liaison) {
				liaison = false;
			}
			remove(combo_liaison);
			revalidate();
		}
	}

}
