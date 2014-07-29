package fr.obs.view;

import javax.swing.*;

import fr.obs.listener.AuditeurBoutonRemove;
import fr.obs.listener.AuditeurOperateurs;
import fr.obs.util.Configuration;
import fr.obs.util.Langage;


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
	private double ra, dec, rayon;
	private String unite_selected;
	
	
	/**
	 * Constructeur d'une ligne de position qui réalise une contrainte sur un cercle
	 * de centre x, y et de rayon donné
	 * @param liaison Liaison avec la ligne précédente (oui ou non)
	 * @param ra Abscisse du centre de la position
	 * @param dec Ordonnée du centre de la position
	 * @param rayon Rayon souhaité
	 * @param unite_selected Unité selectionnée dans la JComboBox
	 */
	public LigneDePosition(boolean liaison, double ra, double dec, double rayon, String unite_selected) {
		this.liaison = liaison;
		this.ra = ra;
		this.dec = dec;
		this.rayon = rayon;
		this.unite_selected = unite_selected;
		
		// Affichage éventuel de la liaison :
		if(liaison) {
			combo_liaison = new JComboBox(Configuration.TAB_LIAISONS);
			add(combo_liaison);
		}
		
		// affichage de l'abscisse, ordonnée et rayon :
		add(new JLabel(" "));
		add(new JLabel(Langage.getRA() + " : " + Double.toString(ra)));
		add(new JLabel("    "));
		add(new JLabel(Langage.getDEC() + " : " + Double.toString(dec)));
		add(new JLabel("    "));
		add(new JLabel(Langage.getRayon() + " : " + Double.toString(rayon)));
		add(new JLabel(unite_selected));
		add(new JLabel(" "));
		
		//JButton remove constraint :
		JButton but_remove = new JButton(Langage.getWhere_but_remove());
		but_remove.setToolTipText(Langage.getWhere_but_remove_tt());
		but_remove.addActionListener(new AuditeurBoutonRemove());
		add(but_remove);
	}
	
	
	/**
	 * Formatte la ligne pour pouvoir l'afficher directement dans la requete résultante
	 */
	@Override
	public String toString() {
		String ret = new String();
		
		// gestion le la liaison :
		if(liaison)
			ret += (String)combo_liaison.getSelectedItem() + " ";
		else
			ret += "WHERE ";
		
		// on met le rayon dans la bonne unité :
		if(unite_selected.equals(Langage.getArcmin()))
			rayon = rayon / 60;
		else if(unite_selected.equals(Langage.getArcsec()))
			rayon = rayon / 3600;
		
		// on convertit en String :
		String str_ra = Double.toString(ra);
		String str_dec = Double.toString(dec);
		String str_rayon = Double.toString(rayon);
		
		// on construit la chaine :
		ret += "CONTAINS(POINT('ICRS', ivoa.ObsCore.s_ra, ivoa.ObsCore.s_dec), CIRCLE('ICRS'," + 
				str_ra + ", " + str_dec + ", " + str_rayon + ")) = 1";
		
		
		return ret;
	}
	
	
}
