package listeners;

import interface_plugin.LigneDeContrainte;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * Classe auditrice de la JComboBox permettant de choisir l'opérateur
 * @author Mallory Marcot
 */
public class AuditeurOperateurs implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		JComboBox combo_source = (JComboBox)e.getSource();
		LigneDeContrainte ligne_source = (LigneDeContrainte)combo_source.getParent();
		
		// on met la composition qu'il faut en fonction de la valeur de la combobox :
		if( combo_source.getSelectedItem().equals("BETWEEN") && ligne_source.isBetweenCompo() == false ) {
			ligne_source.toBetweenComposition();
		}
		else if( combo_source.getSelectedItem().equals("BETWEEN") == false && ligne_source.isBetweenCompo() == true ) {
			ligne_source.toRegularComposition();
		}
	}

}
