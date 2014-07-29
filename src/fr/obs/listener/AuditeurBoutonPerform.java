package fr.obs.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.swing.*;

import cds.aladin.Aladin;
import fr.obs.util.Configuration;
import fr.obs.util.Langage;
import fr.obs.view.PluginLayout;
import fr.obs.view.Requete;


/**
 * Classe qui détermine les actions à réaliser lors du clic sur le 
 * bouton 'Perform query'
 * @author Mallory Marcot
 *
 */
public class AuditeurBoutonPerform implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton but_src = (JButton) e.getSource();
		Requete pan_req = (Requete)but_src.getParent().getParent();
		PluginLayout plug_lay = (PluginLayout) pan_req.getParent().getParent();
		
		if(plug_lay.avecAladin()) {
			// on encode la requete pour la passer dans l'url :
			String requete = "";
			try {
				requete = URLEncoder.encode(pan_req.getTexte(), "UTF-8");
			} catch (UnsupportedEncodingException e1) {
				JOptionPane.showMessageDialog(plug_lay, e1.getMessage(), Langage.getErreur(), JOptionPane.ERROR_MESSAGE);
			}
			
			// on exécute et affiche le résultat de la requete (VOTable) dans Aladin :
			String commande_aladin = "get File(" + Configuration.URL_SERVICE_TAP + "/sync?REQUEST=doQuery&LANG=ADQL&QUERY="+ requete + ")";
			Aladin aladin = plug_lay.getAladin();
			aladin.execCommand(commande_aladin);
		}
		else {
			// erreur :
			JOptionPane.showMessageDialog(plug_lay, Langage.getReq_perform_message_dialog_err(), Langage.getErreur(), JOptionPane.ERROR_MESSAGE);
		}

	}
	
}

















