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
		LigneDeContrainte ligne_src = (LigneDeContrainte)combo_source.getParent();
		String item = (String) combo_source.getSelectedItem();
		
		// on met la composition qu'il faut en fonction de la valeur de la combobox :
		if( (item.equals("BETWEEN") || item.equals("NOT BETW")) && ligne_src.isBetweenCompo() == false ) {
			ligne_src.toBetweenComposition();
		}
		else if( (item.equals("BETWEEN") || item.equals("NOT BETW")) == false && ligne_src.isBetweenCompo() == true ) {
			ligne_src.toRegularComposition();
		}

	}

}
