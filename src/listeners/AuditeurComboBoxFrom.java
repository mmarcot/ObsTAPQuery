package listeners;

import interface_plugin.PluginLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


/**
 * Classe auditrice qui implémente les actions à réaliser lors de la
 * selection d'une nouvelle table dans le from
 * @author Mallory Marcot
 *
 */
public class AuditeurComboBoxFrom implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		JComboBox combo_src = (JComboBox) e.getSource();
		PluginLayout plug_lay = (PluginLayout) combo_src.getParent().getParent().getParent();
	}

}
