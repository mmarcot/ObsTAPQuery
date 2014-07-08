package interface_plugin;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

import listeners.AuditeurComboBoxFrom;
import metier.GestionnaireDeTables;

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
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		add(new JLabel(" ")); // espacement
		
		// JLabel "Select" :
		JLabel lab_from = new JLabel("From");
		lab_from.setAlignmentX(CENTER_ALIGNMENT);
		Font pol_select = new Font(Configuration.POLICE, Font.BOLD, 20);
		lab_from.setFont(pol_select);
		add(lab_from);
		
		// JComboBox liste de tables :
		combo_tables = new JComboBox();
		combo_tables.setAlignmentX(CENTER_ALIGNMENT);
		ArrayList<String> liste_tables = GestionnaireDeTables.getListe_tables();
		for(String table : liste_tables) {
			combo_tables.addItem(table);
		}
		combo_tables.setSelectedItem(Configuration.TABLE_PAR_DEFAULT);
		combo_tables.addActionListener(new AuditeurComboBoxFrom());
		add(combo_tables);
		
		// espacement :
		add(new JLabel(" "));
		add(new JLabel(" "));
	}
	
	
	/**
	 * Methode qui permet de remettre la selection par défault
	 */
	public void recommencer() {
		combo_tables.setSelectedItem(Configuration.TABLE_PAR_DEFAULT);
	}
	
	
	/**
	 * @return La table selectionnée dans la JComboBox
	 */
	public String getSelectedTable() {
		return (String) combo_tables.getSelectedItem();
	}
	
}













