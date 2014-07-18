package interface_plugin;

import javax.swing.*;

import listeners.AuditeurBoutonRemove;
import listeners.AuditeurOperateurs;
import util.Configuration;
import util.Langage;


/**
 * Classe qui modélise une ligne de position dans le gestionnaire de 
 * contraintes
 * @author Mallory Marcot
 *
 */
public class LigneDePosition extends AbstractLigne {
	
	private boolean liaison;
	/** Combo box de la liaison */
	private JComboBox combo_liaison;
	
	
	/**
	 * Constructeur d'une ligne de position qui réalise une contrainte sur un cercle
	 * de centre x, y et de rayon donné
	 * @param liaison Liaison avec la ligne précédente (oui ou non)
	 * @param x Abscisse du centre de la position
	 * @param y Ordonnée du centre de la position
	 * @param rayon Rayon souhaité
	 */
	public LigneDePosition(boolean liaison, double x, double y, double rayon) {
		this.liaison = liaison;
		
		// Affichage éventuel de la liaison :
		if(liaison) {
			combo_liaison = new JComboBox(Configuration.TAB_LIAISONS);
			add(combo_liaison);
		}
		
		// affichage de l'abscisse, ordonnée et rayon :
		add(new JLabel(Langage.getAbscisse() + " : " + Double.toString(x)));
		add(new JLabel("    "));
		add(new JLabel(Langage.getOrdonnee() + " : " + Double.toString(y)));
		add(new JLabel("    "));
		add(new JLabel(Langage.getRayon() + " : " + Double.toString(rayon)));
		add(new JLabel("  "));
		
		//JButton remove constraint :
		JButton but_remove = new JButton(Langage.getWhere_but_remove());
		but_remove.setToolTipText(Langage.getWhere_but_remove_tt());
		but_remove.addActionListener(new AuditeurBoutonRemove());
		add(but_remove);
	}
	
	
}
