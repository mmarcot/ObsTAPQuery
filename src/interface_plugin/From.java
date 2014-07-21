package interface_plugin;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

import listeners.AuditeurComboBoxFrom;
import metier.GestionnaireDeTables;
import metier.UnChamps;

import util.Configuration;


/**
 * Classe qui modélise un panneau From (vue)
 * @author Mallory Marcot
 *
 */
public class From extends JPanel {
	
	private JComboBox combo_tables;

	
	/**
	 * Constructeur du panneau From (vue)
	 */
	public From() {
		setPreferredSize(new Dimension(Configuration.LARGEUR_FROM_PX, Configuration.HAUTEUR_FROM_PX));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		add(new JLabel(" ")); // espacement
		
		// JLabel "From" :
		JLabel lab_from = new JLabel("From");
		lab_from.setAlignmentX(CENTER_ALIGNMENT);
		Font pol_select = new Font(Configuration.POLICE, Font.BOLD, 20);
		lab_from.setFont(pol_select);
		add(lab_from);
		
		// JComboBox liste de tables :
		combo_tables = new JComboBox();
		combo_tables.setAlignmentX(CENTER_ALIGNMENT);
		chargerComboBox();
		combo_tables.addActionListener(new AuditeurComboBoxFrom());
		add(combo_tables);
		
		// espacement :
		add(new JLabel(" "));
		add(new JLabel(" "));
	}
	
	
	/**
	 * Methode qui permet de remet la table par défault
	 */
	public void mettreAJour() {
		combo_tables.setSelectedItem(Configuration.TABLE_PAR_DEFAULT);
		viderComboBox();
		chargerComboBox();
	}
	
	
	/**
	 * Permet de vider la combo box contenant la liste de tables
	 */
	private void viderComboBox() {
		combo_tables.removeAllItems();
	}
	
	
	/**
	 * Permet de charger la combo box contenant la liste de tables
	 */
	private void chargerComboBox() {
		ComboboxToolTipRenderer renderer = new ComboboxToolTipRenderer();
		combo_tables.setRenderer(renderer);
		ArrayList<String> liste_tables = GestionnaireDeTables.getListe_tables(true);
		ArrayList<String> tooltips = new ArrayList<String>();
		for(String table : liste_tables) {
			combo_tables.addItem(table);
			tooltips.add(table);
		}
		renderer.setTooltips(tooltips);
		combo_tables.setSelectedItem(Configuration.TABLE_PAR_DEFAULT);
	}
	
	
	/**
	 * @return La table selectionnée dans la JComboBox
	 */
	public String getSelectedTable() {
		return (String) combo_tables.getSelectedItem();
	}
	
	
}













