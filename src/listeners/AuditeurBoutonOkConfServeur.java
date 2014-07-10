package listeners;

import interface_plugin.PanneauConfServeur;
import interface_plugin.PluginLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.security.auth.callback.ConfirmationCallback;
import javax.swing.*;

import metier.GestionnaireDeTables;

import util.Configuration;


/**
 * Classe qui détermine les actions à réaliser lors d'un clic
 * sur le bouton OK de la configuration du serveur
 * @author Mallory Marcot
 *
 */
public class AuditeurBoutonOkConfServeur implements ActionListener {

	private PanneauConfServeur pan_conf;
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton but_src = (JButton) e.getSource();
		pan_conf = (PanneauConfServeur) but_src.getParent().getParent();
		
		// recup l'ArrayList contenant les champs texte de conf :
		ArrayList<String> ls_conf_serv = pan_conf.getLs_conf_serv();
		
		// affectation dans la configuration :
		Configuration.URL_SERVICE_TAP = ls_conf_serv.get(0);
		Configuration.URL_BDD = ls_conf_serv.get(1);
		Configuration.USER_BDD = ls_conf_serv.get(2);
		Configuration.MOT_DE_PASSE_BDD= ls_conf_serv.get(3);
		
		mettreAJour();
		
		((JFrame) but_src.getParent().getParent().getParent().getParent().getParent()).dispose();
	}
	
	
	/**
	 * Permet de tout nettoyer et de mettre à jour les colonnes 
	 */
	private void mettreAJour() {
		GestionnaireDeTables.changerTableSelectionnee(Configuration.TABLE_PAR_DEFAULT);
		
		PluginLayout plug_lay = pan_conf.getPlug_lay();
		
		// on nettoye tout :
		plug_lay.getSelect().uncheckAll();
		plug_lay.getFrom().recommencer();
		plug_lay.getWhere().toutEnlever();
		plug_lay.getRequete().setTexteRequete(null);
		
		// on met à jour :
		plug_lay.getSelect().mettreAJourColonnes();
		plug_lay.getWhere().getGestionnaire().mettreAJourColonnes();
	}

}
