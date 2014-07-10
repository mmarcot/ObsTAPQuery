package listeners;

import interface_plugin.PanneauConfServeur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.*;

import util.Configuration;


/**
 * Classe qui détermine les actions à réaliser lors d'un clic
 * sur le bouton OK de la configuration du serveur
 * @author Mallory Marcot
 *
 */
public class AuditeurBoutonOkConfServeur implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton but_src = (JButton) e.getSource();
		PanneauConfServeur pan_conf = (PanneauConfServeur) but_src.getParent().getParent();
		
		// recup l'ArrayList contenant les champs texte de conf :
		ArrayList<String> ls_conf_serv = pan_conf.getLs_conf_serv();
		
		// affectation dans la configuration :
		for(int i=0; i<Configuration.TAB_NOM_CHAMPS_CONF_SERVEUR.length; i++) {
			String value = ls_conf_serv.get(i);
			Configuration.TAB_CONTENU_CHAMPS_CONF_SERVEUR[i] = value;
		}
		
		for( String s : Configuration.TAB_CONTENU_CHAMPS_CONF_SERVEUR)
			System.out.println(s);
		
		((JFrame) but_src.getParent().getParent().getParent().getParent().getParent()).dispose();
	}

}
