package listeners;

import interface_plugin.PluginLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import util.Langage;


/**
 * Classe qui implémente les actions à réaliser lors d'un clic
 * sur le bouton clear
 * @author Mallory Marcot
 *
 */
public class AuditeurBoutonClear implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		// on récupère :
		JButton but_src = (JButton) e.getSource();
		PluginLayout plug_lay = (PluginLayout) but_src.getParent().getParent().getParent().getParent();
		
		if( JOptionPane.showConfirmDialog(plug_lay, Langage.getReq_clear_message_dialog(), Langage.getAttention(), JOptionPane.YES_NO_CANCEL_OPTION) == JOptionPane.YES_OPTION ) {		
			// on nettoye tout :
			plug_lay.getSelect().uncheckAll();
			plug_lay.getFrom().recommencer();
			plug_lay.getWhere().toutEnlever();
			plug_lay.getRequete().setTexteRequete(null);
		}
	}
	
}
