package interface_plugin;

import java.awt.Color;

import javax.swing.*;

import metier.ColonnesObscore;

/**
 * Classe qui modélise une unique contrainte du gestionnaire 
 * @author Mallory Marcot
 *
 */
public class LigneDeContrainte extends JPanel {
	
	/**
	 * Constructeur d'une ligne de contrainte 
	 */
	public LigneDeContrainte() {
		this.setBackground(Color.white);
		
		this.setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
		
		// JComboBox colonnes obscore :
		JComboBox combo_col_obs = new JComboBox(ColonnesObscore.getColonnesObscore().toArray());
		this.add(combo_col_obs);
		
		// JComboBox opérateurs :
		String[] tab_oper = {"=", "!=", "<", ">", "<=", ">="};
		JComboBox combo_oper = new JComboBox(tab_oper);
		this.add(combo_oper);
		
		// JTextField valeur :
		JTextField text_valeur = new JTextField(15);
		this.add(text_valeur);
	}

}
