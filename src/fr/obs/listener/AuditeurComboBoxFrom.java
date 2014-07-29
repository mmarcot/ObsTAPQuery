package fr.obs.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import fr.obs.model.GestionnaireDeTables;
import fr.obs.util.Langage;
import fr.obs.view.PluginLayout;


/**
 * Classe auditrice qui implémente les actions à réaliser lors de la
 * selection d'une nouvelle table dans le from
 * @author Mallory Marcot
 *
 */
public class AuditeurComboBoxFrom implements ActionListener{
	
	private JComboBox combo_src;
	private PluginLayout plug_lay;

	
	@Override
	public void actionPerformed(ActionEvent e) {
		combo_src = (JComboBox) e.getSource();
		plug_lay = (PluginLayout) combo_src.getParent().getParent().getParent();
		
		// on détermine quand est-ce qu'il faut demander confirmation (car cela va tout effacer) :
		boolean demander_confirmation = false;
		if(plug_lay.getWhere().getGestionnaire().getComponentCount() >= 2)
			demander_confirmation = true;
		
		if(demander_confirmation) {
			if( JOptionPane.showConfirmDialog(plug_lay, Langage.getReq_changer_table_message_dialog(), Langage.getAttention(), JOptionPane.YES_NO_CANCEL_OPTION) == JOptionPane.YES_OPTION) {
				mettreAJour();
			}
			else { // on remet la JComboBox sur l'item précédent :
				String table_prec = GestionnaireDeTables.getTableSelectionnee();
				combo_src.setSelectedItem(table_prec);
			}
		}
		else { // pas de confirmation
			mettreAJour();
		}
	}

	
	/**
	 * Permet de tout nettoyer et de mettre à jour les colonnes 
	 */
	private void mettreAJour() {
		GestionnaireDeTables.changerTableSelectionnee((String) combo_src.getSelectedItem());
		
		plug_lay.mettreAJour(false);
	}
	

}



















