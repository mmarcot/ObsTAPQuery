package interface_plugin;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

import util.Configuration;

import metier.ColonnesObscore;
import metier.UnChampsObscore;


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
		ArrayList<UnChampsObscore> liste_col_str = ColonnesObscore.getColonnesObscore();
		
		// JLabel "Select" :
		JLabel lab_select = new JLabel("    Select");
		Font pol_select = new Font(Configuration.POLICE, Font.BOLD, 20);
		lab_select.setFont(pol_select);
		this.add(lab_select);
		
		// on transforme les String récupéré en JCheckBox et les ajoute
		// au JPanel select :
		for(UnChampsObscore champs : liste_col_str) {
			JCheckBox cb = new JCheckBox(champs.getName());
			this.liste_checkbox.add(cb);
			this.add(cb);
		}
	}
	
	
	
	/**
	 * Retourne les champs checked dans le select
	 * @return liste de String
	 */
	public ArrayList<String> getChecked() {
		ArrayList<String> checked = new ArrayList<String>();
		
		for(JCheckBox check_box : liste_checkbox) {
			if(check_box.isSelected()) 
				checked.add(check_box.getText());
		}
		
		return checked;
	}
	

}














