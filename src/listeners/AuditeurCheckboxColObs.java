package listeners;

import interface_plugin.Select;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


/**
 * Classe qui définit les actions à réaliser lorque l'utilisateur 
 * clique sur une JCheckBox de colonne obscore
 * @author Mallory Marcot
 *
 */
public class AuditeurCheckboxColObs implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		JCheckBox cb_src = (JCheckBox) e.getSource();
		Select pan_select = (Select) cb_src.getParent();
		
		pan_select.getCb_select_all().setSelected(false);
	}

}
