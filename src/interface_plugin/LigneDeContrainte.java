package interface_plugin;

import java.awt.*;
import javax.swing.*;

import util.Configuration;
import util.Langage;

import metier.ColonnesObscore;

/**
 * Classe qui modélise une unique contrainte du gestionnaire 
 * @author Mallory Marcot
 *
 */
public class LigneDeContrainte extends JPanel {
	
	private boolean operateurDeLiaison;
	
	/**
	 * Constructeur d'une ligne de contrainte 
	 * @param liaison Liaison avec la contrainte précédente (AND ou OR)
	 */
	public LigneDeContrainte(boolean liaison) {
		this.operateurDeLiaison = liaison;
		
		// Affichage éventuel de la liaison :
		if(operateurDeLiaison) {
			JComboBox combo_liaison = new JComboBox(Configuration.TAB_LIAISONS);
			this.add(combo_liaison);
		}
		
		// JComboBox colonnes obscore :
		JComboBox combo_col_obs = new JComboBox(ColonnesObscore.getColonnesObscore().toArray());
		this.add(combo_col_obs);
		
		// JComboBox opérateurs :
		JComboBox combo_oper = new JComboBox(Configuration.TAB_OPERATEURS_WHERE);
		this.add(combo_oper);
		
		// JTextField valeur :
		JTextField text_valeur = new JTextField(15);
		this.add(text_valeur);
		
		// JLabel espacement :
		JLabel lab_esp = new JLabel("   ");
		this.add(lab_esp);
		
		//JButton remove constraint :
		JButton but_remove = new JButton(Langage.getWhere_but_remove());
		but_remove.setToolTipText(Langage.getWhere_but_remove_tt());
		this.add(but_remove);
	}

}
