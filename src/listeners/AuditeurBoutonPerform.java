package listeners;

import interface_plugin.PluginLayout;
import interface_plugin.Requete;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.swing.*;

import util.Langage;

import cds.aladin.Aladin;


/**
 * Classe qui détermine les actions à réaliser lors du clic sur le 
 * bouton 'Générer'
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
				JOptionPane.showMessageDialog(plug_lay, e1.getMessage(), Langage.getReq_perform_titre_dialog(), JOptionPane.ERROR_MESSAGE);
			}
			
			// on exécute et affiche le résultat de la requete (VOTable) dans Aladin :
			String commande_aladin = "get File(http://obs-stage-s4.u-strasbg.fr:8088/VizieR/tap/sync?REQUEST=doQuery&LANG=ADQL&QUERY="+ requete + ")";
			Aladin aladin = plug_lay.getAladin();
			aladin.execCommand(commande_aladin);
		}
		else {
			// erreur :
			JOptionPane.showMessageDialog(plug_lay, Langage.getReq_perform_message_dialog_err(), Langage.getReq_perform_titre_dialog(), JOptionPane.ERROR_MESSAGE);
		}

	}
	
}

















