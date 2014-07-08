package interface_plugin;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

import util.Configuration;
import util.Langage;
import listeners.AuditeurCheckSelectAll;
import listeners.AuditeurCheckboxColObs;
import metier.GestionnaireDeTables;
import metier.UnChamps;


/**
 * Classe JPanel qui représente le select (vue) à gauche
 * @author Mallory Marcot
 *
 */
public class Select extends JPanel {
	
	private ArrayList<JCheckBox> liste_checkbox;
	private JCheckBox cb_select_all;
	private String nom_table;
	
	
	/**
	 * Constructeur de la vue sur le select
	 * @param nom_table nom de la table voulue
	 */
	public Select(String nom_table) {
		this.liste_checkbox = new ArrayList<JCheckBox>();
		this.nom_table = nom_table;
		this.cb_select_all = new JCheckBox(Langage.getSelect_all());
		
		cb_select_all.addActionListener(new AuditeurCheckSelectAll());
		add(cb_select_all);
		
		// JLabel separateur :
		add(new JLabel(" "));
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		afficherColonnes();
	}
	
	
	
	/**
	 * Methode qui permet de mettre à jour dynamiquement le select en fonction de
	 * la selection dans le from
	 */
	public void mettreAJourColonnes() {
		supprimerColonnes();
		afficherColonnes();
		
		revalidate();
	}
	
	
	/**
	 * Methode qui va charger et afficher les champs obscore dans le select
	 */
	private void afficherColonnes() {
		ArrayList<UnChamps> liste_col_str = GestionnaireDeTables.getColonnes();
		
		// on transforme les String récupéré en JCheckBox et les ajoute
		// au JPanel select :
		for(UnChamps champs : liste_col_str) {
			JCheckBox cb = new JCheckBox(champs.getName());
			cb.addActionListener(new AuditeurCheckboxColObs());
			this.liste_checkbox.add(cb);
			this.add(cb);
		}
	}
	
	
	/**
	 * Permet de supprimer toutes les colonnes dans le select
	 */
	private void supprimerColonnes() {
		for(JCheckBox cb : liste_checkbox) {
			remove(cb);
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














