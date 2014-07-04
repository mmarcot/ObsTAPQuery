package interface_plugin;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

import util.Configuration;
import util.Langage;

import listeners.AuditeurCheckSelectAll;
import listeners.AuditeurCheckboxColObs;
import metier.ColonnesObscore;
import metier.UnChampsObscore;


/**
 * Classe JPanel qui représente le select (vue) à gauche
 * @author Mallory Marcot
 *
 */
public class Select extends JPanel {
	
	private ArrayList<JCheckBox> liste_checkbox;
	private JCheckBox cb_select_all;
	
	/**
	 * Constructeur de la vue sur le select
	 */
	public Select() {
		this.liste_checkbox = new ArrayList<JCheckBox>();
		
		// JLabel "Select" :
		JLabel lab_select = new JLabel("    Select");
		Font pol_select = new Font(Configuration.POLICE, Font.BOLD, 20);
		lab_select.setFont(pol_select);
		this.add(lab_select);
		
		// JCheckBox select all :
		this.cb_select_all = new JCheckBox(Langage.getSelect_all());
		cb_select_all.addActionListener(new AuditeurCheckSelectAll());
		this.add(cb_select_all);
		
		// JLabel separateur :
		this.add(new JLabel(" "));
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		this.afficherColonnesObscore();
	}
	
	
	/**
	 * Methode qui va charger et afficher les champs obscore dans le select
	 */
	private void afficherColonnesObscore() {
		ArrayList<UnChampsObscore> liste_col_str = ColonnesObscore.getColonnesObscore();
		
		// on transforme les String récupéré en JCheckBox et les ajoute
		// au JPanel select :
		for(UnChampsObscore champs : liste_col_str) {
			JCheckBox cb = new JCheckBox(champs.getName());
			cb.addActionListener(new AuditeurCheckboxColObs());
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
	
	
	/**
	 * Methode qui va décocher toutes les check box dans le select
	 */
	public void uncheckAll() {
		cb_select_all.setSelected(false);
		for(JCheckBox check_box : liste_checkbox) {
			check_box.setSelected(false);
		}
	}
	
	
	/**
	 * Methode qui va cocher toutes les check box dans le select
	 */
	public void checkAll() {
		for(JCheckBox check_box : liste_checkbox) {
			check_box.setSelected(true);
		}
	}
	
	
	/**
	 * @return La JCheckBox select all
	 */
	public JCheckBox getCb_select_all() {
		return cb_select_all;
	}
	

}














