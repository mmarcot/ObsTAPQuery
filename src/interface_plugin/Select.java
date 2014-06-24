package interface_plugin;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.*;

import util.Configuration;

import metier.ColonnesObscore;


/**
 * Classe JPanel qui représente le select (vue) à gauche
 * @author Mallory Marcot
 *
 */
public class Select extends JPanel {
	
	private ArrayList<JCheckBox> liste_checkbox;
	
	/**
	 * Constructeur de la vue sur le select
	 */
	public Select() {
		this.liste_checkbox = new ArrayList<JCheckBox>();
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		this.afficherColonnesObscore();
	}
	
	
	/**
	 * Methode qui va charger et afficher les champs obscore dans le select
	 */
	private void afficherColonnesObscore() {
		ArrayList<String> liste_col_str = ColonnesObscore.getColonnesObscore();
		Collections.sort(liste_col_str);
		
		// JLabel "Select" :
		JLabel lab_select = new JLabel("    Select");
		Font pol_select = new Font(Configuration.POLICE, Font.BOLD, 20);
		lab_select.setFont(pol_select);
		this.add(lab_select);
		
		// on transforme les String récupéré en JCheckBox et les ajoute
		// au JPanel select :
		for(String col_str : liste_col_str) {
			JCheckBox cb = new JCheckBox(col_str);
			this.liste_checkbox.add(cb);
			this.add(cb);
		}
	}
	

}
