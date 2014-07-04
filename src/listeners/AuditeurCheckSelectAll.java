package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import interface_plugin.Select;

import javax.swing.*;


/**
 * Classe qui implémente les actions à réaliser lorsque l'utilisateur 
 * coche ou décoche la checkbox select all
 * @author Mallory Marcot
 *
 */
public class AuditeurCheckSelectAll implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		JCheckBox cb_src = (JCheckBox) e.getSource();
		Select pan_select = (Select) cb_src.getParent();
		
		if(cb_src.isSelected()) 
			pan_select.checkAll();
		else 
			pan_select.uncheckAll();
	}

}
