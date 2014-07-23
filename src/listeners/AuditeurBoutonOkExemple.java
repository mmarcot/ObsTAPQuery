package listeners;

import interface_plugin.PluginLayout;

import java.awt.event.*;

import javax.swing.*;


/**
 * Classe qui implémente les actions à réaliser lors d'un clic souris sur le bouton OK
 * de la fenetre d'exemple
 * @author Mallory Marcot
 *
 */
public class AuditeurBoutonOkExemple implements ActionListener{
	
	private PluginLayout plug_lay;

	
	/**
	 * Constructeur de l'auditeur
	 * @param plug_lay Référence au PluginLayout
	 */
	public AuditeurBoutonOkExemple(PluginLayout plug_lay) {
		this.plug_lay = plug_lay;
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton but_src = (JButton) e.getSource();
		
		//TODO completer
		
		// on ferme la fenetre :
		((JFrame)but_src.getParent().getParent().getParent().getParent().getParent()).dispose();
	}

}















